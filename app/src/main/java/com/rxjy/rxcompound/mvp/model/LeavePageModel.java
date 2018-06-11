package com.rxjy.rxcompound.mvp.model;

import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.mvp.contract.LeaveContract;
import com.rxjy.rxcompound.mvp.contract.LeavePageContract;
import com.rxjy.rxcompound.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by asus on 2018/5/17.
 */

public class LeavePageModel  implements LeavePageContract.Model{

    @Override
    public Observable<String> getLeavePageTypeData() {
        return ApiEngine.getInstance().getRsApiService()
                .getLeaTypeTyData()
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getpplyAttendance(String cardno, String beginTime, String endTime, String days, String reason, int vacationState) {
        return ApiEngine.getInstance().getRsApiService()
                .getpplyAttendance(cardno,beginTime,endTime,days,reason,vacationState)
                .compose(RxSchedulers.<String>switchThread());
    }
}
