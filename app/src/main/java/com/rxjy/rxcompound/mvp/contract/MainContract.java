package com.rxjy.rxcompound.mvp.contract;

import com.rxjy.rxcompound.commons.base.BaseModel;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.base.BaseView;
import com.rxjy.rxcompound.entity.VersionInfo;

import rx.Observable;

/**
 * Created by Administrator on 2017/12/1.
 */

public interface MainContract {

    interface View extends BaseView {

        void responseVersionData(VersionInfo.Version data);

        void responseVersionDataError(String msg);

    }

    interface Model extends BaseModel {

        Observable<String> getVersionInfo(
            int version
        );


    }

    abstract class Presenter extends BasePresenter<View, Model> {

        public abstract void getVersionInfo(
                int version
        );


    }

}
