package com.rxjy.rxcompound.des.entity;

import java.io.Serializable;

/**
 * Created by qindd on 2017/6/20.
 */
public class MeasureDetailInfo implements Serializable
{

    /**
     * StatusCode : 0
     * StatusMsg : Success
     * Body : {"ci_rwdid":"12-195281","WorksID":9076,"CustomerID":3312,"ca_OriginalTopMaterial":"水泥毛坯","ca_HousingType":1,"ca_ca_HousingSituation":"","ca_HouseOrientation":"东南","ca_OccupyPublicCorridor":1,"ca_isGroundSmooth":"是","ca_CargoDoorHight":111,"ca_CargoDoorWide":"`1.0","ca_OriginalGroundMaterial":"水泥找平","ca_GroundElevation":111,"ca_SpaceMaxHeight":111,"ca_SpaceMinHeight":111,"ca_mainBeamHeight":111,"ca_SecondaryHeight":111,"ca_AirConditionerNum":111,"ca_TuyereMinimumHeight":111,"ca_StrongBoxNum":111,"ca_WeakBoxNum":111,"ca_UpWaterSpot":111,"ca_DownWaterSpot":111,"ca_DownWaterSpotSize":11,"ca_MinimumSprayHeight":111,"ca_CurtainWallSpacing":11,"ca_WindowType":"玻璃幕墙","ca_windowsillHight":111,"ca_WindowHight":111,"ca_OriginalWallMaterial":"刮大白","ca_WaterPath":"板顶","ca_WindowWidth":111,"ca_OriginalGround":"1","ca_LeaseTermStart":"2017-04-01 00:00:00","ca_LeaseTermEnd":"2023-04-01 00:00:00","ca_Rental":3,"ca_RentFreeDate":1,"ci_proHead":"王经理","ci_DecorationAddress":"华东电气A3","ca_DecBudgetPrice":20}
     */

    private int StatusCode;
    private String StatusMsg;
    /**
     * ci_rwdid : 12-195281
     * WorksID : 9076
     * CustomerID : 3312
     * ca_OriginalTopMaterial : 水泥毛坯
     * ca_HousingType : 1
     * ca_ca_HousingSituation :
     * ca_HouseOrientation : 东南
     * ca_OccupyPublicCorridor : 1
     * ca_isGroundSmooth : 是
     * ca_CargoDoorHight : 111.0
     * ca_CargoDoorWide : `1.0
     * ca_OriginalGroundMaterial : 水泥找平
     * ca_GroundElevation : 111.0
     * ca_SpaceMaxHeight : 111.0
     * ca_SpaceMinHeight : 111.0
     * ca_mainBeamHeight : 111.0
     * ca_SecondaryHeight : 111.0
     * ca_AirConditionerNum : 111
     * ca_TuyereMinimumHeight : 111.0
     * ca_StrongBoxNum : 111
     * ca_WeakBoxNum : 111
     * ca_UpWaterSpot : 111
     * ca_DownWaterSpot : 111
     * ca_DownWaterSpotSize : 11.0
     * ca_MinimumSprayHeight : 111.0
     * ca_CurtainWallSpacing : 11.0
     * ca_WindowType : 玻璃幕墙
     * ca_windowsillHight : 111.0
     * ca_WindowHight : 111.0
     * ca_OriginalWallMaterial : 刮大白
     * ca_WaterPath : 板顶
     * ca_WindowWidth : 111.0
     * ca_OriginalGround : 1
     * ca_LeaseTermStart : 2017-04-01 00:00:00
     * ca_LeaseTermEnd : 2023-04-01 00:00:00
     * ca_Rental : 3
     * ca_RentFreeDate : 1
     * ci_proHead : 王经理
     * ci_DecorationAddress : 华东电气A3
     * ca_DecBudgetPrice : 20
     */

    private MeasureInfo Body;

    public int getStatusCode()
    {
        return StatusCode;
    }

    public void setStatusCode(int StatusCode)
    {
        this.StatusCode = StatusCode;
    }

    public String getStatusMsg()
    {
        return StatusMsg;
    }

    public void setStatusMsg(String StatusMsg)
    {
        this.StatusMsg = StatusMsg;
    }

    public MeasureInfo getBody()
    {
        return Body;
    }

    public void setBody(MeasureInfo Body)
    {
        this.Body = Body;
    }

    public static class MeasureInfo implements Serializable
    {
        private String ci_rwdid;
        private int WorksID;
        private int CustomerID;
        private String ca_OriginalTopMaterial;
        private int ca_HousingType;
        private String ca_ca_HousingSituation;
        private String ca_HouseOrientation;
        private int ca_OccupyPublicCorridor;
        private String ca_isGroundSmooth;
        private double ca_CargoDoorHight;
        private String ca_CargoDoorWide;
        private String ca_OriginalGroundMaterial;
        private double ca_GroundElevation;
        private double ca_SpaceMaxHeight;
        private double ca_SpaceMinHeight;
        private double ca_mainBeamHeight;
        private double ca_SecondaryHeight;
        private int ca_AirConditionerNum;
        private double ca_TuyereMinimumHeight;
        private int ca_StrongBoxNum;
        private int ca_WeakBoxNum;
        private int ca_UpWaterSpot;
        private int ca_DownWaterSpot;
        private double ca_DownWaterSpotSize;
        private double ca_MinimumSprayHeight;
        private double ca_CurtainWallSpacing;
        private String ca_WindowType;
        private double ca_windowsillHight;
        private double ca_WindowHight;
        private String ca_OriginalWallMaterial;
        private String ca_WaterPath;
        private double ca_WindowWidth;
        private int ca_OriginalGround;
        private String ca_LeaseTermStart;
        private String ca_LeaseTermEnd;
        private double ca_Rental;
        private int ca_RentFreeDate;
        private String ci_proHead;
        private String ci_DecorationAddress;
        private double ca_DecBudgetPrice;

        public String getCi_rwdid()
        {
            return ci_rwdid;
        }

        public void setCi_rwdid(String ci_rwdid)
        {
            this.ci_rwdid = ci_rwdid;
        }

        public int getWorksID()
        {
            return WorksID;
        }

        public void setWorksID(int WorksID)
        {
            this.WorksID = WorksID;
        }

        public int getCustomerID()
        {
            return CustomerID;
        }

        public void setCustomerID(int CustomerID)
        {
            this.CustomerID = CustomerID;
        }

        public String getCa_OriginalTopMaterial()
        {
            return ca_OriginalTopMaterial;
        }

        public void setCa_OriginalTopMaterial(String ca_OriginalTopMaterial)
        {
            this.ca_OriginalTopMaterial = ca_OriginalTopMaterial;
        }

        public int getCa_HousingType()
        {
            return ca_HousingType;
        }

        public void setCa_HousingType(int ca_HousingType)
        {
            this.ca_HousingType = ca_HousingType;
        }

        public String getCa_ca_HousingSituation()
        {
            return ca_ca_HousingSituation;
        }

        public void setCa_ca_HousingSituation(String ca_ca_HousingSituation)
        {
            this.ca_ca_HousingSituation = ca_ca_HousingSituation;
        }

        public String getCa_HouseOrientation()
        {
            return ca_HouseOrientation;
        }

        public void setCa_HouseOrientation(String ca_HouseOrientation)
        {
            this.ca_HouseOrientation = ca_HouseOrientation;
        }

        public int getCa_OccupyPublicCorridor()
        {
            return ca_OccupyPublicCorridor;
        }

        public void setCa_OccupyPublicCorridor(int ca_OccupyPublicCorridor)
        {
            this.ca_OccupyPublicCorridor = ca_OccupyPublicCorridor;
        }

        public String getCa_isGroundSmooth()
        {
            return ca_isGroundSmooth;
        }

        public void setCa_isGroundSmooth(String ca_isGroundSmooth)
        {
            this.ca_isGroundSmooth = ca_isGroundSmooth;
        }

        public double getCa_CargoDoorHight()
        {
            return ca_CargoDoorHight;
        }

        public void setCa_CargoDoorHight(double ca_CargoDoorHight)
        {
            this.ca_CargoDoorHight = ca_CargoDoorHight;
        }

        public String getCa_CargoDoorWide()
        {
            return ca_CargoDoorWide;
        }

        public void setCa_CargoDoorWide(String ca_CargoDoorWide)
        {
            this.ca_CargoDoorWide = ca_CargoDoorWide;
        }

        public String getCa_OriginalGroundMaterial()
        {
            return ca_OriginalGroundMaterial;
        }

        public void setCa_OriginalGroundMaterial(String ca_OriginalGroundMaterial)
        {
            this.ca_OriginalGroundMaterial = ca_OriginalGroundMaterial;
        }

        public double getCa_GroundElevation()
        {
            return ca_GroundElevation;
        }

        public void setCa_GroundElevation(double ca_GroundElevation)
        {
            this.ca_GroundElevation = ca_GroundElevation;
        }

        public double getCa_SpaceMaxHeight()
        {
            return ca_SpaceMaxHeight;
        }

        public void setCa_SpaceMaxHeight(double ca_SpaceMaxHeight)
        {
            this.ca_SpaceMaxHeight = ca_SpaceMaxHeight;
        }

        public double getCa_SpaceMinHeight()
        {
            return ca_SpaceMinHeight;
        }

        public void setCa_SpaceMinHeight(double ca_SpaceMinHeight)
        {
            this.ca_SpaceMinHeight = ca_SpaceMinHeight;
        }

        public double getCa_mainBeamHeight()
        {
            return ca_mainBeamHeight;
        }

        public void setCa_mainBeamHeight(double ca_mainBeamHeight)
        {
            this.ca_mainBeamHeight = ca_mainBeamHeight;
        }

        public double getCa_SecondaryHeight()
        {
            return ca_SecondaryHeight;
        }

        public void setCa_SecondaryHeight(double ca_SecondaryHeight)
        {
            this.ca_SecondaryHeight = ca_SecondaryHeight;
        }

        public int getCa_AirConditionerNum()
        {
            return ca_AirConditionerNum;
        }

        public void setCa_AirConditionerNum(int ca_AirConditionerNum)
        {
            this.ca_AirConditionerNum = ca_AirConditionerNum;
        }

        public double getCa_TuyereMinimumHeight()
        {
            return ca_TuyereMinimumHeight;
        }

        public void setCa_TuyereMinimumHeight(double ca_TuyereMinimumHeight)
        {
            this.ca_TuyereMinimumHeight = ca_TuyereMinimumHeight;
        }

        public int getCa_StrongBoxNum()
        {
            return ca_StrongBoxNum;
        }

        public void setCa_StrongBoxNum(int ca_StrongBoxNum)
        {
            this.ca_StrongBoxNum = ca_StrongBoxNum;
        }

        public int getCa_WeakBoxNum()
        {
            return ca_WeakBoxNum;
        }

        public void setCa_WeakBoxNum(int ca_WeakBoxNum)
        {
            this.ca_WeakBoxNum = ca_WeakBoxNum;
        }

        public int getCa_UpWaterSpot()
        {
            return ca_UpWaterSpot;
        }

        public void setCa_UpWaterSpot(int ca_UpWaterSpot)
        {
            this.ca_UpWaterSpot = ca_UpWaterSpot;
        }

        public int getCa_DownWaterSpot()
        {
            return ca_DownWaterSpot;
        }

        public void setCa_DownWaterSpot(int ca_DownWaterSpot)
        {
            this.ca_DownWaterSpot = ca_DownWaterSpot;
        }

        public double getCa_DownWaterSpotSize()
        {
            return ca_DownWaterSpotSize;
        }

        public void setCa_DownWaterSpotSize(double ca_DownWaterSpotSize)
        {
            this.ca_DownWaterSpotSize = ca_DownWaterSpotSize;
        }

        public double getCa_MinimumSprayHeight()
        {
            return ca_MinimumSprayHeight;
        }

        public void setCa_MinimumSprayHeight(double ca_MinimumSprayHeight)
        {
            this.ca_MinimumSprayHeight = ca_MinimumSprayHeight;
        }

        public double getCa_CurtainWallSpacing()
        {
            return ca_CurtainWallSpacing;
        }

        public void setCa_CurtainWallSpacing(double ca_CurtainWallSpacing)
        {
            this.ca_CurtainWallSpacing = ca_CurtainWallSpacing;
        }

        public String getCa_WindowType()
        {
            return ca_WindowType;
        }

        public void setCa_WindowType(String ca_WindowType)
        {
            this.ca_WindowType = ca_WindowType;
        }

        public double getCa_windowsillHight()
        {
            return ca_windowsillHight;
        }

        public void setCa_windowsillHight(double ca_windowsillHight)
        {
            this.ca_windowsillHight = ca_windowsillHight;
        }

        public double getCa_WindowHight()
        {
            return ca_WindowHight;
        }

        public void setCa_WindowHight(double ca_WindowHight)
        {
            this.ca_WindowHight = ca_WindowHight;
        }

        public String getCa_OriginalWallMaterial()
        {
            return ca_OriginalWallMaterial;
        }

        public void setCa_OriginalWallMaterial(String ca_OriginalWallMaterial)
        {
            this.ca_OriginalWallMaterial = ca_OriginalWallMaterial;
        }

        public String getCa_WaterPath()
        {
            return ca_WaterPath;
        }

        public void setCa_WaterPath(String ca_WaterPath)
        {
            this.ca_WaterPath = ca_WaterPath;
        }

        public double getCa_WindowWidth()
        {
            return ca_WindowWidth;
        }

        public void setCa_WindowWidth(double ca_WindowWidth)
        {
            this.ca_WindowWidth = ca_WindowWidth;
        }

        public int getCa_OriginalGround()
        {
            return ca_OriginalGround;
        }

        public void setCa_OriginalGround(int ca_OriginalGround)
        {
            this.ca_OriginalGround = ca_OriginalGround;
        }

        public String getCa_LeaseTermStart()
        {
            return ca_LeaseTermStart;
        }

        public void setCa_LeaseTermStart(String ca_LeaseTermStart)
        {
            this.ca_LeaseTermStart = ca_LeaseTermStart;
        }

        public String getCa_LeaseTermEnd()
        {
            return ca_LeaseTermEnd;
        }

        public void setCa_LeaseTermEnd(String ca_LeaseTermEnd)
        {
            this.ca_LeaseTermEnd = ca_LeaseTermEnd;
        }

        public double getCa_Rental()
        {
            return ca_Rental;
        }

        public void setCa_Rental(double ca_Rental)
        {
            this.ca_Rental = ca_Rental;
        }

        public int getCa_RentFreeDate()
        {
            return ca_RentFreeDate;
        }

        public void setCa_RentFreeDate(int ca_RentFreeDate)
        {
            this.ca_RentFreeDate = ca_RentFreeDate;
        }

        public String getCi_proHead()
        {
            return ci_proHead;
        }

        public void setCi_proHead(String ci_proHead)
        {
            this.ci_proHead = ci_proHead;
        }

        public String getCi_DecorationAddress()
        {
            return ci_DecorationAddress;
        }

        public void setCi_DecorationAddress(String ci_DecorationAddress)
        {
            this.ci_DecorationAddress = ci_DecorationAddress;
        }

        public double getCa_DecBudgetPrice()
        {
            return ca_DecBudgetPrice;
        }

        public void setCa_DecBudgetPrice(double ca_DecBudgetPrice)
        {
            this.ca_DecBudgetPrice = ca_DecBudgetPrice;
        }


    }
}
