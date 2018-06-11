package com.rxjy.rxcompound.entity;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by hjh on 2018/4/11.
 */

public class MoneyDBusJFKQMoreBean {
    private int StatusCode;
    private String StatusMsg;
    private ArrayList<BodyBean> Body;

    public MoneyDBusJFKQMoreBean() {super();
    }

    @Override
    public String toString() {
        return "BusMoneyBean{" +
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
//"name":"量房累计",
//        　　　　　　"flag":5,
//        　　　　　　"tm":"2018-04-03",
//        　　　　　　"reward":300,
//        　　　　　　"operater":"系统",
//        　　　　　　"remark":"量房奖励"

        private String name;
        private int flag;
        private String tm;
        private BigDecimal reward;
        private String operater;
        private String remark;

        public BodyBean() {
            super();
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getFlag() {
            return flag;
        }

        public void setFlag(int flag) {
            this.flag = flag;
        }

        public String getTm() {
            return tm;
        }

        public void setTm(String tm) {
            this.tm = tm;
        }

        public BigDecimal getReward() {
            return reward;
        }

        public void setReward(BigDecimal reward) {
            this.reward = reward;
        }

        public String getOperater() {
            return operater;
        }

        public void setOperater(String operater) {
            this.operater = operater;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        @Override
        public String toString() {
            return "BodyBean{" +
                    "name='" + name + '\'' +
                    ", flag=" + flag +
                    ", tm='" + tm + '\'' +
                    ", reward='" + reward + '\'' +
                    ", operater='" + operater + '\'' +
                    ", remark='" + remark + '\'' +
                    '}';
        }
    }
}
