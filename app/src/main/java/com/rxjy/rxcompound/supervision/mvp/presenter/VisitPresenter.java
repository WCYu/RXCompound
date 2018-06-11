package com.rxjy.rxcompound.supervision.mvp.presenter;

import android.util.Log;

import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.des.entity.SubInfo;
import com.rxjy.rxcompound.supervision.entity.VisitInfo;
import com.rxjy.rxcompound.supervision.mvp.contract.VisitContract;
import com.rxjy.rxcompound.supervision.mvp.model.VisitModel;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by AAA on 2017/11/6.
 */

public class VisitPresenter extends VisitContract.Presenter {

    public static final String TAG = "VisitPresenter";

    public VisitPresenter(VisitContract.View mView) {
        this.mView = mView;
        mModel = new VisitModel();
    }

    @Override
    public void getWorkLog(String orderNo) {
        Subscription subscribe = mModel.getWorkLog(orderNo)
                .subscribe(new Subscriber<String>() {

                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "获取回访列表失败 = " + e.toString());
                        mView.responseVisitDataError("请求超时");
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        VisitInfo info = JSONUtils.toObject(s, VisitInfo.class);
                        if (info.getStatusCode() == 1) {
                            List<VisitInfo.Visit> dataList = info.getBody();
                            mView.responseVisitData(dataList);
                        } else {
                            mView.responseVisitDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void subWorkLog(String orderNo, String content, List<String> tagList, String importance) {
        Subscription subscribe = mModel.subWorkLog(orderNo, content, tagList, importance)
                .subscribe(new Subscriber<String>() {

                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "提交回访失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        SubInfo info = JSONUtils.toObject(s,SubInfo.class);
                        if (info.getStatusCode() == 1){
                            mView.responseAddVisitData();
                        }else {
                            mView.responseAddVisitDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
