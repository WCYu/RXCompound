package com.rxjy.rxcompound.mvp.contract;

import com.rxjy.rxcompound.commons.base.BaseModel;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.base.BaseView;
import com.rxjy.rxcompound.entity.MoneyDBusJFBean;
import com.rxjy.rxcompound.entity.MoneyDBusJFKQMoreBean;

import rx.Observable;

/**
 * Created by hjh on 2018/4/11.
 */

public interface MoneyDBusjfContract {


    interface View extends BaseView {


        void responsebuskqdata(MoneyDBusJFBean data);

        void responsebuskqdataError(String msg);

        void responsebuskqmoredata(MoneyDBusJFKQMoreBean data);

        void responsebuskqmoredataError(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {
        Observable<String> getbuskqdata(
                String year,
                String month,
                String cardNo
        );
        Observable<String> getbuskqmoredata(
                String year,
                String month,
                String cardNo
        );
    }


    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void getbuskqdata(//商务奖罚考勤
                                             String year,
                                             String month,
                                             String cardNo
        );
        public abstract void getbuskqmoredata(//商务奖罚考勤以下
                                               String year,
                                               String month,
                                               String cardNo
        );
    }
}
