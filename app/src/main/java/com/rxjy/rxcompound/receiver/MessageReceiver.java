package com.rxjy.rxcompound.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import com.rxjy.rxcompound.activity.EnterJobActivity;
import com.rxjy.rxcompound.activity.IdentityInfoActivity;
import com.rxjy.rxcompound.activity.IdentityInfoNewActivity;
import com.rxjy.rxcompound.activity.InformMessageActivity;
import com.rxjy.rxcompound.activity.MainTabHostActivity;
import com.rxjy.rxcompound.activity.MessageDetailsActivity;
import com.rxjy.rxcompound.activity.MessageTwoActivity;
import com.rxjy.rxcompound.activity.ZThreeActivity;
import com.rxjy.rxcompound.business.activity.BusinessMainHostActivity;
import com.rxjy.rxcompound.commons.App;
import com.rxjy.rxcompound.commons.utils.JSONUtils;
import com.rxjy.rxcompound.commons.utils.StringUtils;
import com.rxjy.rxcompound.des.activity.NjjActivity;
import com.rxjy.rxcompound.entity.NoticBean;
import com.rxjy.rxcompound.supervision.activity.SupervisionMainActivity;

import cn.jpush.android.api.JPushInterface;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by hjh on 2018/3/7.
 */

public class MessageReceiver extends BroadcastReceiver {

    private static final String TAG = "JPush";

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        Log.e(TAG, "[MyReceiver] onReceive - " + intent.getAction() + ", extras: " + bundle.toString());

        if (JPushInterface.ACTION_REGISTRATION_ID.equals(intent.getAction())) {
            String regId = bundle.getString(JPushInterface.EXTRA_REGISTRATION_ID);
            Log.e(TAG, "[MyReceiver] 接收Registration Id : " + regId);
            //send the Registration Id to your server...

        } else if (JPushInterface.ACTION_MESSAGE_RECEIVED.equals(intent.getAction())) {
            Log.e(TAG, "[MyReceiver] 接收到推送下来的自定义消息: " + bundle.getString(JPushInterface.EXTRA_MESSAGE));
//            processCustomMessage(context, bundle);

        } else if (JPushInterface.ACTION_NOTIFICATION_RECEIVED.equals(intent.getAction())) {
            Log.e(TAG, "[MyReceiver] 接收到推送下来的通知");
            int notifactionId = bundle.getInt(JPushInterface.EXTRA_NOTIFICATION_ID);
            String contentstr = bundle.getString(JPushInterface.EXTRA_ALERT);
            String extras = bundle.getString(JPushInterface.EXTRA_EXTRA);
            Log.e(TAG + "接收到的推送数据是：：", contentstr);
            Log.e(TAG + "接收到的推送数据是：：", extras);
            Log.e(TAG, "[MyReceiver] 接收到推送下来的通知的ID: " + notifactionId);
            //接受到推送就底部icon加一
            SetIconMsgNum(context);

        } else if (JPushInterface.ACTION_NOTIFICATION_OPENED.equals(intent.getAction())) {
            Log.e(TAG, "[MyReceiver] 用户点击打开了通知");
            String extras = bundle.getString(JPushInterface.EXTRA_EXTRA);
            NoticBean info = JSONUtils.toObject(extras, NoticBean.class);
            int type = Integer.parseInt(info.getType());

            switch (type) {
                case 1:
                    context.startActivity(new Intent(context, IdentityInfoNewActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                    break;
                case 2:
                    context.startActivity(new Intent(context, IdentityInfoNewActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                    break;
                case 3:
                    context.startActivity(new Intent(context, ZThreeActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                    break;
                default:
                    context.startActivity(new Intent(context, MessageDetailsActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK).putExtra("id", info.getID()));
                    break;

            }

//
//          //打开自定义的Activity
//          Intent i = new Intent(context, TestActivity.class);
//          i.putExtras(bundle);
//          //i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//          i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP );
//          context.startActivity(i);

        } else if (JPushInterface.ACTION_RICHPUSH_CALLBACK.equals(intent.getAction())) {
            Log.e(TAG, "[MyReceiver] 用户收到到RICH PUSH CALLBACK: " + bundle.getString(JPushInterface.EXTRA_EXTRA));
            //在这里根据 JPushInterface.EXTRA_EXTRA 的内容处理代码，比如打开新的Activity， 打开一个网页等..

        } else if (JPushInterface.ACTION_CONNECTION_CHANGE.equals(intent.getAction())) {
            boolean connected = intent.getBooleanExtra(JPushInterface.EXTRA_CONNECTION_CHANGE, false);
            Log.e(TAG, "[MyReceiver]" + intent.getAction() + " connected state change to " + connected);
        } else {
            Log.e(TAG, "[MyReceiver] Unhandled intent - " + intent.getAction());
        }
    }


    public static String MSG_NUM = App.cardNo + "MSG_NUM";
    public static String msgnum = "msgnum";

    private void SetIconMsgNum(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(MSG_NUM, MODE_PRIVATE);
        int num = preferences.getInt(msgnum, 0);
        num = num + 1;
        preferences.edit().putInt(msgnum, num).commit();
        switch (App.apptype) {
            case 2://商务
                /**
                 * 跳转商务在职
                 */
                BusinessMainHostActivity.activity.ShowMsgNum(num);
                break;
            case 3://温特斯
                /**
                 * 跳转温特斯
                 */
                NjjActivity.activity.ShowMsgNum(num);
                break;
            case 4://项目监理
                SupervisionMainActivity.activity.ShowMsgNum(num);
                break;
            default://瑞祥平台
                MainTabHostActivity.SetMsgNum(num);
                break;
        }

    }

}