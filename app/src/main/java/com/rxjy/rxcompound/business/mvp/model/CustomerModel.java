package com.rxjy.rxcompound.business.mvp.model;

import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.business.mvp.contract.CustomerContract;
import com.rxjy.rxcompound.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by hjh on 2017/11/24.
 */

public class CustomerModel implements CustomerContract.Model{

    @Override
    public Observable<String> getCustomer(String card, String pageIndex, String PageSize, String key) {
        return ApiEngine.getInstance().getRxbusicApiHost()
                .getCustomer(card,pageIndex,PageSize,key)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getCustomerMore(String card, String pageIndex, String PageSize, String key) {
        return ApiEngine.getInstance().getRxbusicApiHost()
                .getCustomer(card,pageIndex,PageSize,key)
                .compose(RxSchedulers.<String>switchThread());
    }

}
