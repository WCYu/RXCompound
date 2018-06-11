package com.rxjy.rxcompound.des.mvp.model;

import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.des.mvp.contract.DesDaiSurroundingsContract;
import com.rxjy.rxcompound.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by Administrator on 2017/6/22.
 */
public class DesDaiSurroundingsModel implements DesDaiSurroundingsContract.Model
{
    @Override
    public Observable<String> getDaiSurroundingsData(String rwdId, String enumType, String token)
    {
        return ApiEngine.getInstance().getDesApiService()
                .getAllImages(rwdId, enumType)
                .compose(RxSchedulers.<String>switchThread());
    }
}
