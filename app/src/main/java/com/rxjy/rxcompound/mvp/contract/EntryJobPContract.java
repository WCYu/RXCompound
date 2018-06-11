package com.rxjy.rxcompound.mvp.contract;

import com.rxjy.rxcompound.commons.base.BaseModel;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.base.BaseView;
import com.rxjy.rxcompound.entity.CheckIsBeingBean;
import com.rxjy.rxcompound.entity.ResultBean;

import rx.Observable;

/**
 * Created by hjh on 2017/11/10.
 */

public interface EntryJobPContract {

    interface View extends BaseView {

        void responseConsent(CheckIsBeingBean data);

        void responseConsentError(String msg);

        void responseEntryJob(CheckIsBeingBean data);

        void responseEntryJobError(String msg);

        void responseIsConsent(ResultBean data);

        void responseIsConsentError(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {
        Observable<String> getConsent(
                String cardNo,
                String Type
        );
        Observable<String> getEntryJob(
                String cardNo
        );
        Observable<String> getIsConsent(//是否同意过岗责、保密协议、入职须知
                                        String CardNo,
                                        String Type
        );
    }

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void getConsent(
                String cardNo,
                String Type
        );
        public abstract void getEntryJob(
                String cardNo
        );
        public abstract void getIsConsent(//是否同意过岗责、保密协议、入职须知
                                          String CardNo,
                                          String Type
        );
    }

}
