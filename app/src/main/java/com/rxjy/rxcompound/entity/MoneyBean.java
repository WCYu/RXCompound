package com.rxjy.rxcompound.entity;

/**
 * Created by hjh on 2018/3/2.
 */

public class MoneyBean {

    private int StatusCode;
    private String StatusMsg;
    private BodyBean Body;

    public MoneyBean() {
        super();
    }

    @Override
    public String toString() {
        return "MoneyBean{" +
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
        private String IncomeTotal;//实发、工资合计
        private String SalaryMonth;//底薪
        private String AchievementsMoney;//绩效
        private String RewardTotal;//奖罚RewardTotal
        private String yyMoney;//应用
        private String kfMoney;//开发
        private String glMoney;//管理
        private String Reward;//奖金
        private String Fine;//罚
        private String Cash;//现金
        private String pSocialSecurity;//社保
        private String pAccumulationFund;//公积金
        private int sjLeave;//事假
        private int bjLeave;//病假
        private String SocialFund;//社保公积金
        private String LeaveMoney;//出勤合计
        private String finalpaying;

        public BodyBean() {
            super();
        }

        public String getFinalpaying() {
            return finalpaying;
        }

        public void setFinalpaying(String finalpaying) {
            finalpaying = finalpaying;
        }

        @Override
        public String toString() {
            return "BodyBean{" +
                    "IncomeTotal=" + IncomeTotal +
                    ", SalaryMonth=" + SalaryMonth +
                    ", AchievementsMoney=" + AchievementsMoney +
                    ", RewardTotal=" + RewardTotal +
                    ", yyMoney=" + yyMoney +
                    ", kfMoney=" + kfMoney +
                    ", glMoney=" + glMoney +
                    ", Reward=" + Reward +
                    ", Fine=" + Fine +
                    ", Cash=" + Cash +
                    ", pSocialSecurity=" + pSocialSecurity +
                    ", pAccumulationFund=" + pAccumulationFund +
                    ", sjLeave=" + sjLeave +
                    ", bjLeave=" + bjLeave +
                    ", SocialFund=" + SocialFund +
                    ", LeaveMoney=" + LeaveMoney +
                    '}';
        }


        public String getIncomeTotal() {
            return IncomeTotal;
        }

        public void setIncomeTotal(String incomeTotal) {
            IncomeTotal = incomeTotal;
        }

        public String getSalaryMonth() {
            return SalaryMonth;
        }

        public void setSalaryMonth(String salaryMonth) {
            SalaryMonth = salaryMonth;
        }

        public String getAchievementsMoney() {
            return AchievementsMoney;
        }

        public void setAchievementsMoney(String achievementsMoney) {
            AchievementsMoney = achievementsMoney;
        }

        public String getRewardTotal() {
            return RewardTotal;
        }

        public void setRewardTotal(String rewardTotal) {
            RewardTotal = rewardTotal;
        }

        public String getYyMoney() {
            return yyMoney;
        }

        public void setYyMoney(String yyMoney) {
            this.yyMoney = yyMoney;
        }

        public String getKfMoney() {
            return kfMoney;
        }

        public void setKfMoney(String kfMoney) {
            this.kfMoney = kfMoney;
        }

        public String getGlMoney() {
            return glMoney;
        }

        public void setGlMoney(String glMoney) {
            this.glMoney = glMoney;
        }

        public String getReward() {
            return Reward;
        }

        public void setReward(String reward) {
            Reward = reward;
        }

        public String getFine() {
            return Fine;
        }

        public void setFine(String fine) {
            Fine = fine;
        }

        public String getCash() {
            return Cash;
        }

        public void setCash(String cash) {
            Cash = cash;
        }

        public String getpSocialSecurity() {
            return pSocialSecurity;
        }

        public void setpSocialSecurity(String pSocialSecurity) {
            this.pSocialSecurity = pSocialSecurity;
        }

        public String getpAccumulationFund() {
            return pAccumulationFund;
        }

        public void setpAccumulationFund(String pAccumulationFund) {
            this.pAccumulationFund = pAccumulationFund;
        }

        public int getSjLeave() {
            return sjLeave;
        }

        public void setSjLeave(int sjLeave) {
            this.sjLeave = sjLeave;
        }

        public int getBjLeave() {
            return bjLeave;
        }

        public void setBjLeave(int bjLeave) {
            this.bjLeave = bjLeave;
        }

        public String getSocialFund() {
            return SocialFund;
        }

        public void setSocialFund(String socialFund) {
            SocialFund = socialFund;
        }

        public String getLeaveMoney() {
            return LeaveMoney;
        }

        public void setLeaveMoney(String leaveMoney) {
            LeaveMoney = leaveMoney;
        }
    }

}