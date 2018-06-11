package com.rxjy.rxcompound.des.mvp.contract;

import com.rxjy.rxcompound.commons.base.BaseModel;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.base.BaseView;
import com.rxjy.rxcompound.des.entity.HomeBean;
import com.rxjy.rxcompound.des.entity.OrderGetBean;
import com.rxjy.rxcompound.des.entity.ResultBean;
import com.rxjy.rxcompound.entity.FindBean;
import com.rxjy.rxcompound.joinin.entity.HuanYingBean;
import com.rxjy.rxcompound.mvp.contract.FindFContract;

import rx.Observable;

/**
 * Created by asus on 2018/5/24.
 */

public interface OnTriaHomeContract  {
    interface View extends BaseView {


        void showDialog();

        void hideDialog();

        void showMessage(String  msg);

        void responseFindData(HomeBean data);

        void showHuanying(HuanYingBean.BodyBean bodyBean);

    }
    interface Model extends BaseModel {
        Observable<String> getFindList(
                String cardNo
        );
        Observable<String> getHuanYing(
                String cardNo
        );

    }
    abstract class Presenter extends BasePresenter<OnTriaHomeContract.View, OnTriaHomeContract.Model> {
        public abstract void getFindList(
                String cardNo

        );
        public abstract void getHuanYing(
                String cardNo

        );
    }
}
