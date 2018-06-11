package com.rxjy.rxcompound.entity;

/**
 * Created by asus on 2018/5/14.
 */

public class FloatedBean {


    /**
     * ci_RwdId : 12-200706
     * ci_ClientName : 布克哈德压缩机（上海）有限公司北京分公司办公装饰工程
     * ci_DesignerName : 王阿龙
     * SignTime : 2018-05-14 16:45:36.000
     * OrderType : 2
     * SignAmount : 55000.0
     * tb_diqu : 12
     * DiquName : 北京
     */

    private String ci_RwdId;
    private String ci_ClientName;
    private String ci_DesignerName;
    private String SignTime;
    private int OrderType;
    private double SignAmount;
    private int tb_diqu;
    private String DiquName;

    public String getCi_RwdId() {
        return ci_RwdId;
    }

    public void setCi_RwdId(String ci_RwdId) {
        this.ci_RwdId = ci_RwdId;
    }

    public String getCi_ClientName() {
        return ci_ClientName;
    }

    public void setCi_ClientName(String ci_ClientName) {
        this.ci_ClientName = ci_ClientName;
    }

    public String getCi_DesignerName() {
        return ci_DesignerName;
    }

    public void setCi_DesignerName(String ci_DesignerName) {
        this.ci_DesignerName = ci_DesignerName;
    }

    public String getSignTime() {
        return SignTime;
    }

    public void setSignTime(String SignTime) {
        this.SignTime = SignTime;
    }

    public int getOrderType() {
        return OrderType;
    }

    public void setOrderType(int OrderType) {
        this.OrderType = OrderType;
    }

    public double getSignAmount() {
        return SignAmount;
    }

    public void setSignAmount(double SignAmount) {
        this.SignAmount = SignAmount;
    }

    public int getTb_diqu() {
        return tb_diqu;
    }

    public void setTb_diqu(int tb_diqu) {
        this.tb_diqu = tb_diqu;
    }

    public String getDiquName() {
        return DiquName;
    }

    public void setDiquName(String DiquName) {
        this.DiquName = DiquName;
    }
}
