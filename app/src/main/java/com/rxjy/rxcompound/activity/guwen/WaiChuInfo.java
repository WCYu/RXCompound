package com.rxjy.rxcompound.activity.guwen;

import java.util.List;

public class WaiChuInfo {


    /**
     * StatusCode : 0
     * StatusMsg : 请求成功
     * Body : [{"WaiChuID":25518,"LeiXing":1,"ZhuangTai":4,"KeyID":732636,"YeWuYuanID":11389,"TianJiaShiJian":"2018-07-13 14:54:52","WaiChuShiJian":"2018-07-13 14:54:45","WaiChuYuanYin":"测试外出4","GuiLaiShiJian":null,"WaiChuFanKui":"","IsValid":0,"MeetingArea":"测试大厦4","Remark":"25-108593","WaiChuCiShu":0,"JlRemark":null,"JlPingFen":null,"XingMing":"塞纳春天","Status":"打回"},{"WaiChuID":25468,"LeiXing":2,"ZhuangTai":3,"KeyID":720521,"YeWuYuanID":11389,"TianJiaShiJian":"2018-07-12 15:16:50","WaiChuShiJian":"2018-07-12 15:15:00","WaiChuYuanYin":"协助新人量房","GuiLaiShiJian":null,"WaiChuFanKui":"","IsValid":0,"MeetingArea":"融公馆","Remark":"25-74909","WaiChuCiShu":0,"JlRemark":null,"JlPingFen":null,"XingMing":"党女士","Status":"待审批"}]
     */

    private int StatusCode;
    private String StatusMsg;
    private List<BodyBean> Body;

    public int getStatusCode() {
        return StatusCode;
    }

    public void setStatusCode(int StatusCode) {
        this.StatusCode = StatusCode;
    }

    public String getStatusMsg() {
        return StatusMsg;
    }

    public void setStatusMsg(String StatusMsg) {
        this.StatusMsg = StatusMsg;
    }

    public List<BodyBean> getBody() {
        return Body;
    }

    public void setBody(List<BodyBean> Body) {
        this.Body = Body;
    }

    public static class BodyBean {
        /**
         * WaiChuID : 25518
         * LeiXing : 1
         * ZhuangTai : 4
         * KeyID : 732636
         * YeWuYuanID : 11389
         * TianJiaShiJian : 2018-07-13 14:54:52
         * WaiChuShiJian : 2018-07-13 14:54:45
         * WaiChuYuanYin : 测试外出4
         * GuiLaiShiJian : null
         * WaiChuFanKui :
         * IsValid : 0
         * MeetingArea : 测试大厦4
         * Remark : 25-108593
         * WaiChuCiShu : 0
         * JlRemark : null
         * JlPingFen : null
         * XingMing : 塞纳春天
         * Status : 打回
         */

        private int WaiChuID;
        private int LeiXing;
        private int ZhuangTai;
        private int KeyID;
        private int YeWuYuanID;
        private String TianJiaShiJian;
        private String WaiChuShiJian;
        private String WaiChuYuanYin;
        private Object GuiLaiShiJian;
        private String WaiChuFanKui;
        private int IsValid;
        private String MeetingArea;
        private String Remark;
        private int WaiChuCiShu;
        private Object JlRemark;
        private Object JlPingFen;
        private String XingMing;
        private String Status;

        public int getWaiChuID() {
            return WaiChuID;
        }

        public void setWaiChuID(int WaiChuID) {
            this.WaiChuID = WaiChuID;
        }

        public int getLeiXing() {
            return LeiXing;
        }

        public void setLeiXing(int LeiXing) {
            this.LeiXing = LeiXing;
        }

        public int getZhuangTai() {
            return ZhuangTai;
        }

        public void setZhuangTai(int ZhuangTai) {
            this.ZhuangTai = ZhuangTai;
        }

        public int getKeyID() {
            return KeyID;
        }

        public void setKeyID(int KeyID) {
            this.KeyID = KeyID;
        }

        public int getYeWuYuanID() {
            return YeWuYuanID;
        }

        public void setYeWuYuanID(int YeWuYuanID) {
            this.YeWuYuanID = YeWuYuanID;
        }

        public String getTianJiaShiJian() {
            return TianJiaShiJian;
        }

        public void setTianJiaShiJian(String TianJiaShiJian) {
            this.TianJiaShiJian = TianJiaShiJian;
        }

        public String getWaiChuShiJian() {
            return WaiChuShiJian;
        }

        public void setWaiChuShiJian(String WaiChuShiJian) {
            this.WaiChuShiJian = WaiChuShiJian;
        }

        public String getWaiChuYuanYin() {
            return WaiChuYuanYin;
        }

        public void setWaiChuYuanYin(String WaiChuYuanYin) {
            this.WaiChuYuanYin = WaiChuYuanYin;
        }

        public Object getGuiLaiShiJian() {
            return GuiLaiShiJian;
        }

        public void setGuiLaiShiJian(Object GuiLaiShiJian) {
            this.GuiLaiShiJian = GuiLaiShiJian;
        }

        public String getWaiChuFanKui() {
            return WaiChuFanKui;
        }

        public void setWaiChuFanKui(String WaiChuFanKui) {
            this.WaiChuFanKui = WaiChuFanKui;
        }

        public int getIsValid() {
            return IsValid;
        }

        public void setIsValid(int IsValid) {
            this.IsValid = IsValid;
        }

        public String getMeetingArea() {
            return MeetingArea;
        }

        public void setMeetingArea(String MeetingArea) {
            this.MeetingArea = MeetingArea;
        }

        public String getRemark() {
            return Remark;
        }

        public void setRemark(String Remark) {
            this.Remark = Remark;
        }

        public int getWaiChuCiShu() {
            return WaiChuCiShu;
        }

        public void setWaiChuCiShu(int WaiChuCiShu) {
            this.WaiChuCiShu = WaiChuCiShu;
        }

        public Object getJlRemark() {
            return JlRemark;
        }

        public void setJlRemark(Object JlRemark) {
            this.JlRemark = JlRemark;
        }

        public Object getJlPingFen() {
            return JlPingFen;
        }

        public void setJlPingFen(Object JlPingFen) {
            this.JlPingFen = JlPingFen;
        }

        public String getXingMing() {
            return XingMing;
        }

        public void setXingMing(String XingMing) {
            this.XingMing = XingMing;
        }

        public String getStatus() {
            return Status;
        }

        public void setStatus(String Status) {
            this.Status = Status;
        }
    }
}
