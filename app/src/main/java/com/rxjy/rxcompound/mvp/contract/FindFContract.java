package com.rxjy.rxcompound.mvp.contract;

import android.content.Intent;

import com.rxjy.rxcompound.commons.base.BaseModel;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.base.BaseView;
import com.rxjy.rxcompound.entity.FindBean;

import rx.Observable;

/**
 * Created by hjh on 2017/11/13.
 */

public interface FindFContract {

    interface View extends BaseView {

        void responseFindData(FindBean data);

        void responseFindDataError(String msg);

        void responseFindDataLoadmore(FindBean data);

        void responseFindDataLoadmoreError(String msg);

        void showDialog();

        void hideDialog();

        void obtainWhetheData(int i);

    }

    interface Model extends BaseModel {
        Observable<String> getFindList(
                String cardNo,
                String appId,
                int pageIndex,
                int pageSize
        );
        Observable<String> getFindListLoadmore(
                String cardNo,
                String appId,
                int pageIndex,
                int pageSize
        );
        Observable<String> getFindObtainWhethe(
                String CardNo

        );
    }


    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void getFindList(
                String cardNo,
                String appId,
                int pageIndex,
                int pageSize
        );

        public abstract void getFindListLoadmore(
                String cardNo,
                String appId,
                int pageIndex,
                int pageSize
        );
        public abstract void getFindObtainWhethe(
                String CardNo

        );
    }
}
