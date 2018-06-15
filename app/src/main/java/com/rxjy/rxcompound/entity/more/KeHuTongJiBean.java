package com.rxjy.rxcompound.entity.more;

import java.util.List;

/**
 * Created by 阿禹 on 2018/6/15.
 */

public class KeHuTongJiBean {

    /**
     * StatusCode : 0
     * StatusMsg : 请求成功
     * Body : [{"Status":"在跟踪","Num":0},{"Status":"打回","Num":0},{"Status":"审批","Num":0},{"Status":"在谈","Num":0},{"Status":"已签","Num":0},{"Status":"未签","Num":0}]
     */

    private int StatusCode;
    private String StatusMsg;
    private List<BodyBean> Body;

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

    public List<BodyBean> getBody() {
        return Body;
    }

    public void setBody(List<BodyBean> Body) {
        this.Body = Body;
    }

    public static class BodyBean {
        /**
         * Status : 在跟踪
         * Num : 0
         */

        private String Status;
        private int Num;

        public String getStatus() {
            return Status;
        }

        public void setStatus(String Status) {
            this.Status = Status;
        }

        public int getNum() {
            return Num;
        }

        public void setNum(int Num) {
            this.Num = Num;
        }
    }
}
