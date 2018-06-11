package com.rxjy.rxcompound.entity;

import java.util.ArrayList;

/**
 * Created by hjh on 2017/11/28.
 */

public class ImagesBean {

    private int StatusCode;
    private String StatusMsg;
    private ArrayList<ImagesBody> Body;

    public ImagesBean() {super();
    }

    @Override
    public String toString() {
        return "ImagesBean{" +
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

    public ArrayList<ImagesBody> getBody() {
        return Body;
    }

    public void setBody(ArrayList<ImagesBody> body) {
        Body = body;
    }

    public class ImagesBody{
        private String card_no;
        private String img_name;
        private String img_url;
        private int img_type;
        private int flag;

        public ImagesBody() {super();
        }

        @Override
        public String toString() {
            return "ImagesBody{" +
                    "card_no='" + card_no + '\'' +
                    ", img_name='" + img_name + '\'' +
                    ", img_url='" + img_url + '\'' +
                    ", img_type=" + img_type +
                    ", flag=" + flag +
                    '}';
        }

        public String getCard_no() {
            return card_no;
        }

        public void setCard_no(String card_no) {
            this.card_no = card_no;
        }

        public String getImg_name() {
            return img_name;
        }

        public void setImg_name(String img_name) {
            this.img_name = img_name;
        }

        public String getImg_url() {
            return img_url;
        }

        public void setImg_url(String img_url) {
            this.img_url = img_url;
        }

        public int getImg_type() {
            return img_type;
        }

        public void setImg_type(int img_type) {
            this.img_type = img_type;
        }

        public int getFlag() {
            return flag;
        }

        public void setFlag(int flag) {
            this.flag = flag;
        }
    }

}
