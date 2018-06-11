package com.rxjy.rxcompound.entity;

/**
 * Created by hjh on 2017/11/13.
 */

public class BannerDataBean {

    private String banner_title;
    private String banner_img;
    private String banner_content;
    private int id;
    private int flag;
    private int banner_id;
    private String create_date;
    private String update_date;

    public BannerDataBean() {
        super();
    }

    @Override
    public String toString() {
        return "BannerDataBean{" +
                "banner_title='" + banner_title + '\'' +
                ", banner_img='" + banner_img + '\'' +
                ", banner_content='" + banner_content + '\'' +
                ", id=" + id +
                ", flag=" + flag +
                ", banner_id=" + banner_id +
                ", create_date='" + create_date + '\'' +
                ", update_date='" + update_date + '\'' +
                '}';
    }

    public String getBanner_title() {
        return banner_title;
    }

    public void setBanner_title(String banner_title) {
        this.banner_title = banner_title;
    }

    public String getBanner_img() {
        return banner_img;
    }

    public void setBanner_img(String banner_img) {
        this.banner_img = banner_img;
    }

    public String getBanner_content() {
        return banner_content;
    }

    public void setBanner_content(String banner_content) {
        this.banner_content = banner_content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public int getBanner_id() {
        return banner_id;
    }

    public void setBanner_id(int banner_id) {
        this.banner_id = banner_id;
    }

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    public String getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(String update_date) {
        this.update_date = update_date;
    }
}
