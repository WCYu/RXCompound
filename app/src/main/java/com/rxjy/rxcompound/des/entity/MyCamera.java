package com.rxjy.rxcompound.des.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/8/16.
 */

public class MyCamera implements Serializable {
    private String StatusCode;
    private String StatusMsg;
    private Body Body;

    public String getStatusCode() {
        return StatusCode;
    }

    public void setStatusCode(String statusCode) {
        StatusCode = statusCode;
    }

    public String getStatusMsg() {
        return StatusMsg;
    }

    public void setStatusMsg(String statusMsg) {
        StatusMsg = statusMsg;
    }

    public MyCamera.Body getBody() {
        return Body;
    }

    public void setBody(MyCamera.Body body) {
        Body = body;
    }




    public static class Body{

        private int UserID;
        private int WorkID;
        private List<CatalogList> CatalogList;

        public int getUserID() {
            return UserID;
        }

        public void setUserID(int userID) {
            UserID = userID;
        }

        public int getWorkID() {
            return WorkID;
        }

        public void setWorkID(int workID) {
            WorkID = workID;
        }

        public List<MyCamera.Body.CatalogList> getCatalogList() {
            return CatalogList;
        }

        public void setCatalogList(List<MyCamera.Body.CatalogList> catalogList) {
            CatalogList = catalogList;
        }

        public static class CatalogList{
            private String CatalogName;
            private String CatalogID;
            private String ImgCount;

            public String getCatalogName() {
                return CatalogName;
            }

            public void setCatalogName(String catalogName) {
                CatalogName = catalogName;
            }

            public String getCatalogID() {
                return CatalogID;
            }

            public void setCatalogID(String catalogID) {
                CatalogID = catalogID;
            }

            public String getImgCount() {
                return ImgCount;
            }

            public void setImgCount(String imgCount) {
                ImgCount = imgCount;
            }
        }


    }
}
