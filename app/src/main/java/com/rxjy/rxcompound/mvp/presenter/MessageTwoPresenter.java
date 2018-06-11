package com.rxjy.rxcompound.mvp.presenter;

import android.util.Log;
import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.commons.utils.StringUtils;
import com.rxjy.rxcompound.entity.InfoMessageBean;
import com.rxjy.rxcompound.mvp.contract.MessageTwoContract;
import com.rxjy.rxcompound.mvp.model.MessageTwoModel;
import rx.Subscriber;
import rx.Subscription;

/**
 * Created by hjh on 2018/3/9.
 */
public class MessageTwoPresenter extends MessageTwoContract.Presenter{

    public MessageTwoPresenter(MessageTwoContract.View view) {
        this.mView = view;
        mModel = new MessageTwoModel();
    }

    @Override
    public void getInfoMessageTwoList(String cardNo, String Group) {
        Subscription subscribe = mModel.getInfoMessageTwoList(cardNo,Group)
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
                                mView.responseInfoMessageTwo(info);
                            }else{
                                Log.e("暂无数据。。。","!!!!!");
                            }
                        } else {
                            mView.responseInfoMessageTwoError(info.getStatusMsg());
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
                    }
                });
        addSubscribe(subscribe);
    }
}