package com.rxjy.rxcompound.mvp.presenter;

import android.util.Log;

import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.entity.AssementBean;
import com.rxjy.rxcompound.mvp.contract.JobTryAnContract;
import com.rxjy.rxcompound.mvp.model.JobTryAnModel;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by hjh on 2017/11/16.
 */

public class JobTryAnPresenter extends JobTryAnContract.Presenter {

    public JobTryAnPresenter(JobTryAnContract.View mView) {
        this.mView = mView;
        mModel = new JobTryAnModel();
    }

    @Override
    public void getGetData(String cardno, String dept, String dayIndex) {
        Subscription subscribe = mModel.getGetData(cardno,dept,dayIndex)
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
                        Log.e("", "答题详情 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("答题详情sss",s.toString());
                        AssementBean info = JSONUtils.toObject(s, AssementBean.class);
                        mView.responseGetData(info);
                    }
                });
        addSubscribe(subscribe);
    }
}
