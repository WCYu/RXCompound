package com.rxjy.rxcompound.des.mvp.presenter;


import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.des.entity.DesDaiMeasureABean;
import com.rxjy.rxcompound.des.entity.SaveLhouseBean;
import com.rxjy.rxcompound.des.mvp.contract.DesDaiMeasureAContract;
import com.rxjy.rxcompound.des.mvp.model.DesDaiMeasureAModel;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by hjh on 2017/12/14.
 */

public class DesDaiMeasureAPresenter extends DesDaiMeasureAContract.Presenter{

    public DesDaiMeasureAPresenter(DesDaiMeasureAContract.View mView) {
        this.mView = mView;
        mModel = new DesDaiMeasureAModel();
    }

    @Override
    public void getLHouseData(String rwdid) {

        Subscription subscribe = mModel.getLHouseData(rwdid)
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
                        DesDaiMeasureABean info= JSONUtils.toObject(s, DesDaiMeasureABean.class);
                        if (info.getStatusCode()==0){
                            mView.responseLHouseData(info.getBody());
                        }else{
                            mView.responseLHouseDataError("获取失败");
                        }
                    }
                });
        addSubscribe(subscribe);

    }

    @Override
    public void saveLHouseData(String rwdId, String formpars, String money, String valCount) {

        Subscription subscribe = mModel.saveLHouseData(rwdId,formpars,money,valCount)
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
                        mView.responsesaveLHouseDataError("保存失败！");
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        SaveLhouseBean info= JSONUtils.toObject(s, SaveLhouseBean.class);
                        if (info.getStatusCode()==0){
                            mView.responsesaveLHouseData("保存成功！");
                        }else{
                            mView.responsesaveLHouseDataError(info.getStatusMsg()+"");
                        }
                    }
                });
        addSubscribe(subscribe);

    }

}