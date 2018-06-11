package com.rxjy.rxcompound.mvp.contract;

import com.rxjy.rxcompound.commons.base.BaseModel;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.base.BaseView;
import com.rxjy.rxcompound.entity.CustomerBean;

import java.util.List;

import rx.Observable;

/**
 * Created by asus on 2018/4/13.
 */

public interface CusromerHomeContract {
    interface View extends BaseView {
        void responseCustomerData(List<CustomerBean.BodyBean> mlist);

        void showMessage(String msg);

        void showDialog();

        void hideDialog();

    }
    interface Model extends BaseModel {
        Observable<String> loadCustomerData(
                String CardNo
        );
    }
    abstract class Presenter extends BasePresenter<CusromerHomeContract.View, CusromerHomeContract.Model> {
        public abstract void loadCustomerData(
                String CardNo
        );
    }
}
