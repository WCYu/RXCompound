package com.rxjy.rxcompound.mvp.presenter;

import android.util.Log;

import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.commons.utils.StringUtils;
import com.rxjy.rxcompound.entity.InfoMessageBean;
import com.rxjy.rxcompound.mvp.contract.InfoMessageContract;
import com.rxjy.rxcompound.mvp.model.InfoMessageModel;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by hjh on 2017/11/22.
 */

public class InfoMessagePresenter extends InfoMessageContract.Presenter{

    public InfoMessagePresenter(InfoMessageContract.View view) {
        this.mView = view;
        mModel = new InfoMessageModel();
    }

    @Override
    public void getInfoMessageList(String cardNo) {
        Subscription subscribe = mModel.getInfoMessageList(cardNo)
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
                        Log.e("通知数据sss",s.toString());
                        InfoMessageBean info = JSONUtils.toObject(s, InfoMessageBean.class);
                        if (info.getStatusCode() == 0) {
                            if(!StringUtils.isEmpty(info.getBody())){
                                mView.responseInfoMessage(info);
                            }else{
                               Log.e("暂无数据。。。","!!!!!");
                            }
                        } else {
                            mView.responseInfoMessageError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);

    }

    @Override
    public void toSeeDetails(String id) {
        Subscription subscribe = mModel.toSeeDetails(id)
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
                        Log.e("", "获取查看sss失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("查看sss",s.toString());
//                        InfoMessageBean info = JSONUtils.toObject(s, InfoMessageBean.class);
//                        if (info.getStatusCode() == 0) {
//                            if(!StringUtils.isEmpty(info.getBody())){
//                                mView.responseInfoMessage(info);
//                            }else{
//                                Log.e("暂无数据。。。","!!!!!");
//                            }
//
//                        } else {
//                            mView.responseInfoMessageError(info.getStatusMsg());
//                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
