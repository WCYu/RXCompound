package com.rxjy.rxcompound.mvp.contract;

import com.rxjy.rxcompound.commons.base.BaseModel;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.base.BaseView;
import com.rxjy.rxcompound.des.entity.LHouseNumBean;
import com.rxjy.rxcompound.entity.CustomerBean;

import java.util.List;

import rx.Observable;

/**
 * Created by asus on 2018/4/13.
 */

public interface CustomerContract {
    interface View extends BaseView {
        void responseCustomerData(List<CustomerBean.BodyBean> mlist);

        void showMessage(String msg);

        void showDialog();

        void hideDialog();

        void loaDareaid(LHouseNumBean info);

    }
    interface Model extends BaseModel {
        Observable<String> loadCustomerData(
                String cardNo,
                String type
        );
        Observable<String> GetOrderNumber(
                String  areaid,
                String  phone

        );
    }
    abstract class Presenter extends BasePresenter<CustomerContract.View, CustomerContract.Model> {
        public abstract void loadCustomerData(
                String cardNo,
                String type
        );
        public abstract void  GetOrderNumber(
                String  areaid,
                String  phone

        );
    }
}
