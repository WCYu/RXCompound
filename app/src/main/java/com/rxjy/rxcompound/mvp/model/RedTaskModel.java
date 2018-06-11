package com.rxjy.rxcompound.mvp.model;

import android.util.Log;

import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.commons.App;
import com.rxjy.rxcompound.mvp.contract.RedTaskContract;
import com.rxjy.rxcompound.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by Administrator on 2018/5/9.
 */

public class RedTaskModel implements RedTaskContract.Model {
    @Override
    public Observable<String> getRedTask(String cardNo) {

        if(App.dcid==3){

            return ApiEngine.getInstance().getZAApiService()
                    .getMainCaseRedTask(cardNo)
                    .compose(RxSchedulers.<String>switchThread());
        }else if(App.dcid==34)  {

            return ApiEngine.getInstance().getMoneyApiService()
                    .getRedTask(cardNo)
                    .compose(RxSchedulers.<String>switchThread());
        }else {
            /**
             * 获取商务的红包任务列表
             *///https://api.niujingji.cn:8183/JTRenShi/APP_RS_GetRedPackTask?kahao=01010784
            return ApiEngine.getInstance().getRxbusicApiHost()
                    .getBusRed(cardNo)
                    .compose(RxSchedulers.<String>switchThread());
        }

    }
}
