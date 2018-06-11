package com.rxjy.rxcompound.mvp.presenter;

import android.util.Log;

import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.commons.utils.StringUtils;
import com.rxjy.rxcompound.entity.MessageDetailsBean;
import com.rxjy.rxcompound.mvp.contract.MessageDetailsContract;
import com.rxjy.rxcompound.mvp.model.MessageDetailsModel;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by hjh on 2018/3/9.
 */

public class MessageDetailsPresenter extends MessageDetailsContract.Presenter {

    public MessageDetailsPresenter(MessageDetailsContract.View view) {
        this.mView = view;
        mModel = new MessageDetailsModel();
    }

    @Override
    public void getInfoMessageDList(String Id) {
        Subscription subscribe = mModel.getInfoMessageDList(Id)
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
                        Log.e("通知数据iddsss",s.toString());
                        MessageDetailsBean info = JSONUtils.toObject(s, MessageDetailsBean.class);
                        if (info.getStatusCode() == 0) {
                            if(!StringUtils.isEmpty(info.getBody())){
                                mView.responseInfoMessageD(info);
                            }else{
                                Log.e("暂无数据。。。","!!!!!");
                            }
                        } else {
                            mView.responseInfoMessageDError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
