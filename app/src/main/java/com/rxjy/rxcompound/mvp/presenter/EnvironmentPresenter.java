package com.rxjy.rxcompound.mvp.presenter;

import android.util.Log;

import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.entity.EnvirBean;
import com.rxjy.rxcompound.entity.FigureListBean;
import com.rxjy.rxcompound.mvp.contract.EnvironmentContract;
import com.rxjy.rxcompound.mvp.model.EnvironmentModel;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by hjh on 2018/4/26.
 */

public class EnvironmentPresenter extends EnvironmentContract.Presenter{

    public EnvironmentPresenter(EnvironmentContract.View mView) {
        this.mView = mView;
        mModel = new EnvironmentModel();
    }

    @Override
    public void getEnvir(String CardNo, String RegionId, String Type) {
        Subscription subscribe = mModel.getEnvir(CardNo, RegionId, Type)
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
                        Log.e("", "获取检查是否存在失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        EnvirBean info = JSONUtils.toObject(s, EnvirBean.class);
                        if(info.getStatusCode()==0){
                            mView.responseEnvir(info);
                        }else{
                            mView.responseEnvirError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
