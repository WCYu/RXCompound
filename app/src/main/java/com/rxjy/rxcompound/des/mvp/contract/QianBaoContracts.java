package com.rxjy.rxcompound.des.mvp.contract;


import com.rxjy.rxcompound.commons.base.BaseModel;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.base.BaseView;
import com.rxjy.rxcompound.des.entity.QianBaoInfo;
import com.rxjy.rxcompound.des.entity.QianbaoFenInfo;

import rx.Observable;

/**
 * Created by Administrator on 2017/8/25.
 */

public interface QianBaoContracts {
    interface View extends BaseView {

        void showDialog();

        void hideDialog();

        void responseQianBaoInfo(QianBaoInfo QBInfo);

        void responseQianBaoFenInfo(QianbaoFenInfo QBInfo);

        void responseXLQianBaoInfo(QianBaoInfo QBInfo);

        void responseQianBaoInfoError();

    }

    interface Model extends BaseModel {
        Observable<String> getQianBaoInfo(
                String cardNo,
                int pageIndex
        );
        Observable<String> getQianBaoFenInfo(
                String cardNo,
                int pageIndex,
                int type
        );


    }

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void getQianBaoInfo(
                String cardNo,
                int pageIndex
        );
        public abstract void  getQianBaoFenInfo(
                String cardNo,
                int pageIndex,
                int type
        );

        public abstract void getXLQianBaoInfo(
                String cardNo,
                int pageIndex
        );
        public abstract void getXLFenQianBaoInfo(
                String cardNo,
                int pageIndex,
                int type
        );
    }

}
