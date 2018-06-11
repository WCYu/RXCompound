package com.rxjy.rxcompound.mvp.contract;

import com.rxjy.rxcompound.commons.base.BaseModel;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.base.BaseView;
import com.rxjy.rxcompound.entity.CheckIsBeingBean;
import com.rxjy.rxcompound.entity.PersonBean;
import com.rxjy.rxcompound.entity.UserStatusBean;
import com.rxjy.rxcompound.entity.VPhoneBean;
import com.rxjy.rxcompound.entity.ZiDonBean;

import rx.Observable;

/**
 * Created by hjh on 2017/11/3.
 */

public interface LoginContract {

    interface View extends BaseView {

        void responseIsCheck(VPhoneBean data);

        void responseTokenError(String msg);

        void responseVerityCode(CheckIsBeingBean data);

        void responseVerityError(String msg);

        void responseLogin(CheckIsBeingBean data);

        void responseLoginError(String msg);

        void responseIsConsent(CheckIsBeingBean data);

        void responseIsConsentError(String msg);

        void responseUserStatus(UserStatusBean data);

        void responseUserStatusError(String msg);

        void responseIsPrefect(PersonBean data);

        void responseIsPrefectError(String msg);

        void showDialog();

        void hideDialog();

        void responseZiDonLogin(ZiDonBean ziDonBean);

    }

    interface Model extends BaseModel {
        Observable<String> getCheckIsVerity(
                String cardNo
        );
        Observable<String> getVerityCode(
                String cardNo
        );
        Observable<String> tologin(
                String cardNo,
                String verityCode,
                String pwd
        );
        Observable<String> getIsConsent(
                String cardNo,
                String Type
        );
        Observable<String> getUserStatus(
                String cardNo
        );

        Observable<String> getIsPrefect(
                String Phone,
                String Type
        );

        Observable<String> getLoginTz(
                String cardno,
                String data
        );
        Observable<String> getCheckToken(
                String CardNo,
                String Token
        );
    }

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void getCheckIsVerity(
                String cardNo
        );
        public abstract void getVerityCode(
                String cardNo
        );
        public abstract void tologin(
                String cardNo,
                String verityCode,
                String pwd
        );
        public abstract void getIsConsent(
                String CardNo,
                String Type
        );
        public abstract void getUserStatus(
                String cardNo
        );
        public abstract void getIsPrefect(
                String Phone,
                String Type
        );

        public abstract void getLoginTz(
                String cardno,
                String data
        );
        public abstract void getCheckToken(
                String CardNo,
                String Token
        );
    }

}
