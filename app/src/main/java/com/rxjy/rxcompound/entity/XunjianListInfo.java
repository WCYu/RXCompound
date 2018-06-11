package com.rxjy.rxcompound.entity;

import java.util.List;

/**
 * Created by Administrator on 2017/10/24.
 */

public class XunjianListInfo {


    /**
     * StatusCode : 0
     * StatusMsg : Success
     * Body : [{"sc_Id":160,"sc_RwdId":"12-197631","sc_Times":1,"sc_CheckTime":"2017-10-15","sc_ActualCheckTime":null,"sc_StateName":"待办"},{"sc_Id":161,"sc_RwdId":"12-197631","sc_Times":2,"sc_CheckTime":"2017-11-01","sc_ActualCheckTime":null,"sc_StateName":"待办"},{"sc_Id":162,"sc_RwdId":"12-197631","sc_Times":3,"sc_CheckTime":"2017-12-21","sc_ActualCheckTime":null,"sc_StateName":"待办"}]
     */

    private int StatusCode;
    private String StatusMsg;
    private List<BodyBean> Body;

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

    public List<BodyBean> getBody() {
        return Body;
    }

    public void setBody(List<BodyBean> Body) {
        this.Body = Body;
    }

    public static class BodyBean {
        /**
         * sc_Id : 160
         * sc_RwdId : 12-197631
         * sc_Times : 1
         * sc_CheckTime : 2017-10-15
         * sc_ActualCheckTime : null
         * sc_StateName : 待办
         */

        private int sc_Id;
        private String sc_RwdId;
        private int sc_Times;
        private String sc_CheckTime;
        private Object sc_ActualCheckTime;
        private String sc_StateName;

        public int getSc_Id() {
            return sc_Id;
        }

        public void setSc_Id(int sc_Id) {
            this.sc_Id = sc_Id;
        }

        public String getSc_RwdId() {
            return sc_RwdId;
        }

        public void setSc_RwdId(String sc_RwdId) {
            this.sc_RwdId = sc_RwdId;
        }

        public int getSc_Times() {
            return sc_Times;
        }

        public void setSc_Times(int sc_Times) {
            this.sc_Times = sc_Times;
        }

        public String getSc_CheckTime() {
            return sc_CheckTime;
        }

        public void setSc_CheckTime(String sc_CheckTime) {
            this.sc_CheckTime = sc_CheckTime;
        }

        public Object getSc_ActualCheckTime() {
            return sc_ActualCheckTime;
        }

        public void setSc_ActualCheckTime(Object sc_ActualCheckTime) {
            this.sc_ActualCheckTime = sc_ActualCheckTime;
        }

        public String getSc_StateName() {
            return sc_StateName;
        }

        public void setSc_StateName(String sc_StateName) {
            this.sc_StateName = sc_StateName;
        }
    }
}
