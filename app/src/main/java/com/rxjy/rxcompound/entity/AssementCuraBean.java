package com.rxjy.rxcompound.entity;

/**
 * Created by hjh on 2017/11/16.
 */

public class AssementCuraBean {


    private int dayIndex;
    private int coursewareGrade;
    private int videoType;
    private int indexNo;
    private int dept;
    private String courInfo;
    private String appFileUrl;
    private String score;
    private String coursewareCore;
    private String property;
    private String fileUrl;
    private String coursewareNo;
    private String coursewarePoint;
    private String coursewareDescribe;
    private String cardno;
    private String courInfoId;
    private String coursewareTarget;

    public AssementCuraBean() {super();
    }

    @Override
    public String toString() {
        return "AssementCuraBean{" +
                "dayIndex=" + dayIndex +
                ", coursewareGrade=" + coursewareGrade +
                ", videoType=" + videoType +
                ", indexNo=" + indexNo +
                ", dept=" + dept +
                ", courInfo='" + courInfo + '\'' +
                ", appFileUrl='" + appFileUrl + '\'' +
                ", score='" + score + '\'' +
                ", coursewareCore='" + coursewareCore + '\'' +
                ", property='" + property + '\'' +
                ", fileUrl='" + fileUrl + '\'' +
                ", coursewareNo='" + coursewareNo + '\'' +
                ", coursewarePoint='" + coursewarePoint + '\'' +
                ", coursewareDescribe='" + coursewareDescribe + '\'' +
                ", cardno='" + cardno + '\'' +
                ", courInfoId='" + courInfoId + '\'' +
                ", coursewareTarget='" + coursewareTarget + '\'' +
                '}';
    }

    public int getDayIndex() {
        return dayIndex;
    }

    public void setDayIndex(int dayIndex) {
        this.dayIndex = dayIndex;
    }

    public int getCoursewareGrade() {
        return coursewareGrade;
    }

    public void setCoursewareGrade(int coursewareGrade) {
        this.coursewareGrade = coursewareGrade;
    }

    public int getVideoType() {
        return videoType;
    }

    public void setVideoType(int videoType) {
        this.videoType = videoType;
    }

    public int getIndexNo() {
        return indexNo;
    }

    public void setIndexNo(int indexNo) {
        this.indexNo = indexNo;
    }

    public int getDept() {
        return dept;
    }

    public void setDept(int dept) {
        this.dept = dept;
    }

    public String getCourInfo() {
        return courInfo;
    }

    public void setCourInfo(String courInfo) {
        this.courInfo = courInfo;
    }

    public String getAppFileUrl() {
        return appFileUrl;
    }

    public void setAppFileUrl(String appFileUrl) {
        this.appFileUrl = appFileUrl;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getCoursewareCore() {
        return coursewareCore;
    }

    public void setCoursewareCore(String coursewareCore) {
        this.coursewareCore = coursewareCore;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getCoursewareNo() {
        return coursewareNo;
    }

    public void setCoursewareNo(String coursewareNo) {
        this.coursewareNo = coursewareNo;
    }

    public String getCoursewarePoint() {
        return coursewarePoint;
    }

    public void setCoursewarePoint(String coursewarePoint) {
        this.coursewarePoint = coursewarePoint;
    }

    public String getCoursewareDescribe() {
        return coursewareDescribe;
    }

    public void setCoursewareDescribe(String coursewareDescribe) {
        this.coursewareDescribe = coursewareDescribe;
    }

    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno;
    }

    public String getCourInfoId() {
        return courInfoId;
    }

    public void setCourInfoId(String courInfoId) {
        this.courInfoId = courInfoId;
    }

    public String getCoursewareTarget() {
        return coursewareTarget;
    }

    public void setCoursewareTarget(String coursewareTarget) {
        this.coursewareTarget = coursewareTarget;
    }
}
