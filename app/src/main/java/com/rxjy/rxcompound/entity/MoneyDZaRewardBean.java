package com.rxjy.rxcompound.entity;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by hjh on 2018/3/16.
 */

public class MoneyDZaRewardBean {

    private int StatusCode;
    private String StatusMsg;
    private ArrayList<BodyBean> Body;

    public MoneyDZaRewardBean() {
        super();
    }

    @Override
    public String toString() {
        return "MoneyDTzFenhongBean{" +
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

    public ArrayList<BodyBean> getBody() {
        return Body;
    }

    public void setBody(ArrayList<BodyBean> body) {
        Body = body;
    }

    public class BodyBean {

        private BigDecimal rpActualMoney;
        private String rpupdateTime;
        private String rpRemarks;
        private String rpSponsorName;

        public BodyBean() {
            super();
        }

        @Override
        public String toString() {
            return "BodyBean{" +
                    "rpActualMoney=" + rpActualMoney +
                    ", rpupdateTime='" + rpupdateTime + '\'' +
                    ", rpRemarks='" + rpRemarks + '\'' +
                    ", rpSponsorName='" + rpSponsorName + '\'' +
                    '}';
        }

        public BigDecimal getRpActualMoney() {
            return rpActualMoney;
        }

        public void setRpActualMoney(BigDecimal rpActualMoney) {
            this.rpActualMoney = rpActualMoney;
        }

        public String getRpupdateTime() {
            return rpupdateTime;
        }

        public void setRpupdateTime(String rpupdateTime) {
            this.rpupdateTime = rpupdateTime;
        }

        public String getRpRemarks() {
            return rpRemarks;
        }

        public void setRpRemarks(String rpRemarks) {
            this.rpRemarks = rpRemarks;
        }

        public String getRpSponsorName() {
            return rpSponsorName;
        }

        public void setRpSponsorName(String rpSponsorName) {
            this.rpSponsorName = rpSponsorName;
        }
    }

}
