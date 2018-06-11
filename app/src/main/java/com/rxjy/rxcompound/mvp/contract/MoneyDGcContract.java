package com.rxjy.rxcompound.mvp.contract;

import com.rxjy.rxcompound.commons.base.BaseModel;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.base.BaseView;
import com.rxjy.rxcompound.entity.MoneyDGcJixiaoBean;

import rx.Observable;

/**
 * Created by hjh on 2018/3/19.
 */

public interface MoneyDGcContract {

    interface View extends BaseView {

        void responsegcjixiaodata(MoneyDGcJixiaoBean data);

        void responsegcjixiaodataError(String msg);

        void responsegcchuangshoudata(MoneyDGcJixiaoBean data);

        void responsegcchuangshoudataError(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {
        Observable<String> getgcjixiaodata(
                String year,
                String month,
                String cardNo
        );

        Observable<String> getgcchuangshoudata(
                String year,
                String month,
                String cardNo
        );
    }

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void getgcjixiaodata(//工程绩效
                                             String year,
                                             String month,
                                             String cardNo
        );

        public abstract void getgcchuangshoudata(//工程创收
                                                 String year,
                                                 String month,
                                                 String cardNo
        );
    }
}
