package com.rxjy.rxcompound.des.mvp.presenter;

import android.util.Log;

import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.des.entity.AllImagesInfo;
import com.rxjy.rxcompound.des.entity.GetYiLiangFangAllInfo;
import com.rxjy.rxcompound.des.mvp.contract.GetYiLiangFangAllinfoContract;
import com.rxjy.rxcompound.des.mvp.model.GetYiLiangFangAllinfoModel;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by Administrator on 2017/8/18.
 */

public class GetYiLiangFangAllinfoPresenter extends GetYiLiangFangAllinfoContract.Presenter {
    public static final String TAG = "GetAllInfoPresenter";
    public GetYiLiangFangAllinfoPresenter(GetYiLiangFangAllinfoContract.View mView){
        this.mView = mView;
        mModel = new GetYiLiangFangAllinfoModel();

    }

    @Override
    public void GetYiLiangFangAllinfo(String rwdId) {
        Subscription subscribe = mModel.GetYiLiangFangAllinfo(rwdId)
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
                        Log.e(TAG, "获取客户列表失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e(TAG, "获取客户列表chengong = " + s);
                        GetYiLiangFangAllInfo info= JSONUtils.toObject(s, GetYiLiangFangAllInfo.class);
                        mView.responseMeasureData(info);
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void getAllImagesData(String rwdId, String enumType, String token)
    {
        Subscription subscribe = mModel.getAllImagesData(rwdId, enumType, token)
                .subscribe(new Subscriber<String>()
                {
                    @Override
                    public void onStart()
                    {
                        mView.showDialog();
                    }

                    @Override
                    public void onCompleted()
                    {
                        mView.hideDialog();
                    }

                    @Override
                    public void onError(Throwable e)
                    {
                        Log.e(TAG, "获取照片信息失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s)
                    {
                        AllImagesInfo info = JSONUtils.toObject(s, AllImagesInfo.class);
                        if (info.getStatusCode() == 0)
                        {
                            List<AllImagesInfo.Album> list = info.getBody();
                            mView.responseAllImagesData(list);
                        } else if (info.getStatusCode() == 104)
                        {
                            mView.reLogin(info.getStatusMsg());
                        } else
                        {
                            mView.responseAllImagesError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

}
