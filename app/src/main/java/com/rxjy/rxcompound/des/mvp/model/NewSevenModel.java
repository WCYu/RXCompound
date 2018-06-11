package com.rxjy.rxcompound.des.mvp.model;

import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.des.mvp.contract.NewSevenContract;
import com.rxjy.rxcompound.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by Administrator on 2017/10/9 0009.
 */

public class NewSevenModel implements NewSevenContract.Model{
    @Override
    public Observable<String> GetNewSeven(String rwdid) {
        return ApiEngine.getInstance().getDesApiService()
                .getloupanxinxi(rwdid)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> UpXinxi(String cardNo, String formpars, String type) {
        return ApiEngine.getInstance().getDesApiService()
                .UpXinxi(cardNo,formpars,type)
                .compose(RxSchedulers.<String>switchThread());
    }
}
