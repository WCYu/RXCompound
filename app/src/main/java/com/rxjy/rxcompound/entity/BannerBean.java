package com.rxjy.rxcompound.entity;

import java.util.ArrayList;

/**
 * Created by hjh on 2017/11/13.
 */

public class BannerBean {

    private int StatusCode;
    private String StatusMsg;
    private ArrayList<BannerDataBean> Body;

    public BannerBean() {
        super();
    }

    @Override
    public String toString() {
        return "BannerBean{" +
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

    public ArrayList<BannerDataBean> getBody() {
        return Body;
    }

    public void setBody(ArrayList<BannerDataBean> body) {
        Body = body;
    }
}
