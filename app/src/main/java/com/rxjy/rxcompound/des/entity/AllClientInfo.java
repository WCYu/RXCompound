package com.rxjy.rxcompound.des.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/6/19.
 */
public class AllClientInfo implements Serializable {

    private int StatusCode;
    private String StatusMsg;

    private List<ClientTypeInfo> Body;

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

    public List<ClientTypeInfo> getBody() {
        return Body;
    }

    public void setBody(List<ClientTypeInfo> Body) {
        this.Body = Body;
    }

    public static class ClientTypeInfo implements Serializable {
        private int stage;
        private int total;

        private List<ClientInfo> list;

        public int getStage() {
            return stage;
        }

        public void setStage(int stage) {
            this.stage = stage;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<ClientInfo> getList() {
            return list;
        }

        public void setList(List<ClientInfo> list) {
            this.list = list;
        }

        public static class ClientInfo implements Serializable {
            private String ci_rwdid;
            private String ci_ClientName;
            private int WorksID;
            private int CustomerID;
            private String ci_DesignerCard;
            private String time1;
            private String time2;
            private String ci_DecorationAddress;
            private String Mobile;
            private int rpstate;
            private String StateName;
            private String PatrolProgress;
            private int JDMoney;

            public String getPatrolProgress() {
                return PatrolProgress;
            }

            public void setPatrolProgress(String patrolProgress) {
                PatrolProgress = patrolProgress;
            }

            public String getCi_rwdid() {
                return ci_rwdid;
            }

            public void setCi_rwdid(String ci_rwdid) {
                this.ci_rwdid = ci_rwdid;
            }

            public String getCi_ClientName() {
                return ci_ClientName;
            }

            public void setCi_ClientName(String ci_ClientName) {
                this.ci_ClientName = ci_ClientName;
            }

            public int getWorksID() {
                return WorksID;
            }

            public void setWorksID(int WorksID) {
                this.WorksID = WorksID;
            }

            public int getCustomerID() {
                return CustomerID;
            }

            public void setCustomerID(int CustomerID) {
                this.CustomerID = CustomerID;
            }

            public String getCi_DesignerCard() {
                return ci_DesignerCard;
            }

            public void setCi_DesignerCard(String ci_DesignerCard) {
                this.ci_DesignerCard = ci_DesignerCard;
            }

            public String getTime1() {
                return time1;
            }

            public void setTime1(String time1) {
                this.time1 = time1;
            }

            public String getTime2() {
                return time2;
            }

            public void setTime2(String time2) {
                this.time2 = time2;
            }

            public String getCi_DecorationAddress() {
                return ci_DecorationAddress;
            }

            public void setCi_DecorationAddress(String ci_DecorationAddress) {
                this.ci_DecorationAddress = ci_DecorationAddress;
            }

            public String getMobile() {
                return Mobile;
            }

            public void setMobile(String Mobile) {
                this.Mobile = Mobile;
            }

            public int getRpstate() {
                return rpstate;
            }

            public void setRpstate(int rpstate) {
                this.rpstate = rpstate;
            }

            public String getStateName() {
                return StateName;
            }

            public void setStateName(String StateName) {
                this.StateName = StateName;
            }

            public int getJDMoney() {
                return JDMoney;
            }

            public void setJDMoney(int JDMoney) {
                this.JDMoney = JDMoney;
            }
        }
    }
}
