package com.rxjy.rxcompound.supervision.mvp.contract;
import com.rxjy.rxcompound.commons.base.BaseModel;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.base.BaseView;
import com.rxjy.rxcompound.supervision.entity.ProListInfo;

import java.util.List;

import rx.Observable;

/**
 * Created by AAA on 2017/12/15.
 */

public interface ProListContract {

    interface View extends BaseView {

        void responseProListData(List<ProListInfo.ProList> dataList);

        void responseProListDataError(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {

        Observable<String> getProList(
                String orderNo
        );

    }

    abstract class Presenter extends BasePresenter<View, Model> {

        public abstract void getProList(
                String orderNo
        );

    }

}
