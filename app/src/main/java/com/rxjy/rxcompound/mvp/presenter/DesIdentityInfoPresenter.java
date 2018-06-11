package com.rxjy.rxcompound.mvp.presenter;

import android.util.Log;

import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.entity.ImageDesBean;
import com.rxjy.rxcompound.entity.ImgBean;
import com.rxjy.rxcompound.entity.ResultBean;
import com.rxjy.rxcompound.mvp.contract.DesIdentityInfoContract;
import com.rxjy.rxcompound.mvp.model.DesIdentityInfoModel;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by hjh on 2018/4/21.
 */

public class DesIdentityInfoPresenter extends DesIdentityInfoContract.Presenter{

    public DesIdentityInfoPresenter(DesIdentityInfoContract.View mView) {
        this.mView = mView;
        mModel = new DesIdentityInfoModel();
    }
    @Override
    public void updateDesIdentityMessage(String card_no, String Type, String phone, String nick_name, String sex, String id_card, String birthday, String living_place, String education, String email) {
        Subscription subscribe = mModel.updateDesIdentityMessage(card_no, Type, phone, nick_name, sex, id_card, birthday, living_place, education, email)
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
                            mView.responseDesIdentityMessage(info);
                        } else {
                            mView.responseDesIdentityMessageError(info.getStatusMsg());
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
                        Log.e("", "获取检查是否存在失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("上传图片。。。。。",s);
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