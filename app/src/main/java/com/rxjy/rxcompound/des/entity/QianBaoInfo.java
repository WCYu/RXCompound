package com.rxjy.rxcompound.des.entity;

import java.util.List;

/**
 * Created by Administrator on 2017/8/25.
 */

public class QianBaoInfo {
    /**
     * StatusCode : 0
     * StatusMsg : 操作成功
     * Body : {"DesignerCardNo":"02500272","OrderSummary":"150.00","ProgrammeSummary":"480.00","NegotiateSummary":"120.00","BudgetSummary":"690.00","ContractSummary":"0.000.00","ProcessSubsidySummary":null,"AchievementsWages":"1440.00","Bonus":"0.00","AllSalary":"1440.00","SalaryDetail":[{"RK":0,"RL":52,"CardNo":"02500272","Rwdid":"15-123530","Points":5,"Income":450,"CreateTime":"2017-08-25 09:08 :26","cliType":"方案","TimeNum":1503623306},{"RK":0,"RL":52,"CardNo":"02500272","Rwdid":"15-125697","Points":8,"Income":240,"CreateTime":"2017-08-25 09:08 :26","cliType":"方案","TimeNum":1503623306},{"RK":0,"RL":52,"CardNo":"02500272","Rwdid":"15-123530","Points":10,"Income":0,"CreateTime":"2017-08-25 09:06 :01","cliType":"方案","TimeNum":1503623161},{"RK":0,"RL":52,"CardNo":"02500272","Rwdid":"15-125638","Points":8,"Income":240,"CreateTime":"2017-08-25 09:06 :01","cliType":"方案","TimeNum":1503623161},{"RK":0,"RL":52,"CardNo":"02500272","Rwdid":"15-125697","Points":8,"Income":240,"CreateTime":"2017-08-25 09:06 :01","cliType":"方案","TimeNum":1503623161},{"RK":0,"RL":52,"CardNo":"02500272","Rwdid":"15-119590","Points":0,"Income":0,"CreateTime":"2017-08-25 09:05 :21","cliType":"接单","TimeNum":1503623121},{"RK":0,"RL":52,"CardNo":"02500272","Rwdid":"15-125575","Points":0,"Income":0,"CreateTime":"2017-08-25 09:05 :21","cliType":"接单","TimeNum":1503623121},{"RK":0,"RL":52,"CardNo":"02500272","Rwdid":"15-125638","Points":10,"Income":75,"CreateTime":"2017-08-25 09:05 :21","cliType":"接单","TimeNum":1503623121},{"RK":0,"RL":52,"CardNo":"02500272","Rwdid":"15-125697","Points":10,"Income":75,"CreateTime":"2017-08-25 09:05 :21","cliType":"接单","TimeNum":1503623121},{"RK":0,"RL":52,"CardNo":"02500272","Rwdid":"15-125697","Points":0,"Income":120,"CreateTime":"2017-08-17 18:07 :28","cliType":"洽谈","TimeNum":1502964448}]}
     */

    private int StatusCode;
    private String StatusMsg;
    private BodyBean Body;

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

    public BodyBean getBody() {
        return Body;
    }

    public void setBody(BodyBean Body) {
        this.Body = Body;
    }

    public static class BodyBean {
        /**
         * DesignerCardNo : 02500272
         * OrderSummary : 150.00
         * ProgrammeSummary : 480.00
         * NegotiateSummary : 120.00
         * BudgetSummary : 690.00
         * ContractSummary : 0.000.00
         * ProcessSubsidySummary : null
         * AchievementsWages : 1440.00
         * Bonus : 0.00
         * AllSalary : 1440.00
         * SalaryDetail : [{"RK":0,"RL":52,"CardNo":"02500272","Rwdid":"15-123530","Points":5,"Income":450,"CreateTime":"2017-08-25 09:08 :26","cliType":"方案","TimeNum":1503623306},{"RK":0,"RL":52,"CardNo":"02500272","Rwdid":"15-125697","Points":8,"Income":240,"CreateTime":"2017-08-25 09:08 :26","cliType":"方案","TimeNum":1503623306},{"RK":0,"RL":52,"CardNo":"02500272","Rwdid":"15-123530","Points":10,"Income":0,"CreateTime":"2017-08-25 09:06 :01","cliType":"方案","TimeNum":1503623161},{"RK":0,"RL":52,"CardNo":"02500272","Rwdid":"15-125638","Points":8,"Income":240,"CreateTime":"2017-08-25 09:06 :01","cliType":"方案","TimeNum":1503623161},{"RK":0,"RL":52,"CardNo":"02500272","Rwdid":"15-125697","Points":8,"Income":240,"CreateTime":"2017-08-25 09:06 :01","cliType":"方案","TimeNum":1503623161},{"RK":0,"RL":52,"CardNo":"02500272","Rwdid":"15-119590","Points":0,"Income":0,"CreateTime":"2017-08-25 09:05 :21","cliType":"接单","TimeNum":1503623121},{"RK":0,"RL":52,"CardNo":"02500272","Rwdid":"15-125575","Points":0,"Income":0,"CreateTime":"2017-08-25 09:05 :21","cliType":"接单","TimeNum":1503623121},{"RK":0,"RL":52,"CardNo":"02500272","Rwdid":"15-125638","Points":10,"Income":75,"CreateTime":"2017-08-25 09:05 :21","cliType":"接单","TimeNum":1503623121},{"RK":0,"RL":52,"CardNo":"02500272","Rwdid":"15-125697","Points":10,"Income":75,"CreateTime":"2017-08-25 09:05 :21","cliType":"接单","TimeNum":1503623121},{"RK":0,"RL":52,"CardNo":"02500272","Rwdid":"15-125697","Points":0,"Income":120,"CreateTime":"2017-08-17 18:07 :28","cliType":"洽谈","TimeNum":1502964448}]
         */

        private String DesignerCardNo;
        private String OrderSummary;
        private String ProgrammeSummary;
        private String NegotiateSummary;
        private String BudgetSummary;
        private String ContractSummary;
        private Object ProcessSubsidySummary;
        private String AchievementsWages;
        private String Bonus;
        private String AllSalary;
        private List<SalaryDetailBean> SalaryDetail;

        public String getDesignerCardNo() {
            return DesignerCardNo;
        }

        public void setDesignerCardNo(String DesignerCardNo) {
            this.DesignerCardNo = DesignerCardNo;
        }

        public String getOrderSummary() {
            return OrderSummary;
        }

        public void setOrderSummary(String OrderSummary) {
            this.OrderSummary = OrderSummary;
        }

        public String getProgrammeSummary() {
            return ProgrammeSummary;
        }

        public void setProgrammeSummary(String ProgrammeSummary) {
            this.ProgrammeSummary = ProgrammeSummary;
        }

        public String getNegotiateSummary() {
            return NegotiateSummary;
        }

        public void setNegotiateSummary(String NegotiateSummary) {
            this.NegotiateSummary = NegotiateSummary;
        }

        public String getBudgetSummary() {
            return BudgetSummary;
        }

        public void setBudgetSummary(String BudgetSummary) {
            this.BudgetSummary = BudgetSummary;
        }

        public String getContractSummary() {
            return ContractSummary;
        }

        public void setContractSummary(String ContractSummary) {
            this.ContractSummary = ContractSummary;
        }

        public Object getProcessSubsidySummary() {
            return ProcessSubsidySummary;
        }

        public void setProcessSubsidySummary(Object ProcessSubsidySummary) {
            this.ProcessSubsidySummary = ProcessSubsidySummary;
        }

        public String getAchievementsWages() {
            return AchievementsWages;
        }

        public void setAchievementsWages(String AchievementsWages) {
            this.AchievementsWages = AchievementsWages;
        }

        public String getBonus() {
            return Bonus;
        }

        public void setBonus(String Bonus) {
            this.Bonus = Bonus;
        }

        public String getAllSalary() {
            return AllSalary;
        }

        public void setAllSalary(String AllSalary) {
            this.AllSalary = AllSalary;
        }

        public List<SalaryDetailBean> getSalaryDetail() {
            return SalaryDetail;
        }

        public void setSalaryDetail(List<SalaryDetailBean> SalaryDetail) {
            this.SalaryDetail = SalaryDetail;
        }

        public static class SalaryDetailBean {
            /**
             * RK : 0
             * RL : 52
             * CardNo : 02500272
             * Rwdid : 15-123530
             * Points : 5
             * Income : 450.0
             * CreateTime : 2017-08-25 09:08 :26
             * cliType : 方案
             * TimeNum : 1503623306
             */

            private int RK;
            private int RL;
            private String CardNo;
            private String Rwdid;
            private int Points;
            private double Income;
            private String CreateTime;
            private String cliType;
            private long TimeNum;

            public int getRK() {
                return RK;
            }

            public void setRK(int RK) {
                this.RK = RK;
            }

            public int getRL() {
                return RL;
            }

            public void setRL(int RL) {
                this.RL = RL;
            }

            public String getCardNo() {
                return CardNo;
            }

            public void setCardNo(String CardNo) {
                this.CardNo = CardNo;
            }

            public String getRwdid() {
                return Rwdid;
            }

            public void setRwdid(String Rwdid) {
                this.Rwdid = Rwdid;
            }

            public int getPoints() {
                return Points;
            }

            public void setPoints(int Points) {
                this.Points = Points;
            }

            public double getIncome() {
                return Income;
            }

            public void setIncome(double Income) {
                this.Income = Income;
            }

            public String getCreateTime() {
                return CreateTime;
            }

            public void setCreateTime(String CreateTime) {
                this.CreateTime = CreateTime;
            }

            public String getCliType() {
                return cliType;
            }

            public void setCliType(String cliType) {
                this.cliType = cliType;
            }

            public long getTimeNum() {
                return TimeNum;
            }

            public void setTimeNum(long TimeNum) {
                this.TimeNum = TimeNum;
            }
        }
    }
}
