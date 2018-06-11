package com.rxjy.rxcompound.des.mvp.presenter;

import android.util.Log;

import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.des.mvp.contract.DestoryContract;
import com.rxjy.rxcompound.des.mvp.model.DestoryModel;
import com.rxjy.rxcompound.entity.NumberPackets;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by Administrator on 2017/10/13.
 */

public class DestoryPresenter extends DestoryContract.Presenter{

    public static final String TAG = "DestoryPresenter";

    public DestoryPresenter(DestoryContract.View mView)
    {
        this.mView = mView;
        mModel = new DestoryModel();
    }
    @Override
    public void getDestoryListener() {
        Subscription subscribe = mModel.getDestoryListener()
                .subscribe(new Subscriber<String>()
                {

                    @Override
                    public void onStart()
                    {

                    }

                    @Override
                    public void onCompleted()
                    {

                    }

                    @Override
                    public void onError(Throwable e)
                    {

                    }

                    @Override
                    public void onNext(String s)
                    {
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void getRedTask(String cardNo) {
        Subscription subscribe = mModel.getRedTask(cardNo)
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
                        Log.e("RedTaskPresenter", "获取红包列表是否存在失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("RedTaskPresenter",s);
                        NumberPackets info = JSONUtils.toObject(s, NumberPackets.class);
                        if(info.getStatusCode()==0){//
                            mView.responseTaskData(info.getBody());
                        }else if(info.getStatusCode()==-1){
                            mView.responseUserStatusError(info.getStatusMsg());
                        }

                    }
                });
        addSubscribe(subscribe);
    }
}
