package com.rxjy.rxcompound.business.entity;

import java.util.ArrayList;

/**
 * Created by hjh on 2017/11/24.
 */

public class MyGradeBean {

    private int StatusCode;
    private String StatusMsg;
    private ArrayList<MyGradeBodyBean> Body;

    public MyGradeBean() {super();
    }

    @Override
    public String toString() {
        return "MyGradeBean{" +
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

    public ArrayList<MyGradeBodyBean> getBody() {
        return Body;
    }

    public void setBody(ArrayList<MyGradeBodyBean> body) {
        Body = body;
    }

    public class MyGradeBodyBean{
        private String update_after;
        private String XingMing;
        private String TouXiangImg;
        private String KaHao;
        private String YouXiang;
        private String WeiXinHao;

        public MyGradeBodyBean() {super();
        }

        @Override
        public String toString() {
            return "MyGradeBodyBean{" +
                    "update_after='" + update_after + '\'' +
                    ", XingMing='" + XingMing + '\'' +
                    ", TouXiangImg='" + TouXiangImg + '\'' +
                    ", KaHao='" + KaHao + '\'' +
                    ", YouXiang='" + YouXiang + '\'' +
                    ", WeiXinHao='" + WeiXinHao + '\'' +
                    '}';
        }

        public String getUpdate_after() {
            return update_after;
        }

        public void setUpdate_after(String update_after) {
            this.update_after = update_after;
        }

        public String getXingMing() {
            return XingMing;
        }

        public void setXingMing(String xingMing) {
            XingMing = xingMing;
        }

        public String getTouXiangImg() {
            return TouXiangImg;
        }

        public void setTouXiangImg(String touXiangImg) {
            TouXiangImg = touXiangImg;
        }

        public String getKaHao() {
            return KaHao;
        }

        public void setKaHao(String kaHao) {
            KaHao = kaHao;
        }

        public String getYouXiang() {
            return YouXiang;
        }

        public void setYouXiang(String youXiang) {
            YouXiang = youXiang;
        }

        public String getWeiXinHao() {
            return WeiXinHao;
        }

        public void setWeiXinHao(String weiXinHao) {
            WeiXinHao = weiXinHao;
        }
    }

}
