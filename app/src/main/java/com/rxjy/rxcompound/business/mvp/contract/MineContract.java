package com.rxjy.rxcompound.business.mvp.contract;

import com.rxjy.rxcompound.business.entity.MyGradeBean;
import com.rxjy.rxcompound.business.entity.MyGradeMoneyBean;
import com.rxjy.rxcompound.commons.base.BaseModel;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.base.BaseView;

import rx.Observable;

/**
 * Created by hjh on 2017/11/23.
 */

public interface MineContract {

    interface View extends BaseView {

        void responsegetMessage(MyGradeBean data);

        void responsegetMessageError(String msg);

        void responsegetGradeMessage(MyGradeMoneyBean data);

        void responsegetGradeMessageError(String msg);

        void showDialog();

        void hideDialog();
    }

    interface Model extends BaseModel {

        Observable<String> getMessage(
                String Kahao
        );
        Observable<String> getGradeMessage(
                String Kahao
        );
    }


    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void getMessage(
                String Kahao
        );
        public abstract void getGradeMessage(
                String Kahao
        );
    }




}
