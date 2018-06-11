package com.rxjy.rxcompound.des.mvp.contract;

import com.rxjy.rxcompound.commons.base.BaseModel;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.base.BaseView;
import com.rxjy.rxcompound.des.entity.TalkContractBean;

import rx.Observable;

/**
 * Created by hjh on 2018/5/15.
 */

public interface TalkContractContract {

    interface View extends BaseView {

        void responseData(TalkContractBean data);

        void responseDataError(String msg);

        void responsesubmitData();

        void responsesubmitDataError(String msg);

        void showDialog();

        void hideDialog();


    }

    interface Model extends BaseModel {

        Observable<String> getData(
                String rwdId
        );
        Observable<String> submitData(
                String ca,
                String rwdId
        );
    }

    abstract class Presenter extends BasePresenter<View, Model> {

        public abstract void getData(
                String rwdId
        );

        public abstract void submitData(
                String ca,
                String rwdId
        );

    }
}
