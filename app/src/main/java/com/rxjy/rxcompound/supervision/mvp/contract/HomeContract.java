package com.rxjy.rxcompound.supervision.mvp.contract;

import com.rxjy.rxcompound.commons.base.BaseModel;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.base.BaseView;
import com.rxjy.rxcompound.entity.CustomerBean;
import com.rxjy.rxcompound.supervision.entity.ProjectListInfo;

import java.util.List;

import rx.Observable;

/**
 * Created by AAA on 2017/7/31.
 */

public interface HomeContract {

    interface View extends BaseView {

        void responseProListData(List<ProjectListInfo.Project> dataList);

        void responseProListDataError(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {

        Observable<String> getProList(
                String cardNo
        );

    }

    abstract class Presenter extends BasePresenter<View, Model> {

        public abstract void getProList(
                String cardNo
        );

    }

}