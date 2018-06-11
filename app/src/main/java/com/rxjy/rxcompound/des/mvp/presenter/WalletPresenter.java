package com.rxjy.rxcompound.des.mvp.presenter;

import android.util.Log;

import com.rxjy.rxcompound.business.entity.WalletBean;
import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.des.entity.WalletInfo;
import com.rxjy.rxcompound.des.entity.WalletRecordInfo;
import com.rxjy.rxcompound.des.mvp.contract.WalletContract;
import com.rxjy.rxcompound.des.mvp.model.WalletModel;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by Administrator on 2017/6/30.
 */
public class WalletPresenter extends WalletContract.Presenter {
    public WalletPresenter(WalletContract.View view) {
        this.mView = view;
        mModel = new WalletModel();
    }

    @Override
    public void getWalletdata(String kahao, String zhiwu, String type) {
        Subscription subscribe = mModel.getWalletdata(kahao,zhiwu,type)
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
                        mView.responsegetWalletdataError("请检查您的网络！");
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("获取月、日数据：：：",s.toString());
                        WalletBean info = JSONUtils.toObject(s, WalletBean.class);
                        if (info.getStatusCode() == 0) {
                            mView.responsegetWalletdata(info);
                        } else {//未同意
                            mView.responsegetWalletdataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
