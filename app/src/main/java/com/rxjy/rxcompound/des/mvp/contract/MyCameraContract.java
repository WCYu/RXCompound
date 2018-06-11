package com.rxjy.rxcompound.des.mvp.contract;

import com.rxjy.rxcompound.commons.base.BaseModel;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.base.BaseView;
import com.rxjy.rxcompound.des.entity.AlbumImgInfo;
import com.rxjy.rxcompound.des.entity.MyCamera;

import java.util.List;

import rx.Observable;

/**
 * Created by Administrator on 2017/8/16.
 */

public interface MyCameraContract {
    interface View extends BaseView {

        void showlistitem(MyCamera mc);

        void showDialog();

        void hideDialog();
        void responseSubImageData(List<AlbumImgInfo.ImgInfo> dataList);

        void responseSubImageDataError(String msg);
    }

    interface Model extends BaseModel {
        Observable<String> getCameraType(
                String rwdId
        );
        Observable<String> subImage2(
                int worksID,
                String catalogID,
                int userID,
                List<String> imgList
        );
    }

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void getCameraType(
                String rwdId
        );

        public abstract void subImage2(
                int worksID,
                String catalogID,
                int userID,
                List<String> imgList
        );

    }


}
