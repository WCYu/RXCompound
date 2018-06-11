package com.rxjy.rxcompound.supervision.mvp.presenter;

import android.util.Log;

import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.supervision.entity.DatumListInfo;
import com.rxjy.rxcompound.supervision.mvp.contract.ElectronicContract;
import com.rxjy.rxcompound.supervision.mvp.model.ElectronicModel;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by AAA on 2017/12/21.
 */

public class ElectronicPresenter extends ElectronicContract.Presenter {

    public static final String TAG = "ElectronicPresenter";

    public ElectronicPresenter(ElectronicContract.View mView) {
        this.mView = mView;
        mModel = new ElectronicModel();
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
                        Log.e(TAG, "获取电子资料失败 = " + e.toString());
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
}
