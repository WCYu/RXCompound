package com.rxjy.rxcompound.entity;

/**
 * Created by Administrator on 2017/11/6.
 */

public class Tabs {

    private String title;

    private String msgnum;

    private int icon;

    private Class fragment;

    public Tabs(String title, String msgnum, int icon, Class fragment) {
        this.title = title;
        this.msgnum = msgnum;
        this.icon = icon;
        this.fragment = fragment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public Class getFragment() {
        return fragment;
    }

    public void setFragment(Class fragment) {
        this.fragment = fragment;
    }

    public String getMsgnum() {
        return msgnum;
    }

    public void setMsgnum(String msgnum) {
        this.msgnum = msgnum;
    }

    @Override
    public String toString() {
        return "Tabs{" +
                "title='" + title + '\'' +
                ", msgnum='" + msgnum + '\'' +
                ", icon=" + icon +
                ", fragment=" + fragment +
                '}';
    }
}
