package com.rxjy.rxcompound.supervision.mvp.presenter;

import android.util.Log;

import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.des.entity.SubInfo;
import com.rxjy.rxcompound.supervision.entity.PushElectronicInfo;
import com.rxjy.rxcompound.supervision.mvp.contract.PushElectronicContract;
import com.rxjy.rxcompound.supervision.mvp.model.PushElectronicModel;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by AAA on 2017/12/21.
 */

public class PushElectronicPresenter extends PushElectronicContract.Presenter {

    public static final String TAG = "PushElectronicPresenter";

    public PushElectronicPresenter(PushElectronicContract.View mView) {
        this.mView = mView;
        mModel = new PushElectronicModel();
    }

    @Override
    public void getPaperInfo(String orderNo, int attrId) {
        Subscription subscribe = mModel.getPaperInfo(orderNo, attrId)
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
                        Log.e(TAG, "获取资料推送信息失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        PushElectronicInfo info = JSONUtils.toObject(s, PushElectronicInfo.class);
                        if (info.getStatusCode() == 1) {
                            PushElectronicInfo.PushElectronic data = info.getBody();
                            mView.responsePushElectronicData(data);
                        } else {
                            mView.responsePushElectronicDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);

    }

    @Override
    public void saveElectronicInfo(String orderNo, int attrId, int eleId, String content) {
        Subscription subscribe = mModel.saveElectronicInfo(orderNo, attrId, eleId, content)
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
                        Log.e(TAG, "保存电子资料失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        SubInfo info = JSONUtils.toObject(s, SubInfo.class);
                        if (info.getStatusCode() == 1) {
                            mView.responseSaveElectronicData();
                        } else {
                            mView.responseSaveElectronicDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void savePushElectronicInfo(String orderNo, int attrId) {
        Subscription subscribe = mModel.savePushElectronicInfo(orderNo, attrId)
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
                        Log.e(TAG, "保存推送电子资料失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        SubInfo info = JSONUtils.toObject(s, SubInfo.class);
                        if (info.getStatusCode() == 1) {
                            mView.responseSavePushElectronicData();
                        } else {
                            mView.responseSavePushElectronicDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
