package com.rxjy.rxcompound.mvp.model;

import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.mvp.contract.MoneyDZaContract;
import com.rxjy.rxcompound.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by hjh on 2018/3/16.
 */

public class MoneyDZaModel implements MoneyDZaContract.Model {
    @Override
    public Observable<String> getzaprocessdata(String year, String month, String cardNo) {
        return ApiEngine.getInstance().getMoneyApiService()
                .getZaProcess(year, month, cardNo)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getzaresultdata(String year, String month, String cardNo) {
        return ApiEngine.getInstance().getMoneyApiService()
                .getZaResult(year, month, cardNo)
                .compose(RxSchedulers.<String>switchThread());
    }
}
