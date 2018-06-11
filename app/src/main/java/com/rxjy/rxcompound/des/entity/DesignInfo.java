package com.rxjy.rxcompound.des.entity;

/**
 * Created by asus on 2018/4/24.
 */

public class DesignInfo {

    /**
     * StatusMsg : 成功
     * StatusCode : 0
     * Body : {"ortherInfomationPojo":{"ci_ElectronicCommerce":"0","ci_clientType":"","ci_Stage":"9","ci_TurnStatus":"0","ci_LFMoney":"0.00","ca_AuditTime":"2018-04-12 09:16:53.693","ca_SjsSubTime":"2018-04-16 11:58:03.0","ci_ReciveStatus":"1","ci_ReceiveTime":"2018-03-19 09:49:20.39","ca_AuditState":"4","ca_SWSubmitTime":"2018-03-19","ci_State":"10","ci_AddTime":"2018-03-19 09:49:20.39"},"baseInformation":{"ci_ClientName":"武汉私律科技有限公司","ci_DesignerCard":"02700046","ci_SalesmanName":"杨凤","ca_SWIndustryTypeID":"网络公司","ci_APP":"1","ci_Type":"办公","ca_HangYeLeIXing":"直营连锁","tb_diqu":"武汉","ca_LeaseTermEnd":"2028-01-01","ca_LeaseTermStart":"2017-01-01","ci_OfficeAddress":"湖北省武汉市武汉汉街万达...","ci_TypeLevelThird":"综合门户","ci_SalesmanCard":"02700349","ci_DesignerName":"朱华杰","ci_DesignState":"2","ci_DesignerSex":"男"},"propertyInformation":{"ca_DesignatedFireCompany":"否","ca_Blueprint":"白图","ca_TwoManagerTel":"13407142379","ca_Aptitude":"二级","ca_PropertyInsurance":"否","ca_property_management_company":"","ca_DesignatedSinotrans":"2","ca_ProtectiveMaterial":"彩布条","ca_Elevator":"","ca_HtAuditingCycle":"","ca_LeadName":"","ca_DrawAudit":"有","ca_HtBlowdownPrice":"","ca_HtDeposit":"","ca_SpecialRequirement":"不是全层不能占用过道。","ca_DesignatedAirCompany":"否","ca_HtManagePrice":"","ca_ProductProtection":"是","ca_ReqConTime":"白天","ca_HtRiskPrice":"","ca_Maintenance":"有","ca_HtHydropowerPrice":""},"companyInformation":{"ca_BusinessScope":"互联网信息技术研发、...","ca_EstablishmentTime":"2015-01-01","ca_EnterpriseNature":"私企","ca_CorporateCulture":"法律服务","ca_ForeignEnterprises":"是","ca_EnterprisesScale":"50-100人"},"buildingInformation":{"ca_RealEstate":"长投光谷企业天地","ca_DevelopmentFloor":"3","ca_HouseNumber":"3、4、5号房","ca_RealEstatePeriod":"2栋"},"customerInformation":{"ci_proAge":"40岁-50岁","ca_proHeadIdentity":"负责人","ca_NoteFocus":"效率","ca_proHeadCharacter":"温和","ci_proSex":"男","ci_proHead":"田洋","ca_ContractPerson":"未知","ci_proCharacteristic":""},"contractInfomationPojo":{"ca_HtWorkCycle":"","ca_HtPayProportion":"","ca_HtSignDate":""},"measureInformation":{"ca_windowsillHight":"300.00","ca_TuyereMinimumHeight":"2460.00","ca_AirConditionerNum":"4","ca_MinimumSprayHeight":"2460.00","ca_WindowType":"玻璃幕墙","dataPercent":"76.4%","ca_SpaceMinHeight":"","ca_OccupyPublicCorridor":"否","ca_UpWaterSpot":"0","ca_DownWaterSpot":"0","ca_OriginalTopMaterial":"水泥毛坯","ca_WaterPath":"板底","ca_CargoDoorHight":"2100.00","ca_isGroundSmooth":"是","ca_WindowHight":"2000.00","ca_DownWaterSpotSize":"0.00","ca_WindowWidth":"1200.00","ca_StrongBoxNum":"1","ca_OriginalGroundMaterial":"水泥毛坯","ca_SecondaryHeight":"3050.00","ca_mainBeamHeight":"2985.00","ca_SpaceMaxHeight":"3610.00","ca_OriginalGround":"否","ca_OriginalWallMaterial":"水泥","ca_HouseOrientation":"东","ca_WeakBoxNum":"1","ca_CargoDoorWide":"","ca_CurtainWallSpacing":"1200.00","ca_GroundElevation":"10.00"},"decorateInformation":{"ca_DecorationDate":"2018-04-02","ca_SpaceRequirement":"有","ca_proAttribute":"正常单","ca_InviteTenders":"否","ca_swRemarks":"武汉私律科技有限公司\t田洋\t18571676123\tA2栋303、304、305号房\t579.30武昌区水果湖街汉街中央文化旅游区K3地块第2幢11层8号房","ca_FengShuiRequirements":"否","ci_advancePayment":"否","ci_DecorationAddress":"湖北省武汉市洪山区光谷大道52号长投光谷企业天地A2栋303、304、305号房","ca_DecBudgetPrice":"80","ca_IntentionalStyle":"现代简约","ca_SoftFurniture":"是","ca_IntelligentWeakCurrent":"是"},"housingResourcesInformation":{"ca_AvailabilityStatus":"已定","ca_HousingType":"毛坯房","ca_RentFreeDate":"无","ca_TransactionType":"买","ci_Area":"380","ca_MeasureDate":"2018-03-15","ca_LaunchTime":"2018-03-15","ca_Rental":"0.0","ci_BuildingArea":"380"}}
     */

    private String StatusMsg;
    private int StatusCode;
    private BodyBean Body;

    public String getStatusMsg() {
        return StatusMsg;
    }

    public void setStatusMsg(String StatusMsg) {
        this.StatusMsg = StatusMsg;
    }

    public int getStatusCode() {
        return StatusCode;
    }

    public void setStatusCode(int StatusCode) {
        this.StatusCode = StatusCode;
    }

    public BodyBean getBody() {
        return Body;
    }

    public void setBody(BodyBean Body) {
        this.Body = Body;
    }

    public static class BodyBean {
        /**
         * ortherInfomationPojo : {"ci_ElectronicCommerce":"0","ci_clientType":"","ci_Stage":"9","ci_TurnStatus":"0","ci_LFMoney":"0.00","ca_AuditTime":"2018-04-12 09:16:53.693","ca_SjsSubTime":"2018-04-16 11:58:03.0","ci_ReciveStatus":"1","ci_ReceiveTime":"2018-03-19 09:49:20.39","ca_AuditState":"4","ca_SWSubmitTime":"2018-03-19","ci_State":"10","ci_AddTime":"2018-03-19 09:49:20.39"}
         * baseInformation : {"ci_ClientName":"武汉私律科技有限公司","ci_DesignerCard":"02700046","ci_SalesmanName":"杨凤","ca_SWIndustryTypeID":"网络公司","ci_APP":"1","ci_Type":"办公","ca_HangYeLeIXing":"直营连锁","tb_diqu":"武汉","ca_LeaseTermEnd":"2028-01-01","ca_LeaseTermStart":"2017-01-01","ci_OfficeAddress":"湖北省武汉市武汉汉街万达...","ci_TypeLevelThird":"综合门户","ci_SalesmanCard":"02700349","ci_DesignerName":"朱华杰","ci_DesignState":"2","ci_DesignerSex":"男"}
         * propertyInformation : {"ca_DesignatedFireCompany":"否","ca_Blueprint":"白图","ca_TwoManagerTel":"13407142379","ca_Aptitude":"二级","ca_PropertyInsurance":"否","ca_property_management_company":"","ca_DesignatedSinotrans":"2","ca_ProtectiveMaterial":"彩布条","ca_Elevator":"","ca_HtAuditingCycle":"","ca_LeadName":"","ca_DrawAudit":"有","ca_HtBlowdownPrice":"","ca_HtDeposit":"","ca_SpecialRequirement":"不是全层不能占用过道。","ca_DesignatedAirCompany":"否","ca_HtManagePrice":"","ca_ProductProtection":"是","ca_ReqConTime":"白天","ca_HtRiskPrice":"","ca_Maintenance":"有","ca_HtHydropowerPrice":""}
         * companyInformation : {"ca_BusinessScope":"互联网信息技术研发、...","ca_EstablishmentTime":"2015-01-01","ca_EnterpriseNature":"私企","ca_CorporateCulture":"法律服务","ca_ForeignEnterprises":"是","ca_EnterprisesScale":"50-100人"}
         * buildingInformation : {"ca_RealEstate":"长投光谷企业天地","ca_DevelopmentFloor":"3","ca_HouseNumber":"3、4、5号房","ca_RealEstatePeriod":"2栋"}
         * customerInformation : {"ci_proAge":"40岁-50岁","ca_proHeadIdentity":"负责人","ca_NoteFocus":"效率","ca_proHeadCharacter":"温和","ci_proSex":"男","ci_proHead":"田洋","ca_ContractPerson":"未知","ci_proCharacteristic":""}
         * contractInfomationPojo : {"ca_HtWorkCycle":"","ca_HtPayProportion":"","ca_HtSignDate":""}
         * measureInformation : {"ca_windowsillHight":"300.00","ca_TuyereMinimumHeight":"2460.00","ca_AirConditionerNum":"4","ca_MinimumSprayHeight":"2460.00","ca_WindowType":"玻璃幕墙","dataPercent":"76.4%","ca_SpaceMinHeight":"","ca_OccupyPublicCorridor":"否","ca_UpWaterSpot":"0","ca_DownWaterSpot":"0","ca_OriginalTopMaterial":"水泥毛坯","ca_WaterPath":"板底","ca_CargoDoorHight":"2100.00","ca_isGroundSmooth":"是","ca_WindowHight":"2000.00","ca_DownWaterSpotSize":"0.00","ca_WindowWidth":"1200.00","ca_StrongBoxNum":"1","ca_OriginalGroundMaterial":"水泥毛坯","ca_SecondaryHeight":"3050.00","ca_mainBeamHeight":"2985.00","ca_SpaceMaxHeight":"3610.00","ca_OriginalGround":"否","ca_OriginalWallMaterial":"水泥","ca_HouseOrientation":"东","ca_WeakBoxNum":"1","ca_CargoDoorWide":"","ca_CurtainWallSpacing":"1200.00","ca_GroundElevation":"10.00"}
         * decorateInformation : {"ca_DecorationDate":"2018-04-02","ca_SpaceRequirement":"有","ca_proAttribute":"正常单","ca_InviteTenders":"否","ca_swRemarks":"武汉私律科技有限公司\t田洋\t18571676123\tA2栋303、304、305号房\t579.30武昌区水果湖街汉街中央文化旅游区K3地块第2幢11层8号房","ca_FengShuiRequirements":"否","ci_advancePayment":"否","ci_DecorationAddress":"湖北省武汉市洪山区光谷大道52号长投光谷企业天地A2栋303、304、305号房","ca_DecBudgetPrice":"80","ca_IntentionalStyle":"现代简约","ca_SoftFurniture":"是","ca_IntelligentWeakCurrent":"是"}
         * housingResourcesInformation : {"ca_AvailabilityStatus":"已定","ca_HousingType":"毛坯房","ca_RentFreeDate":"无","ca_TransactionType":"买","ci_Area":"380","ca_MeasureDate":"2018-03-15","ca_LaunchTime":"2018-03-15","ca_Rental":"0.0","ci_BuildingArea":"380"}
         */

        private OrtherInfomationPojoBean ortherInfomationPojo;
        private BaseInformationBean baseInformation;
        private PropertyInformationBean propertyInformation;
        private CompanyInformationBean companyInformation;
        private BuildingInformationBean buildingInformation;
        private CustomerInformationBean customerInformation;
        private ContractInfomationPojoBean contractInfomationPojo;
        private MeasureInformationBean measureInformation;
        private DecorateInformationBean decorateInformation;
        private HousingResourcesInformationBean housingResourcesInformation;

        public OrtherInfomationPojoBean getOrtherInfomationPojo() {
            return ortherInfomationPojo;
        }

        public void setOrtherInfomationPojo(OrtherInfomationPojoBean ortherInfomationPojo) {
            this.ortherInfomationPojo = ortherInfomationPojo;
        }

        public BaseInformationBean getBaseInformation() {
            return baseInformation;
        }

        public void setBaseInformation(BaseInformationBean baseInformation) {
            this.baseInformation = baseInformation;
        }

        public PropertyInformationBean getPropertyInformation() {
            return propertyInformation;
        }

        public void setPropertyInformation(PropertyInformationBean propertyInformation) {
            this.propertyInformation = propertyInformation;
        }

        public CompanyInformationBean getCompanyInformation() {
            return companyInformation;
        }

        public void setCompanyInformation(CompanyInformationBean companyInformation) {
            this.companyInformation = companyInformation;
        }

        public BuildingInformationBean getBuildingInformation() {
            return buildingInformation;
        }

        public void setBuildingInformation(BuildingInformationBean buildingInformation) {
            this.buildingInformation = buildingInformation;
        }

        public CustomerInformationBean getCustomerInformation() {
            return customerInformation;
        }

        public void setCustomerInformation(CustomerInformationBean customerInformation) {
            this.customerInformation = customerInformation;
        }

        public ContractInfomationPojoBean getContractInfomationPojo() {
            return contractInfomationPojo;
        }

        public void setContractInfomationPojo(ContractInfomationPojoBean contractInfomationPojo) {
            this.contractInfomationPojo = contractInfomationPojo;
        }

        public MeasureInformationBean getMeasureInformation() {
            return measureInformation;
        }

        public void setMeasureInformation(MeasureInformationBean measureInformation) {
            this.measureInformation = measureInformation;
        }

        public DecorateInformationBean getDecorateInformation() {
            return decorateInformation;
        }

        public void setDecorateInformation(DecorateInformationBean decorateInformation) {
            this.decorateInformation = decorateInformation;
        }

        public HousingResourcesInformationBean getHousingResourcesInformation() {
            return housingResourcesInformation;
        }

        public void setHousingResourcesInformation(HousingResourcesInformationBean housingResourcesInformation) {
            this.housingResourcesInformation = housingResourcesInformation;
        }

        public static class OrtherInfomationPojoBean {
            /**
             * ci_ElectronicCommerce : 0
             * ci_clientType :
             * ci_Stage : 9
             * ci_TurnStatus : 0
             * ci_LFMoney : 0.00
             * ca_AuditTime : 2018-04-12 09:16:53.693
             * ca_SjsSubTime : 2018-04-16 11:58:03.0
             * ci_ReciveStatus : 1
             * ci_ReceiveTime : 2018-03-19 09:49:20.39
             * ca_AuditState : 4
             * ca_SWSubmitTime : 2018-03-19
             * ci_State : 10
             * ci_AddTime : 2018-03-19 09:49:20.39
             */

            private String ci_ElectronicCommerce;
            private String ci_clientType;
            private String ci_Stage;
            private String ci_TurnStatus;
            private String ci_LFMoney;
            private String ca_AuditTime;
            private String ca_SjsSubTime;
            private String ci_ReciveStatus;
            private String ci_ReceiveTime;
            private String ca_AuditState;
            private String ca_SWSubmitTime;
            private String ci_State;
            private String ci_AddTime;

            public String getCi_ElectronicCommerce() {
                return ci_ElectronicCommerce;
            }

            public void setCi_ElectronicCommerce(String ci_ElectronicCommerce) {
                this.ci_ElectronicCommerce = ci_ElectronicCommerce;
            }

            public String getCi_clientType() {
                return ci_clientType;
            }

            public void setCi_clientType(String ci_clientType) {
                this.ci_clientType = ci_clientType;
            }

            public String getCi_Stage() {
                return ci_Stage;
            }

            public void setCi_Stage(String ci_Stage) {
                this.ci_Stage = ci_Stage;
            }

            public String getCi_TurnStatus() {
                return ci_TurnStatus;
            }

            public void setCi_TurnStatus(String ci_TurnStatus) {
                this.ci_TurnStatus = ci_TurnStatus;
            }

            public String getCi_LFMoney() {
                return ci_LFMoney;
            }

            public void setCi_LFMoney(String ci_LFMoney) {
                this.ci_LFMoney = ci_LFMoney;
            }

            public String getCa_AuditTime() {
                return ca_AuditTime;
            }

            public void setCa_AuditTime(String ca_AuditTime) {
                this.ca_AuditTime = ca_AuditTime;
            }

            public String getCa_SjsSubTime() {
                return ca_SjsSubTime;
            }

            public void setCa_SjsSubTime(String ca_SjsSubTime) {
                this.ca_SjsSubTime = ca_SjsSubTime;
            }

            public String getCi_ReciveStatus() {
                return ci_ReciveStatus;
            }

            public void setCi_ReciveStatus(String ci_ReciveStatus) {
                this.ci_ReciveStatus = ci_ReciveStatus;
            }

            public String getCi_ReceiveTime() {
                return ci_ReceiveTime;
            }

            public void setCi_ReceiveTime(String ci_ReceiveTime) {
                this.ci_ReceiveTime = ci_ReceiveTime;
            }

            public String getCa_AuditState() {
                return ca_AuditState;
            }

            public void setCa_AuditState(String ca_AuditState) {
                this.ca_AuditState = ca_AuditState;
            }

            public String getCa_SWSubmitTime() {
                return ca_SWSubmitTime;
            }

            public void setCa_SWSubmitTime(String ca_SWSubmitTime) {
                this.ca_SWSubmitTime = ca_SWSubmitTime;
            }

            public String getCi_State() {
                return ci_State;
            }

            public void setCi_State(String ci_State) {
                this.ci_State = ci_State;
            }

            public String getCi_AddTime() {
                return ci_AddTime;
            }

            public void setCi_AddTime(String ci_AddTime) {
                this.ci_AddTime = ci_AddTime;
            }
        }

        public static class BaseInformationBean {
            /**
             * ci_ClientName : 武汉私律科技有限公司
             * ci_DesignerCard : 02700046
             * ci_SalesmanName : 杨凤
             * ca_SWIndustryTypeID : 网络公司
             * ci_APP : 1
             * ci_Type : 办公
             * ca_HangYeLeIXing : 直营连锁
             * tb_diqu : 武汉
             * ca_LeaseTermEnd : 2028-01-01
             * ca_LeaseTermStart : 2017-01-01
             * ci_OfficeAddress : 湖北省武汉市武汉汉街万达...
             * ci_TypeLevelThird : 综合门户
             * ci_SalesmanCard : 02700349
             * ci_DesignerName : 朱华杰
             * ci_DesignState : 2
             * ci_DesignerSex : 男
             */

            private String ci_ClientName;
            private String ci_DesignerCard;
            private String ci_SalesmanName;
            private String ca_SWIndustryTypeID;
            private String ci_APP;
            private String ci_Type;
            private String ca_HangYeLeIXing;
            private String tb_diqu;
            private String ca_LeaseTermEnd;
            private String ca_LeaseTermStart;
            private String ci_OfficeAddress;
            private String ci_TypeLevelThird;
            private String ci_SalesmanCard;
            private String ci_DesignerName;
            private String ci_DesignState;
            private String ci_DesignerSex;

            public String getCi_ClientName() {
                return ci_ClientName;
            }

            public void setCi_ClientName(String ci_ClientName) {
                this.ci_ClientName = ci_ClientName;
            }

            public String getCi_DesignerCard() {
                return ci_DesignerCard;
            }

            public void setCi_DesignerCard(String ci_DesignerCard) {
                this.ci_DesignerCard = ci_DesignerCard;
            }

            public String getCi_SalesmanName() {
                return ci_SalesmanName;
            }

            public void setCi_SalesmanName(String ci_SalesmanName) {
                this.ci_SalesmanName = ci_SalesmanName;
            }

            public String getCa_SWIndustryTypeID() {
                return ca_SWIndustryTypeID;
            }

            public void setCa_SWIndustryTypeID(String ca_SWIndustryTypeID) {
                this.ca_SWIndustryTypeID = ca_SWIndustryTypeID;
            }

            public String getCi_APP() {
                return ci_APP;
            }

            public void setCi_APP(String ci_APP) {
                this.ci_APP = ci_APP;
            }

            public String getCi_Type() {
                return ci_Type;
            }

            public void setCi_Type(String ci_Type) {
                this.ci_Type = ci_Type;
            }

            public String getCa_HangYeLeIXing() {
                return ca_HangYeLeIXing;
            }

            public void setCa_HangYeLeIXing(String ca_HangYeLeIXing) {
                this.ca_HangYeLeIXing = ca_HangYeLeIXing;
            }

            public String getTb_diqu() {
                return tb_diqu;
            }

            public void setTb_diqu(String tb_diqu) {
                this.tb_diqu = tb_diqu;
            }

            public String getCa_LeaseTermEnd() {
                return ca_LeaseTermEnd;
            }

            public void setCa_LeaseTermEnd(String ca_LeaseTermEnd) {
                this.ca_LeaseTermEnd = ca_LeaseTermEnd;
            }

            public String getCa_LeaseTermStart() {
                return ca_LeaseTermStart;
            }

            public void setCa_LeaseTermStart(String ca_LeaseTermStart) {
                this.ca_LeaseTermStart = ca_LeaseTermStart;
            }

            public String getCi_OfficeAddress() {
                return ci_OfficeAddress;
            }

            public void setCi_OfficeAddress(String ci_OfficeAddress) {
                this.ci_OfficeAddress = ci_OfficeAddress;
            }

            public String getCi_TypeLevelThird() {
                return ci_TypeLevelThird;
            }

            public void setCi_TypeLevelThird(String ci_TypeLevelThird) {
                this.ci_TypeLevelThird = ci_TypeLevelThird;
            }

            public String getCi_SalesmanCard() {
                return ci_SalesmanCard;
            }

            public void setCi_SalesmanCard(String ci_SalesmanCard) {
                this.ci_SalesmanCard = ci_SalesmanCard;
            }

            public String getCi_DesignerName() {
                return ci_DesignerName;
            }

            public void setCi_DesignerName(String ci_DesignerName) {
                this.ci_DesignerName = ci_DesignerName;
            }

            public String getCi_DesignState() {
                return ci_DesignState;
            }

            public void setCi_DesignState(String ci_DesignState) {
                this.ci_DesignState = ci_DesignState;
            }

            public String getCi_DesignerSex() {
                return ci_DesignerSex;
            }

            public void setCi_DesignerSex(String ci_DesignerSex) {
                this.ci_DesignerSex = ci_DesignerSex;
            }
        }

        public static class PropertyInformationBean {
            /**
             * ca_DesignatedFireCompany : 否
             * ca_Blueprint : 白图
             * ca_TwoManagerTel : 13407142379
             * ca_Aptitude : 二级
             * ca_PropertyInsurance : 否
             * ca_property_management_company :
             * ca_DesignatedSinotrans : 2
             * ca_ProtectiveMaterial : 彩布条
             * ca_Elevator :
             * ca_HtAuditingCycle :
             * ca_LeadName :
             * ca_DrawAudit : 有
             * ca_HtBlowdownPrice :
             * ca_HtDeposit :
             * ca_SpecialRequirement : 不是全层不能占用过道。
             * ca_DesignatedAirCompany : 否
             * ca_HtManagePrice :
             * ca_ProductProtection : 是
             * ca_ReqConTime : 白天
             * ca_HtRiskPrice :
             * ca_Maintenance : 有
             * ca_HtHydropowerPrice :
             */

            private String ca_DesignatedFireCompany;
            private String ca_Blueprint;
            private String ca_TwoManagerTel;
            private String ca_Aptitude;
            private String ca_PropertyInsurance;
            private String ca_property_management_company;
            private String ca_DesignatedSinotrans;
            private String ca_ProtectiveMaterial;
            private String ca_Elevator;
            private String ca_HtAuditingCycle;
            private String ca_LeadName;
            private String ca_DrawAudit;
            private String ca_HtBlowdownPrice;
            private String ca_HtDeposit;
            private String ca_SpecialRequirement;
            private String ca_DesignatedAirCompany;
            private String ca_HtManagePrice;
            private String ca_ProductProtection;
            private String ca_ReqConTime;
            private String ca_HtRiskPrice;
            private String ca_Maintenance;
            private String ca_HtHydropowerPrice;

            public String getCa_DesignatedFireCompany() {
                return ca_DesignatedFireCompany;
            }

            public void setCa_DesignatedFireCompany(String ca_DesignatedFireCompany) {
                this.ca_DesignatedFireCompany = ca_DesignatedFireCompany;
            }

            public String getCa_Blueprint() {
                return ca_Blueprint;
            }

            public void setCa_Blueprint(String ca_Blueprint) {
                this.ca_Blueprint = ca_Blueprint;
            }

            public String getCa_TwoManagerTel() {
                return ca_TwoManagerTel;
            }

            public void setCa_TwoManagerTel(String ca_TwoManagerTel) {
                this.ca_TwoManagerTel = ca_TwoManagerTel;
            }

            public String getCa_Aptitude() {
                return ca_Aptitude;
            }

            public void setCa_Aptitude(String ca_Aptitude) {
                this.ca_Aptitude = ca_Aptitude;
            }

            public String getCa_PropertyInsurance() {
                return ca_PropertyInsurance;
            }

            public void setCa_PropertyInsurance(String ca_PropertyInsurance) {
                this.ca_PropertyInsurance = ca_PropertyInsurance;
            }

            public String getCa_property_management_company() {
                return ca_property_management_company;
            }

            public void setCa_property_management_company(String ca_property_management_company) {
                this.ca_property_management_company = ca_property_management_company;
            }

            public String getCa_DesignatedSinotrans() {
                return ca_DesignatedSinotrans;
            }

            public void setCa_DesignatedSinotrans(String ca_DesignatedSinotrans) {
                this.ca_DesignatedSinotrans = ca_DesignatedSinotrans;
            }

            public String getCa_ProtectiveMaterial() {
                return ca_ProtectiveMaterial;
            }

            public void setCa_ProtectiveMaterial(String ca_ProtectiveMaterial) {
                this.ca_ProtectiveMaterial = ca_ProtectiveMaterial;
            }

            public String getCa_Elevator() {
                return ca_Elevator;
            }

            public void setCa_Elevator(String ca_Elevator) {
                this.ca_Elevator = ca_Elevator;
            }

            public String getCa_HtAuditingCycle() {
                return ca_HtAuditingCycle;
            }

            public void setCa_HtAuditingCycle(String ca_HtAuditingCycle) {
                this.ca_HtAuditingCycle = ca_HtAuditingCycle;
            }

            public String getCa_LeadName() {
                return ca_LeadName;
            }

            public void setCa_LeadName(String ca_LeadName) {
                this.ca_LeadName = ca_LeadName;
            }

            public String getCa_DrawAudit() {
                return ca_DrawAudit;
            }

            public void setCa_DrawAudit(String ca_DrawAudit) {
                this.ca_DrawAudit = ca_DrawAudit;
            }

            public String getCa_HtBlowdownPrice() {
                return ca_HtBlowdownPrice;
            }

            public void setCa_HtBlowdownPrice(String ca_HtBlowdownPrice) {
                this.ca_HtBlowdownPrice = ca_HtBlowdownPrice;
            }

            public String getCa_HtDeposit() {
                return ca_HtDeposit;
            }

            public void setCa_HtDeposit(String ca_HtDeposit) {
                this.ca_HtDeposit = ca_HtDeposit;
            }

            public String getCa_SpecialRequirement() {
                return ca_SpecialRequirement;
            }

            public void setCa_SpecialRequirement(String ca_SpecialRequirement) {
                this.ca_SpecialRequirement = ca_SpecialRequirement;
            }

            public String getCa_DesignatedAirCompany() {
                return ca_DesignatedAirCompany;
            }

            public void setCa_DesignatedAirCompany(String ca_DesignatedAirCompany) {
                this.ca_DesignatedAirCompany = ca_DesignatedAirCompany;
            }

            public String getCa_HtManagePrice() {
                return ca_HtManagePrice;
            }

            public void setCa_HtManagePrice(String ca_HtManagePrice) {
                this.ca_HtManagePrice = ca_HtManagePrice;
            }

            public String getCa_ProductProtection() {
                return ca_ProductProtection;
            }

            public void setCa_ProductProtection(String ca_ProductProtection) {
                this.ca_ProductProtection = ca_ProductProtection;
            }

            public String getCa_ReqConTime() {
                return ca_ReqConTime;
            }

            public void setCa_ReqConTime(String ca_ReqConTime) {
                this.ca_ReqConTime = ca_ReqConTime;
            }

            public String getCa_HtRiskPrice() {
                return ca_HtRiskPrice;
            }

            public void setCa_HtRiskPrice(String ca_HtRiskPrice) {
                this.ca_HtRiskPrice = ca_HtRiskPrice;
            }

            public String getCa_Maintenance() {
                return ca_Maintenance;
            }

            public void setCa_Maintenance(String ca_Maintenance) {
                this.ca_Maintenance = ca_Maintenance;
            }

            public String getCa_HtHydropowerPrice() {
                return ca_HtHydropowerPrice;
            }

            public void setCa_HtHydropowerPrice(String ca_HtHydropowerPrice) {
                this.ca_HtHydropowerPrice = ca_HtHydropowerPrice;
            }
        }

        public static class CompanyInformationBean {
            /**
             * ca_BusinessScope : 互联网信息技术研发、...
             * ca_EstablishmentTime : 2015-01-01
             * ca_EnterpriseNature : 私企
             * ca_CorporateCulture : 法律服务
             * ca_ForeignEnterprises : 是
             * ca_EnterprisesScale : 50-100人
             */

            private String ca_BusinessScope;
            private String ca_EstablishmentTime;
            private String ca_EnterpriseNature;
            private String ca_CorporateCulture;
            private String ca_ForeignEnterprises;
            private String ca_EnterprisesScale;

            public String getCa_BusinessScope() {
                return ca_BusinessScope;
            }

            public void setCa_BusinessScope(String ca_BusinessScope) {
                this.ca_BusinessScope = ca_BusinessScope;
            }

            public String getCa_EstablishmentTime() {
                return ca_EstablishmentTime;
            }

            public void setCa_EstablishmentTime(String ca_EstablishmentTime) {
                this.ca_EstablishmentTime = ca_EstablishmentTime;
            }

            public String getCa_EnterpriseNature() {
                return ca_EnterpriseNature;
            }

            public void setCa_EnterpriseNature(String ca_EnterpriseNature) {
                this.ca_EnterpriseNature = ca_EnterpriseNature;
            }

            public String getCa_CorporateCulture() {
                return ca_CorporateCulture;
            }

            public void setCa_CorporateCulture(String ca_CorporateCulture) {
                this.ca_CorporateCulture = ca_CorporateCulture;
            }

            public String getCa_ForeignEnterprises() {
                return ca_ForeignEnterprises;
            }

            public void setCa_ForeignEnterprises(String ca_ForeignEnterprises) {
                this.ca_ForeignEnterprises = ca_ForeignEnterprises;
            }

            public String getCa_EnterprisesScale() {
                return ca_EnterprisesScale;
            }

            public void setCa_EnterprisesScale(String ca_EnterprisesScale) {
                this.ca_EnterprisesScale = ca_EnterprisesScale;
            }
        }

        public static class BuildingInformationBean {
            /**
             * ca_RealEstate : 长投光谷企业天地
             * ca_DevelopmentFloor : 3
             * ca_HouseNumber : 3、4、5号房
             * ca_RealEstatePeriod : 2栋
             */

            private String ca_RealEstate;
            private String ca_DevelopmentFloor;
            private String ca_HouseNumber;
            private String ca_RealEstatePeriod;

            public String getCa_RealEstate() {
                return ca_RealEstate;
            }

            public void setCa_RealEstate(String ca_RealEstate) {
                this.ca_RealEstate = ca_RealEstate;
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

            public String getCa_RealEstatePeriod() {
                return ca_RealEstatePeriod;
            }

            public void setCa_RealEstatePeriod(String ca_RealEstatePeriod) {
                this.ca_RealEstatePeriod = ca_RealEstatePeriod;
            }
        }

        public static class CustomerInformationBean {
            /**
             * ci_proAge : 40岁-50岁
             * ca_proHeadIdentity : 负责人
             * ca_NoteFocus : 效率
             * ca_proHeadCharacter : 温和
             * ci_proSex : 男
             * ci_proHead : 田洋
             * ca_ContractPerson : 未知
             * ci_proCharacteristic :
             */

            private String ci_proAge;
            private String ca_proHeadIdentity;
            private String ca_NoteFocus;
            private String ca_proHeadCharacter;
            private String ci_proSex;
            private String ci_proHead;
            private String ca_ContractPerson;
            private String ci_proCharacteristic;

            public String getCi_proAge() {
                return ci_proAge;
            }

            public void setCi_proAge(String ci_proAge) {
                this.ci_proAge = ci_proAge;
            }

            public String getCa_proHeadIdentity() {
                return ca_proHeadIdentity;
            }

            public void setCa_proHeadIdentity(String ca_proHeadIdentity) {
                this.ca_proHeadIdentity = ca_proHeadIdentity;
            }

            public String getCa_NoteFocus() {
                return ca_NoteFocus;
            }

            public void setCa_NoteFocus(String ca_NoteFocus) {
                this.ca_NoteFocus = ca_NoteFocus;
            }

            public String getCa_proHeadCharacter() {
                return ca_proHeadCharacter;
            }

            public void setCa_proHeadCharacter(String ca_proHeadCharacter) {
                this.ca_proHeadCharacter = ca_proHeadCharacter;
            }

            public String getCi_proSex() {
                return ci_proSex;
            }

            public void setCi_proSex(String ci_proSex) {
                this.ci_proSex = ci_proSex;
            }

            public String getCi_proHead() {
                return ci_proHead;
            }

            public void setCi_proHead(String ci_proHead) {
                this.ci_proHead = ci_proHead;
            }

            public String getCa_ContractPerson() {
                return ca_ContractPerson;
            }

            public void setCa_ContractPerson(String ca_ContractPerson) {
                this.ca_ContractPerson = ca_ContractPerson;
            }

            public String getCi_proCharacteristic() {
                return ci_proCharacteristic;
            }

            public void setCi_proCharacteristic(String ci_proCharacteristic) {
                this.ci_proCharacteristic = ci_proCharacteristic;
            }
        }

        public static class ContractInfomationPojoBean {
            /**
             * ca_HtWorkCycle :
             * ca_HtPayProportion :
             * ca_HtSignDate :
             */

            private String ca_HtWorkCycle;
            private String ca_HtPayProportion;
            private String ca_HtSignDate;

            public String getCa_HtWorkCycle() {
                return ca_HtWorkCycle;
            }

            public void setCa_HtWorkCycle(String ca_HtWorkCycle) {
                this.ca_HtWorkCycle = ca_HtWorkCycle;
            }

            public String getCa_HtPayProportion() {
                return ca_HtPayProportion;
            }

            public void setCa_HtPayProportion(String ca_HtPayProportion) {
                this.ca_HtPayProportion = ca_HtPayProportion;
            }

            public String getCa_HtSignDate() {
                return ca_HtSignDate;
            }

            public void setCa_HtSignDate(String ca_HtSignDate) {
                this.ca_HtSignDate = ca_HtSignDate;
            }
        }

        public static class MeasureInformationBean {
            /**
             * ca_windowsillHight : 300.00
             * ca_TuyereMinimumHeight : 2460.00
             * ca_AirConditionerNum : 4
             * ca_MinimumSprayHeight : 2460.00
             * ca_WindowType : 玻璃幕墙
             * dataPercent : 76.4%
             * ca_SpaceMinHeight :
             * ca_OccupyPublicCorridor : 否
             * ca_UpWaterSpot : 0
             * ca_DownWaterSpot : 0
             * ca_OriginalTopMaterial : 水泥毛坯
             * ca_WaterPath : 板底
             * ca_CargoDoorHight : 2100.00
             * ca_isGroundSmooth : 是
             * ca_WindowHight : 2000.00
             * ca_DownWaterSpotSize : 0.00
             * ca_WindowWidth : 1200.00
             * ca_StrongBoxNum : 1
             * ca_OriginalGroundMaterial : 水泥毛坯
             * ca_SecondaryHeight : 3050.00
             * ca_mainBeamHeight : 2985.00
             * ca_SpaceMaxHeight : 3610.00
             * ca_OriginalGround : 否
             * ca_OriginalWallMaterial : 水泥
             * ca_HouseOrientation : 东
             * ca_WeakBoxNum : 1
             * ca_CargoDoorWide :
             * ca_CurtainWallSpacing : 1200.00
             * ca_GroundElevation : 10.00
             */

            private String ca_windowsillHight;
            private String ca_TuyereMinimumHeight;
            private String ca_AirConditionerNum;
            private String ca_MinimumSprayHeight;
            private String ca_WindowType;
            private String dataPercent;
            private String ca_SpaceMinHeight;
            private String ca_OccupyPublicCorridor;
            private String ca_UpWaterSpot;
            private String ca_DownWaterSpot;
            private String ca_OriginalTopMaterial;
            private String ca_WaterPath;
            private String ca_CargoDoorHight;
            private String ca_isGroundSmooth;
            private String ca_WindowHight;
            private String ca_DownWaterSpotSize;
            private String ca_WindowWidth;
            private String ca_StrongBoxNum;
            private String ca_OriginalGroundMaterial;
            private String ca_SecondaryHeight;
            private String ca_mainBeamHeight;
            private String ca_SpaceMaxHeight;
            private String ca_OriginalGround;
            private String ca_OriginalWallMaterial;
            private String ca_HouseOrientation;
            private String ca_WeakBoxNum;
            private String ca_CargoDoorWide;
            private String ca_CurtainWallSpacing;
            private String ca_GroundElevation;

            public String getCa_windowsillHight() {
                return ca_windowsillHight;
            }

            public void setCa_windowsillHight(String ca_windowsillHight) {
                this.ca_windowsillHight = ca_windowsillHight;
            }

            public String getCa_TuyereMinimumHeight() {
                return ca_TuyereMinimumHeight;
            }

            public void setCa_TuyereMinimumHeight(String ca_TuyereMinimumHeight) {
                this.ca_TuyereMinimumHeight = ca_TuyereMinimumHeight;
            }

            public String getCa_AirConditionerNum() {
                return ca_AirConditionerNum;
            }

            public void setCa_AirConditionerNum(String ca_AirConditionerNum) {
                this.ca_AirConditionerNum = ca_AirConditionerNum;
            }

            public String getCa_MinimumSprayHeight() {
                return ca_MinimumSprayHeight;
            }

            public void setCa_MinimumSprayHeight(String ca_MinimumSprayHeight) {
                this.ca_MinimumSprayHeight = ca_MinimumSprayHeight;
            }

            public String getCa_WindowType() {
                return ca_WindowType;
            }

            public void setCa_WindowType(String ca_WindowType) {
                this.ca_WindowType = ca_WindowType;
            }

            public String getDataPercent() {
                return dataPercent;
            }

            public void setDataPercent(String dataPercent) {
                this.dataPercent = dataPercent;
            }

            public String getCa_SpaceMinHeight() {
                return ca_SpaceMinHeight;
            }

            public void setCa_SpaceMinHeight(String ca_SpaceMinHeight) {
                this.ca_SpaceMinHeight = ca_SpaceMinHeight;
            }

            public String getCa_OccupyPublicCorridor() {
                return ca_OccupyPublicCorridor;
            }

            public void setCa_OccupyPublicCorridor(String ca_OccupyPublicCorridor) {
                this.ca_OccupyPublicCorridor = ca_OccupyPublicCorridor;
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

            public String getCa_OriginalTopMaterial() {
                return ca_OriginalTopMaterial;
            }

            public void setCa_OriginalTopMaterial(String ca_OriginalTopMaterial) {
                this.ca_OriginalTopMaterial = ca_OriginalTopMaterial;
            }

            public String getCa_WaterPath() {
                return ca_WaterPath;
            }

            public void setCa_WaterPath(String ca_WaterPath) {
                this.ca_WaterPath = ca_WaterPath;
            }

            public String getCa_CargoDoorHight() {
                return ca_CargoDoorHight;
            }

            public void setCa_CargoDoorHight(String ca_CargoDoorHight) {
                this.ca_CargoDoorHight = ca_CargoDoorHight;
            }

            public String getCa_isGroundSmooth() {
                return ca_isGroundSmooth;
            }

            public void setCa_isGroundSmooth(String ca_isGroundSmooth) {
                this.ca_isGroundSmooth = ca_isGroundSmooth;
            }

            public String getCa_WindowHight() {
                return ca_WindowHight;
            }

            public void setCa_WindowHight(String ca_WindowHight) {
                this.ca_WindowHight = ca_WindowHight;
            }

            public String getCa_DownWaterSpotSize() {
                return ca_DownWaterSpotSize;
            }

            public void setCa_DownWaterSpotSize(String ca_DownWaterSpotSize) {
                this.ca_DownWaterSpotSize = ca_DownWaterSpotSize;
            }

            public String getCa_WindowWidth() {
                return ca_WindowWidth;
            }

            public void setCa_WindowWidth(String ca_WindowWidth) {
                this.ca_WindowWidth = ca_WindowWidth;
            }

            public String getCa_StrongBoxNum() {
                return ca_StrongBoxNum;
            }

            public void setCa_StrongBoxNum(String ca_StrongBoxNum) {
                this.ca_StrongBoxNum = ca_StrongBoxNum;
            }

            public String getCa_OriginalGroundMaterial() {
                return ca_OriginalGroundMaterial;
            }

            public void setCa_OriginalGroundMaterial(String ca_OriginalGroundMaterial) {
                this.ca_OriginalGroundMaterial = ca_OriginalGroundMaterial;
            }

            public String getCa_SecondaryHeight() {
                return ca_SecondaryHeight;
            }

            public void setCa_SecondaryHeight(String ca_SecondaryHeight) {
                this.ca_SecondaryHeight = ca_SecondaryHeight;
            }

            public String getCa_mainBeamHeight() {
                return ca_mainBeamHeight;
            }

            public void setCa_mainBeamHeight(String ca_mainBeamHeight) {
                this.ca_mainBeamHeight = ca_mainBeamHeight;
            }

            public String getCa_SpaceMaxHeight() {
                return ca_SpaceMaxHeight;
            }

            public void setCa_SpaceMaxHeight(String ca_SpaceMaxHeight) {
                this.ca_SpaceMaxHeight = ca_SpaceMaxHeight;
            }

            public String getCa_OriginalGround() {
                return ca_OriginalGround;
            }

            public void setCa_OriginalGround(String ca_OriginalGround) {
                this.ca_OriginalGround = ca_OriginalGround;
            }

            public String getCa_OriginalWallMaterial() {
                return ca_OriginalWallMaterial;
            }

            public void setCa_OriginalWallMaterial(String ca_OriginalWallMaterial) {
                this.ca_OriginalWallMaterial = ca_OriginalWallMaterial;
            }

            public String getCa_HouseOrientation() {
                return ca_HouseOrientation;
            }

            public void setCa_HouseOrientation(String ca_HouseOrientation) {
                this.ca_HouseOrientation = ca_HouseOrientation;
            }

            public String getCa_WeakBoxNum() {
                return ca_WeakBoxNum;
            }

            public void setCa_WeakBoxNum(String ca_WeakBoxNum) {
                this.ca_WeakBoxNum = ca_WeakBoxNum;
            }

            public String getCa_CargoDoorWide() {
                return ca_CargoDoorWide;
            }

            public void setCa_CargoDoorWide(String ca_CargoDoorWide) {
                this.ca_CargoDoorWide = ca_CargoDoorWide;
            }

            public String getCa_CurtainWallSpacing() {
                return ca_CurtainWallSpacing;
            }

            public void setCa_CurtainWallSpacing(String ca_CurtainWallSpacing) {
                this.ca_CurtainWallSpacing = ca_CurtainWallSpacing;
            }

            public String getCa_GroundElevation() {
                return ca_GroundElevation;
            }

            public void setCa_GroundElevation(String ca_GroundElevation) {
                this.ca_GroundElevation = ca_GroundElevation;
            }
        }

        public static class DecorateInformationBean {
            /**
             * ca_DecorationDate : 2018-04-02
             * ca_SpaceRequirement : 有
             * ca_proAttribute : 正常单
             * ca_InviteTenders : 否
             * ca_swRemarks : 武汉私律科技有限公司	田洋	18571676123	A2栋303、304、305号房	579.30武昌区水果湖街汉街中央文化旅游区K3地块第2幢11层8号房
             * ca_FengShuiRequirements : 否
             * ci_advancePayment : 否
             * ci_DecorationAddress : 湖北省武汉市洪山区光谷大道52号长投光谷企业天地A2栋303、304、305号房
             * ca_DecBudgetPrice : 80
             * ca_IntentionalStyle : 现代简约
             * ca_SoftFurniture : 是
             * ca_IntelligentWeakCurrent : 是
             */

            private String ca_DecorationDate;
            private String ca_SpaceRequirement;
            private String ca_proAttribute;
            private String ca_InviteTenders;
            private String ca_swRemarks;
            private String ca_FengShuiRequirements;
            private String ci_advancePayment;
            private String ci_DecorationAddress;
            private String ca_DecBudgetPrice;
            private String ca_IntentionalStyle;
            private String ca_SoftFurniture;
            private String ca_IntelligentWeakCurrent;

            public String getCa_DecorationDate() {
                return ca_DecorationDate;
            }

            public void setCa_DecorationDate(String ca_DecorationDate) {
                this.ca_DecorationDate = ca_DecorationDate;
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

            public String getCa_InviteTenders() {
                return ca_InviteTenders;
            }

            public void setCa_InviteTenders(String ca_InviteTenders) {
                this.ca_InviteTenders = ca_InviteTenders;
            }

            public String getCa_swRemarks() {
                return ca_swRemarks;
            }

            public void setCa_swRemarks(String ca_swRemarks) {
                this.ca_swRemarks = ca_swRemarks;
            }

            public String getCa_FengShuiRequirements() {
                return ca_FengShuiRequirements;
            }

            public void setCa_FengShuiRequirements(String ca_FengShuiRequirements) {
                this.ca_FengShuiRequirements = ca_FengShuiRequirements;
            }

            public String getCi_advancePayment() {
                return ci_advancePayment;
            }

            public void setCi_advancePayment(String ci_advancePayment) {
                this.ci_advancePayment = ci_advancePayment;
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

            public String getCa_IntentionalStyle() {
                return ca_IntentionalStyle;
            }

            public void setCa_IntentionalStyle(String ca_IntentionalStyle) {
                this.ca_IntentionalStyle = ca_IntentionalStyle;
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
        }

        public static class HousingResourcesInformationBean {
            /**
             * ca_AvailabilityStatus : 已定
             * ca_HousingType : 毛坯房
             * ca_RentFreeDate : 无
             * ca_TransactionType : 买
             * ci_Area : 380
             * ca_MeasureDate : 2018-03-15
             * ca_LaunchTime : 2018-03-15
             * ca_Rental : 0.0
             * ci_BuildingArea : 380
             */

            private String ca_AvailabilityStatus;
            private String ca_HousingType;
            private String ca_RentFreeDate;
            private String ca_TransactionType;
            private String ci_Area;
            private String ca_MeasureDate;
            private String ca_LaunchTime;
            private String ca_Rental;
            private String ci_BuildingArea;

            public String getCa_AvailabilityStatus() {
                return ca_AvailabilityStatus;
            }

            public void setCa_AvailabilityStatus(String ca_AvailabilityStatus) {
                this.ca_AvailabilityStatus = ca_AvailabilityStatus;
            }

            public String getCa_HousingType() {
                return ca_HousingType;
            }

            public void setCa_HousingType(String ca_HousingType) {
                this.ca_HousingType = ca_HousingType;
            }

            public String getCa_RentFreeDate() {
                return ca_RentFreeDate;
            }

            public void setCa_RentFreeDate(String ca_RentFreeDate) {
                this.ca_RentFreeDate = ca_RentFreeDate;
            }

            public String getCa_TransactionType() {
                return ca_TransactionType;
            }

            public void setCa_TransactionType(String ca_TransactionType) {
                this.ca_TransactionType = ca_TransactionType;
            }

            public String getCi_Area() {
                return ci_Area;
            }

            public void setCi_Area(String ci_Area) {
                this.ci_Area = ci_Area;
            }

            public String getCa_MeasureDate() {
                return ca_MeasureDate;
            }

            public void setCa_MeasureDate(String ca_MeasureDate) {
                this.ca_MeasureDate = ca_MeasureDate;
            }

            public String getCa_LaunchTime() {
                return ca_LaunchTime;
            }

            public void setCa_LaunchTime(String ca_LaunchTime) {
                this.ca_LaunchTime = ca_LaunchTime;
            }

            public String getCa_Rental() {
                return ca_Rental;
            }

            public void setCa_Rental(String ca_Rental) {
                this.ca_Rental = ca_Rental;
            }

            public String getCi_BuildingArea() {
                return ci_BuildingArea;
            }

            public void setCi_BuildingArea(String ci_BuildingArea) {
                this.ci_BuildingArea = ci_BuildingArea;
            }
        }
    }
}
