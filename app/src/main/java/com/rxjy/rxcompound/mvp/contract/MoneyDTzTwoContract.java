package com.rxjy.rxcompound.mvp.contract;

import com.rxjy.rxcompound.commons.base.BaseModel;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.base.BaseView;
import com.rxjy.rxcompound.entity.BusMoneyBean;
import com.rxjy.rxcompound.entity.MoneyBusHisBean;
import com.rxjy.rxcompound.entity.MoneyDTzFenhongBean;
import com.rxjy.rxcompound.entity.MoneyDTzRewardBean;
import com.rxjy.rxcompound.entity.MoneyDZaRewardBean;

import rx.Observable;

/**
 * Created by hjh on 2018/3/15.
 */

public interface MoneyDTzTwoContract {

    interface View extends BaseView {

        void responsetzfenhongdata(MoneyDTzFenhongBean data);

        void responsetzfenhongdataError(String msg);

        void responsetzrewarddata(MoneyDTzRewardBean data);

        void responsetzrewarddataError(String msg);

        void responsezarewarddata(MoneyDZaRewardBean data);

        void responsezarewarddataError(String msg);

        void responsebusmoneydata(BusMoneyBean data);

        void responsebusmoneydataError(String msg);

        void responsebushisdata(MoneyBusHisBean data);

        void responsebushisdataError(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {
        Observable<String> gettzfenhongdata(
                String year,
                String month,
                String cardNo
        );
        Observable<String> gettzrewarddata(
                String year,
                String month,
                String cardNo
        );
        Observable<String> getzarewarddata(
                String year,
                String month,
                String cardNo
        );
        Observable<String> getbusmoneydata(
                String year,
                String month,
                String cardNo
        );
        Observable<String> getbusmhisdata(
                String diqu,
                String cardNo
        );
    }

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void gettzfenhongdata(//投资行政经理分红
                                             String year,
                                             String month,
                                             String cardNo
        );
        public abstract void gettzrewarddata(//投资行政经理奖罚
                                              String year,
                                              String month,
                                              String cardNo
        );
        public abstract void getzarewarddata(//主案奖罚
                String year,
                String month,
                String cardNo
        );
        public abstract void getbusmoneydata(//商务工资
                                             String year,
                                             String month,
                                             String cardNo
        );
        public abstract void getbusmhisdata(//商务历史
                                             String diqu,
                                             String cardNo
        );
    }

}