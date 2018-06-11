package com.rxjy.rxcompound.entity;

/**
 * Created by hjh on 2018/4/21.
 */

public class ImageDesBean {
    private int StatusCode;
    private String StatusMsg;
    private Body  Body;

    public ImageDesBean() {
        super();
    }

    @Override
    public String toString() {
        return "ImageDesBean{" +
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

    public ImageDesBean.Body getBody() {
        return Body;
    }

    public void setBody(ImageDesBean.Body body) {
        Body = body;
    }

    public class Body{
        private String url;

        public Body() {
            super();
        }

        @Override
        public String toString() {
            return "Body{" +
                    "url='" + url + '\'' +
                    '}';
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

}
