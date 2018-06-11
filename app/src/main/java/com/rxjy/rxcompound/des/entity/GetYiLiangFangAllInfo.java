package com.rxjy.rxcompound.des.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/8/18.
 */

public class GetYiLiangFangAllInfo {

    /**
     * StatusCode : 0
     * StatusMsg : Success
     * Body : {"KeHuXuQiu":{"ca_IntentionalStyle":"","ca_SoftFurniture":"","ca_IntelligentWeakCurrent":"","ca_FengShuiRequirements":""},"HuanJingZhaoPian":[{"CreatorID":0,"WorksID":0,"CatalogID":53,"CatalogIDName":"特殊结构","CatalogShowType":"","CatalogCount":0,"childList":[]},{"CreatorID":0,"WorksID":0,"CatalogID":109,"CatalogIDName":"大厦外立面","CatalogShowType":"","CatalogCount":0,"childList":[]},{"CreatorID":0,"WorksID":0,"CatalogID":116,"CatalogIDName":"量房手绘","CatalogShowType":"","CatalogCount":0,"childList":[]},{"CreatorID":0,"WorksID":0,"CatalogID":120,"CatalogIDName":"周边环境","CatalogShowType":"","CatalogCount":0,"childList":[]},{"CreatorID":0,"WorksID":0,"CatalogID":121,"CatalogIDName":"室内全景照片","CatalogShowType":"","CatalogCount":0,"childList":[]},{"CreatorID":0,"WorksID":0,"CatalogID":122,"CatalogIDName":"墙面","CatalogShowType":"","CatalogCount":0,"childList":[]},{"CreatorID":0,"WorksID":0,"CatalogID":123,"CatalogIDName":"顶面","CatalogShowType":"","CatalogCount":0,"childList":[]},{"CreatorID":0,"WorksID":0,"CatalogID":124,"CatalogIDName":"地面","CatalogShowType":"","CatalogCount":0,"childList":[]},{"CreatorID":0,"WorksID":0,"CatalogID":125,"CatalogIDName":"门面","CatalogShowType":"","CatalogCount":0,"childList":[]},{"CreatorID":0,"WorksID":0,"CatalogID":126,"CatalogIDName":"空调","CatalogShowType":"","CatalogCount":0,"childList":[]},{"CreatorID":0,"WorksID":0,"CatalogID":127,"CatalogIDName":"消防","CatalogShowType":"","CatalogCount":0,"childList":[]},{"CreatorID":0,"WorksID":0,"CatalogID":128,"CatalogIDName":"强电箱","CatalogShowType":"","CatalogCount":0,"childList":[]},{"CreatorID":0,"WorksID":0,"CatalogID":129,"CatalogIDName":"弱电箱","CatalogShowType":"","CatalogCount":0,"childList":[]},{"CreatorID":0,"WorksID":0,"CatalogID":130,"CatalogIDName":"上下水","CatalogShowType":"","CatalogCount":0,"childList":[]},{"CreatorID":0,"WorksID":0,"CatalogID":131,"CatalogIDName":"公司logo","CatalogShowType":"","CatalogCount":0,"childList":[]},{"CreatorID":0,"WorksID":0,"CatalogID":132,"CatalogIDName":"客户形象","CatalogShowType":"","CatalogCount":0,"childList":[]},{"CreatorID":0,"WorksID":0,"CatalogID":133,"CatalogIDName":"企业色彩","CatalogShowType":"","CatalogCount":0,"childList":[]},{"CreatorID":0,"WorksID":0,"CatalogID":134,"CatalogIDName":"企业环境","CatalogShowType":"","CatalogCount":0,"childList":[]}],"WenZiXiangQing":{"ci_rwdid":"","WorksID":0,"CustomerID":0,"ca_OriginalTopMaterial":"","ca_HousingType":"","ca_ca_HousingSituation":"","ca_HouseOrientation":"","ca_OccupyPublicCorridor":"","ca_isGroundSmooth":"","ca_CargoDoorHight":"","ca_CargoDoorWide":"","ca_OriginalGroundMaterial":"","ca_GroundElevation":"","ca_SpaceMaxHeight":"","ca_SpaceMinHeight":"","ca_mainBeamHeight":"","ca_SecondaryHeight":"","ca_AirConditionerNum":"","ca_TuyereMinimumHeight":"","ca_StrongBoxNum":"","ca_WeakBoxNum":"","ca_UpWaterSpot":"","ca_DownWaterSpot":"","ca_DownWaterSpotSize":"","ca_MinimumSprayHeight":"","ca_CurtainWallSpacing":"","ca_WindowType":"","ca_windowsillHight":"","ca_WindowHight":"","ca_OriginalWallMaterial":"","ca_WaterPath":"","ca_WindowWidth":"","ca_OriginalGround":"","ca_LeaseTermStart":"","ca_LeaseTermEnd":"","ca_Rental":"","ca_RentFreeDate":"","ci_proHead":"","ci_DecorationAddress":"","ca_DecBudgetPrice":""},"LiangFangWuYe":{"ca_ReqConTime":"","ca_ProductProtection":"","ca_PropertyInsurance":"","ca_DesignatedFireCompany":"","ca_DesignatedAirCompany":"","ca_DesignatedSinotrans":"","ca_Blueprint":"","ca_ProtectiveMaterial":""}}
     */

    private int StatusCode;
    private String StatusMsg;
    private BodyBean Body;

    public int getStatusCode() {
        return StatusCode;
    }

    public void setStatusCode(int StatusCode) {
        this.StatusCode = StatusCode;
    }

    public String getStatusMsg() {
        return StatusMsg;
    }

    public void setStatusMsg(String StatusMsg) {
        this.StatusMsg = StatusMsg;
    }

    public BodyBean getBody() {
        return Body;
    }

    public void setBody(BodyBean Body) {
        this.Body = Body;
    }

    public static class BodyBean {
        /**
         * KeHuXuQiu : {"ca_IntentionalStyle":"","ca_SoftFurniture":"","ca_IntelligentWeakCurrent":"","ca_FengShuiRequirements":""}
         * HuanJingZhaoPian : [{"CreatorID":0,"WorksID":0,"CatalogID":53,"CatalogIDName":"特殊结构","CatalogShowType":"","CatalogCount":0,"childList":[]},{"CreatorID":0,"WorksID":0,"CatalogID":109,"CatalogIDName":"大厦外立面","CatalogShowType":"","CatalogCount":0,"childList":[]},{"CreatorID":0,"WorksID":0,"CatalogID":116,"CatalogIDName":"量房手绘","CatalogShowType":"","CatalogCount":0,"childList":[]},{"CreatorID":0,"WorksID":0,"CatalogID":120,"CatalogIDName":"周边环境","CatalogShowType":"","CatalogCount":0,"childList":[]},{"CreatorID":0,"WorksID":0,"CatalogID":121,"CatalogIDName":"室内全景照片","CatalogShowType":"","CatalogCount":0,"childList":[]},{"CreatorID":0,"WorksID":0,"CatalogID":122,"CatalogIDName":"墙面","CatalogShowType":"","CatalogCount":0,"childList":[]},{"CreatorID":0,"WorksID":0,"CatalogID":123,"CatalogIDName":"顶面","CatalogShowType":"","CatalogCount":0,"childList":[]},{"CreatorID":0,"WorksID":0,"CatalogID":124,"CatalogIDName":"地面","CatalogShowType":"","CatalogCount":0,"childList":[]},{"CreatorID":0,"WorksID":0,"CatalogID":125,"CatalogIDName":"门面","CatalogShowType":"","CatalogCount":0,"childList":[]},{"CreatorID":0,"WorksID":0,"CatalogID":126,"CatalogIDName":"空调","CatalogShowType":"","CatalogCount":0,"childList":[]},{"CreatorID":0,"WorksID":0,"CatalogID":127,"CatalogIDName":"消防","CatalogShowType":"","CatalogCount":0,"childList":[]},{"CreatorID":0,"WorksID":0,"CatalogID":128,"CatalogIDName":"强电箱","CatalogShowType":"","CatalogCount":0,"childList":[]},{"CreatorID":0,"WorksID":0,"CatalogID":129,"CatalogIDName":"弱电箱","CatalogShowType":"","CatalogCount":0,"childList":[]},{"CreatorID":0,"WorksID":0,"CatalogID":130,"CatalogIDName":"上下水","CatalogShowType":"","CatalogCount":0,"childList":[]},{"CreatorID":0,"WorksID":0,"CatalogID":131,"CatalogIDName":"公司logo","CatalogShowType":"","CatalogCount":0,"childList":[]},{"CreatorID":0,"WorksID":0,"CatalogID":132,"CatalogIDName":"客户形象","CatalogShowType":"","CatalogCount":0,"childList":[]},{"CreatorID":0,"WorksID":0,"CatalogID":133,"CatalogIDName":"企业色彩","CatalogShowType":"","CatalogCount":0,"childList":[]},{"CreatorID":0,"WorksID":0,"CatalogID":134,"CatalogIDName":"企业环境","CatalogShowType":"","CatalogCount":0,"childList":[]}]
         * WenZiXiangQing : {"ci_rwdid":"","WorksID":0,"CustomerID":0,"ca_OriginalTopMaterial":"","ca_HousingType":"","ca_ca_HousingSituation":"","ca_HouseOrientation":"","ca_OccupyPublicCorridor":"","ca_isGroundSmooth":"","ca_CargoDoorHight":"","ca_CargoDoorWide":"","ca_OriginalGroundMaterial":"","ca_GroundElevation":"","ca_SpaceMaxHeight":"","ca_SpaceMinHeight":"","ca_mainBeamHeight":"","ca_SecondaryHeight":"","ca_AirConditionerNum":"","ca_TuyereMinimumHeight":"","ca_StrongBoxNum":"","ca_WeakBoxNum":"","ca_UpWaterSpot":"","ca_DownWaterSpot":"","ca_DownWaterSpotSize":"","ca_MinimumSprayHeight":"","ca_CurtainWallSpacing":"","ca_WindowType":"","ca_windowsillHight":"","ca_WindowHight":"","ca_OriginalWallMaterial":"","ca_WaterPath":"","ca_WindowWidth":"","ca_OriginalGround":"","ca_LeaseTermStart":"","ca_LeaseTermEnd":"","ca_Rental":"","ca_RentFreeDate":"","ci_proHead":"","ci_DecorationAddress":"","ca_DecBudgetPrice":""}
         * LiangFangWuYe : {"ca_ReqConTime":"","ca_ProductProtection":"","ca_PropertyInsurance":"","ca_DesignatedFireCompany":"","ca_DesignatedAirCompany":"","ca_DesignatedSinotrans":"","ca_Blueprint":"","ca_ProtectiveMaterial":""}
         */

        private KeHuXuQiuBean KeHuXuQiu;
        private WenZiXiangQingBean WenZiXiangQing;
        private LiangFangWuYeBean LiangFangWuYe;
        private List<HuanJingZhaoPianBean> HuanJingZhaoPian;

        public KeHuXuQiuBean getKeHuXuQiu() {
            return KeHuXuQiu;
        }

        public void setKeHuXuQiu(KeHuXuQiuBean KeHuXuQiu) {
            this.KeHuXuQiu = KeHuXuQiu;
        }

        public WenZiXiangQingBean getWenZiXiangQing() {
            return WenZiXiangQing;
        }

        public void setWenZiXiangQing(WenZiXiangQingBean WenZiXiangQing) {
            this.WenZiXiangQing = WenZiXiangQing;
        }

        public LiangFangWuYeBean getLiangFangWuYe() {
            return LiangFangWuYe;
        }

        public void setLiangFangWuYe(LiangFangWuYeBean LiangFangWuYe) {
            this.LiangFangWuYe = LiangFangWuYe;
        }

        public List<HuanJingZhaoPianBean> getHuanJingZhaoPian() {
            return HuanJingZhaoPian;
        }

        public void setHuanJingZhaoPian(List<HuanJingZhaoPianBean> HuanJingZhaoPian) {
            this.HuanJingZhaoPian = HuanJingZhaoPian;
        }

        public static class KeHuXuQiuBean {
            /**
             * ca_IntentionalStyle :
             * ca_SoftFurniture :
             * ca_IntelligentWeakCurrent :
             * ca_FengShuiRequirements :
             */

            private String ca_IntentionalStyle;
            private int ca_SoftFurniture;
            private int ca_IntelligentWeakCurrent;
            private int ca_FengShuiRequirements;

            public String getCa_IntentionalStyle() {
                return ca_IntentionalStyle;
            }

            public void setCa_IntentionalStyle(String ca_IntentionalStyle) {
                this.ca_IntentionalStyle = ca_IntentionalStyle;
            }

            public int getCa_SoftFurniture() {
                return ca_SoftFurniture;
            }

            public void setCa_SoftFurniture(int ca_SoftFurniture) {
                this.ca_SoftFurniture = ca_SoftFurniture;
            }

            public int getCa_IntelligentWeakCurrent() {
                return ca_IntelligentWeakCurrent;
            }

            public void setCa_IntelligentWeakCurrent(int ca_IntelligentWeakCurrent) {
                this.ca_IntelligentWeakCurrent = ca_IntelligentWeakCurrent;
            }

            public int getCa_FengShuiRequirements() {
                return ca_FengShuiRequirements;
            }

            public void setCa_FengShuiRequirements(int ca_FengShuiRequirements) {
                this.ca_FengShuiRequirements = ca_FengShuiRequirements;
            }
        }

        public static class WenZiXiangQingBean {
            /**
             * ci_rwdid :
             * WorksID : 0
             * CustomerID : 0
             * ca_OriginalTopMaterial :
             * ca_HousingType :
             * ca_ca_HousingSituation :
             * ca_HouseOrientation :
             * ca_OccupyPublicCorridor :
             * ca_isGroundSmooth :
             * ca_CargoDoorHight :
             * ca_CargoDoorWide :
             * ca_OriginalGroundMaterial :
             * ca_GroundElevation :
             * ca_SpaceMaxHeight :
             * ca_SpaceMinHeight :
             * ca_mainBeamHeight :
             * ca_SecondaryHeight :
             * ca_AirConditionerNum :
             * ca_TuyereMinimumHeight :
             * ca_StrongBoxNum :
             * ca_WeakBoxNum :
             * ca_UpWaterSpot :
             * ca_DownWaterSpot :
             * ca_DownWaterSpotSize :
             * ca_MinimumSprayHeight :
             * ca_CurtainWallSpacing :
             * ca_WindowType :
             * ca_windowsillHight :
             * ca_WindowHight :
             * ca_OriginalWallMaterial :
             * ca_WaterPath :
             * ca_WindowWidth :
             * ca_OriginalGround :
             * ca_LeaseTermStart :
             * ca_LeaseTermEnd :
             * ca_Rental :
             * ca_RentFreeDate :
             * ci_proHead :
             * ci_DecorationAddress :
             * ca_DecBudgetPrice :
             */

            private String ci_rwdid;
            private int WorksID;
            private int CustomerID;
            private String ca_OriginalTopMaterial;
            private int ca_HousingType;
            private String ca_ca_HousingSituation;
            private String ca_HouseOrientation;
            private int ca_OccupyPublicCorridor;
            private String ca_isGroundSmooth;
            private String ca_CargoDoorHight;
            private String ca_CargoDoorWide;
            private String ca_OriginalGroundMaterial;
            private String ca_GroundElevation;
            private String ca_SpaceMaxHeight;
            private String ca_SpaceMinHeight;
            private String ca_mainBeamHeight;
            private String ca_SecondaryHeight;
            private String ca_AirConditionerNum;
            private String ca_TuyereMinimumHeight;
            private String ca_StrongBoxNum;
            private String ca_WeakBoxNum;
            private String ca_UpWaterSpot;
            private String ca_DownWaterSpot;
            private String ca_DownWaterSpotSize;
            private String ca_MinimumSprayHeight;
            private String ca_CurtainWallSpacing;
            private String ca_WindowType;
            private String ca_windowsillHight;
            private String ca_WindowHight;
            private String ca_OriginalWallMaterial;
            private String ca_WaterPath;
            private String ca_WindowWidth;
            private String ca_OriginalGround;
            private String ca_LeaseTermStart;
            private String ca_LeaseTermEnd;
            private String ca_Rental;
            private int ca_RentFreeDate;
            private String ci_proHead;
            private String ci_DecorationAddress;
            private String ca_DecBudgetPrice;

            public String getCi_rwdid() {
                return ci_rwdid;
            }

            public void setCi_rwdid(String ci_rwdid) {
                this.ci_rwdid = ci_rwdid;
            }

            public int getWorksID() {
                return WorksID;
            }

            public void setWorksID(int WorksID) {
                this.WorksID = WorksID;
            }

            public int getCustomerID() {
                return CustomerID;
            }

            public void setCustomerID(int CustomerID) {
                this.CustomerID = CustomerID;
            }

            public String getCa_OriginalTopMaterial() {
                return ca_OriginalTopMaterial;
            }

            public void setCa_OriginalTopMaterial(String ca_OriginalTopMaterial) {
                this.ca_OriginalTopMaterial = ca_OriginalTopMaterial;
            }

            public int getCa_HousingType() {
                return ca_HousingType;
            }

            public void setCa_HousingType(int ca_HousingType) {
                this.ca_HousingType = ca_HousingType;
            }

            public String getCa_ca_HousingSituation() {
                return ca_ca_HousingSituation;
            }

            public void setCa_ca_HousingSituation(String ca_ca_HousingSituation) {
                this.ca_ca_HousingSituation = ca_ca_HousingSituation;
            }

            public String getCa_HouseOrientation() {
                return ca_HouseOrientation;
            }

            public void setCa_HouseOrientation(String ca_HouseOrientation) {
                this.ca_HouseOrientation = ca_HouseOrientation;
            }

            public int getCa_OccupyPublicCorridor() {
                return ca_OccupyPublicCorridor;
            }

            public void setCa_OccupyPublicCorridor(int ca_OccupyPublicCorridor) {
                this.ca_OccupyPublicCorridor = ca_OccupyPublicCorridor;
            }

            public String getCa_isGroundSmooth() {
                return ca_isGroundSmooth;
            }

            public void setCa_isGroundSmooth(String ca_isGroundSmooth) {
                this.ca_isGroundSmooth = ca_isGroundSmooth;
            }

            public String getCa_CargoDoorHight() {
                return ca_CargoDoorHight;
            }

            public void setCa_CargoDoorHight(String ca_CargoDoorHight) {
                this.ca_CargoDoorHight = ca_CargoDoorHight;
            }

            public String getCa_CargoDoorWide() {
                return ca_CargoDoorWide;
            }

            public void setCa_CargoDoorWide(String ca_CargoDoorWide) {
                this.ca_CargoDoorWide = ca_CargoDoorWide;
            }

            public String getCa_OriginalGroundMaterial() {
                return ca_OriginalGroundMaterial;
            }

            public void setCa_OriginalGroundMaterial(String ca_OriginalGroundMaterial) {
                this.ca_OriginalGroundMaterial = ca_OriginalGroundMaterial;
            }

            public String getCa_GroundElevation() {
                return ca_GroundElevation;
            }

            public void setCa_GroundElevation(String ca_GroundElevation) {
                this.ca_GroundElevation = ca_GroundElevation;
            }

            public String getCa_SpaceMaxHeight() {
                return ca_SpaceMaxHeight;
            }

            public void setCa_SpaceMaxHeight(String ca_SpaceMaxHeight) {
                this.ca_SpaceMaxHeight = ca_SpaceMaxHeight;
            }

            public String getCa_SpaceMinHeight() {
                return ca_SpaceMinHeight;
            }

            public void setCa_SpaceMinHeight(String ca_SpaceMinHeight) {
                this.ca_SpaceMinHeight = ca_SpaceMinHeight;
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

            public String getCa_CurtainWallSpacing() {
                return ca_CurtainWallSpacing;
            }

            public void setCa_CurtainWallSpacing(String ca_CurtainWallSpacing) {
                this.ca_CurtainWallSpacing = ca_CurtainWallSpacing;
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

            public String getCa_OriginalWallMaterial() {
                return ca_OriginalWallMaterial;
            }

            public void setCa_OriginalWallMaterial(String ca_OriginalWallMaterial) {
                this.ca_OriginalWallMaterial = ca_OriginalWallMaterial;
            }

            public String getCa_WaterPath() {
                return ca_WaterPath;
            }

            public void setCa_WaterPath(String ca_WaterPath) {
                this.ca_WaterPath = ca_WaterPath;
            }

            public String getCa_WindowWidth() {
                return ca_WindowWidth;
            }

            public void setCa_WindowWidth(String ca_WindowWidth) {
                this.ca_WindowWidth = ca_WindowWidth;
            }

            public String getCa_OriginalGround() {
                return ca_OriginalGround;
            }

            public void setCa_OriginalGround(String ca_OriginalGround) {
                this.ca_OriginalGround = ca_OriginalGround;
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

            public String getCa_Rental() {
                return ca_Rental;
            }

            public void setCa_Rental(String ca_Rental) {
                this.ca_Rental = ca_Rental;
            }

            public int getCa_RentFreeDate() {
                return ca_RentFreeDate;
            }

            public void setCa_RentFreeDate(int ca_RentFreeDate) {
                this.ca_RentFreeDate = ca_RentFreeDate;
            }

            public String getCi_proHead() {
                return ci_proHead;
            }

            public void setCi_proHead(String ci_proHead) {
                this.ci_proHead = ci_proHead;
            }

            public String getCi_DecorationAddress() {
                return ci_DecorationAddress;
            }

            public void setCi_DecorationAddress(String ci_DecorationAddress) {
                this.ci_DecorationAddress = ci_DecorationAddress;
            }

            public String getCa_DecBudgetPrice() {
                return ca_DecBudgetPrice;
            }

            public void setCa_DecBudgetPrice(String ca_DecBudgetPrice) {
                this.ca_DecBudgetPrice = ca_DecBudgetPrice;
            }
        }

        public static class LiangFangWuYeBean {
            /**
             * ca_ReqConTime :
             * ca_ProductProtection :
             * ca_PropertyInsurance :
             * ca_DesignatedFireCompany :
             * ca_DesignatedAirCompany :
             * ca_DesignatedSinotrans :
             * ca_Blueprint :
             * ca_ProtectiveMaterial :
             */

            private String ca_ReqConTime;
            private String ca_ProductProtection;
            private String ca_PropertyInsurance;
            private int ca_DesignatedFireCompany;
            private int ca_DesignatedAirCompany;
            private int ca_DesignatedSinotrans;
            private String ca_Blueprint;
            private String ca_ProtectiveMaterial;

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

            public int getCa_DesignatedFireCompany() {
                return ca_DesignatedFireCompany;
            }

            public void setCa_DesignatedFireCompany(int ca_DesignatedFireCompany) {
                this.ca_DesignatedFireCompany = ca_DesignatedFireCompany;
            }

            public int getCa_DesignatedAirCompany() {
                return ca_DesignatedAirCompany;
            }

            public void setCa_DesignatedAirCompany(int ca_DesignatedAirCompany) {
                this.ca_DesignatedAirCompany = ca_DesignatedAirCompany;
            }

            public int getCa_DesignatedSinotrans() {
                return ca_DesignatedSinotrans;
            }

            public void setCa_DesignatedSinotrans(int ca_DesignatedSinotrans) {
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
        }

        public static class HuanJingZhaoPianBean {
            /**
             * CreatorID : 0
             * WorksID : 0
             * CatalogID : 53
             * CatalogIDName : 特殊结构
             * CatalogShowType :
             * CatalogCount : 0
             * childList : []
             */

            private int CreatorID;
            private int WorksID;
            private int CatalogID;
            private String CatalogIDName;
            private String CatalogShowType;
            private int CatalogCount;
            private List<image> childList;

            public static class image implements Serializable
            {
                private int DetailID;
                private String ImageUrl;

                public image()
                {
                }

                public image(int detailID, String imageUrl)
                {
                    DetailID = detailID;
                    ImageUrl = imageUrl;
                }

                public int getDetailID()
                {
                    return DetailID;
                }

                public void setDetailID(int DetailID)
                {
                    this.DetailID = DetailID;
                }

                public String getImageUrl()
                {
                    return ImageUrl;
                }

                public void setImageUrl(String ImageUrl)
                {
                    this.ImageUrl = ImageUrl;
                }
            }



            public int getCreatorID() {
                return CreatorID;
            }

            public void setCreatorID(int CreatorID) {
                this.CreatorID = CreatorID;
            }

            public int getWorksID() {
                return WorksID;
            }

            public void setWorksID(int WorksID) {
                this.WorksID = WorksID;
            }

            public int getCatalogID() {
                return CatalogID;
            }

            public void setCatalogID(int CatalogID) {
                this.CatalogID = CatalogID;
            }

            public String getCatalogIDName() {
                return CatalogIDName;
            }

            public void setCatalogIDName(String CatalogIDName) {
                this.CatalogIDName = CatalogIDName;
            }

            public String getCatalogShowType() {
                return CatalogShowType;
            }

            public void setCatalogShowType(String CatalogShowType) {
                this.CatalogShowType = CatalogShowType;
            }

            public int getCatalogCount() {
                return CatalogCount;
            }

            public void setCatalogCount(int CatalogCount) {
                this.CatalogCount = CatalogCount;
            }

            public List<image> getChildList() {
                return childList;
            }

            public void setChildList(List<image> childList) {
                this.childList = childList;
            }
        }
    }
}
