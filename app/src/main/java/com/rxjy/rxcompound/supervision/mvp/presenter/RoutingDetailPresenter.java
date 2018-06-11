package com.rxjy.rxcompound.supervision.mvp.presenter;

import android.util.Log;

import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.supervision.entity.RoutingDetailInfo;
import com.rxjy.rxcompound.supervision.mvp.contract.RoutingDetailContract;
import com.rxjy.rxcompound.supervision.mvp.model.RoutingDetailModel;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by AAA on 2018/1/17.
 */

public class RoutingDetailPresenter extends RoutingDetailContract.Presenter {

    public static final String TAG = "RoutingDetailPresenter";

    public RoutingDetailPresenter(RoutingDetailContract.View mView) {
        this.mView = mView;
        mModel = new RoutingDetailModel();
    }

    @Override
    public void getRoutingDetail(String orderNo, int xjID) {
        Subscription subscribe = mModel.getRoutingDetail(orderNo, xjID)
                .subscribe(new Subscriber<String>() {

                    @Override
                    public void onStart() {
                        mView.showDialog();
                    }

                    @Override
                    public void onCompleted() {
                        mView.hideDialog();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "获取巡检详情失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        RoutingDetailInfo info = JSONUtils.toObject(s, RoutingDetailInfo.class);
                        if (info.getStatusCode() == 1) {
                            List<RoutingDetailInfo.RoutingMarkInfo> dataList = info.getBody();
                            mView.responseRoutingDetail(dataList);
                        } else {
                            mView.responseRoutingDetailError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
