package com.rxjy.rxcompound.mvp.presenter;

import android.util.Log;

import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.entity.CheckIsBeingBean;
import com.rxjy.rxcompound.entity.PersonBean;
import com.rxjy.rxcompound.entity.UserStatusBean;
import com.rxjy.rxcompound.entity.VPhoneBean;
import com.rxjy.rxcompound.entity.ZiDonBean;
import com.rxjy.rxcompound.mvp.contract.LoginContract;
import com.rxjy.rxcompound.mvp.model.LoginModel;

import org.json.JSONException;
import org.json.JSONObject;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by hjh on 2017/11/3.
 */

public class LoginPresenter  extends LoginContract.Presenter {
    public static final String TAG = "LoginPresenter";

    public LoginPresenter(LoginContract.View mView) {
        this.mView = mView;
        mModel = new LoginModel();
    }

    @Override
    public void getCheckIsVerity(String cardNo) {
        Subscription subscribe = mModel.getCheckIsVerity(cardNo)
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
                        mView.responseIsConsentError("连接失败");
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("tag",s);
                        VPhoneBean info = JSONUtils.toObject(s, VPhoneBean.class);
                        mView.responseIsCheck(info);
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void getVerityCode(String cardNo) {
        Subscription subscribe = mModel.getVerityCode(cardNo)
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
                        Log.e(TAG, " = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        CheckIsBeingBean info = JSONUtils.toObject(s, CheckIsBeingBean.class);
                        mView.responseVerityCode(info);

                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void tologin(String cardNo, String verityCode, String pwd) {
        Subscription subscribe = mModel.tologin(cardNo,verityCode,pwd)
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
                        Log.e(TAG, " = " + e.toString());
                        mView.responseLoginError("自动登录失败!");
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("sssss登录返回",s.toString());
                        CheckIsBeingBean info = JSONUtils.toObject(s, CheckIsBeingBean.class);
                        if (info.getStatusCode() == 0) {
                            mView.responseLogin(info);
                        } else {
                            mView.responseLoginError(info.getStatusMsg());
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
                        Log.e("tag", "获取检查是否存在失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                          Log.e("tag_是否",s);
                        CheckIsBeingBean info = JSONUtils.toObject(s, CheckIsBeingBean.class);
                        if (info.getStatusCode() == 0) {//已同意
                            mView.responseIsConsent(info);
                        } else {//未同意
                            mView.responseIsConsentError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);

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
                        Log.e("aaaaa",s.toString());
                        UserStatusBean info = JSONUtils.toObject(s, UserStatusBean.class);
                        mView.responseUserStatus(info);
                    }
                });
        addSubscribe(subscribe);

    }

    @Override
    public void getIsPrefect(String Phone, String Type) {
        Subscription subscribe = mModel.getIsPrefect(Phone,Type)
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
                        mView.responseIsPrefectError("网络请求超时！");
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("是否完善资料sss",s.toString());
                        PersonBean info = JSONUtils.toObject(s, PersonBean.class);
                        if (info.getStatusCode() == 0) {
                            mView.responseIsPrefect(info);
                        } else {
                            mView.responseIsPrefectError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void getLoginTz(String cardno, String data) {
        Subscription subscribe = mModel.getLoginTz(cardno, data)
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
                        Log.e("TAG", " = " + e.toString());
                        mView.responseIsPrefectError("网络请求超时！");
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("通知请求成功！！！！！","success!");
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void getCheckToken(String CardNo, String Token) {
        Subscription subscribe = mModel.getCheckToken(CardNo, Token)
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
                        Log.e(TAG, " = " + e.toString());
                        mView.responseIsPrefectError("网络请求超时！");
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                         Log.e("tag",s);
                        try {
                            JSONObject jsonObject=new JSONObject(s);
                            JSONObject body = jsonObject.getJSONObject("Body");
                            int isResult = body.getInt("isResult");
                            if(isResult==0){
                               mView.responseTokenError("您的账号已被他人登陆，请重新登陆");
                            }else {
                                ZiDonBean info = JSONUtils.toObject(s, ZiDonBean.class);
                                if (info.getStatusCode() == 0) {
                                  //  if()
                                    mView.responseZiDonLogin(info);
                                } else {
                                    mView.responseLoginError(info.getStatusMsg());
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                });
        addSubscribe(subscribe);
    }


}
