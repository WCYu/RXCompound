package com.rxjy.rxcompound.mvp.presenter;

import android.util.Log;

import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.entity.CheckIsBeingBean;
import com.rxjy.rxcompound.entity.TaskBean;
import com.rxjy.rxcompound.entity.TaskListBean;
import com.rxjy.rxcompound.mvp.contract.TaskContract;
import com.rxjy.rxcompound.mvp.model.TaskModel;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by hjh on 2018/4/9.
 */

public class TaskPresenter extends TaskContract.Presenter{
    public TaskPresenter(TaskContract.View mView) {
        this.mView = mView;
        mModel = new TaskModel();
    }
    @Override
    public void getTaskDetails(String taskId) {
        Subscription subscribe = mModel.getTaskDetails(taskId)
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
                        TaskBean info = JSONUtils.toObject(s, TaskBean.class);
                        if(info.getStatusCode()==0){//同意
                            mView.responseTask(info);
                        }else if(info.getStatusCode()==-1){
                            mView.responseTaskError(info.getStatusMsg());
                        }

                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void submitTask(String id, String t_link, String t_commitDescription, String imgId, String card) {
        Subscription subscribe = mModel.submitTask(id, t_link, t_commitDescription, imgId, card)
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
                        TaskBean info = JSONUtils.toObject(s, TaskBean.class);
                        if(info.getStatusCode()==0){//同意
                            mView.responsesubmitTask(info);
                        }else if(info.getStatusCode()==-1){
                            mView.responsesubmitTaskError(info.getStatusMsg());
                        }

                    }
                });
        addSubscribe(subscribe);
    }
}
