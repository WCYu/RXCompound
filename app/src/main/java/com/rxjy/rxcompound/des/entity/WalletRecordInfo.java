package com.rxjy.rxcompound.des.entity;

import java.util.List;

/**
 * Created by AAA on 2017/7/18.
 */

public class WalletRecordInfo {

    private int StatusCode;
    private String StatusMsg;
    private List<WalletRecord> Body;

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

    public List<WalletRecord> getBody() {
        return Body;
    }

    public void setBody(List<WalletRecord> Body) {
        this.Body = Body;
    }

    public static class WalletRecord {

        private String TianJaiShiJian;
        private String ZhaiYao1;
        private String LeiXing;
        private String IncomeExpenditure;

        public String getIncomeExpenditure() {
            return IncomeExpenditure;
        }

        public void setIncomeExpenditure(String incomeExpenditure) {
            IncomeExpenditure = incomeExpenditure;
        }

        public String getTianJaiShiJian() {
            return TianJaiShiJian;
        }

        public void setTianJaiShiJian(String TianJaiShiJian) {
            this.TianJaiShiJian = TianJaiShiJian;
        }

        public String getZhaiYao1() {
            return ZhaiYao1;
        }

        public void setZhaiYao1(String ZhaiYao1) {
            this.ZhaiYao1 = ZhaiYao1;
        }

        public String getLeiXing() {
            return LeiXing;
        }

        public void setLeiXing(String LeiXing) {
            this.LeiXing = LeiXing;
        }
    }
}
