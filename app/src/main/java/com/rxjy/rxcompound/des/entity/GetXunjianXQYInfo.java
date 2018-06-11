package com.rxjy.rxcompound.des.entity;

import java.util.List;

/**
 * Created by Administrator on 2017/10/24.
 */

public class GetXunjianXQYInfo {


    /**
     * StatusCode : 0
     * StatusMsg : Success
     * Body : {"Description":"测试","ActualCheckTime":"2017-33-24","ActualCheckAddress":"北京市海淀区永定河路388号","ChildList":[{"si_Id":25,"si_ImageUrl":"Image/2017/10/24/18315150880804.jpg"},{"si_Id":26,"si_ImageUrl":"Image/2017/10/24/18325945967854.jpg"}]}
     */

    private int StatusCode;
    private String StatusMsg;
    private BodyBean Body;

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

    public BodyBean getBody() {
        return Body;
    }

    public void setBody(BodyBean Body) {
        this.Body = Body;
    }

    public static class BodyBean {
        /**
         * Description : 测试
         * ActualCheckTime : 2017-33-24
         * ActualCheckAddress : 北京市海淀区永定河路388号
         * ChildList : [{"si_Id":25,"si_ImageUrl":"Image/2017/10/24/18315150880804.jpg"},{"si_Id":26,"si_ImageUrl":"Image/2017/10/24/18325945967854.jpg"}]
         */

        private String Description;
        private String ActualCheckTime;
        private String ActualCheckAddress;
        private List<ChildListBean> ChildList;

        public String getDescription() {
            return Description;
        }

        public void setDescription(String Description) {
            this.Description = Description;
        }

        public String getActualCheckTime() {
            return ActualCheckTime;
        }

        public void setActualCheckTime(String ActualCheckTime) {
            this.ActualCheckTime = ActualCheckTime;
        }

        public String getActualCheckAddress() {
            return ActualCheckAddress;
        }

        public void setActualCheckAddress(String ActualCheckAddress) {
            this.ActualCheckAddress = ActualCheckAddress;
        }

        public List<ChildListBean> getChildList() {
            return ChildList;
        }

        public void setChildList(List<ChildListBean> ChildList) {
            this.ChildList = ChildList;
        }

        public static class ChildListBean {
            /**
             * si_Id : 25
             * si_ImageUrl : Image/2017/10/24/18315150880804.jpg
             */

            private int si_Id;
            private String si_ImageUrl;

            public ChildListBean()
            {

            }
            public ChildListBean(int detailID, String imageUrl)
            {
                si_Id = detailID;
                si_ImageUrl = imageUrl;
            }

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
}
