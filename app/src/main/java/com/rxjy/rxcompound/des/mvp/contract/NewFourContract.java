package com.rxjy.rxcompound.des.mvp.contract;


import com.rxjy.rxcompound.commons.base.BaseModel;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.base.BaseView;
import com.rxjy.rxcompound.des.entity.NewFourInfo;
import com.rxjy.rxcompound.des.entity.UpNewXinXi;

import rx.Observable;

/**
 * Created by Administrator on 2017/10/8 0008.
 */

public interface NewFourContract {
    interface View extends BaseView {

        void responseGetNewFour(NewFourInfo.BodyBean info);

        void responseGetNewFourError(String msg);

        void responseUpNewOne(UpNewXinXi upNewXinXi);

        void responseUpNewOneError(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {
        Observable<String> GetNewFour(
                String rwdid
        );
        Observable<String> UpXinxi
                (
                        String cardNo,
                        String formpars,
                        String type

                );

    }

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void GetNewFour(
                String rwdid
        );
        public abstract void UpXinxi
                (
                        String cardNo,
                        String formpars,
                        String type

                );
    }

}
