package com.rxjy.rxcompound.business.mvp.model;

import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.business.mvp.contract.CustomerNewContract;
import com.rxjy.rxcompound.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by hjh on 2018/5/11.
 */

public class CustomerNewModel implements CustomerNewContract.Model{
    @Override
    public Observable<String> getCustomer(String card, String PageSize, String pageIndex) {
        return ApiEngine.getInstance().geDesLhApiService()
                .getKFCustomer(card, PageSize, pageIndex)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getCustomerMore(String card, String PageSize, String pageIndex) {
        return ApiEngine.getInstance().geDesLhApiService()
                .getKFCustomer(card, PageSize, pageIndex)
                .compose(RxSchedulers.<String>switchThread());
    }
}