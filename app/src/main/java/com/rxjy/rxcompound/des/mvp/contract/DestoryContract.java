package com.rxjy.rxcompound.des.mvp.contract;

import com.rxjy.rxcompound.commons.base.BaseModel;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.base.BaseView;
import com.rxjy.rxcompound.entity.NumberPackets;

import rx.Observable;

/**
 * Created by Administrator on 2017/10/13.
 */

public interface DestoryContract {
    interface View extends BaseView {
        void responseUserStatusError(String msg);

        void showDialog();

        void hideDialog();
        void responseTaskData(NumberPackets.BodyBean mlist);
    }

    interface Model extends BaseModel {
        //1
        Observable<String> getDestoryListener(

        );
        Observable<String> getRedTask(
                String cardNo
        );
    }

    abstract class Presenter extends BasePresenter<View, Model> {
        //1
        public abstract void getDestoryListener(

        );
        public abstract void getRedTask(
                String cardNo
        );
    }

}
