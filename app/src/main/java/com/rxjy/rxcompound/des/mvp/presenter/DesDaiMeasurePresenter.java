package com.rxjy.rxcompound.des.mvp.presenter;

import android.util.Log;

import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.des.entity.AllImagesInfo;
import com.rxjy.rxcompound.des.entity.DesSubInfo;
import com.rxjy.rxcompound.des.entity.MeasureDetailInfo;
import com.rxjy.rxcompound.des.mvp.contract.DesDaiMeasureContract;
import com.rxjy.rxcompound.des.mvp.model.DesDaiMeasureModel;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by Administrator on 2017/6/21.
 */
public class DesDaiMeasurePresenter extends DesDaiMeasureContract.Presenter
{

    public static final String TAG = "DesDaiMeasurePresenter";

    public DesDaiMeasurePresenter(DesDaiMeasureContract.View mView)
    {
        this.mView = mView;
        mModel = new DesDaiMeasureModel();
    }

    @Override
    public void subMeasureData(String rwdID, int caCaHousingSituation, String caHouseOrientation, int caOccupyPublicCorridor, String caIsGroundSmooth, double caCargoDoorHight, double caCargoDoorWide, String caOriginalGroundMaterial, double caGroundElevation, double caSpaceMaxHeight, double camainBeamHeight, double caSecondaryHeight, double caMinimumSprayHeight, int caAirConditionerNum, double caTuyereMinimumHeight, int caStrongBoxNum, int caWeakBoxNum, int caUpWaterSpot, int caDownWaterSpot, double caDownWaterSpotSize, double caCurtainWallSpacing, String caWindowType, double caWindowSillHight, double caWindowWidth, String caOriginalTopMaterial, String caOriginalWallMaterial, double caSpaceMinHeight, String caWaterPath, double caWindowHight, int caOriginalGround, double caRental, int caRentFreeDate, String caLeaseTermStart, String caLeaseTermEnd, String ciProHead, String ciDecorationAddress, double caDecBudgetPrice)
    {
        Subscription subscribe = mModel.subMeasureData(
                rwdID,
                caCaHousingSituation,
                caHouseOrientation,
                caOccupyPublicCorridor,
                caIsGroundSmooth,
                caCargoDoorHight,
                caCargoDoorWide,
                caOriginalGroundMaterial,
                caGroundElevation,
                caSpaceMaxHeight,
                camainBeamHeight,
                caSecondaryHeight,
                caMinimumSprayHeight,
                caAirConditionerNum,
                caTuyereMinimumHeight,
                caStrongBoxNum,
                caWeakBoxNum,
                caUpWaterSpot,
                caDownWaterSpot,
                caDownWaterSpotSize,
                caCurtainWallSpacing,
                caWindowType,
                caWindowSillHight,
                caWindowWidth,
                caOriginalTopMaterial,
                caOriginalWallMaterial,
                caSpaceMinHeight,
                caWaterPath,
                caWindowHight,
                caOriginalGround,
                caRental,
                caRentFreeDate,
                caLeaseTermStart,
                caLeaseTermEnd,
                ciProHead,
                ciDecorationAddress,
                caDecBudgetPrice)
                .subscribe(new Subscriber<String>()
                {

                    @Override
                    public void onStart()
                    {
                        mView.showDialog();
                    }

                    @Override
                    public void onCompleted()
                    {
                        mView.hideDialog();
                    }

                    @Override
                    public void onError(Throwable e)
                    {
                        Log.e(TAG, "上传量房信息失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s)
                    {
                        DesSubInfo info = JSONUtils.toObject(s, DesSubInfo.class);
                        if (info.getStatusCode() == 0)
                        {
                            mView.responseSubMeasureData();
                        } else
                        {
                            mView.responseSubMeasureDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void getDaiMeasureData(String rwdID)
    {
        Subscription subscribe = mModel.getDaiMeasureData(rwdID)
                .subscribe(new Subscriber<String>()
                {

                    @Override
                    public void onStart()
                    {
                        mView.showDialog();
                    }

                    @Override
                    public void onCompleted()
                    {
                        mView.hideDialog();
                    }

                    @Override
                    public void onError(Throwable e)
                    {
                        Log.e(TAG, "获取量房信息失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s)
                    {
                        Log.e(TAG,s);
                        //Measure 测量
                        MeasureDetailInfo info = JSONUtils.toObject(s, MeasureDetailInfo.class);
                        if (info.getStatusCode() == 0)
                        {
                            MeasureDetailInfo.MeasureInfo data = info.getBody();
                            mView.responseMeasureData(data);
                        } else
                        {
                            mView.responseDaiMeasureError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void getDaiMeasureImageData(String rwdId, String enumType, String token)
    {
        Subscription subscribe = mModel.getDaiMeasureImageData(rwdId, enumType, token)
                .subscribe(new Subscriber<String>()
                {

                    @Override
                    public void onStart()
                    {
                        mView.showDialog();
                    }

                    @Override
                    public void onCompleted()
                    {
                        mView.hideDialog();
                    }

                    @Override
                    public void onError(Throwable e)
                    {
                        Log.e(TAG, "获取量房图片列表失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s)
                    {
                        Log.e("desdaimea",s);
                        AllImagesInfo info = JSONUtils.toObject(s, AllImagesInfo.class);
                        if (info.getStatusCode() == 0)
                        {
                            List<AllImagesInfo.Album> dataList = info.getBody();
                            mView.responseDaiMeasureData(dataList);
                        } else if (info.getStatusCode() == 104)
                        {
                            mView.responseDaiMeasureError(info.getStatusMsg());
                        } else
                        {
                            mView.responseDaiMeasureError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
