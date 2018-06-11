package com.rxjy.rxcompound.mvp.presenter;

import android.util.Log;

import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.entity.AdRedEnvelopesBean;
import com.rxjy.rxcompound.entity.FindBean;
import com.rxjy.rxcompound.entity.NumberPackets;
import com.rxjy.rxcompound.entity.UserStatusBean;
import com.rxjy.rxcompound.mvp.contract.GetUserStatusContract;
import com.rxjy.rxcompound.mvp.model.GetUserStatusModel;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by hjh on 2017/11/20.
 */

public class GetUserStatusPresenter extends GetUserStatusContract.Presenter{

    public GetUserStatusPresenter(GetUserStatusContract.View mView) {
        this.mView = mView;
        mModel = new GetUserStatusModel();
    }

    @Override
    public void getUserStatus(String cardNo) {
        Subscription subscribe = mModel.getUserStatus(cardNo)
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
                        Log.e("", " = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("状态sss",s.toString());
                        UserStatusBean info = JSONUtils.toObject(s, UserStatusBean.class);
                        mView.responseUserStatus(info);
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void getRedTask(String cardNo) {
        Subscription subscribe = mModel.getRedTask(cardNo)
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
                        Log.e("RedTaskPresenter", "获取红包列表是否存在失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("RedTaskPresenter",s);
                        NumberPackets info = JSONUtils.toObject(s, NumberPackets.class);
                        if(info.getStatusCode()==0){//
                            mView.responseTaskData(info.getBody());
                        }else if(info.getStatusCode()==-1){
                            mView.responseUserStatusError(info.getStatusMsg());
                        }

                    }
                });
        addSubscribe(subscribe);
    }
}
