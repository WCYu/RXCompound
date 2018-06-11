package com.rxjy.rxcompound.supervision.mvp.contract;


import com.rxjy.rxcompound.commons.base.BaseModel;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.base.BaseView;
import com.rxjy.rxcompound.supervision.entity.ContractInfo;

import rx.Observable;

/**
 * Created by AAA on 2017/12/13.
 */

public interface ContractContract {

    interface View extends BaseView {

        void responseContractData(ContractInfo.Contract data);

        void responseContractDataError(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {

        Observable<String> getFirstPartyContract(
                String orderNo
        );

    }

    abstract class Presenter extends BasePresenter<View, Model> {

        public abstract void getFirstPartyContract(
                String orderNo
        );

    }

}
