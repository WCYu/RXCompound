package com.rxjy.rxcompound.activity.guwen;


import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.rx.RxSchedulers;

import rx.Observable;


/**
 * Created by Administrator on 2018/5/30.
 */

public class DownLineModel implements DownLineContract.Model{

    @Override
    public Observable<String> getClientList(String card) {
        return ApiEngine.getInstance().getSwApiService()
                .GetSubordinateList(card)
                .compose(RxSchedulers.<String>switchThread());
    }
}
