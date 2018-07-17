package com.example.asus.customer.entity;

/**
 * Created by asus on 2018/5/30.
 */

public class QRresultBean {

    /**
     * event : 登陆web
     * parameter : {"app_id":4,"login_id":"RX336D35FEBD864923B0632011E44FA0B2"}
     */

    private String event;
    private ParameterBean parameter;

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public ParameterBean getParameter() {
        return parameter;
    }

    public void setParameter(ParameterBean parameter) {
        this.parameter = parameter;
    }

    public static class ParameterBean {
        /**
         * app_id : 4
         * login_id : RX336D35FEBD864923B0632011E44FA0B2
         */

        private int app_id;
        private String login_id;

        public int getApp_id() {
            return app_id;
        }

        public void setApp_id(int app_id) {
            this.app_id = app_id;
        }

        public String getLogin_id() {
            return login_id;
        }

        public void setLogin_id(String login_id) {
            this.login_id = login_id;
        }
    }
}
