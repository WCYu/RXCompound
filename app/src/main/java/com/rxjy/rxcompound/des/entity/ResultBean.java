package com.rxjy.rxcompound.des.entity;

/**
 * Created by hjh on 2018/4/16.
 */

public class ResultBean {

    private int StatusCode;
    private String StatusMsg;

    public ResultBean() {
        super();
    }

    @Override
    public String toString() {
        return "ResultBean{" +
                "StatusCode=" + StatusCode +
                ", StatusMsg='" + StatusMsg + '\'' +
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
}
