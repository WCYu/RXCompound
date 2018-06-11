package com.rxjy.rxcompound.entity;

/**
 * Created by asus on 2018/5/15.
 */

public class ManagementBean {


    /**
     * StatusCode : 0
     * StatusMsg : 获取成功
     * Body : {"isManage":0}
     */

    private int StatusCode;
    private String StatusMsg;
    private BodyBean Body;

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

    public BodyBean getBody() {
        return Body;
    }

    public void setBody(BodyBean Body) {
        this.Body = Body;
    }

    public static class BodyBean {
        /**
         * isManage : 0
         */

        private int isManage;

        public int getIsManage() {
            return isManage;
        }

        public void setIsManage(int isManage) {
            this.isManage = isManage;
        }
    }
}
