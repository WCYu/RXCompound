package com.rxjy.rxcompound.entity;

/**
 * Created by asus on 2018/6/4.
 */

public class HospitalBean {


    /**
     * StatusCode : 0
     * StatusMsg : 获取成功！
     * Body : {"id":0,"u_kahao":"01012250","u_xingming":"张玉珠","salary":727.27,"basicSalary":8000,"u_zhenggongzi":8000,"achievements":0,"high":0,"gc":0,"yw":0,"rw":0,"jd":0,"yy":0,"gl":0,"jg":0,"reward":0,"fine":0,"kq":0,"tc":0,"social_security":-342.04,"accumulation_fund":0,"income_tax":0,"jg_audit":0,"jf_audit":0,"tc_audit":0,"sg_audit":0,"hj_audit":0,"create_time":"0001-01-01T00:00:00","NowMonth":null,"rp_ActualMoney":null,"rp_FinishTime":null,"em_Content":null,"nem_Content":null,"nBeginTime":null,"nEendTime":null,"Type":null,"Reason":null,"totalTime":null,"YYDataPool":0,"JieGuoMoney":0,"sumkfmoney":375,"tiCheng":0,"advancemoney":0,"finalpaying":760.23,"historymoney":8786.22}
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
         * id : 0
         * u_kahao : 01012250
         * u_xingming : 张玉珠
         * salary : 727.27
         * basicSalary : 8000.0
         * u_zhenggongzi : 8000.0
         * achievements : 0.0
         * high : 0.0
         * gc : 0.0
         * yw : 0.0
         * rw : 0.0
         * jd : 0.0
         * yy : 0.0
         * gl : 0.0
         * jg : 0.0
         * reward : 0.0
         * fine : 0.0
         * kq : 0.0
         * tc : 0.0
         * social_security : -342.04
         * accumulation_fund : 0.0
         * income_tax : 0.0
         * jg_audit : 0
         * jf_audit : 0
         * tc_audit : 0
         * sg_audit : 0
         * hj_audit : 0
         * create_time : 0001-01-01T00:00:00
         * NowMonth : null
         * rp_ActualMoney : null
         * rp_FinishTime : null
         * em_Content : null
         * nem_Content : null
         * nBeginTime : null
         * nEendTime : null
         * Type : null
         * Reason : null
         * totalTime : null
         * YYDataPool : 0.0
         * JieGuoMoney : 0.0
         * sumkfmoney : 375.0
         * tiCheng : 0.0
         * advancemoney : 0.0
         * finalpaying : 760.23
         * historymoney : 8786.22
         */

        private int id;
        private String u_kahao;
        private String u_xingming;
        private double salary;
        private double basicSalary;
        private double u_zhenggongzi;
        private double achievements;
        private double high;
        private double gc;
        private double yw;
        private double rw;
        private double jd;
        private double yy;
        private double gl;
        private double jg;
        private double reward;
        private double fine;
        private double kq;
        private double tc;
        private double social_security;
        private double accumulation_fund;
        private double income_tax;
        private int jg_audit;
        private int jf_audit;
        private int tc_audit;
        private int sg_audit;
        private int hj_audit;
        private String create_time;
        private double  NowMonth;
        private double  rp_ActualMoney;
        private String rp_FinishTime;
        private String em_Content;
        private String nem_Content;
        private String nBeginTime;
        private String nEendTime;
        private int Type;
        private double Reason;
        private String totalTime;
        private double YYDataPool;
        private double JieGuoMoney;
        private double sumkfmoney;
        private double tiCheng;
        private double advancemoney;
        private double finalpaying;
        private double historymoney;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getU_kahao() {
            return u_kahao;
        }

        public void setU_kahao(String u_kahao) {
            this.u_kahao = u_kahao;
        }

        public String getU_xingming() {
            return u_xingming;
        }

        public void setU_xingming(String u_xingming) {
            this.u_xingming = u_xingming;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        public double getBasicSalary() {
            return basicSalary;
        }

        public void setBasicSalary(double basicSalary) {
            this.basicSalary = basicSalary;
        }

        public double getU_zhenggongzi() {
            return u_zhenggongzi;
        }

        public void setU_zhenggongzi(double u_zhenggongzi) {
            this.u_zhenggongzi = u_zhenggongzi;
        }

        public double getAchievements() {
            return achievements;
        }

        public void setAchievements(double achievements) {
            this.achievements = achievements;
        }

        public double getHigh() {
            return high;
        }

        public void setHigh(double high) {
            this.high = high;
        }

        public double getGc() {
            return gc;
        }

        public void setGc(double gc) {
            this.gc = gc;
        }

        public double getYw() {
            return yw;
        }

        public void setYw(double yw) {
            this.yw = yw;
        }

        public double getRw() {
            return rw;
        }

        public void setRw(double rw) {
            this.rw = rw;
        }

        public double getJd() {
            return jd;
        }

        public void setJd(double jd) {
            this.jd = jd;
        }

        public double getYy() {
            return yy;
        }

        public void setYy(double yy) {
            this.yy = yy;
        }

        public double getGl() {
            return gl;
        }

        public void setGl(double gl) {
            this.gl = gl;
        }

        public double getJg() {
            return jg;
        }

        public void setJg(double jg) {
            this.jg = jg;
        }

        public double getReward() {
            return reward;
        }

        public void setReward(double reward) {
            this.reward = reward;
        }

        public double getFine() {
            return fine;
        }

        public void setFine(double fine) {
            this.fine = fine;
        }

        public double getKq() {
            return kq;
        }

        public void setKq(double kq) {
            this.kq = kq;
        }

        public double getTc() {
            return tc;
        }

        public void setTc(double tc) {
            this.tc = tc;
        }

        public double getSocial_security() {
            return social_security;
        }

        public void setSocial_security(double social_security) {
            this.social_security = social_security;
        }

        public double getAccumulation_fund() {
            return accumulation_fund;
        }

        public void setAccumulation_fund(double accumulation_fund) {
            this.accumulation_fund = accumulation_fund;
        }

        public double getIncome_tax() {
            return income_tax;
        }

        public void setIncome_tax(double income_tax) {
            this.income_tax = income_tax;
        }

        public int getJg_audit() {
            return jg_audit;
        }

        public void setJg_audit(int jg_audit) {
            this.jg_audit = jg_audit;
        }

        public int getJf_audit() {
            return jf_audit;
        }

        public void setJf_audit(int jf_audit) {
            this.jf_audit = jf_audit;
        }

        public int getTc_audit() {
            return tc_audit;
        }

        public void setTc_audit(int tc_audit) {
            this.tc_audit = tc_audit;
        }

        public int getSg_audit() {
            return sg_audit;
        }

        public void setSg_audit(int sg_audit) {
            this.sg_audit = sg_audit;
        }

        public int getHj_audit() {
            return hj_audit;
        }

        public void setHj_audit(int hj_audit) {
            this.hj_audit = hj_audit;
        }

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }

        public double getNowMonth() {
            return NowMonth;
        }

        public void setNowMonth(double NowMonth) {
            this.NowMonth = NowMonth;
        }

        public double getRp_ActualMoney() {
            return rp_ActualMoney;
        }

        public void setRp_ActualMoney(double rp_ActualMoney) {
            this.rp_ActualMoney = rp_ActualMoney;
        }

        public String getRp_FinishTime() {
            return rp_FinishTime;
        }

        public void setRp_FinishTime(String rp_FinishTime) {
            this.rp_FinishTime = rp_FinishTime;
        }

        public String getEm_Content() {
            return em_Content;
        }

        public void setEm_Content(String em_Content) {
            this.em_Content = em_Content;
        }

        public String getNem_Content() {
            return nem_Content;
        }

        public void setNem_Content(String nem_Content) {
            this.nem_Content = nem_Content;
        }

        public String getNBeginTime() {
            return nBeginTime;
        }

        public void setNBeginTime(String nBeginTime) {
            this.nBeginTime = nBeginTime;
        }

        public String getNEendTime() {
            return nEendTime;
        }

        public void setNEendTime(String nEendTime) {
            this.nEendTime = nEendTime;
        }

        public int getType() {
            return Type;
        }

        public void setType(int Type) {
            this.Type = Type;
        }

        public double getReason() {
            return Reason;
        }

        public void setReason(double Reason) {
            this.Reason = Reason;
        }

        public String getTotalTime() {
            return totalTime;
        }

        public void setTotalTime(String totalTime) {
            this.totalTime = totalTime;
        }

        public double getYYDataPool() {
            return YYDataPool;
        }

        public void setYYDataPool(double YYDataPool) {
            this.YYDataPool = YYDataPool;
        }

        public double getJieGuoMoney() {
            return JieGuoMoney;
        }

        public void setJieGuoMoney(double JieGuoMoney) {
            this.JieGuoMoney = JieGuoMoney;
        }

        public double getSumkfmoney() {
            return sumkfmoney;
        }

        public void setSumkfmoney(double sumkfmoney) {
            this.sumkfmoney = sumkfmoney;
        }

        public double getTiCheng() {
            return tiCheng;
        }

        public void setTiCheng(double tiCheng) {
            this.tiCheng = tiCheng;
        }

        public double getAdvancemoney() {
            return advancemoney;
        }

        public void setAdvancemoney(double advancemoney) {
            this.advancemoney = advancemoney;
        }

        public double getFinalpaying() {
            return finalpaying;
        }

        public void setFinalpaying(double finalpaying) {
            this.finalpaying = finalpaying;
        }

        public double getHistorymoney() {
            return historymoney;
        }

        public void setHistorymoney(double historymoney) {
            this.historymoney = historymoney;
        }
    }
}
