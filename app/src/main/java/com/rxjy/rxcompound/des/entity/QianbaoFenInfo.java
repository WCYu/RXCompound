package com.rxjy.rxcompound.des.entity;

import java.util.List;

/**
 * Created by Administrator on 2017/9/26.
 */

public class QianbaoFenInfo {

    /**
     * StatusCode : 0
     * StatusMsg : 操作成功
     * Body : [{"RK":1,"RL":2,"CardNo":"01000068","Rwdid":"12-198009","Points":10,"Income":175,"TimeNum":1505999116,"cliType":"接单","CreateTime":"2017-09-21 21:05 :16"},{"RK":2,"RL":2,"CardNo":"01000068","Rwdid":"12-197814","Points":9,"Income":157.5,"TimeNum":1505448321,"cliType":"接单","CreateTime":"2017-09-15 12:05 :21"}]
     */

    private int StatusCode;
    private String StatusMsg;
    private List<BodyBean> Body;

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

    public List<BodyBean> getBody() {
        return Body;
    }

    public void setBody(List<BodyBean> Body) {
        this.Body = Body;
    }

    public static class BodyBean {
        /**
         * RK : 1
         * RL : 2
         * CardNo : 01000068
         * Rwdid : 12-198009
         * Points : 10
         * Income : 175.0
         * TimeNum : 1505999116
         * cliType : 接单
         * CreateTime : 2017-09-21 21:05 :16
         */

        private int RK;
        private int RL;
        private String CardNo;
        private String Rwdid;
        private int Points;
        private double Income;
        private int TimeNum;
        private String cliType;
        private String CreateTime;

        public int getRK() {
            return RK;
        }

        public void setRK(int RK) {
            this.RK = RK;
        }

        public int getRL() {
            return RL;
        }

        public void setRL(int RL) {
            this.RL = RL;
        }

        public String getCardNo() {
            return CardNo;
        }

        public void setCardNo(String CardNo) {
            this.CardNo = CardNo;
        }

        public String getRwdid() {
            return Rwdid;
        }

        public void setRwdid(String Rwdid) {
            this.Rwdid = Rwdid;
        }

        public int getPoints() {
            return Points;
        }

        public void setPoints(int Points) {
            this.Points = Points;
        }

        public double getIncome() {
            return Income;
        }

        public void setIncome(double Income) {
            this.Income = Income;
        }

        public int getTimeNum() {
            return TimeNum;
        }

        public void setTimeNum(int TimeNum) {
            this.TimeNum = TimeNum;
        }

        public String getCliType() {
            return cliType;
        }

        public void setCliType(String cliType) {
            this.cliType = cliType;
        }

        public String getCreateTime() {
            return CreateTime;
        }

        public void setCreateTime(String CreateTime) {
            this.CreateTime = CreateTime;
        }
    }
}
