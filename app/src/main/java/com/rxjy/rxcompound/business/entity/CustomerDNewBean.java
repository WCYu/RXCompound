package com.rxjy.rxcompound.business.entity;

import java.util.ArrayList;

/**
 * Created by hjh on 2018/5/14.
 */

public class CustomerDNewBean {

    private String StatusMsg;
    private ArrayList<BodyBean> Body;

    @Override
    public String toString() {
        return "CustomerBean{" +
                ", StatusMsg='" + StatusMsg + '\'' +
                ", Body=" + Body +
                '}';
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

        private int KeHuBaseID;
        private int LaiYuan;
        private int LeiXingYi;
        private int LeiXingEr;
        private int FangYuan;
        private int MianJi;
        private int Channel;
        private int IsMobilePC;
        private int tb_diqu;
        private String LeiXingMingCheng;
        private String LeiXingErMingCheng;
        private String KeyWord;
        private String FromURL;
        private String LandingURL;
        private String GongSiMingCheng;
        private String XingMing;
        private String City;
        private String ShouJiHaoYi;
        private String ShouJiHaoEr;

        public int getKeHuBaseID() {
            return KeHuBaseID;
        }

        public void setKeHuBaseID(int keHuBaseID) {
            KeHuBaseID = keHuBaseID;
        }

        public int getLaiYuan() {
            return LaiYuan;
        }

        public void setLaiYuan(int laiYuan) {
            LaiYuan = laiYuan;
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

        public int getFangYuan() {
            return FangYuan;
        }

        public void setFangYuan(int fangYuan) {
            FangYuan = fangYuan;
        }

        public int getMianJi() {
            return MianJi;
        }

        public void setMianJi(int mianJi) {
            MianJi = mianJi;
        }

        public int getChannel() {
            return Channel;
        }

        public void setChannel(int channel) {
            Channel = channel;
        }

        public int getIsMobilePC() {
            return IsMobilePC;
        }

        public void setIsMobilePC(int isMobilePC) {
            IsMobilePC = isMobilePC;
        }

        public String getLeiXingMingCheng() {
            return LeiXingMingCheng;
        }

        public void setLeiXingMingCheng(String leiXingMingCheng) {
            LeiXingMingCheng = leiXingMingCheng;
        }

        public String getLeiXingErMingCheng() {
            return LeiXingErMingCheng;
        }

        public void setLeiXingErMingCheng(String leiXingErMingCheng) {
            LeiXingErMingCheng = leiXingErMingCheng;
        }

        public String getKeyWord() {
            return KeyWord;
        }

        public void setKeyWord(String keyWord) {
            KeyWord = keyWord;
        }

        public String getFromURL() {
            return FromURL;
        }

        public void setFromURL(String fromURL) {
            FromURL = fromURL;
        }

        public String getLandingURL() {
            return LandingURL;
        }

        public void setLandingURL(String landingURL) {
            LandingURL = landingURL;
        }

        public String getGongSiMingCheng() {
            return GongSiMingCheng;
        }

        public void setGongSiMingCheng(String gongSiMingCheng) {
            GongSiMingCheng = gongSiMingCheng;
        }

        public String getXingMing() {
            return XingMing;
        }

        public void setXingMing(String xingMing) {
            XingMing = xingMing;
        }

        public String getCity() {
            return City;
        }

        public void setCity(String city) {
            City = city;
        }

        public String getShouJiHaoYi() {
            return ShouJiHaoYi;
        }

        public void setShouJiHaoYi(String shouJiHaoYi) {
            ShouJiHaoYi = shouJiHaoYi;
        }

        public String getShouJiHaoEr() {
            return ShouJiHaoEr;
        }

        public void setShouJiHaoEr(String shouJiHaoEr) {
            ShouJiHaoEr = shouJiHaoEr;
        }

        public int getTb_diqu() {
            return tb_diqu;
        }

        public void setTb_diqu(int tb_diqu) {
            this.tb_diqu = tb_diqu;
        }
    }

}
