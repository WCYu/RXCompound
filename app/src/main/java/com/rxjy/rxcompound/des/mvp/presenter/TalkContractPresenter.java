package com.rxjy.rxcompound.des.mvp.presenter;

import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.des.entity.TalkContractBean;
import com.rxjy.rxcompound.des.mvp.contract.TalkContractContract;
import com.rxjy.rxcompound.des.mvp.model.TalkContractModel;
import com.rxjy.rxcompound.entity.ResultBean;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by hjh on 2018/5/15.
 */

public class TalkContractPresenter extends TalkContractContract.Presenter{

    public TalkContractPresenter(TalkContractContract.View mView) {
        this.mView = mView;
        mModel = new TalkContractModel();
    }

    @Override
    public void getData(String rwdId) {
        Subscription subscribe = mModel.getData(rwdId)
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
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        TalkContractBean info = JSONUtils.toObject(s, TalkContractBean.class);
                        if (info.getStatusCode() == 0) {
                            mView.responseData(info);
                        } else {
                            mView.responseDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void submitData(String ca, String rwdId) {
        Subscription subscribe = mModel.submitData(ca, rwdId)
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
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        ResultBean info = JSONUtils.toObject(s, ResultBean.class);
                        if (info.getStatusCode() == 0) {
                            mView.responsesubmitData();
                        } else {
                            mView.responsesubmitDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

}