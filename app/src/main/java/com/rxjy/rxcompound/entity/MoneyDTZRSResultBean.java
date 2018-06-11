package com.rxjy.rxcompound.entity;

import java.math.BigDecimal;

/**
 * Created by hjh on 2018/4/23.
 */

public class MoneyDTZRSResultBean {

    private int StatusCode;
    private String StatusMsg;
    private BodyBean Body;

    public MoneyDTZRSResultBean() {super();
    }

    @Override
    public String toString() {
        return "MoneyDTZRSResultBean{" +
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

    public MoneyDTZRSResultBean.BodyBean getBody() {
        return Body;
    }

    public void setBody(MoneyDTZRSResultBean.BodyBean body) {
        Body = body;
    }

    public class BodyBean{

        private int three_month_num;
        private int three_month_bz;
        private BigDecimal three_month_dj;
        private int six_month_num;
        private int six_month_bz;
        private BigDecimal six_month_dj;
        private int one_year_num;
        private int one_year_bz;
        private BigDecimal one_year_dj;
        private int lizhi_num;
        private int lizhi_bz;
        private BigDecimal lizhi_dj;
        private BigDecimal three_month_gongzi;
        private BigDecimal six_month_gongzi;
        private BigDecimal one_year_gongzi;
        private BigDecimal lizhi_gongzi;
        private BigDecimal result_gongzi;

        @Override
        public String toString() {
            return "BodyBean{" +
                    "three_month_num=" + three_month_num +
                    ", three_month_bz=" + three_month_bz +
                    ", three_month_dj=" + three_month_dj +
                    ", six_month_num=" + six_month_num +
                    ", six_month_bz=" + six_month_bz +
                    ", six_month_dj=" + six_month_dj +
                    ", one_year_num=" + one_year_num +
                    ", one_year_bz=" + one_year_bz +
                    ", one_year_dj=" + one_year_dj +
                    ", lizhi_num=" + lizhi_num +
                    ", lizhi_bz=" + lizhi_bz +
                    ", lizhi_dj=" + lizhi_dj +
                    ", three_month_gongzi=" + three_month_gongzi +
                    ", six_month_gongzi=" + six_month_gongzi +
                    ", one_year_gongzi=" + one_year_gongzi +
                    ", lizhi_gongzi=" + lizhi_gongzi +
                    ", result_gongzi=" + result_gongzi +
                    '}';
        }

        public int getThree_month_num() {
            return three_month_num;
        }

        public void setThree_month_num(int three_month_num) {
            this.three_month_num = three_month_num;
        }

        public int getThree_month_bz() {
            return three_month_bz;
        }

        public void setThree_month_bz(int three_month_bz) {
            this.three_month_bz = three_month_bz;
        }

        public BigDecimal getThree_month_dj() {
            return three_month_dj;
        }

        public void setThree_month_dj(BigDecimal three_month_dj) {
            this.three_month_dj = three_month_dj;
        }

        public int getSix_month_num() {
            return six_month_num;
        }

        public void setSix_month_num(int six_month_num) {
            this.six_month_num = six_month_num;
        }

        public int getSix_month_bz() {
            return six_month_bz;
        }

        public void setSix_month_bz(int six_month_bz) {
            this.six_month_bz = six_month_bz;
        }

        public BigDecimal getSix_month_dj() {
            return six_month_dj;
        }

        public void setSix_month_dj(BigDecimal six_month_dj) {
            this.six_month_dj = six_month_dj;
        }

        public int getOne_year_num() {
            return one_year_num;
        }

        public void setOne_year_num(int one_year_num) {
            this.one_year_num = one_year_num;
        }

        public int getOne_year_bz() {
            return one_year_bz;
        }

        public void setOne_year_bz(int one_year_bz) {
            this.one_year_bz = one_year_bz;
        }

        public BigDecimal getOne_year_dj() {
            return one_year_dj;
        }

        public void setOne_year_dj(BigDecimal one_year_dj) {
            this.one_year_dj = one_year_dj;
        }

        public int getLizhi_num() {
            return lizhi_num;
        }

        public void setLizhi_num(int lizhi_num) {
            this.lizhi_num = lizhi_num;
        }

        public int getLizhi_bz() {
            return lizhi_bz;
        }

        public void setLizhi_bz(int lizhi_bz) {
            this.lizhi_bz = lizhi_bz;
        }

        public BigDecimal getLizhi_dj() {
            return lizhi_dj;
        }

        public void setLizhi_dj(BigDecimal lizhi_dj) {
            this.lizhi_dj = lizhi_dj;
        }

        public BigDecimal getThree_month_gongzi() {
            return three_month_gongzi;
        }

        public void setThree_month_gongzi(BigDecimal three_month_gongzi) {
            this.three_month_gongzi = three_month_gongzi;
        }

        public BigDecimal getSix_month_gongzi() {
            return six_month_gongzi;
        }

        public void setSix_month_gongzi(BigDecimal six_month_gongzi) {
            this.six_month_gongzi = six_month_gongzi;
        }

        public BigDecimal getOne_year_gongzi() {
            return one_year_gongzi;
        }

        public void setOne_year_gongzi(BigDecimal one_year_gongzi) {
            this.one_year_gongzi = one_year_gongzi;
        }

        public BigDecimal getLizhi_gongzi() {
            return lizhi_gongzi;
        }

        public void setLizhi_gongzi(BigDecimal lizhi_gongzi) {
            this.lizhi_gongzi = lizhi_gongzi;
        }

        public BigDecimal getResult_gongzi() {
            return result_gongzi;
        }

        public void setResult_gongzi(BigDecimal result_gongzi) {
            this.result_gongzi = result_gongzi;
        }

        public BodyBean() {
            super();
        }
    }

}