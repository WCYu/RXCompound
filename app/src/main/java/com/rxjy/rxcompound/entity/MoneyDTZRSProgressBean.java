package com.rxjy.rxcompound.entity;

import java.math.BigDecimal;

/**
 * Created by hjh on 2018/4/23.
 */

public class MoneyDTZRSProgressBean {

    private int StatusCode;
    private String StatusMsg;
    private BodyBean Body;

    public MoneyDTZRSProgressBean() {
        super();
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

    public MoneyDTZRSProgressBean.BodyBean getBody() {
        return Body;
    }

    public void setBody(MoneyDTZRSProgressBean.BodyBean body) {
        Body = body;
    }

    @Override
    public String toString() {
        return "MoneyDTZRSProgressBean{" +
                "StatusCode=" + StatusCode +
                ", StatusMsg='" + StatusMsg + '\'' +
                ", Body=" + Body +
                '}';
    }

    public class BodyBean{

        private int shigang_num;
        private int shigang_bz;
        private BigDecimal shigang_dj;
        private int sw_ruzhi_num;
        private int sw_ruzhi_bz;
        private BigDecimal sw_ruzhi_dj;
        private int za_ruzhi_num;
        private int za_ruzhi_bz;
        private BigDecimal za_ruzhi_dj;
        private int zhuanzheng_num;
        private int zhuanzheng_bz;
        private BigDecimal zhuanzheng_dj;
        private int xz_ping_gu_num;
        private int xz_ping_gu_bz;
        private BigDecimal xz_ping_gu_dj;
        private int xz_ping_gu_num_invalid;
        private BigDecimal xz_ping_gu_debit;
        private int xingxiang_num;
        private int xingxiang_bz;
        private BigDecimal xingxiang_dj;
        private int xingxiang_num_invalid;
        private BigDecimal xingxiang_debit;
        private int rw_zhi_xing_num;
        private int rw_zhi_xing_bz;
        private BigDecimal rw_zhi_xing_dj;
        private BigDecimal shigang_gongzi;
        private BigDecimal sw_ruzhi_gongzi;
        private BigDecimal za_ruzhi_gongzi;
        private BigDecimal zhuanzheng_gongzi;
        private BigDecimal xz_ping_gu_gongzi;
        private BigDecimal xingxiang_gongzi;
        private BigDecimal rw_zhi_xing_gongzi;
        private BigDecimal process_gongzi;

        public BodyBean() {
            super();
        }

        public int getShigang_num() {
            return shigang_num;
        }

        public void setShigang_num(int shigang_num) {
            this.shigang_num = shigang_num;
        }

        public int getShigang_bz() {
            return shigang_bz;
        }

        public void setShigang_bz(int shigang_bz) {
            this.shigang_bz = shigang_bz;
        }

        public BigDecimal getShigang_dj() {
            return shigang_dj;
        }

        public void setShigang_dj(BigDecimal shigang_dj) {
            this.shigang_dj = shigang_dj;
        }

        public int getSw_ruzhi_num() {
            return sw_ruzhi_num;
        }

        public void setSw_ruzhi_num(int sw_ruzhi_num) {
            this.sw_ruzhi_num = sw_ruzhi_num;
        }

        public int getSw_ruzhi_bz() {
            return sw_ruzhi_bz;
        }

        public void setSw_ruzhi_bz(int sw_ruzhi_bz) {
            this.sw_ruzhi_bz = sw_ruzhi_bz;
        }

        public BigDecimal getSw_ruzhi_dj() {
            return sw_ruzhi_dj;
        }

        public void setSw_ruzhi_dj(BigDecimal sw_ruzhi_dj) {
            this.sw_ruzhi_dj = sw_ruzhi_dj;
        }

        public int getZa_ruzhi_num() {
            return za_ruzhi_num;
        }

        public void setZa_ruzhi_num(int za_ruzhi_num) {
            this.za_ruzhi_num = za_ruzhi_num;
        }

        public int getZa_ruzhi_bz() {
            return za_ruzhi_bz;
        }

        public void setZa_ruzhi_bz(int za_ruzhi_bz) {
            this.za_ruzhi_bz = za_ruzhi_bz;
        }

        public BigDecimal getZa_ruzhi_dj() {
            return za_ruzhi_dj;
        }

        public void setZa_ruzhi_dj(BigDecimal za_ruzhi_dj) {
            this.za_ruzhi_dj = za_ruzhi_dj;
        }

        public int getZhuanzheng_num() {
            return zhuanzheng_num;
        }

        public void setZhuanzheng_num(int zhuanzheng_num) {
            this.zhuanzheng_num = zhuanzheng_num;
        }

        public int getZhuanzheng_bz() {
            return zhuanzheng_bz;
        }

        public void setZhuanzheng_bz(int zhuanzheng_bz) {
            this.zhuanzheng_bz = zhuanzheng_bz;
        }

        public BigDecimal getZhuanzheng_dj() {
            return zhuanzheng_dj;
        }

        public void setZhuanzheng_dj(BigDecimal zhuanzheng_dj) {
            this.zhuanzheng_dj = zhuanzheng_dj;
        }

        public int getXz_ping_gu_num() {
            return xz_ping_gu_num;
        }

        public void setXz_ping_gu_num(int xz_ping_gu_num) {
            this.xz_ping_gu_num = xz_ping_gu_num;
        }

        public int getXz_ping_gu_bz() {
            return xz_ping_gu_bz;
        }

        public void setXz_ping_gu_bz(int xz_ping_gu_bz) {
            this.xz_ping_gu_bz = xz_ping_gu_bz;
        }

        public BigDecimal getXz_ping_gu_dj() {
            return xz_ping_gu_dj;
        }

        public void setXz_ping_gu_dj(BigDecimal xz_ping_gu_dj) {
            this.xz_ping_gu_dj = xz_ping_gu_dj;
        }

        public int getXz_ping_gu_num_invalid() {
            return xz_ping_gu_num_invalid;
        }

        public void setXz_ping_gu_num_invalid(int xz_ping_gu_num_invalid) {
            this.xz_ping_gu_num_invalid = xz_ping_gu_num_invalid;
        }

        public BigDecimal getXz_ping_gu_debit() {
            return xz_ping_gu_debit;
        }

        public void setXz_ping_gu_debit(BigDecimal xz_ping_gu_debit) {
            this.xz_ping_gu_debit = xz_ping_gu_debit;
        }

        public int getXingxiang_num() {
            return xingxiang_num;
        }

        public void setXingxiang_num(int xingxiang_num) {
            this.xingxiang_num = xingxiang_num;
        }

        public int getXingxiang_bz() {
            return xingxiang_bz;
        }

        public void setXingxiang_bz(int xingxiang_bz) {
            this.xingxiang_bz = xingxiang_bz;
        }

        public BigDecimal getXingxiang_dj() {
            return xingxiang_dj;
        }

        public void setXingxiang_dj(BigDecimal xingxiang_dj) {
            this.xingxiang_dj = xingxiang_dj;
        }

        public int getXingxiang_num_invalid() {
            return xingxiang_num_invalid;
        }

        public void setXingxiang_num_invalid(int xingxiang_num_invalid) {
            this.xingxiang_num_invalid = xingxiang_num_invalid;
        }

        public BigDecimal getXingxiang_debit() {
            return xingxiang_debit;
        }

        public void setXingxiang_debit(BigDecimal xingxiang_debit) {
            this.xingxiang_debit = xingxiang_debit;
        }

        public int getRw_zhi_xing_num() {
            return rw_zhi_xing_num;
        }

        public void setRw_zhi_xing_num(int rw_zhi_xing_num) {
            this.rw_zhi_xing_num = rw_zhi_xing_num;
        }

        public int getRw_zhi_xing_bz() {
            return rw_zhi_xing_bz;
        }

        public void setRw_zhi_xing_bz(int rw_zhi_xing_bz) {
            this.rw_zhi_xing_bz = rw_zhi_xing_bz;
        }

        public BigDecimal getRw_zhi_xing_dj() {
            return rw_zhi_xing_dj;
        }

        public void setRw_zhi_xing_dj(BigDecimal rw_zhi_xing_dj) {
            this.rw_zhi_xing_dj = rw_zhi_xing_dj;
        }

        public BigDecimal getShigang_gongzi() {
            return shigang_gongzi;
        }

        public void setShigang_gongzi(BigDecimal shigang_gongzi) {
            this.shigang_gongzi = shigang_gongzi;
        }

        public BigDecimal getSw_ruzhi_gongzi() {
            return sw_ruzhi_gongzi;
        }

        public void setSw_ruzhi_gongzi(BigDecimal sw_ruzhi_gongzi) {
            this.sw_ruzhi_gongzi = sw_ruzhi_gongzi;
        }

        public BigDecimal getZa_ruzhi_gongzi() {
            return za_ruzhi_gongzi;
        }

        public void setZa_ruzhi_gongzi(BigDecimal za_ruzhi_gongzi) {
            this.za_ruzhi_gongzi = za_ruzhi_gongzi;
        }

        public BigDecimal getZhuanzheng_gongzi() {
            return zhuanzheng_gongzi;
        }

        public void setZhuanzheng_gongzi(BigDecimal zhuanzheng_gongzi) {
            this.zhuanzheng_gongzi = zhuanzheng_gongzi;
        }

        public BigDecimal getXz_ping_gu_gongzi() {
            return xz_ping_gu_gongzi;
        }

        public void setXz_ping_gu_gongzi(BigDecimal xz_ping_gu_gongzi) {
            this.xz_ping_gu_gongzi = xz_ping_gu_gongzi;
        }

        public BigDecimal getXingxiang_gongzi() {
            return xingxiang_gongzi;
        }

        public void setXingxiang_gongzi(BigDecimal xingxiang_gongzi) {
            this.xingxiang_gongzi = xingxiang_gongzi;
        }

        public BigDecimal getRw_zhi_xing_gongzi() {
            return rw_zhi_xing_gongzi;
        }

        public void setRw_zhi_xing_gongzi(BigDecimal rw_zhi_xing_gongzi) {
            this.rw_zhi_xing_gongzi = rw_zhi_xing_gongzi;
        }

        public BigDecimal getProcess_gongzi() {
            return process_gongzi;
        }

        public void setProcess_gongzi(BigDecimal process_gongzi) {
            this.process_gongzi = process_gongzi;
        }

        @Override
        public String toString() {
            return "Body{" +
                    "shigang_num=" + shigang_num +
                    ", shigang_bz=" + shigang_bz +
                    ", shigang_dj=" + shigang_dj +
                    ", sw_ruzhi_num=" + sw_ruzhi_num +
                    ", sw_ruzhi_bz=" + sw_ruzhi_bz +
                    ", sw_ruzhi_dj=" + sw_ruzhi_dj +
                    ", za_ruzhi_num=" + za_ruzhi_num +
                    ", za_ruzhi_bz=" + za_ruzhi_bz +
                    ", za_ruzhi_dj=" + za_ruzhi_dj +
                    ", zhuanzheng_num=" + zhuanzheng_num +
                    ", zhuanzheng_bz=" + zhuanzheng_bz +
                    ", zhuanzheng_dj=" + zhuanzheng_dj +
                    ", xz_ping_gu_num=" + xz_ping_gu_num +
                    ", xz_ping_gu_bz=" + xz_ping_gu_bz +
                    ", xz_ping_gu_dj=" + xz_ping_gu_dj +
                    ", xz_ping_gu_num_invalid=" + xz_ping_gu_num_invalid +
                    ", xz_ping_gu_debit=" + xz_ping_gu_debit +
                    ", xingxiang_num=" + xingxiang_num +
                    ", xingxiang_bz=" + xingxiang_bz +
                    ", xingxiang_dj=" + xingxiang_dj +
                    ", xingxiang_num_invalid=" + xingxiang_num_invalid +
                    ", xingxiang_debit=" + xingxiang_debit +
                    ", rw_zhi_xing_num=" + rw_zhi_xing_num +
                    ", rw_zhi_xing_bz=" + rw_zhi_xing_bz +
                    ", rw_zhi_xing_dj=" + rw_zhi_xing_dj +
                    ", shigang_gongzi=" + shigang_gongzi +
                    ", sw_ruzhi_gongzi=" + sw_ruzhi_gongzi +
                    ", za_ruzhi_gongzi=" + za_ruzhi_gongzi +
                    ", zhuanzheng_gongzi=" + zhuanzheng_gongzi +
                    ", xz_ping_gu_gongzi=" + xz_ping_gu_gongzi +
                    ", xingxiang_gongzi=" + xingxiang_gongzi +
                    ", rw_zhi_xing_gongzi=" + rw_zhi_xing_gongzi +
                    ", process_gongzi=" + process_gongzi +
                    '}';
        }
    }

}
