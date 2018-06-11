package com.rxjy.rxcompound.supervision.mvp.contract;

import com.luck.picture.lib.entity.LocalMedia;
import com.rxjy.rxcompound.commons.base.BaseModel;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.base.BaseView;
import com.rxjy.rxcompound.supervision.entity.AttachmentTypeInfo;

import java.util.List;

import rx.Observable;

/**
 * Created by AAA on 2017/12/25.
 */

public interface AttachmentContract {

    interface View extends BaseView {

        void responseAttachmentTypeData(List<AttachmentTypeInfo.AttachmentInfo> dataList);

        void responseAttachmentTypeDataError(String msg);

        void responseSubAttachmentData();

        void responseSubAttachmentDataError(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {

        Observable<String> getAttachmentTypeInfo(

        );

        Observable<String> subAttachmentInfo(
                String orderNo,
                String dayCount,
                int modelId,
                List<LocalMedia> imgList
        );

    }

    abstract class Presenter extends BasePresenter<View, Model> {

        public abstract void getAttachmentTypeInfo(

        );
        public abstract void subAttachmentInfo(
                String orderNo,
                String dayCount,
                int modelId,
                List<LocalMedia> imgList
        );

    }

}
