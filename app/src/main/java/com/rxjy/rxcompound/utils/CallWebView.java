package com.rxjy.rxcompound.utils;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.webkit.JavascriptInterface;

/**
 * Created by 阿禹 on 2018/6/29.
 */

public class CallWebView extends Object {
    // 定义JS需要调用的方法
    // 被JS调用的方法必须加入@JavascriptInterface注解
    @JavascriptInterface
    public void hello(Activity  activity,Class clz) {
        Intent intent = new Intent(activity,clz);
        activity.startActivity(intent);
    }
}
