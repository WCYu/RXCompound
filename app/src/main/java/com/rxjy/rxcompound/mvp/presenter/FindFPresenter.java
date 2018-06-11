package com.rxjy.rxcompound.mvp.presenter;

import android.util.Log;

import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.entity.FindBean;
import com.rxjy.rxcompound.entity.ManagementBean;
import com.rxjy.rxcompound.mvp.contract.FindFContract;
import com.rxjy.rxcompound.mvp.model.FindFModel;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by hjh on 2017/11/13.
 */

public class FindFPresenter extends FindFContract.Presenter{
    public FindFPresenter(FindFContract.View mView) {
        this.mView = mView;
        mModel = new FindFModel();
    }
    @Override
    public void getFindList(String cardNo, int pageIndex, int pageSize) {
        Subscription subscribe = mModel.getFindList(cardNo,pageIndex,pageSize)
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
                        Log.e("", "获取banner失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("发现数据sss",s);
                        FindBean info = JSONUtils.toObject(s, FindBean.class);
                        mView.responseFindData(info);
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void getFindListLoadmore(String cardNo, int pageIndex, int pageSize) {
        Subscription subscribe = mModel.getFindList(cardNo,pageIndex,pageSize)
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
                        Log.e("", "获取banner失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("加载更多数据sss",s.toString());
                        FindBean info = JSONUtils.toObject(s, FindBean.class);
                        mView.responseFindDataLoadmore(info);
                    }
                });
        addSubscribe(subscribe);

    }

    @Override
    public void getFindObtainWhethe(String CardNo) {
        Subscription subscribe = mModel.getFindObtainWhethe(CardNo)
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
                        Log.e("", "获取banner失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("加载更多数据sss",s.toString());
                        ManagementBean managementBean = JSONUtils.toObject(s, ManagementBean.class);
                        if(managementBean.getStatusCode()==0){
                            mView.obtainWhetheData(managementBean.getBody().getIsManage());
                        }else {
                            mView.responseFindDataLoadmoreError(managementBean.getStatusMsg());
                        }


                    }
                });
        addSubscribe(subscribe);
    }


}
