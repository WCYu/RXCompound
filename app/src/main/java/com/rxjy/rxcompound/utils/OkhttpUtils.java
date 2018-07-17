package com.rxjy.rxcompound.utils;

import android.app.Activity;
import android.util.Log;

import com.rxjy.rxcompound.commons.App;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by Administrator on 2018/4/16.
 */

public class OkhttpUtils {
    private static OkHttpClient client = null;
    public static MyCall myCall;

    private OkhttpUtils() {
    }

    public static OkHttpClient getInstance() {
        if (client == null) {
            synchronized (OkhttpUtils.class) {
                if (client == null)
                    client = new OkHttpClient();
            }
        }
        return client;
    }

    public static void doGet(String url, Map<String, Object> map, final MyCall callback) {

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
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                App.baseActivity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.error(e.getMessage().toString());
                    }
                });
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                App.baseActivity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            callback.success(response.body().string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
    }

    public static void doGet(final Activity activity, String url, Map<String, Object> map, final MyCall callback) {

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
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.error(e.getMessage().toString());
                    }
                });
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                final String string = response.body().string();
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            callback.success(string);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
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

    public static void doPost(String url, Map<String, Object> mapParams, final MyCall callback) {
        FormBody.Builder builder = new FormBody.Builder();
        for (String key : mapParams.keySet()) {
            builder.add(key, String.valueOf(mapParams.get(key)));
        }
        Request request = new Request.Builder()
                .url(url)
                .post(builder.build())
                .build();
        Call call = getInstance().newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                App.baseActivity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.error(e.getMessage().toString());
                    }
                });
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                App.baseActivity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            callback.success(response.body().string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
    }

    public static void doPost(final Activity activity, String url, Map<String, Object> mapParams, final MyCall callback) {
        FormBody.Builder builder = new FormBody.Builder();
        for (String key : mapParams.keySet()) {
            builder.add(key, String.valueOf(mapParams.get(key)));
        }
        Request request = new Request.Builder()
                .url(url)
                .post(builder.build())
                .build();
        Call call = getInstance().newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.error(e.getMessage().toString());
                    }
                });
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            callback.success(response.body().string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
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

    public static void post(String url, String json , Callback Callback) {
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

    public void setMyCall(MyCall myCall){
        this.myCall = myCall;
    }
    public interface MyCall{
        void success(String data);
        void error(String message);
    }

}