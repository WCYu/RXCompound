package com.rxjy.rxcompound.des.mvp.presenter;

import android.util.Log;

import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.des.entity.NewFiveInfo;
import com.rxjy.rxcompound.des.entity.ProjectTypeBean;
import com.rxjy.rxcompound.des.entity.UpNewXinXi;
import com.rxjy.rxcompound.des.mvp.contract.NewFiveCantract;
import com.rxjy.rxcompound.des.mvp.model.NewFiveModel;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by Administrator on 2017/10/9 0009.
 */

public class NewFivePresenter extends NewFiveCantract.Presenter {

    public static final String TAG = "NewFivePresenter";

    public NewFivePresenter(NewFiveCantract.View mView) {
        this.mView = mView;
        mModel = new NewFiveModel();
    }

    @Override
    public void GetNewFive(String rwdid) {
        Subscription subscribe = mModel.GetNewFive(rwdid)
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
                        Log.e(TAG, "获取基本信息失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e(TAG, "获取基本信息成功 = " + s);
                        NewFiveInfo info= JSONUtils.toObject(s, NewFiveInfo.class);
                        if (info.getStatusCode()==0){
                            mView.responseGetNewFive(info.getBody());
                        }else{
                            mView.responseGetNewFiveError("获取失败");
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
    public void getProjecttype() {

        Subscription subscribe = mModel.getProjecttype()
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
                        Log.e(TAG, "获取项目类型失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e(TAG, "获取项目类型成功 = " + s);
                        ProjectTypeBean info=JSONUtils.toObject(s, ProjectTypeBean.class);
                        mView.responseProjecttype(info);
                    }
                });
        addSubscribe(subscribe);

    }

}
