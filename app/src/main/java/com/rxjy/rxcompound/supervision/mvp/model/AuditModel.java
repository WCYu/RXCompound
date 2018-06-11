package com.rxjy.rxcompound.supervision.mvp.model;

import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.rx.RxSchedulers;
import com.rxjy.rxcompound.supervision.mvp.contract.AuditContract;

import rx.Observable;

/**
 * Created by AAA on 2017/12/13.
 */

public class AuditModel implements AuditContract.Model {
    @Override
    public Observable<String> getAuditList(String orderNo, int pageIndex, int pageSize) {
        return ApiEngine.getInstance().getGcApiService()
                .getAudit(orderNo, pageIndex, pageSize)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getAuditListLoadMore(String orderNo, int pageIndex, int pageSize) {
        return ApiEngine.getInstance().getGcApiService()
                .getAudit(orderNo, pageIndex, pageSize)
                .compose(RxSchedulers.<String>switchThread());
    }
}
