package com.rxjy.rxcompound.des.entity;

/**
 * Created by Administrator on 2017/10/9 0009.
 */

public class NewEightInfo {

    /**
     * StatusCode : 0
     * StatusMsg : 获取成功
     * Body : {"ci_proHead":"郭瑞","ca_proHeadIdentity":"0","ci_proSex":"1","ci_proAge":"1","ca_NoteFocus":"效率","ca_ContractPerson":"0","ca_proHeadCharacter":""}
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
         * ci_proHead : 郭瑞
         * ca_proHeadIdentity : 0
         * ci_proSex : 1
         * ci_proAge : 1
         * ca_NoteFocus : 效率
         * ca_ContractPerson : 0
         * ca_proHeadCharacter :
         */

        private String ci_proHead;
        private String ca_proHeadIdentity;
        private String ci_proSex;
        private String ci_proAge;
        private String ca_NoteFocus;
        private String ca_ContractPerson;
        private String ca_proHeadCharacter;

        public String getCi_proHead() {
            return ci_proHead;
        }

        public void setCi_proHead(String ci_proHead) {
            this.ci_proHead = ci_proHead;
        }

        public String getCa_proHeadIdentity() {
            return ca_proHeadIdentity;
        }

        public void setCa_proHeadIdentity(String ca_proHeadIdentity) {
            this.ca_proHeadIdentity = ca_proHeadIdentity;
        }

        public String getCi_proSex() {
            return ci_proSex;
        }

        public void setCi_proSex(String ci_proSex) {
            this.ci_proSex = ci_proSex;
        }

        public String getCi_proAge() {
            return ci_proAge;
        }

        public void setCi_proAge(String ci_proAge) {
            this.ci_proAge = ci_proAge;
        }

        public String getCa_NoteFocus() {
            return ca_NoteFocus;
        }

        public void setCa_NoteFocus(String ca_NoteFocus) {
            this.ca_NoteFocus = ca_NoteFocus;
        }

        public String getCa_ContractPerson() {
            return ca_ContractPerson;
        }

        public void setCa_ContractPerson(String ca_ContractPerson) {
            this.ca_ContractPerson = ca_ContractPerson;
        }

        public String getCa_proHeadCharacter() {
            return ca_proHeadCharacter;
        }

        public void setCa_proHeadCharacter(String ca_proHeadCharacter) {
            this.ca_proHeadCharacter = ca_proHeadCharacter;
        }
    }
}
