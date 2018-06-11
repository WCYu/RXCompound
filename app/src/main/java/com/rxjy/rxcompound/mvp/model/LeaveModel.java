package com.rxjy.rxcompound.mvp.model;

import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.mvp.contract.LeaveContract;
import com.rxjy.rxcompound.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by asus on 2018/5/17.
 */

public class LeaveModel implements LeaveContract.Model {
    @Override
    public Observable<String> getLeaveData(String CardNo, int year, int month) {
        return ApiEngine.getInstance().getRsApiService()
                .getLeaveData(CardNo,year,month)
                .compose(RxSchedulers.<String>switchThread());
    }
}
