package com.rxjy.rxcompound.business.mvp.contract;

import com.rxjy.rxcompound.business.entity.CustomerBean;
import com.rxjy.rxcompound.business.entity.MyGradeBean;
import com.rxjy.rxcompound.business.entity.MyGradeMoneyBean;
import com.rxjy.rxcompound.commons.base.BaseModel;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.base.BaseView;

import rx.Observable;

/**
 * Created by hjh on 2017/11/24.
 */

public interface CustomerContract {

    interface View extends BaseView {

        void responsegetCustomer(CustomerBean data);

        void responsegetCustomerError(String msg);

        void responsegetCustomerMore(CustomerBean data);

        void responsegetCustomerMoreError(String msg);

        void showDialog();

        void hideDialog();
    }

    interface Model extends BaseModel {

        Observable<String> getCustomer(
                String card,
                String pageIndex,
                String PageSize,
                String key
        );
        Observable<String> getCustomerMore(
                String card,
                String pageIndex,
                String PageSize,
                String key
        );
    }

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void getCustomer(
                String card,
                String pageIndex,
                String PageSize,
                String key
        );
        public abstract void getCustomerMore(
                String card,
                String pageIndex,
                String PageSize,
                String key
        );
    }
}
