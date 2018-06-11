package com.rxjy.rxcompound.joinin.mvp.presenter;

import android.util.Log;

import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.entity.CheckIsBeingBean;
import com.rxjy.rxcompound.entity.ResultBean;
import com.rxjy.rxcompound.joinin.mvp.contract.AnswerContract;
import com.rxjy.rxcompound.joinin.mvp.model.AnswerModel;
import com.rxjy.rxcompound.mvp.contract.AgreeDesContract;
import com.rxjy.rxcompound.mvp.model.AgreeDesModel;

import org.json.JSONException;
import org.json.JSONObject;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by asus on 2018/5/31.
 */

public class AnswerPresenter extends AnswerContract.Presenter {
    public AnswerPresenter(AnswerContract.View mView) {
        this.mView = mView;
        mModel = new AnswerModel();
    }

    @Override
    public void getAgreeYes(String card, String arr) {
        Subscription subscribe = mModel.getAgreeYes(card, arr)
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
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("qq", s);
                        ResultBean info = JSONUtils.toObject(s, ResultBean.class);
                        if (info.getStatusCode() == 0) {
                            mView.responseAgreeYes();
                        } else {
                            mView.responseConsentError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void getConsent(String cardNo, String Type) {
        Subscription subscribe = mModel.getConsent(cardNo, Type)
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
                        Log.e("tag", "获取检查是否存在失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("tag", s);
                        try {
                            JSONObject jsonObject = new JSONObject(s);
                            int statusCode = jsonObject.getInt("StatusCode");
                            if (statusCode == 0) {
                                    mView.showToast();
                            } else {
                                Log.e("tag","------------");
                                mView.responseConsentError(jsonObject.getString("StatusMsg"));
                            }

                        } catch (JSONException e) {
                            Log.e("tag",e.getMessage());
                            e.printStackTrace();
                        }

                    }
                });
        addSubscribe(subscribe);
    }
}
