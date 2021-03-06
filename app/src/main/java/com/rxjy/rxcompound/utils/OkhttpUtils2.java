package com.rxjy.rxcompound.utils;

import android.util.Log;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Set;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Created by Administrator on 2018/4/16.
 */

public class OkhttpUtils2 {
    private static OkHttpClient client = null;

    private OkhttpUtils2() {
    }

    public static OkHttpClient getInstance() {
        if (client == null) {
            synchronized (OkhttpUtils2.class) {
                if (client == null)
                    client = new OkHttpClient();
            }
        }
        return client;
    }

    /**
     * Get请求
     *
     * @param url
     * @param callback
     */
    public static void doGet(String url, Map<String, Object> map, Callback callback) {

        if (map != null && map.size() >= 0) {
            StringBuffer buffer = new StringBuffer();
            buffer.append(url + "?");
            Set<String> strings = map.keySet();
            for (String key : strings) {
                buffer.append(key).append("=").append(map.get(key)).append("&");
            }
            url = buffer.substring(0, buffer.length() - 1);
        }
        Log.e("tag", url);
        Request request = new Request.Builder()
                .url(url)
                .build();
        Call call = getInstance().newCall(request);
        call.enqueue(callback);
    }

    /**
     * Post请求发送键值对数据
     *
     * @param url
     * @param mapParams
     * @param callback
     */
    public static void doPost(String url, Map<String, Object> mapParams, Callback callback) {
        FormBody.Builder builder = new FormBody.Builder();
        for (String key : mapParams.keySet()) {
            builder.add(key, String.valueOf(mapParams.get(key)));
        }
        Request request = new Request.Builder()
                .url(url)
                .post(builder.build())
                .build();
        Call call = getInstance().newCall(request);
        call.enqueue(callback);
    }

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    public static void post(String url, String json, Callback Callback) {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        client.newCall(request).enqueue(Callback);
//        if (response.isSuccessful()) {
//            return response.body().string();
//        } else {
//            throw new IOException("Unexpected code " + response);
//        }
    }

    private static final MediaType MEDIA_TYPE_PNG = MediaType.parse("image/png");

    public static void uploadFile(String url, List<String> fileNames, Map<String, Object>
            params, Callback Callback) {
        //MultipartBody多功能的请求实体对象,,,formBody只能传表单形式的数据
        MultipartBody.Builder builder = new MultipartBody.Builder().setType(MultipartBody.FORM);
        //参数
//        if (params.size()>0) {
//            for (String key : params.keySet()) {
//                builder.addFormDataPart(key, params.get(key).toString());
//       z     }
//        }
        for (int i = 0; i < fileNames.size(); i++) {
            File f = new File(fileNames.get(i));
            if (f != null) {
                builder.addFormDataPart("image", f.getName(), RequestBody.create(MEDIA_TYPE_PNG, f));
            }
        }
        //构建
        MultipartBody multipartBody = builder.build();

        //创建Request
        Request request = new Request.Builder().url(url).post(multipartBody).build();

        //得到Call
        Call call = getInstance().newCall(request);
        //执行请求
        call.enqueue(Callback);

    }

}