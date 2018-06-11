package com.rxjy.rxcompound.des.entity;

/**
 * Created by AAA on 2017/7/27.
 */

public class SubInfo {

    /**
     * StatusCode : 0
     * StatusMsg : 注册成功！
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
