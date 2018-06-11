package com.rxjy.rxcompound.des.entity;

import java.util.List;

/**
 * Created by Administrator on 2017/10/25.
 */

public class UpXJPicInfo {


    /**
     * StatusCode : 0
     * StatusMsg : Success
     * Body : [{"si_Id":49,"si_ImageUrl":"Image/2017/10/25/11263899768956.png"}]
     */

    private int StatusCode;
    private String StatusMsg;
    private List<BodyBean> Body;

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

    public List<BodyBean> getBody() {
        return Body;
    }

    public void setBody(List<BodyBean> Body) {
        this.Body = Body;
    }

    public static class BodyBean {
        /**
         * si_Id : 49
         * si_ImageUrl : Image/2017/10/25/11263899768956.png
         */

        private int si_Id;
        private String si_ImageUrl;

        public int getSi_Id() {
            return si_Id;
        }

        public void setSi_Id(int si_Id) {
            this.si_Id = si_Id;
        }

        public String getSi_ImageUrl() {
            return si_ImageUrl;
        }

        public void setSi_ImageUrl(String si_ImageUrl) {
            this.si_ImageUrl = si_ImageUrl;
        }
    }
}
