package com.rxjy.rxcompound.mvp.model;

import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.mvp.contract.MoneyDBusjfContract;
import com.rxjy.rxcompound.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by hjh on 2018/4/11.
 */

public class MoneyDBusjfModel implements MoneyDBusjfContract.Model{
    @Override
    public Observable<String> getbuskqdata(String year, String month, String cardNo) {
        return ApiEngine.getInstance().getMoneyApiService()
                .getBusJFKQMoney(year, month, cardNo)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getbuskqmoredata(String year, String month, String cardNo) {
        return ApiEngine.getInstance().getMoneyApiService()
                .getBusJFKQMoreMoney(year, month, cardNo)
                .compose(RxSchedulers.<String>switchThread());
    }
}
