package com.rxjy.rxcompound.mvp.contract;

import com.rxjy.rxcompound.commons.base.BaseModel;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.base.BaseView;
import com.rxjy.rxcompound.entity.CheckIsBeingBean;
import com.rxjy.rxcompound.entity.HospitalBean;
import com.rxjy.rxcompound.entity.MoneyBean;
import com.rxjy.rxcompound.entity.MoneyBusBean;
import com.rxjy.rxcompound.entity.MoneyBusNewBean;
import com.rxjy.rxcompound.entity.MoneyDesBean;
import com.rxjy.rxcompound.entity.MoneySupBean;
import com.rxjy.rxcompound.entity.MoneyTzBean;

import rx.Observable;

/**
 * Created by hjh on 2018/3/2.
 */

public interface MoneyContract {

    interface View extends BaseView {

        void responsemoneydata(MoneyBean data);

        void responsemoneydataError(String msg);

        void responsebusmoneydata(MoneyBusBean data);

        void responsebusmoneydataError(String msg);

        void responsebusmoneynewdata(MoneyBusNewBean data);

        void responsebusmoneynewdataError(String msg);

        void responsedesmoneydata(MoneyDesBean data);

        void responsedesmoneydataError(String msg);

        void responsegcmoneydata(MoneySupBean data);

        void responsegcmoneydataError(String msg);

        void responsetzmoneydata(MoneyTzBean data);

        void responsetzmoneydataError(String msg);

        void responsexzmoneydata(MoneyTzBean data);

        void responsexzmoneydataError(String msg);

        void showDialog();

        void hideDialog();

        void responseHospitalSalary(HospitalBean.BodyBean bean);

    }

    interface Model extends BaseModel {
        Observable<String> getmoneydata(
                String card
        );
        Observable<String> getbusmoneynewdata(
                String year,
                String month,
                String cardNo
        );
        Observable<String> getbusmoneydata(
                String year,
                String month,
                String cardNo
        );
        Observable<String> getdesmoneydata(
                String year,
                String month,
                String cardNo
        );
        Observable<String> getgcmoneydata(
                String year,
                String month,
                String cardNo
        );
        Observable<String> gettzmoneydata(
                String year,
                String month,
                String cardNo
        );
        Observable<String> getxzmoneydata(
                String year,
                String month,
                String cardNo
        );

        Observable<String> getHospitaldata(

                String cardNo
        );
    }


    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void getmoneydata(
                String card
        );
        public abstract void getbusmoneydata(
                String year,
                String month,
                String cardNo
        );
        public abstract void getbusmoneynewdata(
                String year,
                String month,
                String cardNo
        );
        public abstract void getdesmoneydata(
                String year,
                String month,
                String cardNo
        );
        public abstract void getgcmoneydata(
                String year,
                String month,
                String cardNo
        );
        public abstract void gettzmoneydata(
                String year,
                String month,
                String cardNo
        );
        public abstract void getxzmoneydata(
                String year,
                String month,
                String cardNo
        );
        public abstract void getHospitaldata(
                String cardNo
        );
    }

}