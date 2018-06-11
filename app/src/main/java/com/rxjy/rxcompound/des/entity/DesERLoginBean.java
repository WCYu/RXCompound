package com.rxjy.rxcompound.des.entity;

/**
 * Created by hjh on 2018/4/18.
 */

public class DesERLoginBean {

    private String uuid;
    private int type;

    public DesERLoginBean() {
        super();
    }

    @Override
    public String toString() {
        return "DesERLoginBean{" +
                "uuid='" + uuid + '\'' +
                ", type=" + type +
                '}';
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
