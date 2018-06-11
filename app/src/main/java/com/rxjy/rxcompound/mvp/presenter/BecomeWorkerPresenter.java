package com.rxjy.rxcompound.mvp.presenter;

import android.util.Log;

import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.entity.BecomeBean;
import com.rxjy.rxcompound.entity.BeconmeConditionsBean;
import com.rxjy.rxcompound.entity.LeaveBean;
import com.rxjy.rxcompound.mvp.contract.BecomeWorkerContract;
import com.rxjy.rxcompound.mvp.contract.LeaveContract;
import com.rxjy.rxcompound.mvp.model.BecomeWorkerModel;
import com.rxjy.rxcompound.mvp.model.LeaveModel;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by asus on 2018/5/18.
 */

public class BecomeWorkerPresenter extends BecomeWorkerContract.Presenter {
    public static final String TAG = "BecomeWorkerPresenter";

    public BecomeWorkerPresenter(BecomeWorkerContract.View mView) {
        this.mView = mView;
        mModel = new BecomeWorkerModel();
    }
    @Override
    public void getSubmitBecome(String CardNo, String Reason1, String Reason2) {
        Subscription subscribe = mModel.getSubmitBecome(CardNo,Reason1,Reason2)
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
                        Log.e(TAG, "获取转正是否失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        //Log.e(TAG, "获取转正是否失败 = " + e.toString());
                        BecomeBean info = JSONUtils.toObject(s, BecomeBean.class);
                        if(info.getStatusCode()==0){
                           mView.responseBeconmeData(info);
                        }else {
                           mView.responseBecomeDataError(info.getStatusMsg());
                        }

                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void getSubmitConditions(String CardNo) {
        Subscription subscribe = mModel.getSubmitConditions(CardNo)
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
                        Log.e(TAG, "获取转正是否失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {

                        BeconmeConditionsBean info = JSONUtils.toObject(s, BeconmeConditionsBean.class);
                        if(info.getStatusCode()==0){
                             mView.responseBeconmeConditions(info.getBody());
                        }else {
                            mView.responseBecomeDataError(info.getStatusMsg());
                        }

                    }
                });
        addSubscribe(subscribe);
    }
}
