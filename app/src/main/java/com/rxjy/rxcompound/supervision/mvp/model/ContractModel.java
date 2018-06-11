package com.rxjy.rxcompound.supervision.mvp.model;

import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.rx.RxSchedulers;
import com.rxjy.rxcompound.supervision.mvp.contract.ContractContract;

import rx.Observable;

/**
 * Created by AAA on 2017/12/13.
 */

public class ContractModel implements ContractContract.Model {
    @Override
    public Observable<String> getFirstPartyContract(String orderNo) {
        return ApiEngine.getInstance().getGcApiService()
                .getFirstPartyContract(orderNo)
                .compose(RxSchedulers.<String>switchThread());
    }
}
