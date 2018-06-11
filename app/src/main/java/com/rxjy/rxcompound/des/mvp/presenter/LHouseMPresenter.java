package com.rxjy.rxcompound.des.mvp.presenter;

import android.util.Log;

import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.des.entity.LHouseNumBean;
import com.rxjy.rxcompound.des.entity.ProjectTypeBean;
import com.rxjy.rxcompound.des.entity.SaveDataBean;
import com.rxjy.rxcompound.des.mvp.contract.LHouseMContract;
import com.rxjy.rxcompound.des.mvp.model.LHouseMModel;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by hjh on 2018/4/4.
 */

public class LHouseMPresenter extends LHouseMContract.Presenter{

    public LHouseMPresenter(LHouseMContract.View mView) {
        this.mView = mView;
        mModel = new LHouseMModel();
    }

    @Override
    public void GetData(String areaid, String phone) {
        Subscription subscribe = mModel.GetData(areaid, phone)
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
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("", "获取数据成功 = " + s);
                        LHouseNumBean info = JSONUtils.toObject(s, LHouseNumBean.class);
                        if (info.getStatusCode() == 0) {
                            mView.responsedata(info);
                        } else {
                            mView.responsedataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void submitData(String rwdid, String clientInfo, String clientAuxiliary) {
        Subscription subscribe = mModel.submitData(rwdid, clientInfo, clientAuxiliary)
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
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("", "获取数据成功 = " + s);
                        SaveDataBean info = JSONUtils.toObject(s, SaveDataBean.class);
                        if (info.getStatusCode() .equals("100")) {
                            mView.responsesubmitdata(info.getStatusMsg());
                        } else {
                            mView.responsesubmitdataError(info.getStatusMsg());
                        }
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
                        Log.e("", "获取项目类型失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("", "获取项目类型成功 = " + s);
                        ProjectTypeBean info=JSONUtils.toObject(s, ProjectTypeBean.class);
                        mView.responseProjecttype(info);
                    }
                });
        addSubscribe(subscribe);
    }
}
