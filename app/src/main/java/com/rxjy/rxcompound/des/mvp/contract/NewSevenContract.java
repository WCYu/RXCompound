package com.rxjy.rxcompound.des.mvp.contract;


import com.rxjy.rxcompound.commons.base.BaseModel;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.base.BaseView;
import com.rxjy.rxcompound.des.entity.NewSevenInfo;
import com.rxjy.rxcompound.des.entity.UpNewXinXi;

import rx.Observable;

/**
 * Created by Administrator on 2017/10/9 0009.
 */

public interface NewSevenContract {
    interface View extends BaseView {
        void responseGetNewSeven(NewSevenInfo.BodyBean info);

        void responseGetNewSevenError(String msg);

        void responseUpNewOne(UpNewXinXi upNewXinXi);

        void responseUpNewOneError(String msg);

        void showDialog();

        void hideDialog();


}

interface Model extends BaseModel {
    Observable<String> GetNewSeven(
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
    public abstract void GetNewSeven(
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
