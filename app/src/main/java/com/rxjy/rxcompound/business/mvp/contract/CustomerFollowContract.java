package com.rxjy.rxcompound.business.mvp.contract;

import com.rxjy.rxcompound.business.entity.StatusBean;
import com.rxjy.rxcompound.commons.base.BaseModel;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.base.BaseView;

import rx.Observable;

/**
 * Created by hjh on 2017/11/30.
 */

public interface CustomerFollowContract {


    interface View extends BaseView {

        void responsegetaddCustomerV(StatusBean data);

        void responsegetaddCustomerVError(String msg);

        void showDialog();

        void hideDialog();
    }

    interface Model extends BaseModel {

        Observable<String> addCustomervisit(
                int KeHuBaseID,
                int salesmanid,
                String content,
                int areaid,
                String nexttime,
                int status
        );
    }

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void addCustomervisit(
                int KeHuBaseID,
                int salesmanid,
                String content,
                int areaid,
                String nexttime,
                int status
        );
    }

}
