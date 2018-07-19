package com.rxjy.rxcompound.mvp.presenter;

import android.util.Log;

import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.des.entity.LHouseNumBean;
import com.rxjy.rxcompound.entity.CustomerBean;
import com.rxjy.rxcompound.mvp.contract.CustomerContract;
import com.rxjy.rxcompound.mvp.model.CustomerModel;
import rx.Subscriber;
import rx.Subscription;
/**
 * Created by asus on 2018/4/13.
 */

public class CustomerPresenter extends CustomerContract.Presenter {
    public String TAG="CustomerPresenter";
    public CustomerPresenter(CustomerContract.View mView) {
        this.mView = mView;
        mModel = new CustomerModel();
    }
    @Override
    public void loadCustomerData(String cardNo,String type) {
        Subscription subscribe = mModel.loadCustomerData(cardNo,type)
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
                        Log.e("sss",e.getMessage());
                        mView.showMessage(e.getMessage());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("tag",s);
                        CustomerBean info = JSONUtils.toObject(s, CustomerBean.class);
                        if (info.getStatusCode().equals("0")) {
                            mView.responseCustomerData(info.getBody());
                        } else {
                         //   mView.showMessage(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void GetOrderNumber(String areaid, String phone) {
        Subscription subscribe = mModel.GetOrderNumber(areaid,phone)
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
                        Log.e(TAG, "获取资料类型失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("flag", "获取数据成功 = " + s);
                        LHouseNumBean info = JSONUtils.toObject(s, LHouseNumBean.class);
                        if (info.getStatusCode() == 0) {
                            mView.loaDareaid(info);
                        } else {
                            mView.showMessage(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}

