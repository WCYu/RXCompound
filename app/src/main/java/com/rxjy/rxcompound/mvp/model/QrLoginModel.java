package com.example.asus.customer.mvp.model;

import com.example.asus.customer.api.ApiEngine;
import com.example.asus.customer.mvp.contract.QrLoginContract;
import com.example.asus.customer.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by asus on 2018/5/30.
 */

public class QrLoginModel implements QrLoginContract.Model {
    @Override
    public Observable<String> getRrLogin(String cardNo, String password, String loginId) {
        return ApiEngine.getInstance().getRsApiService()
                .getEWMLogin(cardNo,password,loginId)
                .compose(RxSchedulers.<String>switchThread());
    }
}
