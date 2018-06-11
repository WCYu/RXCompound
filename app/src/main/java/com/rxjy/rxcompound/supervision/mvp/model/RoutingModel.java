package com.rxjy.rxcompound.supervision.mvp.model;


import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.rx.RxSchedulers;
import com.rxjy.rxcompound.supervision.mvp.contract.RoutingContract;

import rx.Observable;

/**
 * Created by AAA on 2017/11/3.
 */

public class RoutingModel implements RoutingContract.Model {
    @Override
    public Observable<String> getRoutingList(String orderNo) {
        return ApiEngine.getInstance().getGcApiService()
                .getRoutingList(orderNo, 2)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getRoutingState(String orderNo) {
        return ApiEngine.getInstance().getGcApiService()
                .getRoutingState(orderNo, 2)
                .compose(RxSchedulers.<String>switchThread());
    }
}
