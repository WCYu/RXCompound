package com.rxjy.rxcompound.utils;

import android.app.AlertDialog;

import com.rxjy.rxcompound.commons.App;

/**
 * Created by 阿禹 on 2018/6/19.
 */

public class PromptDialog {

    public AlertDialog alertDialog;

    public PromptDialog() {
        this.alertDialog = new AlertDialog.Builder(App.context).create();
        this.alertDialog = alertDialog;
    }

    public static PromptDialog getInstenct(){
        return new PromptDialog();
    }

    public void showDialog(String message){
       alertDialog.setMessage(message);
       alertDialog.show();
    }
}
