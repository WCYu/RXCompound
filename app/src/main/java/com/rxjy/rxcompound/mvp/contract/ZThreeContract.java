package com.rxjy.rxcompound.mvp.contract;

import com.rxjy.rxcompound.commons.base.BaseModel;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.base.BaseView;
import com.rxjy.rxcompound.entity.BankBean;
import com.rxjy.rxcompound.entity.IdentityInfoBean;
import com.rxjy.rxcompound.entity.ImgBean;
import com.rxjy.rxcompound.entity.ZthreeBean;

import java.util.List;

import rx.Observable;

import static android.R.attr.id;

/**
 * Created by hjh on 2018/5/10.
 */

public interface ZThreeContract {

    interface View extends BaseView {
        void responseMessage(ZthreeBean data);

        void responseMessageError(String msg);

        void updateMessage();

        void updateMessageError(String msg);

        void responseImg(ImgBean data);

        void responseImgError(String msg);

        void responseBankList(BankBean data);

        void responseBankListError(String msg);

        void showDialog();

        void hideDialog();
    }

    interface Model extends BaseModel {

        Observable<String> getMessage(
                String Phone,
                String Type
        );
        Observable<String> upDataMessage(
                String Phone,
                String Type,
                String BankCard,
                String BankName,
                String BankUserName,
                String UrgentPerson,
                String UrgentPhone,
                String UrgentContact,
                int id
        );
        Observable<String> upLoadImg(
                String cardNo,
                String type,
                List<String> imglist
        );
        Observable<String> getBankList(
        );

    }


    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void getMessage(
                String Phone,
                String Type
        );
        public abstract void upDataMessage(
                String Phone,
                String Type,
                String BankCard,
                String BankName,
                String BankUserName,
                String UrgentPerson,
                String UrgentPhone,
                String UrgentContact,
                    int id
        );
        public abstract void upLoadImg(
                String cardNo,
                String type,
                List<String> imglist
        );
        public abstract void getBankList(
        );
    }

}
