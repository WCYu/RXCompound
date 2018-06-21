package com.rxjy.rxcompound.entity;

/**
 * Created by asus on 2018/5/23.
 */

public class ZiDonBean {


    /**
     * StatusCode : 0
     * StatusMsg : 获取成功
     * Body : {"isResult":1,"cardNo":"01013606","account":"18810945325","depart":2008,"post_id":993,"postName":"安卓开发","name":"兰荣杰","u_start":3,"app_stage":5,"image":"http://img.dcwzg.com:9192/image/0094wKgBtFqp3RuAEsExAAFu-OHQI2Q139.jpg","region_id":39,"region_name":"集团","passport_photo":"http://img.dcwzg.com:9192/image/00A8wKgBtFqyKlKAOx5jAAB-TiOcAEQ508.jpg","sex":"男"}
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
         * isResult : 1
         * cardNo : 01013606
         * account : 18810945325
         * depart : 2008
         * post_id : 993
         * postName : 安卓开发
         * name : 兰荣杰
         * u_start : 3
         * app_stage : 5
         * image : http://img.dcwzg.com:9192/image/0094wKgBtFqp3RuAEsExAAFu-OHQI2Q139.jpg
         * region_id : 39
         * region_name : 集团
         * passport_photo : http://img.dcwzg.com:9192/image/00A8wKgBtFqyKlKAOx5jAAB-TiOcAEQ508.jpg
         * sex : 男
         *
         */

        private int isResult;
        private String cardNo;
        private String account;
        private int depart;
        private int post_id;
        private String postName;
        private String name;
        private int u_start;
        private int app_stage;
        private String image;
        private int region_id;
        private String region_name;
        private String passport_photo;
        private String sex;
        private int is_exist;
        private int is_group;

        public int getIs_group() {
            return is_group;
        }

        public void setIs_group(int is_group) {
            this.is_group = is_group;
        }

        public int getIs_exist() {
            return is_exist;
        }

        public void setIs_exist(int is_exist) {
            this.is_exist = is_exist;
        }

        public int getIsResult() {
            return isResult;
        }

        public void setIsResult(int isResult) {
            this.isResult = isResult;
        }

        public String getCardNo() {
            return cardNo;
        }

        public void setCardNo(String cardNo) {
            this.cardNo = cardNo;
        }

        public String getAccount() {
            return account;
        }

        public void setAccount(String account) {
            this.account = account;
        }

        public int getDepart() {
            return depart;
        }

        public void setDepart(int depart) {
            this.depart = depart;
        }

        public int getPost_id() {
            return post_id;
        }

        public void setPost_id(int post_id) {
            this.post_id = post_id;
        }

        public String getPostName() {
            return postName;
        }

        public void setPostName(String postName) {
            this.postName = postName;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getU_start() {
            return u_start;
        }

        public void setU_start(int u_start) {
            this.u_start = u_start;
        }

        public int getApp_stage() {
            return app_stage;
        }

        public void setApp_stage(int app_stage) {
            this.app_stage = app_stage;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getRegion_id() {
            return region_id;
        }

        public void setRegion_id(int region_id) {
            this.region_id = region_id;
        }

        public String getRegion_name() {
            return region_name;
        }

        public void setRegion_name(String region_name) {
            this.region_name = region_name;
        }

        public String getPassport_photo() {
            return passport_photo;
        }

        public void setPassport_photo(String passport_photo) {
            this.passport_photo = passport_photo;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }
    }
}
