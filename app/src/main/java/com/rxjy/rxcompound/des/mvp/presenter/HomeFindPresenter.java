package com.rxjy.rxcompound.des.mvp.presenter;

import android.util.Log;

import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.des.entity.HomeBean;
import com.rxjy.rxcompound.des.entity.ShopBean;
import com.rxjy.rxcompound.des.mvp.contract.OnTriaHomeContract;
import com.rxjy.rxcompound.des.mvp.contract.ShopContract;
import com.rxjy.rxcompound.des.mvp.model.HomeFindModel;
import com.rxjy.rxcompound.des.mvp.model.ShopModel;
import com.rxjy.rxcompound.joinin.entity.HuanYingBean;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by asus on 2018/5/25.
 */

public class HomeFindPresenter extends OnTriaHomeContract.Presenter {
    public HomeFindPresenter(OnTriaHomeContract.View mView) {
        this.mView = mView;
        mModel = new HomeFindModel();
    }
    @Override
    public void getFindList(String cardNo) {
        Subscription subscribe = mModel.getFindList(cardNo)
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
                        mView.showMessage(e.getMessage());
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("tag",s);
                        HomeBean info = JSONUtils.toObject(s, HomeBean.class);
                        if (info.getStatusCode() ==0 ) {
                            mView.responseFindData(info);
                        } else {
                            mView.showMessage(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void getHuanYing(String cardNo) {
        Subscription subscribe = mModel.getHuanYing(cardNo)
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
                        mView.showMessage(e.getMessage());
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("tag",s);
                        HuanYingBean info = JSONUtils.toObject(s, HuanYingBean.class);
                        if (info.getStatusCode() ==0 ) {
                            mView.showHuanying(info.getBody());
                        } else {
                            mView.showMessage(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
