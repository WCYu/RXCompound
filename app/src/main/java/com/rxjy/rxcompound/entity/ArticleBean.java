package com.rxjy.rxcompound.entity;

/**
 * Created by asus on 2018/5/15.
 */

public class ArticleBean {


    /**
     * Body : {"id":"1131","isNewRecord":false,"createDate":"2018-05-16 09:56:28","updateDate":"2018-05-16 09:56:28","name":"测试1","cardno":"01012167","author":"董录录","did":70,"cover":"\"\"","content":"<p style=\"text-indent: 2em;\"><span style=\"font-family: 微软雅黑, \"Microsoft YaHei\"; text-indent: 2em;\">做事很有原则<\/span><br/><\/p>","will":"1","specify":"1","status":"1","roleType":1,"praise":0,"view":0,"releaseDate":"2018-05-16 09:56","spare1":"<p style=\"text-indent: 2em;\"><span style=\"font-family: 微软雅黑, \"Microsoft YaHei\"; text-indent: 2em;\">做事很有原则<\/span><br/><\/p>"}
     * StatusCode : 0
     * StatusMsg : 获取成功
     */

    private BodyBean Body;
    private int StatusCode;
    private String StatusMsg;

    public BodyBean getBody() {
        return Body;
    }

    public void setBody(BodyBean Body) {
        this.Body = Body;
    }

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

    public static class BodyBean {
        /**
         * id : 1131
         * isNewRecord : false
         * createDate : 2018-05-16 09:56:28
         * updateDate : 2018-05-16 09:56:28
         * name : 测试1
         * cardno : 01012167
         * author : 董录录
         * did : 70
         * cover : ""
         * content : <p style="text-indent: 2em;"><span style="font-family: 微软雅黑, "Microsoft YaHei"; text-indent: 2em;">做事很有原则</span><br/></p>
         * will : 1
         * specify : 1
         * status : 1
         * roleType : 1
         * praise : 0
         * view : 0
         * releaseDate : 2018-05-16 09:56
         * spare1 : <p style="text-indent: 2em;"><span style="font-family: 微软雅黑, "Microsoft YaHei"; text-indent: 2em;">做事很有原则</span><br/></p>
         */

        private String id;
        private boolean isNewRecord;
        private String createDate;
        private String updateDate;
        private String name;
        private String cardno;
        private String author;
        private int did;
        private String cover;
        private String content;
        private String will;
        private String specify;
        private String status;
        private int roleType;
        private int praise;
        private int view;
        private String releaseDate;
        private String spare1;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public boolean isIsNewRecord() {
            return isNewRecord;
        }

        public void setIsNewRecord(boolean isNewRecord) {
            this.isNewRecord = isNewRecord;
        }

        public String getCreateDate() {
            return createDate;
        }

        public void setCreateDate(String createDate) {
            this.createDate = createDate;
        }

        public String getUpdateDate() {
            return updateDate;
        }

        public void setUpdateDate(String updateDate) {
            this.updateDate = updateDate;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCardno() {
            return cardno;
        }

        public void setCardno(String cardno) {
            this.cardno = cardno;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public int getDid() {
            return did;
        }

        public void setDid(int did) {
            this.did = did;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getWill() {
            return will;
        }

        public void setWill(String will) {
            this.will = will;
        }

        public String getSpecify() {
            return specify;
        }

        public void setSpecify(String specify) {
            this.specify = specify;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public int getRoleType() {
            return roleType;
        }

        public void setRoleType(int roleType) {
            this.roleType = roleType;
        }

        public int getPraise() {
            return praise;
        }

        public void setPraise(int praise) {
            this.praise = praise;
        }

        public int getView() {
            return view;
        }

        public void setView(int view) {
            this.view = view;
        }

        public String getReleaseDate() {
            return releaseDate;
        }

        public void setReleaseDate(String releaseDate) {
            this.releaseDate = releaseDate;
        }

        public String getSpare1() {
            return spare1;
        }

        public void setSpare1(String spare1) {
            this.spare1 = spare1;
        }
    }
}
