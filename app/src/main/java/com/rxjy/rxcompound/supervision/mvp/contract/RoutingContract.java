package com.rxjy.rxcompound.supervision.mvp.contract;

import com.rxjy.rxcompound.commons.base.BaseModel;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.base.BaseView;
import com.rxjy.rxcompound.supervision.entity.RoutingListInfo;
import com.rxjy.rxcompound.supervision.entity.RoutingStateInfo;

import java.util.List;

import rx.Observable;

/**
 * Created by AAA on 2017/11/3.
 */

public interface RoutingContract {

    interface View extends BaseView {

        void responseRoutingListData(List<RoutingListInfo.RoutingInfo> dataList);

        void responseRoutingListDataError(String msg);

        void responseRoutingStateData(RoutingStateInfo.RoutingState data);

        void responseRoutingStateDataError(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {

        Observable<String> getRoutingList(
                String orderNo
        );

        Observable<String> getRoutingState(
                String orderNo
        );

    }

    abstract class Presenter extends BasePresenter<View, Model> {

        public abstract void getRoutingList(
                String orderNo
        );

        public abstract void getRoutingState(
                String orderNo
        );

    }

}
