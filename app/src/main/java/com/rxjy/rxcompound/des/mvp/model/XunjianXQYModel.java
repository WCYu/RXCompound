package com.rxjy.rxcompound.des.mvp.model;

import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.des.mvp.contract.XunjianXQYContract;
import com.rxjy.rxcompound.rx.RxSchedulers;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import rx.Observable;

/**
 * Created by Administrator on 2017/10/24.
 */

public class XunjianXQYModel implements XunjianXQYContract.Model {
    @Override
    public Observable<String> GetScheduleCheckIno(String sc_id) {
        return ApiEngine.getInstance().getDesApiService()
                .GetScheduleCheckIno(sc_id)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> SubmitCheckDes(String sc_id, String description, String address) {
        return ApiEngine.getInstance().getDesApiService()
                .SubmitCheckDes(sc_id,description,address)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> UploadCheckImages(String sc_Id, List<String> imgList) {

        List<MultipartBody.Part> list = new ArrayList<>();

        for (String url : imgList)
        {
            //将照片路径转换为File对象
            File file = new File(url);
            //创建RequestBody ,用于Retrofit2.0上传照片
            RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
            // MultipartBody.Part  和后端约定好Key，这里的partName是用image
            MultipartBody.Part body =
                    MultipartBody.Part.createFormData("file_stream", file.getName(), requestFile);
            list.add(body);
        }


        return ApiEngine.getInstance().getDesApiService()
                .UploadCheckImages(sc_Id,list)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> DeleteloadCheckImages(String sc_Id, String fileName) {
        return ApiEngine.getInstance().getDesApiService()
                .DeleteloadCheckImages(sc_Id,fileName)
                .compose(RxSchedulers.<String>switchThread());
    }
}
