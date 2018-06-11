package com.rxjy.rxcompound.supervision.mvp.contract;

import com.rxjy.rxcompound.commons.base.BaseModel;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.base.BaseView;
import com.rxjy.rxcompound.supervision.entity.MatListInfo;

import java.util.List;

import rx.Observable;

/**
 * Created by AAA on 2017/12/13.
 */

public interface MatListContract {

    interface View extends BaseView {

        void responseMatListData(List<MatListInfo.MatInfo> dataList);

        void responseMatListDataError(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {

        Observable<String> getMatList(
                String orderNo
        );

    }

    abstract class Presenter extends BasePresenter<View, Model> {

        public abstract void getMatList(
                String orderNo
        );

    }

}
