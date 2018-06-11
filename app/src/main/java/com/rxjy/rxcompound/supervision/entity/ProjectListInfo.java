package com.rxjy.rxcompound.supervision.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/4/29.
 */
public class ProjectListInfo {

    private int StatusCode;
    private String StatusMsg;

    private List<Project> Body;

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

    public List<Project> getBody() {
        return Body;
    }

    public void setBody(List<Project> Body) {
        this.Body = Body;
    }

    public static class Project implements Serializable {
        private String OrderNo;
        private int CityID;
        private String ProName;
        private String ProAddr;
        private int State;
        private String BeginTime;
        private String EndTime;
        private int WorkDays;
        private double ProArea;
        private String ContractDate;
        private String UserName;
        private String mobile;
        private int CarmaCount;
        private int ProType;

        public int getProType() {
            return ProType;
        }

        public void setProType(int proType) {
            ProType = proType;
        }

        public int getCarmaCount() {
            return CarmaCount;
        }

        public void setCarmaCount(int carmaCount) {
            CarmaCount = carmaCount;
        }

        public String getUserName() {
            return UserName;
        }

        public void setUserName(String userName) {
            UserName = userName;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getOrderNo() {
            return OrderNo;
        }

        public void setOrderNo(String OrderNo) {
            this.OrderNo = OrderNo;
        }

        public int getCityID() {
            return CityID;
        }

        public void setCityID(int CityID) {
            this.CityID = CityID;
        }

        public String getProName() {
            return ProName;
        }

        public void setProName(String ProName) {
            this.ProName = ProName;
        }

        public String getProAddr() {
            return ProAddr;
        }

        public void setProAddr(String ProAddr) {
            this.ProAddr = ProAddr;
        }

        public int getState() {
            return State;
        }

        public void setState(int State) {
            this.State = State;
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

        public int getWorkDays() {
            return WorkDays;
        }

        public void setWorkDays(int WorkDays) {
            this.WorkDays = WorkDays;
        }

        public double getProArea() {
            return ProArea;
        }

        public void setProArea(double ProArea) {
            this.ProArea = ProArea;
        }

        public String getContractDate() {
            return ContractDate;
        }

        public void setContractDate(String ContractDate) {
            this.ContractDate = ContractDate;
        }
    }
}
