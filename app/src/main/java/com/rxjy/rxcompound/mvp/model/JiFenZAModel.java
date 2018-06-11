package com.rxjy.rxcompound.mvp.model;

import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.mvp.contract.JiFenZAContract;
import com.rxjy.rxcompound.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by hjh on 2018/4/2.
 */

public class JiFenZAModel implements JiFenZAContract.Model{
    @Override
    public Observable<String> getMessage(String cardNo) {
        return ApiEngine.getInstance().getMoneyApiService()
                .getJiFen(cardNo)
                .compose(RxSchedulers.<String>switchThread());
    }
}
