package com.rxjy.rxcompound.mvp.presenter;

import android.util.Log;

import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.entity.LeaveBean;
import com.rxjy.rxcompound.entity.VPhoneBean;
import com.rxjy.rxcompound.mvp.contract.LeaveContract;
import com.rxjy.rxcompound.mvp.contract.LoginContract;
import com.rxjy.rxcompound.mvp.model.LeaveModel;
import com.rxjy.rxcompound.mvp.model.LoginModel;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by asus on 2018/5/17.
 */

public class LeavePresenter extends LeaveContract.Presenter {
    public static final String TAG = "LoginPresenter";

    public LeavePresenter(LeaveContract.View mView) {
        this.mView = mView;
        mModel = new LeaveModel();
    }
    @Override
    public void getLeaveData(String CardNo, int year, int month) {
        Subscription subscribe = mModel.getLeaveData(CardNo,year,month)
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
                        Log.e(TAG, "获取检查是否存在失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e(TAG, "获取检查是否存在失败 = " + s);
                        LeaveBean info = JSONUtils.toObject(s, LeaveBean.class);
                        if(info.getStatusCode()==0){
                            mView.getLeaveData(info.getBody());
                        }else {
                            mView.showMessage(info.getStatusMsg());
                        }

                    }
                });
        addSubscribe(subscribe);
    }
}
