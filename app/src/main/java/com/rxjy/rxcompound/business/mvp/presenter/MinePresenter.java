package com.rxjy.rxcompound.business.mvp.presenter;

import android.util.Log;

import com.rxjy.rxcompound.business.entity.MyGradeBean;
import com.rxjy.rxcompound.business.entity.MyGradeMoneyBean;
import com.rxjy.rxcompound.business.mvp.contract.MineContract;
import com.rxjy.rxcompound.business.mvp.model.MineModel;
import com.rxjy.rxcompound.commons.utils.JSONUtils;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by hjh on 2017/11/24.
 */

public class MinePresenter extends MineContract.Presenter{

    public MinePresenter(MineContract.View view) {
        this.mView = view;
        mModel = new MineModel();
    }

    @Override
    public void getMessage(String Kahao) {

        Subscription subscribe = mModel.getMessage(Kahao)
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
                        mView.responsegetMessageError("请检查您的网络！");
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("用户成就信息：：：",s.toString());
                        MyGradeBean info = JSONUtils.toObject(s, MyGradeBean.class);
                        if (info.getStatusCode() == 0) {//已同意
                            mView.responsegetMessage(info);
                        } else {//未同意
                            mView.responsegetMessageError(info.getStatusMsg());
                        }

                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void getGradeMessage(String Kahao) {
        Subscription subscribe = mModel.getGradeMessage(Kahao)
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
                        mView.responsegetMessageError("请检查您的网络！");
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("用户成就信息ddddd：：：",s.toString());
                        MyGradeMoneyBean info = JSONUtils.toObject(s, MyGradeMoneyBean.class);
                        if (info.getStatusCode() == 0) {//已同意
                            mView.responsegetGradeMessage(info);
                        } else {//未同意
                            mView.responsegetGradeMessageError(info.getStatusMsg());
                        }

                    }
                });
        addSubscribe(subscribe);
    }
}
