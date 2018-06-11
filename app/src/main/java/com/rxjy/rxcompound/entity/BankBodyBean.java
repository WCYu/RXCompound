package com.rxjy.rxcompound.entity;

/**
 * Created by hjh on 2017/11/17.
 */

public class BankBodyBean {

    private int id;
    private String bank_name;
    private String bank_image;

    public BankBodyBean() {super();
    }

    @Override
    public String toString() {
        return "BankBodyBean{" +
                "id=" + id +
                ", bank_name='" + bank_name + '\'' +
                ", bank_image='" + bank_image + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBank_name() {
        return bank_name;
    }

    public void setBank_name(String bank_name) {
        this.bank_name = bank_name;
    }

    public String getBank_image() {
        return bank_image;
    }

    public void setBank_image(String bank_image) {
        this.bank_image = bank_image;
    }
}
