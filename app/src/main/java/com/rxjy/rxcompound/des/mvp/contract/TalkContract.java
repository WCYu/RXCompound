package com.rxjy.rxcompound.des.mvp.contract;

import com.rxjy.rxcompound.commons.base.BaseModel;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.base.BaseView;
import com.rxjy.rxcompound.des.entity.GetHuiFang;

import java.util.List;

import rx.Observable;

/**
 * Created by Administrator on 2017/8/15.
 */

public interface TalkContract {

    interface View extends BaseView {


        void responseTalkData();

        void responseTalkDataError(String msg);

        void xlshowList(GetHuiFang huifang);
        void showList(List<GetHuiFang.Body> body);

        void showDialog();

        void hideDialog();

        void loadnodata();

    }

    interface Model extends BaseModel {

        Observable<String> getHuiFangData(
                String rwdId,
                int pageIndex
        );
        Observable<String> xlgetHuiFangData(
                String rwdId,
                int pageIndex
        );


        Observable<String> addHuiFangData(
                String rwdId,
                String content,
                int methods
        );
    }

    abstract class Presenter extends BasePresenter<View, Model> {

        public abstract void getHuiFangData(
                String rwdId,
                int pageIndex
        );
        public abstract void xlgetHuiFangData(
                String rwdId,
                int pageIndex
        );
        public abstract void addHuiFangData(
                String rwdId,
                String content,
                int methods
        );

    }

}
