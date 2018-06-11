package com.rxjy.rxcompound.mvp.contract;

import com.rxjy.rxcompound.commons.base.BaseModel;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.base.BaseView;
import rx.Observable;

/**
 * Created by hjh on 2018/4/4.
 */

public interface BackVisitContract {

    interface View extends BaseView {
        void responseTalkData();

        void responseTalkDataError(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {
        Observable<String> addHuiFangData(
                String rwdId,
                String content,
                int methods
        );
    }

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void addHuiFangData(
                String rwdId,
                String content,
                int methods
        );
    }

}
