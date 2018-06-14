package com.rxjy.rxcompound.entity.more;

/**
 * Created by 阿禹 on 2018/6/12.
 */

public class JiFenBean {

    /**
     * StatusCode : 0
     * StatusMsg : 获取成功
     * Body : {"Spare1":18,"RewardPercent":1.7,"RewardRoom":700,"CRewardRoom":350,"SignOrderUp":500,"SignOrderDown":80,"MeasureHourse":15}
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
         * Spare1 : 18
         * RewardPercent : 1.7
         * RewardRoom : 700.0
         * CRewardRoom : 350.0
         * SignOrderUp : 500.0
         * SignOrderDown : 80.0
         * MeasureHourse : 15
         */

        private int Spare1;
        private double RewardPercent;
        private double RewardRoom;
        private double CRewardRoom;
        private double SignOrderUp;
        private double SignOrderDown;
        private int MeasureHourse;

        public int getSpare1() {
            return Spare1;
        }

        public void setSpare1(int Spare1) {
            this.Spare1 = Spare1;
        }

        public double getRewardPercent() {
            return RewardPercent;
        }

        public void setRewardPercent(double RewardPercent) {
            this.RewardPercent = RewardPercent;
        }

        public double getRewardRoom() {
            return RewardRoom;
        }

        public void setRewardRoom(double RewardRoom) {
            this.RewardRoom = RewardRoom;
        }

        public double getCRewardRoom() {
            return CRewardRoom;
        }

        public void setCRewardRoom(double CRewardRoom) {
            this.CRewardRoom = CRewardRoom;
        }

        public double getSignOrderUp() {
            return SignOrderUp;
        }

        public void setSignOrderUp(double SignOrderUp) {
            this.SignOrderUp = SignOrderUp;
        }

        public double getSignOrderDown() {
            return SignOrderDown;
        }

        public void setSignOrderDown(double SignOrderDown) {
            this.SignOrderDown = SignOrderDown;
        }

        public int getMeasureHourse() {
            return MeasureHourse;
        }

        public void setMeasureHourse(int MeasureHourse) {
            this.MeasureHourse = MeasureHourse;
        }
    }
}
