package com.rxjy.rxcompound.entity;

/**
 * Created by asus on 2018/5/17.
 */

public class LeaveSubmitBean {

    /**
     * StatusCode : 0
     * StatusMsg : 提交成功
     * Body : null
     */

    private int StatusCode;
    private String StatusMsg;
    private Object Body;

    public int getStatusCode() {
        return StatusCode;
    }

    public void setStatusCode(int StatusCode) {
        this.StatusCode = StatusCode;
    }

    public String getStatusMsg() {
        return StatusMsg;
    }

    public void setStatusMsg(String StatusMsg) {
        this.StatusMsg = StatusMsg;
    }

    public Object getBody() {
        return Body;
    }

    public void setBody(Object Body) {
        this.Body = Body;
    }
}
