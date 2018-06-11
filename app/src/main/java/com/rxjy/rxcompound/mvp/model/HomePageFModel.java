package com.rxjy.rxcompound.mvp.model;

import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.mvp.contract.HomePageFContract;
import com.rxjy.rxcompound.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by hjh on 2017/11/13.
 */

public class HomePageFModel implements HomePageFContract.Model{
    @Override
    public Observable<String> getBannerList(String a_ccount) {
        return ApiEngine.getInstance().getRsApiService()
                .getHomeBanner(a_ccount)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getEduData(String cardno) {
        return ApiEngine.getInstance().getRxeduApiHost()
                .getEduProgress(cardno)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getTaskData(String Card) {
        return ApiEngine.getInstance().getRsApiService()
                .getTaskList(Card)
                .compose(RxSchedulers.<String>switchThread());
    }
}
