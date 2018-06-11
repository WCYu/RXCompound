package com.rxjy.rxcompound.entity;

/**
 * Created by hjh on 2017/11/20.
 */

public class IconBean {
    private int StatusCode;
    private String StatusMsg;
    private Url url;

    public IconBean() {super();
    }

    @Override
    public String toString() {
        return "IconBean{" +
                "StatusCode=" + StatusCode +
                ", StatusMsg='" + StatusMsg + '\'' +
                ", url=" + url +
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

    public Url getUrl() {
        return url;
    }

    public void setUrl(Url url) {
        this.url = url;
    }

    public class Url{
        private String url;

        public Url() {super();
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        @Override
        public String toString() {
            return "Url{" +
                    "url='" + url + '\'' +
                    '}';
        }
    }
}



