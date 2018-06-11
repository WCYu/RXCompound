package com.rxjy.rxcompound.mvp.model;

import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.mvp.contract.QRLoginSureContract;
import com.rxjy.rxcompound.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by Administrator on 2017/12/20.
 */

public class QRLoginSureModel implements QRLoginSureContract.Model{
    @Override
    public Observable<String> getQRLoginSure(String kahao, String biaoshi) {
        return ApiEngine.getInstance().getDesApiWpsService()
                .getQRLoginSure(kahao,biaoshi)
                .compose(RxSchedulers.<String>switchThread());
    }
}
