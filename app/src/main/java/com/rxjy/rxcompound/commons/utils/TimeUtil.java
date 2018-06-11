package com.rxjy.rxcompound.commons.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by AAA on 2017/10/18.
 */

public class TimeUtil {

    //        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static String getYear() {
        long currentTimeMillis = System.currentTimeMillis();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
        Date date = new Date(currentTimeMillis);
        return simpleDateFormat.format(date);
    }

    public static String getMonth() {
        long currentTimeMillis = System.currentTimeMillis();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM");
        Date date = new Date(currentTimeMillis);
        return simpleDateFormat.format(date);
    }

    public static String getDay() {
        long currentTimeMillis = System.currentTimeMillis();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd");
        Date date = new Date(currentTimeMillis);
        return simpleDateFormat.format(date);
    }

    public static String getTime() {
        long currentTimeMillis = System.currentTimeMillis();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(currentTimeMillis);
        return simpleDateFormat.format(date);
    }

    public static String getNormalTime(String time) {
        String str = "";
        if (time == null) {
            return str;
        }
        if (time.contains("T")) {
            return time.substring(0, time.indexOf("T"));
        }
        if (time.contains(" ")) {
            return time.substring(0, time.indexOf(" "));
        }
        return time;
    }

    public static String getRecordTime(String time) {
        String str = "";
//       yyyy-MM-dd HH:mm:ss
        if (time == null) {
            return str;
        }
        if (time.contains("T")) {
            time = time.replace("T", " ");
        }
        Date timeData = toDate(time);
        if (isToday(time)) {
            str = dateFormater3.get().format(timeData);
        } else {
            str = dateFormater.get().format(timeData);
        }
        return str;
    }

    /**
     * 判断给定字符串时间是否为今日
     *
     * @param sdate
     * @return boolean
     */
    public static boolean isToday(String sdate) {
        boolean b = false;
        Date time = toDate(sdate);
        Date today = new Date();
        if (time != null) {
            String nowDate = dateFormater2.get().format(today);
            String timeDate = dateFormater2.get().format(time);
            if (nowDate.equals(timeDate)) {
                b = true;
            }
        }
        return b;
    }

    /**
     * 将字符串转位日期类型
     *
     * @param sdate
     * @return
     */
    public static Date toDate(String sdate) {
        try {
            return dateFormater.get().parse(sdate);
        } catch (ParseException e) {
            return null;
        }
    }

    private final static ThreadLocal<SimpleDateFormat> dateFormater = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm");
        }
    };

    private final static ThreadLocal<SimpleDateFormat> dateFormater2 = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };

    private final static ThreadLocal<SimpleDateFormat> dateFormater3 = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("HH:mm");
        }
    };

}
