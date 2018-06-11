package com.rxjy.rxcompound.entity;

import java.util.ArrayList;

/**
 * Created by hjh on 2017/11/17.
 */

public class BankBean {

    private int StatusCode;
    private String StatusMsg;
    private ArrayList<BankBodyBean> Body;

    public BankBean() {super();
    }

    @Override
    public String toString() {
        return "BankBean{" +
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

    public ArrayList<BankBodyBean> getBody() {
        return Body;
    }

    public void setBody(ArrayList<BankBodyBean> body) {
        Body = body;
    }
}
