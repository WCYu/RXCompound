package com.rxjy.rxcompound.entity;

import java.util.ArrayList;

/**
 * Created by hjh on 2018/4/11.
 */

public class MoneyBusHisBean {

    private int StatusCode;
    private String StatusMsg;
    private ArrayList<Body> Body;

    @Override
    public String toString() {
        return "MoneyBusHisBean{" +
                "StatusCode=" + StatusCode +
                ", StatusMsg='" + StatusMsg + '\'' +
                ", Body=" + Body +
                '}';
    }

    public MoneyBusHisBean() {super();
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

    public ArrayList<MoneyBusHisBean.Body> getBody() {
        return Body;
    }

    public void setBody(ArrayList<MoneyBusHisBean.Body> body) {
        Body = body;
    }

    public class Body{
//        "kaHao":"00001236",
//                　　　　　　"wages":10050,
//                　　　　　　"year":2018,
//                　　　　　　"month":4,
//                　　　　　　"tiCheng":0,
//                　　　　　　"zongHe":10050,
//                　　　　　　"shengYu":0

        private String kaHao;
        private String wages;
        private String year;
        private String month;
        private String tiCheng;
        private String zongHe;
        private String shengYu;

        public Body() {super();
        }

        @Override
        public String toString() {
            return "Body{" +
                    "kaHao='" + kaHao + '\'' +
                    ", wages='" + wages + '\'' +
                    ", year='" + year + '\'' +
                    ", month='" + month + '\'' +
                    ", tiCheng='" + tiCheng + '\'' +
                    ", zongHe='" + zongHe + '\'' +
                    ", shengYu='" + shengYu + '\'' +
                    '}';
        }

        public String getKaHao() {
            return kaHao;
        }

        public void setKaHao(String kaHao) {
            this.kaHao = kaHao;
        }

        public String getWages() {
            return wages;
        }

        public void setWages(String wages) {
            this.wages = wages;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public String getMonth() {
            return month;
        }

        public void setMonth(String month) {
            this.month = month;
        }

        public String getTiCheng() {
            return tiCheng;
        }

        public void setTiCheng(String tiCheng) {
            this.tiCheng = tiCheng;
        }

        public String getZongHe() {
            return zongHe;
        }

        public void setZongHe(String zongHe) {
            this.zongHe = zongHe;
        }

        public String getShengYu() {
            return shengYu;
        }

        public void setShengYu(String shengYu) {
            this.shengYu = shengYu;
        }
    }

}
