package com.rxjy.rxcompound.entity;

/**
 * Created by hjh on 2017/12/20.
 */

public class QRResultBean {

    private String function;
    private String parameters;

    public QRResultBean() {super();
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String getParameters() {
        return parameters;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }

    @Override
    public String toString() {
        return "QRResultBean{" +
                "function='" + function + '\'' +
                ", parameters='" + parameters + '\'' +
                '}';
    }
}
