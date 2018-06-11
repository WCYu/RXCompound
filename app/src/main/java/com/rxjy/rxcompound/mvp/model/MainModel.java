package com.rxjy.rxcompound.mvp.model;

import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.mvp.contract.MainContract;
import com.rxjy.rxcompound.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by Administrator on 2017/12/1.
 */

public class MainModel implements MainContract.Model {
    @Override
    public Observable<String> getVersionInfo(int version) {
        return ApiEngine.getInstance().getRsApiService()
                .getVCode(version)
                .compose(RxSchedulers.<String>switchThread());
    }
}
