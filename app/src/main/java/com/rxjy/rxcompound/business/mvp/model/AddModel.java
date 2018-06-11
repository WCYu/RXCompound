package com.rxjy.rxcompound.business.mvp.model;

import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.business.mvp.contract.AddContract;
import com.rxjy.rxcompound.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by hjh on 2017/12/1.
 */

public class AddModel implements AddContract.Model {
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
    public Observable<String> getAge() {
        return ApiEngine.getInstance().getRxbusicApiHost()
                .getAge()
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getIdentity() {
        return ApiEngine.getInstance().getRxbusicApiHost()
                .getIdentity()
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getAttention() {
        return ApiEngine.getInstance().getRxbusicApiHost()
                .getAttention()
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getSaveCustomer(int FenGongSiID, String XingMing, String ShouJiHaoYi, String MianJi, int LeiXingYi, int LeiXingEr, String Phone, int FangYuan, String GongSiMingCheng, int ZhuangTai, String KeHuBaseID) {
        return ApiEngine.getInstance().getRxbusicApiHost()
                .postsavecustomer(FenGongSiID, XingMing, ShouJiHaoYi, MianJi, LeiXingYi, LeiXingEr, Phone, FangYuan, GongSiMingCheng, ZhuangTai, KeHuBaseID)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getAddCustomer(String XingMing, String ShouJiHaoYi, String MianJi, int LeiXingYi, int LeiXingEr, int FangYuan, int tb_diqu, String card, String XinXiYuanBianHao, String GongSiMingCheng, int LouPanKeHu) {
        return ApiEngine.getInstance().getRxbusicApiHost()
                .postaddcustomer(XingMing, ShouJiHaoYi, MianJi, LeiXingYi, LeiXingEr, FangYuan, tb_diqu,card, XinXiYuanBianHao, GongSiMingCheng, LouPanKeHu)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getSaveMessage(int ShenFenID, int ZhuZhongDianID, int NianLingID, int XingBie, int YuJiZhuangXiu, int ChengJiaoLeiXing, int MianZuQi, String JiaoFangShiJian, String LiangFangDiZhi, int ZhuangXiuXuQiu, int XiangMuShuXing, String ZhuangXiuYuSuan, String YuJiZhuangXiuShiJian, String YuJiLiangFang, int QiYeGuiMoID, int ZhuangTai, String KeHuBaseID) {
        return ApiEngine.getInstance().getRxbusicApiHost()
                .postsavecustomer(ShenFenID, ZhuZhongDianID, NianLingID, XingBie, YuJiZhuangXiu, ChengJiaoLeiXing, MianZuQi, JiaoFangShiJian, LiangFangDiZhi, ZhuangXiuXuQiu, XiangMuShuXing, ZhuangXiuYuSuan, YuJiZhuangXiuShiJian, YuJiLiangFang, QiYeGuiMoID, ZhuangTai, KeHuBaseID)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getCustomerMessage(int id, int type) {
        return ApiEngine.getInstance().getRxbusicApiHost()
                .getCustomerMessage(id, type)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getCustomerPhone(String phone) {
        return ApiEngine.getInstance().getRxbusicApiHost()
                .postCustomerPhone(phone)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getPersonPhone(String phone, String card) {
        return ApiEngine.getInstance().getRxbusicApiHost()
                .postPersonPhone(phone, card)
                .compose(RxSchedulers.<String>switchThread());
    }

}
