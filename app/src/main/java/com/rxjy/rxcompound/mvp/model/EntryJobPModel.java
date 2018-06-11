package com.rxjy.rxcompound.mvp.model;

import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.mvp.contract.EntryJobPContract;
import com.rxjy.rxcompound.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by hjh on 2017/11/10.
 */

public class EntryJobPModel implements EntryJobPContract.Model{

    @Override
    public Observable<String> getConsent(String cardNo, String Type) {
        return ApiEngine.getInstance().getRsApiService()
                .getConsent(cardNo,Type)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getEntryJob(String cardNo) {
        return ApiEngine.getInstance().getRsApiService()
                .getEntryJob(cardNo)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getIsConsent(String CardNo, String Type) {
        return ApiEngine.getInstance().getRsApiService()
                .getIsConsent(CardNo,Type)
                .compose(RxSchedulers.<String>switchThread());
    }
}
