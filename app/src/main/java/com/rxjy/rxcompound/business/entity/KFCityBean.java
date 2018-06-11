package com.rxjy.rxcompound.business.entity;

import java.util.ArrayList;

/**
 * Created by hjh on 2018/5/14.
 */

public class KFCityBean {


    private String StatusMsg;
    private ArrayList<BodyBean> Body;

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
        private int FenGongSiID;
        private String GongSiMingCheng;

        public BodyBean() {
            super();
        }

        public int getFenGongSiID() {
            return FenGongSiID;
        }

        public void setFenGongSiID(int fenGongSiID) {
            FenGongSiID = fenGongSiID;
        }

        public String getGongSiMingCheng() {
            return GongSiMingCheng;
        }

        public void setGongSiMingCheng(String gongSiMingCheng) {
            GongSiMingCheng = gongSiMingCheng;
        }
    }
}
