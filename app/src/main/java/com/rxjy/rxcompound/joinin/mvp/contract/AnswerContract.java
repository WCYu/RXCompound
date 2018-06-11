package com.rxjy.rxcompound.joinin.mvp.contract;

import com.rxjy.rxcompound.commons.base.BaseModel;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.base.BaseView;
import com.rxjy.rxcompound.entity.CheckIsBeingBean;
import com.rxjy.rxcompound.entity.ResultBean;
import com.rxjy.rxcompound.mvp.contract.AgreeDesContract;

import rx.Observable;

/**
 * Created by asus on 2018/5/31.
 */

public interface AnswerContract {

    interface View extends BaseView {

        void responseAgreeYes();

        void showDialog();

        void hideDialog();

        void responseConsent(CheckIsBeingBean data);
        void responseConsentError(String msg);
        void showToast();

    }

    interface Model extends BaseModel {
        Observable<String> getAgreeYes(
                String card,
                String arr
        );
        Observable<String> getConsent(
                String cardNo,
                String Type
        );
    }

    abstract class Presenter extends BasePresenter<AnswerContract.View, AnswerContract.Model> {
        public abstract void getAgreeYes(
                String card,
                String arr
        );
        public abstract void getConsent(
                String cardNo,
                String Type
        );
    }
}
