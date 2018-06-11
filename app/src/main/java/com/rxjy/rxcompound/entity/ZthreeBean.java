package com.rxjy.rxcompound.entity;

/**
 * Created by hjh on 2018/5/10.
 */

public class ZthreeBean {

    private int StatusCode;
    private String StatusMsg;
    private BodyBean Body;

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

        private String YinHangDataState;
        private String JinJiLianXiDataState;
        private String BankImageState;
        private String ResignationCertificateState;
        private String DegreeCertificateState;
        private String PassportPhotoState;
        private String HealthCertificateState;
        private int IsFinsh;
        private String CardNo;
        private String BankCard;
        private String BankImage;
        private String BankImageHeads;
        private String BankImageTails;
        private String BankName;
        private String BankUserName;
        private String UrgentPerson;
        private String UrgentPhone;
        private String UrgentContact;
        private String ResignationCertificate;
        private String DegreeCertificate;
        private String PassportPhoto;
        private String HealthCertificate;
        private String QualificationCertificate;
        private String branchName;

        public String getYinHangDataState() {
            return YinHangDataState;
        }

        public void setYinHangDataState(String yinHangDataState) {
            YinHangDataState = yinHangDataState;
        }

        public String getJinJiLianXiDataState() {
            return JinJiLianXiDataState;
        }

        public void setJinJiLianXiDataState(String jinJiLianXiDataState) {
            JinJiLianXiDataState = jinJiLianXiDataState;
        }

        public String getBankImageState() {
            return BankImageState;
        }

        public void setBankImageState(String bankImageState) {
            BankImageState = bankImageState;
        }

        public String getResignationCertificateState() {
            return ResignationCertificateState;
        }

        public void setResignationCertificateState(String resignationCertificateState) {
            ResignationCertificateState = resignationCertificateState;
        }

        public String getDegreeCertificateState() {
            return DegreeCertificateState;
        }

        public void setDegreeCertificateState(String degreeCertificateState) {
            DegreeCertificateState = degreeCertificateState;
        }

        public String getPassportPhotoState() {
            return PassportPhotoState;
        }

        public void setPassportPhotoState(String passportPhotoState) {
            PassportPhotoState = passportPhotoState;
        }

        public String getHealthCertificateState() {
            return HealthCertificateState;
        }

        public void setHealthCertificateState(String healthCertificateState) {
            HealthCertificateState = healthCertificateState;
        }

        public int getIsFinsh() {
            return IsFinsh;
        }

        public void setIsFinsh(int isFinsh) {
            IsFinsh = isFinsh;
        }

        public String getCardNo() {
            return CardNo;
        }

        public void setCardNo(String cardNo) {
            CardNo = cardNo;
        }

        public String getBankCard() {
            return BankCard;
        }

        public void setBankCard(String bankCard) {
            BankCard = bankCard;
        }

        public String getBankImage() {
            return BankImage;
        }

        public void setBankImage(String bankImage) {
            BankImage = bankImage;
        }

        public String getBankImageHeads() {
            return BankImageHeads;
        }

        public void setBankImageHeads(String bankImageHeads) {
            BankImageHeads = bankImageHeads;
        }

        public String getBankImageTails() {
            return BankImageTails;
        }

        public void setBankImageTails(String bankImageTails) {
            BankImageTails = bankImageTails;
        }

        public String getBankName() {
            return BankName;
        }

        public void setBankName(String bankName) {
            BankName = bankName;
        }

        public String getBankUserName() {
            return BankUserName;
        }

        public void setBankUserName(String bankUserName) {
            BankUserName = bankUserName;
        }

        public String getUrgentPerson() {
            return UrgentPerson;
        }

        public void setUrgentPerson(String urgentPerson) {
            UrgentPerson = urgentPerson;
        }

        public String getUrgentPhone() {
            return UrgentPhone;
        }

        public void setUrgentPhone(String urgentPhone) {
            UrgentPhone = urgentPhone;
        }

        public String getUrgentContact() {
            return UrgentContact;
        }

        public void setUrgentContact(String urgentContact) {
            UrgentContact = urgentContact;
        }

        public String getResignationCertificate() {
            return ResignationCertificate;
        }

        public void setResignationCertificate(String resignationCertificate) {
            ResignationCertificate = resignationCertificate;
        }

        public String getDegreeCertificate() {
            return DegreeCertificate;
        }

        public void setDegreeCertificate(String degreeCertificate) {
            DegreeCertificate = degreeCertificate;
        }

        public String getPassportPhoto() {
            return PassportPhoto;
        }

        public void setPassportPhoto(String passportPhoto) {
            PassportPhoto = passportPhoto;
        }

        public String getHealthCertificate() {
            return HealthCertificate;
        }

        public void setHealthCertificate(String healthCertificate) {
            HealthCertificate = healthCertificate;
        }

        public String getQualificationCertificate() {
            return QualificationCertificate;
        }

        public void setQualificationCertificate(String qualificationCertificate) {
            QualificationCertificate = qualificationCertificate;
        }

        public String getBranchName() {
            return branchName;
        }

        public void setBranchName(String branchName) {
            this.branchName = branchName;
        }

        //         "YinHangDataState":null,
//                 "JinJiLianXiDataState":null,
//                 "CardNo":"01012441",
//                 "BankCard":"6212260200143583132",
//                 "BankImage":"http://img.dcwzg.com:9192/image/001CwKgBtFoSsOKAEhz2AAAW9w5Azaw874.png",
//                 "BankImageState":"1",
//                 "BankImageHeads":null,
//                 "BankImageTails":null,
//                 "BankName":"中国工商银行",
//                 "BankUserName":"候佳会",
//                 "UrgentPerson":"王玲玲",
//                 "UrgentPhone":"15216342571",
//                 "UrgentContact":"朋友",
//                 "ResignationCertificate":"http://img.dcwzg.com:9192/image/001FwKgBtFoei9CAT9WpAAIp21YMUR4982.jpg",
//                 "DegreeCertificate":"http://img.dcwzg.com:9192/image/001CwKgBtFoSqTOAcRjXAACwIlBNM-Q722.jpg",
//                 "PassportPhoto":"http://up.rs.rx/UploadFile/rs/File_87ce57229a2c41f6a07f1e40885f2436.jpg",
//                 "HealthCertificate":"http://img.dcwzg.com:9192/image/001CwKgBtFoSiDqAJ8FSAAEL1Sv9A94425.jpg",
//                 "ResignationCertificateState":"1",
//                 "DegreeCertificateState":"1",
//                 "PassportPhotoState":"1",
//                 "HealthCertificateState":"1",
//                 "QualificationCertificate":null,
//                 "IsFinsh":2,
//                 "branchName":"北京市分行营业部"

    }

}