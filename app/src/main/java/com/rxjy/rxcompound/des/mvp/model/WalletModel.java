package com.rxjy.rxcompound.des.mvp.model;


import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.des.mvp.contract.WalletContract;
import com.rxjy.rxcompound.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by Administrator on 2017/6/30.
 */
public class WalletModel implements WalletContract.Model {
    @Override
    public Observable<String> getWalletdata(String kahao, String zhiwu, String type) {
        return ApiEngine.getInstance().getRxbusicApiHost()
                .postRXBi(kahao,zhiwu,type)
                .compose(RxSchedulers.<String>switchThread());
    }
}
