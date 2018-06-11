package com.rxjy.rxcompound.mvp.model;

import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.mvp.contract.TaskContract;
import com.rxjy.rxcompound.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by hjh on 2018/4/9.
 */

public class TaskModel implements TaskContract.Model{

    @Override
    public Observable<String> getTaskDetails(String taskId) {
        return ApiEngine.getInstance().getRsApiService()
                .getTaskDetails(taskId)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> submitTask(String id, String t_link, String t_commitDescription, String imgId, String card) {
        return ApiEngine.getInstance().getRsApiService()
                .submitTask(id, t_link, t_commitDescription, imgId, card)
                .compose(RxSchedulers.<String>switchThread());
    }
}
