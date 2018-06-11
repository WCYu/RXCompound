package com.rxjy.rxcompound.mvp.contract;

import com.rxjy.rxcompound.commons.base.BaseModel;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.base.BaseView;
import com.rxjy.rxcompound.entity.AssementBean;
import com.rxjy.rxcompound.entity.FindBean;

import rx.Observable;

/**
 * Created by hjh on 2017/11/16.
 */

public interface JobTryAnContract {


    interface View extends BaseView {

        void responseGetData(AssementBean data);

        void responseGetDataError(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {
        Observable<String> getGetData(
                String cardNo,
                String dept,
                String dayIndex
        );
    }


    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void getGetData(
                String cardno,
                String dept,
                String dayIndex
        );

    }

}
