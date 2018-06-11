package com.rxjy.rxcompound.entity;

/**
 * Created by hjh on 2017/11/7.
 */

public class CheckIsBeingBean {

    private int StatusCode;
    private String StatusMsg;
    private BodyBean Body;

    public CheckIsBeingBean() {super();
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

    public BodyBean getBody() {
        return Body;
    }

    public void setBody(BodyBean body) {
        Body = body;
    }

    @Override
    public String toString() {
        return "CheckIsBeingBean{" +
                "StatusCode=" + StatusCode +
                ", StatusMsg='" + StatusMsg + '\'' +
                ", Body=" + Body +
                '}';
    }
}
