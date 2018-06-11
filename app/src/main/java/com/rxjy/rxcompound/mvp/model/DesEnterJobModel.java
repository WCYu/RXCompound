package com.rxjy.rxcompound.mvp.model;

import android.util.Log;

import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.mvp.contract.DesEnterJobContract;
import com.rxjy.rxcompound.rx.RxSchedulers;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import rx.Observable;

/**
 * Created by hjh on 2018/4/21.
 */

public class DesEnterJobModel implements DesEnterJobContract.Model{
    @Override
    public Observable<String> updateDesJobMessage(String card_no, String Type, String bank_name, String bank_card, String bank_user_name, int bank_user_branch) {
        return ApiEngine.getInstance().getRsApiService()
                .getUpdateDesJobMessage(card_no, Type, bank_name, bank_card, bank_user_name,bank_user_branch)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> upLoadDesIdentityImg(String cardNo, String type, List<String> imglist) {
        List<MultipartBody.Part> list = new ArrayList<>();
        Log.e("用来上传的图片：",imglist.toString());

        for (String url : imglist)
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

        return ApiEngine.getInstance().getRsApiService()
                .subDesImage(cardNo,type,list)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getBankList() {
        return  ApiEngine.getInstance().getRsApiService()
                .getBankList()
                .compose(RxSchedulers.<String>switchThread());
    }
}