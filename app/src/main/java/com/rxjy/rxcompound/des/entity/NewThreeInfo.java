package com.rxjy.rxcompound.des.entity;

/**
 * Created by Administrator on 2017/10/8 0008.
 */

public class NewThreeInfo {

    /**
     * StatusCode : 0
     * StatusMsg : 获取成功
     * Body : {"ca_SpaceRequirement":"","ca_proAttribute":"0","ca_DecBudgetPrice":"12.00","ca_ProjectTime":"","ca_InviteTenders":"","ca_DecorationDate":"--","ci_DecorationAddress":"","ca_IntentionalStyle":"","ca_FengShuiRequirements":"0","ca_SoftFurniture":"0","ca_IntelligentWeakCurrent":"0","ca_proLike":"","ca_swRemarks":"","ca_zaRemarks":""}
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
         * ca_SpaceRequirement :
         * ca_proAttribute : 0
         * ca_DecBudgetPrice : 12.00
         * ca_ProjectTime :
         * ca_InviteTenders :
         * ca_DecorationDate : --
         * ci_DecorationAddress :
         * ca_IntentionalStyle :
         * ca_FengShuiRequirements : 0
         * ca_SoftFurniture : 0
         * ca_IntelligentWeakCurrent : 0
         * ca_proLike :
         * ca_swRemarks :
         * ca_zaRemarks :
         */

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
        private String ca_swRemarks;
        private String ca_zaRemarks;

        public String getCa_SpaceRequirement() {
            return ca_SpaceRequirement;
        }

        public void setCa_SpaceRequirement(String ca_SpaceRequirement) {
            this.ca_SpaceRequirement = ca_SpaceRequirement;
        }

        public String getCa_AuditState() {
            return ca_proAttribute;
        }

        public void setCa_AuditState(String ca_proAttribute) {
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

        public String getCa_swRemarks() {
            return ca_swRemarks;
        }

        public void setCa_swRemarks(String ca_swRemarks) {
            this.ca_swRemarks = ca_swRemarks;
        }

        public String getCa_zaRemarks() {
            return ca_zaRemarks;
        }

        public void setCa_zaRemarks(String ca_zaRemarks) {
            this.ca_zaRemarks = ca_zaRemarks;
        }
    }
}
