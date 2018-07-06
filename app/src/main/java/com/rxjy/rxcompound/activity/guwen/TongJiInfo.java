package com.rxjy.rxcompound.activity.guwen;

import java.util.List;

public class TongJiInfo {

    /**
     * StatusCode : 0
     * StatusMsg : 请求成功
     * Body : [{"Tatal":37,"Messenger":31,"Agent":6,"IsInstall":21}]
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
         * Tatal : 37
         * Messenger : 31
         * Agent : 6
         * IsInstall : 21
         */

        private int Tatal;
        private int Messenger;
        private int Agent;
        private int IsInstall;

        public int getTatal() {
            return Tatal;
        }

        public void setTatal(int Tatal) {
            this.Tatal = Tatal;
        }

        public int getMessenger() {
            return Messenger;
        }

        public void setMessenger(int Messenger) {
            this.Messenger = Messenger;
        }

        public int getAgent() {
            return Agent;
        }

        public void setAgent(int Agent) {
            this.Agent = Agent;
        }

        public int getIsInstall() {
            return IsInstall;
        }

        public void setIsInstall(int IsInstall) {
            this.IsInstall = IsInstall;
        }
    }
}
