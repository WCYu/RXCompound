package com.rxjy.rxcompound.entity;

import java.math.BigDecimal;

/**
 * Created by hjh on 2018/3/15.
 */

public class MoneyDTzResultBean {

    private int StatusCode;
    private String StatusMsg;
    private BodyBean Body;

    public MoneyDTzResultBean() {
        super();
    }

    @Override
    public String toString() {
        return "MoneyDTzResultBean{" +
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
//        sgqdBz1":2600000,
//                "sgqdMoney":918833.91,
//                "sgqdGongzi":0,
//                "swlrNum":14,
//                "swlrBz":10,
//                "swlrDanjia":200,
//                "swlrGongzi":800,
//                "jiajuGongzi":0,
//                "ruodianGongzi":0,
//                "shejiGongzi":588
        private BigDecimal sgqdBz1;
        private BigDecimal sgqdMoney;
        private BigDecimal sgqdGongzi;
        private int swlrNum;
        private int swlrBz;
        private int swlrDanjia;
        private BigDecimal swlrGongzi;
        private BigDecimal jiajuGongzi;
        private BigDecimal ruodianGongzi;
        private BigDecimal shejiGongzi;
        private BigDecimal jiaju_precent;
        private BigDecimal ruodian_precent;
        private BigDecimal sheji_precent;

        public BodyBean() {
            super();
        }

        @Override
        public String toString() {
            return "BodyBean{" +
                    "sgqdBz1=" + sgqdBz1 +
                    ", sgqdMoney=" + sgqdMoney +
                    ", sgqdGongzi=" + sgqdGongzi +
                    ", swlrNum=" + swlrNum +
                    ", swlrBz=" + swlrBz +
                    ", swlrDanjia=" + swlrDanjia +
                    ", swlrGongzi=" + swlrGongzi +
                    ", jiajuGongzi=" + jiajuGongzi +
                    ", ruodianGongzi=" + ruodianGongzi +
                    ", shejiGongzi=" + shejiGongzi +
                    ", jiaju_precent=" + jiaju_precent +
                    ", ruodian_precent=" + ruodian_precent +
                    ", sheji_precent=" + sheji_precent +
                    '}';
        }

        public BigDecimal getSgqdBz1() {
            return sgqdBz1;
        }

        public void setSgqdBz1(BigDecimal sgqdBz1) {
            this.sgqdBz1 = sgqdBz1;
        }

        public BigDecimal getSgqdMoney() {
            return sgqdMoney;
        }

        public void setSgqdMoney(BigDecimal sgqdMoney) {
            this.sgqdMoney = sgqdMoney;
        }

        public BigDecimal getSgqdGongzi() {
            return sgqdGongzi;
        }

        public void setSgqdGongzi(BigDecimal sgqdGongzi) {
            this.sgqdGongzi = sgqdGongzi;
        }

        public int getSwlrNum() {
            return swlrNum;
        }

        public void setSwlrNum(int swlrNum) {
            this.swlrNum = swlrNum;
        }

        public int getSwlrBz() {
            return swlrBz;
        }

        public void setSwlrBz(int swlrBz) {
            this.swlrBz = swlrBz;
        }

        public int getSwlrDanjia() {
            return swlrDanjia;
        }

        public void setSwlrDanjia(int swlrDanjia) {
            this.swlrDanjia = swlrDanjia;
        }

        public BigDecimal getSwlrGongzi() {
            return swlrGongzi;
        }

        public void setSwlrGongzi(BigDecimal swlrGongzi) {
            this.swlrGongzi = swlrGongzi;
        }

        public BigDecimal getJiajuGongzi() {
            return jiajuGongzi;
        }

        public void setJiajuGongzi(BigDecimal jiajuGongzi) {
            this.jiajuGongzi = jiajuGongzi;
        }

        public BigDecimal getRuodianGongzi() {
            return ruodianGongzi;
        }

        public void setRuodianGongzi(BigDecimal ruodianGongzi) {
            this.ruodianGongzi = ruodianGongzi;
        }

        public BigDecimal getShejiGongzi() {
            return shejiGongzi;
        }

        public void setShejiGongzi(BigDecimal shejiGongzi) {
            this.shejiGongzi = shejiGongzi;
        }

        public BigDecimal getJiaju_precent() {
            return jiaju_precent;
        }

        public void setJiaju_precent(BigDecimal jiaju_precent) {
            this.jiaju_precent = jiaju_precent;
        }

        public BigDecimal getRuodian_precent() {
            return ruodian_precent;
        }

        public void setRuodian_precent(BigDecimal ruodian_precent) {
            this.ruodian_precent = ruodian_precent;
        }

        public BigDecimal getSheji_precent() {
            return sheji_precent;
        }

        public void setSheji_precent(BigDecimal sheji_precent) {
            this.sheji_precent = sheji_precent;
        }
    }

}