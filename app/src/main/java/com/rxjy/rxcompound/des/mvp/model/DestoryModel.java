package com.rxjy.rxcompound.des.mvp.model;


import android.util.Log;

import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.commons.App;
import com.rxjy.rxcompound.des.mvp.contract.DestoryContract;
import com.rxjy.rxcompound.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by Administrator on 2017/10/13.
 */

public class DestoryModel implements DestoryContract.Model {
    @Override
    public Observable<String> getDestoryListener() {
        return ApiEngine.getInstance().getRsApiService()
                .destorylistener()
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getRedTask(String cardNo) {
        Log.e("=======", App.dcid+"");
        if(App.dcid==3){
            // 主案
            return ApiEngine.getInstance().getNOApiService()
                    .getMainCaseRed(cardNo)
                    .compose(RxSchedulers.<String>switchThread());
        }else if(App.dcid==34) {
            //行政
            return ApiEngine.getInstance().getZTApiService()
                    .getAdministrationRed(cardNo)
                    .compose(RxSchedulers.<String>switchThread());
        }else {
            /**
             * 获取商务的红包任务列表
             *///https://api.niujingji.cn:8183/JTRenShi/APP_RS_GetRedPackTask?kahao=01010784
            return ApiEngine.getInstance().getRxbusicApiHost()
                    .getBusinessRed(cardNo)
                    .compose(RxSchedulers.<String>switchThread());
        }
    }
}
