package com.rxjy.rxcompound.entity;

/**
 * Created by AAA on 2017/8/9.
 */

public class VersionInfo {

    private int StatusCode;
    private String StatusMsg;
    private Version Body;

    @Override
    public String toString() {
        return "VersionInfo{" +
                "StatusCode=" + StatusCode +
                ", StatusMsg='" + StatusMsg + '\'' +
                ", Body=" + Body +
                '}';
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

    public Version getBody() {
        return Body;
    }

    public void setBody(Version Body) {
        this.Body = Body;
    }

    public static class Version {

        private String VersionName;
        private int VersionNo;
        private String VersionUrl;
        private String Content;
        private int force;

        @Override
        public String toString() {
            return "Version{" +
                    "VersionName='" + VersionName + '\'' +
                    ", VersionNo=" + VersionNo +
                    ", VersionUrl='" + VersionUrl + '\'' +
                    ", Content='" + Content + '\'' +
                    ", force=" + force +
                    '}';
        }

        public int getForce() {
            return force;
        }

        public void setForce(int force) {
            this.force = force;
        }

        public String getVersionName() {
            return VersionName;
        }

        public void setVersionName(String VersionName) {
            this.VersionName = VersionName;
        }

        public int getVersionNo() {
            return VersionNo;
        }

        public void setVersionNo(int VersionNo) {
            this.VersionNo = VersionNo;
        }

        public String getVersionUrl() {
            return VersionUrl;
        }

        public void setVersionUrl(String VersionUrl) {
            this.VersionUrl = VersionUrl;
        }

        public String getContent() {
            return Content;
        }

        public void setContent(String Content) {
            this.Content = Content;
        }
    }
}
