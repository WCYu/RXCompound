package com.rxjy.rxcompound.des.entity;

/**
 * Created by Administrator on 2017/6/30.
 */
public class WalletInfo
{

    private int StatusCode;
    private String StatusMsg;

    private Wallet Body;

    public int getStatusCode()
    {
        return StatusCode;
    }

    public void setStatusCode(int StatusCode)
    {
        this.StatusCode = StatusCode;
    }

    public String getStatusMsg()
    {
        return StatusMsg;
    }

    public void setStatusMsg(String StatusMsg)
    {
        this.StatusMsg = StatusMsg;
    }

    public Wallet getBody()
    {
        return Body;
    }

    public void setBody(Wallet Body)
    {
        this.Body = Body;
    }

    public static class Wallet
    {
        private double Balance;
        private double ARMoney;
        private double ReceiptMoney;
        private int ARCount;
        private double Total;
        private double MonthIncome;

        public double getMonthIncome() {
            return MonthIncome;
        }

        public void setMonthIncome(double monthIncome) {
            MonthIncome = monthIncome;
        }

        public double getBalance()
        {
            return Balance;
        }

        public void setBalance(double Balance)
        {
            this.Balance = Balance;
        }

        public double getARMoney()
        {
            return ARMoney;
        }

        public void setARMoney(double ARMoney)
        {
            this.ARMoney = ARMoney;
        }

        public double getReceiptMoney()
        {
            return ReceiptMoney;
        }

        public void setReceiptMoney(double ReceiptMoney)
        {
            this.ReceiptMoney = ReceiptMoney;
        }

        public int getARCount()
        {
            return ARCount;
        }

        public void setARCount(int ARCount)
        {
            this.ARCount = ARCount;
        }

        public double getTotal()
        {
            return Total;
        }

        public void setTotal(double Total)
        {
            this.Total = Total;
        }
    }
}
