package com.rxjy.rxcompound.supervision.entity;

/**
 * Created by AAA on 2018/1/17.
 */

public class RemarkInfo {

    private int xj_Type;
    private String xj_remark;

    public RemarkInfo() {
    }

    public RemarkInfo(int xj_Type, String xj_remark) {
        this.xj_Type = xj_Type;
        this.xj_remark = xj_remark;
    }

    public int getXj_Type() {
        return xj_Type;
    }

    public void setXj_Type(int xj_Type) {
        this.xj_Type = xj_Type;
    }

    public String getXj_remark() {
        return xj_remark;
    }

    public void setXj_remark(String xj_remark) {
        this.xj_remark = xj_remark;
    }
}
