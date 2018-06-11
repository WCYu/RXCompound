package com.rxjy.rxcompound.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.utils.StringUtils;
import com.rxjy.rxcompound.entity.TaskListBean;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by hjh on 2018/4/27.
 */

public class TaskNewActivity extends BaseActivity {

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_theme)
    TextView tvTheme;
    @Bind(R.id.tv_reward)
    TextView tvReward;
    @Bind(R.id.tv_taskdesc)
    TextView tvTaskdesc;
    @Bind(R.id.tv_data)
    TextView tvData;
    @Bind(R.id.tv_addperson)
    TextView tvAddperson;

    TaskListBean.Body taskdata;
    @Bind(R.id.tv_timesecound)
    TextView tvTimesecound;
    @Bind(R.id.tv_min)
    TextView tvMin;
    @Bind(R.id.tv_hour)
    TextView tvHour;

    String t_hour = "";
    String t_min = "";
    String t_secound = "";
    int timemiao;
    int recLen = 0;
    Handler handler;
    @Bind(R.id.tv_miao1)
    TextView tvMiao1;
    @Bind(R.id.tv_miao2)
    TextView tvMiao2;

    @Override
    public int getLayout() {
        return R.layout.activity_taskdetailsnew;
    }


    CountDownTimer timers;

    @Override
    public void initData() {
        tvTitle.setText("任务");
        Intent intent = getIntent();
        taskdata = (TaskListBean.Body) intent.getSerializableExtra("task");
        tvTheme.setText(taskdata.getT_theme());
        tvTaskdesc.setText(taskdata.getT_describe());
        tvData.setText("截止 " + taskdata.getEndTimeStr());
        tvAddperson.setText(taskdata.getAddname());

        String timegets = taskdata.getEndTimeStr();
//        String timegets="2018-04-28 11:21:00";

        timemiao = StringUtils.getTimeMiaoCha(timegets);
        switch (StringUtils.CompareTime(timegets)) {
            case 2://超时或相同（正计时）
                recLen = timemiao * 1000;
                RightTime();
                break;
            default:
                DownTime();
                break;
        }
    }


    private void DownTime() {//倒计时
        tvHour.setBackgroundResource(R.drawable.corner_green);
        tvMin.setBackgroundResource(R.drawable.corner_green);
        tvTimesecound.setBackgroundResource(R.drawable.corner_green);
        tvReward.setText("￥ " + taskdata.getT_money());
        tvReward.setTextColor(getResources().getColor(R.color.textgreen));
        timers = new CountDownTimer(timemiao * 1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                long hour = millisUntilFinished / (1000 * 60 * 60);//时
                long min = (millisUntilFinished - hour * (1000 * 60 * 60)) / (1000 * 60);
                long second = (millisUntilFinished - hour * (1000 * 60 * 60) - min * (1000 * 60)) / 1000;//秒

                t_hour = String.valueOf(hour);
                t_min = String.valueOf(min);
                t_secound = String.valueOf(second);
                if (t_hour.length() == 1) {
                    t_hour = "0" + t_hour;
                }
                if (t_min.length() == 1) {
                    t_min = "0" + t_min;
                }
                if (t_secound.length() == 1) {
                    t_secound = "0" + t_secound;
                }
                tvHour.setText(t_hour);
                tvMin.setText(t_min);
                tvTimesecound.setText(t_secound);
            }

            @Override
            public void onFinish() {
                //倒计时为0时开始正计时
//                tvHour.setText("00");
//                tvMin.setText("00");
//                tvTimesecound.setText("00");
                /**
                 * 开始正计时
                 */
                recLen = 0;
                RightTime();
            }
        };
        timers.start();
    }


    Runnable runnable;

    private void RightTime() {//正计时
        tvHour.setBackgroundResource(R.drawable.corner_red);
        tvMin.setBackgroundResource(R.drawable.corner_red);
        tvTimesecound.setBackgroundResource(R.drawable.corner_red);
        tvReward.setText("￥ 0");
        tvReward.setTextColor(getResources().getColor(R.color.text_blackfour));
        tvHour.setVisibility(View.GONE);
        tvMin.setVisibility(View.GONE);
        tvMiao1.setVisibility(View.GONE);
        tvMiao2.setVisibility(View.GONE);
        tvTimesecound.setText("任务到期");
//        handler = new Handler();
//        runnable = new Runnable() {
//            @Override
//            public void run() {
//                int hours = recLen / (1000 * 60 * 60);//时
//                int mins = (recLen - hours * (1000 * 60 * 60)) / (1000 * 60);
//                int seconds = (recLen - hours * (1000 * 60 * 60) - mins * (1000 * 60)) / 1000;//秒
//                t_hour = String.valueOf(hours);
//                t_min = String.valueOf(mins);
//                t_secound = String.valueOf(seconds);
//                if (t_hour.length() == 1) {
//                    t_hour = "0" + t_hour;
//                }
//                if (t_min.length() == 1) {
//                    t_min = "0" + t_min;
//                }
//                if (t_secound.length() == 1) {
//                    t_secound = "0" + t_secound;
//                }
//                tvHour.setText(t_hour);
//                tvMin.setText(t_min);
//                tvTimesecound.setText(t_secound);
//                recLen=recLen+1000;
//                handler.postDelayed(this, 1000);
//            }
//        };
//        handler.postDelayed(runnable, 1000);
    }


    @Override
    protected BasePresenter onCreatePresenter() {
        return null;
    }


    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        if (timers != null) {
            timers.cancel();
        }
        if (handler != null) {
            handler.removeCallbacks(runnable);
        }
        finish();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (timers != null) {
                timers.cancel();
            }
            if (handler != null) {
                handler.removeCallbacks(runnable);
            }
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}