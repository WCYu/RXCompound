package com.rxjy.rxcompound.mvp.contract;

import com.rxjy.rxcompound.commons.base.BaseModel;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.base.BaseView;
import com.rxjy.rxcompound.entity.UserStatusBean;

import rx.Observable;

/**
 * Created by Administrator on 2018/3/30.
 */

public interface ForgetPwdContract {

    interface View extends BaseView {

        void responseVCode(String str);

        void responseVCodeError(String msg);

        void responsetoFixPwd();

        void responsetoFixPwdError(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {
        Observable<String> getVCode(
                String phone
        );

        Observable<String> toFixPwd(
                String phone,
                String newPassword,
                String vCode
        );

    }


    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void getVCode(
                String phone
        );

        public abstract void toFixPwd(
                String phone,
                String newPassword,
                String vCode
        );

    }
}

