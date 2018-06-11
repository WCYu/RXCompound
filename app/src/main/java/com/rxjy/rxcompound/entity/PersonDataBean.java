package com.rxjy.rxcompound.entity;

/**
 * Created by hjh on 2017/11/10.
 */

public class PersonDataBean {

    private int DepartId;
    private int RegionId;
    private int IsFinsh;
    private int Z2IsFinsh;
    private int Z3IsFinsh;
    private String RegionName;
    private String CardNo;
    private String Name;
    private String Image;
    private String Sex;
    private String DepartName;
    private String PostName;
    private String TryHillockTime;
    private String Phone;
    private String Marriage;
    private String passport_photo;


    //身份证
    private String IdCard;
    private String IdCardName;
    private String IdCardImageHeads;
    private String IdCardImageTails;
    private String Birthday;
    private String IdCardAddress;
    private String NowAddress;


    //入职资料
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


    public PersonDataBean() {super();
    }

    @Override
    public String toString() {
        return "PersonDataBean{" +
                "DepartId=" + DepartId +
                ", RegionId=" + RegionId +
                ", IsFinsh=" + IsFinsh +
                ", RegionName='" + RegionName + '\'' +
                ", CardNo='" + CardNo + '\'' +
                ", Name='" + Name + '\'' +
                ", Image='" + Image + '\'' +
                ", Sex='" + Sex + '\'' +
                ", DepartName='" + DepartName + '\'' +
                ", PostName='" + PostName + '\'' +
                ", TryHillockTime='" + TryHillockTime + '\'' +
                ", Phone='" + Phone + '\'' +
                ", Marriage='" + Marriage + '\'' +
                ", passport_photo='" + passport_photo + '\'' +
                ", IdCard='" + IdCard + '\'' +
                ", IdCardName='" + IdCardName + '\'' +
                ", IdCardImageHeads='" + IdCardImageHeads + '\'' +
                ", IdCardImageTails='" + IdCardImageTails + '\'' +
                ", Birthday='" + Birthday + '\'' +
                ", IdCardAddress='" + IdCardAddress + '\'' +
                ", NowAddress='" + NowAddress + '\'' +
                ", BankCard='" + BankCard + '\'' +
                ", BankImage='" + BankImage + '\'' +
                ", BankImageHeads='" + BankImageHeads + '\'' +
                ", BankImageTails='" + BankImageTails + '\'' +
                ", BankName='" + BankName + '\'' +
                ", BankUserName='" + BankUserName + '\'' +
                ", UrgentPerson='" + UrgentPerson + '\'' +
                ", UrgentPhone='" + UrgentPhone + '\'' +
                ", UrgentContact='" + UrgentContact + '\'' +
                ", ResignationCertificate='" + ResignationCertificate + '\'' +
                ", DegreeCertificate='" + DegreeCertificate + '\'' +
                ", PassportPhoto='" + PassportPhoto + '\'' +
                ", HealthCertificate='" + HealthCertificate + '\'' +
                ", QualificationCertificate='" + QualificationCertificate + '\'' +
                '}';
    }

    public String getPassport_photo() {
        return passport_photo;
    }

    public void setPassport_photo(String passport_photo) {
        this.passport_photo = passport_photo;
    }

    public int getIsFinsh() {
        return IsFinsh;
    }

    public void setIsFinsh(int isFinsh) {
        IsFinsh = isFinsh;
    }

    public int getDepartId() {
        return DepartId;
    }

    public void setDepartId(int departId) {
        DepartId = departId;
    }

    public int getRegionId() {
        return RegionId;
    }

    public void setRegionId(int regionId) {
        RegionId = regionId;
    }

    public String getRegionName() {
        return RegionName;
    }

    public void setRegionName(String regionName) {
        RegionName = regionName;
    }

    public String getCardNo() {
        return CardNo;
    }

    public void setCardNo(String cardNo) {
        CardNo = cardNo;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public String getDepartName() {
        return DepartName;
    }

    public void setDepartName(String departName) {
        DepartName = departName;
    }

    public String getPostName() {
        return PostName;
    }

    public void setPostName(String postName) {
        PostName = postName;
    }

    public String getTryHillockTime() {
        return TryHillockTime;
    }

    public void setTryHillockTime(String tryHillockTime) {
        TryHillockTime = tryHillockTime;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getMarriage() {
        return Marriage;
    }

    public void setMarriage(String marriage) {
        Marriage = marriage;
    }


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

    public int getZ2IsFinsh() {
        return Z2IsFinsh;
    }

    public void setZ2IsFinsh(int z2IsFinsh) {
        Z2IsFinsh = z2IsFinsh;
    }

    public int getZ3IsFinsh() {
        return Z3IsFinsh;
    }

    public void setZ3IsFinsh(int z3IsFinsh) {
        Z3IsFinsh = z3IsFinsh;
    }
}
