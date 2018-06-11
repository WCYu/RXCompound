package com.rxjy.rxcompound.mvp.contract;

import com.rxjy.rxcompound.commons.base.BaseModel;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.base.BaseView;
import com.rxjy.rxcompound.entity.ArticleBean;
import com.rxjy.rxcompound.entity.FigureImgBean;

import java.util.List;

import rx.Observable;

/**
 * Created by asus on 2018/5/15.
 */

public interface PubLishContract {
    interface View extends BaseView {


        void responseArticleData(ArticleBean.BodyBean body);

        void showDialog();

        void hideDialog();

        void showMessage(String msg);
        void responseImg(FigureImgBean data);

        void responseImgError(String msg);
    }

    interface Model extends BaseModel {
        Observable<String> psetArticleData(
                String name,        // 文章标题
                String cardno,       // 作者卡号
                String author,       // 作者名称
                String cover,       // 文章封面图片
                String content,       // 文章内容
                String flag //修改标识 0添加 1修改

        );
        Observable<String> upLoadImg(//上传图片
                                     List<String> imglist
        );
    }

    abstract class Presenter extends BasePresenter<PubLishContract.View, PubLishContract.Model> {
        public abstract void psetArticleData(
             //    String id,   //文章id  （修改文章的时候必传）
                String name,        // 文章标题
                String cardno,       // 作者卡号
                String author,       // 作者名称
                String cover,       // 文章封面图片
                String content,       // 文章内容
                String flag //修改标识 0添加 1修改
        );
        public abstract void upLoadImg(//上传图片
                                       List<String> imglist
        );
    }


}
