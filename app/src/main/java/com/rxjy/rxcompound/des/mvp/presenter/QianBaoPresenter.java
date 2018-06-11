package com.rxjy.rxcompound.des.mvp.presenter;

import android.util.Log;

import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.des.entity.QianBaoInfo;
import com.rxjy.rxcompound.des.entity.QianbaoFenInfo;
import com.rxjy.rxcompound.des.mvp.contract.QianBaoContracts;
import com.rxjy.rxcompound.des.mvp.model.QianBaoModel;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by Administrator on 2017/8/25.
 */

public class QianBaoPresenter extends QianBaoContracts.Presenter {
    public static final String TAG = "QianBaoPresenter";

    private QianBaoContracts.View mView;

    public QianBaoPresenter(QianBaoContracts.View mView){
           this.mView=mView;
           mModel=new QianBaoModel();
    }
    @Override
    public void getQianBaoInfo(String cardNo, int pageIndex) {
        Subscription subscribe = mModel.getQianBaoInfo(cardNo, pageIndex)
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
                        Log.e(TAG, "获取钱包列表失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e(TAG, "获取钱包列表成功 = " + s);

                        QianBaoInfo QBInfo = JSONUtils.toObject(s, QianBaoInfo.class);
                        if (QBInfo.getStatusCode() == 0)
                            mView.responseQianBaoInfo(QBInfo);

                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void getQianBaoFenInfo(String cardNo, int pageIndex, int type) {
        Subscription subscribe = mModel.getQianBaoFenInfo(cardNo,pageIndex,type)
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
                        Log.e(TAG, "获取钱包列表失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e(TAG, "获取钱包列表成功 = " + s);

                        QianbaoFenInfo QBInfo = JSONUtils.toObject(s, QianbaoFenInfo.class);
                        if (QBInfo.getStatusCode() == 0)
                            mView.responseQianBaoFenInfo(QBInfo);

                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void getXLQianBaoInfo(String cardNo, int pageIndex) {
        Subscription subscribe = mModel.getQianBaoInfo(cardNo, pageIndex)
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
                        Log.e(TAG, "获取钱包列表失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e(TAG, "获取钱包列表成功 = " + s);

                        QianBaoInfo QBInfo=JSONUtils.toObject(s, QianBaoInfo.class);
                        if (QBInfo.getStatusCode()==0){
                            mView.responseXLQianBaoInfo(QBInfo);
                        }


                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void getXLFenQianBaoInfo(String cardNo, int pageIndex, int type) {
        Subscription subscribe = mModel.getQianBaoFenInfo(cardNo,pageIndex,type)
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
                        Log.e(TAG, "获取钱包列表失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e(TAG, "获取钱包列表成功 = " + s);

                        QianbaoFenInfo QBInfo = JSONUtils.toObject(s, QianbaoFenInfo.class);
                        if (QBInfo.getStatusCode() == 0)
                            mView.responseQianBaoFenInfo(QBInfo);

                    }
                });
        addSubscribe(subscribe);
    }

}
