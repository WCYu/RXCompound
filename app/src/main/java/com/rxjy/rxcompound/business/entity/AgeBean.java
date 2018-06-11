package com.rxjy.rxcompound.business.entity;

import java.util.ArrayList;

/**
 * Created by hjh on 2017/12/1.
 */

public class AgeBean {

    private int StatusCode;
    private String StatusMsg;
    private ArrayList<AgeBodyBean> Body;

    public AgeBean() {super();
    }

    @Override
    public String toString() {
        return "AgeBean{" +
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

    public ArrayList<AgeBodyBean> getBody() {
        return Body;
    }

    public void setBody(ArrayList<AgeBodyBean> body) {
        Body = body;
    }

    public class AgeBodyBean{
        private int ID;
        private String MingCheng;

        public AgeBodyBean() {super();
        }

        @Override
        public String toString() {
            return "AgeBodyBean{" +
                    "ID=" + ID +
                    ", MingCheng='" + MingCheng + '\'' +
                    '}';
        }

        public int getID() {
            return ID;
        }

        public void setID(int ID) {
            this.ID = ID;
        }

        public String getMingCheng() {
            return MingCheng;
        }

        public void setMingCheng(String mingCheng) {
            MingCheng = mingCheng;
        }
    }

}
