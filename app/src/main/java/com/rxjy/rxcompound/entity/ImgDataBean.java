package com.rxjy.rxcompound.entity;

/**
 * Created by 阿禹 on 2018/7/2.
 */

public class ImgDataBean {

    /**
     * StatusCode : 0
     * Body : {"id":817,"xzId":"267","dept":"1","cardno":"01011451","imgUrl":"http://img.dcwzg.com:9192/image/01F4wKgBtFs0yr6ANcodAAGZCPd8THc232.jpg","imgName":"wKgB4VssW-GAKvjzAAGYbGYxH8E494.jpg","createDate":1529946227000,"updateDate":1529946227000,"delFlag":"0","spare1":"11"}
     * StatusMsg : 有标准照片
     */

    private int StatusCode;
    private BodyBean Body;
    private String StatusMsg;

    public int getStatusCode() {
        return StatusCode;
    }

    public void setStatusCode(int StatusCode) {
        this.StatusCode = StatusCode;
    }

    public BodyBean getBody() {
        return Body;
    }

    public void setBody(BodyBean Body) {
        this.Body = Body;
    }

    public String getStatusMsg() {
        return StatusMsg;
    }

    public void setStatusMsg(String StatusMsg) {
        this.StatusMsg = StatusMsg;
    }

    public static class BodyBean {
        /**
         * id : 817
         * xzId : 267
         * dept : 1
         * cardno : 01011451
         * imgUrl : http://img.dcwzg.com:9192/image/01F4wKgBtFs0yr6ANcodAAGZCPd8THc232.jpg
         * imgName : wKgB4VssW-GAKvjzAAGYbGYxH8E494.jpg
         * createDate : 1529946227000
         * updateDate : 1529946227000
         * delFlag : 0
         * spare1 : 11
         */

        private int id;
        private String xzId;
        private String dept;
        private String cardno;
        private String imgUrl;
        private String imgName;
        private long createDate;
        private long updateDate;
        private String delFlag;
        private String spare1;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getXzId() {
            return xzId;
        }

        public void setXzId(String xzId) {
            this.xzId = xzId;
        }

        public String getDept() {
            return dept;
        }

        public void setDept(String dept) {
            this.dept = dept;
        }

        public String getCardno() {
            return cardno;
        }

        public void setCardno(String cardno) {
            this.cardno = cardno;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public String getImgName() {
            return imgName;
        }

        public void setImgName(String imgName) {
            this.imgName = imgName;
        }

        public long getCreateDate() {
            return createDate;
        }

        public void setCreateDate(long createDate) {
            this.createDate = createDate;
        }

        public long getUpdateDate() {
            return updateDate;
        }

        public void setUpdateDate(long updateDate) {
            this.updateDate = updateDate;
        }

        public String getDelFlag() {
            return delFlag;
        }

        public void setDelFlag(String delFlag) {
            this.delFlag = delFlag;
        }

        public String getSpare1() {
            return spare1;
        }

        public void setSpare1(String spare1) {
            this.spare1 = spare1;
        }
    }
}
