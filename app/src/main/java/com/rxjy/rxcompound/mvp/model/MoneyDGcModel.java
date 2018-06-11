package com.rxjy.rxcompound.mvp.model;

import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.mvp.contract.MoneyDGcContract;
import com.rxjy.rxcompound.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by hjh on 2018/3/19.
 */

public class MoneyDGcModel implements MoneyDGcContract.Model{
    @Override
    public Observable<String> getgcjixiaodata(String year, String month, String cardNo) {
        return ApiEngine.getInstance().getMoneyApiService()
                .getGcJixiao(year, month, cardNo)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getgcchuangshoudata(String year, String month, String cardNo) {
        return ApiEngine.getInstance().getMoneyApiService()
                .getGcChuangshou(year, month, cardNo)
                .compose(RxSchedulers.<String>switchThread());
    }
}
