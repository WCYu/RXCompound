package com.rxjy.rxcompound.des.mvp.contract;

import com.rxjy.rxcompound.commons.base.BaseModel;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.base.BaseView;
import com.rxjy.rxcompound.des.entity.AllImagesInfo;
import com.rxjy.rxcompound.des.entity.HetongCatalogsInfo;

import java.util.List;

import rx.Observable;

/**
 * Created by Administrator on 2017/10/17.
 */

public interface HetongContract {

    interface View extends BaseView {
        void responsePicImgCatalogs();
        void responsedataerror(HetongCatalogsInfo info);
        void responseAllImg(List<AllImagesInfo.Album> info);
        void showDialog();
        void hideDialog();

    }

    interface Model extends BaseModel {

        Observable<String> ProImgCatalogs(
                String rwdId
        );

        Observable<String> GetAllImages(
                String rwdId,
                int enumType
        );

    }

    abstract class Presenter extends BasePresenter<View,Model> {

        public abstract void ProImgCatalogs(
                String rwdId
        );

        public abstract void GetAllImages(
                String rwdId,
                int enumType
        );

    }
}
