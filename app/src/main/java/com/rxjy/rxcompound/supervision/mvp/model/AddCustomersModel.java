package com.rxjy.rxcompound.supervision.mvp.model;

import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.rx.RxSchedulers;
import com.rxjy.rxcompound.supervision.mvp.contract.AddCustomersCotract;

import rx.Observable;

/**
 * Created by asus on 2018/4/14.
 */

public class AddCustomersModel implements AddCustomersCotract.Model {
    @Override
    public Observable<String> getProTypeData() {
        return ApiEngine.getInstance().getDesApiService()
                .getProTypaeData()
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> postCustomersInfo(String rwdId, String cityId, String type, String clientInfo, String clientAuxiliary) {
        return ApiEngine.getInstance().getTjApiService()
                .postCustomersInfo(rwdId,cityId,type,clientInfo,clientAuxiliary)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> GetOrderNumber(String areaid, String phone) {
        return ApiEngine.getInstance().getRxbusicApiHost()
                .getLHouseNum(areaid,phone)
                .compose(RxSchedulers.<String>switchThread());
    }
}
