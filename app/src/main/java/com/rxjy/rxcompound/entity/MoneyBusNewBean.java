package com.rxjy.rxcompound.entity;

/**
 * Created by hjh on 2018/4/11.
 */

public class MoneyBusNewBean {
    private int StatusCode;
    private String StatusMsg;
    private BodyBean Body;

    public MoneyBusNewBean() {
        super();
    }

    @Override
    public String toString() {
        return "MoneyBusBean{" +
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
//        "preMonth":0,
//                　　　　"preThreeMonth":4351.13,
//                　　　　"subsidymoney":8000,
//                　　　　"performanceIncome":2667,
//                　　　　"quqigao":8000,
//                　　　　"totalIncome":7476.9,
//                　　　　"processIncome":2667,
//                　　　　"resultIncome":0,
//                　　　　"jiangJin":0,
//                　　　　"faKuan":0,
//                　　　　"jFHeJi":0,
//                　　　　"sJTiCheng":0,
//                　　　　"sGTiCheng":0,
//                　　　　"tiCheng":0,
//                　　　　"sheBao":-322.1,
//                　　　　"gongJiJin":-201,
//                　　　　"sheBaoGJHeJi":-523.1,
//                　　　　"yingFaXinChou":4420.2,
//                　　　　"weiFaXinChou":3619.2

        private String preMonth;
        private String preThreeMonth;
        private String subsidymoney;
        private String performanceIncome;
        private String quqigao;
        private String totalIncome;
        private String processIncome;
        private String resultIncome;
        private String jiangJin;
        private String faKuan;
        private String jFHeJi;
        private String sJTiCheng;
        private String sGTiCheng;
        private String tiCheng;
        private String sheBao;
        private String gongJiJin;
        private String sheBaoGJHeJi;
        private String yingFaXinChou;
        private String weiFaXinChou;
        private String dHuiIncome;
        private String dCusIncome;
        private String dTotalIncome;

        public BodyBean() {
            super();
        }

        @Override
        public String toString() {
            return "BodyBean{" +
                    "preMonth='" + preMonth + '\'' +
                    ", preThreeMonth='" + preThreeMonth + '\'' +
                    ", subsidymoney='" + subsidymoney + '\'' +
                    ", performanceIncome='" + performanceIncome + '\'' +
                    ", quqigao='" + quqigao + '\'' +
                    ", totalIncome='" + totalIncome + '\'' +
                    ", processIncome='" + processIncome + '\'' +
                    ", resultIncome='" + resultIncome + '\'' +
                    ", jiangJin='" + jiangJin + '\'' +
                    ", faKuan='" + faKuan + '\'' +
                    ", jFHeJi='" + jFHeJi + '\'' +
                    ", sJTiCheng='" + sJTiCheng + '\'' +
                    ", sGTiCheng='" + sGTiCheng + '\'' +
                    ", tiCheng='" + tiCheng + '\'' +
                    ", sheBao='" + sheBao + '\'' +
                    ", gongJiJin='" + gongJiJin + '\'' +
                    ", sheBaoGJHeJi='" + sheBaoGJHeJi + '\'' +
                    ", yingFaXinChou='" + yingFaXinChou + '\'' +
                    ", weiFaXinChou='" + weiFaXinChou + '\'' +
                    '}';
        }

        public String getDHuiIncome() {
            return dHuiIncome;
        }

        public void setDHuiIncome(String dHuiIncome) {
            this.dHuiIncome = dHuiIncome;
        }

        public String getDCusIncome() {
            return dCusIncome;
        }

        public void setDCusIncome(String dCusIncome) {
            this.dCusIncome = dCusIncome;
        }

        public String getDTotalIncome() {
            return dTotalIncome;
        }

        public void setDTotalIncome(String dTotalIncome) {
            this.dTotalIncome = dTotalIncome;
        }


        public String getPreMonth() {
            return preMonth;
        }

        public void setPreMonth(String preMonth) {
            this.preMonth = preMonth;
        }

        public String getPreThreeMonth() {
            return preThreeMonth;
        }

        public void setPreThreeMonth(String preThreeMonth) {
            this.preThreeMonth = preThreeMonth;
        }

        public String getSubsidymoney() {
            return subsidymoney;
        }

        public void setSubsidymoney(String subsidymoney) {
            this.subsidymoney = subsidymoney;
        }

        public String getPerformanceIncome() {
            return performanceIncome;
        }

        public void setPerformanceIncome(String performanceIncome) {
            this.performanceIncome = performanceIncome;
        }

        public String getQuqigao() {
            return quqigao;
        }

        public void setQuqigao(String quqigao) {
            this.quqigao = quqigao;
        }

        public String getTotalIncome() {
            return totalIncome;
        }

        public void setTotalIncome(String totalIncome) {
            this.totalIncome = totalIncome;
        }

        public String getProcessIncome() {
            return processIncome;
        }

        public void setProcessIncome(String processIncome) {
            this.processIncome = processIncome;
        }

        public String getResultIncome() {
            return resultIncome;
        }

        public void setResultIncome(String resultIncome) {
            this.resultIncome = resultIncome;
        }

        public String getJiangJin() {
            return jiangJin;
        }

        public void setJiangJin(String jiangJin) {
            this.jiangJin = jiangJin;
        }

        public String getFaKuan() {
            return faKuan;
        }

        public void setFaKuan(String faKuan) {
            this.faKuan = faKuan;
        }

        public String getjFHeJi() {
            return jFHeJi;
        }

        public void setjFHeJi(String jFHeJi) {
            this.jFHeJi = jFHeJi;
        }

        public String getsJTiCheng() {
            return sJTiCheng;
        }

        public void setsJTiCheng(String sJTiCheng) {
            this.sJTiCheng = sJTiCheng;
        }

        public String getsGTiCheng() {
            return sGTiCheng;
        }

        public void setsGTiCheng(String sGTiCheng) {
            this.sGTiCheng = sGTiCheng;
        }

        public String getTiCheng() {
            return tiCheng;
        }

        public void setTiCheng(String tiCheng) {
            this.tiCheng = tiCheng;
        }

        public String getSheBao() {
            return sheBao;
        }

        public void setSheBao(String sheBao) {
            this.sheBao = sheBao;
        }

        public String getGongJiJin() {
            return gongJiJin;
        }

        public void setGongJiJin(String gongJiJin) {
            this.gongJiJin = gongJiJin;
        }

        public String getSheBaoGJHeJi() {
            return sheBaoGJHeJi;
        }

        public void setSheBaoGJHeJi(String sheBaoGJHeJi) {
            this.sheBaoGJHeJi = sheBaoGJHeJi;
        }

        public String getYingFaXinChou() {
            return yingFaXinChou;
        }

        public void setYingFaXinChou(String yingFaXinChou) {
            this.yingFaXinChou = yingFaXinChou;
        }

        public String getWeiFaXinChou() {
            return weiFaXinChou;
        }

        public void setWeiFaXinChou(String weiFaXinChou) {
            this.weiFaXinChou = weiFaXinChou;
        }
    }
}
