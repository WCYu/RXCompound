package com.rxjy.rxcompound.des.entity;

/**
 * Created by Administrator on 2017/10/12.
 */

public class UpDanHaoInfo {

    /**
     * StatusCode : 0
     * StatusMsg : Success
     * Body :
     */

    private int StatusCode;
    private String StatusMsg;
    private String Body;

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

    public String getBody() {
        return Body;
    }

    public void setBody(String Body) {
        this.Body = Body;
    }
}
