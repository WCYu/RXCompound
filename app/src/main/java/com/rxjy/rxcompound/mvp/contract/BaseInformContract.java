package com.rxjy.rxcompound.mvp.contract;

import com.rxjy.rxcompound.commons.base.BaseModel;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.base.BaseView;
import com.rxjy.rxcompound.entity.BankBean;
import com.rxjy.rxcompound.entity.DesBaseInfoBean;
import com.rxjy.rxcompound.entity.IconBean;
import com.rxjy.rxcompound.entity.ImgBean;
import com.rxjy.rxcompound.entity.MsgNumBean;
import com.rxjy.rxcompound.entity.PersonBean;
import com.rxjy.rxcompound.entity.ResultBean;
import com.rxjy.rxcompound.entity.UserStatusBean;

import java.util.List;

import rx.Observable;

/**
 * Created by hjh on 2017/11/10.
 */

public interface BaseInformContract {
    interface View extends BaseView {

        void responsegetMessage(String s, PersonBean data);

        void responsegetMessageError(String msg);

        void responseUpdateMessage(PersonBean data);

        void responseUpdateMessageError(String msg);

        void responseUpdateMessagebank(PersonBean data);

        void responseUpdateMessagebankError(String msg);

        void responseBankList(BankBean data);

        void responseBankListError(String msg);

        void responseImg(ImgBean data);

        void responseImgError(String msg);

        void responseIcon(IconBean data);

        void responseIconError(String msg);

        void responseUserStatus(UserStatusBean data);

        void responseUserStatusError(String msg);

        void responseMsgStatus(MsgNumBean data);

        void responseMsgError(String msg);

        void responseDesMessage(DesBaseInfoBean data);

        void responseDesMessageError(String msg);

        void responseIsConsent(ResultBean data);

        void responseIsConsentError(String msg);

        void showDialog();

        void hideDialog();
    }

    interface Model extends BaseModel {

        Observable<String> getMessage(
                String Phone,
                String Type
        );

        Observable<String> getUpdateMessages(
                String Phone,
                String Type,
                String IdCardName,
                String IdCard,
                String IdCardAddress,
                String NowAddress,
                String Birthday,
                String Marriage
        );

        Observable<String> getUpdateMessage(
                String Phone,
                String Type,
                String BankName,
                String BankCard,
                String BankUserName,
                String UrgentPerson,
                String UrgentContact,
                String UrgentPhone

        );

        Observable<String> getUpdateMessage(
                String CardNo,
                String Type,
                String Name,
                String Sex,
                String Phone
//                String Marriage

        );

        Observable<String> getBankList(
        );

        Observable<String> upLoadImg(
                String cardNo,
                String type,
                List<String> imglist
        );

        Observable<String> upLoadIcon(
                String cardNo,
                String imglist
        );

        Observable<String> getUserStatus(
                String cardNo
        );

        Observable<String> getMsgnum(
                String cardNo
        );

        Observable<String> getDesMessage(
                String cardNo
        );

        Observable<String> getIsConsent(//是否同意过岗责、保密协议、入职须知
                                        String CardNo,
                                        String Type
        );
    }


    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void getMessage(
                String Phone,
                String Type
        );

        public abstract void getUpdateMessages(
                String CardNo,
                String Type,
                String IdCardName,
                String IdCard,
                String IdCardAddress,
                String NowAddress,
                String Birthday,
                String Marriage
        );

        public abstract void getUpdateMessage(
                String CardNo,
                String Type,
                String BankName,
                String BankCard,
                String BankUserName,
                String UrgentPerson,
                String UrgentContact,
                String UrgentPhone
        );

        public abstract void getUpdateMessage(//基本信息修改
                                              String CardNo,
                                              String Type,
                                              String Name,
                                              String Sex,
                                              String Phone
//                                              String Marriage
        );

        public abstract void getBankList(
        );

        public abstract void upLoadImg(//上传图片
                                       String cardNo,
                                       String type,
                                       List<String> imglist
        );

        public abstract void upLoadIcon(//上传头像
                                        String cardNo,
                                        String imglist
        );

        public abstract void getUserStatus(
                String cardNo
        );

        public abstract void getMsgnum(
                String cardNo
        );

        public abstract void getDesMessage(//获取温特斯会员的数据
                                           String cardNo
        );

        public abstract void getIsConsent(//是否同意过岗责、保密协议、入职须知
                                          String CardNo,
                                          String Type
        );
    }

}
