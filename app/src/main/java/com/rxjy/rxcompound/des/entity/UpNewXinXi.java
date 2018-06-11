package com.rxjy.rxcompound.des.entity;

/**
 * Created by Administrator on 2017/10/10.
 */

public class UpNewXinXi {

    /**
     * StatusCode : 0
     * StatusMsg : 更新成功
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
