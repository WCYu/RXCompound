package com.rxjy.rxcompound.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2017/2/16.
 */
public class DownTimerButton extends android.support.v7.widget.AppCompatButton implements View.OnClickListener {

    private Context mContext;
    private OnClickListener mOnClickListener;
    private Timer mTimer; //调度器
    private TimerTask mTask;
    private long duration = 60000; //倒计时时长，默认为10秒
    private long temp_duration;
    private String clickBefore = "验证码"; //点击前
    private String clickAfter = "秒"; //点击后

    public DownTimerButton(Context context) {
        super(context);
        this.mContext = context;
        setOnClickListener(this);
    }

    public DownTimerButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        setOnClickListener(this);
    }

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {

            DownTimerButton.this.setText(temp_duration / 1000 + clickAfter);

            temp_duration -= 1000;

            //倒计时结束
            if (temp_duration < 0) {
                //设置可以点击
                DownTimerButton.this.setEnabled(true);
                DownTimerButton.this.setText(clickBefore);
                stopTimer();
            }
        }
    };

    @Override
    public void setOnClickListener(OnClickListener onClickListener) {//提供外部访问方法
        if (onClickListener instanceof DownTimerButton) {
            super.setOnClickListener(onClickListener);
        }else{
            this.mOnClickListener = onClickListener;
        }
    }

    @Override
    public void onClick(View view) {
        if (mOnClickListener != null) {
            mOnClickListener.onClick(view);
        }
        switch (isclick){
            case 1:
                isclick=0;
                startTimer();
                break;
            default:
                break;
        }
    }

    //计时开始
    private void startTimer() {
        temp_duration = duration;
        //设置按钮不可点击
        DownTimerButton.this.setEnabled(false);
        mTimer = new Timer();
        mTask = new TimerTask() {
            @Override
            public void run() {
                mHandler.sendEmptyMessage(0x01);
            }
        };
        mTimer.schedule(mTask, 0, 1000);  //调度分配，延时0秒，时间间隔1秒
    }

    //计时结束
    private void stopTimer() {
        if (mTask != null) {
            mTask.cancel();
            mTask = null;
        }
        if (mTimer != null) {
            mTimer.cancel();
            mTimer = null;
        }
    }

    public static int isclick;

    public static int getIsclick() {
        return isclick;
    }

    public static void setIsclick(int isclick) {
        DownTimerButton.isclick = isclick;
    }
}
