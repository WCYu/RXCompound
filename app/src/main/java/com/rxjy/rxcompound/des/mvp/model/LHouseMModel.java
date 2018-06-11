package com.rxjy.rxcompound.des.mvp.model;

import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.des.mvp.contract.LHouseMContract;
import com.rxjy.rxcompound.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by hjh on 2018/4/4.
 */

public class LHouseMModel implements LHouseMContract.Model {

    @Override
    public Observable<String> GetData(String areaid, String phone) {
        return ApiEngine.getInstance().geDesLhApiService()
                .getLHouseNum(areaid, phone)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> submitData(String rwdid, String clientInfo, String clientAuxiliary) {
        return ApiEngine.getInstance().geDesLhSubmitApiService()
                .submitLHouseNum(rwdid, clientInfo, clientAuxiliary)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getProjecttype() {
        return ApiEngine.getInstance().getDesApiService()
                .getProjecttype()
                .compose(RxSchedulers.<String>switchThread());
    }
}
