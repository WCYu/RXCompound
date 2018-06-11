package com.rxjy.rxcompound.supervision.mvp.contract;


import com.rxjy.rxcompound.commons.base.BaseModel;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.base.BaseView;
import com.rxjy.rxcompound.supervision.entity.DatumListInfo;

import rx.Observable;

/**
 * Created by AAA on 2017/12/21.
 */

public interface ElectronicContract {

    interface View extends BaseView {

        void responsePaperData(DatumListInfo.DatumInfo data);

        void responsePaperDataError(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {

        Observable<String> getPaperInfo(
                String orderNo
        );

    }

    abstract class Presenter extends BasePresenter<View, Model> {

        public abstract void getPaperInfo(
                String orderNo
        );

    }

}
