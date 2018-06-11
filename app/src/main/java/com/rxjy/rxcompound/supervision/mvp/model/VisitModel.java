package com.rxjy.rxcompound.supervision.mvp.model;

import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.rx.RxSchedulers;
import com.rxjy.rxcompound.supervision.mvp.contract.VisitContract;

import java.util.List;

import rx.Observable;

/**
 * Created by AAA on 2017/11/6.
 */

public class VisitModel implements VisitContract.Model {
    @Override
    public Observable<String> getWorkLog(String orderNo) {
        return ApiEngine.getInstance().getGcApiService()
                .getWorkLog(orderNo)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> subWorkLog(String orderNo, String content, List<String> tagList, String importance) {
        String tag = "";

        for (int i = 0; i < tagList.size(); i++) {
            if (tagList.size() - 1 == i) {
                tag = tag + tagList.get(i) + "";
            } else {
                tag = tag + tagList.get(i) + ",";
            }
        }

        return ApiEngine.getInstance().getGcApiService()
                .subWorkLog(orderNo, content, "1", tag, importance)
                .compose(RxSchedulers.<String>switchThread());
    }
}
