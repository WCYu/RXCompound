package com.rxjy.rxcompound.supervision.entity;

import java.util.List;

/**
 * Created by AAA on 2017/8/8.
 */

public class VisitInfo {

    private int StatusCode;
    private String StatusMsg;
    private List<Visit> Body;

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

    public List<Visit> getBody() {
        return Body;
    }

    public void setBody(List<Visit> Body) {
        this.Body = Body;
    }

    public static class Visit {

        private int ID;
        private String orderno;
        private String logcontent;
        private int logtype;
        private String createtime;
        private String problemId;
        private int importance;
        private String CreateUserNo;
        private String CreateUserMan;
        private int projectarea;

        public int getID() {
            return ID;
        }

        public void setID(int ID) {
            this.ID = ID;
        }

        public String getOrderno() {
            return orderno;
        }

        public void setOrderno(String orderno) {
            this.orderno = orderno;
        }

        public String getLogcontent() {
            return logcontent;
        }

        public void setLogcontent(String logcontent) {
            this.logcontent = logcontent;
        }

        public int getLogtype() {
            return logtype;
        }

        public void setLogtype(int logtype) {
            this.logtype = logtype;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public String getProblemId() {
            return problemId;
        }

        public void setProblemId(String problemId) {
            this.problemId = problemId;
        }

        public int getImportance() {
            return importance;
        }

        public void setImportance(int importance) {
            this.importance = importance;
        }

        public String getCreateUserNo() {
            return CreateUserNo;
        }

        public void setCreateUserNo(String CreateUserNo) {
            this.CreateUserNo = CreateUserNo;
        }

        public String getCreateUserMan() {
            return CreateUserMan;
        }

        public void setCreateUserMan(String CreateUserMan) {
            this.CreateUserMan = CreateUserMan;
        }

        public int getProjectarea() {
            return projectarea;
        }

        public void setProjectarea(int projectarea) {
            this.projectarea = projectarea;
        }
    }
}
