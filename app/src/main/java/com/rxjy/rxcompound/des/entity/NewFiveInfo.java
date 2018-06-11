package com.rxjy.rxcompound.des.entity;

/**
 * Created by Administrator on 2017/10/9 0009.
 */

public class NewFiveInfo {

    /**
     * StatusCode : 0
     * StatusMsg : 获取成功
     * Body : {"ci_ClientName":"北京京通赤那思","ci_Type":"2","ca_SWIndustryTypeID":"95","ca_HangYeLeIXing":"0","ci_OfficeAddress":"","ca_LeaseTermStart":"2017-10-11","ca_LeaseTermEnd":"2017-10-21"}
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
         * ci_ClientName : 北京京通赤那思
         * ci_Type : 2
         * ca_SWIndustryTypeID : 95
         * ca_HangYeLeIXing : 0
         * ci_OfficeAddress :
         * ca_LeaseTermStart : 2017-10-11
         * ca_LeaseTermEnd : 2017-10-21
         */

        private String ci_ClientName;
        private String ci_Type;
        private String ca_SWIndustryTypeID;
        private String ca_HangYeLeIXing;
        private String ci_OfficeAddress;
        private String ca_LeaseTermStart;
        private String ca_LeaseTermEnd;

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
    }
}
