package com.rxjy.rxcompound.mvp.contract;


import com.rxjy.rxcompound.commons.base.BaseModel;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.base.BaseView;
import com.rxjy.rxcompound.entity.CheckInfo;

import rx.Observable;

/**
 * Created by asus on 2018/5/30.
 */

public interface QrLoginContract {

    interface View extends BaseView {

        void showDialog();

        void hideDialog();

        void showMessage(String message);

        void getRrLoginData(CheckInfo checkInfo);

    }
    interface Model extends BaseModel {
        Observable<String> getRrLogin(
                String cardNo,
                String password,
                String loginId


        );

    }
    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void getRrLogin(
                String cardNo,
                String password,
                String loginId
        );
    }
}
