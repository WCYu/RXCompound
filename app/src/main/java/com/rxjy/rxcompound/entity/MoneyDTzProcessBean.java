package com.rxjy.rxcompound.entity;

import java.math.BigDecimal;

/**
 * Created by hjh on 2018/3/15.
 */

public class MoneyDTzProcessBean {

    private int StatusCode;
    private String StatusMsg;
    private BodyBean Body;

    public MoneyDTzProcessBean() {super();
    }

    @Override
    public String toString() {
        return "MoneyDTzProcessBean{" +
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
//        "shangwu_gongzi":370,
//                "zhuan_num":22,
//                "zhuanInvalid_num":6,
//                "maidan_num":23,
//                "maidan_danjia":200,
//                "zaitanHF_num":180,
//                "weiqian_num":21,
//                "shangwu_danjia":10,
//                "shangwuInvalid_koukuan":20,
//                "zhuan_danjia":10,
//                "zhuanInvalid_koukuan":20,
//                "zaitanHF_danjia":1,
//                "weiqian_danjia":-300,
//                "zhuan_gongzi":100,
//                "maidan_gongzi":4600,
//                "zaitanHF_gongzi":180,
//                "weiqian_gongzi":-6300
        private int shangwu_num;
        private int shangwuInvalid_num;
        private BigDecimal shangwu_gongzi;
        private int zhuan_num;
        private int zhuanInvalid_num;
        private int maidan_num;
        private int maidan_danjia;
        private int zaitanHF_num;
        private int weiqian_num;
        private int shangwu_danjia;
        private int shangwuInvalid_koukuan;
        private int zhuan_danjia;
        private int zhuanInvalid_koukuan;
        private int zaitanHF_danjia;
        private int weiqian_danjia;
        private BigDecimal zhuan_gongzi;
        private BigDecimal maidan_gongzi;
        private BigDecimal zaitanHF_gongzi;
        private BigDecimal weiqian_gongzi;

        public BodyBean() {
            super();
        }

        @Override
        public String toString() {
            return "BodyBean{" +
                    "shangwu_num=" + shangwu_num +
                    ", shangwuInvalid_num=" + shangwuInvalid_num +
                    ", shangwu_gongzi=" + shangwu_gongzi +
                    ", zhuan_num=" + zhuan_num +
                    ", zhuanInvalid_num=" + zhuanInvalid_num +
                    ", maidan_num=" + maidan_num +
                    ", maidan_danjia=" + maidan_danjia +
                    ", zaitanHF_num=" + zaitanHF_num +
                    ", weiqian_num=" + weiqian_num +
                    ", shangwu_danjia=" + shangwu_danjia +
                    ", shangwuInvalid_koukuan=" + shangwuInvalid_koukuan +
                    ", zhuan_danjia=" + zhuan_danjia +
                    ", zhuanInvalid_koukuan=" + zhuanInvalid_koukuan +
                    ", zaitanHF_danjia=" + zaitanHF_danjia +
                    ", weiqian_danjia=" + weiqian_danjia +
                    ", zhuan_gongzi=" + zhuan_gongzi +
                    ", maidan_gongzi=" + maidan_gongzi +
                    ", zaitanHF_gongzi=" + zaitanHF_gongzi +
                    ", weiqian_gongzi=" + weiqian_gongzi +
                    '}';
        }

        public int getShangwu_num() {
            return shangwu_num;
        }

        public void setShangwu_num(int shangwu_num) {
            this.shangwu_num = shangwu_num;
        }

        public int getShangwuInvalid_num() {
            return shangwuInvalid_num;
        }

        public void setShangwuInvalid_num(int shangwuInvalid_num) {
            this.shangwuInvalid_num = shangwuInvalid_num;
        }

        public BigDecimal getShangwu_gongzi() {
            return shangwu_gongzi;
        }

        public void setShangwu_gongzi(BigDecimal shangwu_gongzi) {
            this.shangwu_gongzi = shangwu_gongzi;
        }

        public int getZhuan_num() {
            return zhuan_num;
        }

        public void setZhuan_num(int zhuan_num) {
            this.zhuan_num = zhuan_num;
        }

        public int getZhuanInvalid_num() {
            return zhuanInvalid_num;
        }

        public void setZhuanInvalid_num(int zhuanInvalid_num) {
            this.zhuanInvalid_num = zhuanInvalid_num;
        }

        public int getMaidan_num() {
            return maidan_num;
        }

        public void setMaidan_num(int maidan_num) {
            this.maidan_num = maidan_num;
        }

        public int getMaidan_danjia() {
            return maidan_danjia;
        }

        public void setMaidan_danjia(int maidan_danjia) {
            this.maidan_danjia = maidan_danjia;
        }

        public int getZaitanHF_num() {
            return zaitanHF_num;
        }

        public void setZaitanHF_num(int zaitanHF_num) {
            this.zaitanHF_num = zaitanHF_num;
        }

        public int getWeiqian_num() {
            return weiqian_num;
        }

        public void setWeiqian_num(int weiqian_num) {
            this.weiqian_num = weiqian_num;
        }

        public int getShangwu_danjia() {
            return shangwu_danjia;
        }

        public void setShangwu_danjia(int shangwu_danjia) {
            this.shangwu_danjia = shangwu_danjia;
        }

        public int getShangwuInvalid_koukuan() {
            return shangwuInvalid_koukuan;
        }

        public void setShangwuInvalid_koukuan(int shangwuInvalid_koukuan) {
            this.shangwuInvalid_koukuan = shangwuInvalid_koukuan;
        }

        public int getZhuan_danjia() {
            return zhuan_danjia;
        }

        public void setZhuan_danjia(int zhuan_danjia) {
            this.zhuan_danjia = zhuan_danjia;
        }

        public int getZhuanInvalid_koukuan() {
            return zhuanInvalid_koukuan;
        }

        public void setZhuanInvalid_koukuan(int zhuanInvalid_koukuan) {
            this.zhuanInvalid_koukuan = zhuanInvalid_koukuan;
        }

        public int getZaitanHF_danjia() {
            return zaitanHF_danjia;
        }

        public void setZaitanHF_danjia(int zaitanHF_danjia) {
            this.zaitanHF_danjia = zaitanHF_danjia;
        }

        public int getWeiqian_danjia() {
            return weiqian_danjia;
        }

        public void setWeiqian_danjia(int weiqian_danjia) {
            this.weiqian_danjia = weiqian_danjia;
        }

        public BigDecimal getZhuan_gongzi() {
            return zhuan_gongzi;
        }

        public void setZhuan_gongzi(BigDecimal zhuan_gongzi) {
            this.zhuan_gongzi = zhuan_gongzi;
        }

        public BigDecimal getMaidan_gongzi() {
            return maidan_gongzi;
        }

        public void setMaidan_gongzi(BigDecimal maidan_gongzi) {
            this.maidan_gongzi = maidan_gongzi;
        }

        public BigDecimal getZaitanHF_gongzi() {
            return zaitanHF_gongzi;
        }

        public void setZaitanHF_gongzi(BigDecimal zaitanHF_gongzi) {
            this.zaitanHF_gongzi = zaitanHF_gongzi;
        }

        public BigDecimal getWeiqian_gongzi() {
            return weiqian_gongzi;
        }

        public void setWeiqian_gongzi(BigDecimal weiqian_gongzi) {
            this.weiqian_gongzi = weiqian_gongzi;
        }
    }

}