package com.rxjy.rxcompound.supervision.mvp.presenter;

import android.util.Log;

import com.luck.picture.lib.entity.LocalMedia;
import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.des.entity.SubInfo;
import com.rxjy.rxcompound.supervision.entity.AttachmentTypeInfo;
import com.rxjy.rxcompound.supervision.mvp.contract.AttachmentContract;
import com.rxjy.rxcompound.supervision.mvp.model.AttachmentModel;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by AAA on 2017/12/25.
 */

public class AttachmentPresenter extends AttachmentContract.Presenter {

    public static final String TAG = "AttachmentPresenter";

    public AttachmentPresenter(AttachmentContract.View mView) {
        this.mView = mView;
        mModel = new AttachmentModel();
    }

    @Override
    public void getAttachmentTypeInfo() {
        Subscription subscribe = mModel.getAttachmentTypeInfo()
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
                        Log.e(TAG, "获取资料类型失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        AttachmentTypeInfo info = JSONUtils.toObject(s, AttachmentTypeInfo.class);
                        if (info.getStatusCode() == 1) {
                            List<AttachmentTypeInfo.AttachmentInfo> dataList = info.getBody();
                            mView.responseAttachmentTypeData(dataList);
                        } else {
                            mView.responseAttachmentTypeDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void subAttachmentInfo(String orderNo, String dayCount, int modelId, List<LocalMedia> imgList) {
        Subscription subscribe = mModel.subAttachmentInfo(orderNo, dayCount, modelId, imgList)
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
                        Log.e(TAG, "上传附件资料失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        SubInfo info = JSONUtils.toObject(s, SubInfo.class);
                        if (info.getStatusCode() == 1) {
                            mView.responseSubAttachmentData();
                        } else {
                            mView.responseSubAttachmentDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
