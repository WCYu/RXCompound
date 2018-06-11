package com.rxjy.rxcompound.business.entity;

import java.util.ArrayList;

/**
 * Created by hjh on 2017/11/24.
 */

public class CustomerBean {

    private int StatusCode;
    private String StatusMsg;
    private ArrayList<BodyBean> Body;

    public CustomerBean() {super();
    }

    @Override
    public String toString() {
        return "CustomerBean{" +
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
        private int RowId;
        private int KeHuBaseID;
        private int FenGongSiID;
        private int YeWuYuanID;
        private String Type;
        private String GongSiMingCheng;
        private String ShouJiHaoYi;
        private String DanHao;
        private String Status;
        private String TianJiaShiJian;
        private String XinXiYuanXingMing;
        private String VisitContent;
        private String XingMing;

        public BodyBean() {super();
        }

        @Override
        public String toString() {
            return "BodyBean{" +
                    "RowId=" + RowId +
                    ", KeHuBaseID=" + KeHuBaseID +
                    ", FenGongSiID=" + FenGongSiID +
                    ", YeWuYuanID=" + YeWuYuanID +
                    ", Type='" + Type + '\'' +
                    ", GongSiMingCheng='" + GongSiMingCheng + '\'' +
                    ", ShouJiHaoYi='" + ShouJiHaoYi + '\'' +
                    ", DanHao='" + DanHao + '\'' +
                    ", Status='" + Status + '\'' +
                    ", TianJiaShiJian='" + TianJiaShiJian + '\'' +
                    ", XinXiYuanXingMing='" + XinXiYuanXingMing + '\'' +
                    ", VisitContent='" + VisitContent + '\'' +
                    ", XingMing='" + XingMing + '\'' +
                    '}';
        }

        public int getRowId() {
            return RowId;
        }

        public void setRowId(int rowId) {
            RowId = rowId;
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

        public int getYeWuYuanID() {
            return YeWuYuanID;
        }

        public void setYeWuYuanID(int yeWuYuanID) {
            YeWuYuanID = yeWuYuanID;
        }

        public String getType() {
            return Type;
        }

        public void setType(String type) {
            Type = type;
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

        public String getDanHao() {
            return DanHao;
        }

        public void setDanHao(String danHao) {
            DanHao = danHao;
        }

        public String getStatus() {
            return Status;
        }

        public void setStatus(String status) {
            Status = status;
        }

        public String getTianJiaShiJian() {
            return TianJiaShiJian;
        }

        public void setTianJiaShiJian(String tianJiaShiJian) {
            TianJiaShiJian = tianJiaShiJian;
        }

        public String getXinXiYuanXingMing() {
            return XinXiYuanXingMing;
        }

        public void setXinXiYuanXingMing(String xinXiYuanXingMing) {
            XinXiYuanXingMing = xinXiYuanXingMing;
        }

        public String getVisitContent() {
            return VisitContent;
        }

        public void setVisitContent(String visitContent) {
            VisitContent = visitContent;
        }

        public String getXingMing() {
            return XingMing;
        }

        public void setXingMing(String xingMing) {
            XingMing = xingMing;
        }
    }

}
