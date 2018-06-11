package com.rxjy.rxcompound.mvp.model;

import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.mvp.contract.BackVisitContract;
import com.rxjy.rxcompound.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by hjh on 2018/4/4.
 */

public class BackVisitModel implements BackVisitContract.Model{
    @Override
    public Observable<String> addHuiFangData(String rwdId, String content, int methods) {
        return ApiEngine.getInstance().getDesApiService()
                .addHuiFangData(rwdId, content, methods)
                .compose(RxSchedulers.<String>switchThread());
    }
}
