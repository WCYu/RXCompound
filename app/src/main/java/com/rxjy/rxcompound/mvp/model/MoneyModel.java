package com.rxjy.rxcompound.mvp.model;

import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.mvp.contract.MoneyContract;
import com.rxjy.rxcompound.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by hjh on 2018/3/2.
 */

public class MoneyModel implements MoneyContract.Model{
    @Override
    public Observable<String> getmoneydata(String card) {
        return ApiEngine.getInstance().getRsApiService()
                .getMoney(card)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getbusmoneynewdata(String year, String month, String cardNo) {
        return ApiEngine.getInstance().getMoneyApiService()
                .getBusMoneyNew(year, month, cardNo)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getbusmoneydata(String year, String month, String cardNo) {
        return ApiEngine.getInstance().getMoneyApiService()
                .getBusMoney(year, month, cardNo)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getdesmoneydata(String year, String month, String cardNo) {
        return ApiEngine.getInstance().getMoneyApiService()
                .getDesMoney(year, month, cardNo)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getgcmoneydata(String year, String month, String cardNo) {
        return ApiEngine.getInstance().getMoneyApiService()
                .getGcMoney(year, month, cardNo)
                .compose(RxSchedulers.<String>switchThread());
    }

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
    public Observable<String> getHospitaldata(String cardNo) {
        return ApiEngine.getInstance().getRsApiService()
                .getHospitaldata(cardNo)
                .compose(RxSchedulers.<String>switchThread());
    }
}
