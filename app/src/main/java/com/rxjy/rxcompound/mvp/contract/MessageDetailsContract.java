package com.rxjy.rxcompound.mvp.contract;

import com.rxjy.rxcompound.commons.base.BaseModel;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.base.BaseView;
import com.rxjy.rxcompound.entity.InfoMessageBean;
import com.rxjy.rxcompound.entity.MessageDetailsBean;

import rx.Observable;

/**
 * Created by hjh on 2018/3/9.
 */

public interface MessageDetailsContract {

    interface View extends BaseView {

        void responseInfoMessageD(MessageDetailsBean data);

        void responseInfoMessageDError(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {
        Observable<String> getInfoMessageDList(
                String Id
        );
    }


    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void getInfoMessageDList(
                String Id
        );
    }
}
