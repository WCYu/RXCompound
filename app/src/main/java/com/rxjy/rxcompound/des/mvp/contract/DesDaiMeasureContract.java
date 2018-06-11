package com.rxjy.rxcompound.des.mvp.contract;



import com.rxjy.rxcompound.commons.base.BaseModel;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.base.BaseView;
import com.rxjy.rxcompound.des.entity.AllImagesInfo;
import com.rxjy.rxcompound.des.entity.MeasureDetailInfo;

import java.util.List;

import rx.Observable;

/**
 * Created by Administrator on 2017/6/21.
 */
public interface DesDaiMeasureContract
{

    interface View extends BaseView
    {

        void responseMeasureData(MeasureDetailInfo.MeasureInfo info);

        void responseMeasureDateError(String msg);

        void responseSubMeasureData();

        void responseSubMeasureDataError(String msg);

        void responseDaiMeasureData(List<AllImagesInfo.Album> dataList);

        void responseDaiMeasureError(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel
    {
        Observable<String> subMeasureData(
                //单号
                String rwdID,
                //房屋现状
                int caCaHousingSituation,
                //房屋朝向
                String caHouseOrientation,
                //占用公共过道
                int caOccupyPublicCorridor,
                //地面是否平整
                String caIsGroundSmooth,
                //货梯们高度
                double caCargoDoorHight,
                //货梯们宽度
                double caCargoDoorWide,
                //原地面材质
                String caOriginalGroundMaterial,
                //原顶面材质
                double caGroundElevation,
                //地面高差
                double caSpaceMaxHeight,
                //主梁下（主梁下高度）
                double camainBeamHeight,
                //次梁下（次梁下高度）
                double caSecondaryHeight,
                //淋喷最低点
                double caMinimumSprayHeight,
                //空调设备个数
                int caAirConditionerNum,
                //风口最低点
                double caTuyereMinimumHeight,
                //强电箱个数
                int caStrongBoxNum,
                //弱电箱个数
                int caWeakBoxNum,
                //上水电
                int caUpWaterSpot,
                //下水点
                int caDownWaterSpot,
                //下水管径
                double caDownWaterSpotSize,
                //幕墙架间距
                double caCurtainWallSpacing,
                //窗户类型
                String caWindowType,
                //窗台高
                double caWindowSillHight,
                //窗户高
                double caWindowWidth,
                //原顶面材质
                String caOriginalTopMaterial,
                //原墙面材质
                String caOriginalWallMaterial,
                //空间最低点高度
                double caSpaceMinHeight,
                //上下水路径
                String caWaterPath,
                //窗户宽
                double caWindowHight,
                //原地面保存
                int caOriginalGround,
                //租金/单价
                double caRental,
                //免租期
                int caRentFreeDate,
                //租期开始日期
                String caLeaseTermStart,
                //租期结束日期
                String caLeaseTermEnd,
                //客户姓名
                String ciProHead,
                //量房地址
                String ciDecorationAddress,
                //装修预算
                double caDecBudgetPrice
        );

        Observable<String> getDaiMeasureData(
                String rwdID
        );

        Observable<String> getDaiMeasureImageData(
                String rwdId,
                String enumType,
                String token
        );

    }

    abstract class Presenter extends BasePresenter<View, Model>
    {

        public abstract void subMeasureData(
                //单号
                String rwdID,
                //房屋现状
                int caCaHousingSituation,
                //房屋朝向
                String caHouseOrientation,
                //占用公共过道
                int caOccupyPublicCorridor,
                //地面是否平整
                String caIsGroundSmooth,
                //货梯们高度
                double caCargoDoorHight,
                //货梯们宽度
                double caCargoDoorWide,
                //原地面材质
                String caOriginalGroundMaterial,
                //原顶面材质
                double caGroundElevation,
                //地面高差
                double caSpaceMaxHeight,
                //主梁下（主梁下高度）
                double camainBeamHeight,
                //次梁下（次梁下高度）
                double caSecondaryHeight,
                //淋喷最低点
                double caMinimumSprayHeight,
                //空调设备个数
                int caAirConditionerNum,
                //风口最低点
                double caTuyereMinimumHeight,
                //强电箱个数
                int caStrongBoxNum,
                //弱电箱个数
                int caWeakBoxNum,
                //上水电
                int caUpWaterSpot,
                //下水点
                int caDownWaterSpot,
                //下水管径
                double caDownWaterSpotSize,
                //幕墙架间距
                double caCurtainWallSpacing,
                //窗户类型
                String caWindowType,
                //窗台高
                double caWindowSillHight,
                //窗户高
                double caWindowWidth,
                //原顶面材质
                String caOriginalTopMaterial,
                //原墙面材质
                String caOriginalWallMaterial,
                //空间最低点高度
                double caSpaceMinHeight,
                //上下水路径
                String caWaterPath,
                //窗户宽
                double caWindowHight,
                //原地面保存
                int caOriginalGround,
                //租金/单价
                double caRental,
                //免租期
                int caRentFreeDate,
                //租期开始日期
                String caLeaseTermStart,
                //租期结束日期
                String caLeaseTermEnd,
                //客户姓名
                String ciProHead,
                //量房地址
                String ciDecorationAddress,
                //装修预算
                double caDecBudgetPrice
        );

        public abstract void getDaiMeasureData(
                String rwdID
        );

        public abstract void getDaiMeasureImageData(
                String rwdId,
                String enumType,
                String token
        );

    }
}
