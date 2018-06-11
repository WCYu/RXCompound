package com.rxjy.rxcompound.des.mvp.presenter;

import android.content.Context;

import com.rxjy.rxcompound.des.mvp.contract.IWpsLocalPhotoContract;
import com.rxjy.rxcompound.des.mvp.model.WpsLocalPhotoModel;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by Administrator on 2017/1/9.
 */
public class WpsLocalPhotoPresenter extends IWpsLocalPhotoContract.Presenter {

    private List<String> ivPhotoes = new ArrayList<>();

    public WpsLocalPhotoPresenter(IWpsLocalPhotoContract.View view) {
        mView = view;
        mModel = new WpsLocalPhotoModel();
    }

    @Override
    public void getPhotoes(Context context) {
        Subscription subscribe = mModel.getPhotoes(context)
                .subscribe(new Subscriber<List<String>>() {

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
                    public void onNext(List<String> dataList) {
                        mView.responsePhotoes(dataList);
                    }
                });
        addSubscribe(subscribe);
    }
}
