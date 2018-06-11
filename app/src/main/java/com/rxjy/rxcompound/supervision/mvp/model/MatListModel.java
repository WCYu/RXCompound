package com.rxjy.rxcompound.supervision.mvp.model;
import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.rx.RxSchedulers;
import com.rxjy.rxcompound.supervision.mvp.contract.MatListContract;

import rx.Observable;

/**
 * Created by AAA on 2017/12/13.
 */

public class MatListModel implements MatListContract.Model {
    @Override
    public Observable<String> getMatList(String orderNo) {
        return ApiEngine.getInstance().getGcApiService()
                .getMatList(orderNo)
                .compose(RxSchedulers.<String>switchThread());
    }
}
