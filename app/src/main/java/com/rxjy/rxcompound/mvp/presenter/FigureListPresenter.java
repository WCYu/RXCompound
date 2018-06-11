package com.rxjy.rxcompound.mvp.presenter;

import android.util.Log;

import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.entity.FigureListBean;
import com.rxjy.rxcompound.mvp.contract.FigureListContract;
import com.rxjy.rxcompound.mvp.model.FigureListModel;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by hjh on 2018/4/26.
 */

public class FigureListPresenter extends FigureListContract.Presenter{

    public FigureListPresenter(FigureListContract.View mView) {
        this.mView = mView;
        mModel = new FigureListModel();
    }

    @Override
    public void getFigureList(String CardNo, String RegionId, String Type) {
        Subscription subscribe = mModel.getFigureList(CardNo, RegionId, Type)
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
                        FigureListBean info = JSONUtils.toObject(s, FigureListBean.class);
                        if(info.getStatusCode()==0){//同意
                            mView.responseFigureList(info);
                        }else{
                            mView.responseFigureListError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
