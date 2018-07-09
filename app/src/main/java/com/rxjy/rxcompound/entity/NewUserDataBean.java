package com.rxjy.rxcompound.entity;

/**
 * Created by 阿禹 on 2018/6/28.
 */

public class NewUserDataBean {

    /**
     * StatusCode : 0
     * StatusMsg : 获取成功
     * Body : {"Z2state":"未","carstate":"待","staystate":"待"}
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
         * Z2state : 未
         * carstate : 待
         * staystate : 待
         */

        private String Z2state;
        private String carstate;
        private String staystate;

        public String getZ2state() {
            return Z2state;
        }

        public void setZ2state(String Z2state) {
            this.Z2state = Z2state;
        }

        public String getCarstate() {
            return carstate;
        }

        public void setCarstate(String carstate) {
            this.carstate = carstate;
        }

        public String getStaystate() {
            return staystate;
        }

        public void setStaystate(String staystate) {
            this.staystate = staystate;
        }
    }
}
