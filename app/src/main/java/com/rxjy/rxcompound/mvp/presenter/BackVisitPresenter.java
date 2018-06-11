package com.rxjy.rxcompound.mvp.presenter;

import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.des.entity.SubInfo;
import com.rxjy.rxcompound.mvp.contract.BackVisitContract;
import com.rxjy.rxcompound.mvp.model.BackVisitModel;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by hjh on 2018/4/4.
 */

public class BackVisitPresenter extends BackVisitContract.Presenter {

    public BackVisitPresenter(BackVisitContract.View mView) {
        this.mView = mView;
        mModel = new BackVisitModel();
    }

    @Override
    public void addHuiFangData(String rwdId, String content, int methods) {
        Subscription subscribe = mModel.addHuiFangData(rwdId, content, methods)
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
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        SubInfo info = JSONUtils.toObject(s, SubInfo.class);
                        if (info.getStatusCode() == 0) {
                            mView.responseTalkData();
                        } else {
                            mView.responseTalkDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}

