package com.rxjy.rxcompound.entity;

/**
 * Created by hjh on 2018/4/19.
 */

public class MoneyTzRsProgress {

    private int StatusCode;
    private String StatusMsg;
    private BodyBean Body;

    public MoneyTzRsProgress() {
        super();
    }

    @Override
    public String toString() {
        return "MoneyTzBean{" +
                "StatusCode=" + StatusCode +
                ", StatusMsg='" + StatusMsg + '\'' +
                ", Body=" + Body +
                '}';
    }

    public int getStatusCode() {
        return StatusCode;
    }

    public void setStatusCode(int statusCode) {
        StatusCode = statusCode;
    }

    public String getStatusMsg() {
        return StatusMsg;
    }

    public void setStatusMsg(String statusMsg) {
        StatusMsg = statusMsg;
    }

    public BodyBean getBody() {
        return Body;
    }

    public void setBody(BodyBean body) {
        Body = body;
    }

    public class BodyBean{
//        "shigang_num":8,
//                "shigang_bz":0,
//                "shigang_dj":50,
//                "sw_ruzhi_num":3,
//                "sw_ruzhi_bz":0,
//                "sw_ruzhi_dj":100,
//                "za_ruzhi_num":0,
//                "za_ruzhi_bz":0,
//                "za_ruzhi_dj":100,
//                "zhuanzheng_num":0,
//                "zhuanzheng_bz":0,
//                "zhuanzheng_dj":200,
//                "xz_ping_gu_num":51,
//                "xz_ping_gu_bz":0,
//                "xz_ping_gu_dj":5,
//                "xz_ping_gu_num_invalid":0,
//                "xz_ping_gu_debit":5,
//                "xingxiang_num":9,
//                "xingxiang_bz":0,
//                "xingxiang_dj":5,
//                "xingxiang_num_invalid":0,
//                "xingxiang_debit":5,
//                "rw_zhi_xing_num":10,
//                "rw_zhi_xing_bz":0,
//                "rw_zhi_xing_dj":30,
//                "shigang_gongzi":400,
//                "sw_ruzhi_gongzi":300,
//                "za_ruzhi_gongzi":0,
//                "zhuanzheng_gongzi":0,
//                "xz_ping_gu_gongzi":255,
//                "xingxiang_gongzi":45,
//                "rw_zhi_xing_gongzi":300,
//                "process_gongzi":1300

        private int shigang_num;
        private int shigang_bz;


    }

}