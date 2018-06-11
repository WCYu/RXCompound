package com.rxjy.rxcompound.mvp.presenter;

import android.util.Log;

import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.commons.utils.StringUtils;
import com.rxjy.rxcompound.entity.InfoMessageBean;
import com.rxjy.rxcompound.entity.JiFenBean;
import com.rxjy.rxcompound.mvp.contract.JiFenZAContract;
import com.rxjy.rxcompound.mvp.model.JiFenZAModel;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by hjh on 2018/4/2.
 */

public class JiFenZAPresenter extends JiFenZAContract.Presenter {

    public JiFenZAPresenter(JiFenZAContract.View view) {
        this.mView = view;
        mModel = new JiFenZAModel();
    }

    @Override
    public void getMessage(String cardNo) {
        Subscription subscribe = mModel.getMessage(cardNo)
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
                        Log.e("", "获取通知数据sss失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("通知数据sss", s.toString());
                        JiFenBean info = JSONUtils.toObject(s, JiFenBean.class);
                        if (info.getStatusCode() == 0) {
                            mView.responsegetMessage(info);
                        } else {
                            mView.responsegetMessageError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
