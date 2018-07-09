package com.rxjy.rxcompound.commons.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * Created by hjh on 2017/11/7.
 */

public class StringUtils {


    public static boolean isEmpty(String str) {
        return !(null != str && !str.trim().equals("") && !str.equals("null"));
    }

    /**
     * 得到两个时间相差的秒数
     *
     * @return
     */
    public static int getTimetoTime(long t1, long t2) {
        long poortime;
        if (t1 < t2) {
            poortime = (t2 - t1) / 1000;
        } else {
            poortime = (t1 - t2) / 1000;
        }
        String time;
        if (poortime < 1) {
            time = "1";
        } else {
            time = poortime + "";
        }
        int poortimes = Integer.parseInt(time);
        return poortimes;
    }


    /**
     * 将获取到的时间与当前时间对比是否超时
     * 2超时或相同
     *
     * @param time
     * @return
     */
    public static int CompareTime(String time) {//传入获取到的时间
        int isover = 0;

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateNowStr = sdf.format(date);//当前时间

        long timenow = getStringTimestamp(dateNowStr);
        long timeget = getStringTimestamp(time);

        if (timenow >= timeget) {
            isover = 2;
        }

        return isover;
    }


    /**
     * 将时间转换为时间戳
     *
     * @param time
     * @return
     */
    public static Long getStringTimestamp(String time) {
//        String timestamp = null;
        Long timestamp = null;

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            Long longTime = sdf.parse(time).getTime();
            timestamp = sdf.parse(time).getTime();
//            timestamp = Long.toString(longTime);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return timestamp;
    }


    /**
     * 计算当前时间与获取到的时间相差的秒数
     *
     * @param time
     * @return
     */
    public static int getTimeMiaoCha(String time) {//传入获取到的时间

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateNowStr = sdf.format(date);//当前时间

        long timenow = getStringTimestamp(dateNowStr);
        long timeget = getStringTimestamp(time);

        int timemiao = getTimetoTime(timenow, timeget);

        return timemiao;
    }


    //list转成以“，”分隔
    public static String listToString(List list) {
        StringBuilder sb = new StringBuilder();
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                if (i < list.size() - 1) {
                    sb.append(list.get(i) + ",");
                } else {
                    sb.append(list.get(i));
                }
            }
        }
        return sb.toString();
    }


    //判断字符串是否全为空格
    public static int isAllBlank(String str) {
        int isblank;//1:全为空格 2：不是
        String ss = str.toString().trim();
        if (ss.isEmpty()) {
            isblank = 1;
        } else {
            isblank = 2;
        }
        return isblank;
    }


    public static String getVersionName(Context context) throws Exception {
        // 获取packagemanager的实例
        PackageManager packageManager = context.getPackageManager();
        // getPackageName()是你当前类的包名，0代表是获取版本信息
        PackageInfo packInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
        String version = packInfo.versionName;
        return version;
    }


    //设置edittext的hint字体大小
    public static void setHintSize(String hintcontent, int hintsize, EditText editText) {
        SpannableString ss = new SpannableString(hintcontent);
        AbsoluteSizeSpan ass = new AbsoluteSizeSpan(hintsize, true);//true表示单位为sp
        ss.setSpan(ass, 0, ss.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        editText.setHint(new SpannedString(ss));
    }


    /**
     * 超过10000转换
     */
    public static String ChangeNum(int num) {
        String numshow;
        if (num > 10000) {
            String str = String.valueOf(num);
            String numfirst = str.substring(0, str.length() - 4);
            String numlast = str.substring(str.length() - 4, str.length() - 3);
            if (!numlast.equals("0")) {
                numshow = numfirst + "." + numlast + "万";
            } else {
                numshow = numfirst + "万";
            }
        } else {
            numshow = num + "";
        }
        return numshow;
    }


    /**
     * 判断edittext是否需要滚动
     *
     * @param editText
     * @return
     */
    public static boolean canVerticalScroll(EditText editText) {
        //滚动的距离
        int scrollY = editText.getScrollY();
        //控件内容的总高度
        int scrollRange = editText.getLayout().getHeight();
        //控件实际显示的高度
        int scrollExtent = editText.getHeight() - editText.getCompoundPaddingTop() - editText.getCompoundPaddingBottom();
        //控件内容总高度与实际显示高度的差值
        int scrollDifference = scrollRange - scrollExtent;

        if (scrollDifference == 0) {
            return false;
        }
        return (scrollY > 0) || (scrollY < scrollDifference - 1);
    }


    /**
     * 功能：身份证的有效验证
     *
     * @param IDStr 身份证号
     * @return 有效：返回"" 无效：返回String信息
     * @throws ParseException
     */
    public static String IDCardValidate(String IDStr) throws Exception {
        String errorInfo = "";// 记录错误信息
        String[] ValCodeArr = {"1", "0", "x", "9", "8", "7", "6", "5", "4", "3", "2"};
        String[] Wi = {"7", "9", "10", "5", "8", "4", "2", "1", "6", "3", "7", "9", "10", "5", "8", "4", "2"};
        String Ai = "";
        // ================ 号码的长度 15位或18位 ================
        if (IDStr.length() != 15 && IDStr.length() != 18) {
            errorInfo = "身份证号码长度应该为15位或18位。";
            return errorInfo;
        }
        // =======================(end)========================

        // ================ 数字 除最后以为都为数字 ================
        if (IDStr.length() == 18) {
            Ai = IDStr.substring(0, 17);
        } else if (IDStr.length() == 15) {
            Ai = IDStr.substring(0, 6) + "19" + IDStr.substring(6, 15);
        }
        if (isNumeric(Ai) == false) {
            errorInfo = "身份证15位号码都应为数字 ; 18位号码除最后一位外，都应为数字。";
            return errorInfo;
        }
        // =======================(end)========================

        // ================ 出生年月是否有效 ================
        String strYear = Ai.substring(6, 10);// 年份
        String strMonth = Ai.substring(10, 12);// 月份
        String strDay = Ai.substring(12, 14);// 月份
        if (isDataFormat(strYear + "-" + strMonth + "-" + strDay) == false) {
            errorInfo = "身份证生日无效。";
            return errorInfo;
        }
        GregorianCalendar gc = new GregorianCalendar();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        if ((gc.get(Calendar.YEAR) - Integer.parseInt(strYear)) > 150
                || (gc.getTime().getTime() - s.parse(strYear + "-" + strMonth + "-" + strDay).getTime()) < 0) {
            errorInfo = "身份证生日不在有效范围。";
            return errorInfo;
        }
        if (Integer.parseInt(strMonth) > 12 || Integer.parseInt(strMonth) == 0) {
            errorInfo = "身份证月份无效";
            return errorInfo;
        }
        if (Integer.parseInt(strDay) > 31 || Integer.parseInt(strDay) == 0) {
            errorInfo = "身份证日期无效";
            return errorInfo;
        }
        // =====================(end)=====================

        // ================ 地区码时候有效 ================
        Hashtable<String, String> h = GetAreaCode();
        if (h.get(Ai.substring(0, 2)) == null) {
            errorInfo = "身份证地区编码错误。";
            return errorInfo;
        }
        // ==============================================

        // ================ 判断最后一位的值 ================
        int TotalmulAiWi = 0;
        for (int i = 0; i < 17; i++) {
            TotalmulAiWi = TotalmulAiWi + Integer.parseInt(String.valueOf(Ai.charAt(i))) * Integer.parseInt(Wi[i]);
        }
        int modValue = TotalmulAiWi % 11;
        String strVerifyCode = ValCodeArr[modValue];
        Ai = Ai + strVerifyCode;

        if (IDStr.length() == 18) {
            if (Ai.equalsIgnoreCase(IDStr) == false) {
                errorInfo = "身份证无效，不是合法的身份证号码";
                return errorInfo;
            }
        } else {
            return "";
        }
        // =====================(end)=====================
        return "";
    }


    /**
     * 功能：判断字符串是否为数字
     *
     * @param str
     * @return
     */
    private static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        return isNum.matches();
    }


    /**
     * 功能：设置地区编码
     *
     * @return Hashtable 对象
     */
    private static Hashtable<String, String> GetAreaCode() {
        Hashtable<String, String> hashtable = new Hashtable<String, String>();
        hashtable.put("11", "北京");
        hashtable.put("12", "天津");
        hashtable.put("13", "河北");
        hashtable.put("14", "山西");
        hashtable.put("15", "内蒙古");
        hashtable.put("21", "辽宁");
        hashtable.put("22", "吉林");
        hashtable.put("23", "黑龙江");
        hashtable.put("31", "上海");
        hashtable.put("32", "江苏");
        hashtable.put("33", "浙江");
        hashtable.put("34", "安徽");
        hashtable.put("35", "福建");
        hashtable.put("36", "江西");
        hashtable.put("37", "山东");
        hashtable.put("41", "河南");
        hashtable.put("42", "湖北");
        hashtable.put("43", "湖南");
        hashtable.put("44", "广东");
        hashtable.put("45", "广西");
        hashtable.put("46", "海南");
        hashtable.put("50", "重庆");
        hashtable.put("51", "四川");
        hashtable.put("52", "贵州");
        hashtable.put("53", "云南");
        hashtable.put("54", "西藏");
        hashtable.put("61", "陕西");
        hashtable.put("62", "甘肃");
        hashtable.put("63", "青海");
        hashtable.put("64", "宁夏");
        hashtable.put("65", "新疆");
        hashtable.put("71", "台湾");
        hashtable.put("81", "香港");
        hashtable.put("82", "澳门");
        hashtable.put("91", "国外");
        return hashtable;
    }

    /**
     * 验证日期字符串是否是YYYY-MM-DD格式
     *
     * @param str
     * @return
     */
    public static boolean isDataFormat(String str) {
        boolean flag = false;
        // String
        // regxStr="[1-9][0-9]{3}-[0-1][0-2]-((0[1-9])|([12][0-9])|(3[01]))";
        String regxStr = "^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s(((0?[0-9])|([1-2][0-3]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))?$";
        Pattern pattern1 = Pattern.compile(regxStr);
        Matcher isNo = pattern1.matcher(str);
        if (isNo.matches()) {
            flag = true;
        }
        return flag;
    }

    /**
     * 获取身份证号出生日期的年份
     *
     * @param context
     * @param idCard
     * @return
     */
    public static String getIDCardBirthdayYear(Context context, String idCard) {
        String birthdayYear = "";
        String Ai = "";
        try {
            String idCardValidate = StringUtils.IDCardValidate(idCard);
            if (!StringUtils.isEmpty(idCardValidate)) {
                Toast.makeText(context, idCardValidate, Toast.LENGTH_LONG).show();
                birthdayYear = "";
            } else {
                if (idCard.length() == 18) {
                    Ai = idCard.substring(0, 17);
                } else if (idCard.length() == 15) {
                    Ai = idCard.substring(0, 6) + "19" + idCard.substring(6, 15);
                }
                birthdayYear = Ai.substring(6, 10);// 年份
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return birthdayYear;
    }

    /**
     * 获取身份证号出生日期(yyyy-MM-dd)
     *
     * @param context
     * @param idCard
     * @return
     */
    public static String getIDCardBirthday(Context context, String idCard) {
        String birthdayYear = "";
        String birthdayMonth = "";
        String birthdayDay = "";
        String Ai = "";
        try {
            String idCardValidate = StringUtils.IDCardValidate(idCard);
            if (!StringUtils.isEmpty(idCardValidate)) {
                Toast.makeText(context, idCardValidate, Toast.LENGTH_LONG).show();
                birthdayYear = "";
            } else {
                if (idCard.length() == 18) {
                    Ai = idCard.substring(0, 17);
                } else if (idCard.length() == 15) {
                    Ai = idCard.substring(0, 6) + "19" + idCard.substring(6, 15);
                }
                birthdayYear = Ai.substring(6, 10);// 年份
                birthdayMonth = Ai.substring(10, 12);// 月份
                birthdayDay = Ai.substring(12, 14);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return birthdayYear + "-" + birthdayMonth + "-" + birthdayDay;
    }


    //加密
    public static String changeUtf8(String content) {
        String strUTF8 = null;
        try {
            strUTF8 = URLEncoder.encode(content, "UTF-8");
            strUTF8 = strUTF8.replaceAll("\\+", "%20");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return strUTF8;
    }

    //解密
    public static String changeUtf8s(String content) {
        String strUTF8 = null;
        try {
            strUTF8 = URLDecoder.decode(content, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return strUTF8;
    }


    public static boolean isBackground(Context context) {

        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> appProcesses = activityManager.getRunningAppProcesses();
        for (ActivityManager.RunningAppProcessInfo appProcess : appProcesses) {
            if (appProcess.processName.equals(context.getPackageName())) {
                if (appProcess.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_BACKGROUND) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }


    //去掉相同的数据
    public static List removeDuplicateWithOrder(List list) {
        Set set = new HashSet();
        List newList = new ArrayList();
        for (Iterator iter = list.iterator(); iter.hasNext(); ) {
            Object element = iter.next();
            if (set.add(element))
                newList.add(element);
        }
        return newList;
    }


    /**
     * 从数据多的集合中，取出（两个集合非并集）的数据
     *
     * @param list1(数据少的集合)
     * @param list2(数据多的集合)
     * @return
     */
    public static ArrayList<String> getTheSameSection(ArrayList<String> list1, ArrayList<String> list2) {
        ArrayList<String> resultList = new ArrayList<String>();
        for (String item : list2) {//遍历list2
            if (!list1.contains(item)) {//如果不存在这个数
                resultList.add(item);//放进一个list里面，这个list就是交集
            }
        }
        return resultList;
    }


    /**
     * 将字符串转为时间戳
     *
     * @param user_time
     * @return
     */
    public static String getTime(String user_time) {
        String re_time = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
        Date d;
        try {
            d = sdf.parse(user_time);
            long l = d.getTime() / 100;
            String str = String.valueOf(l);
            re_time = str.substring(0, 11);
        } catch (ParseException e) {
            // TODO Auto-generated catch block e.printStackTrace();
        }
        return re_time;
    }


    public static int compare_date(String DATE1, String DATE2) {

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        try {
            Date dt1 = df.parse(DATE1);
            Date dt2 = df.parse(DATE2);
            if (dt1.getTime() > dt2.getTime()) {
                return 1;
            } else if (dt1.getTime() < dt2.getTime()) {
                return -1;
            } else {
                return 0;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return -2;
    }


    //过滤emoji表情
    public static void setProhibitEmoji(EditText et, int lengths) {
        InputFilter[] filters = new InputFilter[]{getInputFilterProhibitEmoji(), new InputFilter.LengthFilter(lengths)};
        et.setFilters(filters);
    }

    /**
     * 过滤emoji
     *
     * @return
     */
    public static InputFilter getInputFilterProhibitEmoji() {
        InputFilter filter = new InputFilter() {
            @Override
            public CharSequence filter(CharSequence source, int start, int end,
                                       Spanned dest, int dstart, int dend) {
                StringBuffer buffer = new StringBuffer();
                for (int i = start; i < end; i++) {
                    char codePoint = source.charAt(i);
                    if (!getIsEmoji(codePoint)) {
                        buffer.append(codePoint);
                    } else {
                        i++;
                        continue;
                    }
                }
                if (source instanceof Spanned) {
                    SpannableString sp = new SpannableString(buffer);
                    TextUtils.copySpansFrom((Spanned) source, start, end, null,
                            sp, 0);
                    return sp;
                } else {
                    return buffer;
                }
            }
        };
        return filter;
    }

    /**
     * 判断是否为emoji
     *
     * @param codePoint
     * @return
     */
    public static boolean getIsEmoji(char codePoint) {
        return !((codePoint == 0x0) || (codePoint == 0x9) || (codePoint == 0xA)
                || (codePoint == 0xD)
                || ((codePoint >= 0x20) && (codePoint <= 0xD7FF))
                || ((codePoint >= 0xE000) && (codePoint <= 0xFFFD))
                || ((codePoint >= 0x10000) && (codePoint <= 0x10FFFF)));
    }


    /**
     * 禁止换行
     *
     * @param editText
     * @return
     */
    public static void BanANewLine(EditText editText) {
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                return (event.getKeyCode() == KeyEvent.KEYCODE_ENTER);
            }
        });
    }


    /**
     * 閸掋倖鏌嘜bject閺勵垰鎯佹稉绨剈ll
     *
     * @param obj
     * @return null true
     */
    public static boolean isEmpty(Object obj) {
        if (obj == null)
            return true;
        boolean flag = false;
        if (obj == null || "".equals(obj) || "null".equals(obj)) {
            flag = true;
        }
        return flag;
    }


    /**
     * 閸掋倖鏌噇ist閺勵垰鎯佹稉绨剈ll
     *
     * @param list
     * @return null true
     */
    public static boolean isEmpty(List<?> list) {
        return !(null != list && list.size() != 0);
    }

    /**
     * 閸掋倖鏌噇ist閺勵垰鎯佹稉绨剈ll
     *
     * @param map
     * @return null true
     */
    public static boolean isEmpty(Map<?, ?> map) {
        return !(null != map && !map.isEmpty());
    }

    /**
     * 鏉╂柨娲栫粚鍝勶拷锟?
     */
    public static String isEmptyToString(String str) {
        String s = (isEmpty(str) ? "" : str.trim());
        return s;
    }

    /**
     * 鏉╂柨娲栫粚鍝勶拷锟?
     */
    public static String isEmptyToString(Object obj) {
        String s = (isEmpty(obj) ? "" : String.valueOf(obj));
        return s;
    }

    public static String isEmptyToString(String str, String defaultValue) {
        String s = (isEmpty(str) ? defaultValue : str.trim());
        return s;
    }

    public static String isNoEmptyToString(String str, String defaultValue) {
        String s = (isEmpty(str) ? "" : defaultValue);
        return s;
    }


    /**
     * 手机号正则
     */
    public static boolean isMobileNO(String mobiles) {
        String regExp = "^[1]([3][0-9]{1}|[4][0-9]{1}|[5][0-9]{1}|[7][0-9]{1}|[8][0-9]{1})[0-9]{8}$";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }

    //密码是数字和字母且都有
    public static boolean isPwds(String passwords) {
        String pswords = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}$";
        Pattern p = Pattern.compile(pswords);
        Matcher m = p.matcher(passwords);
        return m.matches();
    }

    //密码是数字或者字母
    public static boolean isPwd(String passwords) {
        String pswords = "[A-Z,a-z,0-9]*";
        Pattern p = Pattern.compile(pswords);
        Matcher m = p.matcher(passwords);
        return m.matches();
    }

    //是数字或者字母或者汉字
    public static boolean isEditNickName(String nickname) {
        String nicknames = "[^a-zA-Z0-9\u4E00-\u9FA5]";
        Pattern p = Pattern.compile(nicknames);
        Matcher m = p.matcher(nickname);
        return m.matches();
    }


    //汉字、数字、字母过滤器
    public static String StringFilter(String str) throws PatternSyntaxException {
        // 只允许字母、数字和汉字
        String regEx = "[^a-zA-Z0-9\u4E00-\u9FA5]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.replaceAll("").trim();
    }

    //汉字、数字、字母过滤器+空格
    public static String StringFilterblank(String str) throws PatternSyntaxException {
        // 只允许字母、数字和汉字
        String regEx = "[^a-zA-Z0-9\\s\u4E00-\u9FA5]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.replaceAll("");
    }

    //数字、字母过滤器
    public static String StringFilterPwd(String str) throws PatternSyntaxException {
        // 只允许字母、数字
        String regEx = "[^a-zA-Z0-9]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.replaceAll("").trim();
    }

    //数字过滤器
    public static String StringFilterNum(String str) throws PatternSyntaxException {
        // 只允许数字
        String regEx = "[^0-9]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.replaceAll("").trim();
    }


    //过滤特殊字符
    public static String stringFilterte(String str) throws PatternSyntaxException {
        String regEx = "[/\\:*?<>|,，\"\n\t]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.replaceAll("");
    }


    /**
     * 汉字过滤
     *
     * @param str
     * @return
     * @throws PatternSyntaxException
     */
    public static String StringFilterChinese(String str) throws PatternSyntaxException {
        // 只允许汉字
        String regEx = "[^\u4E00-\u9FA5]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.replaceAll("").trim();
    }


    /**
     * 校验邮箱
     */
    public static boolean checkEmail(String str) {
        String regulars = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
        return str.matches(regulars);
    }


    /**
     * 消掉数据多余的0
     *
     * @param number
     * @return
     */
    public static String getPrettyNumber(String number) {
        String plainString = BigDecimal.valueOf(Double.parseDouble(number))
                .stripTrailingZeros().toPlainString();
        if (plainString.equals("0.0")) {
            plainString = "0";
        }
        return plainString;
    }

    /**
     * 判断是否是相同的数字
     *
     * @param str
     * @return
     * @throws IllegalArgumentException
     */
    public static boolean isSameChars(String str) throws IllegalArgumentException {
        if (str == null)
            throw new IllegalArgumentException("Input string should not be null.");

        else if (str.length() < 2)
            return true;

        char first = str.charAt(0);
        for (int i = 1; i < str.length(); i++)
            if (str.charAt(i) != first)
                return false;

        return true;
    }


    /**
     * 将金额转为万元为单位并保留一位小数
     *
     * @param bigDecimal
     * @return
     */
    public static String toWanYuan(BigDecimal bigDecimal) {
        // 转换为万元（除以10000）
        BigDecimal decimal = bigDecimal.divide(new BigDecimal("10000"));
        // 保留两位小数
        DecimalFormat formater = new DecimalFormat("0.0");
        // 四舍五入
        formater.setRoundingMode(RoundingMode.HALF_UP);    // 5000008.89
//        formater.setRoundingMode(RoundingMode.HALF_DOWN);// 5000008.89
//        formater.setRoundingMode(RoundingMode.HALF_EVEN);

        // 格式化完成之后得出结果
        String formatNum = formater.format(decimal);
        return formatNum;
    }


}
