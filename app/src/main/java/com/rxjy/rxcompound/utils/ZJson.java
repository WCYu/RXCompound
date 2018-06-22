package com.rxjy.rxcompound.utils;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

/**
 * Created by 阿禹 on 2017/12/26.
 */

public class ZJson {

    public static String toJSONMap(Map<String, Object> param) {
        Set<Map.Entry<String, Object>> entrySet = param.entrySet();
        JSONObject object = new JSONObject();
//        try {
//            object.put("", "");
//            object.put("", "");
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
        for (Map.Entry<String, Object> entry : entrySet) {
            String key = entry.getKey();
            Object value = param.get(key);
            try {
                object.put(key, value);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        Log.e("xx","map="+object.toString());
        return object.toString();
    }

    public static String toJSONMap(String str  ,Map<String, Object> param) {
        Set<Map.Entry<String, Object>> entrySet = param.entrySet();
        JSONObject object = new JSONObject();
        for (Map.Entry<String, Object> entry : entrySet) {
            String key = entry.getKey();
            Object value = param.get(key);
            try {
                object.put(key, value);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put(str,object);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }

    public static String toJSONMap(Map<String, Object> param, String jsonArray, int [] ints) {

        Set<Map.Entry<String, Object>> entrySet = param.entrySet();
        JSONObject object = new JSONObject();
        for (Map.Entry<String, Object> entry : entrySet) {
            String key = entry.getKey();
            Object value = param.get(key);
            try {
                object.put(key, value);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        try {
            JSONArray jsonArray1 = new JSONArray();

            for (int i = 0; i < ints.length; i++) {
                jsonArray1.put(ints[i]);
            }
            object.put(jsonArray,jsonArray1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Log.e("json",object.toString());
        return object.toString();
    }
    public static String toJSONMap(Map<String, Object> param, String jsonArray, ArrayList<String> arrayList) {

        Set<Map.Entry<String, Object>> entrySet = param.entrySet();
        JSONObject object = new JSONObject();
        for (Map.Entry<String, Object> entry : entrySet) {
            String key = entry.getKey();
            Object value = param.get(key);
            try {
                object.put(key, value);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        try {
            JSONArray jsonArray1 = new JSONArray();

            for (int i = 0; i < arrayList.size(); i++) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("big",arrayList.get(i));
                jsonObject.put("small",arrayList.get(i));
                jsonArray1.put(jsonObject);

                Log.e("tag_添加保洁",arrayList.get(i));
            }
            object.put(jsonArray,jsonArray1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Log.e("tag_json",object.toString());
        return object.toString();
    }
}
