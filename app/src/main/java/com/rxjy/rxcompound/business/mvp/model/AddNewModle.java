package com.rxjy.rxcompound.business.mvp.model;

import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.business.mvp.contract.AddNewContract;
import com.rxjy.rxcompound.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by hjh on 2018/5/14.
 */

public class AddNewModle implements AddNewContract.Model{
    @Override
    public Observable<String> getAddress(String name) {
        return ApiEngine.getInstance().getRxbusicApiHost()
                .getAddressList(name)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getIndustryType(String type) {
        return ApiEngine.getInstance().getRxbusicApiHost()
                .postIndustryType(type)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getCity(String KaHao) {
        return ApiEngine.getInstance().getRxbusicApiHost()
                .getKFCity(KaHao)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getChannel(String FenGongSiID, String Type) {
        return ApiEngine.getInstance().getRxbusicApiHost()
                .getKFChannel(FenGongSiID, Type)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getCustomerPhone(String phone) {
        return ApiEngine.getInstance().getRxbusicApiHost()
                .postCustomerPhone(phone)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> addCustomer(String XingMing, String ShouJiHaoYi, String card, String Channel, String City, String LeiXingYi, String LaiYuan, String GongSiMingCheng, String KeyWord, String MianJi, String FangYuan, String LeiXingEr, String FromURL, String LandingURL, String IsMobilePC,String PTLaiYuan) {
        return ApiEngine.getInstance().getRxbusicApiHost()
                .getKFAddCustomer(XingMing, ShouJiHaoYi, card, Channel, City, LeiXingYi, LaiYuan, GongSiMingCheng, KeyWord, MianJi, FangYuan, LeiXingEr, FromURL, LandingURL, IsMobilePC,PTLaiYuan)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getPersonPhone(String phone, String card) {
        return ApiEngine.getInstance().getRxbusicApiHost()
                .postPersonPhone(phone, card)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getCustomerDetails(String id) {
        return ApiEngine.getInstance().getRxbusicApiHost()
                .getKFCustomerDetails(id)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> fixCustomer(String KeHuBaseID, String XingMing, String ShouJiHaoYi,  String Channel, String City, String LeiXingYi, String LaiYuan, String GongSiMingCheng, String KeyWord, String MianJi,String FangYuan, String LeiXingEr, String FromURL, String LandingURL,String ZhuangTai, String IsMobilePC) {

        return ApiEngine.getInstance().getRxbusicApiHost()
                .getKFFixCustomer(KeHuBaseID,XingMing, ShouJiHaoYi,Channel, City, LeiXingYi, LaiYuan, GongSiMingCheng, KeyWord, MianJi, FangYuan, LeiXingEr, FromURL, LandingURL,ZhuangTai, IsMobilePC)
                .compose(RxSchedulers.<String>switchThread());
    }
}