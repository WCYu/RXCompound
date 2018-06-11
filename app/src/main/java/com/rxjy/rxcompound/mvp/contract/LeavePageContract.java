package com.rxjy.rxcompound.mvp.contract;

import com.rxjy.rxcompound.commons.base.BaseModel;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.base.BaseView;
import com.rxjy.rxcompound.entity.LeaveBean;
import com.rxjy.rxcompound.entity.LeaveSubmitBean;
import com.rxjy.rxcompound.entity.LeaveTypeBean;

import java.util.List;

import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by asus on 2018/5/17.
 */

public interface LeavePageContract {
    interface View extends BaseView {


        void showDialog();

        void hideDialog();

        void showMessage(String msg);

        void getLeavePageTypeData(List<LeaveTypeBean.BodyBean> bodyBeen);
        void loadLeaveSubmit(LeaveSubmitBean leaveSubmitBean);

    }

    interface Model extends BaseModel {
        Observable<String> getLeavePageTypeData(

        );

        Observable<String> getpplyAttendance(
                String cardno,
                String beginTime,
                String endTime,
                String days,
                String reason,
                int vacationState
        );
    }

    abstract class Presenter extends BasePresenter<LeavePageContract.View, LeavePageContract.Model> {
        public abstract void getLeaveData(

        );
        public abstract void getpplyAttendance(
                String cardno,
                String beginTime,
                String endTime,
                String days,
                String reason,
                int vacationState
        );
    }
}
