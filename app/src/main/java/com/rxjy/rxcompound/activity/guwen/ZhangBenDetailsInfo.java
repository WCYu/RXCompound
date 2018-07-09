package com.rxjy.rxcompound.activity.guwen;

import java.util.List;

/**
 * Created by 解亚鑫 on 2018/6/21.
 */

public class ZhangBenDetailsInfo  {

    /**
     * StatusCode : 0
     * StatusMsg : 请求成功
     * Body : {"table":[{"ID":50,"Money":100,"TJShiJian":"2018-06-20","TJAllShiJian":"2018-06-20 15:21:17","DanHao":"55-17121","ShouZhiType":1,"Type":12,"LaiYuan":"会员"},{"ID":47,"Money":5,"TJShiJian":"2018-06-20","TJAllShiJian":"2018-06-20 15:09:39","DanHao":"","ShouZhiType":1,"Type":11,"LaiYuan":"会员"},{"ID":45,"Money":100,"TJShiJian":"2018-06-20","TJAllShiJian":"2018-06-20 14:26:05","DanHao":"12-204057","ShouZhiType":1,"Type":12,"LaiYuan":"会员"},{"ID":42,"Money":5,"TJShiJian":"2018-06-20","TJAllShiJian":"2018-06-20 13:52:24","DanHao":"","ShouZhiType":1,"Type":11,"LaiYuan":"会员"},{"ID":40,"Money":5,"TJShiJian":"2018-06-20","TJAllShiJian":"2018-06-20 13:51:55","DanHao":"","ShouZhiType":1,"Type":11,"LaiYuan":"会员"},{"ID":38,"Money":5,"TJShiJian":"2018-06-20","TJAllShiJian":"2018-06-20 13:43:17","DanHao":"","ShouZhiType":1,"Type":11,"LaiYuan":"会员"},{"ID":36,"Money":5,"TJShiJian":"2018-06-20","TJAllShiJian":"2018-06-20 13:17:49","DanHao":"","ShouZhiType":1,"Type":11,"LaiYuan":"会员"}],"total":{"ARMoney":"225.00","Balance":"225.00","ReceiptMoney":"0.00"},"count":7}
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
         * table : [{"ID":50,"Money":100,"TJShiJian":"2018-06-20","TJAllShiJian":"2018-06-20 15:21:17","DanHao":"55-17121","ShouZhiType":1,"Type":12,"LaiYuan":"会员"},{"ID":47,"Money":5,"TJShiJian":"2018-06-20","TJAllShiJian":"2018-06-20 15:09:39","DanHao":"","ShouZhiType":1,"Type":11,"LaiYuan":"会员"},{"ID":45,"Money":100,"TJShiJian":"2018-06-20","TJAllShiJian":"2018-06-20 14:26:05","DanHao":"12-204057","ShouZhiType":1,"Type":12,"LaiYuan":"会员"},{"ID":42,"Money":5,"TJShiJian":"2018-06-20","TJAllShiJian":"2018-06-20 13:52:24","DanHao":"","ShouZhiType":1,"Type":11,"LaiYuan":"会员"},{"ID":40,"Money":5,"TJShiJian":"2018-06-20","TJAllShiJian":"2018-06-20 13:51:55","DanHao":"","ShouZhiType":1,"Type":11,"LaiYuan":"会员"},{"ID":38,"Money":5,"TJShiJian":"2018-06-20","TJAllShiJian":"2018-06-20 13:43:17","DanHao":"","ShouZhiType":1,"Type":11,"LaiYuan":"会员"},{"ID":36,"Money":5,"TJShiJian":"2018-06-20","TJAllShiJian":"2018-06-20 13:17:49","DanHao":"","ShouZhiType":1,"Type":11,"LaiYuan":"会员"}]
         * total : {"ARMoney":"225.00","Balance":"225.00","ReceiptMoney":"0.00"}
         * count : 7
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

        public static class TotalBean {
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

        public static class TableBean {
            /**
             * ID : 50
             * Money : 100
             * TJShiJian : 2018-06-20
             * TJAllShiJian : 2018-06-20 15:21:17
             * DanHao : 55-17121
             * ShouZhiType : 1
             * Type : 12
             * LaiYuan : 会员
             */

            private int ID;
            private int Money;
            private String TJShiJian;
            private String TJAllShiJian;
            private String DanHao;
            private int ShouZhiType;
            private int Type;
            private String LaiYuan;

            public int getID() {
                return ID;
            }

            public void setID(int ID) {
                this.ID = ID;
            }

            public int getMoney() {
                return Money;
            }

            public void setMoney(int Money) {
                this.Money = Money;
            }

            public String getTJShiJian() {
                return TJShiJian;
            }

            public void setTJShiJian(String TJShiJian) {
                this.TJShiJian = TJShiJian;
            }

            public String getTJAllShiJian() {
                return TJAllShiJian;
            }

            public void setTJAllShiJian(String TJAllShiJian) {
                this.TJAllShiJian = TJAllShiJian;
            }

            public String getDanHao() {
                return DanHao;
            }

            public void setDanHao(String DanHao) {
                this.DanHao = DanHao;
            }

            public int getShouZhiType() {
                return ShouZhiType;
            }

            public void setShouZhiType(int ShouZhiType) {
                this.ShouZhiType = ShouZhiType;
            }

            public int getType() {
                return Type;
            }

            public void setType(int Type) {
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
