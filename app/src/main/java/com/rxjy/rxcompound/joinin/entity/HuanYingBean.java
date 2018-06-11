package com.rxjy.rxcompound.joinin.entity;

/**
 * Created by asus on 2018/5/31.
 */

public class HuanYingBean {


    /**
     * StatusCode : 0
     * StatusMsg : 成功
     * Body : {"Welcomes":"欢迎落安来到瑞祥加盟"}
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
         * Welcomes : 欢迎落安来到瑞祥加盟
         */

        private String Welcomes;

        public String getWelcomes() {
            return Welcomes;
        }

        public void setWelcomes(String Welcomes) {
            this.Welcomes = Welcomes;
        }
    }
}
