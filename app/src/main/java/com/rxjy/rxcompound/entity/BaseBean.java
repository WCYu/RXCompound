package com.rxjy.rxcompound.entity;

/**
 * Created by hjh on 2018/3/30.
 */

public class BaseBean {

    private int StatusCode;
    private String StatusMsg;

    public BaseBean() {super();
    }

    @Override
    public String toString() {
        return "BaseBean{" +
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
