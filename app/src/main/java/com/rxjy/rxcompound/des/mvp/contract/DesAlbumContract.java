package com.rxjy.rxcompound.des.mvp.contract;


import com.rxjy.rxcompound.commons.base.BaseModel;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.base.BaseView;
import com.rxjy.rxcompound.des.entity.AlbumImgInfo;
import com.rxjy.rxcompound.des.entity.AllImagesInfo;
import com.rxjy.rxcompound.des.entity.GetYiLiangFangAllInfo;

import java.util.List;

import rx.Observable;

/**
 * Created by Administrator on 2017/6/22.
 */
public interface DesAlbumContract
{

    interface View extends BaseView
    {

        void responseSubImageData(List<AlbumImgInfo.ImgInfo> dataList);

        void responseSubImageDataError(String msg);

        void responseDeleteImageData();

        void responseDeleteImageDataError(String msg);

        void deletePhoto(AllImagesInfo.Album.image img, int position);

        void deletePhoto(GetYiLiangFangAllInfo.BodyBean.HuanJingZhaoPianBean.image img, int position);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel
    {

        Observable<String> subImage(
                int worksID,
                int catalogID,
                String userID,
                List<String> imgList
        );

        Observable<String> deleteImage(
                int detailID,
                String fileName
        );

    }

    abstract class Presenter extends BasePresenter<View, Model>
    {

        public abstract void subImage(
                int worksID,
                int catalogID,
                String userID,
                List<String> imgList
        );

        public abstract void deleteImage(
                int detailID,
                String fileName
        );

    }

}
