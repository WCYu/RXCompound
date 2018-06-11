package com.rxjy.rxcompound.des.mvp.model;

import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.des.mvp.contract.OrderGetContract;
import com.rxjy.rxcompound.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by hjh on 2018/4/16.
 */

public class OrderGetModel implements OrderGetContract.Model{

    @Override
    public Observable<String> GetData(String rwdid) {
        return ApiEngine.getInstance().geDesLhSubmitApiService()
                .getOrderget(rwdid)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> OrderDeal(String rwdid, String formpars, String type) {
        return ApiEngine.getInstance().getDesApiService()
                .getOrderdeal(rwdid, formpars, type)
                .compose(RxSchedulers.<String>switchThread());
    }
}