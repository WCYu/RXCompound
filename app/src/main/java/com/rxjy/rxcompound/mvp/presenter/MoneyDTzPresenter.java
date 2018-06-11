package com.rxjy.rxcompound.mvp.presenter;

import android.util.Log;

import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.entity.MoneyBusRewardBean;
import com.rxjy.rxcompound.entity.MoneyDTZRSProgressBean;
import com.rxjy.rxcompound.entity.MoneyDTZRSResultBean;
import com.rxjy.rxcompound.entity.MoneyDTzProcessBean;
import com.rxjy.rxcompound.entity.MoneyDTzResultBean;
import com.rxjy.rxcompound.mvp.contract.MoneyDTzContract;
import com.rxjy.rxcompound.mvp.model.MoneyDTzModel;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by hjh on 2018/3/15.
 */

public class MoneyDTzPresenter extends MoneyDTzContract.Presenter{

    public MoneyDTzPresenter(MoneyDTzContract.View mView) {
        this.mView = mView;
        mModel = new MoneyDTzModel();
    }

    @Override
    public void gettzresultdata(String year, String month, String cardNo) {
        Subscription subscribe = mModel.gettzresultdata(year, month, cardNo)
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
                        MoneyDTzResultBean info = JSONUtils.toObject(s, MoneyDTzResultBean.class);
                        if (info.getStatusCode() == 0) {
                            mView.responsetzresultdata(info);
                        } else {
                            mView.responsetzresultdataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void gettzprocessdata(String year, String month, String cardNo) {
        Subscription subscribe = mModel.gettzprocessdata(year, month, cardNo)
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
                        MoneyDTzProcessBean info = JSONUtils.toObject(s, MoneyDTzProcessBean.class);
                        if (info.getStatusCode() == 0) {
                            mView.responsetzprocesdata(info);
                        } else {
                            mView.responsetzprocesdataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void getbusrewarddata(String year, String month, String cardNo) {
        Subscription subscribe = mModel.getbusrewarddata(year, month, cardNo)
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
                        MoneyBusRewardBean info = JSONUtils.toObject(s, MoneyBusRewardBean.class);
                        if (info.getStatusCode() == 0) {
                            mView.responsebusrewarddata(info);
                        } else {
                            mView.responsebusrewarddataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void gettzrsresultdata(String year, String month, String cardNo) {
        Subscription subscribe = mModel.gettzrsresultdata(year, month, cardNo)
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
                        MoneyDTZRSResultBean info = JSONUtils.toObject(s, MoneyDTZRSResultBean.class);
                        if (info.getStatusCode() == 0) {
                            mView.responsetzrsresultdata(info);
                        } else {
                            mView.responsetzrsresultdataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void gettzrsprocessdata(String year, String month, String cardNo) {
        Subscription subscribe = mModel.gettzrsprocessdata(year, month, cardNo)
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
                        MoneyDTZRSProgressBean info = JSONUtils.toObject(s, MoneyDTZRSProgressBean.class);
                        if (info.getStatusCode() == 0) {
                            mView.responsetzrsprocesdata(info);
                        } else {
                            mView.responsetzrsprocesdataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

}