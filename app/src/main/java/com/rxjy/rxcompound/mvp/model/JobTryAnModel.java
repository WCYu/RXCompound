package com.rxjy.rxcompound.mvp.model;

import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.mvp.contract.JobTryAnContract;
import com.rxjy.rxcompound.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by hjh on 2017/11/16.
 */

public class JobTryAnModel implements JobTryAnContract.Model{
    @Override
    public Observable<String> getGetData(String cardNo, String dept, String dayIndex) {
        return ApiEngine.getInstance().getRxeduApiHost()
                .getJobTryData(cardNo,dept,dayIndex)
                .compose(RxSchedulers.<String>switchThread());
    }
}
