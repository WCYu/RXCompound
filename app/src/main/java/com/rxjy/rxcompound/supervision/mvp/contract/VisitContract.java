package com.rxjy.rxcompound.supervision.mvp.contract;


import com.rxjy.rxcompound.commons.base.BaseModel;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.base.BaseView;
import com.rxjy.rxcompound.supervision.entity.VisitInfo;

import java.util.List;

import rx.Observable;

/**
 * Created by AAA on 2017/11/6.
 */

public interface VisitContract {

    interface View extends BaseView {

        void responseAddVisitData();

        void responseAddVisitDataError(String msg);

        void responseVisitData(List<VisitInfo.Visit> dataList);

        void responseVisitDataError(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {

        Observable<String> getWorkLog(
                String orderNo
        );

        Observable<String> subWorkLog(
                String orderNo,
                String content,
                List<String> tagList,
                String importance
        );

    }

    abstract class Presenter extends BasePresenter<View, Model> {

        public abstract void getWorkLog(
                String orderNo
        );

        public abstract void subWorkLog(
                String orderNo,
                String content,
                List<String> tagList,
                String importance
        );

    }

}
