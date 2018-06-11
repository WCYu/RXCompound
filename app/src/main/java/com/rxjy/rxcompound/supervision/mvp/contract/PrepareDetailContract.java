package com.rxjy.rxcompound.supervision.mvp.contract;


import com.rxjy.rxcompound.commons.base.BaseModel;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.base.BaseView;
import com.rxjy.rxcompound.supervision.entity.ProcessDetailInfo;

import java.util.List;

import rx.Observable;

/**
 * Created by AAA on 2017/11/6.
 */

public interface PrepareDetailContract {

    interface View extends BaseView {

        void responseSubProcessPhotoData();

        void responseSubProcessPhotoDataError(String msg);

        void responseProcessDetailData(List<ProcessDetailInfo.ProcessDetail> dataList);

        void responseProcessDetailDataError(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {

        Observable<String> getProcessDetail(
                int processID
        );

        Observable<String> subProcessDetailPhoto(
                int stepID,
                int processID,
                int stepPhotoID,
                String url
        );

    }

    abstract class Presenter extends BasePresenter<View, Model> {

        public abstract void getProcessDetail(
                int processID
        );

        public abstract void subProcessDetailPhoto(
                int stepID,
                int processID,
                int stepPhotoID,
                String url
        );

    }

}
