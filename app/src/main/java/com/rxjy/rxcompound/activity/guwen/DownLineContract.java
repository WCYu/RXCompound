package com.rxjy.rxcompound.activity.guwen;


import com.rxjy.rxcompound.commons.base.*;
import com.rxjy.rxcompound.commons.base.BaseModel;
import com.rxjy.rxcompound.commons.base.BaseView;

import rx.Observable;


/**
 * Created by Administrator on 2018/5/30.
 */

public interface DownLineContract {

    interface View extends BaseView {


        void lodeDate(DownLineBean downLineBean);

        void lodeDateErr(String s);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {

        Observable<String> getClientList(
                String card
        );

    }



    abstract class Presenter extends com.rxjy.rxcompound.commons.base.BasePresenter<View, Model> {

        public abstract void getDownLineList(
                String card
        );


    }


}
