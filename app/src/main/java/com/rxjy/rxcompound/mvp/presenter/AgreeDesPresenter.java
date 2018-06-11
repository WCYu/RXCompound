package com.rxjy.rxcompound.mvp.presenter;

import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.entity.ResultBean;
import com.rxjy.rxcompound.mvp.contract.AgreeDesContract;
import com.rxjy.rxcompound.mvp.model.AgreeDesModel;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by hjh on 2018/4/21.
 */

public class AgreeDesPresenter extends AgreeDesContract.Presenter{

    public AgreeDesPresenter(AgreeDesContract.View mView) {
        this.mView = mView;
        mModel = new AgreeDesModel();
    }

    @Override
    public void getAgreeYes(String cardno, String type) {
        Subscription subscribe = mModel.getAgreeYes(cardno, type)
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
                        ResultBean info = JSONUtils.toObject(s, ResultBean.class);
                        if (info.getStatusCode() == 0) {
                            mView.responseAgreeYes(info);
                        } else {
                            mView.responseAgreeYesError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}