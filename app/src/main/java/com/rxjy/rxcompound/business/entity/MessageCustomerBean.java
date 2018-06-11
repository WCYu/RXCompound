package com.rxjy.rxcompound.business.entity;

/**
 * Created by hjh on 2017/12/2.
 */

public class MessageCustomerBean{

    private int StatusCode;
    private String StatusMsg;
    private CBodyBean Body;

    @Override
    public String toString() {
        return "MessageCustomerBean{" +
                "StatusCode=" + StatusCode +
                ", StatusMsg='" + StatusMsg + '\'' +
                ", Body=" + Body +
                '}';
    }

    public MessageCustomerBean() {super();
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

    public CBodyBean getBody() {
        return Body;
    }

    public void setBody(CBodyBean body) {
        Body = body;
    }

    public class CBodyBean{
        private int KeHuBaseID;
        private int FenGongSiID;
        private int LeiXingYi;
        private int LeiXingEr;
        private int MianJi;
        private int FangYuan;
        private String GongSiMingCheng;
        private String ShouJiHaoYi;
        private String XingMing;
        private String Phone;
        private String FenGongSiMing;

        public String getPhone() {
            return Phone;
        }

        public void setPhone(String phone) {
            Phone = phone;
        }

        public CBodyBean() {super();
        }

        public int getKeHuBaseID() {
            return KeHuBaseID;
        }

        public void setKeHuBaseID(int keHuBaseID) {
            KeHuBaseID = keHuBaseID;
        }

        public int getFenGongSiID() {
            return FenGongSiID;
        }

        public void setFenGongSiID(int fenGongSiID) {
            FenGongSiID = fenGongSiID;
        }

        public int getLeiXingYi() {
            return LeiXingYi;
        }

        public void setLeiXingYi(int leiXingYi) {
            LeiXingYi = leiXingYi;
        }

        public int getLeiXingEr() {
            return LeiXingEr;
        }

        public void setLeiXingEr(int leiXingEr) {
            LeiXingEr = leiXingEr;
        }

        public int getMianJi() {
            return MianJi;
        }

        public void setMianJi(int mianJi) {
            MianJi = mianJi;
        }

        public int getFangYuan() {
            return FangYuan;
        }

        public void setFangYuan(int fangYuan) {
            FangYuan = fangYuan;
        }

        public String getGongSiMingCheng() {
            return GongSiMingCheng;
        }

        public void setGongSiMingCheng(String gongSiMingCheng) {
            GongSiMingCheng = gongSiMingCheng;
        }

        public String getShouJiHaoYi() {
            return ShouJiHaoYi;
        }

        public void setShouJiHaoYi(String shouJiHaoYi) {
            ShouJiHaoYi = shouJiHaoYi;
        }

        public String getXingMing() {
            return XingMing;
        }

        public void setXingMing(String xingMing) {
            XingMing = xingMing;
        }

        public String getFenGongSiMing() {
            return FenGongSiMing;
        }

        public void setFenGongSiMing(String fenGongSiMing) {
            FenGongSiMing = fenGongSiMing;
        }

        @Override
        public String toString() {
            return "CBodyBean{" +
                    "KeHuBaseID=" + KeHuBaseID +
                    ", FenGongSiID=" + FenGongSiID +
                    ", LeiXingYi=" + LeiXingYi +
                    ", LeiXingEr=" + LeiXingEr +
                    ", MianJi=" + MianJi +
                    ", FangYuan=" + FangYuan +
                    ", GongSiMingCheng='" + GongSiMingCheng + '\'' +
                    ", ShouJiHaoYi='" + ShouJiHaoYi + '\'' +
                    ", XingMing='" + XingMing + '\'' +
                    ", Phone='" + Phone + '\'' +
                    ", FenGongSiMing='" + FenGongSiMing + '\'' +
                    '}';
        }
    }

}
