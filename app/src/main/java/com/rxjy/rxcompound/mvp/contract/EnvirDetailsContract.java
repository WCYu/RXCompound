package com.rxjy.rxcompound.mvp.contract;

import com.rxjy.rxcompound.commons.base.BaseModel;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.base.BaseView;
import com.rxjy.rxcompound.entity.EnvirImgBean;
import com.rxjy.rxcompound.entity.FigureImgBean;

import java.util.List;

import rx.Observable;

/**
 * Created by hjh on 2018/4/26.
 */

public interface EnvirDetailsContract {

    interface View extends BaseView {


        void responseImg(FigureImgBean data);

        void responseImgError(String msg);

        void responseData( );

        void responseDataError(String msg);

        void responsegetImg(EnvirImgBean data);

        void responsegetImgError(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {

        Observable<String> upLoadImg(//上传图片
                                     List<String> imglist
        );

        Observable<String> upLoadData(
                String EvaluateTxt,
                String Urls,
                String Id,
                String ContentId,
                String OperatorCardNo,
                String OperatorName,
                String Type,
                String RegionId,
                String AreaName
        );

        Observable<String> getImg(
                String ID
        );
    }

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void upLoadImg(//上传图片
                                       List<String> imglist
        );
        public abstract void upLoadData(
                String EvaluateTxt,
                String Urls,
                String Id,
                String ContentId,
                String OperatorCardNo,
                String OperatorName,
                String Type,
                String RegionId,
                String AreaName
        );
        public abstract void getImg(
                String ID
        );
    }
}
