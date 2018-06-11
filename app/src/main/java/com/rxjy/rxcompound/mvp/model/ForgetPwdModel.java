package com.rxjy.rxcompound.mvp.model;

import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.mvp.contract.ForgetPwdContract;
import com.rxjy.rxcompound.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by hjh on 2018/3/30.
 */

public class ForgetPwdModel implements ForgetPwdContract.Model{
    @Override
    public Observable<String> getVCode(String phone) {
        return ApiEngine.getInstance().getRsApiService()
                .getVCodes(phone)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> toFixPwd(String phone, String newPassword, String vCode) {
        return ApiEngine.getInstance().getRsApiService()
                .postFixPwd(phone, newPassword, vCode)
                .compose(RxSchedulers.<String>switchThread());
    }
}
