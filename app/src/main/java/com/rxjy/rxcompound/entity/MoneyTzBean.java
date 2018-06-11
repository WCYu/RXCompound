package com.rxjy.rxcompound.entity;

import java.math.BigDecimal;

/**
 * Created by hjh on 2018/3/7.
 */

public class MoneyTzBean {

    private int StatusCode;
    private String StatusMsg;
    private BodyBean Body;

    public MoneyTzBean() {
        super();
    }

    @Override
    public String toString() {
        return "MoneyTzBean{" +
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
//        "baoDiGongZi":6500,
//                "jiXiaoGongZi":50,
//                "quQiGao":6500,
//                "zuiZhongGongZi":5042,
//                "jieGuoGongZi":0,
//                "guoChengGongZi":50,
//                "rCount":0,
//                "pCount":1,
//                "rMoney":0,
//                "xianJin":0,
//                "jiangFaGongZi":-1800,
//                "jiangFaGongZiHou":-1800,
//                "socialPrivate":-342,
//                "housePrivate":0,
//                "sheBao":-342,
//                "fenHongNum":0,
//                "fenHongSumMoney":0,
//                "zuiZhongGongZiHou":5042,
//                "pmoney":-1800
        private String baoDiGongZi;
        private String jiXiaoGongZi;
        private String quQiGao;
        private String zuiZhongGongZi;
        private String jieGuoGongZi;
        private String guoChengGongZi;
        private String rCount;
        private String pCount;
        private String rMoney;
        private String xianJin;
        private BigDecimal jiangFaGongZi;
        private BigDecimal jiangFaGongZiHou;
        private String socialPrivate;
        private String housePrivate;
        private String sheBao;
        private String fenHongNum;
        private String fenHongSumMoney;
        private String zuiZhongGongZiHou;
        private String pmoney;
        private String pMoney;
        private String shouldPay;
        private String noPay;

        public BodyBean() {
            super();
        }

        @Override
        public String toString() {
            return "BodyBean{" +
                    "baoDiGongZi='" + baoDiGongZi + '\'' +
                    ", jiXiaoGongZi='" + jiXiaoGongZi + '\'' +
                    ", quQiGao='" + quQiGao + '\'' +
                    ", zuiZhongGongZi='" + zuiZhongGongZi + '\'' +
                    ", jieGuoGongZi='" + jieGuoGongZi + '\'' +
                    ", guoChengGongZi='" + guoChengGongZi + '\'' +
                    ", rCount='" + rCount + '\'' +
                    ", pCount='" + pCount + '\'' +
                    ", rMoney='" + rMoney + '\'' +
                    ", xianJin='" + xianJin + '\'' +
                    ", jiangFaGongZi=" + jiangFaGongZi +
                    ", jiangFaGongZiHou=" + jiangFaGongZiHou +
                    ", socialPrivate='" + socialPrivate + '\'' +
                    ", housePrivate='" + housePrivate + '\'' +
                    ", sheBao='" + sheBao + '\'' +
                    ", fenHongNum='" + fenHongNum + '\'' +
                    ", fenHongSumMoney='" + fenHongSumMoney + '\'' +
                    ", zuiZhongGongZiHou='" + zuiZhongGongZiHou + '\'' +
                    ", pmoney='" + pmoney + '\'' +
                    ", pMoney='" + pMoney + '\'' +
                    ", shouldPay='" + shouldPay + '\'' +
                    ", noPay='" + noPay + '\'' +
                    '}';
        }

        public String getBaoDiGongZi() {
            return baoDiGongZi;
        }

        public void setBaoDiGongZi(String baoDiGongZi) {
            this.baoDiGongZi = baoDiGongZi;
        }

        public String getJiXiaoGongZi() {
            return jiXiaoGongZi;
        }

        public void setJiXiaoGongZi(String jiXiaoGongZi) {
            this.jiXiaoGongZi = jiXiaoGongZi;
        }

        public String getQuQiGao() {
            return quQiGao;
        }

        public void setQuQiGao(String quQiGao) {
            this.quQiGao = quQiGao;
        }

        public String getZuiZhongGongZi() {
            return zuiZhongGongZi;
        }

        public void setZuiZhongGongZi(String zuiZhongGongZi) {
            this.zuiZhongGongZi = zuiZhongGongZi;
        }

        public String getJieGuoGongZi() {
            return jieGuoGongZi;
        }

        public void setJieGuoGongZi(String jieGuoGongZi) {
            this.jieGuoGongZi = jieGuoGongZi;
        }

        public String getGuoChengGongZi() {
            return guoChengGongZi;
        }

        public void setGuoChengGongZi(String guoChengGongZi) {
            this.guoChengGongZi = guoChengGongZi;
        }

        public String getrCount() {
            return rCount;
        }

        public void setrCount(String rCount) {
            this.rCount = rCount;
        }

        public String getpCount() {
            return pCount;
        }

        public void setpCount(String pCount) {
            this.pCount = pCount;
        }

        public String getrMoney() {
            return rMoney;
        }

        public void setrMoney(String rMoney) {
            this.rMoney = rMoney;
        }

        public String getXianJin() {
            return xianJin;
        }

        public void setXianJin(String xianJin) {
            this.xianJin = xianJin;
        }

        public BigDecimal getJiangFaGongZi() {
            return jiangFaGongZi;
        }

        public void setJiangFaGongZi(BigDecimal jiangFaGongZi) {
            this.jiangFaGongZi = jiangFaGongZi;
        }

        public BigDecimal getJiangFaGongZiHou() {
            return jiangFaGongZiHou;
        }

        public void setJiangFaGongZiHou(BigDecimal jiangFaGongZiHou) {
            this.jiangFaGongZiHou = jiangFaGongZiHou;
        }

        public String getSocialPrivate() {
            return socialPrivate;
        }

        public void setSocialPrivate(String socialPrivate) {
            this.socialPrivate = socialPrivate;
        }

        public String getHousePrivate() {
            return housePrivate;
        }

        public void setHousePrivate(String housePrivate) {
            this.housePrivate = housePrivate;
        }

        public String getSheBao() {
            return sheBao;
        }

        public void setSheBao(String sheBao) {
            this.sheBao = sheBao;
        }

        public String getFenHongNum() {
            return fenHongNum;
        }

        public void setFenHongNum(String fenHongNum) {
            this.fenHongNum = fenHongNum;
        }

        public String getFenHongSumMoney() {
            return fenHongSumMoney;
        }

        public void setFenHongSumMoney(String fenHongSumMoney) {
            this.fenHongSumMoney = fenHongSumMoney;
        }

        public String getZuiZhongGongZiHou() {
            return zuiZhongGongZiHou;
        }

        public void setZuiZhongGongZiHou(String zuiZhongGongZiHou) {
            this.zuiZhongGongZiHou = zuiZhongGongZiHou;
        }

        public String getPmoney() {
            return pmoney;
        }

        public void setPmoney(String pmoney) {
            this.pmoney = pmoney;
        }

        public String getpMoney() {
            return pMoney;
        }

        public void setpMoney(String pMoney) {
            this.pMoney = pMoney;
        }

        public String getShouldPay() {
            return shouldPay;
        }

        public void setShouldPay(String shouldPay) {
            this.shouldPay = shouldPay;
        }

        public String getNoPay() {
            return noPay;
        }

        public void setNoPay(String noPay) {
            this.noPay = noPay;
        }
    }

}