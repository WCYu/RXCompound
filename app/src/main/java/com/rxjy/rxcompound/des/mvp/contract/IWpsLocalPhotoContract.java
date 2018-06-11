package com.rxjy.rxcompound.des.mvp.contract;

import android.content.Context;

import com.rxjy.rxcompound.commons.base.BaseModel;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.base.BaseView;

import java.util.List;

import rx.Observable;

/**
 * Created by Administrator on 2017/4/14.
 */
public interface IWpsLocalPhotoContract
{

    interface View extends BaseView
    {

        /**
         * 返回相机中所有照片
         *
         * @param imgs
         */
        void responsePhotoes(List<String> imgs);

        /**
         * 提示用户只能选择一张照片
         */
        void responseToast();

        /**
         * 启动照相机
         */
        void responseStartCamera();

        /**
         * 返回被选择的照片
         *
         * @param imgSelected
         * @param type
         */
        void responseSelectedPhotoes(String imgSelected, int type);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel
    {
        Observable<List<String>> getPhotoes(Context context);
    }

    abstract class Presenter extends BasePresenter<View, Model>
    {
        public abstract void getPhotoes(Context context);
    }

}
