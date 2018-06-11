package com.rxjy.rxcompound.mvp.model;

import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.mvp.contract.MoneyDetailsContract;
import com.rxjy.rxcompound.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by hjh on 2018/3/14.
 */

public class MoneyDetailsModel implements MoneyDetailsContract.Model{
    @Override
    public Observable<String> getbusmoneydata(String year, String month, String cardNo) {
        return ApiEngine.getInstance().getMoneyApiService()
                .getBussMoney(year, month, cardNo)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getbusprocessdata(String year, String month, String cardNo) {
        return ApiEngine.getInstance().getMoneyApiService()
                .getBusProcess(year, month, cardNo)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getbusresultdata(String year, String month, String cardNo) {
        return ApiEngine.getInstance().getMoneyApiService()
                .getBusResult(year, month, cardNo)
                .compose(RxSchedulers.<String>switchThread());
    }

}
