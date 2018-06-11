package com.rxjy.rxcompound.des.mvp.contract;

import com.rxjy.rxcompound.commons.base.BaseModel;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.base.BaseView;
import com.rxjy.rxcompound.des.entity.PlanImageBean;
import com.rxjy.rxcompound.des.entity.PlanStrBean;

import rx.Observable;

/**
 * Created by hjh on 2018/4/16.
 */

public interface PlanContract {

    interface View extends BaseView {

        void responseGetTxt(PlanStrBean data);

        void responseGetTxtError(String msg);

        void responseGetImage(PlanImageBean data);

        void responseGetImageError(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {
        Observable<String> GetTxt(
                String rwdId
        );

        Observable<String> GetImage(
                String rwdId
        );

    }

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void GetTxt(
                String rwdId
        );

        public abstract void GetImage(
                String rwdId
        );
    }

}