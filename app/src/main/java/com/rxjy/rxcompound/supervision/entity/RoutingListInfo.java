package com.rxjy.rxcompound.supervision.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/4/30.
 */
public class RoutingListInfo {

    private int StatusCode;
    private String StatusMsg;

    private List<RoutingInfo> Body;

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

    public List<RoutingInfo> getBody() {
        return Body;
    }

    public void setBody(List<RoutingInfo> Body) {
        this.Body = Body;
    }

    public static class RoutingInfo implements Serializable {
        private int xj_id;
        private String xj_content;
        private String xj_finishtime;
        private int xj_type;
        private List<String> xj_photo;
        private List<String> xj_tag;

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

        public String getXj_finishtime() {
            return xj_finishtime;
        }

        public void setXj_finishtime(String xj_finishtime) {
            this.xj_finishtime = xj_finishtime;
        }

        public int getXj_type() {
            return xj_type;
        }

        public void setXj_type(int xj_type) {
            this.xj_type = xj_type;
        }

        public List<String> getXj_photo() {
            return xj_photo;
        }

        public void setXj_photo(List<String> xj_photo) {
            this.xj_photo = xj_photo;
        }

        public List<String> getXj_tag() {
            return xj_tag;
        }

        public void setXj_tag(List<String> xj_tag) {
            this.xj_tag = xj_tag;
        }
    }
}
