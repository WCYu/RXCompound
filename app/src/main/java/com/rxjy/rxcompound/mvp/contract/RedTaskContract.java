package com.rxjy.rxcompound.mvp.contract;

import com.rxjy.rxcompound.commons.base.BaseModel;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.base.BaseView;
import com.rxjy.rxcompound.entity.AdRedEnvelopesBean;

import java.util.List;

import rx.Observable;

/**
 * Created by Administrator on 2018/5/9.
 */

public interface RedTaskContract {

    interface View extends BaseView {

        void responseTaskData(List<AdRedEnvelopesBean.BodyBean> mlist);

        void responseConsentError(String msg);

        void showDialog();

        void hideDialog();

        void showMeaaage(String msg);

    }

    interface Model extends BaseModel {
        Observable<String> getRedTask(
                String cardNo
        );
    }

    abstract class Presenter extends BasePresenter<RedTaskContract.View, RedTaskContract.Model> {
        public abstract void getRedTask(
                String cardNo
        );
    }
}
