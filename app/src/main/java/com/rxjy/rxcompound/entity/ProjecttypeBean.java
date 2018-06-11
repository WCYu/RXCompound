package com.rxjy.rxcompound.entity;

import java.util.List;

/**
 * Created by asus on 2018/4/13.
 */

public class ProjecttypeBean {


    private List<BodyBean> Body;

    public List<BodyBean> getBody() {
        return Body;
    }

    public void setBody(List<BodyBean> Body) {
        this.Body = Body;
    }

    public static class BodyBean {
        /**
         * ID : 1
         * MingCheng : 办公
         * FuID : 0
         * ziji : [{"ID":"8","FuID":"1","MingCheng":"地产/开发"},{"ID":"9","FuID":"1","MingCheng":"贸易类"},{"ID":"11","FuID":"1","MingCheng":"文化/广告/传媒"},{"ID":"12","FuID":"1","MingCheng":"教育培训"},{"ID":"13","FuID":"1","MingCheng":"咨询/服务"},{"ID":"14","FuID":"1","MingCheng":"政府/企事业"},{"ID":"15","FuID":"1","MingCheng":"工业/生产/能源"},{"ID":"16","FuID":"1","MingCheng":"医疗/生物/医药"},{"ID":"18","FuID":"1","MingCheng":"孵化产业"},{"ID":"79","FuID":"1","MingCheng":"早教机构"},{"ID":"80","FuID":"1","MingCheng":"幼儿园"},{"ID":"81","FuID":"1","MingCheng":"中小学机构"},{"ID":"82","FuID":"1","MingCheng":"出国留学机构"},{"ID":"243","FuID":"1","MingCheng":"网络公司"},{"ID":"244","FuID":"1","MingCheng":"科技公司"},{"ID":"245","FuID":"1","MingCheng":"金融投资"},{"ID":"246","FuID":"1","MingCheng":"贸易公司"},{"ID":"247","FuID":"1","MingCheng":"政府机构"},{"ID":"248","FuID":"1","MingCheng":"房地产"},{"ID":"249","FuID":"1","MingCheng":"工业"},{"ID":"250","FuID":"1","MingCheng":"广告传媒"},{"ID":"251","FuID":"1","MingCheng":"咨询服务"},{"ID":"252","FuID":"1","MingCheng":"生物医药"}]
         */

        private String ID;
        private String MingCheng;
        private int FuID;
        private List<ZijiBean> ziji;

        public String getID() {
            return ID;
        }

        public void setID(String ID) {
            this.ID = ID;
        }

        public String getMingCheng() {
            return MingCheng;
        }

        public void setMingCheng(String MingCheng) {
            this.MingCheng = MingCheng;
        }

        public int getFuID() {
            return FuID;
        }

        public void setFuID(int FuID) {
            this.FuID = FuID;
        }

        public List<ZijiBean> getZiji() {
            return ziji;
        }

        public void setZiji(List<ZijiBean> ziji) {
            this.ziji = ziji;
        }

        public static class ZijiBean {
            /**
             * ID : 8
             * FuID : 1
             * MingCheng : 地产/开发
             */

            private String ID;
            private String FuID;
            private String MingCheng;

            public String getID() {
                return ID;
            }

            public void setID(String ID) {
                this.ID = ID;
            }

            public String getFuID() {
                return FuID;
            }

            public void setFuID(String FuID) {
                this.FuID = FuID;
            }

            public String getMingCheng() {
                return MingCheng;
            }

            public void setMingCheng(String MingCheng) {
                this.MingCheng = MingCheng;
            }
        }
    }
}
