package com.rxjy.rxcompound.des.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hjh on 2018/4/17.
 */

public class PlanImageBean {
    private int StatusCode;
    private String StatusMsg;

    private List<Data> Body;

    public PlanImageBean() {
        super();
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

    public List<Data> getBody() {
        return Body;
    }

    public void setBody(List<Data> body) {
        Body = body;
    }

    public class Data{
        private String ImageUrl;
        private String SourceFile;
        private int CatalogID;

        public Data() {
            super();
        }

        public String getImageUrl() {
            return ImageUrl;
        }

        public void setImageUrl(String imageUrl) {
            ImageUrl = imageUrl;
        }

        public String getSourceFile() {
            return SourceFile;
        }

        public void setSourceFile(String sourceFile) {
            SourceFile = sourceFile;
        }

        public int getCatalogID() {
            return CatalogID;
        }

        public void setCatalogID(int catalogID) {
            CatalogID = catalogID;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "ImageUrl='" + ImageUrl + '\'' +
                    ", SourceFile='" + SourceFile + '\'' +
                    ", CatalogID=" + CatalogID +
                    '}';
        }
    }
}