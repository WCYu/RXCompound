package com.rxjy.rxcompound.activity.guwen;

import android.util.Log;

import com.rxjy.rxcompound.utils.JSONUtils;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by Administrator on 2018/5/30.
 */

public class DownLinePresenter extends DownLineContract.Presenter{

    public DownLinePresenter(DownLineContract.View mView) {
        this.mView = mView;
        mModel = new DownLineModel();
    }

    @Override
    public void getDownLineList(String card) {
        Subscription subscribe = mModel.getClientList(card)
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

                        mView.lodeDateErr(e.toString());
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("lrj+","=============="+s);
                        DownLineBean downLineBean = JSONUtils.toObject(s, DownLineBean.class);
                        mView.lodeDate(downLineBean);
                    }
                });
        addSubscribe(subscribe);
    }
}
