package com.rxjy.rxcompound.entity;

/**
 * Created by hjh on 2017/11/14.
 */

public class FindBean {

    private int StatusCode;
    private String StatusMsg;
    private FindBodyBean Body;

    public FindBean() {super();
    }

    @Override
    public String toString() {
        return "FindBean{" +
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

    public FindBodyBean getBody() {
        return Body;
    }

    public void setBody(FindBodyBean body) {
        Body = body;
    }
}
