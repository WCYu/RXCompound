package com.rxjy.rxcompound.des.mvp.contract;
import com.rxjy.rxcompound.commons.base.BaseModel;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.base.BaseView;
import com.rxjy.rxcompound.des.entity.GetXunjianXQYInfo;
import com.rxjy.rxcompound.des.entity.UpXJPicInfo;

import java.util.List;

import rx.Observable;

/**
 * Created by Administrator on 2017/10/24.
 */

public interface XunjianXQYContract {

    interface View extends BaseView {

        void responseGetXunjianXinxiData(GetXunjianXQYInfo info);

        void responseUpXunjianXinxiData(String msg);

        void responseXunjianDataError(String msg);

        void UpKaigongPicInfo(UpXJPicInfo info);

        void UpKaigongPicInfoError(UpXJPicInfo info);

        void DeleteKaigongPicInfo(GetXunjianXQYInfo.BodyBean.ChildListBean info, int position);



        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {

        Observable<String> GetScheduleCheckIno(
                String sc_id
        );

        Observable<String> SubmitCheckDes(
                String sc_id,
                String description,
                String address
        );

        Observable<String> UploadCheckImages(
                String sc_Id,
                List<String> imgList
        );

        Observable<String> DeleteloadCheckImages(
                String sc_Id,
                String fileName
        );

    }

    abstract class Presenter extends BasePresenter<View, Model> {

        public abstract void GetScheduleCheckIno(
                String sc_id
        );

        public abstract void SubmitCheckDes(
                String sc_id,
                String description,
                String address
        );
        public abstract void UploadCheckImages(
                String sc_Id,
                List<String> imgList
        );

        public abstract void DeleteloadCheckImages(
                String sc_Id,
                String fileName
        );




    }

}
