package com.rxjy.rxcompound.des.mvp.presenter;

import android.util.Log;

import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.des.entity.DesignInfo;
import com.rxjy.rxcompound.des.mvp.contract.CompactContract;
import com.rxjy.rxcompound.des.mvp.model.CompactModel;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by asus on 2018/5/14.
 */

public class CompactPresenter extends CompactContract.Presenter {
    private String TAG="CompactPresenter";

    public  CompactPresenter(CompactContract.View mView) {
        this.mView = mView;
        mModel = new CompactModel();
    }

    @Override
    public void getDegisInfoData(String rwdId) {
        Subscription subscribe = mModel.getDegisInfoData(rwdId)
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
                        Log.e(TAG,e.getMessage());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("lrj",s);
                        DesignInfo picture = JSONUtils.toObject(s, DesignInfo.class);
                        if(picture.getStatusCode()==0){
                            mView.getDegisInfoData(picture.getBody());
                        }else {
                            mView.showMessage(picture.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
