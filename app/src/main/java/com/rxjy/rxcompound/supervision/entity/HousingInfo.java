package com.rxjy.rxcompound.supervision.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asus on 2018/4/14.
 */

public class HousingInfo {

  String id;
  String Minchang;

    public HousingInfo(String id, String minchang) {
        this.id = id;
        Minchang = minchang;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMinchang() {
        return Minchang;
    }

    public void setMinchang(String minchang) {
        Minchang = minchang;
    }


}
