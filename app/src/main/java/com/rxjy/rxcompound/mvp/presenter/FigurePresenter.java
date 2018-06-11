package com.rxjy.rxcompound.mvp.presenter;

import android.util.Log;

import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.entity.FigureImgBean;
import com.rxjy.rxcompound.entity.FigurePersonBean;
import com.rxjy.rxcompound.entity.ResultBean;
import com.rxjy.rxcompound.mvp.contract.FigureContract;
import com.rxjy.rxcompound.mvp.model.FigureModel;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by hjh on 2018/4/25.
 */

public class FigurePresenter extends FigureContract.Presenter{

    public FigurePresenter(FigureContract.View mView) {
        this.mView = mView;
        mModel = new FigureModel();
    }
    @Override
    public void getPerson(String CardNo, String DepartId) {
        Subscription subscribe = mModel.getPerson(CardNo, DepartId)
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
                        FigurePersonBean info = JSONUtils.toObject(s, FigurePersonBean.class);
                        if(info.getStatusCode()==0){//同意
                            mView.responsePerson(info);
                        }else{
                            mView.responsePersonError(info.getStatusMsg());
                        }

                    }
                });
        addSubscribe(subscribe);
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
                        Log.e("", "获取检查是否存在失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
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
    public void upLoadData(String CardNo, String Name, String EvaluateTxt, String Urls, String Id, String OperatorCardNo, String OperatorName, String RegionId, String EduDepartId) {
        Subscription subscribe = mModel.upLoadData(CardNo, Name, EvaluateTxt, Urls, Id, OperatorCardNo, OperatorName, RegionId, EduDepartId)
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
                            mView.responseImgError(info.getStatusMsg());
                        }

                    }
                });
        addSubscribe(subscribe);
    }
}
