package com.rxjy.rxcompound.mvp.presenter;


import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.entity.DesBaseInfoBean;
import com.rxjy.rxcompound.entity.ImageDesBean;
import com.rxjy.rxcompound.mvp.contract.DesBaseInfoContract;
import com.rxjy.rxcompound.mvp.model.DesBaseInfoModel;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by hjh on 2018/4/20.
 */

public class DesBaseInfoPresenter extends DesBaseInfoContract.Presenter{

    public DesBaseInfoPresenter(DesBaseInfoContract.View mView) {
        this.mView = mView;
        mModel = new DesBaseInfoModel();
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
    public void upLoadDesIdentityImg(String cardNo, String type, List<String> imglist) {
        Subscription subscribe = mModel.upLoadDesIdentityImg(cardNo, type, imglist)
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
                        ImageDesBean info = JSONUtils.toObject(s, ImageDesBean.class);
                        if (info.getStatusCode() == 0) {
                            mView.responseDesIdenImgMessage(info);
                        } else {
                            mView.responseDesIdenImgMessageError(info.getStatusMsg());
                        }

                    }
                });
        addSubscribe(subscribe);
    }
}
