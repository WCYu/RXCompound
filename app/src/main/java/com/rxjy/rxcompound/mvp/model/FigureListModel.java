package com.rxjy.rxcompound.mvp.model;

import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.mvp.contract.FigureListContract;
import com.rxjy.rxcompound.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by hjh on 2018/4/26.
 */

public class FigureListModel implements FigureListContract.Model{
    @Override
    public Observable<String> getFigureList(String CardNo, String RegionId, String Type) {
        return ApiEngine.getInstance().getRsApiService()
                .getFigureList(CardNo, RegionId, Type)
                .compose(RxSchedulers.<String>switchThread());
    }
}
