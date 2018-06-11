package com.rxjy.rxcompound.supervision.mvp.presenter;

import android.util.Log;

import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.des.entity.SubInfo;
import com.rxjy.rxcompound.supervision.entity.DatumListInfo;
import com.rxjy.rxcompound.supervision.mvp.contract.PaperContract;
import com.rxjy.rxcompound.supervision.mvp.model.PaperModel;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by AAA on 2017/12/21.
 */

public class PaperPresenter extends PaperContract.Presenter {

    public static final String TAG = "PaperPresenter";

    public PaperPresenter(PaperContract.View mView) {
        this.mView = mView;
        mModel = new PaperModel();
    }

    @Override
    public void getPaperInfo(String orderNo) {
        Subscription subscribe = mModel.getPaperInfo(orderNo)
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
                        Log.e(TAG, "获取纸质资料失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        DatumListInfo info = JSONUtils.toObject(s, DatumListInfo.class);
                        if (info.getStatusCode() == 1) {
                            DatumListInfo.DatumInfo data = info.getBody();
                            mView.responsePaperData(data);
                        } else {
                            mView.responsePaperDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void uploadPaperInfo(String orderNo, int category, int attrId, int orderID, String url) {
        Subscription subscribe = mModel.uploadPaperInfo(orderNo, category, attrId, orderID, url)
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
                        Log.e(TAG, "上传纸质资料失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        SubInfo info = JSONUtils.toObject(s, SubInfo.class);
                        if (info.getStatusCode() == 1) {
                            mView.responseUploadPaperData();
                        } else {
                            mView.responseUploadPaperDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
