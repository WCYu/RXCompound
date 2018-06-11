package com.rxjy.rxcompound.mvp.contract;

import com.rxjy.rxcompound.commons.base.BaseModel;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.base.BaseView;
import com.rxjy.rxcompound.entity.AdRedEnvelopesBean;
import com.rxjy.rxcompound.entity.NumberPackets;
import com.rxjy.rxcompound.entity.UserStatusBean;

import java.util.List;

import rx.Observable;

/**
 * Created by hjh on 2017/11/20.
 */

public interface GetUserStatusContract {

    interface View extends BaseView {

        void responseUserStatus(UserStatusBean data);

        void responseUserStatusError(String msg);

        void showDialog();

        void hideDialog();
        void responseTaskData(NumberPackets.BodyBean mlist);

    }

    interface Model extends BaseModel {
        Observable<String> getUserStatus(
                String cardNo
        );
        Observable<String> getRedTask(
                String cardNo
        );
    }


    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void getUserStatus(
                String cardNo
        );
        public abstract void getRedTask(
                String cardNo
        );
    }
}
