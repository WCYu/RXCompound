package com.rxjy.rxcompound.mvp.contract;

import com.rxjy.rxcompound.commons.base.BaseModel;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.base.BaseView;
import com.rxjy.rxcompound.entity.BusMoneyBean;
import com.rxjy.rxcompound.entity.BusProcessBean;
import com.rxjy.rxcompound.entity.BusResultBean;
import com.rxjy.rxcompound.entity.MoneyBusBean;
import com.rxjy.rxcompound.entity.MoneyDesBean;
import com.rxjy.rxcompound.entity.MoneySupBean;
import com.rxjy.rxcompound.entity.MoneyTzBean;

import rx.Observable;

/**
 * Created by hjh on 2018/3/14.
 */

public interface MoneyDetailsContract {


    interface View extends BaseView {


        void responsebusmoneydata(BusMoneyBean data);

        void responsebusmoneydataError(String msg);

        void responsebusprocesdata(BusProcessBean data);

        void responsebusprocesdataError(String msg);

        void responsebusresultdata(BusResultBean data);

        void responsebusresultdataError(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {
        Observable<String> getbusmoneydata(
                String year,
                String month,
                String cardNo
        );
        Observable<String> getbusprocessdata(
                String year,
                String month,
                String cardNo
        );
        Observable<String> getbusresultdata(
                String year,
                String month,
                String cardNo
        );
    }


    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void getbusmoneydata(//商务工资
                String year,
                String month,
                String cardNo
        );
        public abstract void getbusprocessdata(//商务过程
                String year,
                String month,
                String cardNo
        );
        public abstract void getbusresultdata(//商务结果
                String year,
                String month,
                String cardNo
        );
    }
}
