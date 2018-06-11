package com.rxjy.rxcompound.supervision.entity;

import com.luck.picture.lib.entity.LocalMedia;

import java.util.List;

/**
 * Created by Administrator on 2017/5/4.
 */
public class ProblemInfo {

    private int StatusCode;
    private String StatusMsg;

    private List<Problem> Body;

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

    public List<Problem> getBody() {
        return Body;
    }

    public void setBody(List<Problem> Body) {
        this.Body = Body;
    }

    public static class Problem {
        private int xj_id;
        private String xj_content;
        private String remark;
        private List<LocalMedia> photoList;

        public int getXj_id() {
            return xj_id;
        }

        public void setXj_id(int xj_id) {
            this.xj_id = xj_id;
        }

        public String getXj_content() {
            return xj_content;
        }

        public void setXj_content(String xj_content) {
            this.xj_content = xj_content;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public List<LocalMedia> getPhotoList() {
            return photoList;
        }

        public void setPhotoList(List<LocalMedia> photoList) {
            this.photoList = photoList;
        }
    }
}
