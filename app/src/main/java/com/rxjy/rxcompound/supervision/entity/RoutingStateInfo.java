package com.rxjy.rxcompound.supervision.entity;

/**
 * Created by AAA on 2018/1/25.
 */

public class RoutingStateInfo {

    /**
     * StatusCode : 1
     * StatusMsg : Success
     * Body : {"BeginTime":"2018-01-18 03:32;27","EndTime":"2018-01-25 03:32;27","Isstatus":1}
     */

    private int StatusCode;
    private String StatusMsg;
    private RoutingState Body;

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

    public RoutingState getBody() {
        return Body;
    }

    public void setBody(RoutingState Body) {
        this.Body = Body;
    }

    public static class RoutingState {
        /**
         * BeginTime : 2018-01-18 03:32;27
         * EndTime : 2018-01-25 03:32;27
         * Isstatus : 1
         */

        private String BeginTime;
        private String EndTime;
        private int Isstatus;
        private int xj_id;
        private int Closetype;

        public String getBeginTime() {
            return BeginTime;
        }

        public void setBeginTime(String BeginTime) {
            this.BeginTime = BeginTime;
        }

        public String getEndTime() {
            return EndTime;
        }

        public void setEndTime(String EndTime) {
            this.EndTime = EndTime;
        }

        public int getIsstatus() {
            return Isstatus;
        }

        public void setIsstatus(int Isstatus) {
            this.Isstatus = Isstatus;
        }

        public int getXj_id() {
            return xj_id;
        }

        public void setXj_id(int xj_id) {
            this.xj_id = xj_id;
        }

        public int getClosetype() {
            return Closetype;
        }

        public void setClosetype(int closetype) {
            Closetype = closetype;
        }
    }
}
