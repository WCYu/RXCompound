package com.rxjy.rxcompound.mvp.contract;

import com.rxjy.rxcompound.commons.base.BaseModel;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.base.BaseView;
import com.rxjy.rxcompound.entity.BannerBean;
import com.rxjy.rxcompound.entity.EduDataBean;
import com.rxjy.rxcompound.entity.TaskListBean;

import rx.Observable;

/**
 * Created by hjh on 2017/11/13.
 */

public interface HomePageFContract {
    interface View extends BaseView {

        void responseBannerData(BannerBean data);

        void responseBannerDataError(String msg);

        void responseEduData(EduDataBean data);

        void responseEduDataError(String msg);

        void responseTaskData(TaskListBean data);

        void responseTaskDataError(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {
        Observable<String> getBannerList(
                String a_ccount
        );
        Observable<String> getEduData(
                String cardno
        );
        Observable<String> getTaskData(
                String Card
        );
    }


    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void getBannerList(
                String a_ccount
        );
        public abstract void getEduData(
                String cardno
        );
        public abstract void getTaskData(
                String Card
        );
    }

}