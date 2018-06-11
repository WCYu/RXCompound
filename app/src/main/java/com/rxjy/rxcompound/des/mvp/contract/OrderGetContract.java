package com.rxjy.rxcompound.des.mvp.contract;

import com.rxjy.rxcompound.commons.base.BaseModel;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.base.BaseView;
import com.rxjy.rxcompound.des.entity.OrderGetBean;
import com.rxjy.rxcompound.des.entity.ResultBean;

import rx.Observable;

/**
 * Created by hjh on 2018/4/16.
 */

public interface OrderGetContract {

    interface View extends BaseView {

        void responseGetData(OrderGetBean info);

        void responseGetDataError(String msg);

        void responseOrderDeal(ResultBean info);

        void responseOrderDealError(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {
        Observable<String> GetData(
                String rwdid
        );
        Observable<String> OrderDeal(
                String rwdid,
                String formpars,
                String type
        );

    }

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void GetData(
                String rwdid
        );
        public abstract void OrderDeal(
                String rwdid,
                String formpars,
                String type
        );

    }
}
