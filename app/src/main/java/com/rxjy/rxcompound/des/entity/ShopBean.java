package com.rxjy.rxcompound.des.entity;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created by asus on 2018/5/24.
 */

public class ShopBean {

    /**
     * StatusCode : 200
     * StatusMsg : null
     * Body : {"um_ID":1,"um_CardNo":"00000003","um_Password":"YJXR4ee7d9e67aa9978b926ec630f0f1a6bf","um_Name":"王婷婷","um_EnglishName":null,"um_Sex":2,"um_Age":null,"um_WorkYears":null,"um_WeChat":null,"um_Phone":"15810563815","um_EntryTime":"2014-01-02T00:00:00","um_Birthdy":"1988-01-24T00:00:00","um_Email":"616533951@qq.com","um_Education":"本科","um_StarLevel":5,"um_GoodType":null,"um_Motto":"设计源于生活，生活因设计而改变！","um_QRCode":"http://img9.wenes.cn/upload/ZhuAn/QRcode/4c5c96d5-cb8a-44f9-9f7f-119d7199b51c/2016072918238653473.jpg","um_ImagePhoto":"","um_Role":37,"um_State":3,"um_LeaveDate":null,"um_PublicIdent":0,"um_Consultation":null}
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

    public static class BodyBean  implements Serializable{
        /**
         * um_ID : 1
         * um_CardNo : 00000003
         * um_Password : YJXR4ee7d9e67aa9978b926ec630f0f1a6bf
         * um_Name : 王婷婷
         * um_EnglishName : null
         * um_Sex : 2
         * um_Age : null
         * um_WorkYears : null
         * um_WeChat : null
         * um_Phone : 15810563815
         * um_EntryTime : 2014-01-02T00:00:00
         * um_Birthdy : 1988-01-24T00:00:00
         * um_Email : 616533951@qq.com
         * um_Education : 本科
         * um_StarLevel : 5
         * um_GoodType : null
         * um_Motto : 设计源于生活，生活因设计而改变！
         * um_QRCode : http://img9.wenes.cn/upload/ZhuAn/QRcode/4c5c96d5-cb8a-44f9-9f7f-119d7199b51c/2016072918238653473.jpg
         * um_ImagePhoto :
         * um_Role : 37
         * um_State : 3
         * um_LeaveDate : null
         * um_PublicIdent : 0
         * um_Consultation : null
         */

        private int um_ID;
        private String um_CardNo;
        private String um_Password;
        private String um_Name;
        private String um_EnglishName;
        private int um_Sex;
        private Object um_Age;
        private Object um_WorkYears;
        private Object um_WeChat;
        private String um_Phone;
        private String um_EntryTime;
        private String um_Birthdy;
        private String um_Email;
        private String um_Education;
        private int um_StarLevel;
        private Object um_GoodType;
        private String um_Motto;
        private String um_QRCode;
        private String um_ImagePhoto;
        private int um_Role;
        private int um_State;
        private Object um_LeaveDate;
        private int um_PublicIdent;
        private Object um_Consultation;

        public int getUm_ID() {
            return um_ID;
        }

        public void setUm_ID(int um_ID) {
            this.um_ID = um_ID;
        }

        public String getUm_CardNo() {
            return um_CardNo;
        }

        public void setUm_CardNo(String um_CardNo) {
            this.um_CardNo = um_CardNo;
        }

        public String getUm_Password() {
            return um_Password;
        }

        public void setUm_Password(String um_Password) {
            this.um_Password = um_Password;
        }

        public String getUm_Name() {
            return um_Name;
        }

        public void setUm_Name(String um_Name) {
            this.um_Name = um_Name;
        }

        public String getUm_EnglishName() {
            return um_EnglishName;
        }

        public void setUm_EnglishName(String um_EnglishName) {
            this.um_EnglishName = um_EnglishName;
        }

        public int getUm_Sex() {
            return um_Sex;
        }

        public void setUm_Sex(int um_Sex) {
            this.um_Sex = um_Sex;
        }

        public Object getUm_Age() {
            return um_Age;
        }

        public void setUm_Age(Object um_Age) {
            this.um_Age = um_Age;
        }

        public Object getUm_WorkYears() {
            return um_WorkYears;
        }

        public void setUm_WorkYears(Object um_WorkYears) {
            this.um_WorkYears = um_WorkYears;
        }

        public Object getUm_WeChat() {
            return um_WeChat;
        }

        public void setUm_WeChat(Object um_WeChat) {
            this.um_WeChat = um_WeChat;
        }

        public String getUm_Phone() {
            return um_Phone;
        }

        public void setUm_Phone(String um_Phone) {
            this.um_Phone = um_Phone;
        }

        public String getUm_EntryTime() {
            return um_EntryTime;
        }

        public void setUm_EntryTime(String um_EntryTime) {
            this.um_EntryTime = um_EntryTime;
        }

        public String getUm_Birthdy() {
            return um_Birthdy;
        }

        public void setUm_Birthdy(String um_Birthdy) {
            this.um_Birthdy = um_Birthdy;
        }

        public String getUm_Email() {
            return um_Email;
        }

        public void setUm_Email(String um_Email) {
            this.um_Email = um_Email;
        }

        public String getUm_Education() {
            return um_Education;
        }

        public void setUm_Education(String um_Education) {
            this.um_Education = um_Education;
        }

        public int getUm_StarLevel() {
            return um_StarLevel;
        }

        public void setUm_StarLevel(int um_StarLevel) {
            this.um_StarLevel = um_StarLevel;
        }

        public Object getUm_GoodType() {
            return um_GoodType;
        }

        public void setUm_GoodType(Object um_GoodType) {
            this.um_GoodType = um_GoodType;
        }

        public String getUm_Motto() {
            return um_Motto;
        }

        public void setUm_Motto(String um_Motto) {
            this.um_Motto = um_Motto;
        }

        public String getUm_QRCode() {
            return um_QRCode;
        }

        public void setUm_QRCode(String um_QRCode) {
            this.um_QRCode = um_QRCode;
        }

        public String getUm_ImagePhoto() {
            return um_ImagePhoto;
        }

        public void setUm_ImagePhoto(String um_ImagePhoto) {
            this.um_ImagePhoto = um_ImagePhoto;
        }

        public int getUm_Role() {
            return um_Role;
        }

        public void setUm_Role(int um_Role) {
            this.um_Role = um_Role;
        }

        public int getUm_State() {
            return um_State;
        }

        public void setUm_State(int um_State) {
            this.um_State = um_State;
        }

        public Object getUm_LeaveDate() {
            return um_LeaveDate;
        }

        public void setUm_LeaveDate(Object um_LeaveDate) {
            this.um_LeaveDate = um_LeaveDate;
        }

        public int getUm_PublicIdent() {
            return um_PublicIdent;
        }

        public void setUm_PublicIdent(int um_PublicIdent) {
            this.um_PublicIdent = um_PublicIdent;
        }

        public Object getUm_Consultation() {
            return um_Consultation;
        }

        public void setUm_Consultation(Object um_Consultation) {
            this.um_Consultation = um_Consultation;
        }
    }
}
