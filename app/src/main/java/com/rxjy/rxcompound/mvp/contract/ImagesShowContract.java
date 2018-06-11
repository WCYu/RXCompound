package com.rxjy.rxcompound.mvp.contract;

import com.rxjy.rxcompound.commons.base.BaseModel;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.base.BaseView;
import com.rxjy.rxcompound.entity.ImagesBean;
import com.rxjy.rxcompound.entity.ImgBean;

import java.util.List;

import rx.Observable;

/**
 * Created by hjh on 2017/11/28.
 */

public interface ImagesShowContract {

    interface View extends BaseView {

        void responseImgsData(ImagesBean data);

        void responseImgsDataError(String msg);

        void responseupImages(ImgBean data);

        void responseupImagesError(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {
        Observable<String> getImgsData(
                String cardNo,
                String img_type
        );
        Observable<String> upImages(
                String cardNo,
                String type,
                List<String> imglist
        );
    }


    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void getImgsData(
                String cardNo,
                String img_type
        );

        public abstract void upImages(
                String cardNo,
                String type,
                List<String> imglist
        );
    }
}
