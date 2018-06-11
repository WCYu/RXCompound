package com.rxjy.rxcompound.mvp.presenter;

import android.util.Log;

import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.entity.ImagesBean;
import com.rxjy.rxcompound.entity.ImgBean;
import com.rxjy.rxcompound.mvp.contract.ImagesShowContract;
import com.rxjy.rxcompound.mvp.model.ImagesShowModel;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by hjh on 2017/11/28.
 */

public class ImagesShowPresenter extends ImagesShowContract.Presenter{

    public ImagesShowPresenter(ImagesShowContract.View view) {
        this.mView = view;
        mModel = new ImagesShowModel();
    }

    @Override
    public void getImgsData(String cardNo, String img_type) {

        Subscription subscribe = mModel.getImgsData(cardNo,img_type)
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
                        Log.e("获取到的数据是",s);
                        ImagesBean info = JSONUtils.toObject(s, ImagesBean.class);
                        if(info.getStatusCode()==0){//同意
                            mView.responseImgsData(info);
                        }else if(info.getStatusCode()==-1){
                            mView.responseImgsDataError(info.getStatusMsg());
                        }

                    }
                });
        addSubscribe(subscribe);

    }

    @Override
    public void upImages(String cardNo, String type, List<String> imglist) {

        Subscription subscribe = mModel.upImages(cardNo,type,imglist)
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
                        Log.e("", "上传图片检查是否存在失败 = " + e.toString());
                        mView.responseupImagesError("网络不给力！");
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("上传图片。。。。。",s);
                        ImgBean info = JSONUtils.toObject(s, ImgBean.class);
                        if (info.getStatusCode() == 0) {
                            mView.responseupImages(info);
                        } else {
                            mView.responseupImagesError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);

    }
}
