package com.rxjy.rxcompound.mvp.presenter;

import android.util.Log;

import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.entity.IdentityInfoBean;
import com.rxjy.rxcompound.entity.ImgBean;
import com.rxjy.rxcompound.entity.ResultBean;
import com.rxjy.rxcompound.mvp.contract.IdentityInfoContract;
import com.rxjy.rxcompound.mvp.model.IdentityInfoModel;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by hjh on 2018/5/3.
 */

public class IdentityInfoPresenter extends IdentityInfoContract.Presenter{

    public IdentityInfoPresenter(IdentityInfoContract.View mView) {
        this.mView = mView;
        mModel = new IdentityInfoModel();
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
                        Log.e("e:::",e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("---身份信息---",s);
                        IdentityInfoBean info = JSONUtils.toObject(s, IdentityInfoBean.class);
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
    public void upDataMessage(String Phone, String Type, String IdCard, String IdCardName, String Birthday, String IdCardAddress, String NowAddress, String Marriage, String Xueli) {
        Subscription subscribe = mModel.upDataMessage(Phone, Type, IdCard, IdCardName, Birthday, IdCardAddress, NowAddress, Marriage, Xueli)
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
                        ResultBean info = JSONUtils.toObject(s, ResultBean.class);
                        if (info.getStatusCode() == 0) {
                            Log.e("提交用户信息",s);
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

}