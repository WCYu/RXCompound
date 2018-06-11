package com.rxjy.rxcompound.des.mvp.contract;

import com.rxjy.rxcompound.commons.base.BaseModel;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.base.BaseView;
import com.rxjy.rxcompound.des.entity.ShopBean;

import rx.Observable;

/**
 * Created by asus on 2018/5/24.
 */

public interface ShopContract {
    interface View extends BaseView {


        void showDialog();

        void hideDialog();

        void showMessage(String msg);

        void shopresopneData(ShopBean.BodyBean bodyBean);

    }

    interface Model extends BaseModel {
        Observable<String> GetShopBean(
                String cardNo
        );

        Observable<String> psotUpShopInfo(
                String cardNo,
                String image,
                int age,
                int workYears,
                String english,
                String consultation,
                String motto
        );

    }

    abstract class Presenter extends BasePresenter<ShopContract.View, ShopContract.Model> {
        public abstract void GetShopBean(
                String cardNo
        );
        public abstract void psotUpShopInfo(
                String cardNo,
                String image,
                int age,
                int workYears,
                String english,
                String consultation,
                String motto
        );

    }
}
