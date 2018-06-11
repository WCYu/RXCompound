package com.rxjy.rxcompound.business.entity;

/**
 * Created by hjh on 2017/12/4.
 */

public class PersonPhoneBean {

    private int StatusCode;
    private String StatusMsg;
    private PhoneBean Body;

    @Override
    public String toString() {
        return "PersonPhoneBean{" +
                "StatusCode=" + StatusCode +
                ", StatusMsg='" + StatusMsg + '\'' +
                ", Body=" + Body +
                '}';
    }

    public int getStatusCode() {
        return StatusCode;
    }

    public void setStatusCode(int statusCode) {
        StatusCode = statusCode;
    }

    public String getStatusMsg() {
        return StatusMsg;
    }

    public void setStatusMsg(String statusMsg) {
        StatusMsg = statusMsg;
    }

    public PhoneBean getBody() {
        return Body;
    }

    public void setBody(PhoneBean body) {
        Body = body;
    }

    public PersonPhoneBean() {super();
    }

    public class PhoneBean{
        private String XinXiYuanBianHao;

        public PhoneBean() {super();
        }

        public String getXinXiYuanBianHao() {
            return XinXiYuanBianHao;
        }

        public void setXinXiYuanBianHao(String xinXiYuanBianHao) {
            XinXiYuanBianHao = xinXiYuanBianHao;
        }

        @Override
        public String toString() {
            return "PhoneBean{" +
                    "XinXiYuanBianHao='" + XinXiYuanBianHao + '\'' +
                    '}';
        }
    }
}
