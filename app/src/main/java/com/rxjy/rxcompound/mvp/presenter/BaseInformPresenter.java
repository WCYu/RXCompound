package com.rxjy.rxcompound.mvp.presenter;

import android.util.Log;

import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.entity.BankBean;
import com.rxjy.rxcompound.entity.CheckIsBeingBean;
import com.rxjy.rxcompound.entity.DesBaseInfoBean;
import com.rxjy.rxcompound.entity.IconBean;
import com.rxjy.rxcompound.entity.ImgBean;
import com.rxjy.rxcompound.entity.MsgNumBean;
import com.rxjy.rxcompound.entity.PersonBean;
import com.rxjy.rxcompound.entity.ResultBean;
import com.rxjy.rxcompound.entity.UserStatusBean;
import com.rxjy.rxcompound.mvp.contract.BaseInformContract;
import com.rxjy.rxcompound.mvp.model.BaseInformModel;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by hjh on 2017/11/10.
 */

public class BaseInformPresenter extends BaseInformContract.Presenter{

    public BaseInformPresenter(BaseInformContract.View mView) {
        this.mView = mView;
        mModel = new BaseInformModel();
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
                        mView.responsegetMessageError("网络不给力！");
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("用户ssss信息：：：",s.toString());
                        PersonBean info = JSONUtils.toObject(s, PersonBean.class);
                        if (info.getStatusCode() == 0) {
                            mView.responsegetMessage(s,info);
                        } else {
                            mView.responsegetMessageError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void getUpdateMessages(String Phone, String Type, String IdCardName, String IdCard, String IdCardAddress, String NowAddress, String Birthday,String Marrary) {
        Subscription subscribe = mModel.getUpdateMessages(Phone,Type,IdCardName,IdCard,IdCardAddress,NowAddress,Birthday,Marrary)
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
                        PersonBean info = JSONUtils.toObject(s, PersonBean.class);
                        if (info.getStatusCode() == 0) {
                            mView.responseUpdateMessage(info);
                        } else {
                            mView.responseUpdateMessageError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
    @Override
    public void getUpdateMessage(String Phone, String Type, String BankName, String BankCard, String BankUserName, String UrgentPerson, String UrgentContact,String UrgentPhone) {
        Subscription subscribe = mModel.getUpdateMessage(Phone,Type,BankName,BankCard,BankUserName,UrgentPerson,UrgentContact,UrgentPhone)
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
                        PersonBean info = JSONUtils.toObject(s, PersonBean.class);
                        if (info.getStatusCode() == 0) {
                            mView.responseUpdateMessage(info);
                        } else {
                            mView.responseUpdateMessageError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void getUpdateMessage(String CardNo, String Type, String Name, String Sex, String Phone) {
        Subscription subscribe = mModel.getUpdateMessage(CardNo,Type,Name,Sex,Phone)
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
                        Log.e("返回的数据是：",s.toString());
                        PersonBean info = JSONUtils.toObject(s, PersonBean.class);
                        if (info.getStatusCode() == 0) {
                            mView.responseUpdateMessage(info);
                        } else {
                            mView.responseUpdateMessageError(info.getStatusMsg());
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
                        Log.e("", "获取检查是否存在失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("获取银行卡列表",s);
                        BankBean info = JSONUtils.toObject(s, BankBean.class);
                        mView.responseBankList(info);
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
                        Log.e("上传图片。。。。。",s);
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
    public void upLoadIcon(String cardNo, String imglist) {
        Subscription subscribe = mModel.upLoadIcon(cardNo,imglist)
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
                        Log.e("上传头像。。。。。",s);
                        IconBean info = JSONUtils.toObject(s, IconBean.class);
                        if (info.getStatusCode() == 0) {
                            mView.responseIcon(info);
                        } else {
                            mView.responseIconError(info.getStatusMsg());
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
                        Log.e("状态sss",s.toString());
                        UserStatusBean info = JSONUtils.toObject(s, UserStatusBean.class);
                        mView.responseUserStatus(info);
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void getMsgnum(String cardNo) {

        Subscription subscribe = mModel.getMsgnum(cardNo)
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
                        MsgNumBean info = JSONUtils.toObject(s, MsgNumBean.class);
                        if(info.getStatusCode() == 0){
                            mView.responseMsgStatus(info);
                        }else {
                            mView.responseMsgError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);

    }


    @Override
    public void getDesMessage(String cardNo) {

        Subscription subscribe = mModel.getDesMessage(cardNo)
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
                        DesBaseInfoBean info = JSONUtils.toObject(s, DesBaseInfoBean.class);
                        if (info.getStatusCode() == 0) {
                            mView.responseDesMessage(info);
                        } else {
                            mView.responseDesMessageError(info.getStatusMsg());
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
                        Log.e("", "获取检查是否存在失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        ResultBean info = JSONUtils.toObject(s, ResultBean.class);
                        if (info.getStatusCode() == 0) {//已同意
                            mView.responseIsConsent(info);
                        } else {//未同意
                            mView.responseIsConsentError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

}
