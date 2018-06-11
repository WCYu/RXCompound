package com.rxjy.rxcompound.mvp.presenter;

import android.util.Log;

import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.entity.EnvirImgBean;
import com.rxjy.rxcompound.entity.FigureImgBean;
import com.rxjy.rxcompound.entity.ResultBean;
import com.rxjy.rxcompound.mvp.contract.EnvirDetailsContract;
import com.rxjy.rxcompound.mvp.model.EnvirDetailsModel;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by hjh on 2018/4/26.
 */

public class EnvirDetailsPresenter extends EnvirDetailsContract.Presenter{

    public EnvirDetailsPresenter(EnvirDetailsContract.View mView) {
        this.mView = mView;
        mModel = new EnvirDetailsModel();
    }
    @Override
    public void upLoadImg(List<String> imglist) {
        Subscription subscribe = mModel.upLoadImg(imglist)
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
                        Log.e("===", "获取检查是否存在失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("===",s);
                        FigureImgBean info = JSONUtils.toObject(s, FigureImgBean.class);
                        if(info.getStatusCode()==0){
                            mView.responseImg(info);
                        }else{
                            mView.responseImgError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void upLoadData(String EvaluateTxt, String Urls, String Id, String ContentId, String OperatorCardNo, String OperatorName, String Type, String RegionId, String AreaName) {
        Subscription subscribe = mModel.upLoadData(EvaluateTxt, Urls, Id, ContentId, OperatorCardNo, OperatorName, Type, RegionId, AreaName)
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
                        Log.e("", "获取检查是否存在失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        ResultBean info = JSONUtils.toObject(s, ResultBean.class);
                        if(info.getStatusCode()==0){
                            mView.responseData();
                        }else{
                            mView.responseDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void getImg(String ID) {
        Subscription subscribe = mModel.getImg(ID)
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
                        Log.e("", "获取检查是否存在失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        EnvirImgBean info = JSONUtils.toObject(s, EnvirImgBean.class);
                        if(info.getStatusCode()==0){
                            mView.responsegetImg(info);
                        }else{
                            mView.responsegetImgError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
