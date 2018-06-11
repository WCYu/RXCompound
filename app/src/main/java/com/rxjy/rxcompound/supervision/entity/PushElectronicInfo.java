package com.rxjy.rxcompound.supervision.entity;

/**
 * Created by AAA on 2017/12/21.
 */

public class PushElectronicInfo {

    /**
     * StatusCode : 1
     * StatusMsg : 成功
     * Body : {"eleid":0,"content":" ","attr_model_id":25}
     */

    private int StatusCode;
    private String StatusMsg;
    private PushElectronic Body;

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

    public PushElectronic getBody() {
        return Body;
    }

    public void setBody(PushElectronic Body) {
        this.Body = Body;
    }

    public static class PushElectronic {
        /**
         * eleid : 0
         * content :
         * attr_model_id : 25
         */

        private int eleid;
        private String content;
        private int attr_model_id;

        public int getEleid() {
            return eleid;
        }

        public void setEleid(int eleid) {
            this.eleid = eleid;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getAttr_model_id() {
            return attr_model_id;
        }

        public void setAttr_model_id(int attr_model_id) {
            this.attr_model_id = attr_model_id;
        }
    }
}
