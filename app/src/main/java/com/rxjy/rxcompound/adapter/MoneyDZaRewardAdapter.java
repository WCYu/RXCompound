package com.rxjy.rxcompound.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.base.SingleBaseAdapter;
import com.rxjy.rxcompound.commons.base.SingleViewHolder;
import com.rxjy.rxcompound.commons.utils.StringUtils;
import com.rxjy.rxcompound.entity.MoneyDZaRewardBean;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/3/19.
 */

public class MoneyDZaRewardAdapter extends SingleBaseAdapter<MoneyDZaRewardBean.BodyBean,MoneyDZaRewardAdapter.ViewHolder>{

    public MoneyDZaRewardAdapter(Context context, List<MoneyDZaRewardBean.BodyBean> datas) {
        super(context, datas);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.item_txtlist;
    }

    @Override
    public ViewHolder initViewHolder() {
        return new ViewHolder();
    }

    @Override
    public void onBindView(int position, MoneyDZaRewardBean.BodyBean data, ViewHolder holder) {
        holder.tvOne.setText(data.getRpupdateTime());
        holder.tvTwo.setText(data.getRpRemarks());
        int money=data.getRpActualMoney().intValue();
        if(money>=0){
            holder.tvThree.setTextColor(context.getResources().getColor(R.color.colorPrimarys));
        }else{
            holder.tvThree.setTextColor(context.getResources().getColor(R.color.textred));
        }
        holder.tvThree.setText(StringUtils.getPrettyNumber(data.getRpActualMoney()+""));
        holder.tvFour.setText(data.getRpSponsorName());
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