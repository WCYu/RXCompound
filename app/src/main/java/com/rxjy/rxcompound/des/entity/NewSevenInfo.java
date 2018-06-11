package com.rxjy.rxcompound.des.entity;

/**
 * Created by Administrator on 2017/10/9 0009.
 */

public class NewSevenInfo {
    /**
     * StatusCode : 0
     * StatusMsg : 获取成功
     * Body : {"ca_RealEstate":"楼盘名称","ca_RealEstatePeriod":"期座","ca_DevelopmentFloor":"楼层","ca_HouseNumber":"门牌号"}
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
         * ca_RealEstate : 楼盘名称
         * ca_RealEstatePeriod : 期座
         * ca_DevelopmentFloor : 楼层
         * ca_HouseNumber : 门牌号
         */

        private String ca_RealEstate;
        private String ca_RealEstatePeriod;
        private String ca_DevelopmentFloor;
        private String ca_HouseNumber;

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
    }
}
