package com.rxjy.rxcompound.des.mvp.contract;

import com.rxjy.rxcompound.commons.base.BaseModel;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.base.BaseView;
import com.rxjy.rxcompound.des.entity.AllImagesInfo;

import java.util.List;

import rx.Observable;

/**
 * Created by Administrator on 2017/6/22.
 */
public interface DesDaiSurroundingsContract {

    interface View extends BaseView {


        void responseDaiSurroundingsData(List<AllImagesInfo.Album> dataList);

        void responseDaiSurroundingsError(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {

        Observable<String> getDaiSurroundingsData(
                String rwdId,
                String enumType,
                String token
        );

    }

    abstract class Presenter extends BasePresenter<View, Model> {

        public abstract void getDaiSurroundingsData(
                String rwdId,
                String enumType,
                String token
        );

    }

}
