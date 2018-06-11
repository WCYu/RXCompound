package com.rxjy.rxcompound.mvp.model;

import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.mvp.contract.CustomerContract;
import com.rxjy.rxcompound.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by asus on 2018/4/13.
 */

public class CustomerModel implements CustomerContract.Model {


    @Override
    public Observable<String> loadCustomerData(String cardNo,String type) {
        return ApiEngine.getInstance().getTjApiService()
                .loadCustomerData(cardNo,type)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> GetOrderNumber(String areaid, String phone) {
        return ApiEngine.getInstance().getRxbusicApiHost()
                .getLHouseNum(areaid,phone)
                .compose(RxSchedulers.<String>switchThread());
    }
}
