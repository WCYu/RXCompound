package com.rxjy.rxcompound.mvp.presenter;

import android.util.Log;

import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.entity.BusMoneyBean;
import com.rxjy.rxcompound.entity.BusProcessBean;
import com.rxjy.rxcompound.entity.BusResultBean;
import com.rxjy.rxcompound.mvp.contract.MoneyDetailsContract;
import com.rxjy.rxcompound.mvp.model.MoneyDetailsModel;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by hjh on 2018/3/14.
 */

public class MoneyDetailsPresenter extends MoneyDetailsContract.Presenter{

    public MoneyDetailsPresenter(MoneyDetailsContract.View mView) {
        this.mView = mView;
        mModel = new MoneyDetailsModel();
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
    public void getbusprocessdata(String year, String month, String cardNo) {
        Subscription subscribe = mModel.getbusprocessdata(year, month, cardNo)
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
                        Log.e("商务过程：：",s);
                        BusProcessBean info = JSONUtils.toObject(s, BusProcessBean.class);
                        if (info.getStatusCode() == 0) {
                            mView.responsebusprocesdata(info);
                        } else {
                            mView.responsebusprocesdataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void getbusresultdata(String year, String month, String cardNo) {
        Subscription subscribe = mModel.getbusresultdata(year, month, cardNo)
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
                        Log.e("商务结果：：",s);
                        BusResultBean info = JSONUtils.toObject(s, BusResultBean.class);
                        if (info.getStatusCode() == 0) {
                            mView.responsebusresultdata(info);
                        } else {
                            mView.responsebusresultdataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

}
