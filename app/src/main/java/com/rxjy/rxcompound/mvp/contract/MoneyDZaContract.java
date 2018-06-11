package com.rxjy.rxcompound.mvp.contract;

import com.rxjy.rxcompound.commons.base.BaseModel;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.base.BaseView;
import com.rxjy.rxcompound.entity.MoneyDTzFenhongBean;
import com.rxjy.rxcompound.entity.MoneyDTzRewardBean;
import com.rxjy.rxcompound.entity.MoneyDZaProcessBean;
import com.rxjy.rxcompound.entity.MoneyDZaResultBean;
import com.rxjy.rxcompound.entity.MoneyDZaRewardBean;

import rx.Observable;

/**
 * Created by hjh on 2018/3/16.
 */

public interface MoneyDZaContract {


    interface View extends BaseView {

        void responsezaprocessdata(MoneyDZaProcessBean data);

        void responsezaprocessdataError(String msg);

        void responsezaresultdata(MoneyDZaProcessBean data);
//        void responsezaresultdata(MoneyDZaResultBean data);

        void responsezaresultdataError(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {
        Observable<String> getzaprocessdata(
                String year,
                String month,
                String cardNo
        );

        Observable<String> getzaresultdata(
                String year,
                String month,
                String cardNo
        );
    }

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void getzaprocessdata(
                String year,
                String month,
                String cardNo
        );

        public abstract void getzaresultdata(
                String year,
                String month,
                String cardNo
        );

    }

}