package com.rxjy.rxcompound.des.mvp.model;

import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.des.mvp.contract.QianBaoContracts;
import com.rxjy.rxcompound.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by Administrator on 2017/8/25.
 */

public class QianBaoModel implements QianBaoContracts.Model{
    @Override
    public Observable<String> getQianBaoInfo(String cardNo, int pageIndex) {
        return ApiEngine.getInstance().getDesApiService()
                .getQianBaoInfo(cardNo,pageIndex)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getQianBaoFenInfo(String cardNo, int pageIndex, int type) {
        return ApiEngine.getInstance().getDesApiService()
                .getQianBaoFenInfo(cardNo,pageIndex,type)
                .compose(RxSchedulers.<String>switchThread());
    }
}
