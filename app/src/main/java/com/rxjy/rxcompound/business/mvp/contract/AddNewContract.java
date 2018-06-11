package com.rxjy.rxcompound.business.mvp.contract;

import com.rxjy.rxcompound.business.entity.AddressBean;
import com.rxjy.rxcompound.business.entity.CustomerDNewBean;
import com.rxjy.rxcompound.business.entity.IndustryBean;
import com.rxjy.rxcompound.business.entity.KFChannelBean;
import com.rxjy.rxcompound.business.entity.KFCityBean;
import com.rxjy.rxcompound.business.entity.PersonPhoneBean;
import com.rxjy.rxcompound.commons.base.BaseModel;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.base.BaseView;

import rx.Observable;

/**
 * Created by hjh on 2018/5/14.
 */

public interface AddNewContract {
    interface View extends BaseView {

        void responsegetAddress(AddressBean data);

        void responsegetAddressError(String msg);

        void responsegetIndustryType(IndustryBean data);

        void responsegetIndustryTypeError(String msg);

        void responsegetCity(KFCityBean data);

        void responsegetCityError(String msg);

        void responsegetChannel(KFChannelBean data);

        void responsegetChannelError(String msg);

        void responseCustomerPhone();

        void responseCustomerPhoneError(String msg);

        void responseaddCustomer();

        void responseaddCustomerError(String msg);

        void responsePersonPhone(PersonPhoneBean data);

        void responsePersonPhoneError(String msg);

        void responseCustomerDeatils(CustomerDNewBean data);

        void responseCustomerDeatilsError(String msg);

        void responsefixCustomer();

        void responsefixCustomerError(String msg);

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
        Observable<String> getCity(
                String KaHao
        );
        Observable<String> getChannel(
                String FenGongSiID,
                String Type
        );
        Observable<String> getCustomerPhone(
                String phone
        );
        Observable<String> addCustomer(

                String XingMing,
                String ShouJiHaoYi,
                String card,
                String Channel,
                String City,
                String LeiXingYi,
                String LaiYuan,
                String GongSiMingCheng,
                String KeyWord,
                String MianJi,
                String FangYuan,
                String LeiXingEr,
                String FromURL,
                String LandingURL,
                String IsMobilePC,
                String PTLaiYuan
        );
        Observable<String> getPersonPhone(
                String phone,
                String card
        );
        Observable<String> getCustomerDetails(
                String id
        );
        Observable<String> fixCustomer(
                String KeHuBaseID,
                String XingMing,
                String ShouJiHaoYi,
                String Channel,
                String City,
                String LeiXingYi,
                String LaiYuan,
                String GongSiMingCheng,
                String KeyWord,
                String MianJi,
                String FangYuan,
                String LeiXingEr,
                String FromURL,
                String LandingURL,
                String ZhuangTai,
                String IsMobilePC
        );
    }

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void getAddress(
                String name
        );
        public abstract void getIndustryType(
                String type
        );
        public abstract void getCity(
                String KaHao
        );

        public abstract void getChannel(
                String FenGongSiID,
                String Type
        );
        public abstract void getCustomerPhone(
                String phone
        );
        public abstract void addCustomer(
                String XingMing,
                String ShouJiHaoYi,
                String card,
                String Channel,
                String City,
                String LeiXingYi,
                String LaiYuan,
                String GongSiMingCheng,
                String KeyWord,
                String MianJi,
                String FangYuan,
                String LeiXingEr,
                String FromURL,
                String LandingURL,
                String IsMobilePC,
                String PTLaiYuan
        );
        public abstract void getPersonPhone(
                String phone,
                String card
        );
        public abstract void getCustomerDetails(
                String id
        );
        public abstract void fixCustomer(
                String KeHuBaseID,
                String XingMing,
                String ShouJiHaoYi,
                String Channel,
                String City,
                String LeiXingYi,
                String LaiYuan,
                String GongSiMingCheng,
                String KeyWord,
                String MianJi,
                String FangYuan,
                String LeiXingEr,
                String FromURL,
                String LandingURL,
                String ZhuangTai,
                String IsMobilePC

        );
    }

}