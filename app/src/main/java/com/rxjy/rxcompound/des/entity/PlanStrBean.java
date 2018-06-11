package com.rxjy.rxcompound.des.entity;

import java.util.List;

/**
 * Created by hjh on 2018/4/17.
 */

public class PlanStrBean {

    private int StatusCode;
    private String StatusMsg;

    private Data Body;

    public PlanStrBean() {
        super();
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

    public Data getBody() {
        return Body;
    }

    public void setBody(Data body) {
        Body = body;
    }

    public class Data{
        private String ProjectBrief;

        public Data() {
            super();
        }

        @Override
        public String toString() {
            return "Data{" +
                    "ProjectBrief='" + ProjectBrief + '\'' +
                    '}';
        }

        public String getProjectBrief() {
            return ProjectBrief;
        }

        public void setProjectBrief(String projectBrief) {
            ProjectBrief = projectBrief;
        }
    }
}