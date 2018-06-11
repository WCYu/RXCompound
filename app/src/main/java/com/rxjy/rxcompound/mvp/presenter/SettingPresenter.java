package com.rxjy.rxcompound.mvp.presenter;

import android.util.Log;

import com.rxjy.rxcompound.activity.SettingActivity;
import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.entity.CheckIsBeingBean;
import com.rxjy.rxcompound.mvp.contract.SettingContract;
import com.rxjy.rxcompound.mvp.model.EntryJobPModel;
import com.rxjy.rxcompound.mvp.model.SettingModel;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by hjh on 2017/11/20.
 */

public class SettingPresenter extends SettingContract.Presenter{
    public SettingPresenter(SettingContract.View mView) {
        this.mView = mView;
        mModel = new SettingModel();
    }

    @Override
    public void getConsent(String cardNo) {
        Subscription subscribe = mModel.getConsent(cardNo)
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
}
