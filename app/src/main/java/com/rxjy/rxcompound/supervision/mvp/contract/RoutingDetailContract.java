package com.rxjy.rxcompound.supervision.mvp.contract;

import com.rxjy.rxcompound.commons.base.BaseModel;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.base.BaseView;
import com.rxjy.rxcompound.supervision.entity.RoutingDetailInfo;

import java.util.List;

import rx.Observable;

/**
 * Created by AAA on 2018/1/17.
 */

public interface RoutingDetailContract {

    interface View extends BaseView {

        void responseRoutingDetail(List<RoutingDetailInfo.RoutingMarkInfo> dataList);

        void responseRoutingDetailError(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {

        Observable<String> getRoutingDetail(
                String orderNo,
                int xjID
        );

    }

    abstract class Presenter extends BasePresenter<View, Model> {

        public abstract void getRoutingDetail(
                String orderNo,
                int xjID
        );

    }

}
