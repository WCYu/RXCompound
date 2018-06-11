package com.rxjy.rxcompound.business.adapter;


import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.business.entity.WalletBean;
import com.rxjy.rxcompound.commons.base.SingleBaseAdapter;
import com.rxjy.rxcompound.commons.base.SingleViewHolder;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by hjh on 2017/11/30.
 */

public class WalletAdapter extends SingleBaseAdapter<WalletBean.ListBean, WalletAdapter.ViewHolder> {

    int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public WalletAdapter(Context context, List<WalletBean.ListBean> datas) {
        super(context, datas);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.item_wallet;
    }

    @Override
    public ViewHolder initViewHolder() {
        return new ViewHolder();
    }

    @Override
    public void onBindView(int position, WalletBean.ListBean data, ViewHolder holder) {
        holder.tvTitle.setText(data.getMingCheng());
        holder.tvMoney.setText(data.getShouRuJinE()+"");
        holder.tvNume.setText(data.getShuLiang()+"次");
        holder.tvComputations.setText(data.getDan()+"×"+data.getShuLiang());
        switch (data.getType()){
            case 1:
                holder.ivType.setImageResource(R.drawable.ic_visitvalidity);
                break;
            case 2:
                holder.ivType.setImageResource(R.drawable.ic_personvisit);
                break;
            case 3:
                holder.ivType.setImageResource(R.drawable.ic_lhouse);
                break;
            case 4:
                holder.ivType.setImageResource(R.drawable.ic_event);
                break;
            case 5:
                holder.ivType.setImageResource(R.drawable.ic_personnum);
                break;
            case 6:
                holder.ivType.setImageResource(R.drawable.ic_personvisitno);
                break;
            case 7:
                holder.ivType.setImageResource(R.drawable.ic_lhouse);
                break;
            case 8:
                holder.ivType.setImageResource(R.drawable.ic_visitvalidityall);
                break;
            case 9:
                holder.ivType.setImageResource(R.drawable.ic_lhouseteam);
                break;
            case 10:
                holder.ivType.setImageResource(R.drawable.ic_personmanag);
                break;
            case 11:
                holder.ivType.setImageResource(R.drawable.ic_rewards);
                break;
            case 12:
                holder.ivType.setImageResource(R.drawable.ic_coopervalidity);
                break;

        }

    }

    class ViewHolder implements SingleViewHolder {
        @Bind(R.id.iv_type)
        ImageView ivType;
        @Bind(R.id.tv_title)
        TextView tvTitle;
        @Bind(R.id.tv_money)
        TextView tvMoney;
        @Bind(R.id.tv_nume)
        TextView tvNume;
        @Bind(R.id.tv_computations)
        TextView tvComputations;

        @Override
        public void onInFlate(View v) {
            ButterKnife.bind(this, v);
        }
    }

}
