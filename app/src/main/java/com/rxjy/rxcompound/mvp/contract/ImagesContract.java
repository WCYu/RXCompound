package com.rxjy.rxcompound.mvp.contract;

import com.rxjy.rxcompound.commons.base.BaseModel;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.base.BaseView;
import com.rxjy.rxcompound.entity.CheckIsBeingBean;

import rx.Observable;

/**
 * Created by hjh on 2017/11/25.
 */

public interface ImagesContract {

    interface View extends BaseView {

        void responseConsent(CheckIsBeingBean data);

        void responseConsentError(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {
        Observable<String> getImage(
                String cardNo,
                String Type
        );
    }

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void getImage(
                String card_no,
                String img_type
        );
    }


}
