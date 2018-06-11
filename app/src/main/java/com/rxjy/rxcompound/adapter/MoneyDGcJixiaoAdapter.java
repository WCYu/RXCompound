package com.rxjy.rxcompound.adapter;

import android.content.Context;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.base.SingleBaseAdapter;
import com.rxjy.rxcompound.commons.base.SingleViewHolder;
import com.rxjy.rxcompound.commons.utils.StringUtils;
import com.rxjy.rxcompound.entity.MoneyDGcJixiaoBean;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/3/20.
 */

public class MoneyDGcJixiaoAdapter extends SingleBaseAdapter<MoneyDGcJixiaoBean.BodyBean, MoneyDGcJixiaoAdapter.ViewHolder> {


    public MoneyDGcJixiaoAdapter(Context context, List<MoneyDGcJixiaoBean.BodyBean> datas) {
        super(context, datas);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.widget_tzmoneyone;
    }

    @Override
    public ViewHolder initViewHolder() {
        return new ViewHolder();
    }

    @Override
    public void onBindView(int position, MoneyDGcJixiaoBean.BodyBean data, ViewHolder holder) {
        holder.tvTitle.setText(data.getProname());
        holder.tvOne.setText("单号 "+data.getOrderNo());

        int money=data.getAmount().intValue();
        String moneystr="金额 "+ StringUtils.getPrettyNumber(""+data.getAmount());
        int size=moneystr.length();
        SpannableStringBuilder style=new SpannableStringBuilder("金额 "+ StringUtils.getPrettyNumber(""+data.getAmount()));
        if(money>=0){
            style.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.colorPrimarys)), 3, size, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }else{
            style.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.textred)), 3, size, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        holder.tvFour.setText(style);
        holder.tvTwo.setVisibility(View.GONE);
        holder.tvThree.setVisibility(View.GONE);
        holder.tvFive.setVisibility(View.GONE);
        holder.tvSix.setVisibility(View.GONE);
        holder.tvSeven.setVisibility(View.GONE);
    }

    class ViewHolder implements SingleViewHolder {
        @Bind(R.id.tv_title)
        TextView tvTitle;
        @Bind(R.id.tv_one)
        TextView tvOne;
        @Bind(R.id.tv_two)
        TextView tvTwo;
        @Bind(R.id.tv_three)
        TextView tvThree;
        @Bind(R.id.tv_four)
        TextView tvFour;
        @Bind(R.id.tv_five)
        TextView tvFive;
        @Bind(R.id.tv_six)
        TextView tvSix;
        @Bind(R.id.tv_seven)
        TextView tvSeven;

        @Override
        public void onInFlate(View v) {
            ButterKnife.bind(this, v);
        }
    }
}
