package com.rxjy.rxcompound.entity;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by hjh on 2018/3/14.
 */

public class BusProcessBean {

    private int StatusCode;
    private String StatusMsg;
    private ArrayList<BodyBean> Body;

    public BusProcessBean() {
        super();
    }

    @Override
    public String toString() {
        return "BusProcessBean{" +
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
//"agentVisit":0,
//        "messengerVisit":0,
//        "xfInCome":311,
//        "jfInCome":0,
//        "sagentVisit":42,
//        "smessengerVisit":1278

        private int smessengerVisit;
        private BigDecimal xfInCome;
        private int agentVisit;
        private int messengerVisit;
        private BigDecimal jfInCome;
        private int sagentVisit;


        public BodyBean() {super();
        }

        @Override
        public String toString() {
            return "BodyBean{" +
                    "smessengerVisit=" + smessengerVisit +
                    ", xfInCome=" + xfInCome +
                    ", agentVisit=" + agentVisit +
                    ", messengerVisit=" + messengerVisit +
                    ", jfInCome=" + jfInCome +
                    ", sagentVisit=" + sagentVisit +
                    '}';
        }

        public int getSmessengerVisit() {
            return smessengerVisit;
        }

        public void setSmessengerVisit(int smessengerVisit) {
            this.smessengerVisit = smessengerVisit;
        }

        public BigDecimal getJfInCome() {
            return jfInCome;
        }

        public void setJfInCome(BigDecimal jfInCome) {
            this.jfInCome = jfInCome;
        }

        public BigDecimal getXfInCome() {
            return xfInCome;
        }

        public void setXfInCome(BigDecimal xfInCome) {
            this.xfInCome = xfInCome;
        }

        public int getAgentVisit() {
            return agentVisit;
        }

        public void setAgentVisit(int agentVisit) {
            this.agentVisit = agentVisit;
        }

        public int getMessengerVisit() {
            return messengerVisit;
        }

        public void setMessengerVisit(int messengerVisit) {
            this.messengerVisit = messengerVisit;
        }


        public int getSagentVisit() {
            return sagentVisit;
        }

        public void setSagentVisit(int sagentVisit) {
            this.sagentVisit = sagentVisit;
        }
    }
}
