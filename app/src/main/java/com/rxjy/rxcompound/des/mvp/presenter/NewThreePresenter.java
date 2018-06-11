package com.rxjy.rxcompound.des.mvp.presenter;

import android.util.Log;

import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.des.entity.NewThreeInfo;
import com.rxjy.rxcompound.des.entity.UpNewXinXi;
import com.rxjy.rxcompound.des.mvp.contract.NewThreeContract;
import com.rxjy.rxcompound.des.mvp.model.NewThreeModel;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by Administrator on 2017/10/8 0008.
 */

public class NewThreePresenter extends NewThreeContract.Presenter{

    public static final String TAG = "NewThreePresenter";

    public NewThreePresenter(NewThreeContract.View mView) {
        this.mView = mView;
        mModel = new NewThreeModel();
    }

    @Override
    public void GetNewThree(String rwdid) {
        Subscription subscribe = mModel.GetNewThree(rwdid)
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
                        Log.e(TAG, "获取装修需求失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e(TAG, "获取装修需求成功 = " + s);
                        NewThreeInfo info= JSONUtils.toObject(s, NewThreeInfo.class);
                        if (info.getStatusCode()==0){
                            mView.responseGetNewThree(info.getBody());
                        }else{
                            mView.responseGetNewThreeError("获取失败");
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void UpXinxi(String cardNo, String formpars, String type) {
        Subscription subscribe = mModel.UpXinxi(cardNo,formpars,type)
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
                        Log.e(TAG, "上传信息失败 = " + e.toString());
                        mView.responseUpNewOneError("上传失败");
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e(TAG, "上传信息成功 = " + s);
                        UpNewXinXi info=JSONUtils.toObject(s, UpNewXinXi.class);
                        mView.responseUpNewOne(info);
                    }
                });
        addSubscribe(subscribe);
    }


}
