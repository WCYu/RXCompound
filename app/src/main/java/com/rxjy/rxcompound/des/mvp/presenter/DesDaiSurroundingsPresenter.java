package com.rxjy.rxcompound.des.mvp.presenter;

import android.util.Log;

import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.des.entity.AllImagesInfo;
import com.rxjy.rxcompound.des.mvp.contract.DesDaiSurroundingsContract;
import com.rxjy.rxcompound.des.mvp.model.DesDaiSurroundingsModel;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by Administrator on 2017/6/22.
 */
public class DesDaiSurroundingsPresenter extends DesDaiSurroundingsContract.Presenter {

    public static final String TAG = "DesDaiSurPresenter";

    public DesDaiSurroundingsPresenter(DesDaiSurroundingsContract.View mView) {
        this.mView = mView;
        mModel = new DesDaiSurroundingsModel();
    }

    @Override
    public void getDaiSurroundingsData(String rwdId, String enumType, String token) {
        Subscription subscribe = mModel.getDaiSurroundingsData(rwdId, enumType, token)
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
                        Log.e(TAG, "获取环境图片列表失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("allimage", s);
                        AllImagesInfo info = JSONUtils.toObject(s, AllImagesInfo.class);
                        if (info.getStatusCode() == 0) {
                            List<AllImagesInfo.Album> dataList = info.getBody();
                            mView.responseDaiSurroundingsData(dataList);
                        } else if (info.getStatusCode() == 104) {
                            mView.responseDaiSurroundingsError(info.getStatusMsg());
                        } else {
                            mView.responseDaiSurroundingsError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
