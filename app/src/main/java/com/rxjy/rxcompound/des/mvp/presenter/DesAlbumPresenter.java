package com.rxjy.rxcompound.des.mvp.presenter;

import android.util.Log;


import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.des.entity.AlbumImgInfo;
import com.rxjy.rxcompound.des.mvp.contract.DesAlbumContract;
import com.rxjy.rxcompound.des.mvp.model.DesAlbumModel;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by Administrator on 2017/6/22.
 */
public class DesAlbumPresenter extends DesAlbumContract.Presenter {

    public static final String TAG = "DesAlbumPresenter";

    public DesAlbumPresenter(DesAlbumContract.View mView) {
        this.mView = mView;
        mModel = new DesAlbumModel();
    }

    @Override
    public void subImage(int worksID, int catalogID, String userID, final List<String> imgList) {
        Subscription subscribe = mModel.subImage(worksID, catalogID, userID, imgList)
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

    @Override
    public void deleteImage(int detailID, String fileName) {
        Subscription subscribe = mModel.deleteImage(detailID, fileName)
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
                        Log.e(TAG, "删除图片失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        mView.responseDeleteImageData();
                    }
                });
        addSubscribe(subscribe);
    }

}
