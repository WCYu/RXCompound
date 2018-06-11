package com.rxjy.rxcompound.entity;

import java.io.Serializable;

/**
 * Created by hjh on 2018/4/20.
 */

public class DesBaseInfoBean implements Serializable{

    private int StatusCode;
    private String StatusMsg;
    private BodyBean Body;

    public DesBaseInfoBean() {
        super();
    }

    @Override
    public String toString() {
        return "MoneyDTzResultBean{" +
                "StatusCode=" + StatusCode +
                ", StatusMsg='" + StatusMsg + '\'' +
                ", Body=" + Body +
                '}';
    }

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

    public BodyBean getBody() {
        return Body;
    }

    public void setBody(BodyBean body) {
        Body = body;
    }

    public class BodyBean implements Serializable{

        private String cardNo;
        private String name;
        private String a_account;
        private int post_id;
        private String postName;
        private String sex;
        private String birthday;
        private String strBirthday;
        private String phone;
        private String email;
        private String id_card;
        private String bank_card;
        private String bank_name;
        private String living_place;
        private String education;
        private int OperatorDepart;
        private String create_date;
        private String update_date;
        private String passport_photo;
        private String id_card_image_heads;
        private String id_card_image_tails;
        private String primaryCertificate;
        private String intermediateCertificate;
        private String advancedCertificate;
        private String bank_image_heads;
        private String bank_user_name;
        private String image;
        private int identity_state;
        private int Entry_state;



//        "name":"朱来杰",
//                "postName":"会员",
//                "passport_photo":null,
//                "cardNo":"WTS00000001",
//                "card_no":null,
//                "nick_name":null,
//                "v_code":null,
//                "app_id":null,
//                "a_account":"18516674765",
//                "a_password":null,
//                "token":null,
//                "a_really_password":null,
//                "depart_id":0,
//                "depart_name":null,
//                "bm_lishu":null,
//                "post_id":10000,
//                "post_name":null,
//                "position_id":0,
//                "position_name":null,
//                "region_id":0,
//                "region_name":null,
//                "image_state":null,
//                "imageName":null,
//                "weixin":null,
//                "sw_invitation_code":null,
//                "sex":null,
//                "age":0,
//                "birthday":null,
//                "strBirthday":null,
//                "phone":null,
//                "email":null,
//                "id_card":null,
//                "id_card_name":null,
//                "id_card_address":null,
//                "now_address":null,
//                "bank_card":null,
//                "bank_name":null,
//                "bank_user_name":null,
//                "bank_image_tails":null,
//                "bank_image_heads_state":null,
//                "bank_image_tails_state":null,
//                "native_place":null,
//                "marital_status":null,
//                "living_place":null,
//                "education":null,
//                "major":null,
//                "urgent_person":null,
//                "urgent_phone":null,
//                "urgent_contact":null,
//                "try_hillock_time":null,
//                "state":null,
//                "bank_image":null,
//                "bank_image_state":null,
//                "id_card_image_heads":null,
//                "id_card_image_tails":null,
//                "resignation_certificate":null,
//                "degree_certificate":null,
//                "health_certificate":null,
//                "resignation_certificate_state":null,
//                "degree_certificate_state":null,
//                "passport_photo_state":null,
//                "health_certificate_state":null,
//                "qualification_certificate":null,
//                "a_state":null,
//                "sid":null,
//                "branchName":null,
//                "inside_user":0,
//                "join_date":"0001-01-01T00:00:00",
//                "OperatorCard":null,
//                "OperatorDepart":3,
//                "order_id":null,
//                "image":null,
//                "id_card_image_heads_state":null,
//                "id_card_image_tails_state":null,
//                "bank_image_heads":null,
//                "primaryCertificate":null,
//                "intermediateCertificate":null,
//                "advancedCertificate":null,
//                "primaryCertificate_state":0,
//                "intermediateCertificate_state":0,
//                "advancedCertificate_state":0,
//                "Entry_state":0,
//                "identity_state":0,
//                "shen_fen_data_state":null,
//                "xian_zhu_zhi_data_state":null,
//                "sheng_ri_data_state":null,
//                "xue_li_data_state":null,
//                "hun_fou_data_state":null,
//                "yin_hang_data_state":null,
//                "jin_ji_lian_xi_data_state":null,
//                "id":0,
//                "flag":0,
//                "create_date":"2018-04-16T20:16:39.36",
//                "update_date":"0001-01-01T00:00:00"


        public BodyBean() {
            super();
        }

        @Override
        public String toString() {
            return "BodyBean{" +
                    "cardNo='" + cardNo + '\'' +
                    ", name='" + name + '\'' +
                    ", a_account='" + a_account + '\'' +
                    ", post_id=" + post_id +
                    ", postName='" + postName + '\'' +
                    ", sex='" + sex + '\'' +
                    ", birthday='" + birthday + '\'' +
                    ", strBirthday='" + strBirthday + '\'' +
                    ", phone='" + phone + '\'' +
                    ", email='" + email + '\'' +
                    ", id_card='" + id_card + '\'' +
                    ", bank_card='" + bank_card + '\'' +
                    ", bank_name='" + bank_name + '\'' +
                    ", living_place='" + living_place + '\'' +
                    ", education='" + education + '\'' +
                    ", OperatorDepart=" + OperatorDepart +
                    ", create_date='" + create_date + '\'' +
                    ", update_date='" + update_date + '\'' +
                    ", passport_photo='" + passport_photo + '\'' +
                    ", id_card_image_heads='" + id_card_image_heads + '\'' +
                    ", id_card_image_tails='" + id_card_image_tails + '\'' +
                    ", primaryCertificate='" + primaryCertificate + '\'' +
                    ", intermediateCertificate='" + intermediateCertificate + '\'' +
                    ", advancedCertificate='" + advancedCertificate + '\'' +
                    ", bank_image_heads='" + bank_image_heads + '\'' +
                    ", identity_state='" + identity_state + '\'' +
                    ", Entry_state='" + Entry_state + '\'' +
                    '}';
        }

        public String getCardNo() {
            return cardNo;
        }

        public void setCardNo(String cardNo) {
            this.cardNo = cardNo;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getA_account() {
            return a_account;
        }

        public void setA_account(String a_account) {
            this.a_account = a_account;
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

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public String getStrBirthday() {
            return strBirthday;
        }

        public void setStrBirthday(String strBirthday) {
            this.strBirthday = strBirthday;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getId_card() {
            return id_card;
        }

        public void setId_card(String id_card) {
            this.id_card = id_card;
        }

        public String getBank_card() {
            return bank_card;
        }

        public void setBank_card(String bank_card) {
            this.bank_card = bank_card;
        }

        public String getBank_name() {
            return bank_name;
        }

        public void setBank_name(String bank_name) {
            this.bank_name = bank_name;
        }

        public String getLiving_place() {
            return living_place;
        }

        public void setLiving_place(String living_place) {
            this.living_place = living_place;
        }

        public String getEducation() {
            return education;
        }

        public void setEducation(String education) {
            this.education = education;
        }

        public int getOperatorDepart() {
            return OperatorDepart;
        }

        public void setOperatorDepart(int operatorDepart) {
            OperatorDepart = operatorDepart;
        }

        public String getCreate_date() {
            return create_date;
        }

        public void setCreate_date(String create_date) {
            this.create_date = create_date;
        }

        public String getUpdate_date() {
            return update_date;
        }

        public void setUpdate_date(String update_date) {
            this.update_date = update_date;
        }

        public String getPassport_photo() {
            return passport_photo;
        }

        public void setPassport_photo(String passport_photo) {
            this.passport_photo = passport_photo;
        }

        public String getId_card_image_heads() {
            return id_card_image_heads;
        }

        public void setId_card_image_heads(String id_card_image_heads) {
            this.id_card_image_heads = id_card_image_heads;
        }

        public String getId_card_image_tails() {
            return id_card_image_tails;
        }

        public void setId_card_image_tails(String id_card_image_tails) {
            this.id_card_image_tails = id_card_image_tails;
        }

        public String getPrimaryCertificate() {
            return primaryCertificate;
        }

        public void setPrimaryCertificate(String primaryCertificate) {
            this.primaryCertificate = primaryCertificate;
        }

        public String getIntermediateCertificate() {
            return intermediateCertificate;
        }

        public void setIntermediateCertificate(String intermediateCertificate) {
            this.intermediateCertificate = intermediateCertificate;
        }

        public String getAdvancedCertificate() {
            return advancedCertificate;
        }

        public void setAdvancedCertificate(String advancedCertificate) {
            this.advancedCertificate = advancedCertificate;
        }

        public String getBank_image_heads() {
            return bank_image_heads;
        }

        public void setBank_image_heads(String bank_image_heads) {
            this.bank_image_heads = bank_image_heads;
        }

        public int getIdentity_state() {
            return identity_state;
        }

        public void setIdentity_state(int identity_state) {
            this.identity_state = identity_state;
        }

        public int getEntry_state() {
            return Entry_state;
        }

        public void setEntry_state(int entry_state) {
            Entry_state = entry_state;
        }

        public String getBank_user_name() {
            return bank_user_name;
        }

        public void setBank_user_name(String bank_user_name) {
            this.bank_user_name = bank_user_name;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }
    }
}
