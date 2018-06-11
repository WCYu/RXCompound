package com.rxjy.rxcompound.business.mvp.contract;

import com.rxjy.rxcompound.business.entity.AddressBean;
import com.rxjy.rxcompound.business.entity.AgeBean;
import com.rxjy.rxcompound.business.entity.IndustryBean;
import com.rxjy.rxcompound.business.entity.MessageCustomerBean;
import com.rxjy.rxcompound.business.entity.MessageHouseBean;
import com.rxjy.rxcompound.business.entity.PersonPhoneBean;
import com.rxjy.rxcompound.commons.base.BaseModel;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.base.BaseView;

import rx.Observable;

/**
 * Created by hjh on 2017/12/1.
 */

public interface AddContract {
    interface View extends BaseView {

        void responsegetAddress(AddressBean data);

        void responsegetAddressError(String msg);

        void responsegetIndustryType(IndustryBean data);

        void responsegetIndustryTypeError(String msg);

        void responsegetgetAge(AgeBean data);

        void responsegetgetAgeError(String msg);

        void responsegetgetIdentity(AgeBean data);

        void responsegetgetAttention(AgeBean data);

        void responseSaveCustomer();

        void responseSaveCustomerError(String msg);

        void responseAddCustomer(String kahao);

        void responseSaveMessage();

        void responseSaveMessageError(String msg);

        void responseCustomerMessage(MessageCustomerBean data);

        void responseHouseMessage(MessageHouseBean data);

        void responseCustomerMessageError(String msg);

        void responseCustomerPhone();

        void responseCustomerPhoneError(String msg);

        void responsePersonPhone(PersonPhoneBean data);

        void responsePersonPhoneError(String msg);

        void showDialog();

        void hideDialog();
    }

    interface Model extends BaseModel {

        Observable<String> getAddress(
                String name
        );
        Observable<String> getIndustryType(
                String type
        );
        Observable<String> getAge(
        );
        Observable<String> getIdentity(
        );
        Observable<String> getAttention(
        );
        Observable<String> getSaveCustomer(
                int FenGongSiID,
                String XingMing,
                String ShouJiHaoYi,
                String MianJi,
                int LeiXingYi,
                int LeiXingEr,
                String Phone,
                int FangYuan,
                String GongSiMingCheng,
                int ZhuangTai,
                String KeHuBaseID
        );
        Observable<String> getAddCustomer(
                String XingMing,
                String ShouJiHaoYi,
                String MianJi,
                int LeiXingYi,
                int LeiXingEr,
                int FangYuan,
                int tb_diqu,
                String card,
                String XinXiYuanBianHao,
                String GongSiMingCheng,
                int LouPanKeHu
        );
        Observable<String> getSaveMessage(
                int ShenFenID,
                int ZhuZhongDianID,
                int NianLingID,
                int XingBie,
                int YuJiZhuangXiu,
                int ChengJiaoLeiXing,
                int MianZuQi,
                String JiaoFangShiJian,
                String LiangFangDiZhi,
                int ZhuangXiuXuQiu,
                int XiangMuShuXing,
                String ZhuangXiuYuSuan,
                String YuJiZhuangXiuShiJian,
                String YuJiLiangFang,
                int QiYeGuiMoID,
                int ZhuangTai,
                String KeHuBaseID
        );
        Observable<String> getCustomerMessage(
                int id,
                int type
        );
        Observable<String> getCustomerPhone(
                String phone
        );
        Observable<String> getPersonPhone(
                String phone,
                String card
        );
    }

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void getAddress(
                String name
        );
        public abstract void getIndustryType(
                String type
        );
        public abstract void getAge(
        );
        public abstract void getIdentity(
        );
        public abstract void getAttention(
        );
        public abstract void getSaveCustomer(
                int FenGongSiID,
                String XingMing,
                String ShouJiHaoYi,
                String MianJi,
                int LeiXingYi,
                int LeiXingEr,
                String Phone,
                int FangYuan,
                String GongSiMingCheng,
                int ZhuangTai,
                String KeHuBaseID
        );
        public abstract void getAddCustomer(
                String XingMing,
                String ShouJiHaoYi,
                String MianJi,
                int LeiXingYi,
                int LeiXingEr,
                int FangYuan,
                int tb_diqu,
                String card,
                String XinXiYuanBianHao,
                String GongSiMingCheng,
                int LouPanKeHu
        );
        public abstract void getSaveMessage(
                int ShenFenID,
                int ZhuZhongDianID,
                int NianLingID,
                int XingBie,
                int YuJiZhuangXiu,
                int ChengJiaoLeiXing,
                int MianZuQi,
                String JiaoFangShiJian,
                String LiangFangDiZhi,
                int ZhuangXiuXuQiu,
                int XiangMuShuXing,
                String ZhuangXiuYuSuan,
                String YuJiZhuangXiuShiJian,
                String YuJiLiangFang,
                int QiYeGuiMoID,
                int ZhuangTai,
                String KeHuBaseID
        );

        public abstract void getCustomerMessage(
                int id,
                int type
        );
        public abstract void getCustomerPhone(
                String phone
        );
        public abstract void getPersonPhone(
                String phone,
                String card
        );

    }
}
