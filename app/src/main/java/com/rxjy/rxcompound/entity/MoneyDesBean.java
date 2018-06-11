package com.rxjy.rxcompound.entity;

/**
 * Created by hjh on 2018/3/5.
 */

public class MoneyDesBean {
    private int StatusCode;
    private String StatusMsg;
    private BodyBean Body;

    public MoneyDesBean() {
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
//        "achievementsWages":0,
//                "averageIncome":7508.8025,
//                "designerAchievements":5000,
//                "processIncome":0,
//                "takeItHigh":0,
//                "comprehensiveIncome":0,
//                "resultMoney":0,
//                "cashMoney":0,
//                "wagesMoney":0,
//                "bonus":0,
//                "wagesTotal":0,
//                "designCommission":0,
//                "shiGongCommission":0,
//                "commissionTotal":0,
//                "socialSecurity":-325.61,
//                "housingFund":-124,
//                "hstotal":-449.61

        private String achievementsWages;
        private String averageIncome;
        private String designerAchievements;
        private String processIncome;
        private String takeItHigh;
        private String comprehensiveIncome;
        private String resultMoney;
        private String cashMoney;
        private String wagesMoney;
        private String bonus;
        private String wagesTotal;
        private String designCommission;
        private String shiGongCommission;
        private String commissionTotal;
        private String socialSecurity;
        private String housingFund;
        private String hstotal;

        public BodyBean() {
            super();
        }

        @Override
        public String toString() {
            return "BodyBean{" +
                    "achievementsWages='" + achievementsWages + '\'' +
                    ", averageIncome='" + averageIncome + '\'' +
                    ", designerAchievements='" + designerAchievements + '\'' +
                    ", processIncome='" + processIncome + '\'' +
                    ", takeItHigh='" + takeItHigh + '\'' +
                    ", comprehensiveIncome='" + comprehensiveIncome + '\'' +
                    ", resultMoney='" + resultMoney + '\'' +
                    ", cashMoney='" + cashMoney + '\'' +
                    ", wagesMoney='" + wagesMoney + '\'' +
                    ", bonus='" + bonus + '\'' +
                    ", wagesTotal='" + wagesTotal + '\'' +
                    ", designCommission='" + designCommission + '\'' +
                    ", shiGongCommission='" + shiGongCommission + '\'' +
                    ", commissionTotal='" + commissionTotal + '\'' +
                    ", socialSecurity='" + socialSecurity + '\'' +
                    ", housingFund='" + housingFund + '\'' +
                    ", hstotal='" + hstotal + '\'' +
                    '}';
        }

        public String getAchievementsWages() {
            return achievementsWages;
        }

        public void setAchievementsWages(String achievementsWages) {
            this.achievementsWages = achievementsWages;
        }

        public String getAverageIncome() {
            return averageIncome;
        }

        public void setAverageIncome(String averageIncome) {
            this.averageIncome = averageIncome;
        }

        public String getDesignerAchievements() {
            return designerAchievements;
        }

        public void setDesignerAchievements(String designerAchievements) {
            this.designerAchievements = designerAchievements;
        }

        public String getProcessIncome() {
            return processIncome;
        }

        public void setProcessIncome(String processIncome) {
            this.processIncome = processIncome;
        }

        public String getTakeItHigh() {
            return takeItHigh;
        }

        public void setTakeItHigh(String takeItHigh) {
            this.takeItHigh = takeItHigh;
        }

        public String getComprehensiveIncome() {
            return comprehensiveIncome;
        }

        public void setComprehensiveIncome(String comprehensiveIncome) {
            this.comprehensiveIncome = comprehensiveIncome;
        }

        public String getResultMoney() {
            return resultMoney;
        }

        public void setResultMoney(String resultMoney) {
            this.resultMoney = resultMoney;
        }

        public String getCashMoney() {
            return cashMoney;
        }

        public void setCashMoney(String cashMoney) {
            this.cashMoney = cashMoney;
        }

        public String getWagesMoney() {
            return wagesMoney;
        }

        public void setWagesMoney(String wagesMoney) {
            this.wagesMoney = wagesMoney;
        }

        public String getBonus() {
            return bonus;
        }

        public void setBonus(String bonus) {
            this.bonus = bonus;
        }

        public String getWagesTotal() {
            return wagesTotal;
        }

        public void setWagesTotal(String wagesTotal) {
            this.wagesTotal = wagesTotal;
        }

        public String getDesignCommission() {
            return designCommission;
        }

        public void setDesignCommission(String designCommission) {
            this.designCommission = designCommission;
        }

        public String getShiGongCommission() {
            return shiGongCommission;
        }

        public void setShiGongCommission(String shiGongCommission) {
            this.shiGongCommission = shiGongCommission;
        }

        public String getCommissionTotal() {
            return commissionTotal;
        }

        public void setCommissionTotal(String commissionTotal) {
            this.commissionTotal = commissionTotal;
        }

        public String getSocialSecurity() {
            return socialSecurity;
        }

        public void setSocialSecurity(String socialSecurity) {
            this.socialSecurity = socialSecurity;
        }

        public String getHousingFund() {
            return housingFund;
        }

        public void setHousingFund(String housingFund) {
            this.housingFund = housingFund;
        }

        public String getHstotal() {
            return hstotal;
        }

        public void setHstotal(String hstotal) {
            this.hstotal = hstotal;
        }
    }

}
