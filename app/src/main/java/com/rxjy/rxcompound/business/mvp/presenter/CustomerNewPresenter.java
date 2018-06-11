package com.rxjy.rxcompound.business.mvp.presenter;

import com.rxjy.rxcompound.business.entity.CustomerNewBean;
import com.rxjy.rxcompound.business.mvp.contract.CustomerNewContract;
import com.rxjy.rxcompound.business.mvp.model.CustomerNewModel;
import com.rxjy.rxcompound.commons.utils.JSONUtils;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by hjh on 2018/5/11.
 */

public class CustomerNewPresenter extends CustomerNewContract.Presenter{

    public CustomerNewPresenter(CustomerNewContract.View view) {
        this.mView = view;
        mModel = new CustomerNewModel();
    }

    @Override
    public void getCustomer(String card, String PageSize, String pageIndex) {
        Subscription subscribe = mModel.getCustomer(card, PageSize, pageIndex)
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
                        CustomerNewBean info = JSONUtils.toObject(s, CustomerNewBean.class);
                        if (info.getStatusMsg().equals("请求成功")) {
                            mView.responsegetCustomer(info);
                        } else {
                            mView.responsegetCustomerError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void getCustomerMore(String card, String PageSize, String pageIndex) {
        Subscription subscribe = mModel.getCustomer(card, PageSize, pageIndex)
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
                        CustomerNewBean info = JSONUtils.toObject(s, CustomerNewBean.class);
                        if (info.getStatusMsg().equals("请求成功")) {
                            mView.responsegetCustomerMore(info);
                        } else {
                            mView.responsegetCustomerMoreError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}