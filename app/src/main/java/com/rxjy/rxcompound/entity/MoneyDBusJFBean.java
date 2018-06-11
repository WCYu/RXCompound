package com.rxjy.rxcompound.entity;

import java.math.BigDecimal;

/**
 * Created by hjh on 2018/4/11.
 */

public class MoneyDBusJFBean {
    private int StatusCode;
    private String StatusMsg;
    private BodyBean Body;

    public MoneyDBusJFBean() {
        super();
    }

    @Override
    public String toString() {
        return "MoneyDBusJFBean{" +
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

    public BodyBean getBody() {
        return Body;
    }

    public void setBody(BodyBean body) {
        Body = body;
    }

    public class BodyBean{
//        "queQinDay":20,
//                　　　　"queQinMoney":7272.73,
//                　　　　"subsidymoney":8000
        private int queQinDay;
        private BigDecimal queQinMoney;
        private BigDecimal subsidymoney;

        public BodyBean() {
            super();
        }

        public int getQueQinDay() {
            return queQinDay;
        }

        public void setQueQinDay(int queQinDay) {
            this.queQinDay = queQinDay;
        }

        public BigDecimal getQueQinMoney() {
            return queQinMoney;
        }

        public void setQueQinMoney(BigDecimal queQinMoney) {
            this.queQinMoney = queQinMoney;
        }

        public BigDecimal getSubsidymoney() {
            return subsidymoney;
        }

        public void setSubsidymoney(BigDecimal subsidymoney) {
            this.subsidymoney = subsidymoney;
        }

        @Override
        public String toString() {
            return "BodyBean{" +
                    "queQinDay=" + queQinDay +
                    ", queQinMoney='" + queQinMoney + '\'' +
                    ", subsidymoney='" + subsidymoney + '\'' +
                    '}';
        }
    }
}
