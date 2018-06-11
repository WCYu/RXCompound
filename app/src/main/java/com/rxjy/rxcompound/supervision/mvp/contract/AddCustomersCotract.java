package com.rxjy.rxcompound.supervision.mvp.contract;

import com.luck.picture.lib.entity.LocalMedia;
import com.rxjy.rxcompound.commons.base.BaseModel;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.base.BaseView;
import com.rxjy.rxcompound.des.entity.LHouseNumBean;

import java.util.List;

import rx.Observable;

/**
 * Created by asus on 2018/4/14.
 */

public interface AddCustomersCotract {
    interface View extends BaseView {
        void responseProListDataError(String msg);

        void  loadProTypeData(String data);
        void showDialog();

        void loaDareaid(LHouseNumBean info);
        void hideDialog();
          void toIntent();



    }
    interface Model extends BaseModel {

        Observable<String> getProTypeData(

        );
        Observable<String> postCustomersInfo(
               String rwdId,
               String cityId,
               String type,
               String clientInfo,
               String clientAuxiliary
        );

        Observable<String> GetOrderNumber(
            String  areaid,
            String  phone

        );
    }

    abstract class Presenter extends BasePresenter<AddCustomersCotract.View, AddCustomersCotract.Model> {

        public abstract void getProTypeData(

        );
        public abstract void postCustomersInfo(
                String rwdId,
                String cityId,
                String type,
                String clientInfo,
                String clientAuxiliary
        );
        public abstract void  GetOrderNumber(
                String  areaid,
                String  phone

        );
    }
}
