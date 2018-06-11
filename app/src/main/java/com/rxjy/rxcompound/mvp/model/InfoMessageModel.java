package com.rxjy.rxcompound.mvp.model;

import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.mvp.contract.InfoMessageContract;
import com.rxjy.rxcompound.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by hjh on 2017/11/22.
 */

public class InfoMessageModel implements InfoMessageContract.Model{
    @Override
    public Observable<String> getInfoMessageList(String cardNo) {
        return ApiEngine.getInstance().getRsApiService()
                .getInformMessage(cardNo)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> toSeeDetails(String id) {
        return ApiEngine.getInstance().getRsApiService()
                .getToSeeDetails(id)
                .compose(RxSchedulers.<String>switchThread());
    }
}
