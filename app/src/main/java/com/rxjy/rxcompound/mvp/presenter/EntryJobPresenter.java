package com.rxjy.rxcompound.mvp.presenter;

import android.content.Intent;
import android.util.Log;

import com.rxjy.rxcompound.activity.BaseInformationActivity;
import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.entity.CheckIsBeingBean;
import com.rxjy.rxcompound.entity.ResultBean;
import com.rxjy.rxcompound.mvp.contract.EntryJobPContract;
import com.rxjy.rxcompound.mvp.model.EntryJobPModel;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by hjh on 2017/11/10.
 */

public class EntryJobPresenter extends EntryJobPContract.Presenter{

    public EntryJobPresenter(EntryJobPContract.View mView) {
        this.mView = mView;
        mModel = new EntryJobPModel();
    }


    @Override
    public void getConsent(String cardNo, String Type) {
        Subscription subscribe = mModel.getConsent(cardNo,Type)
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
                        Log.e("", "获取检查是否存在失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("同意入职协议",s);
                        CheckIsBeingBean info = JSONUtils.toObject(s, CheckIsBeingBean.class);
                        if(info.getStatusCode()==0){//同意
                            mView.responseConsent(info);
                        }else if(info.getStatusCode()==-1){
                            mView.responseConsentError(info.getStatusMsg());
                        }

                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void getEntryJob(String cardNo) {
        Subscription subscribe = mModel.getEntryJob(cardNo)
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
                        Log.e("", "获取检查是否存在失败 = " + e.toString());
                        mView.responseEntryJobError("网络不给力！");
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("同意入职协议ddddd",s);
                        CheckIsBeingBean info = JSONUtils.toObject(s, CheckIsBeingBean.class);
                        if(info.getStatusCode()==0){//同意
                            mView.responseEntryJob(info);
                        }else if(info.getStatusCode()==-1){
                            mView.responseEntryJobError(info.getStatusMsg());
                        }

                    }
                });
        addSubscribe(subscribe);

    }

    @Override
    public void getIsConsent(String CardNo, String Type) {
        Subscription subscribe = mModel.getIsConsent(CardNo,Type)
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
                        Log.e("", "获取检查是否存在失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        ResultBean info = JSONUtils.toObject(s, ResultBean.class);
                        if (info.getStatusCode() == 0) {//已同意
                            mView.responseIsConsent(info);
                        } else {//未同意
                            mView.responseIsConsentError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
