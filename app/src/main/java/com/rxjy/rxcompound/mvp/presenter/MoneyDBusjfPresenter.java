package com.rxjy.rxcompound.mvp.presenter;

import android.util.Log;

import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.entity.MoneyDBusJFBean;
import com.rxjy.rxcompound.entity.MoneyDBusJFKQMoreBean;
import com.rxjy.rxcompound.mvp.contract.MoneyDBusjfContract;
import com.rxjy.rxcompound.mvp.model.MoneyDBusjfModel;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by hjh on 2018/4/11.
 */

public class MoneyDBusjfPresenter extends MoneyDBusjfContract.Presenter{

    public MoneyDBusjfPresenter(MoneyDBusjfContract.View mView) {
        this.mView = mView;
        mModel = new MoneyDBusjfModel();
    }

    @Override
    public void getbuskqdata(String year, String month, String cardNo) {
        Subscription subscribe = mModel.getbuskqdata(year, month, cardNo)
                .subscribe(new Subscriber<String>() {

                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        MoneyDBusJFBean info = JSONUtils.toObject(s, MoneyDBusJFBean.class);
                        if (info.getStatusCode() == 0) {
                            mView.responsebuskqdata(info);
                        } else {
                            mView.responsebuskqdataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void getbuskqmoredata(String year, String month, String cardNo) {
        Subscription subscribe = mModel.getbuskqmoredata(year, month, cardNo)
                .subscribe(new Subscriber<String>() {

                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        MoneyDBusJFKQMoreBean info = JSONUtils.toObject(s, MoneyDBusJFKQMoreBean.class);
                        if (info.getStatusCode() == 0) {
                            mView.responsebuskqmoredata(info);
                        } else {
                            mView.responsebuskqmoredataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
