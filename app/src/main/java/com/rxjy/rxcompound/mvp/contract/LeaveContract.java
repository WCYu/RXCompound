package com.rxjy.rxcompound.mvp.contract;

import com.rxjy.rxcompound.commons.base.BaseModel;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.base.BaseView;
import com.rxjy.rxcompound.entity.LeaveBean;
import com.rxjy.rxcompound.entity.MoneyBusRewardBean;
import com.rxjy.rxcompound.entity.MoneyDTZRSProgressBean;
import com.rxjy.rxcompound.entity.MoneyDTZRSResultBean;
import com.rxjy.rxcompound.entity.MoneyDTzProcessBean;
import com.rxjy.rxcompound.entity.MoneyDTzResultBean;

import java.util.List;

import rx.Observable;

/**
 * Created by asus on 2018/5/17.
 */

public interface LeaveContract  {

    interface View extends BaseView {




        void showDialog();

        void hideDialog();

        void showMessage(String msg);

        void getLeaveData(List<LeaveBean.BodyBean> bodyBeen);

    }
    interface Model extends BaseModel {
        Observable<String> getLeaveData(

                String CardNo,
                int year,
                int month
        );

    }
    abstract class Presenter extends BasePresenter<LeaveContract.View, LeaveContract.Model> {
        public abstract void getLeaveData(
                String CardNo,
                int year,
                int month
        );


    }
}
