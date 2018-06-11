package com.rxjy.rxcompound.supervision.mvp.presenter;

import android.util.Log;

import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.supervision.entity.ContractInfo;
import com.rxjy.rxcompound.supervision.mvp.contract.ContractContract;
import com.rxjy.rxcompound.supervision.mvp.model.ContractModel;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by AAA on 2017/12/13.
 */

public class ContractPresenter extends ContractContract.Presenter {

    public static final String TAG = "ContractPresenter";

    public ContractPresenter(ContractContract.View mView) {
        this.mView = mView;
        mModel = new ContractModel();
    }

    @Override
    public void getFirstPartyContract(String orderNo) {
        Subscription subscribe = mModel.getFirstPartyContract(orderNo)
                .subscribe(new Subscriber<String>() {

                    @Override
                    public void onStart() {
                        mView.showDialog();
                    }

                    @Override
                    public void onCompleted() {
                        mView.hideDialog();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "获取甲方合同失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        ContractInfo info = JSONUtils.toObject(s, ContractInfo.class);
                        if (info.getStatusCode() == 1) {
                            ContractInfo.Contract data = info.getBody();
                            mView.responseContractData(data);
                        } else {
                            mView.responseContractDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
