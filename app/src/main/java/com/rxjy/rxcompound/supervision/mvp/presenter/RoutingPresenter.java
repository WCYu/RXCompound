package com.rxjy.rxcompound.supervision.mvp.presenter;

import android.util.Log;

import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.supervision.entity.RoutingListInfo;
import com.rxjy.rxcompound.supervision.entity.RoutingStateInfo;
import com.rxjy.rxcompound.supervision.mvp.contract.RoutingContract;
import com.rxjy.rxcompound.supervision.mvp.model.RoutingModel;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by AAA on 2017/11/3.
 */

public class RoutingPresenter extends RoutingContract.Presenter {

    public static final String TAG = "RoutingPresenter";

    public RoutingPresenter(RoutingContract.View mView) {
        this.mView = mView;
        mModel = new RoutingModel();
    }

    @Override
    public void getRoutingList(String orderNo) {
        Subscription subscribe = mModel.getRoutingList(orderNo)
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
                        Log.e(TAG, "获取巡检记录失败 = " + e.toString());
                        mView.responseRoutingListDataError("请求超时");
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        RoutingListInfo info = JSONUtils.toObject(s, RoutingListInfo.class);
                        if (info.getStatusCode() == 1) {
                            List<RoutingListInfo.RoutingInfo> dataList = info.getBody();
                            mView.responseRoutingListData(dataList);
                        } else {
                            mView.responseRoutingListDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void getRoutingState(String orderNo) {
        Subscription subscribe = mModel.getRoutingState(orderNo)
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
                        Log.e(TAG, "获取巡检状态失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        RoutingStateInfo info = JSONUtils.toObject(s, RoutingStateInfo.class);
                        if (info.getStatusCode() == 1) {
                            RoutingStateInfo.RoutingState data = info.getBody();
                            mView.responseRoutingStateData(data);
                        } else {
                            mView.responseRoutingStateDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
