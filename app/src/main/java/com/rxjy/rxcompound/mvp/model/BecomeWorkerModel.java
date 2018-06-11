package com.rxjy.rxcompound.mvp.model;

import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.mvp.contract.BecomeWorkerContract;
import com.rxjy.rxcompound.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by asus on 2018/5/18.
 */

public class BecomeWorkerModel implements BecomeWorkerContract.Model {
    @Override
    public Observable<String> getSubmitBecome(String CardNo, String Reason1, String Reason2) {
        return ApiEngine.getInstance().getRsApiService()
                .getpplyAttendance(CardNo,Reason1,Reason2)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getSubmitConditions(String CardNo) {
        //getsubmitConditions
        return ApiEngine.getInstance().getRsApiService()
                .getsubmitConditions(CardNo)
                .compose(RxSchedulers.<String>switchThread());
    }
}
