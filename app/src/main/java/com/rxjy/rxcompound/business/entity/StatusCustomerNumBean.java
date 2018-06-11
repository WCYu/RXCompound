package com.rxjy.rxcompound.business.entity;

/**
 * Created by Administrator on 2017/12/19.
 */

public class StatusCustomerNumBean {

    private int StatusCode;
    private String StatusMsg;
    private StatusBody Body;

    public StatusCustomerNumBean() {super();
    }

    @Override
    public String toString() {
        return "StatusBean{" +
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

    public StatusBody getBody() {
        return Body;
    }

    public void setBody(StatusBody body) {
        Body = body;
    }

    public class StatusBody{
        private String KeHuBaseID;

        public StatusBody() {super();
        }

        @Override
        public String toString() {
            return "StatusBody{" +
                    "KeHuBaseID='" + KeHuBaseID + '\'' +
                    '}';
        }

        public String getKeHuBaseID() {
            return KeHuBaseID;
        }

        public void setKeHuBaseID(String keHuBaseID) {
            KeHuBaseID = keHuBaseID;
        }
    }

}
