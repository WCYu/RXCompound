package com.rxjy.rxcompound.mvp.model;

import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.mvp.contract.AgreeDesContract;
import com.rxjy.rxcompound.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by hjh on 2018/4/21.
 */

public class AgreeDesModel implements AgreeDesContract.Model{
    @Override
    public Observable<String> getAgreeYes(String cardno, String type) {
        return ApiEngine.getInstance().getRsApiService()
                .getAgreeYes(cardno, type)
                .compose(RxSchedulers.<String>switchThread());
    }
}
