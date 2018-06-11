package com.rxjy.rxcompound.entity;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by hjh on 2018/3/16.
 */

public class MoneyBusRewardBean {

    private int StatusCode;
    private String StatusMsg;
    private ArrayList<BodyBean> Body;

    public MoneyBusRewardBean() {super();
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
//        "lfTotalCount":0,
//                "lfTotalReward":0,
//                "lfCount":0,
//                "lfReward":0,
//                "eventCount":0,
//                "eventReward":0,
//                "executeGzCount":0,
//                "executeGzReward":0,
//                "executeXjCount":0,
//                "executeXjReward":0,
//                "jtReward":0,
//                "jtCount":0,
//                "totalCount":0,
//                "totalMoney":0
        private int lfTotalCount;
        private int executeGzCount;
        private int executeXjCount;
        private int jtCount;
        private int totalCount;
        private int lfCount;
        private int eventCount;
        private BigDecimal lfTotalReward;
        private BigDecimal lfReward;
        private BigDecimal eventReward;
        private BigDecimal executeGzReward;
        private BigDecimal executeXjReward;
        private BigDecimal jtReward;
        private BigDecimal totalMoney;

        public BodyBean() {
            super();
        }

        @Override
        public String toString() {
            return "BodyBean{" +
                    "lfTotalCount=" + lfTotalCount +
                    ", executeGzCount=" + executeGzCount +
                    ", executeXjCount=" + executeXjCount +
                    ", jtCount=" + jtCount +
                    ", totalCount=" + totalCount +
                    ", lfCount=" + lfCount +
                    ", eventCount=" + eventCount +
                    ", lfTotalReward=" + lfTotalReward +
                    ", lfReward=" + lfReward +
                    ", eventReward=" + eventReward +
                    ", executeGzReward=" + executeGzReward +
                    ", executeXjReward=" + executeXjReward +
                    ", jtReward=" + jtReward +
                    ", totalMoney=" + totalMoney +
                    '}';
        }

        public int getLfTotalCount() {
            return lfTotalCount;
        }

        public void setLfTotalCount(int lfTotalCount) {
            this.lfTotalCount = lfTotalCount;
        }

        public int getExecuteGzCount() {
            return executeGzCount;
        }

        public void setExecuteGzCount(int executeGzCount) {
            this.executeGzCount = executeGzCount;
        }

        public int getExecuteXjCount() {
            return executeXjCount;
        }

        public void setExecuteXjCount(int executeXjCount) {
            this.executeXjCount = executeXjCount;
        }

        public int getJtCount() {
            return jtCount;
        }

        public void setJtCount(int jtCount) {
            this.jtCount = jtCount;
        }

        public int getTotalCount() {
            return totalCount;
        }

        public void setTotalCount(int totalCount) {
            this.totalCount = totalCount;
        }

        public int getLfCount() {
            return lfCount;
        }

        public void setLfCount(int lfCount) {
            this.lfCount = lfCount;
        }

        public int getEventCount() {
            return eventCount;
        }

        public void setEventCount(int eventCount) {
            this.eventCount = eventCount;
        }

        public BigDecimal getLfTotalReward() {
            return lfTotalReward;
        }

        public void setLfTotalReward(BigDecimal lfTotalReward) {
            this.lfTotalReward = lfTotalReward;
        }

        public BigDecimal getLfReward() {
            return lfReward;
        }

        public void setLfReward(BigDecimal lfReward) {
            this.lfReward = lfReward;
        }

        public BigDecimal getEventReward() {
            return eventReward;
        }

        public void setEventReward(BigDecimal eventReward) {
            this.eventReward = eventReward;
        }

        public BigDecimal getExecuteGzReward() {
            return executeGzReward;
        }

        public void setExecuteGzReward(BigDecimal executeGzReward) {
            this.executeGzReward = executeGzReward;
        }

        public BigDecimal getExecuteXjReward() {
            return executeXjReward;
        }

        public void setExecuteXjReward(BigDecimal executeXjReward) {
            this.executeXjReward = executeXjReward;
        }

        public BigDecimal getJtReward() {
            return jtReward;
        }

        public void setJtReward(BigDecimal jtReward) {
            this.jtReward = jtReward;
        }

        public BigDecimal getTotalMoney() {
            return totalMoney;
        }

        public void setTotalMoney(BigDecimal totalMoney) {
            this.totalMoney = totalMoney;
        }
    }

}
