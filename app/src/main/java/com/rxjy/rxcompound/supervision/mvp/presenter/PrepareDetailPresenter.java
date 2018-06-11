package com.rxjy.rxcompound.supervision.mvp.presenter;

import android.util.Log;

import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.des.entity.SubInfo;
import com.rxjy.rxcompound.supervision.entity.ProcessDetailInfo;
import com.rxjy.rxcompound.supervision.mvp.contract.PrepareDetailContract;
import com.rxjy.rxcompound.supervision.mvp.model.PrepareDetailModel;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by AAA on 2017/11/6.
 */

public class PrepareDetailPresenter extends PrepareDetailContract.Presenter {

    public static final String TAG = "PrepareDetailPresenter";

    public PrepareDetailPresenter(PrepareDetailContract.View mView){
        this.mView = mView;
        mModel = new PrepareDetailModel();
    }

    @Override
    public void getProcessDetail(int processID) {
        Subscription subscribe = mModel.getProcessDetail(processID)
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
                        Log.e(TAG, "获取工序详情失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        ProcessDetailInfo info = JSONUtils.toObject(s, ProcessDetailInfo.class);
                        if (info.getStatusCode() == 1) {
                            List<ProcessDetailInfo.ProcessDetail> dataList = info.getBody();
                            mView.responseProcessDetailData(dataList);
                        } else {
                            mView.responseProcessDetailDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void subProcessDetailPhoto(int stepID, int processID, int stepPhotoID, String url) {
        Subscription subscribe = mModel.subProcessDetailPhoto(stepID, processID, stepPhotoID, url)
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
                        Log.e(TAG, "上传工序图片失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        SubInfo info = JSONUtils.toObject(s, SubInfo.class);
                        if (info.getStatusCode() == 1) {
                            mView.responseSubProcessPhotoData();
                        } else {
                            mView.responseSubProcessPhotoDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
