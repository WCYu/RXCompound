package com.rxjy.rxcompound.des.mvp.model;

import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.des.activity.CompactActivity;
import com.rxjy.rxcompound.des.mvp.contract.CompactContract;
import com.rxjy.rxcompound.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by asus on 2018/5/14.
 */

public class CompactModel implements CompactContract.Model {
    @Override
    public Observable<String> getDegisInfoData(String rwdId) {
        return ApiEngine.getInstance().geDesLhSubmitApiService()
                .getDegisInfoData(rwdId)
                .compose(RxSchedulers.<String>switchThread());
    }
}
