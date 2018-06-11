package com.rxjy.rxcompound.mvp.presenter;

import android.util.Log;

import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.entity.BankBean;
import com.rxjy.rxcompound.entity.ImageDesBean;
import com.rxjy.rxcompound.entity.ImgBean;
import com.rxjy.rxcompound.entity.ResultBean;
import com.rxjy.rxcompound.mvp.contract.DesEnterJobContract;
import com.rxjy.rxcompound.mvp.model.DesEnterJobModel;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by hjh on 2018/4/21.
 */

public class DesEnterJobPresenter extends DesEnterJobContract.Presenter{

    public DesEnterJobPresenter(DesEnterJobContract.View mView) {
        this.mView = mView;
        mModel = new DesEnterJobModel();
    }

    @Override
    public void updateDesJobMessage(String card_no, String Type, String bank_name, String bank_card, String bank_user_name,int bank_user_branch) {
        Subscription subscribe = mModel.updateDesJobMessage(card_no, Type, bank_name, bank_card, bank_user_name,bank_user_branch)
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
                            mView.responseDesJobMessage(info);
                        } else {
                            mView.responseDesJobMessageError(info.getStatusMsg());
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
                        if(info.getStatusCode()==0){
                            mView.responseBankMessage(info);
                        }else{
                            mView.responseBankMessageError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
