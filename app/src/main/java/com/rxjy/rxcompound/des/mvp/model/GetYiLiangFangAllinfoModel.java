package com.rxjy.rxcompound.des.mvp.model;

import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.des.mvp.contract.GetYiLiangFangAllinfoContract;
import com.rxjy.rxcompound.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by Administrator on 2017/8/18.
 */

public class GetYiLiangFangAllinfoModel implements GetYiLiangFangAllinfoContract.Model {
    @Override
    public Observable<String> GetYiLiangFangAllinfo(String rwdId) {
        return ApiEngine.getInstance().getDesApiService()
                .geYiLiangFangAllInfo(rwdId)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getAllImagesData(String rwdId, String enumType, String token)
    {
        return ApiEngine.getInstance().getDesApiService()
                .getAllImages(rwdId, enumType)
                .compose(RxSchedulers.<String>switchThread());
    }

}
