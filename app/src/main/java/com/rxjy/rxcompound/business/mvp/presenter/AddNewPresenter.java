package com.rxjy.rxcompound.business.mvp.presenter;

import android.util.Log;

import com.rxjy.rxcompound.business.entity.AddressBean;
import com.rxjy.rxcompound.business.entity.CustomerDNewBean;
import com.rxjy.rxcompound.business.entity.IndustryBean;
import com.rxjy.rxcompound.business.entity.KFChannelBean;
import com.rxjy.rxcompound.business.entity.KFCityBean;
import com.rxjy.rxcompound.business.entity.PersonPhoneBean;
import com.rxjy.rxcompound.business.entity.StatusBean;
import com.rxjy.rxcompound.business.mvp.contract.AddNewContract;
import com.rxjy.rxcompound.business.mvp.model.AddNewModle;
import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.entity.ResultBean;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by hjh on 2018/5/14.
 */

public class AddNewPresenter extends AddNewContract.Presenter{

    public AddNewPresenter(AddNewContract.View view) {
        this.mView = view;
        mModel = new AddNewModle();
    }

    @Override
    public void getAddress(String name) {
        Subscription subscribe = mModel.getAddress(name)
                .subscribe(new Subscriber<String>() {

                    @Override
                    public void onStart() {
                    }

                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        onCompleted();
                        mView.responsegetAddressError("请检查您的网络！");
                    }

                    @Override
                    public void onNext(String s) {
//                        Log.e("地址信息：：：",s.toString());
                        AddressBean info = JSONUtils.toObject(s, AddressBean.class);
                        if (info.getStatusCode() == 0) {
                            mView.responsegetAddress(info);
                        } else {//未同意
                            mView.responsegetAddressError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void getIndustryType(String type) {
        Subscription subscribe = mModel.getIndustryType(type)
                .subscribe(new Subscriber<String>() {

                    @Override
                    public void onStart() {
                    }

                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        onCompleted();
                        mView.responsegetIndustryTypeError("请检查您的网络！");
                    }

                    @Override
                    public void onNext(String s) {
                        IndustryBean info = JSONUtils.toObject(s, IndustryBean.class);
                        if (info.getStatusCode() == 0) {
                            mView.responsegetIndustryType(info);
                        } else {//未同意
                            mView.responsegetIndustryTypeError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void getCity(String KaHao) {
        Subscription subscribe = mModel.getCity(KaHao)
                .subscribe(new Subscriber<String>() {

                    @Override
                    public void onStart() {
                    }

                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        onCompleted();
                        mView.responsegetIndustryTypeError("请检查您的网络！");
                    }

                    @Override
                    public void onNext(String s) {
                        KFCityBean info = JSONUtils.toObject(s, KFCityBean.class);
                        if (info.getStatusMsg().equals("请求成功")) {
                            mView.responsegetCity(info);
                        } else {//未同意
                            mView.responsegetCityError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);

    }

    @Override
    public void getChannel(String FenGongSiID, String Type) {
        Subscription subscribe = mModel.getChannel(FenGongSiID, Type)
                .subscribe(new Subscriber<String>() {

                    @Override
                    public void onStart() {

                    }

                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        onCompleted();
                        mView.responsegetIndustryTypeError("请检查您的网络！");
                    }

                    @Override
                    public void onNext(String s) {
                        KFChannelBean info = JSONUtils.toObject(s, KFChannelBean.class);
                        if (info.getStatusMsg().equals("请求成功")) {
                            mView.responsegetChannel(info);
                        } else {//未同意
                            mView.responsegetChannelError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void getCustomerPhone(String phone) {
        Subscription subscribe = mModel.getCustomerPhone(phone)
                .subscribe(new Subscriber<String>() {

                    @Override
                    public void onStart() {

                    }

                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("验证客户手机号", s);
                        StatusBean info = JSONUtils.toObject(s, StatusBean.class);
                        if (info.getStatusCode() == 0) {
                            mView.responseCustomerPhone();
                        } else if(info.getStatusCode() == 1){
                            mView.responseCustomerPhoneError("手机号重复！");
                        }else if(info.getStatusCode() == 3){
                            mView.responseCustomerPhoneError("验证异常！");
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void addCustomer(String XingMing, String ShouJiHaoYi, String card, String Channel, String City, String LeiXingYi, String LaiYuan, String GongSiMingCheng, String KeyWord, String MianJi,  String FangYuan, String LeiXingEr, String FromURL, String LandingURL, String IsMobilePC,String PTLaiYuan) {
        Subscription subscribe = mModel.addCustomer(XingMing, ShouJiHaoYi, card, Channel, City, LeiXingYi, LaiYuan, GongSiMingCheng, KeyWord, MianJi, FangYuan, LeiXingEr, FromURL, LandingURL, IsMobilePC,PTLaiYuan)
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
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        ResultBean  info = JSONUtils.toObject(s, ResultBean.class);
                        if (info.getStatusCode() == 0) {
                            mView.responseaddCustomer();
                        } else {
                            Log.e("tag",info.getStatusMsg());
                            mView.responseaddCustomerError(info.getStatusMsg());
                        }

                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void getPersonPhone(String phone, String card) {
        Subscription subscribe = mModel.getPersonPhone(phone,card)
                .subscribe(new Subscriber<String>() {

                    @Override
                    public void onStart() {

                    }

                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("验证信息员手机号", s);
                        PersonPhoneBean info = JSONUtils.toObject(s, PersonPhoneBean.class);
                        if (info.getStatusCode() == 0) {
                            mView.responsePersonPhone(info);
                        } else {
                            mView.responsePersonPhoneError("不存在该信息员的手机号！");
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void getCustomerDetails(String id) {
        Subscription subscribe = mModel.getCustomerDetails(id)
                .subscribe(new Subscriber<String>() {

                    @Override
                    public void onStart() {

                    }

                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        CustomerDNewBean info = JSONUtils.toObject(s, CustomerDNewBean.class);
                        if (info.getStatusMsg().equals("请求成功")) {
                            Log.e("dddddd","请求成功");
                            mView.responseCustomerDeatils(info);
                        } else {
                            mView.responseCustomerDeatilsError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void fixCustomer(String KeHuBaseID, String XingMing, String ShouJiHaoYi, String Channel, String City, String LeiXingYi, String LaiYuan, String GongSiMingCheng, String KeyWord, String MianJi, String FangYuan, String LeiXingEr, String FromURL, String LandingURL,String ZhuangTai, String IsMobilePC) {
        Subscription subscribe = mModel.fixCustomer(KeHuBaseID,XingMing, ShouJiHaoYi, Channel, City, LeiXingYi, LaiYuan, GongSiMingCheng, KeyWord, MianJi, FangYuan, LeiXingEr, FromURL, LandingURL,ZhuangTai, IsMobilePC)
                .subscribe(new Subscriber<String>() {

                    @Override
                    public void onStart() {

                    }

                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("tag",e.getMessage());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        ResultBean info = JSONUtils.toObject(s, ResultBean.class);
                        if (info.getStatusMsg().equals("修改成功")) {
                            mView.responsefixCustomer();
                        } else {
                            mView.responsefixCustomerError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}