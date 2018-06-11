package com.rxjy.rxcompound.des.mvp.presenter;

import android.util.Log;


import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.des.entity.GetHuiFang;
import com.rxjy.rxcompound.des.entity.SubInfo;
import com.rxjy.rxcompound.des.mvp.contract.TalkContract;
import com.rxjy.rxcompound.des.mvp.model.TalkModel;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by Administrator on 2017/8/15.
 */

public class TalkPresenter extends TalkContract.Presenter {

    public TalkPresenter(TalkContract.View mView) {
        this.mView = mView;
        mModel = new TalkModel();
    }

    public static final String TAG = "TalkPresenter";

    @Override
    public void getHuiFangData(String rwdId, int pageIndex) {
        Subscription subscribe = mModel.getHuiFangData(rwdId, pageIndex)
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
                        Log.e(TAG, e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e(TAG, s);
                        GetHuiFang hf = JSONUtils.toObject(s, GetHuiFang.class);
                        int index = hf.getBody().size();
                        for (int i = 0; i < index; i++) {
                        }
                        if (hf.getStatusCode() == 1) {
                            mView.loadnodata();
                        }
                        mView.showList(hf.getBody());
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void xlgetHuiFangData(String rwdId, int pageIndex) {
        Subscription subscribe = mModel.getHuiFangData(rwdId, pageIndex)
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
                        Log.e(TAG, e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e(TAG, s);
                        GetHuiFang hf = JSONUtils.toObject(s, GetHuiFang.class);
                        if (hf.getStatusCode() == 1) {
                            mView.loadnodata();
                        }
                        mView.xlshowList(hf);
                    }
                });
        addSubscribe(subscribe);
    }


    @Override
    public void addHuiFangData(String rwdId, String content, int methods) {
        Subscription subscribe = mModel.addHuiFangData(rwdId, content, methods)
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
                        Log.e(TAG, e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        SubInfo info = JSONUtils.toObject(s, SubInfo.class);
                        if (info.getStatusCode() == 0) {
                            mView.responseTalkData();
                        } else {
                            mView.responseTalkDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
