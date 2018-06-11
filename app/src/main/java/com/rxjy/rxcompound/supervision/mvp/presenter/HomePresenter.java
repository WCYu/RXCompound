package com.rxjy.rxcompound.supervision.mvp.presenter;

import android.util.Log;


import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.entity.CustomerBean;
import com.rxjy.rxcompound.supervision.entity.ProjectListInfo;
import com.rxjy.rxcompound.supervision.mvp.contract.HomeContract;
import com.rxjy.rxcompound.supervision.mvp.model.HomeModel;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by AAA on 2017/7/31.
 */

public class HomePresenter extends HomeContract.Presenter {

    public static final String TAG = "HomePresenter";

    public HomePresenter(HomeContract.View mView) {
        this.mView = mView;
        mModel = new HomeModel();
    }

    @Override
    public void getProList(String cardNo) {
        Subscription subscribe = mModel.getProList(cardNo)
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
                        Log.e(TAG, "获取项目列表失败 = " + e.toString());
                        mView.responseProListDataError("请求超时");
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {

                        ProjectListInfo info = JSONUtils.toObject(s, ProjectListInfo.class);
                        if (info.getStatusCode() == 1) {
                            List<ProjectListInfo.Project> dataList = info.getBody();
                            mView.responseProListData(dataList);
                        } else {
                            mView.responseProListDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
