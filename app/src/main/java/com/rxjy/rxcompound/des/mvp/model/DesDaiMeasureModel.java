package com.rxjy.rxcompound.des.mvp.model;

import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.des.mvp.contract.DesDaiMeasureContract;
import com.rxjy.rxcompound.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by Administrator on 2017/6/21.
 */
public class DesDaiMeasureModel implements DesDaiMeasureContract.Model
{

    @Override
    public Observable<String> subMeasureData(String rwdID, int caCaHousingSituation, String caHouseOrientation, int caOccupyPublicCorridor, String caIsGroundSmooth
            , double caCargoDoorHight, double caCargoDoorWide, String caOriginalGroundMaterial, double caGroundElevation, double caSpaceMaxHeight, double camainBeamHeight, double caSecondaryHeight
            , double caMinimumSprayHeight, int caAirConditionerNum, double caTuyereMinimumHeight, int caStrongBoxNum, int caWeakBoxNum, int caUpWaterSpot, int caDownWaterSpot
            , double caDownWaterSpotSize, double caCurtainWallSpacing, String caWindowType, double caWindowSillHight, double caWindowWidth, String caOriginalTopMaterial
            , String caOriginalWallMaterial, double caSpaceMinHeight, String caWaterPath, double caWindowHight, int caOriginalGround, double caRental, int caRentFreeDate
            , String caLeaseTermStart, String caLeaseTermEnd, String ciProHead, String ciDecorationAddress, double caDecBudgetPrice)
    {
        return ApiEngine.getInstance().getDesApiService()
                .subMeasureData(
                        rwdID,
                        caCaHousingSituation + "",
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
                        caDecBudgetPrice
                )
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getDaiMeasureData(String rwdID)
    {
        return ApiEngine.getInstance().getDesApiService()
                .getMeasureData(rwdID)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getDaiMeasureImageData(String rwdId, String enumType, String token)
    {
        return ApiEngine.getInstance().getDesApiService()
                .getAllImages(rwdId, enumType)
                .compose(RxSchedulers.<String>switchThread());
    }
}
