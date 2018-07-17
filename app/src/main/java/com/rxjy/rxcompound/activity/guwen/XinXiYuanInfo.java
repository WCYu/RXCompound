package com.rxjy.rxcompound.activity.guwen;

import java.util.List;

public class XinXiYuanInfo {

    /**
     * StatusCode : 0
     * StatusMsg : 请求成功
     * Body : [{"RowId":1,"XinXiYuanBaseID":694005,"XingMing":"王凡","GongSiMingCheng":"独立经纪人","ShouJiHaoYi":"13891009117","KeHuShu":0,"workType":"中介","ZuiJinHuiFangShiJian":"2018-06-29 10:13:52","XiaCiHuiFangShiJian":"2018-07-06 10:03:38","TianJiaShiJian":"2018-02-24 19:57:48","ZhiWu":"业务员","ShouJiHaoEr":"","ShouJiHaoSan":"","YeWuYuanID":11389,"JiBie":"月亮","ZuiJinHuiFangNeiRong":"手机回访，给他讲了亚太那个单子现在做报价，他这边也想赚一个签单钱，继续跟进。","VisitHour":"67"},{"RowId":2,"XinXiYuanBaseID":661397,"XingMing":"张伟","GongSiMingCheng":"金翅鸟装饰","ShouJiHaoYi":"18729459548","KeHuShu":0,"workType":"其他","ZuiJinHuiFangShiJian":"2018-06-29 10:25:10","XiaCiHuiFangShiJian":"2018-07-06 10:03:38","TianJiaShiJian":"2017-10-12 15:06:38","ZhiWu":"老板","ShouJiHaoEr":"15529269123","ShouJiHaoSan":"","YeWuYuanID":11389,"JiBie":"月亮","ZuiJinHuiFangNeiRong":"手机回访，给他讲了那个金徽酒的单子又给他发了三千，说还有11056，并且让他在给我介绍一点客户，他第二天去给我找了一下，说最近单子质量都不行，面积很小。","VisitHour":"67"},{"RowId":3,"XinXiYuanBaseID":517836,"XingMing":"折静","GongSiMingCheng":"昇昱","ShouJiHaoYi":"18729021582","KeHuShu":2,"workType":"售楼","ZuiJinHuiFangShiJian":"2018-06-29 10:21:48","XiaCiHuiFangShiJian":"2018-07-06 10:03:38","TianJiaShiJian":"2016-11-12 11:11:50","ZhiWu":"业务员","ShouJiHaoEr":"","ShouJiHaoSan":"","YeWuYuanID":11389,"JiBie":"月亮","ZuiJinHuiFangNeiRong":"手机回访，给他讲了那个提成现在就是发完了，他有客户一定会给我介绍的，继续跟进。","VisitHour":"67"},{"RowId":4,"XinXiYuanBaseID":727647,"XingMing":"会员","GongSiMingCheng":"","ShouJiHaoYi":"13988888887","KeHuShu":0,"workType":"其他","ZuiJinHuiFangShiJian":"2018-06-29 10:25:44","XiaCiHuiFangShiJian":"2018-07-06 10:25:58","TianJiaShiJian":"2018-06-25 15:30:04","ZhiWu":"","ShouJiHaoEr":"","ShouJiHaoSan":"","YeWuYuanID":11389,"JiBie":"月亮","ZuiJinHuiFangNeiRong":"继续跟进","VisitHour":"67"},{"RowId":5,"XinXiYuanBaseID":727732,"XingMing":"会员","GongSiMingCheng":"","ShouJiHaoYi":"13988888890","KeHuShu":0,"workType":"其他","ZuiJinHuiFangShiJian":"2018-06-29 10:25:34","XiaCiHuiFangShiJian":"2018-07-06 10:25:58","TianJiaShiJian":"2018-06-25 18:58:50","ZhiWu":"","ShouJiHaoEr":"","ShouJiHaoSan":"","YeWuYuanID":11389,"JiBie":"月亮","ZuiJinHuiFangNeiRong":"继续跟进","VisitHour":"67"},{"RowId":6,"XinXiYuanBaseID":692084,"XingMing":"郝生银","GongSiMingCheng":"业之峰装饰","ShouJiHaoYi":"18792645208","KeHuShu":0,"workType":"其他","ZuiJinHuiFangShiJian":"2018-06-29 10:26:16","XiaCiHuiFangShiJian":"2018-07-06 10:25:58","TianJiaShiJian":"2018-01-29 15:15:53","ZhiWu":"业务员","ShouJiHaoEr":"","ShouJiHaoSan":"","YeWuYuanID":11389,"JiBie":"月亮","ZuiJinHuiFangNeiRong":"手机回访，给他讲了教育培训那个单子订到天仁了，他说后面可以继续跟进。","VisitHour":"67"}]
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
         * RowId : 1
         * XinXiYuanBaseID : 694005
         * XingMing : 王凡
         * GongSiMingCheng : 独立经纪人
         * ShouJiHaoYi : 13891009117
         * KeHuShu : 0
         * workType : 中介
         * ZuiJinHuiFangShiJian : 2018-06-29 10:13:52
         * XiaCiHuiFangShiJian : 2018-07-06 10:03:38
         * TianJiaShiJian : 2018-02-24 19:57:48
         * ZhiWu : 业务员
         * ShouJiHaoEr :
         * ShouJiHaoSan :
         * YeWuYuanID : 11389
         * JiBie : 月亮
         * ZuiJinHuiFangNeiRong : 手机回访，给他讲了亚太那个单子现在做报价，他这边也想赚一个签单钱，继续跟进。
         * VisitHour : 67
         */

        private int RowId;
        private int XinXiYuanBaseID;
        private String XingMing;
        private String GongSiMingCheng;
        private String ShouJiHaoYi;
        private int KeHuShu;
        private String workType;
        private String ZuiJinHuiFangShiJian;
        private String XiaCiHuiFangShiJian;
        private String TianJiaShiJian;
        private String ZhiWu;
        private String ShouJiHaoEr;
        private String ShouJiHaoSan;
        private int YeWuYuanID;
        private String JiBie;
        private String ZuiJinHuiFangNeiRong;
        private String VisitHour;

        public int getRowId() {
            return RowId;
        }

        public void setRowId(int RowId) {
            this.RowId = RowId;
        }

        public int getXinXiYuanBaseID() {
            return XinXiYuanBaseID;
        }

        public void setXinXiYuanBaseID(int XinXiYuanBaseID) {
            this.XinXiYuanBaseID = XinXiYuanBaseID;
        }

        public String getXingMing() {
            return XingMing;
        }

        public void setXingMing(String XingMing) {
            this.XingMing = XingMing;
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

        public int getKeHuShu() {
            return KeHuShu;
        }

        public void setKeHuShu(int KeHuShu) {
            this.KeHuShu = KeHuShu;
        }

        public String getWorkType() {
            return workType;
        }

        public void setWorkType(String workType) {
            this.workType = workType;
        }

        public String getZuiJinHuiFangShiJian() {
            return ZuiJinHuiFangShiJian;
        }

        public void setZuiJinHuiFangShiJian(String ZuiJinHuiFangShiJian) {
            this.ZuiJinHuiFangShiJian = ZuiJinHuiFangShiJian;
        }

        public String getXiaCiHuiFangShiJian() {
            return XiaCiHuiFangShiJian;
        }

        public void setXiaCiHuiFangShiJian(String XiaCiHuiFangShiJian) {
            this.XiaCiHuiFangShiJian = XiaCiHuiFangShiJian;
        }

        public String getTianJiaShiJian() {
            return TianJiaShiJian;
        }

        public void setTianJiaShiJian(String TianJiaShiJian) {
            this.TianJiaShiJian = TianJiaShiJian;
        }

        public String getZhiWu() {
            return ZhiWu;
        }

        public void setZhiWu(String ZhiWu) {
            this.ZhiWu = ZhiWu;
        }

        public String getShouJiHaoEr() {
            return ShouJiHaoEr;
        }

        public void setShouJiHaoEr(String ShouJiHaoEr) {
            this.ShouJiHaoEr = ShouJiHaoEr;
        }

        public String getShouJiHaoSan() {
            return ShouJiHaoSan;
        }

        public void setShouJiHaoSan(String ShouJiHaoSan) {
            this.ShouJiHaoSan = ShouJiHaoSan;
        }

        public int getYeWuYuanID() {
            return YeWuYuanID;
        }

        public void setYeWuYuanID(int YeWuYuanID) {
            this.YeWuYuanID = YeWuYuanID;
        }

        public String getJiBie() {
            return JiBie;
        }

        public void setJiBie(String JiBie) {
            this.JiBie = JiBie;
        }

        public String getZuiJinHuiFangNeiRong() {
            return ZuiJinHuiFangNeiRong;
        }

        public void setZuiJinHuiFangNeiRong(String ZuiJinHuiFangNeiRong) {
            this.ZuiJinHuiFangNeiRong = ZuiJinHuiFangNeiRong;
        }

        public String getVisitHour() {
            return VisitHour;
        }

        public void setVisitHour(String VisitHour) {
            this.VisitHour = VisitHour;
        }
    }
}
