package com.rxjy.rxcompound.entity;

/**
 * Created by hjh on 2018/3/21.
 */

public class NoticBean {

    private String ID;
    private String Type;

    public NoticBean() {
        super();
    }

    @Override
    public String toString() {
        return "NoticBean{" +
                "ID='" + ID + '\'' +
                ", Type='" + Type + '\'' +
                '}';
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }
}
