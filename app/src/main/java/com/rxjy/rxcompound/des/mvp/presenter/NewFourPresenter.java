package com.rxjy.rxcompound.des.mvp.presenter;

import android.util.Log;

import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.des.entity.NewFourInfo;
import com.rxjy.rxcompound.des.entity.UpNewXinXi;
import com.rxjy.rxcompound.des.mvp.contract.NewFourContract;
import com.rxjy.rxcompound.des.mvp.model.NewFourModel;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by Administrator on 2017/10/8 0008.
 */

public class NewFourPresenter extends NewFourContract.Presenter {

    public static final String TAG = "NewFourPresenter";

    public NewFourPresenter(NewFourContract.View mView) {
        this.mView = mView;
        mModel = new NewFourModel();
    }

    @Override
    public void GetNewFour(String rwdid) {
        Subscription subscribe = mModel.GetNewFour(rwdid)
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
                        Log.e(TAG, "获取物业信息失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e(TAG, "获取物业信息成功 = " + s);
                        NewFourInfo info= JSONUtils.toObject(s, NewFourInfo.class);
                        if (info.getStatusCode()==0){
                            mView.responseGetNewFour(info.getBody());
                        }else{
                            mView.responseGetNewFourError("获取失败");
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
