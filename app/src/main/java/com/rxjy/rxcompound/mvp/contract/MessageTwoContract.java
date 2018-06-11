package com.rxjy.rxcompound.mvp.contract;

import com.rxjy.rxcompound.commons.base.BaseModel;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.base.BaseView;
import com.rxjy.rxcompound.entity.InfoMessageBean;

import rx.Observable;

/**
 * Created by hjh on 2018/3/9.
 */

public interface MessageTwoContract {


    interface View extends BaseView {

        void responseInfoMessageTwo(InfoMessageBean data);

        void responseInfoMessageTwoError(String msg);

        void responseSeeDetails(InfoMessageBean data);

        void responseSeeDetailsError(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {
        Observable<String> getInfoMessageTwoList(
                String cardNo,
                String Group
        );
        Observable<String> toSeeDetails(
                String id
        );
    }


    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void getInfoMessageTwoList(
                String cardNo,
                String Group
        );
        public abstract void toSeeDetails(
                String id
        );
    }
}
