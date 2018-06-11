package com.rxjy.rxcompound.mvp.contract;

import com.rxjy.rxcompound.commons.base.BaseModel;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.base.BaseView;
import com.rxjy.rxcompound.entity.JiFenBean;

import rx.Observable;

/**
 * Created by hjh on 2018/4/2.
 */

public interface JiFenZAContract {

    interface View extends BaseView {

        void responsegetMessage(JiFenBean data);

        void responsegetMessageError(String msg);

        void showDialog();

        void hideDialog();
    }

    interface Model extends BaseModel {

        Observable<String> getMessage(
                String cardNo
        );

    }


    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void getMessage(
                String cardNo
        );

    }
}
