package com.rxjy.rxcompound.mvp.presenter;

import android.util.Log;

import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.entity.VersionInfo;
import com.rxjy.rxcompound.mvp.contract.JobTryAnContract;
import com.rxjy.rxcompound.mvp.contract.MainContract;
import com.rxjy.rxcompound.mvp.model.MainModel;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by Administrator on 2017/12/1.
 */

public class MainPresenter extends MainContract.Presenter {

    public static final String TAG = "MainPresenter";

    public MainPresenter(MainContract.View mView) {
        this.mView = mView;
        mModel = new MainModel();
    }

    @Override
    public void getVersionInfo(int version) {
        Subscription subscribe = mModel.getVersionInfo(version)
                .subscribe(new Subscriber<String>() {

                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "获取版本信息失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e(TAG, "tag_获取版本信息" + s);
                        VersionInfo info = JSONUtils.toObject(s, VersionInfo.class);
                        if (info.getStatusCode() == 0) {
                            Log.e(TAG, "tag_获取版本信息" + "开始");
                            VersionInfo.Version data = info.getBody();
                            mView.responseVersionData(null);
                            Log.e(TAG, "tag_获取版本信息" + "结束");
                        } else {
                            mView.responseVersionDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
