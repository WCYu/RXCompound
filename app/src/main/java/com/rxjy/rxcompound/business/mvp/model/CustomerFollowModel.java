package com.rxjy.rxcompound.business.mvp.model;

import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.business.mvp.contract.CustomerFollowContract;
import com.rxjy.rxcompound.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by Administrator on 2017/11/30.
 */

public class CustomerFollowModel implements CustomerFollowContract.Model{
    @Override
    public Observable<String> addCustomervisit(int KeHuBaseID, int salesmanid, String content, int areaid, String nexttime, int status) {
        return ApiEngine.getInstance().getRxbusicApiHost()
                .postAddCustomerVisit(KeHuBaseID,salesmanid,content,areaid,nexttime,status)
                .compose(RxSchedulers.<String>switchThread());
    }
}
