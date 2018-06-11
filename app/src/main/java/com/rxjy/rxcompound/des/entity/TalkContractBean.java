package com.rxjy.rxcompound.des.entity;

/**
 * Created by Administrator on 2018/5/15.
 */

public class TalkContractBean {

//        "ca_DesignatedFireCompany":"是",...............................
//        "ca_Blueprint":"白图",......................
//        "ca_HtAuditingCycle":"",.........................
//        "ca_HtBlowdownPrice":"",..........................
//        "ca_HtDeposit":"",.......................
//        "ca_DesignatedAirCompany":"否",...............
//        "ca_HtManagePrice":"",........................
//        "ca_ProductProtection":"是",......................
//        "ca_ReqConTime":"晚上",............................
//        "ca_HtRiskPrice":"",............................
//        "ca_HtHydropowerPrice":"".......................
//
//        "ca_HtWorkCycle":"",.....................
//        "ca_HtPayProportion":"",...........................
//        "ca_HtSignDate":"".....................


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

    public class BodyBean {
        private ProporBean propertyInformation;
        private ContracBean contractInfomationPojo;

        public ProporBean getPropertyInformation() {
            return propertyInformation;
        }

        public void setPropertyInformation(ProporBean propertyInformation) {
            this.propertyInformation = propertyInformation;
        }

        public ContracBean getContractInfomationPojo() {
            return contractInfomationPojo;
        }

        public void setContractInfomationPojo(ContracBean contractInfomationPojo) {
            this.contractInfomationPojo = contractInfomationPojo;
        }

        public  class ProporBean{
            private String ca_DesignatedFireCompany;
            private String ca_Blueprint;
            private String ca_HtAuditingCycle;
            private String ca_HtBlowdownPrice;
            private String ca_HtDeposit;
            private String ca_DesignatedAirCompany;
            private String ca_HtManagePrice;
            private String ca_ProductProtection;
            private String ca_ReqConTime;
            private String ca_HtRiskPrice;
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

            public String getCa_HtAuditingCycle() {
                return ca_HtAuditingCycle;
            }

            public void setCa_HtAuditingCycle(String ca_HtAuditingCycle) {
                this.ca_HtAuditingCycle = ca_HtAuditingCycle;
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

            public String getCa_HtHydropowerPrice() {
                return ca_HtHydropowerPrice;
            }

            public void setCa_HtHydropowerPrice(String ca_HtHydropowerPrice) {
                this.ca_HtHydropowerPrice = ca_HtHydropowerPrice;
            }
        }

        public class ContracBean{

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

    }

}
