package com.rxjy.rxcompound.joinin.mvp.model;

import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.joinin.mvp.contract.AnswerContract;
import com.rxjy.rxcompound.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by asus on 2018/5/31.
 */

public class AnswerModel implements AnswerContract.Model{
    @Override
    public Observable<String> getAgreeYes(String card, String arr) {
        return ApiEngine.getInstance().getRsApiService()
                .getSubmitAnswer(card, arr,0)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getConsent(String cardNo, String Type) {
        return ApiEngine.getInstance().getRsApiService()
                .getConsent(cardNo,Type)
                .compose(RxSchedulers.<String>switchThread());
    }
}
