package com.rxjy.rxcompound.mvp.contract;

import com.rxjy.rxcompound.commons.base.BaseModel;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.base.BaseView;
import com.rxjy.rxcompound.entity.MoneyTzBean;

import rx.Observable;

/**
 * Created by hjh on 2018/3/27.
 */

public interface MoneyTzContract {
    interface View extends BaseView {

        void responsetzmoneydata(MoneyTzBean data);

        void responsetzmoneydataError(String msg);

        void responsexzmoneydata(MoneyTzBean data);

        void responsexzmoneydataError(String msg);

        void responsekjmoneydata(MoneyTzBean data);

        void responsekjmoneydataError(String msg);

        void responsecnmoneydata(MoneyTzBean data);

        void responsecnmoneydataError(String msg);

        void showDialog();

        void hideDialog();
    }

    interface Model extends BaseModel {
        Observable<String> gettzmoneydata(
                String year,
                String month,
                String cardNo
        );
        Observable<String> getxzmoneydata(
                String year,
                String month,
                String cardNo
        );
        Observable<String> getkjmoneydata(
                String year,
                String month,
                String cardNo
        );
        Observable<String> getcnmoneydata(
                String year,
                String month,
                String cardNo
        );
    }

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void gettzmoneydata(
                String year,
                String month,
                String cardNo
        );
        public abstract void getxzmoneydata(
                String year,
                String month,
                String cardNo
        );
        public abstract void getkjmoneydata(
                String year,
                String month,
                String cardNo
        );
        public abstract void getcnmoneydata(
                String year,
                String month,
                String cardNo
        );
    }

}