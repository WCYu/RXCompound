package com.rxjy.rxcompound.supervision.mvp.contract;

import com.rxjy.rxcompound.commons.base.BaseModel;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.base.BaseView;
import com.rxjy.rxcompound.entity.VersionInfo;

import rx.Observable;

/**
 * Created by AAA on 2018/1/18.
 */

public interface MainContract {

    interface View extends BaseView {

        void responseVersionData(VersionInfo.Version data);

        void responseVersionDataError(String msg);

    }

    interface Model extends BaseModel {

        Observable<String> getVersionInfo(

        );

    }

    abstract class Presenter extends BasePresenter<View, Model> {

        public abstract void getVersionInfo(

        );

    }

}