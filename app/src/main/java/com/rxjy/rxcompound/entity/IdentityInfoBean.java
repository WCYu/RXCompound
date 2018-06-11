package com.rxjy.rxcompound.entity;

/**
 * Created by hjh on 2018/5/7.
 */

public class IdentityInfoBean {

    private int StatusCode;
    private String StatusMsg;
    private BodyBean  Body;

    public IdentityInfoBean() {
        super();
    }

    @Override
    public String toString() {
        return "ImageDesBean{" +
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

    public class BodyBean{

//        "IdCardImageTails":"http://img.dcwzg.com:9192/image/001CwKgBtFoSnveAMt4fAAGejijtkIM967.jpg",
//                "Birthday":"2014/04/22",
//                "IdCardAddress":"山西",
//                "NowAddress":"北京",
//                "IsFinsh":2,
//                "Marriage":"未婚",
//                "Image":"http://img.dcwzg.com:9192/image/0064wKgBtFp8ClWABxlIAACISF_lfMU125.jpg",
//                "Image_State":null,
//                "Xueli":null
//        "XianZhuZhiDataState":null,
//                "ShengRiDataState":null,
//                "XueLiDataState":null,
//                "HunFouDataState":null,
//                "IdCardImageHeadsState":"0",
//                "IdCardImageTailsState":"1",
//                "ImageState":"1",

        private String IdCard;
        private String IdCardName;
        private String IdCardImageHeads;
        private String IdCardImageTails;
        private String Birthday;
        private String IdCardAddress;
        private String NowAddress;
        private int IsFinsh;
        private String Marriage;
        private String Image;
        private String Xueli;
        private String ShenFenDataState;
        private String XianZhuZhiDataState;
        private String ShengRiDataState;
        private String XueLiDataState;
        private String HunFouDataState;
        private String IdCardImageHeadsState;
        private String IdCardImageTailsState;
        private String ImageState;

        public String getIdCard() {
            return IdCard;
        }

        public void setIdCard(String idCard) {
            IdCard = idCard;
        }

        public String getIdCardName() {
            return IdCardName;
        }

        public void setIdCardName(String idCardName) {
            IdCardName = idCardName;
        }

        public String getIdCardImageHeads() {
            return IdCardImageHeads;
        }

        public void setIdCardImageHeads(String idCardImageHeads) {
            IdCardImageHeads = idCardImageHeads;
        }

        public String getIdCardImageTails() {
            return IdCardImageTails;
        }

        public void setIdCardImageTails(String idCardImageTails) {
            IdCardImageTails = idCardImageTails;
        }

        public String getBirthday() {
            return Birthday;
        }

        public void setBirthday(String birthday) {
            Birthday = birthday;
        }

        public String getIdCardAddress() {
            return IdCardAddress;
        }

        public void setIdCardAddress(String idCardAddress) {
            IdCardAddress = idCardAddress;
        }

        public String getNowAddress() {
            return NowAddress;
        }

        public void setNowAddress(String nowAddress) {
            NowAddress = nowAddress;
        }

        public int getIsFinsh() {
            return IsFinsh;
        }

        public void setIsFinsh(int isFinsh) {
            IsFinsh = isFinsh;
        }

        public String getMarriage() {
            return Marriage;
        }

        public void setMarriage(String marriage) {
            Marriage = marriage;
        }

        public String getImage() {
            return Image;
        }

        public void setImage(String image) {
            Image = image;
        }

        public String getXueli() {
            return Xueli;
        }

        public void setXueli(String xueli) {
            Xueli = xueli;
        }

        public String getShenFenDataState() {
            return ShenFenDataState;
        }

        public void setShenFenDataState(String shenFenDataState) {
            ShenFenDataState = shenFenDataState;
        }

        public String getXianZhuZhiDataState() {
            return XianZhuZhiDataState;
        }

        public void setXianZhuZhiDataState(String xianZhuZhiDataState) {
            XianZhuZhiDataState = xianZhuZhiDataState;
        }

        public String getShengRiDataState() {
            return ShengRiDataState;
        }

        public void setShengRiDataState(String shengRiDataState) {
            ShengRiDataState = shengRiDataState;
        }

        public String getXueLiDataState() {
            return XueLiDataState;
        }

        public void setXueLiDataState(String xueLiDataState) {
            XueLiDataState = xueLiDataState;
        }

        public String getHunFouDataState() {
            return HunFouDataState;
        }

        public void setHunFouDataState(String hunFouDataState) {
            HunFouDataState = hunFouDataState;
        }

        public String getIdCardImageHeadsState() {
            return IdCardImageHeadsState;
        }

        public void setIdCardImageHeadsState(String idCardImageHeadsState) {
            IdCardImageHeadsState = idCardImageHeadsState;
        }

        public String getIdCardImageTailsState() {
            return IdCardImageTailsState;
        }

        public void setIdCardImageTailsState(String idCardImageTailsState) {
            IdCardImageTailsState = idCardImageTailsState;
        }

        public String getImageState() {
            return ImageState;
        }

        public void setImageState(String imageState) {
            ImageState = imageState;
        }
    }

}
