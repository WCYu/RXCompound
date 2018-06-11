package com.rxjy.rxcompound.entity;

import java.util.List;

/**
 * Created by asus on 2018/4/13.
 */

public class CustomerBean {


    /**
     * StatusMsg : 获取成功
     * StatusCode : 0
     * Body : [{"ca_AvailabilityStatus":3,"ci_ClientName":"12132","ci_proHeadTel":"21263","ci_SalesmanName":"IsSetAliasnull","ci_Area":2615,"ca_SWIndustryTypeID":null,"ci_Type":"其他","ca_MeasureDate":"2023-06-16 00:00:00","ca_DecBudgetPrice":465,"ca_HousingType":5,"ca_DecorationDate":"2018/08/16","ca_proAttribute":6,"ca_TransactionType":3,"ci_SalesmanCard":"01100165","ci_DecorationAddress":"阿三大苏打","ci_RwdId":"55-15835","ci_proHead":"55-15835"},{"ca_AvailabilityStatus":3,"ci_ClientName":"大苏打撒","ci_proHeadTel":"d啊实打实打算","ci_SalesmanName":"IsSetAliasnull","ci_Area":635464,"ca_SWIndustryTypeID":null,"ci_Type":"办公","ca_MeasureDate":"2018-04-16 00:00:00","ca_DecBudgetPrice":456456,"ca_HousingType":5,"ca_DecorationDate":"2018/07/16","ca_proAttribute":7,"ca_TransactionType":3,"ci_SalesmanCard":"01100165","ci_DecorationAddress":"大撒大撒","ci_RwdId":"55-15836","ci_proHead":"55-15836"},{"ca_AvailabilityStatus":3,"ci_ClientName":"qq","ci_proHeadTel":"qq","ci_SalesmanName":"IsSetAliasnull","ci_Area":126,"ca_SWIndustryTypeID":null,"ci_Type":"其他","ca_MeasureDate":"2018-04-16 00:00:00","ca_DecBudgetPrice":5666,"ca_HousingType":4,"ca_DecorationDate":"2020/04/16","ca_proAttribute":0,"ca_TransactionType":3,"ci_SalesmanCard":"01100165","ci_DecorationAddress":"很喜欢电话","ci_RwdId":"55-15838","ci_proHead":"55-15838"},{"ca_AvailabilityStatus":3,"ci_ClientName":"456","ci_proHeadTel":"4564","ci_SalesmanName":"IsSetAliasnull","ci_Area":456,"ca_SWIndustryTypeID":null,"ci_Type":"办公","ca_MeasureDate":"1900-01-01 00:00:00","ca_DecBudgetPrice":456456,"ca_HousingType":3,"ca_DecorationDate":"2018/04/16","ca_proAttribute":2,"ca_TransactionType":0,"ci_SalesmanCard":"01100165","ci_DecorationAddress":"456456","ci_RwdId":"55-15850","ci_proHead":"55-15850"},{"ca_AvailabilityStatus":3,"ci_ClientName":"456456","ci_proHeadTel":"456456","ci_SalesmanName":"IsSetAliasnull","ci_Area":456,"ca_SWIndustryTypeID":null,"ci_Type":"办公","ca_MeasureDate":"2018-05-16 00:00:00","ca_DecBudgetPrice":456,"ca_HousingType":3,"ca_DecorationDate":"2018/04/16","ca_proAttribute":2,"ca_TransactionType":3,"ci_SalesmanCard":"01100165","ci_DecorationAddress":"456","ci_RwdId":"55-15851","ci_proHead":"55-15851"},{"ca_AvailabilityStatus":3,"ci_ClientName":"试点房产税地方","ci_proHeadTel":"53513153","ci_SalesmanName":"IsSetAliasnull","ci_Area":5252,"ca_SWIndustryTypeID":null,"ci_Type":"餐饮","ca_MeasureDate":"2018-05-16 00:00:00","ca_DecBudgetPrice":4255,"ca_HousingType":5,"ca_DecorationDate":"2018/12/16","ca_proAttribute":8,"ca_TransactionType":3,"ci_SalesmanCard":"01100165","ci_DecorationAddress":"发生的吃饭撒地址","ci_RwdId":"55-15856","ci_proHead":"实打实大苏打似的"},{"ca_AvailabilityStatus":3,"ci_ClientName":"萨达萨达","ci_proHeadTel":"13623585765","ci_SalesmanName":"IsSetAliasnull","ci_Area":546456,"ca_SWIndustryTypeID":null,"ci_Type":"办公","ca_MeasureDate":"1900-01-01 00:00:00","ca_DecBudgetPrice":5645,"ca_HousingType":4,"ca_DecorationDate":"2018/02/16","ca_proAttribute":8,"ca_TransactionType":3,"ci_SalesmanCard":"01100165","ci_DecorationAddress":"分的高分的效果","ci_RwdId":"55-15857","ci_proHead":"上的擦拭的"},{"ca_AvailabilityStatus":3,"ci_ClientName":"大撒大撒","ci_proHeadTel":"13623585765","ci_SalesmanName":"IsSetAliasnull","ci_Area":345345,"ca_SWIndustryTypeID":null,"ci_Type":"商业","ca_MeasureDate":"2018-06-16 00:00:00","ca_DecBudgetPrice":4563453,"ca_HousingType":3,"ca_DecorationDate":"2018/08/16","ca_proAttribute":8,"ca_TransactionType":1,"ci_SalesmanCard":"01100165","ci_DecorationAddress":"国防部和奋斗","ci_RwdId":"55-15858","ci_proHead":"撒打算"},{"ca_AvailabilityStatus":3,"ci_ClientName":"撒大苏打擦拭","ci_proHeadTel":"13623585765","ci_SalesmanName":"IsSetAliasnull","ci_Area":213213,"ca_SWIndustryTypeID":null,"ci_Type":"办公","ca_MeasureDate":"2018-07-16 00:00:00","ca_DecBudgetPrice":23131,"ca_HousingType":5,"ca_DecorationDate":"2018/08/16","ca_proAttribute":8,"ca_TransactionType":3,"ci_SalesmanCard":"01100165","ci_DecorationAddress":"侠盗飞车v浮现出v","ci_RwdId":"55-15860","ci_proHead":"萨达萨达"},{"ca_AvailabilityStatus":3,"ci_ClientName":"阿萨德","ci_proHeadTel":"13623698975","ci_SalesmanName":"IsSetAliasnull","ci_Area":63523,"ca_SWIndustryTypeID":null,"ci_Type":"酒店","ca_MeasureDate":"2018-06-16 00:00:00","ca_DecBudgetPrice":213123,"ca_HousingType":5,"ca_DecorationDate":"2018/03/16","ca_proAttribute":7,"ca_TransactionType":3,"ci_SalesmanCard":"01100165","ci_DecorationAddress":"客户尽快","ci_RwdId":"55-15861","ci_proHead":"阿萨德"},{"ca_AvailabilityStatus":3,"ci_ClientName":"萨达萨达","ci_proHeadTel":"13623698975","ci_SalesmanName":"IsSetAliasnull","ci_Area":213213,"ca_SWIndustryTypeID":null,"ci_Type":"办公","ca_MeasureDate":"2018-06-17 00:00:00","ca_DecBudgetPrice":53413,"ca_HousingType":3,"ca_DecorationDate":"2018/12/17","ca_proAttribute":2,"ca_TransactionType":3,"ci_SalesmanCard":"01100165","ci_DecorationAddress":"梵蒂吗v的大城市的","ci_RwdId":"55-15862","ci_proHead":"萨达萨达"},{"ca_AvailabilityStatus":3,"ci_ClientName":"萨达萨达","ci_proHeadTel":"13623698975","ci_SalesmanName":"IsSetAliasnull","ci_Area":4536456,"ca_SWIndustryTypeID":null,"ci_Type":"酒店","ca_MeasureDate":"2016-04-17 00:00:00","ca_DecBudgetPrice":546456,"ca_HousingType":5,"ca_DecorationDate":"2018/03/17","ca_proAttribute":8,"ca_TransactionType":3,"ci_SalesmanCard":"01100165","ci_DecorationAddress":"的采访时对此VS的v","ci_RwdId":"55-15863","ci_proHead":"s啊大苏打实打实"},{"ca_AvailabilityStatus":3,"ci_ClientName":"v地方VS地方","ci_proHeadTel":"13623698975","ci_SalesmanName":"IsSetAliasnull","ci_Area":5436456,"ca_SWIndustryTypeID":null,"ci_Type":"酒店","ca_MeasureDate":"2018-09-17 00:00:00","ca_DecBudgetPrice":654654,"ca_HousingType":3,"ca_DecorationDate":"2018/02/17","ca_proAttribute":8,"ca_TransactionType":3,"ci_SalesmanCard":"01100165","ci_DecorationAddress":"几个月后你非常","ci_RwdId":"55-15864","ci_proHead":"e发热我"}]
     */

    private String StatusMsg;
    private String StatusCode;
    private List<BodyBean> Body;

    public String getStatusMsg() {
        return StatusMsg;
    }

    public void setStatusMsg(String StatusMsg) {
        this.StatusMsg = StatusMsg;
    }

    public String getStatusCode() {
        return StatusCode;
    }

    public void setStatusCode(String StatusCode) {
        this.StatusCode = StatusCode;
    }

    public List<BodyBean> getBody() {
        return Body;
    }

    public void setBody(List<BodyBean> Body) {
        this.Body = Body;
    }

    public static class BodyBean {
        /**
         * ca_AvailabilityStatus : 3
         * ci_ClientName : 12132
         * ci_proHeadTel : 21263
         * ci_SalesmanName : IsSetAliasnull
         * ci_Area : 2615.0
         * ca_SWIndustryTypeID : null
         * ci_Type : 其他
         * ca_MeasureDate : 2023-06-16 00:00:00
         * ca_DecBudgetPrice : 465.0
         * ca_HousingType : 5
         * ca_DecorationDate : 2018/08/16
         * ca_proAttribute : 6
         * ca_TransactionType : 3
         * ci_SalesmanCard : 01100165
         * ci_DecorationAddress : 阿三大苏打
         * ci_RwdId : 55-15835
         * ci_proHead : 55-15835
         */

        private int ca_AvailabilityStatus;
        private String ci_ClientName;
        private String ci_proHeadTel;
        private String ci_SalesmanName;
        private double ci_Area;
        private Object ca_SWIndustryTypeID;
        private String ci_Type;
        private String ca_MeasureDate;
        private double ca_DecBudgetPrice;
        private int ca_HousingType;
        private String ca_DecorationDate;
        private int ca_proAttribute;
        private int ca_TransactionType;
        private String ci_SalesmanCard;
        private String ci_DecorationAddress;
        private String ci_RwdId;
        private String ci_proHead;

        public int getCa_AvailabilityStatus() {
            return ca_AvailabilityStatus;
        }

        public void setCa_AvailabilityStatus(int ca_AvailabilityStatus) {
            this.ca_AvailabilityStatus = ca_AvailabilityStatus;
        }

        public String getCi_ClientName() {
            return ci_ClientName;
        }

        public void setCi_ClientName(String ci_ClientName) {
            this.ci_ClientName = ci_ClientName;
        }

        public String getCi_proHeadTel() {
            return ci_proHeadTel;
        }

        public void setCi_proHeadTel(String ci_proHeadTel) {
            this.ci_proHeadTel = ci_proHeadTel;
        }

        public String getCi_SalesmanName() {
            return ci_SalesmanName;
        }

        public void setCi_SalesmanName(String ci_SalesmanName) {
            this.ci_SalesmanName = ci_SalesmanName;
        }

        public double getCi_Area() {
            return ci_Area;
        }

        public void setCi_Area(double ci_Area) {
            this.ci_Area = ci_Area;
        }

        public Object getCa_SWIndustryTypeID() {
            return ca_SWIndustryTypeID;
        }

        public void setCa_SWIndustryTypeID(Object ca_SWIndustryTypeID) {
            this.ca_SWIndustryTypeID = ca_SWIndustryTypeID;
        }

        public String getCi_Type() {
            return ci_Type;
        }

        public void setCi_Type(String ci_Type) {
            this.ci_Type = ci_Type;
        }

        public String getCa_MeasureDate() {
            return ca_MeasureDate;
        }

        public void setCa_MeasureDate(String ca_MeasureDate) {
            this.ca_MeasureDate = ca_MeasureDate;
        }

        public double getCa_DecBudgetPrice() {
            return ca_DecBudgetPrice;
        }

        public void setCa_DecBudgetPrice(double ca_DecBudgetPrice) {
            this.ca_DecBudgetPrice = ca_DecBudgetPrice;
        }

        public int getCa_HousingType() {
            return ca_HousingType;
        }

        public void setCa_HousingType(int ca_HousingType) {
            this.ca_HousingType = ca_HousingType;
        }

        public String getCa_DecorationDate() {
            return ca_DecorationDate;
        }

        public void setCa_DecorationDate(String ca_DecorationDate) {
            this.ca_DecorationDate = ca_DecorationDate;
        }

        public int getCa_proAttribute() {
            return ca_proAttribute;
        }

        public void setCa_proAttribute(int ca_proAttribute) {
            this.ca_proAttribute = ca_proAttribute;
        }

        public int getCa_TransactionType() {
            return ca_TransactionType;
        }

        public void setCa_TransactionType(int ca_TransactionType) {
            this.ca_TransactionType = ca_TransactionType;
        }

        public String getCi_SalesmanCard() {
            return ci_SalesmanCard;
        }

        public void setCi_SalesmanCard(String ci_SalesmanCard) {
            this.ci_SalesmanCard = ci_SalesmanCard;
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

        public String getCi_proHead() {
            return ci_proHead;
        }

        public void setCi_proHead(String ci_proHead) {
            this.ci_proHead = ci_proHead;
        }
    }
}
