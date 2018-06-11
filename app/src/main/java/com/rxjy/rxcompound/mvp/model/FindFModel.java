package com.rxjy.rxcompound.mvp.model;

import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.mvp.contract.FindFContract;
import com.rxjy.rxcompound.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by Administrator on 2017/11/13.
 */

public class FindFModel implements FindFContract.Model{
    @Override
    public Observable<String> getFindList(String cardNo, int pageIndex, int pageSize) {
        return ApiEngine.getInstance().getfindApiService()
                .postFindData(cardNo,pageIndex,pageSize)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getFindListLoadmore(String cardNo, int pageIndex, int pageSize) {
        return ApiEngine.getInstance().getfindApiService()
                .postFindData(cardNo,pageIndex,pageSize)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getFindObtainWhethe(String CardNo) {
        return ApiEngine.getInstance().getRsApiService()
                .getMnagementLayer(CardNo)
                .compose(RxSchedulers.<String>switchThread());
    }
}
