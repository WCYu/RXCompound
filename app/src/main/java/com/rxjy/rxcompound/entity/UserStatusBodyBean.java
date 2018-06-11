package com.rxjy.rxcompound.entity;

/**
 * Created by hjh on 2017/11/20.
 */

public class UserStatusBodyBean {

    private int Stage;
    private String DataPower;
    private String SystemPower;

    public UserStatusBodyBean() {super();
    }

    public int getStage() {
        return Stage;
    }

    public void setStage(int stage) {
        Stage = stage;
    }

    public String getDataPower() {
        return DataPower;
    }

    public void setDataPower(String dataPower) {
        DataPower = dataPower;
    }

    public String getSystemPower() {
        return SystemPower;
    }

    public void setSystemPower(String systemPower) {
        SystemPower = systemPower;
    }

    @Override
    public String toString() {
        return "UserStatusBodyBean{" +
                "Stage=" + Stage +
                ", DataPower='" + DataPower + '\'' +
                ", SystemPower='" + SystemPower + '\'' +
                '}';
    }
}
