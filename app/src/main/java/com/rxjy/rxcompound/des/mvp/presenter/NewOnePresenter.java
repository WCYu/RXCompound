package com.rxjy.rxcompound.des.mvp.presenter;

import android.util.Log;

import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.des.entity.NewOneInfo;
import com.rxjy.rxcompound.des.entity.UpDanHaoInfo;
import com.rxjy.rxcompound.des.entity.UpNewXinXi;
import com.rxjy.rxcompound.des.mvp.contract.NewOneContract;
import com.rxjy.rxcompound.des.mvp.model.NewOneModel;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by Administrator on 2017/10/8 0008.
 */

public class NewOnePresenter extends NewOneContract.Presenter{
    public static final String TAG = "NewOnePresenter";

    public NewOnePresenter(NewOneContract.View mView) {
        this.mView = mView;
        mModel = new NewOneModel();
    }

    @Override
    public void GetNewOne(String rwdid) {
        Subscription subscribe = mModel.GetNewOne(rwdid)
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
                        Log.e(TAG, "获取量房信息失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e(TAG, "获取量房信息成功 = " + s);
                        NewOneInfo info= JSONUtils.toObject(s, NewOneInfo.class);
                        if (info.getStatusCode()==0){
                            mView.responseGetNewOne(info.getBody());
                        }else{
                            mView.responseGetNewOneError("获取失败");
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

    @Override
    public void UpDanHao(String rwdid) {
        Subscription subscribe = mModel.UpDanHao(rwdid)
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
                        Log.e(TAG, "上传单号失败 = " + e.toString());
                        mView.responseUpDanHaoError("上传失败");
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e(TAG, "上传单号成功 = " + s);
                        UpDanHaoInfo info=JSONUtils.toObject(s,UpDanHaoInfo.class);
                        mView.responseUpDanHao(info);

                    }
                });
        addSubscribe(subscribe);
    }
}
