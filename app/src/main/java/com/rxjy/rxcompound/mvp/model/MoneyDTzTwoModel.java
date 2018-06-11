package com.rxjy.rxcompound.mvp.model;

import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.mvp.contract.MoneyDTzTwoContract;
import com.rxjy.rxcompound.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by hjh on 2018/3/15.
 */

public class MoneyDTzTwoModel implements MoneyDTzTwoContract.Model{

    @Override
    public Observable<String> getbusmoneydata(String year, String month, String cardNo) {
        return ApiEngine.getInstance().getMoneyApiService()
                .getBussMoney(year, month, cardNo)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getbusmhisdata(String year, String cardNo) {
        return ApiEngine.getInstance().getMoneyApiService()
                .getMoneyBusHis(year, cardNo)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> gettzfenhongdata(String year, String month, String cardNo) {
        return ApiEngine.getInstance().getMoneyApiService()
                .getTzFenhong(year, month, cardNo)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> gettzrewarddata(String year, String month, String cardNo) {
        return ApiEngine.getInstance().getMoneyApiService()
                .getTzReward(year, month, cardNo)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getzarewarddata(String year, String month, String cardNo) {
        return ApiEngine.getInstance().getMoneyApiService()
                .getZaReward(year, month, cardNo)
                .compose(RxSchedulers.<String>switchThread());
    }

}
