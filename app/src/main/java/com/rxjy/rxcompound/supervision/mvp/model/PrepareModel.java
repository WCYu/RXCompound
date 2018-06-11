package com.rxjy.rxcompound.supervision.mvp.model;

import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.rx.RxSchedulers;
import com.rxjy.rxcompound.supervision.mvp.contract.PrepareContract;

import rx.Observable;

/**
 * Created by AAA on 2017/11/6.
 */

public class PrepareModel implements PrepareContract.Model {
    @Override
    public Observable<String> getProjectProcess(String orderNo) {
        return ApiEngine.getInstance().getGcApiService()
                .getProjectProcess(orderNo, 2, 0)
                .compose(RxSchedulers.<String>switchThread());
    }
}
