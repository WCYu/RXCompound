package com.rxjy.rxcompound.des.mvp.presenter;

import android.util.Log;

import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.des.entity.ShopBean;
import com.rxjy.rxcompound.des.entity.TalkContractBean;
import com.rxjy.rxcompound.des.mvp.contract.ShopContract;
import com.rxjy.rxcompound.des.mvp.contract.TalkContractContract;
import com.rxjy.rxcompound.des.mvp.model.ShopModel;
import com.rxjy.rxcompound.des.mvp.model.TalkContractModel;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by asus on 2018/5/24.
 */

public class ShopPresenter extends ShopContract.Presenter {
    public ShopPresenter(ShopContract.View mView) {
        this.mView = mView;
        mModel = new ShopModel();
    }

    @Override
    public void GetShopBean(String cardNo) {
        Subscription subscribe = mModel.GetShopBean(cardNo)
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
                        ShopBean info = JSONUtils.toObject(s, ShopBean.class);
                        if (info.getStatusCode() ==200 ) {
                            mView.shopresopneData(info.getBody());
                        } else {
                            mView.showMessage(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void psotUpShopInfo(String cardNo, String image, int age, int workYears, String english, String consultation, String motto) {
        Subscription subscribe = mModel.psotUpShopInfo(cardNo,image,age,workYears,english,consultation,motto)
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
//                        ShopBean info = JSONUtils.toObject(s, ShopBean.class);
//                        if (info.getStatusCode() ==200 ) {
//                            mView.shopresopneData(info.getBody());
//                        } else {
//                            mView.showMessage(info.getStatusMsg());
//                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
