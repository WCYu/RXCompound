package com.rxjy.rxcompound.des.mvp.presenter;

import android.util.Log;

import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.des.entity.NewSixInfo;
import com.rxjy.rxcompound.des.entity.UpNewXinXi;
import com.rxjy.rxcompound.des.mvp.contract.NewSixContract;
import com.rxjy.rxcompound.des.mvp.model.NewSixModel;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by Administrator on 2017/10/9 0009.
 */

public class NewSixPresenter extends NewSixContract.Presenter {

    public static final String TAG = "NewSixPresenter";

    public NewSixPresenter(NewSixContract.View mView) {
        this.mView = mView;
        mModel = new NewSixModel();
    }

    @Override
    public void GetNewSix(String rwdid) {
        Subscription subscribe = mModel.GetNewSix(rwdid)
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
                        Log.e(TAG, "获取房源信息失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e(TAG, "获取房源信息成功 = " + s);
                        NewSixInfo info= JSONUtils.toObject(s, NewSixInfo.class);
                        if (info.getStatusCode()==0){
                            mView.responseGetNewSix(info.getBody());
                        }else{
                            mView.responseGetNewSixError("获取失败");
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
