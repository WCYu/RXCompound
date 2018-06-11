package com.rxjy.rxcompound.des.mvp.presenter;

import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.des.entity.PlanImageBean;
import com.rxjy.rxcompound.des.entity.PlanStrBean;
import com.rxjy.rxcompound.des.mvp.contract.PlanContract;
import com.rxjy.rxcompound.des.mvp.model.PlanModel;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by hjh on 2018/4/17.
 */

public class PlanPresenter extends PlanContract.Presenter{

    public PlanPresenter(PlanContract.View mView) {
        this.mView = mView;
        mModel = new PlanModel();
    }

    @Override
    public void GetTxt(String rwdId) {
        Subscription subscribe = mModel.GetTxt(rwdId)
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
                        PlanStrBean info= JSONUtils.toObject(s, PlanStrBean.class);
                        if (info.getStatusCode()==0){
                            mView.responseGetTxt(info);
                        }else{
                            mView.responseGetTxtError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void GetImage(String rwdId) {
        Subscription subscribe = mModel.GetImage(rwdId)
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
                        PlanImageBean info= JSONUtils.toObject(s, PlanImageBean.class);
                        if (info.getStatusCode()==0){
                            mView.responseGetImage(info);
                        }else{
                            mView.responseGetImageError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}