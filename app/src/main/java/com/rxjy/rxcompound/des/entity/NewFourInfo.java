package com.rxjy.rxcompound.des.entity;

/**
 * Created by Administrator on 2017/10/8 0008.
 */

public class NewFourInfo {

    /**
     * StatusCode : 0
     * StatusMsg : 获取成功
     * Body : {"ca_ReqConTime":"晚上","ca_ProductProtection":"是","ca_PropertyInsurance":"否","ca_DesignatedFireCompany":"1","ca_DesignatedAirCompany":"2","ca_DesignatedSinotrans":"1","ca_Blueprint":"白图","ca_ProtectiveMaterial":"彩钢板","ca_SpecialRequirements":"","ca_Elevator":"禁用"}
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
         * ca_ReqConTime : 晚上
         * ca_ProductProtection : 是
         * ca_PropertyInsurance : 否
         * ca_DesignatedFireCompany : 1
         * ca_DesignatedAirCompany : 2
         * ca_DesignatedSinotrans : 1
         * ca_Blueprint : 白图
         * ca_ProtectiveMaterial : 彩钢板
         * ca_SpecialRequirements :
         * ca_LeadName负责人姓名，
         * ca_TwoManagerTel二装经理电话，
         * ca_Maintenance空调消防维保单位，
         * ca_Aptitude资质要求，
         * ca_DrawAudit图纸审核，
         */

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

        public String getCa_SpecialRequirements() {
            return ca_SpecialRequirement;
        }

        public void setCa_SpecialRequirements(String ca_SpecialRequirement) {
            this.ca_SpecialRequirement = ca_SpecialRequirement;
        }

        public String getCa_Elevator() {
            return ca_Elevator;
        }

        public void setCa_Elevator(String ca_Elevator) {
            this.ca_Elevator = ca_Elevator;
        }
    }
}
