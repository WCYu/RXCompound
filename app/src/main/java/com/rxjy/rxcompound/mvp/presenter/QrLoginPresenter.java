package com.example.asus.customer.mvp.presenter;

import android.util.Log;

import com.example.asus.customer.commons.utils.JSONUtils;
import com.example.asus.customer.entity.CheckInfo;
import com.example.asus.customer.entity.RecommendBean;
import com.example.asus.customer.mvp.contract.NjjContract;
import com.example.asus.customer.mvp.contract.QrLoginContract;
import com.example.asus.customer.mvp.model.NjjModel;
import com.example.asus.customer.mvp.model.QrLoginModel;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by asus on 2018/5/30.
 */

public class QrLoginPresenter extends QrLoginContract.Presenter {
    public static final String TAG = "NjjPresenter";

    public QrLoginPresenter(QrLoginContract.View mView) {
        this.mView = mView;
        mModel = new QrLoginModel();
    }
    @Override
    public void getRrLogin(String cardNo, String password, String loginId) {
        Subscription subscribe = mModel.getRrLogin(cardNo,password,loginId)
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
                        CheckInfo picture = JSONUtils.toObject(s, CheckInfo.class);

                            mView.getRrLoginData(picture);

                    }
                });
        addSubscribe(subscribe);
    }
}
