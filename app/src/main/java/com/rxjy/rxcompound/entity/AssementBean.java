package com.rxjy.rxcompound.entity;

import java.util.ArrayList;

/**
 * Created by hjh on 2017/11/16.
 */

public class AssementBean {

    private ArrayList<AssementCuraBean> cura;
    private String pressess;

    public AssementBean() {super();
    }

    @Override
    public String toString() {
        return "AssementBean{" +
                "cura=" + cura +
                ", pressess='" + pressess + '\'' +
                '}';
    }

    public ArrayList<AssementCuraBean> getCura() {
        return cura;
    }

    public void setCura(ArrayList<AssementCuraBean> cura) {
        this.cura = cura;
    }

    public String getPressess() {
        return pressess;
    }

    public void setPressess(String pressess) {
        this.pressess = pressess;
    }
}
