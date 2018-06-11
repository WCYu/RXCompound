package com.rxjy.rxcompound.des.entity;

/**
 * Created by hjh on 2018/4/4.
 */

public class LHouseSubmitBean {

    public static class clientInfos{

//        "ci_proHead": name,//客户姓名
//                "ci_proHeadTel": phone,//客户电话
//                "ci_OfficeAddress": address,//量房地址(删)
//                "ci_ClientName": clientName,//项目名称
//                "ci_Type": type,//项目类型
//                "ci_Area": area,//面积
//                "ci_DecorationAddress": houseAddress,//量房地址
//                "ci_DesignerCard": '@cardNo'//设计师卡号

        private String ci_proHead;
        private String ci_proHeadTel;
        private String ci_ClientName;
        private String ci_Type;
        private String ci_Area;
        private String ci_DecorationAddress;
        private String ci_DesignerCard;

        @Override
        public String toString() {
            return "clientInfo{" +
                    "ci_proHead='" + ci_proHead + '\'' +
                    ", ci_proHeadTel='" + ci_proHeadTel + '\'' +
                    ", ci_ClientName='" + ci_ClientName + '\'' +
                    ", ci_Type='" + ci_Type + '\'' +
                    ", ci_Area='" + ci_Area + '\'' +
                    ", ci_DecorationAddress='" + ci_DecorationAddress + '\'' +
                    ", ci_DesignerCard='" + ci_DesignerCard + '\'' +
                    '}';
        }

        public String getCi_proHead() {
            return ci_proHead;
        }

        public void setCi_proHead(String ci_proHead) {
            this.ci_proHead = ci_proHead;
        }

        public String getCi_proHeadTel() {
            return ci_proHeadTel;
        }

        public void setCi_proHeadTel(String ci_proHeadTel) {
            this.ci_proHeadTel = ci_proHeadTel;
        }


        public String getCi_ClientName() {
            return ci_ClientName;
        }

        public void setCi_ClientName(String ci_ClientName) {
            this.ci_ClientName = ci_ClientName;
        }

        public String getCi_Type() {
            return ci_Type;
        }

        public void setCi_Type(String ci_Type) {
            this.ci_Type = ci_Type;
        }

        public String getCi_Area() {
            return ci_Area;
        }

        public void setCi_Area(String ci_Area) {
            this.ci_Area = ci_Area;
        }

        public String getCi_DecorationAddress() {
            return ci_DecorationAddress;
        }

        public void setCi_DecorationAddress(String ci_DecorationAddress) {
            this.ci_DecorationAddress = ci_DecorationAddress;
        }

        public String getCi_DesignerCard() {
            return ci_DesignerCard;
        }

        public void setCi_DesignerCard(String ci_DesignerCard) {
            this.ci_DesignerCard = ci_DesignerCard;
        }
    }




    public static class clientAuxiliarys{
//        "ca_proAttribute": attribute,//项目属性
//                "ca_DecorationDate": time,//装修时间
//                "ca_DecBudgetPrice": budget,//项目预算
//                "ca_HousingType": houseStatus,//房屋状况
//                "ca_AvailabilityStatus": housingState,//房源状态
//                "ca_TransactionType": transaction,//成交类型
//                "ca_MeasureDate": houseTime//量房时间

        private String ca_proAttribute;
        private String ca_DecorationDate;
        private String ca_DecBudgetPrice;
        private String ca_HousingType;
        private String ca_AvailabilityStatus;
        private String ca_TransactionType;
        private String ca_MeasureDate;
        private String ca_SWIndustryTypeID;

        @Override
        public String toString() {
            return "clientAuxiliarys{" +
                    "ca_proAttribute='" + ca_proAttribute + '\'' +
                    ", ca_DecorationDate='" + ca_DecorationDate + '\'' +
                    ", ca_DecBudgetPrice='" + ca_DecBudgetPrice + '\'' +
                    ", ca_HousingType='" + ca_HousingType + '\'' +
                    ", ca_AvailabilityStatus='" + ca_AvailabilityStatus + '\'' +
                    ", ca_TransactionType='" + ca_TransactionType + '\'' +
                    ", ca_MeasureDate='" + ca_MeasureDate + '\'' +
                    ", ca_SWIndustryTypeID='" + ca_SWIndustryTypeID + '\'' +
                    '}';
        }

        public String getCa_proAttribute() {
            return ca_proAttribute;
        }

        public void setCa_proAttribute(String ca_proAttribute) {
            this.ca_proAttribute = ca_proAttribute;
        }

        public String getCa_DecorationDate() {
            return ca_DecorationDate;
        }

        public void setCa_DecorationDate(String ca_DecorationDate) {
            this.ca_DecorationDate = ca_DecorationDate;
        }

        public String getCa_DecBudgetPrice() {
            return ca_DecBudgetPrice;
        }

        public void setCa_DecBudgetPrice(String ca_DecBudgetPrice) {
            this.ca_DecBudgetPrice = ca_DecBudgetPrice;
        }

        public String getCa_HousingType() {
            return ca_HousingType;
        }

        public void setCa_HousingType(String ca_HousingType) {
            this.ca_HousingType = ca_HousingType;
        }

        public String getCa_AvailabilityStatus() {
            return ca_AvailabilityStatus;
        }

        public void setCa_AvailabilityStatus(String ca_AvailabilityStatus) {
            this.ca_AvailabilityStatus = ca_AvailabilityStatus;
        }

        public String getCa_TransactionType() {
            return ca_TransactionType;
        }

        public void setCa_TransactionType(String ca_TransactionType) {
            this.ca_TransactionType = ca_TransactionType;
        }

        public String getCa_MeasureDate() {
            return ca_MeasureDate;
        }

        public void setCa_MeasureDate(String ca_MeasureDate) {
            this.ca_MeasureDate = ca_MeasureDate;
        }

        public String getCa_SWIndustryTypeID() {
            return ca_SWIndustryTypeID;
        }

        public void setCa_SWIndustryTypeID(String ca_SWIndustryTypeID) {
            this.ca_SWIndustryTypeID = ca_SWIndustryTypeID;
        }
    }

}
