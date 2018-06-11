package com.rxjy.rxcompound.mvp.model;

import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.mvp.contract.EnvironmentContract;
import com.rxjy.rxcompound.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by hjh on 2018/4/26.
 */

public class EnvironmentModel implements EnvironmentContract.Model{
    @Override
    public Observable<String> getEnvir(String CardNo, String RegionId, String Type) {
        return ApiEngine.getInstance().getRsApiService()
                .getFigureList(CardNo, RegionId, Type)
                .compose(RxSchedulers.<String>switchThread());
    }
}
