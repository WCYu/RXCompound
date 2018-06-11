package com.rxjy.rxcompound.entity;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by hjh on 2018/3/14.
 */

public class BusMoneyBean {

    private int StatusCode;
    private String StatusMsg;
    private ArrayList<BodyBean> Body;

    public BusMoneyBean() {super();
    }

    @Override
    public String toString() {
        return "BusMoneyBean{" +
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

    public class BodyBean{
        private String ctime;
        private String reason;
        private String remark;
        private BigDecimal subSidyMoney;

        public BodyBean() {
            super();
        }

        @Override
        public String toString() {
            return "BodyBean{" +
                    "ctime='" + ctime + '\'' +
                    ", reason='" + reason + '\'' +
                    ", remark='" + remark + '\'' +
                    ", subSidyMoney='" + subSidyMoney + '\'' +
                    '}';
        }

        public String getCtime() {
            return ctime;
        }

        public void setCtime(String ctime) {
            this.ctime = ctime;
        }

        public String getReason() {
            return reason;
        }

        public void setReason(String reason) {
            this.reason = reason;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public BigDecimal getSubSidyMoney() {
            return subSidyMoney;
        }

        public void setSubSidyMoney(BigDecimal subSidyMoney) {
            this.subSidyMoney = subSidyMoney;
        }
    }

}