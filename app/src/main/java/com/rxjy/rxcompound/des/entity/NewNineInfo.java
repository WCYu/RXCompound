package com.rxjy.rxcompound.des.entity;

/**
 * Created by Administrator on 2017/10/9 0009.
 */

public class NewNineInfo {

    /**
     * StatusCode : 0
     * StatusMsg : 获取成功
     * Body : {"ca_EnterpriseNature":"其他","ca_EnterprisesScale":"办公","ca_EstablishmentTime":"2017-10-10","ca_ForeignEnterprises":"是","ca_BusinessScope":"","ca_CorporateCulture":""}
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
         * ca_EnterpriseNature : 其他
         * ca_EnterprisesScale : 办公
         * ca_EstablishmentTime : 2017-10-10
         * ca_ForeignEnterprises : 是
         * ca_BusinessScope :
         * ca_CorporateCulture :
         */

        private String ca_EnterpriseNature;
        private String ca_EnterprisesScale;
        private String ca_EstablishmentTime;
        private String ca_ForeignEnterprises;
        private String ca_BusinessScope;
        private String ca_CorporateCulture;

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
    }
}
