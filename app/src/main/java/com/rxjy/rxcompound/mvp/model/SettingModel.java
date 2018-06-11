package com.rxjy.rxcompound.mvp.model;

import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.mvp.contract.SettingContract;
import com.rxjy.rxcompound.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by hjh on 2017/11/20.
 */

public class SettingModel implements SettingContract.Model{
    @Override
    public Observable<String> getConsent(String cardNo) {
        return ApiEngine.getInstance().getRsApiService()
                .xiaxian(cardNo)
                .compose(RxSchedulers.<String>switchThread());
    }
}
