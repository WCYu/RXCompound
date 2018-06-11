package com.rxjy.rxcompound.entity;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by hjh on 2018/3/16.
 */

public class MoneyDZaResultBean {

    private int StatusCode;
    private String StatusMsg;
    private ArrayList<BodyBean> Body;

    public MoneyDZaResultBean() {
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
//        rwdId":"25-69858",
//                "clientName":"互联网软件设计公司",
//                "ordersPreCollection":2500,
//                "alreadyPay":2500,
//                "monthShouldPaid":0
        private String clientName;
        private BigDecimal ordersPreCollection;
        private BigDecimal alreadyPay;
        private BigDecimal monthShouldPaid;

        public BodyBean() {super();
        }

        @Override
        public String toString() {
            return "BodyBean{" +
                    "clientName='" + clientName + '\'' +
                    ", ordersPreCollection=" + ordersPreCollection +
                    ", alreadyPay=" + alreadyPay +
                    ", monthShouldPaid=" + monthShouldPaid +
                    '}';
        }

        public String getClientName() {
            return clientName;
        }

        public void setClientName(String clientName) {
            this.clientName = clientName;
        }

        public BigDecimal getOrdersPreCollection() {
            return ordersPreCollection;
        }

        public void setOrdersPreCollection(BigDecimal ordersPreCollection) {
            this.ordersPreCollection = ordersPreCollection;
        }

        public BigDecimal getAlreadyPay() {
            return alreadyPay;
        }

        public void setAlreadyPay(BigDecimal alreadyPay) {
            this.alreadyPay = alreadyPay;
        }

        public BigDecimal getMonthShouldPaid() {
            return monthShouldPaid;
        }

        public void setMonthShouldPaid(BigDecimal monthShouldPaid) {
            this.monthShouldPaid = monthShouldPaid;
        }
    }

}
