package com.rxjy.rxcompound.entity;

/**
 * Created by hjh on 2018/3/12.
 */

public class MsgNumBean {

    private int StatusCode;
    private String StatusMsg;
    private int Body;

    public MsgNumBean() {
        super();
    }

    @Override
    public String toString() {
        return "MsgNumBean{" +
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

    public int getBody() {
        return Body;
    }

    public void setBody(int body) {
        Body = body;
    }
}
