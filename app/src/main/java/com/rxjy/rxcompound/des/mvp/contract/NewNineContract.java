package com.rxjy.rxcompound.des.mvp.contract;


import com.rxjy.rxcompound.commons.base.BaseModel;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.base.BaseView;
import com.rxjy.rxcompound.des.entity.NewNineInfo;
import com.rxjy.rxcompound.des.entity.UpNewXinXi;

import rx.Observable;

/**
 * Created by Administrator on 2017/10/9 0009.
 */

public interface NewNineContract {
    interface View extends BaseView {
        void responseGetNewNine(NewNineInfo.BodyBean info);

        void responseGetNewNineError(String msg);

        void responseUpNewOne(UpNewXinXi upNewXinXi);

        void responseUpNewOneError(String msg);

        void showDialog();

        void hideDialog();


    }

    interface Model extends BaseModel {
        Observable<String> GetNewNine(
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
        public abstract void GetNewNine(
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
