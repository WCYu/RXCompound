package com.rxjy.rxcompound.business.mvp.presenter;

import android.util.Log;


import com.rxjy.rxcompound.business.entity.StatusBean;
import com.rxjy.rxcompound.business.mvp.contract.CustomerFollowContract;
import com.rxjy.rxcompound.business.mvp.model.CustomerFollowModel;
import com.rxjy.rxcompound.commons.utils.JSONUtils;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by hjh on 2017/11/30.
 */

public class CustomerFollowPresenter extends CustomerFollowContract.Presenter{

    public CustomerFollowPresenter(CustomerFollowContract.View view) {
        this.mView = view;
        mModel = new CustomerFollowModel();
    }

    @Override
    public void addCustomervisit(int KeHuBaseID, int salesmanid, String content, int areaid, String nexttime, int status) {
        Subscription subscribe = mModel.addCustomervisit(KeHuBaseID,salesmanid,content,areaid,nexttime,status)
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
                        mView.responsegetaddCustomerVError("请检查您的网络！");
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("回访客户信息：：：",s.toString());
                        StatusBean info = JSONUtils.toObject(s, StatusBean.class);
                        if (info.getStatusCode() == 0) {
                            mView.responsegetaddCustomerV(info);
                        } else {//未同意
                            mView.responsegetaddCustomerVError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
