package com.rxjy.rxcompound.business.mvp.model;

import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.business.mvp.contract.MineContract;
import com.rxjy.rxcompound.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by hjh on 2017/11/24.
 */

public class MineModel implements MineContract.Model{
    @Override
    public Observable<String> getMessage(String Kahao) {
        return ApiEngine.getInstance().getRxbusiApiHost()
                .getMyGrade(Kahao)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getGradeMessage(String Kahao) {
        return ApiEngine.getInstance().getRxbusiApiHost()
                .getMyGradeMoney(Kahao)
                .compose(RxSchedulers.<String>switchThread());
    }
}
