package com.rxjy.rxcompound.business.mvp.presenter;


import android.util.Log;

import com.rxjy.rxcompound.business.entity.AddressBean;
import com.rxjy.rxcompound.business.entity.AgeBean;
import com.rxjy.rxcompound.business.entity.IndustryBean;
import com.rxjy.rxcompound.business.entity.MessageCustomerBean;
import com.rxjy.rxcompound.business.entity.MessageHouseBean;
import com.rxjy.rxcompound.business.entity.PersonPhoneBean;
import com.rxjy.rxcompound.business.entity.StatusBean;
import com.rxjy.rxcompound.business.entity.StatusCustomerNumBean;
import com.rxjy.rxcompound.business.mvp.contract.AddContract;
import com.rxjy.rxcompound.business.mvp.model.AddModel;
import com.rxjy.rxcompound.commons.utils.JSONUtils;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by hjh on 2017/12/1.
 */

public class AddPresenter extends AddContract.Presenter {

    public AddPresenter(AddContract.View view) {
        this.mView = view;
        mModel = new AddModel();
    }

    @Override
    public void getAddress(String name) {
        Subscription subscribe = mModel.getAddress(name)
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
                        mView.responsegetAddressError("请检查您的网络！");
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("地址信息：：：",s.toString());
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
                        mView.showDialog();
                    }

                    @Override
                    public void onCompleted() {
                        mView.hideDialog();
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
    public void getAge() {
        Subscription subscribe = mModel.getAge()
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
                        mView.responsegetgetAgeError("请检查您的网络！");
                    }

                    @Override
                    public void onNext(String s) {
                        AgeBean info = JSONUtils.toObject(s, AgeBean.class);
                        if (info.getStatusCode() == 0) {
                            mView.responsegetgetAge(info);
                        } else {//未同意
                            mView.responsegetgetAgeError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void getIdentity() {
        Subscription subscribe = mModel.getIdentity()
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
                        mView.responsegetgetAgeError("请检查您的网络！");
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("身份：：",s);
                        AgeBean info = JSONUtils.toObject(s, AgeBean.class);
                        if (info.getStatusCode() == 0) {
                            mView.responsegetgetIdentity(info);
                        } else {//未同意
                            mView.responsegetgetAgeError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);

    }

    @Override
    public void getAttention() {
        Subscription subscribe = mModel.getAttention()
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
                        mView.responsegetgetAgeError("请检查您的网络！");
                    }

                    @Override
                    public void onNext(String s) {
                        AgeBean info = JSONUtils.toObject(s, AgeBean.class);
                        if (info.getStatusCode() == 0) {
                            mView.responsegetgetAttention(info);
                        } else {//未同意
                            mView.responsegetgetAgeError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);

    }

    @Override
    public void getSaveCustomer(int FenGongSiID, String XingMing, String ShouJiHaoYi, String MianJi, int LeiXingYi, int LeiXingEr, String Phone, int FangYuan, String GongSiMingCheng, int ZhuangTai, String KeHuBaseID) {
        Subscription subscribe = mModel.getSaveCustomer(FenGongSiID, XingMing, ShouJiHaoYi, MianJi, LeiXingYi, LeiXingEr, Phone, FangYuan, GongSiMingCheng, ZhuangTai, KeHuBaseID)
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
                        mView.responseSaveCustomerError("请检查您的网络！");
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("保存客户", s);
                        StatusBean info = JSONUtils.toObject(s, StatusBean.class);
                        if (info.getStatusCode() == 0) {
                            mView.responseSaveCustomer();
                        } else {
                            mView.responseSaveCustomerError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void getAddCustomer(String XingMing, String ShouJiHaoYi, String MianJi, int LeiXingYi, int LeiXingEr, int FangYuan, int tb_diqu, String card, String XinXiYuanBianHao, String GongSiMingCheng, int LouPanKeHu) {
        Subscription subscribe = mModel.getAddCustomer( XingMing, ShouJiHaoYi, MianJi, LeiXingYi, LeiXingEr,FangYuan, tb_diqu,card,XinXiYuanBianHao,GongSiMingCheng, LouPanKeHu)
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
                        mView.responseSaveCustomerError("请检查您的网络！");
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("添加客户", s);
                        StatusCustomerNumBean info = JSONUtils.toObject(s, StatusCustomerNumBean.class);
                        if (info.getStatusCode() == 0) {
                            mView.responseAddCustomer(info.getBody().getKeHuBaseID());
                        } else {
                            mView.responseSaveCustomerError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void getSaveMessage(int ShenFenID, int ZhuZhongDianID, int NianLingID, int XingBie, int YuJiZhuangXiu, int ChengJiaoLeiXing, int MianZuQi, String JiaoFangShiJian, String LiangFangDiZhi, int ZhuangXiuXuQiu, int XiangMuShuXing, String ZhuangXiuYuSuan, String YuJiZhuangXiuShiJian, String YuJiLiangFang, int QiYeGuiMoID, int ZhuangTai, String KeHuBaseID) {
        Subscription subscribe = mModel.getSaveMessage(ShenFenID, ZhuZhongDianID, NianLingID, XingBie, YuJiZhuangXiu, ChengJiaoLeiXing, MianZuQi, JiaoFangShiJian, LiangFangDiZhi, ZhuangXiuXuQiu, XiangMuShuXing, ZhuangXiuYuSuan, YuJiZhuangXiuShiJian, YuJiLiangFang, QiYeGuiMoID, ZhuangTai, KeHuBaseID)
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
                        mView.responseSaveCustomerError("请检查您的网络！");
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("保存量房", s);
                        StatusBean info = JSONUtils.toObject(s, StatusBean.class);
                        if (info.getStatusCode() == 0) {
                            mView.responseSaveMessage();
                        } else {
                            mView.responseSaveMessageError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void getCustomerMessage(int id, final int type) {

        Subscription subscribe = mModel.getCustomerMessage(id, type)
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
                        mView.responseSaveCustomerError("请检查您的网络！");
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("获取后端数据", s);
                        switch (type){
                            case 1:
                                MessageCustomerBean info = JSONUtils.toObject(s, MessageCustomerBean.class);
                                if (info.getStatusCode() == 0) {
                                    mView.responseCustomerMessage(info);
                                } else {
                                    mView.responseCustomerMessageError(info.getStatusMsg());
                                }
                                break;
                            case 2:
                                MessageHouseBean infohouse = JSONUtils.toObject(s, MessageHouseBean.class);
                                if (infohouse.getStatusCode() == 0) {
                                    mView.responseHouseMessage(infohouse);
                                } else {
                                    mView.responseCustomerMessageError(infohouse.getStatusMsg());
                                }
                                break;
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
                        mView.showDialog();
                    }

                    @Override
                    public void onCompleted() {
                        mView.hideDialog();
                    }

                    @Override
                    public void onError(Throwable e) {
                        onCompleted();
                        mView.responseSaveCustomerError("请检查您的网络！");
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
    public void getPersonPhone(String phone, String card) {
        Subscription subscribe = mModel.getPersonPhone(phone,card)
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
                        mView.responseSaveCustomerError("请检查您的网络！");
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
}
