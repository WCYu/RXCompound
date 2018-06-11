package com.rxjy.rxcompound.des.mvp.presenter;

import android.util.Log;

import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.des.entity.DeleteXJPICInfo;
import com.rxjy.rxcompound.des.entity.GetXunjianXQYInfo;
import com.rxjy.rxcompound.des.entity.UpDanHaoInfo;
import com.rxjy.rxcompound.des.entity.UpXJPicInfo;
import com.rxjy.rxcompound.des.mvp.contract.XunjianXQYContract;
import com.rxjy.rxcompound.des.mvp.model.XunjianXQYModel;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by Administrator on 2017/10/24.
 */

public class XunjianXQYPresenter extends XunjianXQYContract.Presenter {

    public static final String TAG = "XunjianXQYPresenter";

    public XunjianXQYPresenter(XunjianXQYContract.View mView) {
        this.mView = mView;
        mModel = new XunjianXQYModel();
    }

    @Override
    public void GetScheduleCheckIno(String sc_id) {
        Subscription subscribe = mModel.GetScheduleCheckIno(sc_id)
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
                        Log.e(TAG, "获取信息失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e(TAG, "获取信息成功 = " + s);
                        GetXunjianXQYInfo info= JSONUtils.toObject(s, GetXunjianXQYInfo.class);
                       if (info.getStatusCode()==0){
                           mView.responseGetXunjianXinxiData(info);
                       }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void SubmitCheckDes(String sc_id, String description, String address) {
        Subscription subscribe = mModel.SubmitCheckDes(sc_id,description,address)
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
                        Log.e(TAG, "获取信息失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e(TAG, "获取信息成功 = " + s);
                        UpDanHaoInfo info=JSONUtils.toObject(s, UpDanHaoInfo.class);
                        if (info.getStatusCode()==0){
                            mView.responseUpXunjianXinxiData(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void UploadCheckImages(String sc_Id,final List<String> imgList) {
        Subscription subscribe = mModel.UploadCheckImages(sc_Id,imgList)
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
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e(TAG, "上传信息成功 = " + s.toString());
                        UpXJPicInfo info=JSONUtils.toObject(s, UpXJPicInfo.class);
                        if (info.getStatusCode()==0){
                            mView.UpKaigongPicInfo(info);
                        }else{
                            mView.UpKaigongPicInfoError(info);
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void DeleteloadCheckImages(String sc_Id, String fileName) {
        Subscription subscribe = mModel.DeleteloadCheckImages(sc_Id,fileName)
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
                        Log.e(TAG, "删除信息失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e(TAG, "删除信息成功 = " + s);
                        DeleteXJPICInfo info=JSONUtils.toObject(s,DeleteXJPICInfo.class);
                        if (info.getStatusCode()==0){
                            mView.responseXunjianDataError("删除成功");

                        }
                    }
                });
        addSubscribe(subscribe);
    }

}
