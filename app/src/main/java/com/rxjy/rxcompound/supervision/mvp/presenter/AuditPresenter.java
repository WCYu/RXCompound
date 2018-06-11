package com.rxjy.rxcompound.supervision.mvp.presenter;

import android.util.Log;

import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.supervision.entity.AuditListInfo;
import com.rxjy.rxcompound.supervision.mvp.contract.AuditContract;
import com.rxjy.rxcompound.supervision.mvp.model.AuditModel;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by AAA on 2017/12/13.
 */

public class AuditPresenter extends AuditContract.Presenter {

    public static final String TAG = "AuditPresenter";

    public AuditPresenter(AuditContract.View mView) {
        this.mView = mView;
        mModel = new AuditModel();
    }

    @Override
    public void getAuditList(String orderNo, int pageIndex, int pageSize) {
        Subscription subscribe = mModel.getAuditList(orderNo, pageIndex, pageSize)
                .subscribe(new Subscriber<String>() {


                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "获取审计列表失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        AuditListInfo info = JSONUtils.toObject(s, AuditListInfo.class);
                        if (info.getStatusCode() == 1) {
                            AuditListInfo.AuditList data = info.getBody();
                            List<AuditListInfo.AuditList.AuditInfo> dataList = data.getLoseitems();
                            mView.responseAuditListData(dataList);
                        } else {
                            mView.responseAuditListDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void getAuditListLoadMore(String orderNo, int pageIndex, int pageSize) {
        Subscription subscribe = mModel.getAuditList(orderNo, pageIndex, pageSize)
                .subscribe(new Subscriber<String>() {


                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "获取审计列表失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        AuditListInfo info = JSONUtils.toObject(s, AuditListInfo.class);
                        if (info.getStatusCode() == 1) {
                            AuditListInfo.AuditList data = info.getBody();
                            List<AuditListInfo.AuditList.AuditInfo> dataList = data.getLoseitems();
                            mView.responseAuditListLoadMoreData(dataList);
                        } else {
                            mView.responseAuditListLoadMoreDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
