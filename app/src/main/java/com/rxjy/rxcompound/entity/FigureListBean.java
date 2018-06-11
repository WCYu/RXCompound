package com.rxjy.rxcompound.entity;

import java.util.ArrayList;

/**
 * Created by hjh on 2018/4/26.
 */

public class FigureListBean {

    private int StatusCode;
    private String StatusMsg;
    private ArrayList<BodyBean> Body;

    public FigureListBean() {
        super();
    }

    @Override
    public String toString() {
        return "FigureListBean{" +
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

    public ArrayList<BodyBean> getBody() {
        return Body;
    }

    public void setBody(ArrayList<BodyBean> body) {
        Body = body;
    }

    public class BodyBean{
//        "id":268,
//                "contentId":0,
//                "region":11,
//                "dept":2,
//                "areaId":0,
//                "checkItem":1,
//                "areaName":null

        private int id;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }

}
