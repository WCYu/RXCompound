package com.rxjy.rxcompound.activity.guwen;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 解亚鑫 on 2018/6/20.
 */

public class ZhangBenInfo implements Serializable{


    /**
     * StatusCode : 0
     * StatusMsg : 请求成功
     * Body : {"table":[{"sumMoney":0,"ShouZhiType":1,"Type":"1,2,3,4,20","LaiYuan":"个人"},{"sumMoney":225,"ShouZhiType":1,"Type":"11,12,13","LaiYuan":"会员"},{"sumMoney":0,"ShouZhiType":2,"Type":"30","LaiYuan":"提现记录"},{"sumMoney":0,"ShouZhiType":0,"Type":"0","LaiYuan":"预收"}],"total":{"ARMoney":"225.00","Balance":"225.00","ReceiptMoney":"0.00"},"count":4}
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

    public static class BodyBean implements Serializable{
        /**
         * table : [{"sumMoney":0,"ShouZhiType":1,"Type":"1,2,3,4,20","LaiYuan":"个人"},{"sumMoney":225,"ShouZhiType":1,"Type":"11,12,13","LaiYuan":"会员"},{"sumMoney":0,"ShouZhiType":2,"Type":"30","LaiYuan":"提现记录"},{"sumMoney":0,"ShouZhiType":0,"Type":"0","LaiYuan":"预收"}]
         * total : {"ARMoney":"225.00","Balance":"225.00","ReceiptMoney":"0.00"}
         * count : 4
         */

        private TotalBean total;
        private int count;
        private List<TableBean> table;

        public TotalBean getTotal() {
            return total;
        }

        public void setTotal(TotalBean total) {
            this.total = total;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public List<TableBean> getTable() {
            return table;
        }

        public void setTable(List<TableBean> table) {
            this.table = table;
        }

        public static class TotalBean{
            /**
             * ARMoney : 225.00
             * Balance : 225.00
             * ReceiptMoney : 0.00
             */

            private String ARMoney;
            private String Balance;
            private String ReceiptMoney;

            public String getARMoney() {
                return ARMoney;
            }

            public void setARMoney(String ARMoney) {
                this.ARMoney = ARMoney;
            }

            public String getBalance() {
                return Balance;
            }

            public void setBalance(String Balance) {
                this.Balance = Balance;
            }

            public String getReceiptMoney() {
                return ReceiptMoney;
            }

            public void setReceiptMoney(String ReceiptMoney) {
                this.ReceiptMoney = ReceiptMoney;
            }
        }

        public static class TableBean implements Serializable{
            /**
             * sumMoney : 0
             * ShouZhiType : 1
             * Type : 1,2,3,4,20
             * LaiYuan : 个人
             */

            private int sumMoney;
            private int ShouZhiType;
            private String Type;
            private String LaiYuan;

            public int getSumMoney() {
                return sumMoney;
            }

            public void setSumMoney(int sumMoney) {
                this.sumMoney = sumMoney;
            }

            public int getShouZhiType() {
                return ShouZhiType;
            }

            public void setShouZhiType(int ShouZhiType) {
                this.ShouZhiType = ShouZhiType;
            }

            public String getType() {
                return Type;
            }

            public void setType(String Type) {
                this.Type = Type;
            }

            public String getLaiYuan() {
                return LaiYuan;
            }

            public void setLaiYuan(String LaiYuan) {
                this.LaiYuan = LaiYuan;
            }
        }
    }
}
