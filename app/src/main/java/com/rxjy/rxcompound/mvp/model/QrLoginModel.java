package com.rxjy.rxcompound.mvp.model;



import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.mvp.contract.QrLoginContract;
import com.rxjy.rxcompound.rx.RxSchedulers;

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
