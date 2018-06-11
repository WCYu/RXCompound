package com.rxjy.rxcompound.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by hjh on 2018/4/9.
 */

public class TaskListBean implements Serializable{

    private int StatusCode;
    private String StatusMsg;
    private ArrayList<Body> Body;

    public TaskListBean() {
        super();
    }

    @Override
    public String toString() {
        return "TaskListBean{" +
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

    public ArrayList<TaskListBean.Body> getBody() {
        return Body;
    }

    public void setBody(ArrayList<TaskListBean.Body> body) {
        Body = body;
    }

    public class Body implements Serializable{
        private int taskId;
        private int t_state;
        private String t_theme;
        private String yname;
        private String tname;
        private String sname;
        private String endTime;
        private String timeDifference;
        private String t_sysPathStr;
        private String beginTimeStr;
        private String endTimeStr;
        private String addname;
        private String t_describe;
        private BigDecimal t_money;
        private BigDecimal evaluatemoney;

        public Body() {
            super();
        }

        @Override
        public String toString() {
            return "Body{" +
                    "taskId=" + taskId +
                    ", t_theme='" + t_theme + '\'' +
                    ", yname='" + yname + '\'' +
                    ", tname='" + tname + '\'' +
                    ", sname='" + sname + '\'' +
                    ", endTime='" + endTime + '\'' +
                    ", timeDifference='" + timeDifference + '\'' +
                    ", t_sysPathStr='" + t_sysPathStr + '\'' +
                    ", beginTimeStr='" + beginTimeStr + '\'' +
                    ", endTimeStr='" + endTimeStr + '\'' +
                    ", t_money=" + t_money +
                    ", evaluatemoney=" + evaluatemoney +
                    '}';
        }

        public String getBeginTimeStr() {
            return beginTimeStr;
        }

        public void setBeginTimeStr(String beginTimeStr) {
            this.beginTimeStr = beginTimeStr;
        }

        public String getEndTimeStr() {
            return endTimeStr;
        }

        public void setEndTimeStr(String endTimeStr) {
            this.endTimeStr = endTimeStr;
        }

        public String getT_sysPathStr() {
            return t_sysPathStr;
        }

        public void setT_sysPathStr(String t_sysPathStr) {
            this.t_sysPathStr = t_sysPathStr;
        }

        public int getTaskId() {
            return taskId;
        }

        public void setTaskId(int taskId) {
            this.taskId = taskId;
        }

        public String getT_theme() {
            return t_theme;
        }

        public void setT_theme(String t_theme) {
            this.t_theme = t_theme;
        }

        public String getYname() {
            return yname;
        }

        public void setYname(String yname) {
            this.yname = yname;
        }

        public String getTname() {
            return tname;
        }

        public void setTname(String tname) {
            this.tname = tname;
        }

        public String getSname() {
            return sname;
        }

        public void setSname(String sname) {
            this.sname = sname;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTimeStr) {
            this.endTime = endTimeStr;
        }

        public String getTimeDifference() {
            return timeDifference;
        }

        public void setTimeDifference(String timeDifference) {
            this.timeDifference = timeDifference;
        }

        public BigDecimal getT_money() {
            return t_money;
        }

        public void setT_money(BigDecimal t_money) {
            this.t_money = t_money;
        }

        public BigDecimal getEvaluatemoney() {
            return evaluatemoney;
        }

        public void setEvaluatemoney(BigDecimal evaluatemoney) {
            this.evaluatemoney = evaluatemoney;
        }

        public int getT_state() {
            return t_state;
        }

        public void setT_state(int t_state) {
            this.t_state = t_state;
        }

        public String getAddname() {
            return addname;
        }

        public void setAddname(String addname) {
            this.addname = addname;
        }

        public String getT_describe() {
            return t_describe;
        }

        public void setT_describe(String t_describe) {
            this.t_describe = t_describe;
        }
    }

//    "taskId":6187,
//            　　　　"t_theme":"测试使命版本",
//            　　　　"t_describe":"1、测试1 2、测试2 3、测试3 4、测试4",
//            　　　　"addTime":"2018-04-09T09:53:45.437",
//            　　　　"beginTime":"2018-04-09T09:00:00",
//            　　　　"endTime":"2018-04-09T11:00:00",
//            　　　　"addTimeStr":"2018-04-09",
//            　　　　"beginTimeStr":"2018-04-09",
//            　　　　"endTimeStr":"2018-04-09",
//            　　　　"executorName":"7师-吕天瑞",
//            　　　　"taskHours":2,
//            　　　　"delayHours":0,
//            　　　　"t_state":1,
//            　　　　"stateStr":"进行中",
//            　　　　"t_money":100,
//            　　　　"evaluatemoney":0,
//            　　　　"t_Type":3,
//            　　　　"typeStr":"节点任务",
//            　　　　"stage":5,
//            　　　　"tasktypeStr":"管理任务",
//            　　　　"yid":130,
//            　　　　"yname":"系统",
//            　　　　"tid":37,
//            　　　　"tname":"开发",
//            　　　　"sid":8,
//            　　　　"sname":"大院投资",
//            　　　　"t_sysPathStr":"开军系统、-任、-全、-使命1、",
//            　　　　"rewardsCausation":null,
//            　　　　"timeDifference":"6H"


}