package com.rxjy.rxcompound.entity;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/11/14.
 */

public class FindBodyBean {

    private ArrayList<FindDataBean> topList;
    private ArrayList<FindDataBean> list;

    public FindBodyBean() {super();
    }

    @Override
    public String toString() {
        return "FindBodyBean{" +
                "topList=" + topList +
                ", list=" + list +
                '}';
    }

    public ArrayList<FindDataBean> getTopList() {
        return topList;
    }

    public void setTopList(ArrayList<FindDataBean> topList) {
        this.topList = topList;
    }

    public ArrayList<FindDataBean> getList() {
        return list;
    }

    public void setList(ArrayList<FindDataBean> list) {
        this.list = list;
    }
}
