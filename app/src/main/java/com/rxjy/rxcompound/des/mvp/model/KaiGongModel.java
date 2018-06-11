package com.rxjy.rxcompound.des.mvp.model;
import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.des.mvp.contract.KaiGongContract;
import com.rxjy.rxcompound.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by Administrator on 2017/10/23.
 */

public class KaiGongModel implements KaiGongContract.Model {
    @Override
    public Observable<String> GetUCAllImages(String rwdId, int enumType) {
        return ApiEngine.getInstance().getDesApiService()
                .GetUCAllImages(rwdId,enumType)
                .compose(RxSchedulers.<String>switchThread());
    }
}
