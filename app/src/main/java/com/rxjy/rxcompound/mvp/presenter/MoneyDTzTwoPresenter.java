package com.rxjy.rxcompound.mvp.presenter;

import android.util.Log;

import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.entity.BusMoneyBean;
import com.rxjy.rxcompound.entity.MoneyBusHisBean;
import com.rxjy.rxcompound.entity.MoneyDTzFenhongBean;
import com.rxjy.rxcompound.entity.MoneyDTzRewardBean;
import com.rxjy.rxcompound.entity.MoneyDZaRewardBean;
import com.rxjy.rxcompound.mvp.contract.MoneyDTzTwoContract;
import com.rxjy.rxcompound.mvp.model.MoneyDTzTwoModel;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by hjh on 2018/3/15.
 */

public class MoneyDTzTwoPresenter extends MoneyDTzTwoContract.Presenter{

    public MoneyDTzTwoPresenter(MoneyDTzTwoContract.View mView) {
        this.mView = mView;
        mModel = new MoneyDTzTwoModel();
    }

    @Override
    public void getbusmoneydata(String year, String month, String cardNo) {
        Subscription subscribe = mModel.getbusmoneydata(year, month, cardNo)
                .subscribe(new Subscriber<String>() {

                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("", "获取钱包信息失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("商务工资：：",s);
                        BusMoneyBean info = JSONUtils.toObject(s, BusMoneyBean.class);
                        if (info.getStatusCode() == 0) {
                            mView.responsebusmoneydata(info);
                        } else {
                            mView.responsebusmoneydataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void getbusmhisdata(String diqu, String cardNo) {
        Subscription subscribe = mModel.getbusmhisdata(diqu, cardNo)
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
                        MoneyBusHisBean info = JSONUtils.toObject(s, MoneyBusHisBean.class);
                        if (info.getStatusCode() == 0) {
                            mView.responsebushisdata(info);
                        } else {
                            mView.responsebushisdataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void gettzfenhongdata(String year, String month, String cardNo) {
        Subscription subscribe = mModel.gettzfenhongdata(year, month, cardNo)
                .subscribe(new Subscriber<String>() {

                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("", "获取钱包信息失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("商务工资：：",s);
                        MoneyDTzFenhongBean info = JSONUtils.toObject(s, MoneyDTzFenhongBean.class);
                        if (info.getStatusCode() == 0) {
                            mView.responsetzfenhongdata(info);
                        } else {
                            mView.responsetzfenhongdataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void gettzrewarddata(String year, String month, String cardNo) {
        Subscription subscribe = mModel.gettzrewarddata(year, month, cardNo)
                .subscribe(new Subscriber<String>() {

                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("", "获取钱包信息失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("商务工资：：",s);
                        MoneyDTzRewardBean info = JSONUtils.toObject(s, MoneyDTzRewardBean.class);
                        if (info.getStatusCode() == 0) {
                            mView.responsetzrewarddata(info);
                        } else {
                            mView.responsetzrewarddataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void getzarewarddata(String year, String month, String cardNo) {
        Subscription subscribe = mModel.getzarewarddata(year, month, cardNo)
                .subscribe(new Subscriber<String>() {

                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("", "获取钱包信息失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        MoneyDZaRewardBean info = JSONUtils.toObject(s, MoneyDZaRewardBean.class);
                        if (info.getStatusCode() == 0) {
                            mView.responsezarewarddata(info);
                        } else {
                            mView.responsezarewarddataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
