package com.rxjy.rxcompound.des.mvp.model;
import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.des.mvp.contract.GetXunjianListContract;
import com.rxjy.rxcompound.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by Administrator on 2017/10/24.
 */

public class GetXunjianListModel implements GetXunjianListContract.Model {
    @Override
    public Observable<String> GetScheduleCheckList(String rwdId) {
        return ApiEngine.getInstance().getDesApiService()
                .GetScheduleCheckList(rwdId)
                .compose(RxSchedulers.<String>switchThread());
    }
}
