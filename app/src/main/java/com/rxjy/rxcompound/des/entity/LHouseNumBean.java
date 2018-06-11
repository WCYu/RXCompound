package com.rxjy.rxcompound.des.entity;

/**
 * Created by hjh on 2018/4/4.
 */

public class LHouseNumBean {

    private int StatusCode;
    private String StatusMsg;
    private Body Body;

    public LHouseNumBean() {super();
    }

    @Override
    public String toString() {
        return "LHouseNumBean{" +
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

    public LHouseNumBean.Body getBody() {
        return Body;
    }

    public void setBody(LHouseNumBean.Body body) {
        Body = body;
    }

    public class Body {
        private String OrderNumber;

        public Body() {
            super();
        }

        @Override
        public String toString() {
            return "Body{" +
                    "OrderNumber='" + OrderNumber + '\'' +
                    '}';
        }

        public String getOrderNumber() {
            return OrderNumber;
        }

        public void setOrderNumber(String orderNumber) {
            OrderNumber = orderNumber;
        }
    }

}
