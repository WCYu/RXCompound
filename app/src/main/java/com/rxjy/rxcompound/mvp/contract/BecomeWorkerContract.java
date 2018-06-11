package com.rxjy.rxcompound.mvp.contract;

import com.rxjy.rxcompound.commons.base.BaseModel;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.base.BaseView;
import com.rxjy.rxcompound.entity.BecomeBean;
import com.rxjy.rxcompound.entity.BeconmeConditionsBean;

import rx.Observable;

/**
 * Created by asus on 2018/5/18.
 */
//> GET actionapi/AppCurrencyHome/ApplyFormalUser
public interface BecomeWorkerContract {

    interface View extends BaseView {

        void responseBecomeDataError(String msg);

        void showDialog();

        void hideDialog();

        void responseBeconmeConditions(BeconmeConditionsBean.BodyBean bodyBean);

        void responseBeconmeData(BecomeBean becomeBean);

    }

    interface Model extends BaseModel {

        Observable<String> getSubmitBecome(
                String CardNo,
                String Reason1,
                String Reason2

        );
        Observable<String> getSubmitConditions(
                String CardNo


        );
    }
    abstract class Presenter extends BasePresenter<BecomeWorkerContract.View, BecomeWorkerContract.Model> {
        public abstract void getSubmitBecome(
                String CardNo,
                String Reason1,
                String Reason2
        );
        public abstract void getSubmitConditions(
                String CardNo

        );
    }
}
