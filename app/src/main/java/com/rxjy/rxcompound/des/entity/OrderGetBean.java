package com.rxjy.rxcompound.des.entity;


/**
 * Created by hjh on 2018/4/16.
 */

public class OrderGetBean {

    private int StatusCode;
    private String StatusMsg;
    private BodyBean Body;

    public OrderGetBean() {
        super();
    }

    @Override
    public String toString() {
        return "MoneyDesBean{" +
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

        private BaseInfo baseInformation;
        private DecorateInfo decorateInformation;
        private HousingResourcesInfo housingResourcesInformation;

        public BodyBean() {
            super();
        }

        @Override
        public String toString() {
            return "BodyBean{" +
                    "baseInformation=" + baseInformation +
                    ", decorateInformation=" + decorateInformation +
                    ", housingResourcesInformation=" + housingResourcesInformation +
                    '}';
        }

        public BaseInfo getBaseInformation() {
            return baseInformation;
        }

        public void setBaseInformation(BaseInfo baseInformation) {
            this.baseInformation = baseInformation;
        }

        public DecorateInfo getDecorateInformation() {
            return decorateInformation;
        }

        public void setDecorateInformation(DecorateInfo decorateInformation) {
            this.decorateInformation = decorateInformation;
        }

        public HousingResourcesInfo getHousingResourcesInformation() {
            return housingResourcesInformation;
        }

        public void setHousingResourcesInformation(HousingResourcesInfo housingResourcesInformation) {
            this.housingResourcesInformation = housingResourcesInformation;
        }

        public class BaseInfo{
            private String ci_ClientName;
            private String ci_Type;
            private String secondType;
            private String thirdType;

            public BaseInfo() {
                super();
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

            public String getSecondType() {
                return secondType;
            }

            public void setSecondType(String secondType) {
                this.secondType = secondType;
            }

            public String getThirdType() {
                return thirdType;
            }

            public void setThirdType(String thirdType) {
                this.thirdType = thirdType;
            }

            @Override
            public String toString() {
                return "BaseInfo{" +
                        "ci_ClientName='" + ci_ClientName + '\'' +
                        ", ci_Type='" + ci_Type + '\'' +
                        ", secondType='" + secondType + '\'' +
                        ", thirdType='" + thirdType + '\'' +
                        '}';
            }
        }

        public class DecorateInfo{
            private String ca_proAttribute;
            private String ca_DecorationDate;
            private String ca_DecBudgetPrice;

            public DecorateInfo() {
                super();
            }

            @Override
            public String toString() {
                return "DecorateInfo{" +
                        "ca_proAttribute='" + ca_proAttribute + '\'' +
                        ", ca_DecorationDate='" + ca_DecorationDate + '\'' +
                        ", ca_DecBudgetPrice='" + ca_DecBudgetPrice + '\'' +
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
        }

        public class HousingResourcesInfo{
            private String ca_MeasureDate;
            private String ci_Area;

            public HousingResourcesInfo() {
                super();
            }

            @Override
            public String toString() {
                return "HousingResourcesInfo{" +
                        "ca_MeasureDate='" + ca_MeasureDate + '\'' +
                        ", ci_Area='" + ci_Area + '\'' +
                        '}';
            }

            public String getCa_MeasureDate() {
                return ca_MeasureDate;
            }

            public void setCa_MeasureDate(String ca_MeasureDate) {
                this.ca_MeasureDate = ca_MeasureDate;
            }

            public String getCi_Area() {
                return ci_Area;
            }

            public void setCi_Area(String ci_Area) {
                this.ci_Area = ci_Area;
            }
        }

    }
}
