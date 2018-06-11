package com.rxjy.rxcompound.des.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/8/15.
 */

public class GetHuiFang implements Serializable {
    private int StatusCode;
    private String StatusMsg;
    private List<Body> Body;

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

    public List<GetHuiFang.Body> getBody() {
        return Body;
    }

    public void setBody(List<GetHuiFang.Body> body) {
        Body = body;
    }

    public static class Body implements Serializable{
        private int RL;
        private String cv_TodayProgress;
        private int cv_Type;
        private String cv_AddTime;
        private String cv_TypeName;

        public String getCv_TypeName() {
            return cv_TypeName;
        }

        public void setCv_TypeName(String cv_TypeName) {
            this.cv_TypeName = cv_TypeName;
        }

        public int getRL() {
            return RL;
        }

        public void setRL(int RL) {
            this.RL = RL;
        }

        public String getCv_TodayProgress() {
            return cv_TodayProgress;
        }

        public void setCv_TodayProgress(String cv_TodayProgress) {
            this.cv_TodayProgress = cv_TodayProgress;
        }

        public int getCv_Type() {
            return cv_Type;
        }

        public void setCv_Type(int cv_Type) {
            this.cv_Type = cv_Type;
        }

        public String getCv_AddTime() {
            return cv_AddTime;
        }

        public void setCv_AddTime(String cv_AddTime) {
            this.cv_AddTime = cv_AddTime;
        }
    }
}
