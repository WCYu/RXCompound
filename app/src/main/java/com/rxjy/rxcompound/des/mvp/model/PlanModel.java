package com.rxjy.rxcompound.des.mvp.model;

import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.des.mvp.contract.PlanContract;
import com.rxjy.rxcompound.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by hjh on 2018/4/17.
 */

public class PlanModel implements PlanContract.Model{
    @Override
    public Observable<String> GetTxt(String rwdId) {
        return ApiEngine.getInstance().geDesLhSubmitApiService()
                .getPlanTxt(rwdId)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> GetImage(String rwdId) {
        return ApiEngine.getInstance().geDesLhSubmitApiService()
                .getPlanImage(rwdId)
                .compose(RxSchedulers.<String>switchThread());
    }
}
