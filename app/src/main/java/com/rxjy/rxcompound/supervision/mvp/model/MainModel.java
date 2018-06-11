package com.rxjy.rxcompound.supervision.mvp.model;


import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.rx.RxSchedulers;
import com.rxjy.rxcompound.supervision.mvp.contract.MainContract;

import rx.Observable;

/**
 * Created by AAA on 2018/1/18.
 */

public class MainModel implements MainContract.Model {
    @Override
    public Observable<String> getVersionInfo() {
        return ApiEngine.getInstance().getGcApiService()
                .getVersionInfo()
                .compose(RxSchedulers.<String>switchThread());
    }
}
