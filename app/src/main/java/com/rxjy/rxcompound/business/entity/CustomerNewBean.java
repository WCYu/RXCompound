package com.rxjy.rxcompound.business.entity;

import java.util.ArrayList;

/**
 * Created by hjh on 2018/5/11.
 */

public class CustomerNewBean {

//    "ROWID":1,
//            "TianJiaShiJian":"2018-05-11 16:36:12",
//            "DanHao":"12-202729",
//            "XingMing":"测试",
//            "LeiXingYi":2,
//            "ZhongYaoXing":0,
//            "ZuiJinHuiFangNeiRong":null,
//            "IsDaHui":0,
//            "Zhuan":0,
//            "MianJi":300,
//            "KeHuBaseID":700540,
//            "Derive":null,
//            "ZType":1,
//            "MobilePC":"移动",
//            "IsPending":1,
//            "ZTypeName":"",
//            "XiaCiHuiFangShiJian":0,
//            "ZhunKeHuShiJian":null,
//            "ZhuangTai":0,
//            "GongSiMingCheng":"测试",
//            "LiangFangDiZhi":"",
//            "CityName":"北京",
//            "ChannelName":"360",
//            "HangYe":null,
//            "Remarks":"在跟踪",
//            "ShouJiHao":"13312613807"

    private String StatusMsg;
    private ArrayList<BodyBean> Body;

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
        private int ROWID;
        private int ZhongYaoXing;
        private int MianJi;
        private int KeHuBaseID;
        private String TianJiaShiJian;
        private String DanHao;
        private String XingMing;
        private String MobilePC;
        private String GongSiMingCheng;
        private String LiangFangDiZhi;
        private String CityName;
        private String ChannelName;
        private String Remarks;
        private String ShouJiHao;

        public int getROWID() {
            return ROWID;
        }

        public void setROWID(int ROWID) {
            this.ROWID = ROWID;
        }

        public int getZhongYaoXing() {
            return ZhongYaoXing;
        }

        public void setZhongYaoXing(int zhongYaoXing) {
            ZhongYaoXing = zhongYaoXing;
        }

        public int getMianJi() {
            return MianJi;
        }

        public void setMianJi(int mianJi) {
            MianJi = mianJi;
        }

        public int getKeHuBaseID() {
            return KeHuBaseID;
        }

        public void setKeHuBaseID(int keHuBaseID) {
            KeHuBaseID = keHuBaseID;
        }

        public String getTianJiaShiJian() {
            return TianJiaShiJian;
        }

        public void setTianJiaShiJian(String tianJiaShiJian) {
            TianJiaShiJian = tianJiaShiJian;
        }

        public String getDanHao() {
            return DanHao;
        }

        public void setDanHao(String danHao) {
            DanHao = danHao;
        }

        public String getXingMing() {
            return XingMing;
        }

        public void setXingMing(String xingMing) {
            XingMing = xingMing;
        }

        public String getMobilePC() {
            return MobilePC;
        }

        public void setMobilePC(String mobilePC) {
            MobilePC = mobilePC;
        }

        public String getGongSiMingCheng() {
            return GongSiMingCheng;
        }

        public void setGongSiMingCheng(String gongSiMingCheng) {
            GongSiMingCheng = gongSiMingCheng;
        }

        public String getLiangFangDiZhi() {
            return LiangFangDiZhi;
        }

        public void setLiangFangDiZhi(String liangFangDiZhi) {
            LiangFangDiZhi = liangFangDiZhi;
        }

        public String getCityName() {
            return CityName;
        }

        public void setCityName(String cityName) {
            CityName = cityName;
        }

        public String getChannelName() {
            return ChannelName;
        }

        public void setChannelName(String channelName) {
            ChannelName = channelName;
        }

        public String getRemarks() {
            return Remarks;
        }

        public void setRemarks(String remarks) {
            Remarks = remarks;
        }

        public String getShouJiHao() {
            return ShouJiHao;
        }

        public void setShouJiHao(String shouJiHao) {
            ShouJiHao = shouJiHao;
        }
    }
}
