package com.rxjy.rxcompound.activity.guwen;

import java.util.List;

public class WaiChuDetialInfo  {

    /**
     * StatusCode : 0
     * StatusMsg : 请求成功
     * Body : [{"TypeName":"外出见信息员","WaiChuID":13827,"WaiChuYuanYin":"量房","WaiChuFanKui":"量房完毕","MeetingArea":"","GuiLaiShiJian":"2017-06-14 09:51:19","Name":"丁先生","WaiChuShiJian":"2017-06-13 13:20:00","ZhuangTai":5}]
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
         * TypeName : 外出见信息员
         * WaiChuID : 13827
         * WaiChuYuanYin : 量房
         * WaiChuFanKui : 量房完毕
         * MeetingArea :
         * GuiLaiShiJian : 2017-06-14 09:51:19
         * Name : 丁先生
         * WaiChuShiJian : 2017-06-13 13:20:00
         * ZhuangTai : 5
         */

        private String TypeName;
        private int WaiChuID;
        private String WaiChuYuanYin;
        private String WaiChuFanKui;
        private String MeetingArea;
        private String GuiLaiShiJian;
        private String Name;
        private String WaiChuShiJian;
        private int ZhuangTai;

        public String getTypeName() {
            return TypeName;
        }

        public void setTypeName(String TypeName) {
            this.TypeName = TypeName;
        }

        public int getWaiChuID() {
            return WaiChuID;
        }

        public void setWaiChuID(int WaiChuID) {
            this.WaiChuID = WaiChuID;
        }

        public String getWaiChuYuanYin() {
            return WaiChuYuanYin;
        }

        public void setWaiChuYuanYin(String WaiChuYuanYin) {
            this.WaiChuYuanYin = WaiChuYuanYin;
        }

        public String getWaiChuFanKui() {
            return WaiChuFanKui;
        }

        public void setWaiChuFanKui(String WaiChuFanKui) {
            this.WaiChuFanKui = WaiChuFanKui;
        }

        public String getMeetingArea() {
            return MeetingArea;
        }

        public void setMeetingArea(String MeetingArea) {
            this.MeetingArea = MeetingArea;
        }

        public String getGuiLaiShiJian() {
            return GuiLaiShiJian;
        }

        public void setGuiLaiShiJian(String GuiLaiShiJian) {
            this.GuiLaiShiJian = GuiLaiShiJian;
        }

        public String getName() {
            return Name;
        }

        public void setName(String Name) {
            this.Name = Name;
        }

        public String getWaiChuShiJian() {
            return WaiChuShiJian;
        }

        public void setWaiChuShiJian(String WaiChuShiJian) {
            this.WaiChuShiJian = WaiChuShiJian;
        }

        public int getZhuangTai() {
            return ZhuangTai;
        }

        public void setZhuangTai(int ZhuangTai) {
            this.ZhuangTai = ZhuangTai;
        }
    }
}
