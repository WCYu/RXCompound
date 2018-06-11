package com.rxjy.rxcompound.supervision.entity;

import java.util.List;

/**
 * Created by Administrator on 2017/4/27.
 */
public class ProcessDetailInfo {


    private int StatusCode;
    private String StatusMsg;

    private List<ProcessDetail> Body;

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

    public List<ProcessDetail> getBody() {
        return Body;
    }

    public void setBody(List<ProcessDetail> Body) {
        this.Body = Body;
    }

    public static class ProcessDetail {
        private int StepId;
        private int ProcessId;
        private String StepName;
        private String StepDesc;
        private int StepPhotoID;
        private String StepPhotoUrl;
        private String PhotoUrl;
        private int Manager_audit;

        public int getManager_audit() {
            return Manager_audit;
        }

        public void setManager_audit(int manager_audit) {
            Manager_audit = manager_audit;
        }

        public int getStepId() {
            return StepId;
        }

        public void setStepId(int StepId) {
            this.StepId = StepId;
        }

        public int getProcessId() {
            return ProcessId;
        }

        public void setProcessId(int ProcessId) {
            this.ProcessId = ProcessId;
        }

        public String getStepName() {
            return StepName;
        }

        public void setStepName(String StepName) {
            this.StepName = StepName;
        }

        public String getStepDesc() {
            return StepDesc;
        }

        public void setStepDesc(String StepDesc) {
            this.StepDesc = StepDesc;
        }

        public int getStepPhotoID() {
            return StepPhotoID;
        }

        public void setStepPhotoID(int StepPhotoID) {
            this.StepPhotoID = StepPhotoID;
        }

        public String getStepPhotoUrl() {
            return StepPhotoUrl;
        }

        public void setStepPhotoUrl(String StepPhotoUrl) {
            this.StepPhotoUrl = StepPhotoUrl;
        }

        public String getPhotoUrl() {
            return PhotoUrl;
        }

        public void setPhotoUrl(String PhotoUrl) {
            this.PhotoUrl = PhotoUrl;
        }
    }
}
