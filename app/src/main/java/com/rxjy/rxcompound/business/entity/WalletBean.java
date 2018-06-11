package com.rxjy.rxcompound.business.entity;

import java.util.ArrayList;

/**
 * Created by hjh on 2017/11/30.
 */

public class WalletBean {

    private int StatusCode;
    private String StatusMsg;
    private PackBean Body;

    public WalletBean() {super();
    }

    @Override
    public String toString() {
        return "WalletBean{" +
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

    public PackBean getBody() {
        return Body;
    }

    public void setBody(PackBean body) {
        Body = body;
    }

    public class PackBean{
        private ArrayList<ListBean> PackageType;

        public PackBean() {super();
        }

        @Override
        public String toString() {
            return "PackBean{" +
                    "PackageType=" + PackageType +
                    '}';
        }

        public ArrayList<ListBean> getPackageType() {
            return PackageType;
        }

        public void setPackageType(ArrayList<ListBean> packageType) {
            PackageType = packageType;
        }
    }

    public class ListBean{
        private String MingCheng;
        private int ShuLiang;
        private int ShouRuJinE;
        private int Dan;
        private int type;
        private int ID;
        private int JinRiRxb;
        private int DyRxb;

        public ListBean() {super();
        }

        public String getMingCheng() {
            return MingCheng;
        }

        public void setMingCheng(String mingCheng) {
            MingCheng = mingCheng;
        }

        public int getShuLiang() {
            return ShuLiang;
        }

        public void setShuLiang(int shuLiang) {
            ShuLiang = shuLiang;
        }

        public int getShouRuJinE() {
            return ShouRuJinE;
        }

        public void setShouRuJinE(int shouRuJinE) {
            ShouRuJinE = shouRuJinE;
        }

        public int getDan() {
            return Dan;
        }

        public void setDan(int dan) {
            Dan = dan;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getID() {
            return ID;
        }

        public void setID(int ID) {
            this.ID = ID;
        }

        public int getJinRiRxb() {
            return JinRiRxb;
        }

        public void setJinRiRxb(int jinRiRxb) {
            JinRiRxb = jinRiRxb;
        }

        public int getDyRxb() {
            return DyRxb;
        }

        public void setDyRxb(int dyRxb) {
            DyRxb = dyRxb;
        }

        @Override
        public String toString() {
            return "ListBean{" +
                    "MingCheng='" + MingCheng + '\'' +
                    ", ShuLiang=" + ShuLiang +
                    ", ShouRuJinE=" + ShouRuJinE +
                    ", Dan=" + Dan +
                    ", type=" + type +
                    ", ID=" + ID +
                    ", JinRiRxb=" + JinRiRxb +
                    ", DyRxb=" + DyRxb +
                    '}';
        }
    }

}
