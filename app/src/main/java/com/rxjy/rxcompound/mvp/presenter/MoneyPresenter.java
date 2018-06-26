package com.rxjy.rxcompound.mvp.presenter;

import android.util.Log;

import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.entity.HospitalBean;
import com.rxjy.rxcompound.entity.MoneyBean;
import com.rxjy.rxcompound.entity.MoneyBusBean;
import com.rxjy.rxcompound.entity.MoneyBusNewBean;
import com.rxjy.rxcompound.entity.MoneyDesBean;
import com.rxjy.rxcompound.entity.MoneySupBean;
import com.rxjy.rxcompound.entity.MoneyTzBean;
import com.rxjy.rxcompound.mvp.contract.MoneyContract;
import com.rxjy.rxcompound.mvp.model.MoneyModel;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by hjh on 2018/3/2.
 */

public class MoneyPresenter extends MoneyContract.Presenter{

    public MoneyPresenter(MoneyContract.View mView) {
        this.mView = mView;
        mModel = new MoneyModel();
    }

    @Override
    public void getmoneydata(String card) {

        Subscription subscribe = mModel.getmoneydata(card)
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
                        Log.e("", "获取钱包信息 = " + s);
                        MoneyBean info = JSONUtils.toObject(s, MoneyBean.class);
                        if (info.getStatusCode() == 0) {
                            mView.responsemoneydata(info);
                        } else {
                            mView.responsemoneydataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);

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
                        Log.e("", "获取版本信息失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        MoneyBusBean info = JSONUtils.toObject(s, MoneyBusBean.class);
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
    public void getbusmoneynewdata(String year, String month, String cardNo) {
        Subscription subscribe = mModel.getbusmoneynewdata(year, month, cardNo)
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
                        Log.e("tag_钱包信息",s);
                        MoneyBusNewBean info = JSONUtils.toObject(s, MoneyBusNewBean.class);
                        if (info.getStatusCode() == 0) {
                            mView.responsebusmoneynewdata(info);
                        } else {
                            mView.responsebusmoneynewdataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void getdesmoneydata(String year, String month, String cardNo) {
        Subscription subscribe = mModel.getdesmoneydata(year, month, cardNo)
                .subscribe(new Subscriber<String>() {

                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("", "获取版本信息失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("tag_钱包信息",s);
                        MoneyDesBean info = JSONUtils.toObject(s, MoneyDesBean.class);
                        if (info.getStatusCode() == 0) {
                            mView.responsedesmoneydata(info);
                        } else {
                            mView.responsedesmoneydataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void getgcmoneydata(String year, String month, String cardNo) {
        Subscription subscribe = mModel.getgcmoneydata(year, month, cardNo)
                .subscribe(new Subscriber<String>() {

                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("", "获取版本信息失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("tag_钱包信息",s);
                        MoneySupBean info = JSONUtils.toObject(s, MoneySupBean.class);
                        if (info.getStatusCode() == 0) {
                            mView.responsegcmoneydata(info);
                        } else {
                            mView.responsegcmoneydataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
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
                        Log.e("", "获取版本信息失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("tag_钱包信息",s);
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
                        Log.e("", "获取版本信息失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("tag_钱包信息",s);
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
    public void getHospitaldata(String cardNo) {
        Subscription subscribe = mModel.getHospitaldata(cardNo)
                .subscribe(new Subscriber<String>() {

                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("", "获取版本信息失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("tag_钱包信息",s);
                        HospitalBean info = JSONUtils.toObject(s, HospitalBean.class);
                        if (info.getStatusCode() == 0) {
                            mView.responseHospitalSalary(info.getBody());
                        } else {
                            mView.responsexzmoneydataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}