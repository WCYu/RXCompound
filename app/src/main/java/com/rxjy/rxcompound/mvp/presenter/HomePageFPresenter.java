package com.rxjy.rxcompound.mvp.presenter;

import android.util.Log;
import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.entity.BannerBean;
import com.rxjy.rxcompound.entity.EduDataBean;
import com.rxjy.rxcompound.entity.TaskListBean;
import com.rxjy.rxcompound.mvp.contract.HomePageFContract;
import com.rxjy.rxcompound.mvp.model.HomePageFModel;
import rx.Subscriber;
import rx.Subscription;


/**
 * Created by hjh on 2017/11/13.
 */
public class HomePageFPresenter extends HomePageFContract.Presenter{

    public HomePageFPresenter(HomePageFContract.View mView) {
        this.mView = mView;
        mModel = new HomePageFModel();
    }

    @Override
    public void getBannerList(String a_ccount) {
        Subscription subscribe = mModel.getBannerList(a_ccount)
                .subscribe(new Subscriber<String>() {

                    @Override
                    public void onStart() {
//                        mView.showDialog();
                    }

                    @Override
                    public void onCompleted() {
//                        mView.hideDialog();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("", "获取banner失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("banner数据显示。。。。",s.toString());
                        BannerBean info = JSONUtils.toObject(s, BannerBean.class);
                        mView.responseBannerData(info);
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void getEduData(String cardno) {
        Subscription subscribe = mModel.getEduData(cardno)
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
                        Log.e("", "获取到自己的分数 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("获取到自己的分数：：：",s.toString());
                        EduDataBean info = JSONUtils.toObject(s, EduDataBean.class);
                        mView.responseEduData(info);
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void getTaskData(String Card) {
        Subscription subscribe = mModel.getTaskData(Card)
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
                        TaskListBean info = JSONUtils.toObject(s, TaskListBean.class);
                        if (info.getStatusCode() == 0) {
                            mView.responseTaskData(info);
                        } else {
                            mView.responseTaskDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

}