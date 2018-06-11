package com.rxjy.rxcompound.des.mvp.model;


import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.des.mvp.contract.MyCameraContract;
import com.rxjy.rxcompound.rx.RxSchedulers;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import rx.Observable;

/**
 * Created by Administrator on 2017/8/16.
 */

public class MyCameraModel implements MyCameraContract.Model {
    @Override
    public Observable<String> getCameraType(String rwdId) {
        return ApiEngine.getInstance().getDesApiService()
                .getCameraType(rwdId)
                .compose(RxSchedulers.<String>switchThread());
    }
    @Override
    public Observable<String> subImage2(int worksID, String catalogID, int userID, List<String> imgList)
    {

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
                .subImage2(worksID, catalogID, userID, list)
                .compose(RxSchedulers.<String>switchThread());
    }

}
