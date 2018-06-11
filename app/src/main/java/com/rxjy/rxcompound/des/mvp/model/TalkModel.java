package com.rxjy.rxcompound.des.mvp.model;

import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.des.mvp.contract.TalkContract;
import com.rxjy.rxcompound.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by Administrator on 2017/8/15.
 */

public class TalkModel implements TalkContract.Model {

    @Override
    public Observable<String> getHuiFangData(String rwdId, int pageIndex) {
        return ApiEngine.getInstance().getDesApiService()
                .getHuiFangData(rwdId, pageIndex)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> xlgetHuiFangData(String rwdId, int pageIndex) {
        return ApiEngine.getInstance().getDesApiService()
                .getHuiFangData(rwdId, pageIndex)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> addHuiFangData(String rwdId, String content, int methods) {
        return ApiEngine.getInstance().getDesApiService()
                .addHuiFangData(rwdId, content, methods)
                .compose(RxSchedulers.<String>switchThread());
    }


}
