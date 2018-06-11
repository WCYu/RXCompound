package com.rxjy.rxcompound.mvp.contract;

import com.rxjy.rxcompound.commons.base.BaseModel;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.base.BaseView;
import com.rxjy.rxcompound.entity.FindBean;

import rx.Observable;

/**
 * Created by hjh on 2017/12/20.
 */

public interface QRLoginSureContract {

    interface View extends BaseView {

        void responseQRLoginSure();

        void responseQRLoginSureError(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {
        Observable<String> getQRLoginSure(
                String kahao,
                String biaoshi
        );
    }

//http://www.rxjy.com/api/values/UPWPS?kahao=02000112&biaoshi=11111111111111111
    abstract class Presenter extends BasePresenter<View, Model> {                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       public abstract void getQRLoginSure(
                String kahao,
                String biaoshi
        );

    }

}
