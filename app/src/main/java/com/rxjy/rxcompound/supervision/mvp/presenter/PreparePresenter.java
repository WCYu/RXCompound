package com.rxjy.rxcompound.supervision.mvp.presenter;

import android.util.Log;

import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.supervision.entity.PrepareInfo;
import com.rxjy.rxcompound.supervision.mvp.contract.PrepareContract;
import com.rxjy.rxcompound.supervision.mvp.model.PrepareModel;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by AAA on 2017/11/6.
 */

public class PreparePresenter extends PrepareContract.Presenter {

    public static final String TAG = "PreparePresenter";

    public PreparePresenter(PrepareContract.View mView) {
        this.mView = mView;
        mModel = new PrepareModel();
    }

    @Override
    public void getProjectProcess(String orderNo) {
        Subscription subscribe = mModel.getProjectProcess(orderNo)
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
                        Log.e(TAG, "获取开工准备失败 = " + e.toString());
                        mView.responsePrepareDataError("请求超时");
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        PrepareInfo info = JSONUtils.toObject(s, PrepareInfo.class);
                        if (info.getStatusCode() == 1) {
                            List<PrepareInfo.PrepareGroup> dataList = info.getBody();
                            mView.responsePrepareData(dataList);
                        } else {
                            mView.responsePrepareDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
