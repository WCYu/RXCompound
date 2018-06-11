package com.rxjy.rxcompound.supervision.mvp.presenter;

import android.util.Log;

import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.des.entity.LHouseNumBean;
import com.rxjy.rxcompound.entity.ShowInfo;
import com.rxjy.rxcompound.supervision.entity.AttachmentTypeInfo;
import com.rxjy.rxcompound.supervision.mvp.contract.AddCustomersCotract;
import com.rxjy.rxcompound.supervision.mvp.contract.AttachmentContract;
import com.rxjy.rxcompound.supervision.mvp.model.AddCustomersModel;
import com.rxjy.rxcompound.supervision.mvp.model.AttachmentModel;

import org.json.JSONObject;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by asus on 2018/4/14.
 */

public class AddCustomersPresenter extends AddCustomersCotract.Presenter {
    public static final String TAG = "AddCustomersPresenter";

    public AddCustomersPresenter(AddCustomersCotract.View mView) {
        this.mView = mView;
        mModel = new AddCustomersModel();
    }


    @Override
    public void getProTypeData() {
        Subscription subscribe = mModel.getProTypeData()
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
                        Log.e(TAG, "获取资料类型失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {

                        mView.loadProTypeData(s);
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void postCustomersInfo(String rwdId, String cityId, String type, String clientInfo, String clientAuxiliary) {
        Subscription subscribe = mModel.postCustomersInfo(rwdId,cityId,type,clientInfo,clientAuxiliary)
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
                        Log.e(TAG, "获取资料类型失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e(TAG, "获取资料类型成功 = " + s);
                        //mView.loadProTypeData(s);
                        ShowInfo showInfo = JSONUtils.toObject(s, ShowInfo.class);
                        if(showInfo.getStatusCode()==0){
                            mView.responseProListDataError("信息完善成功");
                            mView.toIntent();
                        }else {
                            mView.responseProListDataError(s);
                        }
                    }
                });
        addSubscribe(subscribe);
    }


    @Override
    public void GetOrderNumber(String areaid, String phone) {
        Subscription subscribe = mModel.GetOrderNumber(areaid,phone)
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
                        Log.e(TAG, "获取资料类型失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("", "获取数据成功 = " + s);
                        LHouseNumBean info = JSONUtils.toObject(s, LHouseNumBean.class);
                        if (info.getStatusCode() == 0) {
                            mView.loaDareaid(info);
                        } else {
                            mView.responseProListDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
