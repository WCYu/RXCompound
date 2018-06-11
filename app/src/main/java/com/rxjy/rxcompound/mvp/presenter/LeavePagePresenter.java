package com.rxjy.rxcompound.mvp.presenter;

import android.util.Log;

import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.entity.LeaveBean;
import com.rxjy.rxcompound.entity.LeaveSubmitBean;
import com.rxjy.rxcompound.entity.LeaveTypeBean;
import com.rxjy.rxcompound.mvp.contract.LeaveContract;
import com.rxjy.rxcompound.mvp.contract.LeavePageContract;
import com.rxjy.rxcompound.mvp.model.LeaveModel;
import com.rxjy.rxcompound.mvp.model.LeavePageModel;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by asus on 2018/5/17.
 */

public class LeavePagePresenter extends LeavePageContract.Presenter {
    public static final String TAG = "LoginPresenter";

    public LeavePagePresenter(LeavePageContract.View mView) {
        this.mView = mView;
        mModel = new LeavePageModel();
    }
    @Override
    public void getLeaveData() {
        Subscription subscribe = mModel.getLeavePageTypeData()
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

                        LeaveTypeBean info = JSONUtils.toObject(s, LeaveTypeBean.class);
                        if(info.getStatusCode()==0){
                            mView.getLeavePageTypeData(info.getBody());
                        }else {
                            mView.showMessage(info.getStatusMsg());
                        }

                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void getpplyAttendance(String cardno, String beginTime, String endTime, String days, String reason, int vacationState) {
        Subscription subscribe = mModel.getpplyAttendance(cardno,beginTime,endTime,days,reason,vacationState)
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
                        Log.e(TAG, "获取失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e(TAG, "获取成功 = " + s);
                        LeaveSubmitBean info = JSONUtils.toObject(s, LeaveSubmitBean.class);
                        if(info.getStatusCode()==0){
                            mView.loadLeaveSubmit(info);
                        }else {
                            mView.showMessage(info.getStatusMsg());
                        }

                    }
                });
        addSubscribe(subscribe);
    }
}
