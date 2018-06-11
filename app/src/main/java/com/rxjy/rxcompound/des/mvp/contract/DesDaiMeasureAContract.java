package com.rxjy.rxcompound.des.mvp.contract;


import com.rxjy.rxcompound.commons.base.BaseModel;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.base.BaseView;
import com.rxjy.rxcompound.des.entity.DesDaiMeasureABean;

import rx.Observable;

/**
 * Created by hjh on 2017/12/14.
 */

public interface DesDaiMeasureAContract {

    interface View extends BaseView {

        void responseLHouseData(DesDaiMeasureABean.BodyBean bodyBean);

        void responseLHouseDataError(String msg);

        void responsesaveLHouseData(String msg);

        void responsesaveLHouseDataError(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {
        Observable<String> getLHouseData(
                String rwdid
        );

        Observable<String> saveLHouseData(
                String rwdId,
                String formpars,
                String money,
                String valCount
        );

    }

    abstract class Presenter extends BasePresenter<View, Model> {


        public abstract void getLHouseData(
                String rwdid
        );

        public abstract void saveLHouseData(
                String rwdId,
                String formpars,
                String money,
                String valCount
        );

    }

}
