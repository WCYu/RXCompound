package com.rxjy.rxcompound.supervision.mvp.model;

import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.rx.RxSchedulers;
import com.rxjy.rxcompound.supervision.mvp.contract.ElectronicContract;

import rx.Observable;

/**
 * Created by AAA on 2017/12/21.
 */

public class ElectronicModel implements ElectronicContract.Model {
    @Override
    public Observable<String> getPaperInfo(String orderNo) {
        return ApiEngine.getInstance().getGcApiService()
                .getDatumInfo(1, orderNo)
                .compose(RxSchedulers.<String>switchThread());
    }
}
