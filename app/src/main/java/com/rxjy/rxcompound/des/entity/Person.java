package com.rxjy.rxcompound.des.entity;

import java.io.Serializable;

/**
 * Created by asus on 2018/5/24.
 */

public class Person  implements Serializable {
    private String Title ; //每条item的数据
    private boolean isChecked; //每条item的状态
    private int id;

    public Person(String title, int id) {
        Title = title;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Person(String title){
        Title = title;
    }
    public String getTitle() {
        return Title;
    }
    public void setTitle(String title) {
        Title = title;
    }
    public boolean isChecked() {
        return isChecked;
    }
    public void setChecked(boolean checked) {
        isChecked = checked;
    }


}
