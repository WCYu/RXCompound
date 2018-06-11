package com.rxjy.rxcompound.des.mvp.presenter;

import android.util.Log;

import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.des.entity.OrderGetBean;
import com.rxjy.rxcompound.des.entity.ResultBean;
import com.rxjy.rxcompound.des.mvp.contract.OrderGetContract;
import com.rxjy.rxcompound.des.mvp.model.OrderGetModel;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by hjh on 2018/4/16.
 */

public class OrderGetPresenter extends OrderGetContract.Presenter{

    public OrderGetPresenter(OrderGetContract.View mView) {
        this.mView = mView;
        mModel = new OrderGetModel();
    }

    @Override
    public void GetData(String rwdid) {

        Subscription subscribe = mModel.GetData(rwdid)
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
                        OrderGetBean info= JSONUtils.toObject(s, OrderGetBean.class);
                        if (info.getStatusCode()==0){
                            mView.responseGetData(info);
                        }else{
                            mView.responseGetDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);

    }

    @Override
    public void OrderDeal(String rwdid, String formpars, String type) {
        Subscription subscribe = mModel.OrderDeal(rwdid, formpars, type)
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
                        ResultBean info= JSONUtils.toObject(s, ResultBean.class);
                        if (info.getStatusCode()==0){
                            mView.responseOrderDeal(info);
                        }else{
                            mView.responseOrderDealError("提交失败");
                        }
                    }
                });
        addSubscribe(subscribe);
    }

}