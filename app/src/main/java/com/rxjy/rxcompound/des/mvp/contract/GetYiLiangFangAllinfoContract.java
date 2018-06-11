package com.rxjy.rxcompound.des.mvp.contract;

import com.rxjy.rxcompound.commons.base.BaseModel;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.base.BaseView;
import com.rxjy.rxcompound.des.entity.AllImagesInfo;
import com.rxjy.rxcompound.des.entity.GetYiLiangFangAllInfo;

import java.util.List;

import rx.Observable;

/**
 * Created by Administrator on 2017/8/18.
 */

public interface GetYiLiangFangAllinfoContract {
    interface View extends BaseView {
        void responseMeasureData(GetYiLiangFangAllInfo info);
        void responseMeasureError(String error);
        void responseAllImagesData(List<AllImagesInfo.Album> list);
        void responseAllImagesError(String error);
        void showDialog();
        void reLogin(String msg);
        void hideDialog();

    }

    interface Model extends BaseModel {

        Observable<String> GetYiLiangFangAllinfo(
                String rwdId
        );
        Observable<String> getAllImagesData(
                String rwdId,
                String enumType,
                String token
        );
    }

    abstract class Presenter extends BasePresenter<View,Model> {

        public abstract void GetYiLiangFangAllinfo(
                String rwdId
        );
        public abstract void getAllImagesData(
                String rwdId,
                String enumType,
                String token
        );
    }
}
