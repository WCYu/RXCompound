package com.rxjy.rxcompound.entity;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by hjh on 2018/3/16.
 */

public class MoneyDZaProcessBean {//主案过程

    private int StatusCode;
    private String StatusMsg;
    private ArrayList<BodyBean> Body;

    public MoneyDZaProcessBean() {
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

//        "result":"未签",
//                　　　　　　"budgetIncome":0,
//                　　　　　　"programmeIncome":0,
//                　　　　　　"orderIncome":0,
//                　　　　　　"contractIncome":0,
//                　　　　　　"alreadyPaid":927.5,
//                　　　　　　"shouldPaid":280,
//                　　　　　　"ordersPreCollection":3500,
//                　　　　　　"negotiateIncome":280,
//                　　　　　　"processSubsidy":0


        private BigDecimal ordersPreCollection;//预收
        private BigDecimal shouldPaid;//本月
        private BigDecimal alreadyPaid;//已收
        private BigDecimal orderIncome;//接单
        private BigDecimal programmeIncome;//方案
        private BigDecimal negotiateIncome;//洽谈
        private BigDecimal budgetIncome;//预算
        private BigDecimal contractIncome;//合同
        private BigDecimal processSubsidy;//绩效
        private String ci_ClientName;
        private String result;//状态


        public BodyBean() {super();
        }

        @Override
        public String toString() {
            return "BodyBean{" +
                    "ordersPreCollection=" + ordersPreCollection +
                    ", shouldPaid=" + shouldPaid +
                    ", alreadyPaid=" + alreadyPaid +
                    ", orderIncome=" + orderIncome +
                    ", programmeIncome=" + programmeIncome +
                    ", negotiateIncome=" + negotiateIncome +
                    ", budgetIncome=" + budgetIncome +
                    ", contractIncome=" + contractIncome +
                    ", processSubsidy=" + processSubsidy +
                    ", clientName='" + ci_ClientName + '\'' +
                    ", result='" + result + '\'' +
                    '}';
        }

        public BigDecimal getOrdersPreCollection() {
            return ordersPreCollection;
        }

        public void setOrdersPreCollection(BigDecimal ordersPreCollection) {
            this.ordersPreCollection = ordersPreCollection;
        }

        public BigDecimal getShouldPaid() {
            return shouldPaid;
        }

        public void setShouldPaid(BigDecimal shouldPaid) {
            this.shouldPaid = shouldPaid;
        }

        public BigDecimal getAlreadyPaid() {
            return alreadyPaid;
        }

        public void setAlreadyPaid(BigDecimal alreadyPaid) {
            this.alreadyPaid = alreadyPaid;
        }

        public BigDecimal getOrderIncome() {
            return orderIncome;
        }

        public void setOrderIncome(BigDecimal orderIncome) {
            this.orderIncome = orderIncome;
        }

        public BigDecimal getProgrammeIncome() {
            return programmeIncome;
        }

        public void setProgrammeIncome(BigDecimal programmeIncome) {
            this.programmeIncome = programmeIncome;
        }

        public BigDecimal getNegotiateIncome() {
            return negotiateIncome;
        }

        public void setNegotiateIncome(BigDecimal negotiateIncome) {
            this.negotiateIncome = negotiateIncome;
        }

        public BigDecimal getBudgetIncome() {
            return budgetIncome;
        }

        public void setBudgetIncome(BigDecimal budgetIncome) {
            this.budgetIncome = budgetIncome;
        }

        public BigDecimal getContractIncome() {
            return contractIncome;
        }

        public void setContractIncome(BigDecimal contractIncome) {
            this.contractIncome = contractIncome;
        }

        public BigDecimal getProcessSubsidy() {
            return processSubsidy;
        }

        public void setProcessSubsidy(BigDecimal processSubsidy) {
            this.processSubsidy = processSubsidy;
        }

        public String getClientName() {
            return ci_ClientName;
        }

        public void setClientName(String clientName) {
            this.ci_ClientName = clientName;
        }

        public String getResult() {
            return result;
        }

        public void setResult(String result) {
            this.result = result;
        }
    }


}