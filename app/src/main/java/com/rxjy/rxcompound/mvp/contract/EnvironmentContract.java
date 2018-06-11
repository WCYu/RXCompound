package com.rxjy.rxcompound.mvp.contract;

import com.rxjy.rxcompound.commons.base.BaseModel;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.base.BaseView;
import com.rxjy.rxcompound.entity.EnvirBean;
import com.rxjy.rxcompound.entity.FigureListBean;

import rx.Observable;

/**
 * Created by hjh on 2018/4/26.
 */

public interface EnvironmentContract {

    interface View extends BaseView {

        void responseEnvir(EnvirBean data);

        void responseEnvirError(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {
        Observable<String> getEnvir(
                String CardNo,
                String RegionId,
                String Type
        );
    }

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void getEnvir(
                String CardNo,
                String RegionId,
                String Type
        );
    }
}
