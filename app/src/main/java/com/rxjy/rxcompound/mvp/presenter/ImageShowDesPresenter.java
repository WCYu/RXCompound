package com.rxjy.rxcompound.mvp.presenter;

import android.util.Log;

import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.entity.ImageDesBean;
import com.rxjy.rxcompound.entity.ImgBean;
import com.rxjy.rxcompound.mvp.contract.ImageShowDesContract;
import com.rxjy.rxcompound.mvp.model.ImageShowDesModel;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by hjh on 2018/4/21.
 */

public class ImageShowDesPresenter extends ImageShowDesContract.Presenter{

    public ImageShowDesPresenter(ImageShowDesContract.View mView) {
        this.mView = mView;
        mModel = new ImageShowDesModel();
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
