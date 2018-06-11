package com.rxjy.rxcompound.des.entity;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by hjh on 2017/12/14.
 */

public class DesDaiMeasureABean implements Serializable{

    private int StatusCode;
    private String StatusMsg;
    private BodyBean Body;


    @Override
    public String toString() {
        return "DesDaiMeasureABean{" +
                "StatusCode=" + StatusCode +
                ", StatusMsg='" + StatusMsg + '\'' +
                ", Body=" + Body +
                '}';
    }

    public int getStatusCode() {
        return StatusCode;
    }

    public void setStatusCode(int statusCode) {
        StatusCode = statusCode;
    }

    public String getStatusMsg() {
        return StatusMsg;
    }

    public void setStatusMsg(String statusMsg) {
        StatusMsg = statusMsg;
    }


    public BodyBean getBody() {
        return Body;
    }

    public void setBody(BodyBean body) {
        Body = body;
    }

    public static class BodyBean implements Serializable{

        private String JDMoney;
        private String LFMondey;
        private int ValCount;


        private ImageArrBean ImagesArray;

        private String ci_ClientName;
        private String ci_Type;
        private String ca_SWIndustryTypeID;
        private String ca_HangYeLeIXing;
        private String ci_OfficeAddress;

        private String ca_LeaseTermStart;
        private String ca_LeaseTermEnd;
        private String ca_EnterpriseNature;
        private String ca_EnterprisesScale;
        private String ca_EstablishmentTime;

        private String ca_ForeignEnterprises;
        private String ca_BusinessScope;
        private String ca_CorporateCulture;
        private String ci_proHead;
        private String ca_proHeadIdentity;

        private String ci_proSex;
        private String ci_proAge;
        private String ca_NoteFocus;
        private String ca_ContractPerson;
        private String ca_proHeadCharacter;

        private String ca_SpaceRequirement;
        private String ca_proAttribute;
        private String ca_DecBudgetPrice;
        private String ca_ProjectTime;
        private String ca_InviteTenders;

        private String ca_DecorationDate;
        private String ci_DecorationAddress;
        private String ca_IntentionalStyle;
        private String ca_FengShuiRequirements;
        private String ca_SoftFurniture;

        private String ca_IntelligentWeakCurrent;
        private String ca_proLike;
        private String ca_zaRemarks;
        private String ca_HouseOrientation;
        private String ca_OccupyPublicCorridor;

        private String ca_CargoDoorWide;
        private String ca_CargoDoorHight;
        private String ca_OriginalGroundMaterial;
        private String ca_isGroundSmooth;
        private String ca_GroundElevation;

        private String ca_OriginalTopMaterial;
        private String ca_OriginalWallMaterial;
        private String ca_mainBeamHeight;
        private String ca_SecondaryHeight;
        private String ca_SpaceMinHeight;

        private String ca_SpaceMaxHeight;
        private String ca_StrongBoxNum;
        private String ca_WeakBoxNum;
        private String ca_UpWaterSpot;
        private String ca_DownWaterSpot;

        private String ca_DownWaterSpotSize;
        private String ca_MinimumSprayHeight;
        private String ca_AirConditionerNum;
        private String ca_TuyereMinimumHeight;
        private String ca_WindowType;

        private String ca_windowsillHight;
        private String ca_WindowHight;
        private String ca_WindowWidth;
        private String ca_WaterPath;
        private String ca_CurtainWallSpacing;

        private String ca_OriginalGround;
        private String ca_ReqConTime;
        private String ca_ProductProtection;
        private String ca_PropertyInsurance;
        private String ca_DesignatedFireCompany;

        private String ca_DesignatedAirCompany;
        private String ca_DesignatedSinotrans;
        private String ca_Blueprint;
        private String ca_ProtectiveMaterial;
        private String ca_SpecialRequirement;

        private String ca_Elevator;
        private String ca_LeadName;
        private String ca_TwoManagerTel;
        private String ca_Maintenance;
        private String ca_Aptitude;

        private String ca_DrawAudit;
        private String ca_HousingType;
        private String ca_AvailabilityStatus;
        private String ci_Area;//使用面积
        private String ca_TransactionType;

        private String ca_RentFreeDate;
        private String ca_LaunchTime;
        private String ca_MeasureDate;
        private String ca_RealEstate;
        private String ca_RealEstatePeriod;

        private String ca_DevelopmentFloor;
        private String ca_HouseNumber;
        private String ci_advancePayment;//垫资
        private String ci_BuildingArea;//建筑面积

        @Override
        public String toString() {
            return "BodyBean{" +
                    "JDMoney='" + JDMoney + '\'' +
                    ", LFMondey='" + LFMondey + '\'' +
                    ", ValCount=" + ValCount +
                    ", ImagesArray=" + ImagesArray +
                    ", ci_ClientName='" + ci_ClientName + '\'' +
                    ", ci_Type='" + ci_Type + '\'' +
                    ", ca_SWIndustryTypeID='" + ca_SWIndustryTypeID + '\'' +
                    ", ca_HangYeLeIXing='" + ca_HangYeLeIXing + '\'' +
                    ", ci_OfficeAddress='" + ci_OfficeAddress + '\'' +
                    ", ca_LeaseTermStart='" + ca_LeaseTermStart + '\'' +
                    ", ca_LeaseTermEnd='" + ca_LeaseTermEnd + '\'' +
                    ", ca_EnterpriseNature='" + ca_EnterpriseNature + '\'' +
                    ", ca_EnterprisesScale='" + ca_EnterprisesScale + '\'' +
                    ", ca_EstablishmentTime='" + ca_EstablishmentTime + '\'' +
                    ", ca_ForeignEnterprises='" + ca_ForeignEnterprises + '\'' +
                    ", ca_BusinessScope='" + ca_BusinessScope + '\'' +
                    ", ca_CorporateCulture='" + ca_CorporateCulture + '\'' +
                    ", ci_proHead='" + ci_proHead + '\'' +
                    ", ca_proHeadIdentity='" + ca_proHeadIdentity + '\'' +
                    ", ci_proSex='" + ci_proSex + '\'' +
                    ", ci_proAge='" + ci_proAge + '\'' +
                    ", ca_NoteFocus='" + ca_NoteFocus + '\'' +
                    ", ca_ContractPerson='" + ca_ContractPerson + '\'' +
                    ", ca_proHeadCharacter='" + ca_proHeadCharacter + '\'' +
                    ", ca_SpaceRequirement='" + ca_SpaceRequirement + '\'' +
                    ", ca_proAttribute='" + ca_proAttribute + '\'' +
                    ", ca_DecBudgetPrice='" + ca_DecBudgetPrice + '\'' +
                    ", ca_ProjectTime='" + ca_ProjectTime + '\'' +
                    ", ca_InviteTenders='" + ca_InviteTenders + '\'' +
                    ", ca_DecorationDate='" + ca_DecorationDate + '\'' +
                    ", ci_DecorationAddress='" + ci_DecorationAddress + '\'' +
                    ", ca_IntentionalStyle='" + ca_IntentionalStyle + '\'' +
                    ", ca_FengShuiRequirements='" + ca_FengShuiRequirements + '\'' +
                    ", ca_SoftFurniture='" + ca_SoftFurniture + '\'' +
                    ", ca_IntelligentWeakCurrent='" + ca_IntelligentWeakCurrent + '\'' +
                    ", ca_proLike='" + ca_proLike + '\'' +
                    ", ca_zaRemarks='" + ca_zaRemarks + '\'' +
                    ", ca_HouseOrientation='" + ca_HouseOrientation + '\'' +
                    ", ca_OccupyPublicCorridor='" + ca_OccupyPublicCorridor + '\'' +
                    ", ca_CargoDoorWide='" + ca_CargoDoorWide + '\'' +
                    ", ca_CargoDoorHight='" + ca_CargoDoorHight + '\'' +
                    ", ca_OriginalGroundMaterial='" + ca_OriginalGroundMaterial + '\'' +
                    ", ca_isGroundSmooth='" + ca_isGroundSmooth + '\'' +
                    ", ca_GroundElevation='" + ca_GroundElevation + '\'' +
                    ", ca_OriginalTopMaterial='" + ca_OriginalTopMaterial + '\'' +
                    ", ca_OriginalWallMaterial='" + ca_OriginalWallMaterial + '\'' +
                    ", ca_mainBeamHeight='" + ca_mainBeamHeight + '\'' +
                    ", ca_SecondaryHeight='" + ca_SecondaryHeight + '\'' +
                    ", ca_SpaceMinHeight='" + ca_SpaceMinHeight + '\'' +
                    ", ca_SpaceMaxHeight='" + ca_SpaceMaxHeight + '\'' +
                    ", ca_StrongBoxNum='" + ca_StrongBoxNum + '\'' +
                    ", ca_WeakBoxNum='" + ca_WeakBoxNum + '\'' +
                    ", ca_UpWaterSpot='" + ca_UpWaterSpot + '\'' +
                    ", ca_DownWaterSpot='" + ca_DownWaterSpot + '\'' +
                    ", ca_DownWaterSpotSize='" + ca_DownWaterSpotSize + '\'' +
                    ", ca_MinimumSprayHeight='" + ca_MinimumSprayHeight + '\'' +
                    ", ca_AirConditionerNum='" + ca_AirConditionerNum + '\'' +
                    ", ca_TuyereMinimumHeight='" + ca_TuyereMinimumHeight + '\'' +
                    ", ca_WindowType='" + ca_WindowType + '\'' +
                    ", ca_windowsillHight='" + ca_windowsillHight + '\'' +
                    ", ca_WindowHight='" + ca_WindowHight + '\'' +
                    ", ca_WindowWidth='" + ca_WindowWidth + '\'' +
                    ", ca_WaterPath='" + ca_WaterPath + '\'' +
                    ", ca_CurtainWallSpacing='" + ca_CurtainWallSpacing + '\'' +
                    ", ca_OriginalGround='" + ca_OriginalGround + '\'' +
                    ", ca_ReqConTime='" + ca_ReqConTime + '\'' +
                    ", ca_ProductProtection='" + ca_ProductProtection + '\'' +
                    ", ca_PropertyInsurance='" + ca_PropertyInsurance + '\'' +
                    ", ca_DesignatedFireCompany='" + ca_DesignatedFireCompany + '\'' +
                    ", ca_DesignatedAirCompany='" + ca_DesignatedAirCompany + '\'' +
                    ", ca_DesignatedSinotrans='" + ca_DesignatedSinotrans + '\'' +
                    ", ca_Blueprint='" + ca_Blueprint + '\'' +
                    ", ca_ProtectiveMaterial='" + ca_ProtectiveMaterial + '\'' +
                    ", ca_SpecialRequirement='" + ca_SpecialRequirement + '\'' +
                    ", ca_Elevator='" + ca_Elevator + '\'' +
                    ", ca_LeadName='" + ca_LeadName + '\'' +
                    ", ca_TwoManagerTel='" + ca_TwoManagerTel + '\'' +
                    ", ca_Maintenance='" + ca_Maintenance + '\'' +
                    ", ca_Aptitude='" + ca_Aptitude + '\'' +
                    ", ca_DrawAudit='" + ca_DrawAudit + '\'' +
                    ", ca_HousingType='" + ca_HousingType + '\'' +
                    ", ca_AvailabilityStatus='" + ca_AvailabilityStatus + '\'' +
                    ", ci_Area='" + ci_Area + '\'' +
                    ", ca_TransactionType='" + ca_TransactionType + '\'' +
                    ", ca_RentFreeDate='" + ca_RentFreeDate + '\'' +
                    ", ca_LaunchTime='" + ca_LaunchTime + '\'' +
                    ", ca_MeasureDate='" + ca_MeasureDate + '\'' +
                    ", ca_RealEstate='" + ca_RealEstate + '\'' +
                    ", ca_RealEstatePeriod='" + ca_RealEstatePeriod + '\'' +
                    ", ca_DevelopmentFloor='" + ca_DevelopmentFloor + '\'' +
                    ", ca_HouseNumber='" + ca_HouseNumber + '\'' +
                    ", ci_advancePayment='" + ci_advancePayment + '\'' +
                    ", ci_BuildingArea='" + ci_BuildingArea + '\'' +
                    '}';
        }

        public String getCi_advancePayment() {
            return ci_advancePayment;
        }

        public void setCi_advancePayment(String ci_advancePayment) {
            this.ci_advancePayment = ci_advancePayment;
        }

        public String getCi_BuildingArea() {
            return ci_BuildingArea;
        }

        public void setCi_BuildingArea(String ci_BuildingArea) {
            this.ci_BuildingArea = ci_BuildingArea;
        }

        public int getValCount() {
            return ValCount;
        }

        public void setValCount(int valCount) {
            ValCount = valCount;
        }

        public String getJDMoney() {
            return JDMoney;
        }

        public void setJDMoney(String JDMoney) {
            this.JDMoney = JDMoney;
        }

        public String getLFMondey() {
            return LFMondey;
        }

        public void setLFMondey(String LFMondey) {
            this.LFMondey = LFMondey;
        }

        public String getCi_ClientName() {
            return ci_ClientName;
        }

        public void setCi_ClientName(String ci_ClientName) {
            this.ci_ClientName = ci_ClientName;
        }

        public String getCi_Type() {
            return ci_Type;
        }

        public void setCi_Type(String ci_Type) {
            this.ci_Type = ci_Type;
        }

        public String getCa_SWIndustryTypeID() {
            return ca_SWIndustryTypeID;
        }

        public void setCa_SWIndustryTypeID(String ca_SWIndustryTypeID) {
            this.ca_SWIndustryTypeID = ca_SWIndustryTypeID;
        }

        public String getCa_HangYeLeIXing() {
            return ca_HangYeLeIXing;
        }

        public void setCa_HangYeLeIXing(String ca_HangYeLeIXing) {
            this.ca_HangYeLeIXing = ca_HangYeLeIXing;
        }

        public String getCi_OfficeAddress() {
            return ci_OfficeAddress;
        }

        public void setCi_OfficeAddress(String ci_OfficeAddress) {
            this.ci_OfficeAddress = ci_OfficeAddress;
        }

        public String getCa_LeaseTermStart() {
            return ca_LeaseTermStart;
        }

        public void setCa_LeaseTermStart(String ca_LeaseTermStart) {
            this.ca_LeaseTermStart = ca_LeaseTermStart;
        }

        public String getCa_LeaseTermEnd() {
            return ca_LeaseTermEnd;
        }

        public void setCa_LeaseTermEnd(String ca_LeaseTermEnd) {
            this.ca_LeaseTermEnd = ca_LeaseTermEnd;
        }

        public String getCa_EnterpriseNature() {
            return ca_EnterpriseNature;
        }

        public void setCa_EnterpriseNature(String ca_EnterpriseNature) {
            this.ca_EnterpriseNature = ca_EnterpriseNature;
        }

        public String getCa_EnterprisesScale() {
            return ca_EnterprisesScale;
        }

        public void setCa_EnterprisesScale(String ca_EnterprisesScale) {
            this.ca_EnterprisesScale = ca_EnterprisesScale;
        }

        public String getCa_EstablishmentTime() {
            return ca_EstablishmentTime;
        }

        public void setCa_EstablishmentTime(String ca_EstablishmentTime) {
            this.ca_EstablishmentTime = ca_EstablishmentTime;
        }

        public String getCa_ForeignEnterprises() {
            return ca_ForeignEnterprises;
        }

        public void setCa_ForeignEnterprises(String ca_ForeignEnterprises) {
            this.ca_ForeignEnterprises = ca_ForeignEnterprises;
        }

        public String getCa_BusinessScope() {
            return ca_BusinessScope;
        }

        public void setCa_BusinessScope(String ca_BusinessScope) {
            this.ca_BusinessScope = ca_BusinessScope;
        }

        public String getCa_CorporateCulture() {
            return ca_CorporateCulture;
        }

        public void setCa_CorporateCulture(String ca_CorporateCulture) {
            this.ca_CorporateCulture = ca_CorporateCulture;
        }

        public String getCi_proHead() {
            return ci_proHead;
        }

        public void setCi_proHead(String ci_proHead) {
            this.ci_proHead = ci_proHead;
        }

        public String getCa_proHeadIdentity() {
            return ca_proHeadIdentity;
        }

        public void setCa_proHeadIdentity(String ca_proHeadIdentity) {
            this.ca_proHeadIdentity = ca_proHeadIdentity;
        }

        public String getCi_proSex() {
            return ci_proSex;
        }

        public void setCi_proSex(String ci_proSex) {
            this.ci_proSex = ci_proSex;
        }

        public String getCi_proAge() {
            return ci_proAge;
        }

        public void setCi_proAge(String ci_proAge) {
            this.ci_proAge = ci_proAge;
        }

        public String getCa_NoteFocus() {
            return ca_NoteFocus;
        }

        public void setCa_NoteFocus(String ca_NoteFocus) {
            this.ca_NoteFocus = ca_NoteFocus;
        }

        public String getCa_ContractPerson() {
            return ca_ContractPerson;
        }

        public void setCa_ContractPerson(String ca_ContractPerson) {
            this.ca_ContractPerson = ca_ContractPerson;
        }

        public String getCa_proHeadCharacter() {
            return ca_proHeadCharacter;
        }

        public void setCa_proHeadCharacter(String ca_proHeadCharacter) {
            this.ca_proHeadCharacter = ca_proHeadCharacter;
        }

        public String getCa_SpaceRequirement() {
            return ca_SpaceRequirement;
        }

        public void setCa_SpaceRequirement(String ca_SpaceRequirement) {
            this.ca_SpaceRequirement = ca_SpaceRequirement;
        }

        public String getCa_proAttribute() {
            return ca_proAttribute;
        }

        public void setCa_proAttribute(String ca_proAttribute) {
            this.ca_proAttribute = ca_proAttribute;
        }

        public String getCa_DecBudgetPrice() {
            return ca_DecBudgetPrice;
        }

        public void setCa_DecBudgetPrice(String ca_DecBudgetPrice) {
            this.ca_DecBudgetPrice = ca_DecBudgetPrice;
        }

        public String getCa_ProjectTime() {
            return ca_ProjectTime;
        }

        public void setCa_ProjectTime(String ca_ProjectTime) {
            this.ca_ProjectTime = ca_ProjectTime;
        }

        public String getCa_InviteTenders() {
            return ca_InviteTenders;
        }

        public void setCa_InviteTenders(String ca_InviteTenders) {
            this.ca_InviteTenders = ca_InviteTenders;
        }

        public String getCa_DecorationDate() {
            return ca_DecorationDate;
        }

        public void setCa_DecorationDate(String ca_DecorationDate) {
            this.ca_DecorationDate = ca_DecorationDate;
        }

        public String getCi_DecorationAddress() {
            return ci_DecorationAddress;
        }

        public void setCi_DecorationAddress(String ci_DecorationAddress) {
            this.ci_DecorationAddress = ci_DecorationAddress;
        }

        public String getCa_IntentionalStyle() {
            return ca_IntentionalStyle;
        }

        public void setCa_IntentionalStyle(String ca_IntentionalStyle) {
            this.ca_IntentionalStyle = ca_IntentionalStyle;
        }

        public String getCa_FengShuiRequirements() {
            return ca_FengShuiRequirements;
        }

        public void setCa_FengShuiRequirements(String ca_FengShuiRequirements) {
            this.ca_FengShuiRequirements = ca_FengShuiRequirements;
        }

        public String getCa_SoftFurniture() {
            return ca_SoftFurniture;
        }

        public void setCa_SoftFurniture(String ca_SoftFurniture) {
            this.ca_SoftFurniture = ca_SoftFurniture;
        }

        public String getCa_IntelligentWeakCurrent() {
            return ca_IntelligentWeakCurrent;
        }

        public void setCa_IntelligentWeakCurrent(String ca_IntelligentWeakCurrent) {
            this.ca_IntelligentWeakCurrent = ca_IntelligentWeakCurrent;
        }

        public String getCa_proLike() {
            return ca_proLike;
        }

        public void setCa_proLike(String ca_proLike) {
            this.ca_proLike = ca_proLike;
        }

        public String getCa_zaRemarks() {
            return ca_zaRemarks;
        }

        public void setCa_zaRemarks(String ca_zaRemarks) {
            this.ca_zaRemarks = ca_zaRemarks;
        }

        public String getCa_HouseOrientation() {
            return ca_HouseOrientation;
        }

        public void setCa_HouseOrientation(String ca_HouseOrientation) {
            this.ca_HouseOrientation = ca_HouseOrientation;
        }

        public String getCa_OccupyPublicCorridor() {
            return ca_OccupyPublicCorridor;
        }

        public void setCa_OccupyPublicCorridor(String ca_OccupyPublicCorridor) {
            this.ca_OccupyPublicCorridor = ca_OccupyPublicCorridor;
        }

        public String getCa_CargoDoorWide() {
            return ca_CargoDoorWide;
        }

        public void setCa_CargoDoorWide(String ca_CargoDoorWide) {
            this.ca_CargoDoorWide = ca_CargoDoorWide;
        }

        public String getCa_CargoDoorHight() {
            return ca_CargoDoorHight;
        }

        public void setCa_CargoDoorHight(String ca_CargoDoorHight) {
            this.ca_CargoDoorHight = ca_CargoDoorHight;
        }

        public String getCa_OriginalGroundMaterial() {
            return ca_OriginalGroundMaterial;
        }

        public void setCa_OriginalGroundMaterial(String ca_OriginalGroundMaterial) {
            this.ca_OriginalGroundMaterial = ca_OriginalGroundMaterial;
        }

        public String getCa_isGroundSmooth() {
            return ca_isGroundSmooth;
        }

        public void setCa_isGroundSmooth(String ca_isGroundSmooth) {
            this.ca_isGroundSmooth = ca_isGroundSmooth;
        }

        public String getCa_GroundElevation() {
            return ca_GroundElevation;
        }

        public void setCa_GroundElevation(String ca_GroundElevation) {
            this.ca_GroundElevation = ca_GroundElevation;
        }

        public String getCa_OriginalTopMaterial() {
            return ca_OriginalTopMaterial;
        }

        public void setCa_OriginalTopMaterial(String ca_OriginalTopMaterial) {
            this.ca_OriginalTopMaterial = ca_OriginalTopMaterial;
        }

        public String getCa_OriginalWallMaterial() {
            return ca_OriginalWallMaterial;
        }

        public void setCa_OriginalWallMaterial(String ca_OriginalWallMaterial) {
            this.ca_OriginalWallMaterial = ca_OriginalWallMaterial;
        }

        public String getCa_mainBeamHeight() {
            return ca_mainBeamHeight;
        }

        public void setCa_mainBeamHeight(String ca_mainBeamHeight) {
            this.ca_mainBeamHeight = ca_mainBeamHeight;
        }

        public String getCa_SecondaryHeight() {
            return ca_SecondaryHeight;
        }

        public void setCa_SecondaryHeight(String ca_SecondaryHeight) {
            this.ca_SecondaryHeight = ca_SecondaryHeight;
        }

        public String getCa_SpaceMinHeight() {
            return ca_SpaceMinHeight;
        }

        public void setCa_SpaceMinHeight(String ca_SpaceMinHeight) {
            this.ca_SpaceMinHeight = ca_SpaceMinHeight;
        }

        public String getCa_SpaceMaxHeight() {
            return ca_SpaceMaxHeight;
        }

        public void setCa_SpaceMaxHeight(String ca_SpaceMaxHeight) {
            this.ca_SpaceMaxHeight = ca_SpaceMaxHeight;
        }

        public String getCa_StrongBoxNum() {
            return ca_StrongBoxNum;
        }

        public void setCa_StrongBoxNum(String ca_StrongBoxNum) {
            this.ca_StrongBoxNum = ca_StrongBoxNum;
        }

        public String getCa_WeakBoxNum() {
            return ca_WeakBoxNum;
        }

        public void setCa_WeakBoxNum(String ca_WeakBoxNum) {
            this.ca_WeakBoxNum = ca_WeakBoxNum;
        }

        public String getCa_UpWaterSpot() {
            return ca_UpWaterSpot;
        }

        public void setCa_UpWaterSpot(String ca_UpWaterSpot) {
            this.ca_UpWaterSpot = ca_UpWaterSpot;
        }

        public String getCa_DownWaterSpot() {
            return ca_DownWaterSpot;
        }

        public void setCa_DownWaterSpot(String ca_DownWaterSpot) {
            this.ca_DownWaterSpot = ca_DownWaterSpot;
        }

        public String getCa_DownWaterSpotSize() {
            return ca_DownWaterSpotSize;
        }

        public void setCa_DownWaterSpotSize(String ca_DownWaterSpotSize) {
            this.ca_DownWaterSpotSize = ca_DownWaterSpotSize;
        }

        public String getCa_MinimumSprayHeight() {
            return ca_MinimumSprayHeight;
        }

        public void setCa_MinimumSprayHeight(String ca_MinimumSprayHeight) {
            this.ca_MinimumSprayHeight = ca_MinimumSprayHeight;
        }

        public String getCa_AirConditionerNum() {
            return ca_AirConditionerNum;
        }

        public void setCa_AirConditionerNum(String ca_AirConditionerNum) {
            this.ca_AirConditionerNum = ca_AirConditionerNum;
        }

        public String getCa_TuyereMinimumHeight() {
            return ca_TuyereMinimumHeight;
        }

        public void setCa_TuyereMinimumHeight(String ca_TuyereMinimumHeight) {
            this.ca_TuyereMinimumHeight = ca_TuyereMinimumHeight;
        }

        public String getCa_WindowType() {
            return ca_WindowType;
        }

        public void setCa_WindowType(String ca_WindowType) {
            this.ca_WindowType = ca_WindowType;
        }

        public String getCa_windowsillHight() {
            return ca_windowsillHight;
        }

        public void setCa_windowsillHight(String ca_windowsillHight) {
            this.ca_windowsillHight = ca_windowsillHight;
        }

        public String getCa_WindowHight() {
            return ca_WindowHight;
        }

        public void setCa_WindowHight(String ca_WindowHight) {
            this.ca_WindowHight = ca_WindowHight;
        }

        public String getCa_WindowWidth() {
            return ca_WindowWidth;
        }

        public void setCa_WindowWidth(String ca_WindowWidth) {
            this.ca_WindowWidth = ca_WindowWidth;
        }

        public String getCa_WaterPath() {
            return ca_WaterPath;
        }

        public void setCa_WaterPath(String ca_WaterPath) {
            this.ca_WaterPath = ca_WaterPath;
        }

        public String getCa_CurtainWallSpacing() {
            return ca_CurtainWallSpacing;
        }

        public void setCa_CurtainWallSpacing(String ca_CurtainWallSpacing) {
            this.ca_CurtainWallSpacing = ca_CurtainWallSpacing;
        }

        public String getCa_OriginalGround() {
            return ca_OriginalGround;
        }

        public void setCa_OriginalGround(String ca_OriginalGround) {
            this.ca_OriginalGround = ca_OriginalGround;
        }

        public String getCa_ReqConTime() {
            return ca_ReqConTime;
        }

        public void setCa_ReqConTime(String ca_ReqConTime) {
            this.ca_ReqConTime = ca_ReqConTime;
        }

        public String getCa_ProductProtection() {
            return ca_ProductProtection;
        }

        public void setCa_ProductProtection(String ca_ProductProtection) {
            this.ca_ProductProtection = ca_ProductProtection;
        }

        public String getCa_PropertyInsurance() {
            return ca_PropertyInsurance;
        }

        public void setCa_PropertyInsurance(String ca_PropertyInsurance) {
            this.ca_PropertyInsurance = ca_PropertyInsurance;
        }

        public String getCa_DesignatedFireCompany() {
            return ca_DesignatedFireCompany;
        }

        public void setCa_DesignatedFireCompany(String ca_DesignatedFireCompany) {
            this.ca_DesignatedFireCompany = ca_DesignatedFireCompany;
        }

        public String getCa_DesignatedAirCompany() {
            return ca_DesignatedAirCompany;
        }

        public void setCa_DesignatedAirCompany(String ca_DesignatedAirCompany) {
            this.ca_DesignatedAirCompany = ca_DesignatedAirCompany;
        }

        public String getCa_DesignatedSinotrans() {
            return ca_DesignatedSinotrans;
        }

        public void setCa_DesignatedSinotrans(String ca_DesignatedSinotrans) {
            this.ca_DesignatedSinotrans = ca_DesignatedSinotrans;
        }

        public String getCa_Blueprint() {
            return ca_Blueprint;
        }

        public void setCa_Blueprint(String ca_Blueprint) {
            this.ca_Blueprint = ca_Blueprint;
        }

        public String getCa_ProtectiveMaterial() {
            return ca_ProtectiveMaterial;
        }

        public void setCa_ProtectiveMaterial(String ca_ProtectiveMaterial) {
            this.ca_ProtectiveMaterial = ca_ProtectiveMaterial;
        }

        public String getCa_SpecialRequirement() {
            return ca_SpecialRequirement;
        }

        public void setCa_SpecialRequirement(String ca_SpecialRequirement) {
            this.ca_SpecialRequirement = ca_SpecialRequirement;
        }

        public String getCa_Elevator() {
            return ca_Elevator;
        }

        public void setCa_Elevator(String ca_Elevator) {
            this.ca_Elevator = ca_Elevator;
        }

        public String getCa_LeadName() {
            return ca_LeadName;
        }

        public void setCa_LeadName(String ca_LeadName) {
            this.ca_LeadName = ca_LeadName;
        }

        public String getCa_TwoManagerTel() {
            return ca_TwoManagerTel;
        }

        public void setCa_TwoManagerTel(String ca_TwoManagerTel) {
            this.ca_TwoManagerTel = ca_TwoManagerTel;
        }

        public String getCa_Maintenance() {
            return ca_Maintenance;
        }

        public void setCa_Maintenance(String ca_Maintenance) {
            this.ca_Maintenance = ca_Maintenance;
        }

        public String getCa_Aptitude() {
            return ca_Aptitude;
        }

        public void setCa_Aptitude(String ca_Aptitude) {
            this.ca_Aptitude = ca_Aptitude;
        }

        public String getCa_DrawAudit() {
            return ca_DrawAudit;
        }

        public void setCa_DrawAudit(String ca_DrawAudit) {
            this.ca_DrawAudit = ca_DrawAudit;
        }

        public String getCa_HousingType() {
            return ca_HousingType;
        }

        public void setCa_HousingType(String ca_HousingType) {
            this.ca_HousingType = ca_HousingType;
        }

        public String getCa_AvailabilityStatus() {
            return ca_AvailabilityStatus;
        }

        public void setCa_AvailabilityStatus(String ca_AvailabilityStatus) {
            this.ca_AvailabilityStatus = ca_AvailabilityStatus;
        }

        public String getCi_Area() {
            return ci_Area;
        }

        public void setCi_Area(String ci_Area) {
            this.ci_Area = ci_Area;
        }

        public String getCa_TransactionType() {
            return ca_TransactionType;
        }

        public void setCa_TransactionType(String ca_TransactionType) {
            this.ca_TransactionType = ca_TransactionType;
        }

        public String getCa_RentFreeDate() {
            return ca_RentFreeDate;
        }

        public void setCa_RentFreeDate(String ca_RentFreeDate) {
            this.ca_RentFreeDate = ca_RentFreeDate;
        }

        public String getCa_LaunchTime() {
            return ca_LaunchTime;
        }

        public void setCa_LaunchTime(String ca_LaunchTime) {
            this.ca_LaunchTime = ca_LaunchTime;
        }

        public String getCa_MeasureDate() {
            return ca_MeasureDate;
        }

        public void setCa_MeasureDate(String ca_MeasureDate) {
            this.ca_MeasureDate = ca_MeasureDate;
        }

        public String getCa_RealEstate() {
            return ca_RealEstate;
        }

        public void setCa_RealEstate(String ca_RealEstate) {
            this.ca_RealEstate = ca_RealEstate;
        }

        public String getCa_RealEstatePeriod() {
            return ca_RealEstatePeriod;
        }

        public void setCa_RealEstatePeriod(String ca_RealEstatePeriod) {
            this.ca_RealEstatePeriod = ca_RealEstatePeriod;
        }

        public String getCa_DevelopmentFloor() {
            return ca_DevelopmentFloor;
        }

        public void setCa_DevelopmentFloor(String ca_DevelopmentFloor) {
            this.ca_DevelopmentFloor = ca_DevelopmentFloor;
        }

        public String getCa_HouseNumber() {
            return ca_HouseNumber;
        }

        public void setCa_HouseNumber(String ca_HouseNumber) {
            this.ca_HouseNumber = ca_HouseNumber;
        }

        public ImageArrBean getImagesArray() {
            return ImagesArray;
        }

        public void setImagesArray(ImageArrBean imagesArray) {
            ImagesArray = imagesArray;
        }

        public static class ImageArrBean implements Serializable{
            private ArrayList<ImageBean> LFImages;
            private ArrayList<ImageBean> QYImages;

            @Override
            public String toString() {
                return "ImageArrBean{" +
                        "LFImages=" + LFImages +
                        ", QYImages=" + QYImages +
                        '}';
            }

            public ArrayList<ImageBean> getLFImages() {
                return LFImages;
            }

            public void setLFImages(ArrayList<ImageBean> LFImages) {
                this.LFImages = LFImages;
            }

            public ArrayList<ImageBean> getQYImages() {
                return QYImages;
            }

            public void setQYImages(ArrayList<ImageBean> QYImages) {
                this.QYImages = QYImages;
            }

            public static class ImageBean implements Serializable{
                private int CreatorID;
                private int WorksID;
                private int CatalogID;
                private String CatalogIDName;
                private String CatalogShowType;
                private int CatalogCount;
                private ArrayList<ChildBean> childList;

                @Override
                public String toString() {
                    return "ImageBean{" +
                            "CreatorID=" + CreatorID +
                            ", WorksID=" + WorksID +
                            ", CatalogID=" + CatalogID +
                            ", CatalogIDName='" + CatalogIDName + '\'' +
                            ", CatalogShowType='" + CatalogShowType + '\'' +
                            ", CatalogCount=" + CatalogCount +
                            ", childList=" + childList +
                            '}';
                }

                public int getCreatorID() {
                    return CreatorID;
                }

                public void setCreatorID(int creatorID) {
                    CreatorID = creatorID;
                }

                public int getWorksID() {
                    return WorksID;
                }

                public void setWorksID(int worksID) {
                    WorksID = worksID;
                }

                public int getCatalogID() {
                    return CatalogID;
                }

                public void setCatalogID(int catalogID) {
                    CatalogID = catalogID;
                }

                public String getCatalogIDName() {
                    return CatalogIDName;
                }

                public void setCatalogIDName(String catalogIDName) {
                    CatalogIDName = catalogIDName;
                }

                public String getCatalogShowType() {
                    return CatalogShowType;
                }

                public void setCatalogShowType(String catalogShowType) {
                    CatalogShowType = catalogShowType;
                }

                public int getCatalogCount() {
                    return CatalogCount;
                }

                public void setCatalogCount(int catalogCount) {
                    CatalogCount = catalogCount;
                }

                public ArrayList<ChildBean> getChildList() {
                    return childList;
                }

                public void setChildList(ArrayList<ChildBean> childList) {
                    this.childList = childList;
                }

                public class ChildBean{
                    private int DetailID;
                    private String ImageUrl;

                    @Override
                    public String toString() {
                        return "ChildBean{" +
                                "DetailID=" + DetailID +
                                ", ImageUrl='" + ImageUrl + '\'' +
                                '}';
                    }

                    public int getDetailID() {
                        return DetailID;
                    }

                    public void setDetailID(int detailID) {
                        DetailID = detailID;
                    }

                    public String getImageUrl() {
                        return ImageUrl;
                    }

                    public void setImageUrl(String imageUrl) {
                        ImageUrl = imageUrl;
                    }
                }

            }

        }


    }


}
