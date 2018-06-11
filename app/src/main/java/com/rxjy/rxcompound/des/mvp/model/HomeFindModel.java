package com.rxjy.rxcompound.des.mvp.model;

import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.des.mvp.contract.OnTriaHomeContract;
import com.rxjy.rxcompound.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by asus on 2018/5/25.
 */

public class HomeFindModel implements OnTriaHomeContract.Model {
    @Override
    public Observable<String> getFindList(String cardNo) {
        return ApiEngine.getInstance().getRsApiService()
                .getNeswList(cardNo)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getHuanYing(String cardNo) {
        return ApiEngine.getInstance().getRsApiService()
                .getHuanying(cardNo)
                .compose(RxSchedulers.<String>switchThread());
    }
}
