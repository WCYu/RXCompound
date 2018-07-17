package com.rxjy.rxcompound.des.entity;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by hjh on 2018/4/17.
 */

public class AllClientNewBean implements Serializable{

    private int StatusCode;
    private String StatusMsg;
    private ArrayList<ClientNewBean> Body;

    public AllClientNewBean() {
        super();
    }

    @Override
    public String toString() {
        return "AllClientNewBean{" +
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

    public ArrayList<ClientNewBean> getBody() {
        return Body;
    }

    public void setBody(ArrayList<ClientNewBean> body) {
        Body = body;
    }

    public class ClientNewBean implements Serializable {
//        "ci_ClientName":"湖南资产管理某公司办公室装修项目",
//                "ci_DesignerCard":"02900996",
//                "StateName":"方案",
//                "CustomerID":12524,
//                "ca_MeasureDate":"2018-03-13",
//                "Mobile":"18681827923",
//                "Total":2,
//                "ci_DecorationAddress":"高新大都荟",
//                "ci_RwdId":"25-72311",
//                "WorksID":20113

        private String ci_ClientName;
        private String ci_DesignerCard;
        private String StateName;
        private String ca_MeasureDate;
        private String Mobile;
        private String ci_DecorationAddress;
        private String ci_RwdId;
        private int CustomerID;
        private int Total;
        private int WorksID;
        private String appId;

        public ClientNewBean() {
            super();
        }

        @Override
        public String toString() {
            return "ClientNewBean{" +
                    "ci_ClientName='" + ci_ClientName + '\'' +
                    ", ci_DesignerCard='" + ci_DesignerCard + '\'' +
                    ", StateName='" + StateName + '\'' +
                    ", ca_MeasureDate='" + ca_MeasureDate + '\'' +
                    ", Mobile='" + Mobile + '\'' +
                    ", ci_DecorationAddress='" + ci_DecorationAddress + '\'' +
                    ", ci_RwdId='" + ci_RwdId + '\'' +
                    ", CustomerID=" + CustomerID +
                    ", Total=" + Total +
                    ", WorksID=" + WorksID +
                    '}';
        }

        public String getAppId() {
            return appId;
        }

        public void setAppId(String appId) {
            this.appId = appId;
        }

        public String getCi_ClientName() {
            return ci_ClientName;
        }

        public void setCi_ClientName(String ci_ClientName) {
            this.ci_ClientName = ci_ClientName;
        }

        public String getCi_DesignerCard() {
            return ci_DesignerCard;
        }

        public void setCi_DesignerCard(String ci_DesignerCard) {
            this.ci_DesignerCard = ci_DesignerCard;
        }

        public String getStateName() {
            return StateName;
        }

        public void setStateName(String stateName) {
            StateName = stateName;
        }

        public String getCa_MeasureDate() {
            return ca_MeasureDate;
        }

        public void setCa_MeasureDate(String ca_MeasureDate) {
            this.ca_MeasureDate = ca_MeasureDate;
        }

        public String getMobile() {
            return Mobile;
        }

        public void setMobile(String mobile) {
            Mobile = mobile;
        }

        public String getCi_DecorationAddress() {
            return ci_DecorationAddress;
        }

        public void setCi_DecorationAddress(String ci_DecorationAddress) {
            this.ci_DecorationAddress = ci_DecorationAddress;
        }

        public String getCi_RwdId() {
            return ci_RwdId;
        }

        public void setCi_RwdId(String ci_RwdId) {
            this.ci_RwdId = ci_RwdId;
        }

        public int getCustomerID() {
            return CustomerID;
        }

        public void setCustomerID(int customerID) {
            CustomerID = customerID;
        }

        public int getTotal() {
            return Total;
        }

        public void setTotal(int total) {
            Total = total;
        }

        public int getWorksID() {
            return WorksID;
        }

        public void setWorksID(int worksID) {
            WorksID = worksID;
        }
    }
}
