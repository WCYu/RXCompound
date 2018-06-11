package com.rxjy.rxcompound.adapter;

import android.content.Context;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.base.SingleBaseAdapter;
import com.rxjy.rxcompound.commons.base.SingleViewHolder;
import com.rxjy.rxcompound.commons.utils.StringUtils;
import com.rxjy.rxcompound.entity.AdRedEnvelopesBean;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/5/9.
 */

public class AdTaskAdaper extends SingleBaseAdapter<AdRedEnvelopesBean.BodyBean, AdTaskAdaper.ViewHolder> {
    int recLen = 0;
    String t_hour = "";
    String t_min = "";
    String t_secound = "";
    Handler handler;


    public AdTaskAdaper(Context context, List<AdRedEnvelopesBean.BodyBean> datas) {
        super(context, datas);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.activity_red_list_item;
    }

    @Override
    public ViewHolder initViewHolder() {
        return new ViewHolder();
    }

    @Override
    public void onBindView(int position, AdRedEnvelopesBean.BodyBean data, final ViewHolder holder) {

        holder.llView.setVisibility(View.VISIBLE);
        holder.tvTasktitle.setText(data.getTwo_level() + " " + data.getTask_num());
        holder.allowance.setText(data.getTask_balance());
        holder.tvPerson.setText("内容：" + data.getContent_total());
        holder.tvReward.setText("￥ " + data.getTask_award());
        String count_down = data.getCount_down();
        String timegets = data.getExecute_time();
        int timemiao = StringUtils.getTimeMiaoCha(timegets);
        switch (StringUtils.CompareTime(timegets)) {
            case 2://超时或相同（正计时）
                holder.tvReward.setText("￥ 0");
                holder.tvReward.setTextColor(context.getResources().getColor(R.color.text_blackfour));
                holder.tvHour.setVisibility(View.GONE);
                holder.tvMin.setVisibility(View.GONE);
                holder.tvMiao1.setVisibility(View.GONE);
                holder.tvMiao2.setVisibility(View.GONE);
                holder.tvTimesecound.setText("任务到期");
                holder.tvTimesecound.setBackgroundResource(R.drawable.corner_red);
                break;
            default:
                /**
                 * 倒计时
                 */
                holder.tvReward.setText("￥ " + StringUtils.getPrettyNumber(data.getTask_award() + ""));
                holder.tvReward.setTextColor(context.getResources().getColor(R.color.textgreen));
                CountDownTimer timer = new CountDownTimer(timemiao * 1000, 1000) {
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
                        holder.tvHour.setText(t_hour);
                        holder.tvMin.setText(t_min);
                        holder.tvTimesecound.setText(t_secound);
                        holder.tvHour.setBackgroundResource(R.drawable.corner_green);
                        holder.tvMin.setBackgroundResource(R.drawable.corner_green);
                        holder.tvTimesecound.setBackgroundResource(R.drawable.corner_green);
                    }

                    @Override
                    public void onFinish() {
                        //倒计时为0时开始正计时
                        holder.tvReward.setText("￥ 0");
                        holder.tvReward.setTextColor(context.getResources().getColor(R.color.text_blackfour));
                        holder.tvHour.setVisibility(View.GONE);
                        holder.tvMin.setVisibility(View.GONE);
                        holder.tvMiao1.setVisibility(View.GONE);
                        holder.tvMiao2.setVisibility(View.GONE);
                        holder.tvTimesecound.setText("任务到期");
                        holder.tvTimesecound.setBackgroundResource(R.drawable.corner_red);
                    }
                };
                timer.start();
                break;
        }
    }

    public class ViewHolder implements SingleViewHolder {

        @Bind(R.id.tv_tasktitle)
        TextView tvTasktitle;
        @Bind(R.id.tv_person)
        TextView tvPerson;
        @Bind(R.id.tv_reward)
        TextView tvReward;
        @Bind(R.id.ll_view)
        LinearLayout llView;
        @Bind(R.id.tv_timesecound)
        TextView tvTimesecound;

        @Bind(R.id.tv_miao1)
        TextView tvMiao1;
        @Bind(R.id.tv_min)
        TextView tvMin;
        @Bind(R.id.tv_miao2)
        TextView tvMiao2;
        @Bind(R.id.tv_hour)
        TextView tvHour;
        @Bind(R.id.tv_content)
        TextView tvContent;
        @Bind(R.id.allowance)
        TextView allowance;
        @Override
        public void onInFlate(View v) {
            ButterKnife.bind(this, v);
        }
    }
    //tv_person
}
