package com.rxjy.rxcompound.supervision.mvp.model;

import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.rx.RxSchedulers;
import com.rxjy.rxcompound.supervision.mvp.contract.ProListContract;

import rx.Observable;

/**
 * Created by AAA on 2017/12/15.
 */

public class ProListModel implements ProListContract.Model {
    @Override
    public Observable<String> getProList(String orderNo) {
        return ApiEngine.getInstance().getGcApiService()
                .getProList(orderNo)
                .compose(RxSchedulers.<String>switchThread());
    }
}
