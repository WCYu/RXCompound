package com.rxjy.rxcompound.business.mvp.contract;

import com.rxjy.rxcompound.business.entity.CustomerBean;
import com.rxjy.rxcompound.business.entity.CustomerNewBean;
import com.rxjy.rxcompound.commons.base.BaseModel;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.base.BaseView;

import rx.Observable;

/**
 * Created by hjh on 2018/5/11.
 */

public interface CustomerNewContract {

    interface View extends BaseView {

        void responsegetCustomer(CustomerNewBean data);

        void responsegetCustomerError(String msg);

        void responsegetCustomerMore(CustomerNewBean data);

        void responsegetCustomerMoreError(String msg);

        void showDialog();

        void hideDialog();
    }

    interface Model extends BaseModel {

        Observable<String> getCustomer(
                String card,
                String PageSize,
                String pageIndex
        );
        Observable<String> getCustomerMore(
                String card,
                String PageSize,
                String pageIndex
        );
    }

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void getCustomer(
                String card,
                String PageSize,
                String pageIndex
        );
        public abstract void getCustomerMore(
                String card,
                String PageSize,
                String pageIndex
        );
    }
}
