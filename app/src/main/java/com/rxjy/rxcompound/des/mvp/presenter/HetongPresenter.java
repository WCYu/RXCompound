package com.rxjy.rxcompound.des.mvp.presenter;

import android.util.Log;

import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.des.entity.AllImagesInfo;
import com.rxjy.rxcompound.des.entity.HetongCatalogsInfo;
import com.rxjy.rxcompound.des.mvp.contract.HetongContract;
import com.rxjy.rxcompound.des.mvp.model.HetongModel;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by Administrator on 2017/10/17.
 */

public class HetongPresenter extends HetongContract.Presenter{

    public static final String TAG = "HetongPresenter";

    public HetongPresenter(HetongContract.View mView) {
        this.mView = mView;
        mModel = new HetongModel();
    }

    @Override
    public void ProImgCatalogs(String rwdId) {
        Subscription subscribe = mModel.ProImgCatalogs(rwdId)
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
                        Log.e(TAG, "获取信息失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e(TAG, "获取信息成功 = " + s);
                        HetongCatalogsInfo info= JSONUtils.toObject(s, HetongCatalogsInfo.class);
                        if (info.getStatusCode()==0){
                            mView.responsedataerror(info);
                        }

                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void GetAllImages(String rwdId, int enumType) {
        Subscription subscribe = mModel.GetAllImages(rwdId,enumType)
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
                        Log.e(TAG, "获取信息失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e(TAG, "获取信息成功 = " + s);
                        AllImagesInfo info=JSONUtils.toObject(s, AllImagesInfo.class);
                        if (info.getStatusCode()==0){
                            mView.responseAllImg(info.getBody());
                        }

                    }
                });
        addSubscribe(subscribe);
    }
}
