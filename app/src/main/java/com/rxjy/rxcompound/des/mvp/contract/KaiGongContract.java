package com.rxjy.rxcompound.des.mvp.contract;

import com.rxjy.rxcompound.commons.base.BaseModel;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.base.BaseView;
import com.rxjy.rxcompound.des.entity.AllImagesInfo;

import java.util.List;

import rx.Observable;

/**
 * Created by Administrator on 2017/10/23.
 */

public interface KaiGongContract {
    interface View extends BaseView {
        void responseKaigongInfo(List<AllImagesInfo.Album> info);

        void responseKaigongInfoError(String error);

        void showDialog();

        void hideDialog();
    }

    interface Model extends BaseModel {
        Observable<String> GetUCAllImages(
                String rwdId,
                int enumType
        );

    }

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void GetUCAllImages(
                String rwdId,
                int enumType
        );

    }

}
