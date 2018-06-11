package com.rxjy.rxcompound.des.mvp.presenter;

import android.util.Log;

import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.des.entity.NewNineInfo;
import com.rxjy.rxcompound.des.entity.UpNewXinXi;
import com.rxjy.rxcompound.des.mvp.contract.NewNineContract;
import com.rxjy.rxcompound.des.mvp.model.NewNineModel;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by Administrator on 2017/10/9 0009.
 */

public class NewNinePresenter extends NewNineContract.Presenter{

    public static final String TAG = "NewEightPresenter";

    public NewNinePresenter(NewNineContract.View mView) {
        this.mView = mView;
        mModel = new NewNineModel();
    }

    @Override
    public void GetNewNine(String rwdid) {
        Subscription subscribe = mModel.GetNewNine(rwdid)
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
                        Log.e(TAG, "获取企业信息失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e(TAG, "获取企业信息成功 = " + s);
                        NewNineInfo info= JSONUtils.toObject(s, NewNineInfo.class);
                        if (info.getStatusCode()==0){
                            mView.responseGetNewNine(info.getBody());
                        }else{
                            mView.responseGetNewNineError("获取失败");
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
