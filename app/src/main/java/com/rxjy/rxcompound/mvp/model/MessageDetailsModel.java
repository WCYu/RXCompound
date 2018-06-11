package com.rxjy.rxcompound.mvp.model;

import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.mvp.contract.MessageDetailsContract;
import com.rxjy.rxcompound.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by hjh on 2018/3/9.
 */

public class MessageDetailsModel implements MessageDetailsContract.Model{
    @Override
    public Observable<String> getInfoMessageDList(String Id) {
        return ApiEngine.getInstance().getRsApiService()
                .getInformDetailsMessage(Id)
                .compose(RxSchedulers.<String>switchThread());
    }
}
