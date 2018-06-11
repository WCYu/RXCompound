package com.rxjy.rxcompound.supervision.mvp.presenter;

import android.util.Log;


import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.supervision.entity.ProListInfo;
import com.rxjy.rxcompound.supervision.mvp.contract.ProListContract;
import com.rxjy.rxcompound.supervision.mvp.model.ProListModel;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by AAA on 2017/12/15.
 */

public class ProListPresenter extends ProListContract.Presenter {

    public static final String TAG = "ProListPresenter";

    public ProListPresenter(ProListContract.View mView) {
        this.mView = mView;
        mModel = new ProListModel();
    }

    @Override
    public void getProList(String orderNo) {
        Subscription subscribe = mModel.getProList(orderNo)
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
                        Log.e(TAG, "获取项目清单列表失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        ProListInfo info = JSONUtils.toObject(s, ProListInfo.class);
                        if (info.getStatusCode() == 1) {
                            List<ProListInfo.ProList> dataList = info.getBody();
                            mView.responseProListData(dataList);
                        } else {
                            mView.responseProListDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
