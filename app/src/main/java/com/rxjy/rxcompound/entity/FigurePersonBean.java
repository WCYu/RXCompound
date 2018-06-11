package com.rxjy.rxcompound.entity;

import java.util.ArrayList;

/**
 * Created by hjh on 2018/4/25.
 */

public class FigurePersonBean {

    private int StatusCode;
    private String StatusMsg;
    private ArrayList<BodyBean> Body;

    public FigurePersonBean() {
        super();
    }

    @Override
    public String toString() {
        return "BusResultBean{" +
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
//         "UserCardno":"00002000",
//                 "UserName":"卞赛男",
//                 "RegionName":null,
//                 "RegionId":0,
//                 "DepartName":null,
//                 "DepartId":0,
//                 "PositionName":null,
//                 "PositionId":0,
//                 "CompanyName":null,
//                 "CompanyId":0,
//                 "UserState":0
        private String UserCardno;
        private String UserName;

        public BodyBean() {
            super();
        }

        @Override
        public String toString() {
            return "BodyBean{" +
                    "UserCardno='" + UserCardno + '\'' +
                    ", UserName='" + UserName + '\'' +
                    '}';
        }

        public String getUserCardno() {
            return UserCardno;
        }

        public void setUserCardno(String userCardno) {
            UserCardno = userCardno;
        }

        public String getUserName() {
            return UserName;
        }

        public void setUserName(String userName) {
            UserName = userName;
        }
    }
}
