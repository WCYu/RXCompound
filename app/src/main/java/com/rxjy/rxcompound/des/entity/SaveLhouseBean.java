package com.rxjy.rxcompound.des.entity;

/**
 * Created by hjh on 2017/12/25.
 */

public class SaveLhouseBean {

    private int StatusCode;
    private String StatusMsg;

    public SaveLhouseBean() {super();
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

    @Override
    public String toString() {
        return "SaveLhouseBean{" +
                "StatusCode=" + StatusCode +
                ", StatusMsg='" + StatusMsg + '\'' +
                '}';
    }
}
