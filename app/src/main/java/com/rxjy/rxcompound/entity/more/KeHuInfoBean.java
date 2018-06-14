package com.rxjy.rxcompound.entity.more;

import java.util.List;

/**
 * Created by 阿禹 on 2018/6/11.
 */

public class KeHuInfoBean {

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
         * RowId : 1
         * KeHuBaseID : 608317
         * Type : 餐饮
         * GongSiMingCheng : 木木十五
         * ShouJiHaoYi : 15850093960
         * DanHao : 15-833375
         * FenGongSiID : 11
         * Status : 在跟踪
         * TianJiaShiJian : 2018-05-22 11:21
         * XinXiYuanXingMing : 暂无
         * VisitContent : null
         * YeWuYuanID : 7021
         * XingMing : 木木十五
         */

        private int RowId;
        private int KeHuBaseID;
        private String Type;
        private String GongSiMingCheng;
        private String ShouJiHaoYi;
        private String DanHao;
        private int FenGongSiID;
        private String Status;
        private String TianJiaShiJian;
        private String XinXiYuanXingMing;
        private Object VisitContent;
        private int YeWuYuanID;
        private String XingMing;

        public int getRowId() {
            return RowId;
        }

        public void setRowId(int RowId) {
            this.RowId = RowId;
        }

        public int getKeHuBaseID() {
            return KeHuBaseID;
        }

        public void setKeHuBaseID(int KeHuBaseID) {
            this.KeHuBaseID = KeHuBaseID;
        }

        public String getType() {
            return Type;
        }

        public void setType(String Type) {
            this.Type = Type;
        }

        public String getGongSiMingCheng() {
            return GongSiMingCheng;
        }

        public void setGongSiMingCheng(String GongSiMingCheng) {
            this.GongSiMingCheng = GongSiMingCheng;
        }

        public String getShouJiHaoYi() {
            return ShouJiHaoYi;
        }

        public void setShouJiHaoYi(String ShouJiHaoYi) {
            this.ShouJiHaoYi = ShouJiHaoYi;
        }

        public String getDanHao() {
            return DanHao;
        }

        public void setDanHao(String DanHao) {
            this.DanHao = DanHao;
        }

        public int getFenGongSiID() {
            return FenGongSiID;
        }

        public void setFenGongSiID(int FenGongSiID) {
            this.FenGongSiID = FenGongSiID;
        }

        public String getStatus() {
            return Status;
        }

        public void setStatus(String Status) {
            this.Status = Status;
        }

        public String getTianJiaShiJian() {
            return TianJiaShiJian;
        }

        public void setTianJiaShiJian(String TianJiaShiJian) {
            this.TianJiaShiJian = TianJiaShiJian;
        }

        public String getXinXiYuanXingMing() {
            return XinXiYuanXingMing;
        }

        public void setXinXiYuanXingMing(String XinXiYuanXingMing) {
            this.XinXiYuanXingMing = XinXiYuanXingMing;
        }

        public Object getVisitContent() {
            return VisitContent;
        }

        public void setVisitContent(Object VisitContent) {
            this.VisitContent = VisitContent;
        }

        public int getYeWuYuanID() {
            return YeWuYuanID;
        }

        public void setYeWuYuanID(int YeWuYuanID) {
            this.YeWuYuanID = YeWuYuanID;
        }

        public String getXingMing() {
            return XingMing;
        }

        public void setXingMing(String XingMing) {
            this.XingMing = XingMing;
        }
    }
}
