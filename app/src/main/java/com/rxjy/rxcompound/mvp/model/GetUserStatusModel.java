package com.rxjy.rxcompound.mvp.model;

import android.util.Log;

import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.commons.App;
import com.rxjy.rxcompound.mvp.contract.GetUserStatusContract;
import com.rxjy.rxcompound.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by hjh on 2017/11/20.
 */

public class GetUserStatusModel implements GetUserStatusContract.Model{
    @Override
    public Observable<String> getUserStatus(String cardNo) {
        return ApiEngine.getInstance().getRsApiService()
                .getUserStatus(cardNo)
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
