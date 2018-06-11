package com.rxjy.rxcompound.mvp.contract;

import com.rxjy.rxcompound.commons.base.BaseModel;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.base.BaseView;
import com.rxjy.rxcompound.entity.TaskBean;

import rx.Observable;

/**
 * Created by hjh on 2018/4/9.
 */

public interface TaskContract {

    interface View extends BaseView {

        void responseTask(TaskBean data);

        void responseTaskError(String msg);

        void responsesubmitTask(TaskBean data);

        void responsesubmitTaskError(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {
        Observable<String> getTaskDetails(
                String taskId
        );

        Observable<String> submitTask(
                String id,
                String t_link,
                String t_commitDescription,
                String imgId,
                String card
        );
    }

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void getTaskDetails(
                String taskId
        );
        public abstract void submitTask(
                String id,
                String t_link,
                String t_commitDescription,
                String imgId,
                String card
        );
    }

}