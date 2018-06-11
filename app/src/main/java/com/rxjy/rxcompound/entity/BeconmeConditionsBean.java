package com.rxjy.rxcompound.entity;

/**
 * Created by asus on 2018/5/18.
 */

public class BeconmeConditionsBean  {

    /**
     * StatusCode : 0
     * StatusMsg : 获取成功
     * Body : {"ApplyFormalUserTime":"0001/01/01","ApplyFormalUserCondition":"合同需要上传并集团审核通过;人事考核未通过;"}
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
         * ApplyFormalUserTime : 0001/01/01
         * ApplyFormalUserCondition : 合同需要上传并集团审核通过;人事考核未通过;
         */

        private String ApplyFormalUserTime;
        private String ApplyFormalUserCondition;

        public String getApplyFormalUserTime() {
            return ApplyFormalUserTime;
        }

        public void setApplyFormalUserTime(String ApplyFormalUserTime) {
            this.ApplyFormalUserTime = ApplyFormalUserTime;
        }

        public String getApplyFormalUserCondition() {
            return ApplyFormalUserCondition;
        }

        public void setApplyFormalUserCondition(String ApplyFormalUserCondition) {
            this.ApplyFormalUserCondition = ApplyFormalUserCondition;
        }
    }
}
