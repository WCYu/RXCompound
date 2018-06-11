package com.rxjy.rxcompound.mvp.model;

import android.util.Log;

import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.mvp.contract.BaseInformContract;
import com.rxjy.rxcompound.rx.RxSchedulers;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import rx.Observable;

/**
 * Created by hjh on 2017/11/10.
 */

public class BaseInformModel implements BaseInformContract.Model{

    @Override
    public Observable<String> getDesMessage(String cardNo) {
        return ApiEngine.getInstance().getRsApiService()
                .getMessageDes(cardNo)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getIsConsent(String CardNo, String Type) {
        return ApiEngine.getInstance().getRsApiService()
                .getIsConsent(CardNo,Type)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getMessage(String Phone, String Type) {
        return ApiEngine.getInstance().getRsApiService()
                .getMessage(Phone,Type)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getUpdateMessages(String Phone, String Type, String IdCardName, String IdCard, String IdCardAddress, String NowAddress, String Birthday,String Marrary) {
        return ApiEngine.getInstance().getRsApiService()
                .getUpdateMessages(Phone,Type,IdCardName,IdCard,IdCardAddress,NowAddress,Birthday,Marrary)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getUpdateMessage(String Phone, String Type, String BankName, String BankCard, String BankUserName, String UrgentPerson, String UrgentContact, String UrgentPhone) {
        return ApiEngine.getInstance().getRsApiService()
                .getUpdateMessage(Phone,Type,BankName,BankCard,BankUserName,UrgentPerson,UrgentContact,UrgentPhone)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getUpdateMessage(String CardNo, String Type, String Name, String Sex, String Phone) {
        return ApiEngine.getInstance().getRsApiService()
                .getUpdateMessage(CardNo,Type,Name,Sex,Phone)
                .compose(RxSchedulers.<String>switchThread());
    }


    @Override
    public Observable<String> getBankList() {
        return  ApiEngine.getInstance().getRsApiService()
                .getBankList()
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> upLoadImg(String cardNo, String type, List<String> imglist) {
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
                .subImage(cardNo, type, list)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> upLoadIcon(String cardNo, String imglist) {
        //将照片路径转换为File对象
        File file = new File(imglist);
        //创建RequestBody ,用于Retrofit2.0上传照片
        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        // MultipartBody.Part  和后端约定好Key，这里的partName是用image
        MultipartBody.Part body = MultipartBody.Part.createFormData("file_stream", file.getName(), requestFile);

        return ApiEngine.getInstance().getRsApiService()
                .upIcon( cardNo, body)
                .compose(RxSchedulers.<String>switchThread());
    }
    @Override
    public Observable<String> getUserStatus(String cardNo) {
        return ApiEngine.getInstance().getRsApiService()
                .getUserStatus(cardNo)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getMsgnum(String cardNo) {
        return ApiEngine.getInstance().getRsApiService()
                .getMsgnum(cardNo)
                .compose(RxSchedulers.<String>switchThread());
    }
}
