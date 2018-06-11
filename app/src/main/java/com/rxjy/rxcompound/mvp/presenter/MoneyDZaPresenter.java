package com.rxjy.rxcompound.mvp.presenter;

import android.util.Log;

import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.entity.MoneyDZaProcessBean;
import com.rxjy.rxcompound.entity.MoneyDZaResultBean;
import com.rxjy.rxcompound.entity.MoneyDZaRewardBean;
import com.rxjy.rxcompound.mvp.contract.MoneyDZaContract;
import com.rxjy.rxcompound.mvp.model.MoneyDZaModel;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by hjh on 2018/3/16.
 */

public class MoneyDZaPresenter extends MoneyDZaContract.Presenter{

    public MoneyDZaPresenter(MoneyDZaContract.View mView) {
        this.mView = mView;
        mModel = new MoneyDZaModel();
    }

    @Override
    public void getzaprocessdata(String year, String month, String cardNo) {
        Subscription subscribe = mModel.getzaprocessdata(year, month, cardNo)
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
                        MoneyDZaProcessBean info = JSONUtils.toObject(s, MoneyDZaProcessBean.class);
                        if (info.getStatusCode() == 0) {
                            mView.responsezaprocessdata(info);
                        } else {
                            mView.responsezaprocessdataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void getzaresultdata(String year, String month, String cardNo) {
        Subscription subscribe = mModel.getzaresultdata(year, month, cardNo)
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
                        MoneyDZaProcessBean info = JSONUtils.toObject(s, MoneyDZaProcessBean.class);
//                        MoneyDZaResultBean info = JSONUtils.toObject(s, MoneyDZaResultBean.class);
                        if (info.getStatusCode() == 0) {
                            mView.responsezaresultdata(info);
                        } else {
                            mView.responsezaresultdataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}