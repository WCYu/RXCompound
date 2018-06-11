package com.rxjy.rxcompound.mvp.model;


import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.mvp.contract.LoginContract;
import com.rxjy.rxcompound.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by hjh on 2017/7/27.
 */
public class LoginModel implements LoginContract.Model {
    @Override
    public Observable<String> getCheckIsVerity(String cardNo) {
        return ApiEngine.getInstance().getRsApiService()
                .getCheckIsVerity(cardNo)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getVerityCode(String cardNo) {
        return ApiEngine.getInstance().getRsApiService()
                .getVerityCode(cardNo)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> tologin(String cardNo, String verityCode, String pwd) {
        return ApiEngine.getInstance().getRsApiService()
                .getLogin(cardNo,verityCode,pwd)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getIsConsent(String cardNo, String Type) {
        return ApiEngine.getInstance().getRsApiService()
                .getIsConsent(cardNo,Type)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getUserStatus(String cardNo) {
        return ApiEngine.getInstance().getRsApiService()
                .getUserStatus(cardNo)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getIsPrefect(String Phone, String Type) {
        return ApiEngine.getInstance().getRsApiService()
                .getMessage(Phone,Type)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getLoginTz(String cardno, String data) {
        return ApiEngine.getInstance().geTzApiService()
                .getLoginTz(cardno,data)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getCheckToken(String CardNo, String Token) {

        return ApiEngine.getInstance().getRsApiService()
                .getCheckToken(CardNo,Token)
                .compose(RxSchedulers.<String>switchThread());
    }

}
