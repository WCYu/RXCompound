package com.rxjy.rxcompound.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.base.SingleBaseAdapter;
import com.rxjy.rxcompound.commons.base.SingleViewHolder;
import com.rxjy.rxcompound.entity.BusMoneyBean;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by hjh on 2018/3/23.
 */

public class MoneyDBusAdapter extends SingleBaseAdapter<BusMoneyBean.BodyBean, MoneyDBusAdapter.ViewHolder> {


    public MoneyDBusAdapter(Context context, List<BusMoneyBean.BodyBean> datas) {
        super(context, datas);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.item_txtlist;
    }

    @Override
    public MoneyDBusAdapter.ViewHolder initViewHolder() {
        return new MoneyDBusAdapter.ViewHolder();
    }

    @Override
    public void onBindView(int position, BusMoneyBean.BodyBean data, MoneyDBusAdapter.ViewHolder holder) {
        holder.tvOne.setText(data.getCtime());
        holder.tvTwo.setText(data.getReason());
        holder.tvThree.setText(data.getRemark());
        int money=data.getSubSidyMoney().intValue();
        if(money>=0){
            holder.tvFour.setTextColor(context.getResources().getColor(R.color.colorPrimarys));
        }else{
            holder.tvFour.setTextColor(context.getResources().getColor(R.color.textred));
        }
        holder.tvFour.setVisibility(View.GONE);
        holder.tvFive.setVisibility(View.GONE);
    }


    class ViewHolder implements SingleViewHolder {

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

        @Override
        public void onInFlate(View v) {
            ButterKnife.bind(this, v);
        }
    }
}