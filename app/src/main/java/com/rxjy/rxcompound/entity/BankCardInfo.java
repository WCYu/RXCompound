package com.rxjy.rxcompound.entity;

/**
 * Created by AAA on 2017/7/19.
 */

public class BankCardInfo {

    private String bankUserName;
    private String bankName;
    private String bankCard;

    public BankCardInfo() {
    }

    public BankCardInfo(String bankUserName, String bankName, String bankCard) {
        this.bankUserName = bankUserName;
        this.bankName = bankName;
        this.bankCard = bankCard;
    }

    public String getBankUserName() {
        return bankUserName;
    }

    public void setBankUserName(String bankUserName) {
        this.bankUserName = bankUserName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankCard() {
        return bankCard;
    }

    public void setBankCard(String bankCard) {
        this.bankCard = bankCard;
    }
}
