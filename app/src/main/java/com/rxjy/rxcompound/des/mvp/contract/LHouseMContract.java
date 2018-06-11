package com.rxjy.rxcompound.des.mvp.contract;

import com.rxjy.rxcompound.commons.base.BaseModel;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.base.BaseView;
import com.rxjy.rxcompound.des.entity.LHouseNumBean;
import com.rxjy.rxcompound.des.entity.ProjectTypeBean;

import rx.Observable;

/**
 * Created by hjh on 2018/4/4.
 */

public interface LHouseMContract {

    interface View extends BaseView {

        void responsedata(LHouseNumBean data);

        void responsedataError(String error);

        void responsesubmitdata(String str);

        void responsesubmitdataError(String error);

        void responseProjecttype(ProjectTypeBean data);

        void responseProjecttypeError(String msg);

        void showDialog();

        void hideDialog();
    }

    interface Model extends BaseModel {
        Observable<String> GetData(
                String areaid,
                String phone
        );
        Observable<String> submitData(
                String rwdid,
                String clientInfo,
                String clientAuxiliary
        );
        Observable<String> getProjecttype(

        );
    }

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void GetData(
                String areaid,
                String phone
        );

        public abstract void submitData(
                String rwdid,
                String clientInfo,
                String clientAuxiliary
        );

        public abstract void getProjecttype(

        );
    }

}