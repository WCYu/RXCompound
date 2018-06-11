package com.rxjy.rxcompound.entity;

import java.math.BigDecimal;

/**
 * Created by hjh on 2018/3/5.
 */

public class MoneyBusBean {

    private int StatusCode;
    private String StatusMsg;
    private BodyBean Body;

    public MoneyBusBean() {
        super();
    }

    @Override
    public String toString() {
        return "MoneyBusBean{" +
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
//        "preThreeMonth":8511.84,
//                "incomeStatus":"收入中",
//                "totalIncome":3000,
//                "resultIncome":0,
//                "processIncome":0,
//                "subSidyMoney":3000,
//                "performanceIncome":0,
//                "sanctionIncome":0,
//                "executeXjReward":0,
//                "sanctionTotalIncome":0,
//                "salary":3000,
//                "acturalIncome":3000,
//                "tiCheng":0,
//                "sheBao":0,
//                "gongJiJin":0
        private String preMonth;
        private String preThreeMonth;
        private String incomeStatus;
        private String totalIncome;
        private String resultIncome;
        private String processIncome;
        private String subSidyMoney;
        private String performanceIncome;
        private String sanctionIncome;
        private String executeXjReward;
        private String sanctionTotalIncome;
        private String salary;
        private String acturalIncome;
        private String tiCheng;
        private BigDecimal sheBao;
        private BigDecimal gongJiJin;

        public BodyBean() {
            super();
        }

        @Override
        public String toString() {
            return "BodyBean{" +
                    "preMonth='" + preMonth + '\'' +
                    ", preThreeMonth='" + preThreeMonth + '\'' +
                    ", incomeStatus='" + incomeStatus + '\'' +
                    ", totalIncome='" + totalIncome + '\'' +
                    ", resultIncome='" + resultIncome + '\'' +
                    ", processIncome='" + processIncome + '\'' +
                    ", subSidyMoney='" + subSidyMoney + '\'' +
                    ", performanceIncome='" + performanceIncome + '\'' +
                    ", sanctionIncome='" + sanctionIncome + '\'' +
                    ", executeXjReward='" + executeXjReward + '\'' +
                    ", sanctionTotalIncome='" + sanctionTotalIncome + '\'' +
                    ", salary='" + salary + '\'' +
                    ", acturalIncome='" + acturalIncome + '\'' +
                    ", tiCheng='" + tiCheng + '\'' +
                    ", sheBao='" + sheBao + '\'' +
                    ", gongJiJin='" + gongJiJin + '\'' +
                    '}';
        }

        public String getPreMonth() {
            return preMonth;
        }

        public void setPreMonth(String preMonth) {
            this.preMonth = preMonth;
        }

        public String getPreThreeMonth() {
            return preThreeMonth;
        }

        public void setPreThreeMonth(String preThreeMonth) {
            this.preThreeMonth = preThreeMonth;
        }

        public String getIncomeStatus() {
            return incomeStatus;
        }

        public void setIncomeStatus(String incomeStatus) {
            this.incomeStatus = incomeStatus;
        }

        public String getTotalIncome() {
            return totalIncome;
        }

        public void setTotalIncome(String totalIncome) {
            this.totalIncome = totalIncome;
        }

        public String getResultIncome() {
            return resultIncome;
        }

        public void setResultIncome(String resultIncome) {
            this.resultIncome = resultIncome;
        }

        public String getProcessIncome() {
            return processIncome;
        }

        public void setProcessIncome(String processIncome) {
            this.processIncome = processIncome;
        }

        public String getSubSidyMoney() {
            return subSidyMoney;
        }

        public void setSubSidyMoney(String subSidyMoney) {
            this.subSidyMoney = subSidyMoney;
        }

        public String getPerformanceIncome() {
            return performanceIncome;
        }

        public void setPerformanceIncome(String performanceIncome) {
            this.performanceIncome = performanceIncome;
        }

        public String getSanctionIncome() {
            return sanctionIncome;
        }

        public void setSanctionIncome(String sanctionIncome) {
            this.sanctionIncome = sanctionIncome;
        }

        public String getExecuteXjReward() {
            return executeXjReward;
        }

        public void setExecuteXjReward(String executeXjReward) {
            this.executeXjReward = executeXjReward;
        }

        public String getSanctionTotalIncome() {
            return sanctionTotalIncome;
        }

        public void setSanctionTotalIncome(String sanctionTotalIncome) {
            this.sanctionTotalIncome = sanctionTotalIncome;
        }

        public String getSalary() {
            return salary;
        }

        public void setSalary(String salary) {
            this.salary = salary;
        }

        public String getActuralIncome() {
            return acturalIncome;
        }

        public void setActuralIncome(String acturalIncome) {
            this.acturalIncome = acturalIncome;
        }

        public String getTiCheng() {
            return tiCheng;
        }

        public void setTiCheng(String tiCheng) {
            this.tiCheng = tiCheng;
        }

        public BigDecimal getSheBao() {
            return sheBao;
        }

        public void setSheBao(BigDecimal sheBao) {
            this.sheBao = sheBao;
        }

        public BigDecimal getGongJiJin() {
            return gongJiJin;
        }

        public void setGongJiJin(BigDecimal gongJiJin) {
            this.gongJiJin = gongJiJin;
        }
    }

}
