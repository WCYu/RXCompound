package com.rxjy.rxcompound.des.mvp.model;


import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.des.mvp.contract.NewOneContract;
import com.rxjy.rxcompound.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by Administrator on 2017/10/8 0008.
 */

public class NewOneModel implements NewOneContract.Model {
    @Override
    public Observable<String> GetNewOne(String rwdid) {
        return ApiEngine.getInstance().getDesApiService()
                .getliangfangxinxi(rwdid)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> UpXinxi(String cardNo, String formpars, String type) {
        return ApiEngine.getInstance().getDesApiService()
                .UpXinxi(cardNo,formpars,type)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> UpDanHao(String rwdid) {
        return ApiEngine.getInstance().getDesApiService()
                .UpDanHao(rwdid)
                .compose(RxSchedulers.<String>switchThread());
    }
}
