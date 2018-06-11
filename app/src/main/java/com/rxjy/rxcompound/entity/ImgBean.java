package com.rxjy.rxcompound.entity;

import java.util.ArrayList;

/**
 * Created by hjh on 2017/11/20.
 */

public class ImgBean {

    private int StatusCode;
    private String StatusMsg;
    private ArrayList<String> Body;

    public ImgBean() {super();
    }

    @Override
    public String toString() {
        return "ImgBean{" +
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

    public ArrayList<String> getBody() {
        return Body;
    }

    public void setBody(ArrayList<String> body) {
        Body = body;
    }
}
