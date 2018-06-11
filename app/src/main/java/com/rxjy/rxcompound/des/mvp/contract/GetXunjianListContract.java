package com.rxjy.rxcompound.des.mvp.contract;

import com.rxjy.rxcompound.commons.base.BaseModel;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.base.BaseView;
import com.rxjy.rxcompound.entity.XunjianListInfo;

import java.util.List;

import rx.Observable;

/**
 * Created by Administrator on 2017/10/24.
 */

public interface GetXunjianListContract {

    interface View extends BaseView
    {

        void responseXunjianListData(List<XunjianListInfo.BodyBean> info);

        void responseXunjianListDataError();

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel
    {
        Observable<String> GetScheduleCheckList(
                String rwdId
        );
    }

    abstract class Presenter extends BasePresenter<View, Model>
    {

        public abstract void GetScheduleCheckList(
                String rwdId
        );

    }

}
