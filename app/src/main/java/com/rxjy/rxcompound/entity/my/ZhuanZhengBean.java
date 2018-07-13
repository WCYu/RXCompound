package com.rxjy.rxcompound.entity.my;

/**
 * Created by 阿禹 on 2018/6/21.
 */

public class ZhuanZhengBean {

    /**
     * StatusCode : 0
     * StatusMsg : 获取成功！
     * Body : {"hege":-1,"zhuanzhengTimeStr":"转正时间未到;","zhuanzhengTime":"2018-07-30"}
     */

    private int StatusCode;
    private String StatusMsg;
    private BodyBean Body;

    public int getStatusCode() {
        return StatusCode;
    }

    public void setStatusCode(int StatusCode) {
        this.StatusCode = StatusCode;
    }

    public String getStatusMsg() {
        return StatusMsg;
    }

    public void setStatusMsg(String StatusMsg) {
        this.StatusMsg = StatusMsg;
    }

    public BodyBean getBody() {
        return Body;
    }

    public void setBody(BodyBean Body) {
        this.Body = Body;
    }

    public static class BodyBean {
        /**
         * hege : -1
         * zhuanzhengTimeStr : 转正时间未到;
         * zhuanzhengTime : 2018-07-30
         */

        private int hege;
        private String zhuanzhengTimeStr;
        private String zhuanzhengTime;

        public int getHege() {
            return hege;
        }

        public void setHege(int hege) {
            this.hege = hege;
        }

        public String getZhuanzhengTimeStr() {
            return zhuanzhengTimeStr;
        }

        public void setZhuanzhengTimeStr(String zhuanzhengTimeStr) {
            this.zhuanzhengTimeStr = zhuanzhengTimeStr;
        }

        public String getZhuanzhengTime() {
            return zhuanzhengTime;
        }

        public void setZhuanzhengTime(String zhuanzhengTime) {
            this.zhuanzhengTime = zhuanzhengTime;
        }
    }
}
