package com.rxjy.rxcompound.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.base.SingleBaseAdapter;
import com.rxjy.rxcompound.commons.base.SingleViewHolder;
import com.rxjy.rxcompound.commons.utils.StringUtils;
import com.rxjy.rxcompound.entity.MoneyBusHisBean;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by hjh on 2018/4/11.
 */

public class MoneyDBusHisAdapter extends SingleBaseAdapter<MoneyBusHisBean.Body, MoneyDBusHisAdapter.ViewHolder> {


    public MoneyDBusHisAdapter(Context context, List<MoneyBusHisBean.Body> datas) {
        super(context, datas);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.item_txtlist;
    }

    @Override
    public MoneyDBusHisAdapter.ViewHolder initViewHolder() {
        return new MoneyDBusHisAdapter.ViewHolder();
    }


    @Override
    public void onBindView(int position, MoneyBusHisBean.Body data, MoneyDBusHisAdapter.ViewHolder holder) {
        holder.tvOne.setText(data.getMonth()+"月");
        holder.tvTwo.setText(StringUtils.getPrettyNumber(data.getWages()));
        holder.tvThree.setText(StringUtils.getPrettyNumber(data.getTiCheng()));
//        int money = data.getSubSidyMoney().intValue();
//        if (money >= 0) {
//            holder.tvFour.setTextColor(context.getResources().getColor(R.color.colorPrimarys));
//        } else {
//            holder.tvFour.setTextColor(context.getResources().getColor(R.color.textred));
//        }
        holder.tvFour.setText(StringUtils.getPrettyNumber(data.getZongHe()));
        holder.tvFive.setText(StringUtils.getPrettyNumber(data.getShengYu()));
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