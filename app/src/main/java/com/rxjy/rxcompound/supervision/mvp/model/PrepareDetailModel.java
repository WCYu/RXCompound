package com.rxjy.rxcompound.supervision.mvp.model;
import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.rx.RxSchedulers;
import com.rxjy.rxcompound.supervision.mvp.contract.PrepareDetailContract;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import rx.Observable;

/**
 * Created by AAA on 2017/11/6.
 */

public class PrepareDetailModel implements PrepareDetailContract.Model {

    @Override
    public Observable<String> getProcessDetail(int processID) {
        return ApiEngine.getInstance().getGcApiService()
                .getProcessDetail(processID, 2)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> subProcessDetailPhoto(int stepID, int processID, int stepPhotoID, String url) {
        //将照片路径转换为File对象
        File file = new File(url);
        //创建RequestBody ,用于Retrofit2.0上传照片
        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        // MultipartBody.Part  和后端约定好Key，这里的partName是用image
        MultipartBody.Part body =
                MultipartBody.Part.createFormData("file_stream", file.getName(), requestFile);

        return ApiEngine.getInstance().getGcApiService()
                .subProcessPhoto(stepID, processID, stepPhotoID, 2, body)
                .compose(RxSchedulers.<String>switchThread());
    }

}
