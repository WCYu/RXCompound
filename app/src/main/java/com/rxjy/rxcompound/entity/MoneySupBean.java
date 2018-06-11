package com.rxjy.rxcompound.entity;

import java.math.BigDecimal;

/**
 * Created by hjh on 2018/3/5.
 */

public class MoneySupBean {

    private int StatusCode;
    private String StatusMsg;
    private BodyBean Body;

    public MoneySupBean() {
        super();
    }

    @Override
    public String toString() {
        return "MoneySupBean{" +
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
//         "basePay":0,
//                 "performance":0,
//                 "salaryTotal":0,
//                 "startCommission":0,
//                 "finishCommission":0,
//                 "performanceTotal":0,
//                 "gain":0,
//                 "fine":0,
//                 "eventTotal":0,
//                 "gainCommission":0,
//                 "fineCommission":0,
//                 "revenue":0,
//                 "socialSecurity":0,
//                 "housingFund":0

        private String basePay;
        private String performance;
        private String salaryTotal;
        private String startCommission;
        private String finishCommission;
        private BigDecimal performanceTotal;
        private String gain;
        private String fine;
        private String eventTotal;
        private String gainCommission;
        private String fineCommission;
        private BigDecimal revenue;
        private BigDecimal socialSecurity;
        private BigDecimal housingFund;

        public BodyBean() {
            super();
        }

        @Override
        public String toString() {
            return "BodyBean{" +
                    "basePay='" + basePay + '\'' +
                    ", performance='" + performance + '\'' +
                    ", salaryTotal='" + salaryTotal + '\'' +
                    ", startCommission='" + startCommission + '\'' +
                    ", finishCommission='" + finishCommission + '\'' +
                    ", performanceTotal='" + performanceTotal + '\'' +
                    ", gain='" + gain + '\'' +
                    ", fine='" + fine + '\'' +
                    ", eventTotal='" + eventTotal + '\'' +
                    ", gainCommission='" + gainCommission + '\'' +
                    ", fineCommission='" + fineCommission + '\'' +
                    ", revenue='" + revenue + '\'' +
                    ", socialSecurity='" + socialSecurity + '\'' +
                    ", housingFund='" + housingFund + '\'' +
                    '}';
        }

        public String getBasePay() {
            return basePay;
        }

        public void setBasePay(String basePay) {
            this.basePay = basePay;
        }

        public String getPerformance() {
            return performance;
        }

        public void setPerformance(String performance) {
            this.performance = performance;
        }

        public String getSalaryTotal() {
            return salaryTotal;
        }

        public void setSalaryTotal(String salaryTotal) {
            this.salaryTotal = salaryTotal;
        }

        public String getStartCommission() {
            return startCommission;
        }

        public void setStartCommission(String startCommission) {
            this.startCommission = startCommission;
        }

        public String getFinishCommission() {
            return finishCommission;
        }

        public void setFinishCommission(String finishCommission) {
            this.finishCommission = finishCommission;
        }

        public BigDecimal getPerformanceTotal() {
            return performanceTotal;
        }

        public void setPerformanceTotal(BigDecimal performanceTotal) {
            this.performanceTotal = performanceTotal;
        }

        public String getGain() {
            return gain;
        }

        public void setGain(String gain) {
            this.gain = gain;
        }

        public String getFine() {
            return fine;
        }

        public void setFine(String fine) {
            this.fine = fine;
        }

        public String getEventTotal() {
            return eventTotal;
        }

        public void setEventTotal(String eventTotal) {
            this.eventTotal = eventTotal;
        }

        public String getGainCommission() {
            return gainCommission;
        }

        public void setGainCommission(String gainCommission) {
            this.gainCommission = gainCommission;
        }

        public String getFineCommission() {
            return fineCommission;
        }

        public void setFineCommission(String fineCommission) {
            this.fineCommission = fineCommission;
        }

        public BigDecimal getRevenue() {
            return revenue;
        }

        public void setRevenue(BigDecimal revenue) {
            this.revenue = revenue;
        }

        public BigDecimal getSocialSecurity() {
            return socialSecurity;
        }

        public void setSocialSecurity(BigDecimal socialSecurity) {
            this.socialSecurity = socialSecurity;
        }

        public BigDecimal getHousingFund() {
            return housingFund;
        }

        public void setHousingFund(BigDecimal housingFund) {
            this.housingFund = housingFund;
        }
    }

}
