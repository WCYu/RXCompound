package com.rxjy.rxcompound.mvp.presenter;

import android.util.Log;

import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.entity.MoneyDGcJixiaoBean;
import com.rxjy.rxcompound.mvp.contract.MoneyDGcContract;
import com.rxjy.rxcompound.mvp.model.MoneyDGcModel;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by hjh on 2018/3/19.
 */

public class MoneyDGcPresenter extends MoneyDGcContract.Presenter{

    public MoneyDGcPresenter(MoneyDGcContract.View mView) {
        this.mView = mView;
        mModel = new MoneyDGcModel();
    }

    @Override
    public void getgcjixiaodata(String year, String month, String cardNo) {
        Subscription subscribe = mModel.getgcjixiaodata(year, month, cardNo)
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
                        MoneyDGcJixiaoBean info = JSONUtils.toObject(s, MoneyDGcJixiaoBean.class);
                        if (info.getStatusCode() == 0) {
                            mView.responsegcjixiaodata(info);
                        } else {
                            mView.responsegcjixiaodataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void getgcchuangshoudata(String year, String month, String cardNo) {
        Subscription subscribe = mModel.getgcchuangshoudata(year, month, cardNo)
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
                        MoneyDGcJixiaoBean info = JSONUtils.toObject(s, MoneyDGcJixiaoBean.class);
                        if (info.getStatusCode() == 0) {
                            mView.responsegcchuangshoudata(info);
                        } else {
                            mView.responsegcchuangshoudataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
