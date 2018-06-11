package com.rxjy.rxcompound.mvp.contract;

import com.rxjy.rxcompound.commons.base.BaseModel;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.base.BaseView;
import com.rxjy.rxcompound.entity.ImageDesBean;
import com.rxjy.rxcompound.entity.ImgBean;

import java.util.List;

import rx.Observable;

/**
 * Created by hjh on 2018/4/21.
 */

public interface ImageShowDesContract {
    interface View extends BaseView {

        void responseDesIdenImgMessage(ImageDesBean data);

        void responseDesIdenImgMessageError(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {
        Observable<String> upLoadDesIdentityImg(//上传图片
                                                String cardNo,
                                                String type,
                                                List<String> imglist
        );
    }

    abstract class Presenter extends BasePresenter<View, Model> {

        public abstract void upLoadDesIdentityImg(//上传图片
                                                  String cardNo,
                                                  String type,
                                                  List<String> imglist
        );
    }

}