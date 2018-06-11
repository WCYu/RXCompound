package com.rxjy.rxcompound.des.mvp.model;

import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.des.mvp.contract.NewFourContract;
import com.rxjy.rxcompound.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by Administrator on 2017/10/8 0008.
 */

public class NewFourModel implements NewFourContract.Model {
    @Override
    public Observable<String> GetNewFour(String rwdid) {
        return ApiEngine.getInstance().getDesApiService()
                .getwuyexinxi(rwdid)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> UpXinxi(String cardNo, String formpars, String type) {
        return ApiEngine.getInstance().getDesApiService()
                .UpXinxi(cardNo,formpars,type)
                .compose(RxSchedulers.<String>switchThread());
    }
}
