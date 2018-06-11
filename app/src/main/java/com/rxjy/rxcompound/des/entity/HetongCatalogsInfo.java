package com.rxjy.rxcompound.des.entity;

import java.util.List;

/**
 * Created by Administrator on 2017/10/17.
 */

public class HetongCatalogsInfo {

    /**
     * StatusCode : 0
     * StatusMsg : 获取成功
     * Body : {"CatalogList":[{"CatalogName":"合同首页","CatalogID":"71","ImgCount":"0","ImageUrl":""},{"CatalogName":"合同尾页","CatalogID":"72","ImgCount":"0","ImageUrl":""},{"CatalogName":"合同二三页","CatalogID":"98","ImgCount":"0","ImageUrl":""},{"CatalogName":"合同骑缝","CatalogID":"96","ImgCount":"0","ImageUrl":""},{"CatalogName":"附件","CatalogID":"136","ImgCount":"0","ImageUrl":""},{"CatalogName":"身份证复印件","CatalogID":"99","ImgCount":"0","ImageUrl":""},{"CatalogName":"授权委托书","CatalogID":"97","ImgCount":"0","ImageUrl":""},{"CatalogName":"授权委托书","CatalogID":"97","ImgCount":"0","ImageUrl":""},{"CatalogName":"报价合同","CatalogID":"100","ImgCount":"0","ImageUrl":""},{"CatalogName":"报价骑缝","CatalogID":"101","ImgCount":"0","ImageUrl":""},{"CatalogName":"拍摄点位图","CatalogID":"66","ImgCount":"0","ImageUrl":""},{"CatalogName":"效果图","CatalogID":"16","ImgCount":"0","ImageUrl":""},{"CatalogName":"彩色平面图","CatalogID":"90","ImgCount":"1","ImageUrl":"http:/img0.wenes.cn/upload/project/image/2017/10/17/thumbnail/11333046174760.jpg"},{"CatalogName":"施工图骑缝","CatalogID":"103","ImgCount":"0","ImageUrl":""},{"CatalogName":"施工图封面","CatalogID":"104","ImgCount":"0","ImageUrl":""}],"UserID":219514,"WorkID":16637}
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
         * CatalogList : [{"CatalogName":"合同首页","CatalogID":"71","ImgCount":"0","ImageUrl":""},{"CatalogName":"合同尾页","CatalogID":"72","ImgCount":"0","ImageUrl":""},{"CatalogName":"合同二三页","CatalogID":"98","ImgCount":"0","ImageUrl":""},{"CatalogName":"合同骑缝","CatalogID":"96","ImgCount":"0","ImageUrl":""},{"CatalogName":"附件","CatalogID":"136","ImgCount":"0","ImageUrl":""},{"CatalogName":"身份证复印件","CatalogID":"99","ImgCount":"0","ImageUrl":""},{"CatalogName":"授权委托书","CatalogID":"97","ImgCount":"0","ImageUrl":""},{"CatalogName":"授权委托书","CatalogID":"97","ImgCount":"0","ImageUrl":""},{"CatalogName":"报价合同","CatalogID":"100","ImgCount":"0","ImageUrl":""},{"CatalogName":"报价骑缝","CatalogID":"101","ImgCount":"0","ImageUrl":""},{"CatalogName":"拍摄点位图","CatalogID":"66","ImgCount":"0","ImageUrl":""},{"CatalogName":"效果图","CatalogID":"16","ImgCount":"0","ImageUrl":""},{"CatalogName":"彩色平面图","CatalogID":"90","ImgCount":"1","ImageUrl":"http:/img0.wenes.cn/upload/project/image/2017/10/17/thumbnail/11333046174760.jpg"},{"CatalogName":"施工图骑缝","CatalogID":"103","ImgCount":"0","ImageUrl":""},{"CatalogName":"施工图封面","CatalogID":"104","ImgCount":"0","ImageUrl":""}]
         * UserID : 219514
         * WorkID : 16637
         */

        private int UserID;
        private int WorkID;
        private List<CatalogListBean> CatalogList;

        public int getUserID() {
            return UserID;
        }

        public void setUserID(int UserID) {
            this.UserID = UserID;
        }

        public int getWorkID() {
            return WorkID;
        }

        public void setWorkID(int WorkID) {
            this.WorkID = WorkID;
        }

        public List<CatalogListBean> getCatalogList() {
            return CatalogList;
        }

        public void setCatalogList(List<CatalogListBean> CatalogList) {
            this.CatalogList = CatalogList;
        }

        public static class CatalogListBean {
            /**
             * CatalogName : 合同首页
             * CatalogID : 71
             * ImgCount : 0
             * ImageUrl :
             */

            private String CatalogName;
            private String CatalogID;
            private String ImgCount;
            private String ImageUrl;

            public String getCatalogName() {
                return CatalogName;
            }

            public void setCatalogName(String CatalogName) {
                this.CatalogName = CatalogName;
            }

            public String getCatalogID() {
                return CatalogID;
            }

            public void setCatalogID(String CatalogID) {
                this.CatalogID = CatalogID;
            }

            public String getImgCount() {
                return ImgCount;
            }

            public void setImgCount(String ImgCount) {
                this.ImgCount = ImgCount;
            }

            public String getImageUrl() {
                return ImageUrl;
            }

            public void setImageUrl(String ImageUrl) {
                this.ImageUrl = ImageUrl;
            }
        }
    }
}
