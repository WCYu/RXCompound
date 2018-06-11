package com.rxjy.rxcompound.supervision.mvp.presenter;

import android.util.Log;

import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.supervision.entity.MatListInfo;
import com.rxjy.rxcompound.supervision.mvp.contract.MatListContract;
import com.rxjy.rxcompound.supervision.mvp.model.MatListModel;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by AAA on 2017/12/13.
 */

public class MatListPresenter extends MatListContract.Presenter {

    public static final String TAG = "MatListPresenter";

    public MatListPresenter(MatListContract.View mView) {
        this.mView = mView;
        mModel = new MatListModel();
    }

    @Override
    public void getMatList(String orderNo) {
        Subscription subscribe = mModel.getMatList(orderNo)
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
                        Log.e(TAG, "获取材料清单失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        MatListInfo info = JSONUtils.toObject(s, MatListInfo.class);
                        if (info.getStatusCode() == 1) {
                            List<MatListInfo.MatInfo> dataList = info.getBody();
                            mView.responseMatListData(dataList);
                        } else {
                            mView.responseMatListDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
