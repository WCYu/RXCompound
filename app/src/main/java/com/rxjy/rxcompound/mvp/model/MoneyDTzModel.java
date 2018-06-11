package com.rxjy.rxcompound.mvp.model;

import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.mvp.contract.MoneyDTzContract;
import com.rxjy.rxcompound.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by hjh on 2018/3/15.
 */

public class MoneyDTzModel implements MoneyDTzContract.Model{
    @Override
    public Observable<String> gettzresultdata(String year, String month, String cardNo) {
        return ApiEngine.getInstance().getMoneyApiService()
                .getTzResult(year, month, cardNo)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> gettzprocessdata(String year, String month, String cardNo) {
        return ApiEngine.getInstance().getMoneyApiService()
                .getTzProcess(year, month, cardNo)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getbusrewarddata(String year, String month, String cardNo) {
        return ApiEngine.getInstance().getMoneyApiService()
                .getBusReward(year, month, cardNo)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> gettzrsresultdata(String year, String month, String cardNo) {
        return ApiEngine.getInstance().getMoneyApiService()
                .getTzRSResult(year, month, cardNo)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> gettzrsprocessdata(String year, String month, String cardNo) {
        return ApiEngine.getInstance().getMoneyApiService()
                .getTzRSProcess(year, month, cardNo)
                .compose(RxSchedulers.<String>switchThread());
    }
}