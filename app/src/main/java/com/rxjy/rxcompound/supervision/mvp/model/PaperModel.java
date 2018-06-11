package com.rxjy.rxcompound.supervision.mvp.model;

import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.rx.RxSchedulers;
import com.rxjy.rxcompound.supervision.mvp.contract.PaperContract;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import rx.Observable;

/**
 * Created by AAA on 2017/12/21.
 */

public class PaperModel implements PaperContract.Model {
    @Override
    public Observable<String> getPaperInfo(String orderNo) {
        return ApiEngine.getInstance().getGcApiService()
                .getDatumInfo(2, orderNo)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> uploadPaperInfo(String orderNo, int category, int attrId, int orderID, String url) {

        //将照片路径转换为File对象
        File file = new File(url);
        //创建RequestBody ,用于Retrofit2.0上传照片
        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        // MultipartBody.Part  和后端约定好Key，这里的partName是用image
        MultipartBody.Part body =
                MultipartBody.Part.createFormData("file_stream", file.getName(), requestFile);

        return ApiEngine.getInstance().getGcApiService()
                .uploadPaperInfo(orderNo, category, attrId, orderID, body)
                .compose(RxSchedulers.<String>switchThread());
    }
}
