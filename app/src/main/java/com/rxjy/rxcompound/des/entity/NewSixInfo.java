package com.rxjy.rxcompound.des.entity;

/**
 * Created by Administrator on 2017/10/9 0009.
 */

public class NewSixInfo {

    /**
     * StatusCode : 0
     * StatusMsg : 获取成功
     * Body : {"ca_HousingType":"6","ca_AvailabilityStatus":"1","ci_Area":"300.00","ca_TransactionType":"1","ca_RentFreeDate":"2","ca_LaunchTime":"2017-09-29","ca_MeasureDate":"2017-09-29"}
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
         * ca_HousingType : 6
         * ca_AvailabilityStatus : 1
         * ci_Area : 300.00
         * ca_TransactionType : 1
         * ca_RentFreeDate : 2
         * ca_LaunchTime : 2017-09-29
         * ca_MeasureDate : 2017-09-29
         */

        private String ca_HousingType;
        private String ca_AvailabilityStatus;
        private String ci_Area;
        private String ca_TransactionType;
        private String ca_RentFreeDate;
        private String ca_LaunchTime;
        private String ca_MeasureDate;

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
    }
}
