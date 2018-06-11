package com.rxjy.rxcompound.des.mvp.presenter;

import android.util.Log;

import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.des.mvp.contract.GetXunjianListContract;
import com.rxjy.rxcompound.des.mvp.model.GetXunjianListModel;
import com.rxjy.rxcompound.entity.XunjianListInfo;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by Administrator on 2017/10/24.
 */

public class GetXunjianListPresenter extends GetXunjianListContract.Presenter{
    public static final String TAG = "GetALLClientInfoPresent";

    public GetXunjianListPresenter(GetXunjianListContract.View mView) {
        this.mView = mView;
        mModel = new GetXunjianListModel();
    }

    @Override
    public void GetScheduleCheckList(String rwdId) {
        Subscription subscribe = mModel.GetScheduleCheckList(rwdId).subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {
                mView.hideDialog();
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG,e.toString());
                mView.hideDialog();
            }

            @Override
            public void onStart() {
                mView.showDialog();
            }

            @Override
            public void onNext(String s) {
                Log.e(TAG,s);
                XunjianListInfo info= JSONUtils.toObject(s, XunjianListInfo.class);
                if (info.getStatusCode()==0){
                    mView.responseXunjianListData(info.getBody());
                }
            }
        });
        addSubscribe(subscribe);
    }
}
