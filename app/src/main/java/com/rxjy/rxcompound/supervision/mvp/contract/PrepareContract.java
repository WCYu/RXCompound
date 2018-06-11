package com.rxjy.rxcompound.supervision.mvp.contract;


import com.rxjy.rxcompound.commons.base.BaseModel;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.base.BaseView;
import com.rxjy.rxcompound.supervision.entity.PrepareInfo;

import java.util.List;

import rx.Observable;

/**
 * Created by Administrator on 2017/4/30.
 */
public interface PrepareContract {

    interface View extends BaseView {

        void responsePrepareData(List<PrepareInfo.PrepareGroup> dataList);

        void responsePrepareDataError(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {
        Observable<String> getProjectProcess(
                String orderNo
        );
    }

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void getProjectProcess(
                String orderNo
        );
    }

}
