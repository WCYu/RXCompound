package com.rxjy.rxcompound.des.mvp.model;

import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.des.mvp.contract.NewSixContract;
import com.rxjy.rxcompound.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by Administrator on 2017/10/9 0009.
 */

public class NewSixModel implements NewSixContract.Model {
    @Override
    public Observable<String> GetNewSix(String rwdid) {
        return ApiEngine.getInstance().getDesApiService()
                .getfangyuanxinxi(rwdid)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> UpXinxi(String cardNo, String formpars, String type) {
        return ApiEngine.getInstance().getDesApiService()
                .UpXinxi(cardNo,formpars,type)
                .compose(RxSchedulers.<String>switchThread());
    }
}
