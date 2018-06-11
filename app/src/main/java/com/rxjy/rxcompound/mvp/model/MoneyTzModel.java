package com.rxjy.rxcompound.mvp.model;

import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.mvp.contract.MoneyTzContract;
import com.rxjy.rxcompound.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by hjh on 2018/3/27.
 */

public class MoneyTzModel implements MoneyTzContract.Model{
    @Override
    public Observable<String> gettzmoneydata(String year, String month, String cardNo) {
        return ApiEngine.getInstance().getMoneyApiService()
                .getTzMoney(year, month, cardNo)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getxzmoneydata(String year, String month, String cardNo) {
        return ApiEngine.getInstance().getMoneyApiService()
                .getXzMoney(year, month, cardNo)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getkjmoneydata(String year, String month, String cardNo) {
        return ApiEngine.getInstance().getMoneyApiService()
                .getKjMoney(year, month, cardNo)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getcnmoneydata(String year, String month, String cardNo) {
        return ApiEngine.getInstance().getMoneyApiService()
                .getCnMoney(year, month, cardNo)
                .compose(RxSchedulers.<String>switchThread());
    }

}
