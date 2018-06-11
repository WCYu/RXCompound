package com.rxjy.rxcompound.mvp.presenter;

import android.util.Log;

import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.entity.AdRedEnvelopesBean;
import com.rxjy.rxcompound.entity.CheckIsBeingBean;
import com.rxjy.rxcompound.mvp.contract.RedTaskContract;
import com.rxjy.rxcompound.mvp.contract.SettingContract;
import com.rxjy.rxcompound.mvp.model.RedTaskModel;
import com.rxjy.rxcompound.mvp.model.SettingModel;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by Administrator on 2018/5/9.
 */

public class RedTaskPresenter extends RedTaskContract.Presenter {

    public RedTaskPresenter(RedTaskContract.View mView) {
        this.mView = mView;
        mModel = new RedTaskModel();
    }
    @Override
    public void getRedTask(String cardNo) {

        Subscription subscribe = mModel.getRedTask(cardNo)
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
                        Log.e("RedTaskPresenter", "获取红包列表是否存在失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("RedTaskPresenter",s);
                        AdRedEnvelopesBean info = JSONUtils.toObject(s, AdRedEnvelopesBean.class);
                        if(info.getStatusCode()==0){//
                            mView.responseTaskData(info.getBody());
                        }else if(info.getStatusCode()==-1){
                            mView.responseConsentError(info.getStatusMsg());
                        }

                    }
                });
        addSubscribe(subscribe);
    }
}
