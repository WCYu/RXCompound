package com.rxjy.rxcompound.business.entity;

import java.util.ArrayList;

/**
 * Created by hjh on 2017/12/1.
 */

public class AddressBean {

    private int StatusCode;
    private String StatusMsg;
    private ArrayList<AddressBodyBean> Body;

    public AddressBean() {super();
    }

    @Override
    public String toString() {
        return "AddressBean{" +
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

    public ArrayList<AddressBodyBean> getBody() {
        return Body;
    }

    public void setBody(ArrayList<AddressBodyBean> body) {
        Body = body;
    }

    public class AddressBodyBean{
        private int FenGongSiID;
        private String Name;

        public AddressBodyBean() {super();
        }

        @Override
        public String toString() {
            return "AddressBodyBean{" +
                    "FenGongSiID=" + FenGongSiID +
                    ", Name='" + Name + '\'' +
                    '}';
        }

        public int getFenGongSiID() {
            return FenGongSiID;
        }

        public void setFenGongSiID(int fenGongSiID) {
            FenGongSiID = fenGongSiID;
        }

        public String getName() {
            return Name;
        }

        public void setName(String name) {
            Name = name;
        }

    }

}
