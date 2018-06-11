package com.rxjy.rxcompound.entity;

import java.util.List;

/**
 * Created by asus on 2018/5/17.
 */

public class LeaveBean {


    /**
     * StatusCode : 0
     * StatusMsg : 获取成功
     * Body : [{"Id":5,"BeginTime":"2018-05-11T14:00:00","EndTime":"2018-05-12T14:00:00","CreateTime":"2018-05-11T14:00:14.62","Cardno":"01014133","Days":1,"Type":228,"TypeName":"事假","UName":"测赵静","Reason":"1","Flag":0,"Region":11,"OpreatCardNo":null,"State":0}]
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
         * Id : 5
         * BeginTime : 2018-05-11T14:00:00
         * EndTime : 2018-05-12T14:00:00
         * CreateTime : 2018-05-11T14:00:14.62
         * Cardno : 01014133
         * Days : 1.0
         * Type : 228
         * TypeName : 事假
         * UName : 测赵静
         * Reason : 1
         * Flag : 0
         * Region : 11
         * OpreatCardNo : null
         * State : 0
         */

        private int Id;
        private String BeginTime;
        private String EndTime;
        private String CreateTime;
        private String Cardno;
        private double Days;
        private int Type;
        private String TypeName;
        private String UName;
        private String Reason;
        private int Flag;
        private int Region;
        private Object OpreatCardNo;
        private int State;

        public int getId() {
            return Id;
        }

        public void setId(int Id) {
            this.Id = Id;
        }

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

        public String getCreateTime() {
            return CreateTime;
        }

        public void setCreateTime(String CreateTime) {
            this.CreateTime = CreateTime;
        }

        public String getCardno() {
            return Cardno;
        }

        public void setCardno(String Cardno) {
            this.Cardno = Cardno;
        }

        public double getDays() {
            return Days;
        }

        public void setDays(double Days) {
            this.Days = Days;
        }

        public int getType() {
            return Type;
        }

        public void setType(int Type) {
            this.Type = Type;
        }

        public String getTypeName() {
            return TypeName;
        }

        public void setTypeName(String TypeName) {
            this.TypeName = TypeName;
        }

        public String getUName() {
            return UName;
        }

        public void setUName(String UName) {
            this.UName = UName;
        }

        public String getReason() {
            return Reason;
        }

        public void setReason(String Reason) {
            this.Reason = Reason;
        }

        public int getFlag() {
            return Flag;
        }

        public void setFlag(int Flag) {
            this.Flag = Flag;
        }

        public int getRegion() {
            return Region;
        }

        public void setRegion(int Region) {
            this.Region = Region;
        }

        public Object getOpreatCardNo() {
            return OpreatCardNo;
        }

        public void setOpreatCardNo(Object OpreatCardNo) {
            this.OpreatCardNo = OpreatCardNo;
        }

        public int getState() {
            return State;
        }

        public void setState(int State) {
            this.State = State;
        }
    }
}
