package com.rxjy.rxcompound.mvp.contract;

import com.rxjy.rxcompound.commons.base.BaseModel;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.base.BaseView;
import com.rxjy.rxcompound.entity.IdentityInfoBean;
import com.rxjy.rxcompound.entity.ImgBean;
import com.rxjy.rxcompound.entity.PersonBean;

import java.util.List;

import rx.Observable;

/**
 * Created by hjh on 2017/11/17.
 */

public interface IdentityInfoContract {

    interface View extends BaseView {
        void responseMessage(IdentityInfoBean data);

        void responseMessageError(String msg);

        void updateMessage();

        void updateMessageError(String msg);

        void responseImg(ImgBean data);

        void responseImgError(String msg);

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
                String IdCard,
                String IdCardName,
                String Birthday,
                String IdCardAddress,
                String NowAddress,
                String Marriage,
                String Xueli
        );
        Observable<String> upLoadImg(
                String cardNo,
                String type,
                List<String> imglist
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
                String IdCard,
                String IdCardName,
                String Birthday,
                String IdCardAddress,
                String NowAddress,
                String Marriage,
                String Xueli
        );
        public abstract void upLoadImg(
                String cardNo,
                String type,
                List<String> imglist
        );
    }
}
