package com.rxjy.rxcompound.supervision.mvp.model;

import com.luck.picture.lib.entity.LocalMedia;
import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.rx.RxSchedulers;
import com.rxjy.rxcompound.supervision.mvp.contract.AttachmentContract;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import rx.Observable;

/**
 * Created by AAA on 2017/12/25.
 */

public class AttachmentModel implements AttachmentContract.Model {
    @Override
    public Observable<String> getAttachmentTypeInfo() {
        return ApiEngine.getInstance().getGcApiService()
                .getAttachmentTypeInfo()
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> subAttachmentInfo(String orderNo, String dayCount, int modelId, List<LocalMedia> imgList) {

        List<MultipartBody.Part> list = new ArrayList<>();

        for (LocalMedia url : imgList) {
            //将照片路径转换为File对象
            File file = new File(url.getPath());
            //创建RequestBody ,用于Retrofit2.0上传照片
            RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
            // MultipartBody.Part  和后端约定好Key，这里的partName是用image
            MultipartBody.Part body =
                    MultipartBody.Part.createFormData("file_stream", file.getName(), requestFile);
            list.add(body);
        }

        return ApiEngine.getInstance().getGcApiService()
                .subAttachmentInfo(orderNo, dayCount, modelId, list)
                .compose(RxSchedulers.<String>switchThread());
    }
}
