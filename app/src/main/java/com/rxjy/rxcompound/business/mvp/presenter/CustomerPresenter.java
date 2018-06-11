package com.rxjy.rxcompound.business.mvp.presenter;

import android.util.Log;

import com.rxjy.rxcompound.business.entity.CustomerBean;
import com.rxjy.rxcompound.business.mvp.contract.CustomerContract;
import com.rxjy.rxcompound.business.mvp.model.CustomerModel;
import com.rxjy.rxcompound.commons.utils.JSONUtils;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by hjh on 2017/11/24.
 */

public class CustomerPresenter extends CustomerContract.Presenter{

    public CustomerPresenter(CustomerContract.View view) {
        this.mView = view;
        mModel = new CustomerModel();
    }

    @Override
    public void getCustomer(String card, String pageIndex, String PageSize, String key) {

        Subscription subscribe = mModel.getCustomer(card,pageIndex,PageSize,key)
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
                        mView.responsegetCustomerError("请检查您的网络！");
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("客户信息：：：",s.toString());
                        CustomerBean info = JSONUtils.toObject(s, CustomerBean.class);
                        if (info.getStatusCode() == 0) {//已同意
                            mView.responsegetCustomer(info);
                        } else {//未同意
                            mView.responsegetCustomerError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void getCustomerMore(String card, String pageIndex, String PageSize, String key) {
        Subscription subscribe = mModel.getCustomer(card,pageIndex,PageSize,key)
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
                        mView.responsegetCustomerMoreError("请检查您的网络！");
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("客户信息：：：",s.toString());
                        CustomerBean info = JSONUtils.toObject(s, CustomerBean.class);
                        if (info.getStatusCode() == 0) {//已同意
                            mView.responsegetCustomerMore(info);
                        } else {//未同意
                            mView.responsegetCustomerMoreError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
