package com.rxjy.rxcompound.mvp.presenter;

import android.util.Log;

import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.entity.MoneyTzBean;
import com.rxjy.rxcompound.mvp.contract.MoneyTzContract;
import com.rxjy.rxcompound.mvp.model.MoneyTzModel;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by hjh on 2018/3/27.
 */

public class MoneyTzPresenter extends MoneyTzContract.Presenter{

    public MoneyTzPresenter(MoneyTzContract.View mView) {
        this.mView = mView;
        mModel = new MoneyTzModel();
    }

    @Override
    public void gettzmoneydata(String year, String month, String cardNo) {
        Subscription subscribe = mModel.gettzmoneydata(year, month, cardNo)
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
                        MoneyTzBean info = JSONUtils.toObject(s, MoneyTzBean.class);
                        if (info.getStatusCode() == 0) {
                            mView.responsetzmoneydata(info);
                        } else {
                            mView.responsetzmoneydataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void getxzmoneydata(String year, String month, String cardNo) {
        Subscription subscribe = mModel.getxzmoneydata(year, month, cardNo)
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
                        MoneyTzBean info = JSONUtils.toObject(s, MoneyTzBean.class);
                        if (info.getStatusCode() == 0) {
                            mView.responsexzmoneydata(info);
                        } else {
                            mView.responsexzmoneydataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void getkjmoneydata(String year, String month, String cardNo) {
        Subscription subscribe = mModel.getkjmoneydata(year, month, cardNo)
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
                        MoneyTzBean info = JSONUtils.toObject(s, MoneyTzBean.class);
                        if (info.getStatusCode() == 0) {
                            mView.responsexzmoneydata(info);
                        } else {
                            mView.responsexzmoneydataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void getcnmoneydata(String year, String month, String cardNo) {
        Subscription subscribe = mModel.getcnmoneydata(year, month, cardNo)
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
                        MoneyTzBean info = JSONUtils.toObject(s, MoneyTzBean.class);
                        if (info.getStatusCode() == 0) {
                            mView.responsexzmoneydata(info);
                        } else {
                            mView.responsexzmoneydataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
