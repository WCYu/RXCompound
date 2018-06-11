package com.rxjy.rxcompound.mvp.contract;

import com.rxjy.rxcompound.commons.base.BaseModel;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.base.BaseView;
import com.rxjy.rxcompound.entity.MoneyBusRewardBean;
import com.rxjy.rxcompound.entity.MoneyDGcJixiaoBean;
import com.rxjy.rxcompound.entity.MoneyDTZRSProgressBean;
import com.rxjy.rxcompound.entity.MoneyDTZRSResultBean;
import com.rxjy.rxcompound.entity.MoneyDTzProcessBean;
import com.rxjy.rxcompound.entity.MoneyDTzResultBean;

import rx.Observable;

/**
 * Created by hjh on 2018/3/15.
 */
public interface MoneyDTzContract {

    interface View extends BaseView {

        void responsetzresultdata(MoneyDTzResultBean data);

        void responsetzresultdataError(String msg);

        void responsetzprocesdata(MoneyDTzProcessBean data);

        void responsetzprocesdataError(String msg);

        void responsebusrewarddata(MoneyBusRewardBean data);

        void responsebusrewarddataError(String msg);

        void responsetzrsresultdata(MoneyDTZRSResultBean data);

        void responsetzrsresultdataError(String msg);

        void responsetzrsprocesdata(MoneyDTZRSProgressBean data);

        void responsetzrsprocesdataError(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {
        Observable<String> gettzresultdata(
                String year,
                String month,
                String cardNo
        );
        Observable<String> gettzprocessdata(
                String year,
                String month,
                String cardNo
        );
        Observable<String> getbusrewarddata(
                String year,
                String month,
                String cardNo
        );
        Observable<String> gettzrsresultdata(//投资人事经理结果
                                             String year,
                                             String month,
                                             String cardNo
        );
        Observable<String> gettzrsprocessdata(//投资人事经理过程
                                              String year,
                                              String month,
                                              String cardNo
        );
    }

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void gettzresultdata(//投资行政经理结果
                                             String year,
                                             String month,
                                             String cardNo
        );
        public abstract void gettzprocessdata(//投资行政经理过程
                                               String year,
                                               String month,
                                               String cardNo
        );
        public abstract void getbusrewarddata(//商务奖罚
                                              String year,
                                              String month,
                                              String cardNo
        );
        public abstract void gettzrsresultdata(//投资人事经理结果
                                             String year,
                                             String month,
                                             String cardNo
        );
        public abstract void gettzrsprocessdata(//投资人事经理过程
                                              String year,
                                              String month,
                                              String cardNo
        );
    }

}