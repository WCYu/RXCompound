package com.rxjy.rxcompound.entity;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by hjh on 2018/4/2.
 */

public class JiFenBean {

    private int StatusCode;
    private String StatusMsg;
    private ArrayList<BodyBean> Body;

    public JiFenBean() {
        super();
    }

    @Override
    public String toString() {
        return "JiFenBean{" +
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
//        "grade":2,
//                　　　　　　"remind":0,
//                　　　　　　"lessThenTwo":2000,
//                　　　　　　"twoToFive":2500,
//                　　　　　　"fiveToTwelve":3000,
//                　　　　　　"greaterThenTwelve":3500,
//                　　　　　　"upGrade":"距累计600000的升级任务，您已完成0.00, 还差600000.00即可升级。",
//                　　　　　　"downGrade":"您本月的最低任务为100000还差0.00, 还差100000.00即可完成。",
//                　　　　　　"finalMoney":0,
//                　　　　　　"upStandard":600000,
//                　　　　　　"upDifference":-600000,
//                　　　　　　"downStandard":100000,
//                　　　　　　"downDifference":-100000,
//                　　　　　　"oneRemind":0,
//                　　　　　　"twoRemind":0,
//                　　　　　　"threeRemind":0.1,
//                　　　　　　"fourRemind":0.2,
//                　　　　　　"fiveRemind":0.3,
//                　　　　　　"sixRemind":0.4,
//                　　　　　　"sevenRemind":0.5,
//                　　　　　　"eightRemind":1,
//                　　　　　　"nineRemind":1.5,
//                　　　　　　"tenRemind":2

        private int grade;
        private BigDecimal lessThenTwo;
        private BigDecimal twoToFive;
        private BigDecimal fiveToTwelve;
        private BigDecimal greaterThenTwelve;
        private BigDecimal finalMoney;
        private BigDecimal upStandard;
        private BigDecimal downStandard;
        private String ddeclaration;
        private int achievementGrade;
        private Double oneRemind;
        private Double twoRemind;
        private Double threeRemind;
        private Double fourRemind;
        private Double fiveRemind;
        private Double sixRemind;
        private Double sevenRemind;
        private Double eightRemind;
        private Double nineRemind;
        private Double tenRemind;

        public BodyBean() {
            super();
        }

        @Override
        public String toString() {
            return "BodyBean{" +
                    "grade=" + grade +
                    ", lessThenTwo=" + lessThenTwo +
                    ", twoToFive=" + twoToFive +
                    ", fiveToTwelve=" + fiveToTwelve +
                    ", greaterThenTwelve=" + greaterThenTwelve +
                    ", finalMoney=" + finalMoney +
                    ", upStandard=" + upStandard +
                    ", downStandard=" + downStandard +
                    ", ddeclaration='" + ddeclaration + '\'' +
                    ", achievementGrade=" + achievementGrade +
                    ", oneRemind='" + oneRemind + '\'' +
                    ", twoRemind='" + twoRemind + '\'' +
                    ", threeRemind='" + threeRemind + '\'' +
                    ", fourRemind='" + fourRemind + '\'' +
                    ", fiveRemind='" + fiveRemind + '\'' +
                    ", sixRemind='" + sixRemind + '\'' +
                    ", sevenRemind='" + sevenRemind + '\'' +
                    ", eightRemind='" + eightRemind + '\'' +
                    ", nineRemind='" + nineRemind + '\'' +
                    ", tenRemind='" + tenRemind + '\'' +
                    '}';
        }

        public int getGrade() {
            return grade;
        }

        public void setGrade(int grade) {
            this.grade = grade;
        }

        public BigDecimal getLessThenTwo() {
            return lessThenTwo;
        }

        public void setLessThenTwo(BigDecimal lessThenTwo) {
            this.lessThenTwo = lessThenTwo;
        }

        public BigDecimal getTwoToFive() {
            return twoToFive;
        }

        public void setTwoToFive(BigDecimal twoToFive) {
            this.twoToFive = twoToFive;
        }

        public BigDecimal getFiveToTwelve() {
            return fiveToTwelve;
        }

        public void setFiveToTwelve(BigDecimal fiveToTwelve) {
            this.fiveToTwelve = fiveToTwelve;
        }

        public BigDecimal getGreaterThenTwelve() {
            return greaterThenTwelve;
        }

        public void setGreaterThenTwelve(BigDecimal greaterThenTwelve) {
            this.greaterThenTwelve = greaterThenTwelve;
        }

        public BigDecimal getFinalMoney() {
            return finalMoney;
        }

        public void setFinalMoney(BigDecimal finalMoney) {
            this.finalMoney = finalMoney;
        }

        public BigDecimal getUpStandard() {
            return upStandard;
        }

        public void setUpStandard(BigDecimal upStandard) {
            this.upStandard = upStandard;
        }

        public BigDecimal getDownStandard() {
            return downStandard;
        }

        public void setDownStandard(BigDecimal downStandard) {
            this.downStandard = downStandard;
        }

        public String getDdeclaration() {
            return ddeclaration;
        }

        public void setDdeclaration(String ddeclaration) {
            this.ddeclaration = ddeclaration;
        }

        public int getAchievementGrade() {
            return achievementGrade;
        }

        public void setAchievementGrade(int achievementGrade) {
            this.achievementGrade = achievementGrade;
        }

        public Double getOneRemind() {
            return oneRemind;
        }

        public void setOneRemind(Double oneRemind) {
            this.oneRemind = oneRemind;
        }

        public Double getTwoRemind() {
            return twoRemind;
        }

        public void setTwoRemind(Double twoRemind) {
            this.twoRemind = twoRemind;
        }

        public Double getThreeRemind() {
            return threeRemind;
        }

        public void setThreeRemind(Double threeRemind) {
            this.threeRemind = threeRemind;
        }

        public Double getFourRemind() {
            return fourRemind;
        }

        public void setFourRemind(Double fourRemind) {
            this.fourRemind = fourRemind;
        }

        public Double getFiveRemind() {
            return fiveRemind;
        }

        public void setFiveRemind(Double fiveRemind) {
            this.fiveRemind = fiveRemind;
        }

        public Double getSixRemind() {
            return sixRemind;
        }

        public void setSixRemind(Double sixRemind) {
            this.sixRemind = sixRemind;
        }

        public Double getSevenRemind() {
            return sevenRemind;
        }

        public void setSevenRemind(Double sevenRemind) {
            this.sevenRemind = sevenRemind;
        }

        public Double getEightRemind() {
            return eightRemind;
        }

        public void setEightRemind(Double eightRemind) {
            this.eightRemind = eightRemind;
        }

        public Double getNineRemind() {
            return nineRemind;
        }

        public void setNineRemind(Double nineRemind) {
            this.nineRemind = nineRemind;
        }

        public Double getTenRemind() {
            return tenRemind;
        }

        public void setTenRemind(Double tenRemind) {
            this.tenRemind = tenRemind;
        }
    }

}