package com.rxjy.rxcompound.des.mvp.presenter;

import android.util.Log;

import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.des.entity.AlbumImgInfo;
import com.rxjy.rxcompound.des.entity.MyCamera;
import com.rxjy.rxcompound.des.mvp.contract.MyCameraContract;
import com.rxjy.rxcompound.des.mvp.model.MyCameraModel;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by Administrator on 2017/8/16.
 */

public class MyCameraPresenter extends MyCameraContract.Presenter {
    public static final String TAG = "MyCameraPresenter";

    public MyCameraPresenter(MyCameraContract.View mView) {
        this.mView = mView;
        mModel = new MyCameraModel();
    }

    @Override
    public void getCameraType(String rwdId) {
        Subscription subscribe = mModel.getCameraType(rwdId)
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
                        Log.e(TAG, "获取拍照类型失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e(TAG, s);
                        MyCamera mc = JSONUtils.toObject(s, MyCamera.class);
                        mView.showlistitem(mc);

                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void subImage2(int worksID, String catalogID, int userID, final List<String> imgList) {
        Subscription subscribe = mModel.subImage2(worksID, catalogID, userID, imgList)
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
                        Log.e(TAG, "上传图片失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e(TAG, s);
                        AlbumImgInfo info = JSONUtils.toObject(s, AlbumImgInfo.class);
                        if (info.getStatusCode() == 0) {
                            List<AlbumImgInfo.ImgInfo> dataList = info.getBody();
                            mView.responseSubImageData(dataList);
                        } else {
                            mView.responseSubImageDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }


}
