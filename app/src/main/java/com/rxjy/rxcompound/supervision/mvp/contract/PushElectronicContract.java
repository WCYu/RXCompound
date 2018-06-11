package com.rxjy.rxcompound.supervision.mvp.contract;


import com.rxjy.rxcompound.commons.base.BaseModel;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.base.BaseView;
import com.rxjy.rxcompound.supervision.entity.PushElectronicInfo;

import rx.Observable;

/**
 * Created by AAA on 2017/12/21.
 */

public interface PushElectronicContract {

    interface View extends BaseView {

        void responsePushElectronicData(PushElectronicInfo.PushElectronic data);

        void responsePushElectronicDataError(String msg);

        void responseSaveElectronicData();

        void responseSaveElectronicDataError(String msg);

        void responseSavePushElectronicData();

        void responseSavePushElectronicDataError(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {

        Observable<String> getPaperInfo(
                String orderNo,
                int attrId
        );

        Observable<String> saveElectronicInfo(
                String orderNo,
                int attrId,
                int eleId,
                String content
        );

        Observable<String> savePushElectronicInfo(
                String orderNo,
                int attrId
        );

    }

    abstract class Presenter extends BasePresenter<View, Model> {

        public abstract void getPaperInfo(
                String orderNo,
                int attrId
        );

        public abstract void saveElectronicInfo(
                String orderNo,
                int attrId,
                int eleId,
                String content
        );

        public abstract void savePushElectronicInfo(
                String orderNo,
                int attrId
        );

    }

}
