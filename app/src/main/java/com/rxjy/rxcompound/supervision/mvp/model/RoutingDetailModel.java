package com.rxjy.rxcompound.supervision.mvp.model;


import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.rx.RxSchedulers;
import com.rxjy.rxcompound.supervision.mvp.contract.RoutingDetailContract;

import rx.Observable;

/**
 * Created by AAA on 2018/1/17.
 */

public class RoutingDetailModel implements RoutingDetailContract.Model {
    @Override
    public Observable<String> getRoutingDetail(String orderNo, int xjID) {
        return ApiEngine.getInstance().getGcApiService()
                .getRoutingDetail(orderNo, xjID)
                .compose(RxSchedulers.<String>switchThread());
    }
}
