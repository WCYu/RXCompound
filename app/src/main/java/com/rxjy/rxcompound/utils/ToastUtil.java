package com.rxjy.rxcompound.utils;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextView;
import android.widget.Toast;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.App;

/**
 * Created by 阿禹 on 2018/3/23.
 * Toast类
 */

public class ToastUtil {
    private Toast toast;

    public static ToastUtil getInstance(){
        return new ToastUtil();
    }

    //在屏幕中间显示吐司
    public void toastCentent(String message){
        toast = Toast.makeText(App.context, message, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER,0,0);
        TextView textView = new TextView(App.context);
        textView.setPadding(180,60,180,60);
        textView.setText(message);
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(Color.parseColor("#ffffff"));
        textView.setBackgroundResource(R.drawable.toast_background);
        toast.setView(textView);
        toast.show();
    }

    public void toastCentent(String message, Context context){
        toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER,0,0);
        TextView textView = new TextView(context);
        textView.setPadding(180,60,180,60);
        textView.setText(message);
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(Color.parseColor("#ffffff"));
        textView.setBackgroundResource(R.drawable.toast_background);
        toast.setView(textView);
        toast.show();
    }

    //在屏幕底部显示吐司
    public void toastBottom(String message){
        toast = Toast.makeText(App.context, message, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM,0,0);
        toast.show();
    }

    //在屏幕上方显示吐司
    public void toastTop(String message){
        toast = Toast.makeText(App.context, message, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP,0,0);
        toast.show();
    }

    //在屏幕中间显示吐司
    public void toastCentent(int message){
        toast = Toast.makeText(App.context, message, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();
    }

    //在屏幕底部显示吐司
    public void toastBottom(int message){
        toast = Toast.makeText(App.context, message, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM,0,0);
        toast.show();
    }

//    //在屏幕上方显示吐司
//    public void toastTop(int message){
//        toast = Toast.makeTextApp.baseActivity, message, Toast.LENGTH_SHORT);
//        toast.setGravity(Gravity.TOP,0,0);
//        toast.show();
//    }
}
