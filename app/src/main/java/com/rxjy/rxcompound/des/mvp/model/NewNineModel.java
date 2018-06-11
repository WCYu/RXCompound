package com.rxjy.rxcompound.des.mvp.model;


import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.des.mvp.contract.NewNineContract;
import com.rxjy.rxcompound.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by Administrator on 2017/10/9 0009.
 */

public class NewNineModel implements NewNineContract.Model {
    @Override
    public Observable<String> GetNewNine(String rwdid) {
        return ApiEngine.getInstance().getDesApiService()
                .getqiyexinxi(rwdid)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> UpXinxi(String cardNo, String formpars, String type) {
        return ApiEngine.getInstance().getDesApiService()
                .UpXinxi(cardNo,formpars,type)
                .compose(RxSchedulers.<String>switchThread());
    }

}
