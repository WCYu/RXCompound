package com.rxjy.rxcompound.mvp.presenter;

import android.util.Log;

import com.rxjy.rxcompound.mvp.contract.QRLoginSureContract;
import com.rxjy.rxcompound.mvp.model.QRLoginSureModel;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by hjh on 2017/12/20.
 */

public class QRLoginSurePresenter extends QRLoginSureContract.Presenter{

    public QRLoginSurePresenter(QRLoginSureContract.View mView) {
        this.mView = mView;
        mModel = new QRLoginSureModel();
    }

    @Override
    public void getQRLoginSure(String kahao, String biaoshi) {
        Subscription subscribe = mModel.getQRLoginSure(kahao,biaoshi)
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
                        mView.responseQRLoginSureError("网络不给力！");
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("请求登录的接口啊。。。。",s);
                        String resultdata=s;
                        resultdata=resultdata.replaceAll("\"","");
                        if(resultdata.equals("1")){
                            mView.responseQRLoginSure();
                        }else {
                            mView.responseQRLoginSureError("扫码登录失败！");
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
