package com.rxjy.rxcompound.entity;

import java.util.ArrayList;

/**
 * Created by hjh on 2018/3/14.
 */

public class BusResultBean {

    private int StatusCode;
    private String StatusMsg;
    private ArrayList<BodyBean> Body;

    public BusResultBean() {
        super();
    }

    @Override
    public String toString() {
        return "BusResultBean{" +
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

    public class BodyBean{
        private int jiaoYi;
        private int jiaoYiStandard;
        private String lfIncome;

        public BodyBean() {super();
        }

        @Override
        public String toString() {
            return "BodyBean{" +
                    "jiaoYi='" + jiaoYi + '\'' +
                    ", jiaoYiStandard='" + jiaoYiStandard + '\'' +
                    ", lfIncome='" + lfIncome + '\'' +
                    '}';
        }

        public int getJiaoYi() {
            return jiaoYi;
        }

        public void setJiaoYi(int jiaoYi) {
            this.jiaoYi = jiaoYi;
        }

        public int getJiaoYiStandard() {
            return jiaoYiStandard;
        }

        public void setJiaoYiStandard(int jiaoYiStandard) {
            this.jiaoYiStandard = jiaoYiStandard;
        }

        public String getLfIncome() {
            return lfIncome;
        }

        public void setLfIncome(String lfIncome) {
            this.lfIncome = lfIncome;
        }
    }

}