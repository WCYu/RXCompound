package com.rxjy.rxcompound.entity;

/**
 * Created by hjh on 2017/11/10.
 */

public class PersonBean {

    private int StatusCode;
    private String StatusMsg;
    private PersonDataBean Body;

    public PersonBean() {super();
    }

    @Override
    public String toString() {
        return "PersonBean{" +
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

    public PersonDataBean getBody() {
        return Body;
    }

    public void setBody(PersonDataBean body) {
        Body = body;
    }
}
