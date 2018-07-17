package com.rxjy.rxcompound.des.mvp.presenter;

import android.util.Log;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.des.entity.AllClientInfo;
import com.rxjy.rxcompound.des.entity.AllClientNewBean;
import com.rxjy.rxcompound.des.entity.GetZaishiInfo;
import com.rxjy.rxcompound.des.entity.ResultBean;
import com.rxjy.rxcompound.des.mvp.contract.GetALLClientInfoContract;
import com.rxjy.rxcompound.des.mvp.model.GetALLClientInfoModel;
import com.rxjy.rxcompound.entity.FloatedBean;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by Administrator on 2017/8/11.
 */

public class GetALLClientInfoPresenter extends GetALLClientInfoContract.Presenter {

    public static final String TAG = "GetALLClientInfoPresent";

    public GetALLClientInfoPresenter(GetALLClientInfoContract.View mView) {
        this.mView = mView;
        mModel = new GetALLClientInfoModel();
    }


    @Override
    public void getALLClientInfo(String phone) {
        Subscription subscribe = mModel.getALLClientInfo(phone).subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {
                mView.hideDialog();
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, e.toString());
                mView.hideDialog();
            }

            @Override
            public void onNext(String s) {
                mView.showDialog();
                AllClientInfo clientInfo = JSONUtils.toObject(s, AllClientInfo.class);
                int size = clientInfo.getBody().size();

                for (int i = 0; i < size; i++) {
                    if (clientInfo.getBody().get(i).getStage() == 1) {
                        List<AllClientInfo.ClientTypeInfo.ClientInfo> list = clientInfo.getBody().get(i).getList();
                        mView.pagehomelist(list);
                    }
                }
                Log.e(TAG, s);
            }
        });
        addSubscribe(subscribe);
    }

    @Override
    public void getALLClientInfoNew(String mobile) {
        Subscription subscribe = mModel.getALLClientInfoNew(mobile)
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
                        Log.e(TAG, e.toString());
                        mView.hideDialog();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("---在施---", s);
                        AllClientNewBean info = JSONUtils.toObject(s, AllClientNewBean.class);
                        if (info.getStatusCode() == 0) {
                            mView.pagehomelistnew(info);
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void GetUCList(String cardNo) {
        Subscription subscribe = mModel.GetUCList(cardNo).subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {
                mView.hideDialog();
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, e.toString());
                mView.hideDialog();
            }

            @Override
            public void onStart() {
                mView.showDialog();

            }

            @Override
            public void onNext(String s) {
                Log.e(TAG, s);
//                Log.e("---在施---", s);
                GetZaishiInfo info = JSONUtils.toObject(s, GetZaishiInfo.class);
                if (info.getStatusCode() == 0) {
                    mView.pagehomelist2(info.getBody());
                }
            }
        });
        addSubscribe(subscribe);
    }

    @Override
    public void DesERLogin(String cardno, String password, String uuid) {
        Subscription subscribe = mModel.DesERLogin(cardno, password, uuid)
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {
                        mView.hideDialog();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.hideDialog();
                    }

                    @Override
                    public void onStart() {
                        mView.showDialog();

                    }

                    @Override
                    public void onNext(String s) {
                        ResultBean info = JSONUtils.toObject(s, ResultBean.class);
                        if (info.getStatusCode() == 0) {
                            mView.responseDesERLoginData();
                        }else{
                            mView.responseDesERLoginDataError(info.getStatusMsg());
                        }


                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void getFloatedSheet(String diquId) {
        Subscription subscribe = mModel.getFloatedSheet(diquId)
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {
                        mView.hideDialog();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("tag",e.getMessage());
                        mView.hideDialog();
                    }

                    @Override
                    public void onStart() {
                        mView.showDialog();

                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("tag",s);
                        List<FloatedBean> mlist = new Gson().fromJson(s, new TypeToken<List<FloatedBean>>() {

                        }.getType());
                        mView.getFloatedSheetData(mlist);
//                        ResultBean info = JSONUtils.toObject(s, ResultBean.class);
//                        if (info.getStatusCode() == 0) {
//                            mView.responseDesERLoginData();
//                        }else{
//                            mView.responseDesERLoginDataError(info.getStatusMsg());
//                        }


                    }
                });
        addSubscribe(subscribe);
    }
}
