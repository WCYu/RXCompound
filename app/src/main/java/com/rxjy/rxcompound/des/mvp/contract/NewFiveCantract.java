package com.rxjy.rxcompound.des.mvp.contract;

import com.rxjy.rxcompound.commons.base.BaseModel;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.base.BaseView;
import com.rxjy.rxcompound.des.entity.NewFiveInfo;
import com.rxjy.rxcompound.des.entity.ProjectTypeBean;
import com.rxjy.rxcompound.des.entity.UpNewXinXi;

import rx.Observable;

/**
 * Created by Administrator on 2017/10/9 0009.
 */

public interface NewFiveCantract {


    interface View extends BaseView {

        void responseGetNewFive(NewFiveInfo.BodyBean info);

        void responseGetNewFiveError(String msg);

        void responseUpNewOne(UpNewXinXi upNewXinXi);

        void responseUpNewOneError(String msg);

        void responseProjecttype(ProjectTypeBean data);

        void responseProjecttypeError(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {
        Observable<String> GetNewFive(
                String rwdid
        );

        Observable<String> UpXinxi(
                String cardNo,
                String formpars,
                String type

        );
        Observable<String> getProjecttype(

        );

    }

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void GetNewFive(
                String rwdid
        );

        public abstract void UpXinxi(
                String cardNo,
                String formpars,
                String type

        );
        public abstract void getProjecttype(

        );
    }
}
