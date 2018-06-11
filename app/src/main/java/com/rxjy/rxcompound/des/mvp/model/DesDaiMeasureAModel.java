package com.rxjy.rxcompound.des.mvp.model;

import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.des.mvp.contract.DesDaiMeasureAContract;
import com.rxjy.rxcompound.rx.RxSchedulers;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import rx.Observable;

/**
 * Created by hjh on 2017/12/14.
 */

public class DesDaiMeasureAModel implements DesDaiMeasureAContract.Model{
    @Override
    public Observable<String> getLHouseData(String rwdid) {
        return ApiEngine.getInstance().getDesApiService()
                .GetLHouseData(rwdid)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> saveLHouseData(String rwdId, String formpars, String money, String valCount) {

        RequestBody body = RequestBody.create(MediaType.parse("application/json"), formpars);

        return ApiEngine.getInstance().getDesApiService()
                .SaveLHouseData(rwdId,formpars,money,valCount)
//                .SaveLHouseData(rwdId,body,money,valCount)
                .compose(RxSchedulers.<String>switchThread());
    }

}
