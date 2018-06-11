package com.rxjy.rxcompound.mvp.model;

import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.mvp.contract.MessageTwoContract;
import com.rxjy.rxcompound.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by hjh on 2018/3/9.
 */

public class MessageTwoModel implements MessageTwoContract.Model{
    @Override
    public Observable<String> getInfoMessageTwoList(String cardNo, String Group) {
        return ApiEngine.getInstance().getRsApiService()
                .getInformListMessage(cardNo,Group)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> toSeeDetails(String id) {
        return ApiEngine.getInstance().getRsApiService()
                .getToSeeDetails(id)
                .compose(RxSchedulers.<String>switchThread());
    }
}
