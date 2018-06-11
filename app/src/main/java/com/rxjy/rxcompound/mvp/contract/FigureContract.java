package com.rxjy.rxcompound.mvp.contract;

import com.rxjy.rxcompound.commons.base.BaseModel;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.base.BaseView;
import com.rxjy.rxcompound.entity.FigureImgBean;
import com.rxjy.rxcompound.entity.FigurePersonBean;

import java.util.List;

import rx.Observable;

/**
 * Created by hjh on 2018/4/25.
 */

public interface FigureContract {
    interface View extends BaseView {

        void responsePerson(FigurePersonBean data);

        void responsePersonError(String msg);

        void responseImg(FigureImgBean data);

        void responseImgError(String msg);

        void responseData( );

        void responseDataError(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {
        Observable<String> getPerson(
                String CardNo,
                String DepartId
        );

        Observable<String> upLoadImg(//上传图片
                                     List<String> imglist
        );

        Observable<String> upLoadData(
                String CardNo,
                String Name,
                String EvaluateTxt,
                String Urls,
                String Id,
                String OperatorCardNo,
                String OperatorName,
                String RegionId,
                String EduDepartId
        );
    }

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void getPerson(
                String CardNo,
                String DepartId
        );

        public abstract void upLoadImg(//上传图片
                                       List<String> imglist
        );
        public abstract void upLoadData(
                String CardNo,
                String Name,
                String EvaluateTxt,
                String Urls,
                String Id,
                String OperatorCardNo,
                String OperatorName,
                String RegionId,
                String EduDepartId
        );
    }
}
