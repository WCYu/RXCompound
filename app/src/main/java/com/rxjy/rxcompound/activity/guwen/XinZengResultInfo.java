package com.rxjy.rxcompound.activity.guwen;

public class XinZengResultInfo {

    /**
     * StatusCode : -2
     * StatusMsg : 手机号重复
     * Body : {"XinXiYuanBaseID":""}
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
         * XinXiYuanBaseID :
         */

        private String XinXiYuanBaseID;

        public String getXinXiYuanBaseID() {
            return XinXiYuanBaseID;
        }

        public void setXinXiYuanBaseID(String XinXiYuanBaseID) {
            this.XinXiYuanBaseID = XinXiYuanBaseID;
        }
    }
}
