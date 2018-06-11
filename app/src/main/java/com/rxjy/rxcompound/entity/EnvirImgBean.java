package com.rxjy.rxcompound.entity;

import java.util.ArrayList;

/**
 * Created by hjh on 2018/4/26.
 */

public class EnvirImgBean {

    private int StatusCode;
    private String StatusMsg;
    private ArrayList<BodyBean> Body;

    public EnvirImgBean() {
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

//         "id":344,
//                 "xzId":335,
//                 "imgUrl":"http://192.168.1.172:15001/M00/00/13/wKgBrFpQbziAKEZ4AAIDzfGcc3I130.jpg",
//                 "imgName":"商务-柜.jpg"

        private String imgUrl;

        public BodyBean() {
            super();
        }

        @Override
        public String toString() {
            return "BodyBean{" +
                    "imgUrl='" + imgUrl + '\'' +
                    '}';
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }
    }
}
