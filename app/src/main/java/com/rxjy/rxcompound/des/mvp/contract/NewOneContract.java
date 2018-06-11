package com.rxjy.rxcompound.des.mvp.contract;


import com.rxjy.rxcompound.commons.base.BaseModel;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.base.BaseView;
import com.rxjy.rxcompound.des.entity.NewOneInfo;
import com.rxjy.rxcompound.des.entity.UpDanHaoInfo;
import com.rxjy.rxcompound.des.entity.UpNewXinXi;

import rx.Observable;

/**
 * Created by Administrator on 2017/10/8 0008.
 */

public interface NewOneContract {
    interface View extends BaseView {

        void responseGetNewOne(NewOneInfo.BodyBean info);

        void responseGetNewOneError(String msg);

        void responseUpNewOne(UpNewXinXi upNewXinXi);

        void responseUpNewOneError(String msg);

        void responseUpDanHao(UpDanHaoInfo info);

        void responseUpDanHaoError(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {
        Observable<String> GetNewOne(
                String rwdid
        );
        Observable<String> UpXinxi
                (
                        String cardNo,
                        String formpars,
                        String type

                );

        Observable<String> UpDanHao
                (
                        String rwdid
                );

    }

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void GetNewOne(
                String rwdid
        );
        public abstract void UpXinxi
                (
               String cardNo,
               String formpars,
               String type

                );
        public abstract void UpDanHao
                (
                        String rwdid
                );

    }
}
