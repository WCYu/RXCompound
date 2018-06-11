package com.rxjy.rxcompound.supervision.mvp.model;


import android.util.Log;

import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.rx.RxSchedulers;
import com.rxjy.rxcompound.supervision.mvp.contract.HomeContract;

import rx.Observable;

/**
 * Created by AAA on 2017/7/31.
 */

public class HomeModel implements HomeContract.Model {
    @Override
    public Observable<String> getProList(String cardNo) {

        return ApiEngine.getInstance().getGcApiService()
                .getProjectList(cardNo)
                .compose(RxSchedulers.<String>switchThread());
    }
}
