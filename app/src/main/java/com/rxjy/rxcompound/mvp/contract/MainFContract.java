package com.rxjy.rxcompound.mvp.contract;

import com.rxjy.rxcompound.commons.base.BaseModel;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.base.BaseView;
import com.rxjy.rxcompound.entity.CheckIsBeingBean;
import com.rxjy.rxcompound.entity.FindBean;

import rx.Observable;

/**
 * Created by hjh on 2017/11/14.
 */

public interface MainFContract {

    interface View extends BaseView {

        void responsepersondata(CheckIsBeingBean data);

        void responsepersondataError(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {
        Observable<String> getpersondata(
                String cardNo,
                int pageIndex,
                int pageSize
        );
    }


    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void getpersondata(
                String cardNo,
                int pageIndex,
                int pageSize
        );

    }
}
