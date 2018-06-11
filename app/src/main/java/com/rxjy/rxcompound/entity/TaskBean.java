package com.rxjy.rxcompound.entity;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2018/4/9.
 */

public class TaskBean {
    private int StatusCode;
    private String StatusMsg;
    private Body Body;

    public TaskBean() {
        super();
    }

    @Override
    public String toString() {
        return "TaskBean{" +
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

    public TaskBean.Body getBody() {
        return Body;
    }

    public void setBody(TaskBean.Body body) {
        Body = body;
    }

    public class Body{
        private int taskId;
        private String t_theme;
        private String yname;
        private String tname;
        private String sname;
        private String endTime;
        private String timeDifference;
        private String t_sysPathStr;
        private String executorName;
        private String t_describe;
        private String beginTimeStr;
        private String endTimeStr;
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
                    ", executorName='" + executorName + '\'' +
                    ", t_describe='" + t_describe + '\'' +
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

        public String getExecutorName() {
            return executorName;
        }

        public void setExecutorName(String executorName) {
            this.executorName = executorName;
        }

        public String getT_describe() {
            return t_describe;
        }

        public void setT_describe(String t_describe) {
            this.t_describe = t_describe;
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
    }
}
