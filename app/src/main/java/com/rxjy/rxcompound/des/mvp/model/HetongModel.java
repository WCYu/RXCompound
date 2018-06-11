package com.rxjy.rxcompound.des.mvp.model;


import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.des.mvp.contract.HetongContract;
import com.rxjy.rxcompound.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by Administrator on 2017/10/17.
 */

public class HetongModel implements HetongContract.Model {
    @Override
    public Observable<String> ProImgCatalogs(String rwdId) {
        return ApiEngine.getInstance().getDesApiService()
                .ProImgCatalogs(rwdId)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> GetAllImages(String rwdId, int enumType) {
        return ApiEngine.getInstance().getDesApiService()
                .GetAllImages(rwdId,enumType)
                .compose(RxSchedulers.<String>switchThread());
    }
}
