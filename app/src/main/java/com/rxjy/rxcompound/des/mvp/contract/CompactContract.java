package com.rxjy.rxcompound.des.mvp.contract;

import com.rxjy.rxcompound.commons.base.BaseModel;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.base.BaseView;
import com.rxjy.rxcompound.des.entity.DesignInfo;

import rx.Observable;

/**
 * Created by asus on 2018/5/14.
 */

public interface CompactContract {
    interface View extends BaseView {
        void getDegisInfoData(DesignInfo.BodyBean bodyBean);

        void showMessage(String message);

        void showDialog();

        void hideDialog();
    }
    interface Model extends BaseModel {

        Observable<String> getDegisInfoData(
                String rwdId


        );
    }
    abstract class Presenter extends BasePresenter<View, Model> {


        public abstract void getDegisInfoData(
                String rwdId
        );
    }
}
