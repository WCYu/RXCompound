package com.rxjy.rxcompound.entity;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by hjh on 2018/3/15.
 */

public class MoneyDTzFenhongBean {

    private int StatusCode;
    private String StatusMsg;
    private ArrayList<BodyBean> Body;

    public MoneyDTzFenhongBean() {
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

    public class BodyBean{
        private String time;
        private String money;
        private int precent;
        private BigDecimal fenHong;

        public BodyBean() {
            super();
        }

        @Override
        public String toString() {
            return "BodyBean{" +
                    "time='" + time + '\'' +
                    ", money='" + money + '\'' +
                    ", precent=" + precent +
                    ", fenHong=" + fenHong +
                    '}';
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getMoney() {
            return money;
        }

        public void setMoney(String money) {
            this.money = money;
        }

        public int getPrecent() {
            return precent;
        }

        public void setPrecent(int precent) {
            this.precent = precent;
        }

        public BigDecimal getFenHong() {
            return fenHong;
        }

        public void setFenHong(BigDecimal fenHong) {
            this.fenHong = fenHong;
        }
    }
}
