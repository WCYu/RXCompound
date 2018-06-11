package com.rxjy.rxcompound.des.mvp.contract;


import com.rxjy.rxcompound.commons.base.BaseModel;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.base.BaseView;
import com.rxjy.rxcompound.des.entity.AllClientInfo;
import com.rxjy.rxcompound.des.entity.AllClientNewBean;
import com.rxjy.rxcompound.des.entity.GetZaishiInfo;
import com.rxjy.rxcompound.entity.FloatedBean;

import java.util.List;

import rx.Observable;

/**
 * Created by Administrator on 2017/8/11.
 */

public interface GetALLClientInfoContract {

    interface View extends BaseView {

        void pagehomelist(List<AllClientInfo.ClientTypeInfo.ClientInfo> list);

        void pagehomelistnew(AllClientNewBean data);

        void pagehomelist2(List<GetZaishiInfo.BodyBean> info);

        void responseDesERLoginData();

        void responseDesERLoginDataError(String msg);

        void showDialog();

        void hideDialog();

        void getFloatedSheetData(List<FloatedBean>  mlist );

    }

    interface Model extends BaseModel {


        Observable<String> getALLClientInfo(
                String phone
        );
        Observable<String> getALLClientInfoNew(
                String mobile
        );

        Observable<String> GetUCList(
                String cardNo
        );

        Observable<String> DesERLogin(
                String cardno,
                String password,
                String uuid
        );
        Observable<String> getFloatedSheet(
                String diquId

        );
    }

    abstract class Presenter extends BasePresenter<View, Model> {


        public abstract void getALLClientInfo(
                String phone
        );
        public abstract void getALLClientInfoNew(
                String mobile
        );

        public abstract void GetUCList(
                String cardNo
        );

        public abstract void DesERLogin(
                String cardno,
                String password,
                String uuid
        );
        public abstract void getFloatedSheet(
                String diquId
        );
    }


}
