package com.rxjy.rxcompound.des.mvp.model;

import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.des.mvp.contract.ShopContract;
import com.rxjy.rxcompound.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by asus on 2018/5/24.
 */

public class ShopModel implements ShopContract.Model {
    @Override
    public Observable<String> GetShopBean(String cardNo) {
        return ApiEngine.getInstance().getNOApiService()
                .getShopInfo(cardNo)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> psotUpShopInfo(String cardNo, String image, int age, int workYears, String english, String consultation, String motto) {
        return ApiEngine.getInstance().getNOApiService()
                .postUpShopInfo(cardNo,image,age,workYears,english,consultation,motto)
                .compose(RxSchedulers.<String>switchThread());
    }
}
