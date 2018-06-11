package com.rxjy.rxcompound.des.mvp.model;

import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.des.mvp.contract.GetALLClientInfoContract;
import com.rxjy.rxcompound.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by Administrator on 2017/8/11.
 */

public class GetALLClientInfoModel implements GetALLClientInfoContract.Model{
    @Override
    public Observable<String> getALLClientInfo(String phone) {
        return ApiEngine.getInstance().getDesApiService()
                .getALLClientInfo(phone)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getALLClientInfoNew(String mobile) {
        return ApiEngine.getInstance().geDesLhSubmitApiService()
                .getALLClientInfoNew(mobile)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> GetUCList(String cardNo) {
        return ApiEngine.getInstance().getDesApiService()
                .GetUCList(cardNo)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> DesERLogin(String cardno, String password, String uuid) {
        return ApiEngine.getInstance().getDesErLoginApiService()
                .getDesERLogin(cardno, password, uuid)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getFloatedSheet(String diquId) {

        return ApiEngine.getInstance().getPDApiService()
                .getFloatedSheet(diquId)
                .compose(RxSchedulers.<String>switchThread());
    }
}
