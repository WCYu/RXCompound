package com.rxjy.rxcompound.supervision.mvp.presenter;

import android.util.Log;

import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.des.entity.SubInfo;
import com.rxjy.rxcompound.supervision.entity.ProblemInfo;
import com.rxjy.rxcompound.supervision.mvp.contract.NewRoutingSubContract;
import com.rxjy.rxcompound.supervision.mvp.model.NewRoutingSubModel;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by AAA on 2018/1/17.
 */

public class NewRoutingSubPresenter extends NewRoutingSubContract.Presenter {

    public static final String TAG = "NewRoutingSubPresenter";

    public NewRoutingSubPresenter(NewRoutingSubContract.View mView) {
        this.mView = mView;
        mModel = new NewRoutingSubModel();
    }

    @Override
    public void getProblemList() {
        Subscription subscribe = mModel.getProblemList()
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
                        Log.e(TAG, "获取问题列表失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        ProblemInfo info = JSONUtils.toObject(s, ProblemInfo.class);
                        if (info.getStatusCode() == 1) {
                            List<ProblemInfo.Problem> dataList = info.getBody();
                            mView.responseProblemListData(dataList);
                        } else {
                            mView.responseProblemListDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void subXJProblem(int xjID, String orderNo, String content, String count, double xjX, double xjY, String address, int type, List<ProblemInfo.Problem> proList) {
        Subscription subscribe = mModel.subXJProblem(xjID, orderNo, content, count, xjX, xjY, address, type, proList)
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
                        Log.e(TAG, "提交巡检失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        SubInfo info = JSONUtils.toObject(s, SubInfo.class);
                        if (info.getStatusCode() == 1) {
                            mView.responseRoutingSubData();
                        } else {
                            mView.responseRoutingSubDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
