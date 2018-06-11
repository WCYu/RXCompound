package com.rxjy.rxcompound.widget;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * Created by hjh on 2018/4/8.
 */

public class UrlTools {
    public static void main(String[] args) {
        String str="h\nw";
        System.out.println(str);
        String result=encode(str);
        System.out.println(result);
        System.out.println(decode(result));
    }

    public static String encode(String url) {
        StringBuffer sb=new StringBuffer();
        byte[] bytes=url.getBytes();
        for(int i=0;i<bytes.length;i++) {
            char c=(char)bytes[i];
            if (Character.isDigit(c)) {
                sb.append(c);
            }else{
                String hex = Integer.toHexString(bytes[i] & 0xff);
                //因为换行符位1010，十六进制位A，所以特殊处理
                if(hex.length()==1){
                    hex="0"+hex;
                }
                sb.append("%" + hex.toUpperCase());
            }
        }
        return sb.toString();
    }
    public static String decode(String url) {
        try {
            url = URLDecoder.decode(url, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return url;
    }
}
