package com.rxjy.rxcompound.entity;

/**
 * Created by hjh on 2017/11/20.
 */

public class UserStatusBean {

    private int StatusCode;
    private String StatusMsg;
    private UserStatusBodyBean Body;

    public UserStatusBean() {super();
    }

    @Override
    public String toString() {
        return "UserStatusBean{" +
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

    public UserStatusBodyBean getBody() {
        return Body;
    }

    public void setBody(UserStatusBodyBean body) {
        Body = body;
    }
}
