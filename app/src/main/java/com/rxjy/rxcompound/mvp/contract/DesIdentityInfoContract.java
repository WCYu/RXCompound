package com.rxjy.rxcompound.mvp.contract;

import com.rxjy.rxcompound.commons.base.BaseModel;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.base.BaseView;
import com.rxjy.rxcompound.entity.ImageDesBean;
import com.rxjy.rxcompound.entity.ImgBean;
import com.rxjy.rxcompound.entity.ResultBean;

import java.util.List;

import rx.Observable;

/**
 * Created by hjh on 2018/4/21.
 */

public interface DesIdentityInfoContract {

    interface View extends BaseView {

        void responseDesIdentityMessage(ResultBean data);

        void responseDesIdentityMessageError(String msg);

        void responseDesIdenImgMessage(ImageDesBean data);

        void responseDesIdenImgMessageError(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {
        Observable<String> updateDesIdentityMessage(
                String card_no,
                String Type,
                String phone,
                String nick_name,
                String sex,
                String id_card,
                String birthday,
                String living_place,
                String education,
                String email
        );
        Observable<String> upLoadDesIdentityImg(//上传图片
                                                String cardNo,
                                                String type,
                                                List<String> imglist
        );
    }

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void updateDesIdentityMessage(
                String card_no,
                String Type,
                String phone,
                String nick_name,
                String sex,
                String id_card,
                String birthday,
                String living_place,
                String education,
                String email
        );
        public abstract void upLoadDesIdentityImg(//上传图片
                                       String cardNo,
                                       String type,
                                       List<String> imglist
        );
    }

}