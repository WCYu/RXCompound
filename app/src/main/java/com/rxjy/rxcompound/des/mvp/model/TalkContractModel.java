package com.rxjy.rxcompound.des.mvp.model;

import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.des.mvp.contract.TalkContractContract;
import com.rxjy.rxcompound.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by hjh on 2018/5/15.
 */

public class TalkContractModel implements TalkContractContract.Model{
    @Override
    public Observable<String> getData(String rwdId) {
        return ApiEngine.getInstance().geDesLhSubmitApiService()
                .getTalkContractData(rwdId)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> submitData(String ca, String rwdId) {
        return ApiEngine.getInstance().geDesLhSubmitApiService()
                .submitTalkContractData(ca, rwdId)
                .compose(RxSchedulers.<String>switchThread());
    }
}
