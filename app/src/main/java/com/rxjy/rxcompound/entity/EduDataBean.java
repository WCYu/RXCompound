package com.rxjy.rxcompound.entity;

/**
 * Created by hjh on 2017/11/16.
 */

public class EduDataBean {

    private int dayIndex;
    private double pressess1;
    private int state;
    private String score1;
    private double pressess2;
    private double pressess3;
    private String flag;
    private String StatusMsg;
//    private double score2;
//    private double score3;
    private String score2;
    private String score3;
    private String dept;
    private String msg;

    public EduDataBean() {super();
    }

    @Override
    public String toString() {
        return "EduDataBean{" +
                "dayIndex=" + dayIndex +
                ", pressess1=" + pressess1 +
                ", state=" + state +
                ", score1=" + score1 +
                ", pressess2=" + pressess2 +
                ", pressess3=" + pressess3 +
                ", flag='" + flag + '\'' +
                ", StatusMsg='" + StatusMsg + '\'' +
                ", score2='" + score2 + '\'' +
                ", score3='" + score3 + '\'' +
                ", dept='" + dept + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }

    public int getDayIndex() {
        return dayIndex;
    }

    public void setDayIndex(int dayIndex) {
        this.dayIndex = dayIndex;
    }

    public double getPressess1() {
        return pressess1;
    }

    public void setPressess1(int pressess1) {
        this.pressess1 = pressess1;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

//    public double getScore1() {
//        return score1;
//    }
//
//    public void setScore1(int score1) {
//        this.score1 = score1;
//    }

    public double getPressess2() {
        return pressess2;
    }

    public void setPressess2(int pressess2) {
        this.pressess2 = pressess2;
    }

    public double getPressess3() {
        return pressess3;
    }

    public void setPressess3(int pressess3) {
        this.pressess3 = pressess3;
    }

    public String getFlag() {
        return flag;
    }

    public String getScore1() {
        return score1;
    }

    public void setScore1(String score1) {
        this.score1 = score1;
    }

    public String getScore2() {
        return score2;
    }

    public void setScore2(String score2) {
        this.score2 = score2;
    }

    public String getScore3() {
        return score3;
    }

    public void setScore3(String score3) {
        this.score3 = score3;
    }

    //    public double getScore2() {
//        return score2;
//    }
//
//    public void setScore2(double score2) {
//        this.score2 = score2;
//    }
//
//    public double getScore3() {
//        return score3;
//    }
//
//    public void setScore3(double score3) {
//        this.score3 = score3;
//    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getStatusMsg() {
        return StatusMsg;
    }

    public void setStatusMsg(String statusMsg) {
        StatusMsg = statusMsg;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
