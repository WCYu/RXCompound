package com.rxjy.rxcompound.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.base.SingleBaseAdapter;
import com.rxjy.rxcompound.commons.base.SingleViewHolder;
import com.rxjy.rxcompound.commons.utils.StringUtils;
import com.rxjy.rxcompound.entity.MoneyDBusJFKQMoreBean;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by hjh on 2018/4/12.
 */

public class MoneyDBusjfAdapter extends SingleBaseAdapter<MoneyDBusJFKQMoreBean.BodyBean, MoneyDBusjfAdapter.ViewHolder> {


    public MoneyDBusjfAdapter(Context context, List<MoneyDBusJFKQMoreBean.BodyBean> datas) {
        super(context, datas);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.item_moneybusjf;
    }

    @Override
    public ViewHolder initViewHolder() {
        return new ViewHolder();
    }

    @Override
    public void onBindView(int position, MoneyDBusJFKQMoreBean.BodyBean data, ViewHolder holder) {

        holder.tvTitle.setText(data.getName());
        holder.tvTime.setText(data.getTm());
        int money= data.getReward().intValue();
        if(money>=0){
            holder.tvMoney.setTextColor(context.getResources().getColor(R.color.textgreen));
        }else {
            holder.tvMoney.setTextColor(context.getResources().getColor(R.color.textred));
        }
        holder.tvMoney.setText(StringUtils.getPrettyNumber(data.getReward()+""));
        holder.tvPerson.setText(data.getOperater());
        holder.tvTip.setText("摘要"+data.getRemark());

    }

    class ViewHolder implements SingleViewHolder {

        @Bind(R.id.iv_shu)
        ImageView ivShu;
        @Bind(R.id.tv_title)
        TextView tvTitle;
        @Bind(R.id.tv_time)
        TextView tvTime;
        @Bind(R.id.tv_money)
        TextView tvMoney;
        @Bind(R.id.tv_person)
        TextView tvPerson;
        @Bind(R.id.tv_tip)
        TextView tvTip;

        @Override
        public void onInFlate(View v) {
            ButterKnife.bind(this, v);
        }
    }
}
