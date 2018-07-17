package com.example.asus.customer.mvp.contract;

import com.example.asus.customer.commons.base.BaseModel;
import com.example.asus.customer.commons.base.BasePresenter;
import com.example.asus.customer.commons.base.BaseView;
import com.example.asus.customer.entity.CheckInfo;
import com.example.asus.customer.entity.ProjectBean;

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
    abstract class Presenter extends BasePresenter<QrLoginContract.View, QrLoginContract.Model> {
        public abstract void getRrLogin(
                String cardNo,
                String password,
                String loginId
        );
    }
}
