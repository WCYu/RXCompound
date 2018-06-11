package com.rxjy.rxcompound.entity;

import java.util.ArrayList;

/**
 * Created by hjh on 2017/11/22.
 */

public class InfoMessageBean {

    private int StatusCode;
    private String StatusMsg;
    private ArrayList<InfoMessageBodyBean> Body;

    @Override
    public String toString() {
        return "InfoMessageBean{" +
                "StatusCode=" + StatusCode +
                ", StatusMsg='" + StatusMsg + '\'' +
                ", Body=" + Body +
                '}';
    }

    public InfoMessageBean() {super();
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

    public ArrayList<InfoMessageBodyBean> getBody() {
        return Body;
    }

    public void setBody(ArrayList<InfoMessageBodyBean> body) {
        Body = body;
    }
}
