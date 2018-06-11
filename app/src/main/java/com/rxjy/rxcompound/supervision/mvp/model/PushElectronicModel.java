package com.rxjy.rxcompound.supervision.mvp.model;
import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.rx.RxSchedulers;
import com.rxjy.rxcompound.supervision.mvp.contract.PushElectronicContract;

import rx.Observable;

/**
 * Created by AAA on 2017/12/21.
 */

public class PushElectronicModel implements PushElectronicContract.Model {
    @Override
    public Observable<String> getPaperInfo(String orderNo, int attrId) {
        return ApiEngine.getInstance().getGcApiService()
                .getPushElectronicInfo(orderNo, attrId)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> saveElectronicInfo(String orderNo, int attrId, int eleId, String content) {
        return ApiEngine.getInstance().getGcApiService()
                .saveElectronicInfo(orderNo, attrId, eleId, content)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> savePushElectronicInfo(String orderNo, int attrId) {
        return ApiEngine.getInstance().getGcApiService()
                .savePushElectronicInfo(orderNo, attrId)
                .compose(RxSchedulers.<String>switchThread());
    }
}
