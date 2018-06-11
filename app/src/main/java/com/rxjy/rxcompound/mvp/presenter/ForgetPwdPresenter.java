package com.rxjy.rxcompound.mvp.presenter;

import android.util.Log;

import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.entity.BaseBean;
import com.rxjy.rxcompound.entity.FindBean;
import com.rxjy.rxcompound.mvp.contract.ForgetPwdContract;
import com.rxjy.rxcompound.mvp.model.ForgetPwdModel;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by hjh on 2018/3/30.
 */

public class ForgetPwdPresenter extends ForgetPwdContract.Presenter{

    public ForgetPwdPresenter(ForgetPwdContract.View mView) {
        this.mView = mView;
        mModel = new ForgetPwdModel();
    }

    @Override
    public void getVCode(String phone) {
        Subscription subscribe = mModel.getVCode(phone)
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
                        Log.e("", "失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("sss",s.toString());
                        BaseBean info = JSONUtils.toObject(s, BaseBean.class);
                        if(info.getStatusCode()==0){
                            mView.responseVCode(info.getStatusMsg());
                        }else {
                            mView.responseVCodeError(info.getStatusMsg());
                        }
//                        mView.responseVCode();
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void toFixPwd(String phone, String newPassword, String vCode) {
        Subscription subscribe = mModel.toFixPwd(phone, newPassword, vCode)
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
                        Log.e("", "失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("sss",s.toString());
                        BaseBean info = JSONUtils.toObject(s, BaseBean.class);
                        if(info.getStatusCode()==0){
                            mView.responsetoFixPwd();
                        }else{
                            mView.responsetoFixPwdError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
