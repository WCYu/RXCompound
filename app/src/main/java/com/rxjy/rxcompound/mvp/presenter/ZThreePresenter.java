package com.rxjy.rxcompound.mvp.presenter;

import android.util.Log;

import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.entity.BankBean;
import com.rxjy.rxcompound.entity.ImgBean;
import com.rxjy.rxcompound.entity.ResultBean;
import com.rxjy.rxcompound.entity.ZthreeBean;
import com.rxjy.rxcompound.mvp.contract.ZThreeContract;
import com.rxjy.rxcompound.mvp.model.ZThreeModel;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by hjh on 2018/5/10.
 */

public class ZThreePresenter extends ZThreeContract.Presenter{

    public ZThreePresenter(ZThreeContract.View mView) {
        this.mView = mView;
        mModel = new ZThreeModel();
    }

    @Override
    public void getMessage(String Phone, String Type) {
        Subscription subscribe = mModel.getMessage(Phone,Type)
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
                        mView.responseMessageError("网络不给力！");
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("---入职资料---",s);
                        ZthreeBean info = JSONUtils.toObject(s, ZthreeBean.class);
                        if (info.getStatusCode() == 0) {
                            mView.responseMessage(info);
                        } else {
                            mView.responseMessageError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void upDataMessage(String Phone, String Type, String BankCard, String BankName, String BankUserName, String UrgentPerson, String UrgentPhone, String UrgentContact,int id) {
        Subscription subscribe = mModel.upDataMessage(Phone, Type, BankCard, BankName, BankUserName, UrgentPerson, UrgentPhone, UrgentContact,id)
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
                        mView.responseMessageError("网络不给力！");
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        ResultBean info = JSONUtils.toObject(s, ResultBean.class);
                        if (info.getStatusCode() == 0) {
                            mView.updateMessage();
                        } else {
                            mView.updateMessageError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void upLoadImg(String cardNo, String type, List<String> imglist) {
        Subscription subscribe = mModel.upLoadImg(cardNo,type,imglist)
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
                        ImgBean info = JSONUtils.toObject(s, ImgBean.class);
                        if (info.getStatusCode() == 0) {
                            mView.responseImg(info);
                        } else {
                            mView.responseImgError(info.getStatusMsg());
                        }

                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void getBankList() {
        Subscription subscribe = mModel.getBankList()
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
                        Log.e("获取银行卡列表",s);
                        BankBean info = JSONUtils.toObject(s, BankBean.class);
                        if (info.getStatusCode() == 0) {
                            mView.responseBankList(info);
                        }else{
                            mView.responseBankListError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}