package com.rxjy.rxcompound.mvp.contract;

import com.rxjy.rxcompound.commons.base.BaseModel;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.base.BaseView;
import com.rxjy.rxcompound.entity.ResultBean;

import rx.Observable;

/**
 * Created by hjh on 2018/4/21.
 */

public interface AgreeDesContract {

    interface View extends BaseView {

        void responseAgreeYes(ResultBean data);

        void responseAgreeYesError(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {
        Observable<String> getAgreeYes(
                String cardno,
                String type
        );
    }

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void getAgreeYes(
                String cardno,
                String type
        );
    }
}
