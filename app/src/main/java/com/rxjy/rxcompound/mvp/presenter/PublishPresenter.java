package com.rxjy.rxcompound.mvp.presenter;

import android.util.Log;

import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.entity.AdRedEnvelopesBean;
import com.rxjy.rxcompound.entity.ArticleBean;
import com.rxjy.rxcompound.entity.FigureImgBean;
import com.rxjy.rxcompound.mvp.contract.PubLishContract;
import com.rxjy.rxcompound.mvp.contract.QRLoginSureContract;
import com.rxjy.rxcompound.mvp.model.PublishModel;
import com.rxjy.rxcompound.mvp.model.QRLoginSureModel;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by asus on 2018/5/16.
 */

public class PublishPresenter extends PubLishContract.Presenter {
    public PublishPresenter(PubLishContract.View mView) {
        this.mView = mView;
        mModel = new PublishModel();
    }
    @Override
    public void psetArticleData(  String name, String cardno, String author, String cover, String content, String flag) {
        Subscription subscribe = mModel.psetArticleData(name,cardno,author,cover,content,flag)
                .subscribe(new Subscriber<String>() {

                    @Override
                    public void onStart() {
                        mView.showDialog();
                    }

                    @Override
                    public void onCompleted() {
                        mView.hideDialog();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("========", "发表失败 = " + e.toString());
                        mView.showMessage(e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("======", "发表成功 = " +s);
                        ArticleBean info = JSONUtils.toObject(s, ArticleBean.class);
                        if(info.getStatusCode()==0){//
                            mView.responseArticleData(info.getBody());
                        }else if(info.getStatusCode()==-1){
                            mView.showMessage(info.getStatusMsg());
                        }

                    }

                });
        addSubscribe(subscribe);
    }

    @Override
    public void upLoadImg(List<String> imglist) {
        Subscription subscribe = mModel.upLoadImg(imglist)
                .subscribe(new Subscriber<String>() {

                    @Override
                    public void onStart() {
                        mView.showDialog();
                    }

                    @Override
                    public void onCompleted() {
                        mView.hideDialog();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("========", "获取检查是否存在失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                         Log.e("========", "获取检查是否成功 = " + s);
                        FigureImgBean info = JSONUtils.toObject(s, FigureImgBean.class);
                        if(info.getStatusCode()==0){
                            mView.responseImg(info);
                        }else{
                            mView.responseImgError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
