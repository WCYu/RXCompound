package com.rxjy.rxcompound.des.mvp.presenter;

import android.util.Log;

import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.des.entity.AllImagesInfo;
import com.rxjy.rxcompound.des.mvp.contract.KaiGongContract;
import com.rxjy.rxcompound.des.mvp.model.KaiGongModel;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by Administrator on 2017/10/23.
 */

public class KaigongPresenter extends KaiGongContract.Presenter {

    public static final String TAG = "KaigongPresenter";

    public KaigongPresenter(KaiGongContract.View mView) {
        this.mView = mView;
        mModel = new KaiGongModel();
    }

    @Override
    public void GetUCAllImages(String rwdId, int enumType) {
        Subscription subscribe = mModel.GetUCAllImages(rwdId,enumType)
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
                        Log.e(TAG, "获取数据失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e(TAG, "获取数据成功 = " + s);
                        AllImagesInfo info= JSONUtils.toObject(s,AllImagesInfo.class);
                        if (info.getStatusCode()==0){
                            mView.responseKaigongInfo(info.getBody());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
