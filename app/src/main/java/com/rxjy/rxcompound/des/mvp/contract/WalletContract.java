package com.rxjy.rxcompound.des.mvp.contract;


import com.rxjy.rxcompound.business.entity.WalletBean;
import com.rxjy.rxcompound.commons.base.BaseModel;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.base.BaseView;
import com.rxjy.rxcompound.des.entity.WalletInfo;
import com.rxjy.rxcompound.des.entity.WalletRecordInfo;

import java.util.List;

import rx.Observable;

/**
 * Created by Administrator on 2017/6/30.
 */
public interface WalletContract {

    interface View extends BaseView {

        void responsegetWalletdata(WalletBean data);

        void responsegetWalletdataError(String msg);

        void showDialog();

        void hideDialog();
    }

    interface Model extends BaseModel {

        Observable<String> getWalletdata(
                String kahao,
                String zhiwu,
                String type
        );
    }

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void getWalletdata(
                String kahao,
                String zhiwu,
                String type
        );
    }

}
