package com.rxjy.rxcompound.mvp.contract;

import com.rxjy.rxcompound.commons.base.BaseModel;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.base.BaseView;
import com.rxjy.rxcompound.entity.BankBean;
import com.rxjy.rxcompound.entity.ImageDesBean;
import com.rxjy.rxcompound.entity.ResultBean;

import java.util.List;

import rx.Observable;

/**
 * Created by hjh on 2018/4/21.
 */

public interface DesEnterJobContract {

    interface View extends BaseView {

        void responseDesJobMessage(ResultBean data);

        void responseDesJobMessageError(String msg);

        void responseDesIdenImgMessage(ImageDesBean data);

        void responseDesIdenImgMessageError(String msg);

        void responseBankMessage(BankBean data);

        void responseBankMessageError(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {
        Observable<String> updateDesJobMessage(
                String card_no,
                String Type,
                String bank_name,
                String bank_card,
                String bank_user_name,
                 int bank_user_branch
        );
        Observable<String> upLoadDesIdentityImg(//上传图片
                                                String cardNo,
                                                String type,
                                                List<String> imglist
        );
        Observable<String> getBankList(
        );
    }

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void updateDesJobMessage(
                String card_no,
                String Type,
                String bank_name,
                String bank_card,
                String bank_user_name,
                int bank_user_branch
        );
        public abstract void upLoadDesIdentityImg(//上传图片
                                                  String cardNo,
                                                  String type,
                                                  List<String> imglist
        );
        public abstract void getBankList(
        );
    }

}