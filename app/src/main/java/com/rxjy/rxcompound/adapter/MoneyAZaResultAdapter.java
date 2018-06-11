package com.rxjy.rxcompound.adapter;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.base.SingleBaseAdapter;
import com.rxjy.rxcompound.commons.base.SingleViewHolder;
import com.rxjy.rxcompound.commons.utils.StringUtils;
import com.rxjy.rxcompound.entity.MoneyDZaResultBean;

import java.math.BigDecimal;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by hjh on 2018/3/19.
 */

public class MoneyAZaResultAdapter extends SingleBaseAdapter<MoneyDZaResultBean.BodyBean,MoneyAZaResultAdapter.ViewHolder>{

    public MoneyAZaResultAdapter(Context context, List<MoneyDZaResultBean.BodyBean> datas) {
        super(context, datas);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.widget_zamoney;
    }

    @Override
    public ViewHolder initViewHolder() {
        return new ViewHolder();
    }

    @Override
    public void onBindView(int position, MoneyDZaResultBean.BodyBean data, ViewHolder holder) {
        holder.tvTitle.setText(data.getClientName());
        holder.tvTitleone.setText("预收");
        holder.tvContentone.setText(StringUtils.getPrettyNumber(data.getOrdersPreCollection()+""));
        holder.tvTitletwo.setText("已收");
        holder.tvContenttwo.setText(StringUtils.getPrettyNumber(data.getAlreadyPay()+""));
        holder.tvTitlethree.setText("本月");
        BigDecimal benyue=data.getOrdersPreCollection().subtract(data.getAlreadyPay());
        holder.tvContentthree.setText(StringUtils.getPrettyNumber(benyue+""));
        holder.tvContentthree.setTextColor(context.getResources().getColor(R.color.colorPrimarys));
    }

    class ViewHolder implements SingleViewHolder {
        @Bind(R.id.tv_title)
        TextView tvTitle;
        @Bind(R.id.tv_titleone)
        TextView tvTitleone;
        @Bind(R.id.tv_contentone)
        TextView tvContentone;
        @Bind(R.id.tv_titletwo)
        TextView tvTitletwo;
        @Bind(R.id.tv_contenttwo)
        TextView tvContenttwo;
        @Bind(R.id.tv_titlethree)
        TextView tvTitlethree;
        @Bind(R.id.tv_contentthree)
        TextView tvContentthree;
        @Bind(R.id.tv_titlefour)
        TextView tvTitlefour;
        @Bind(R.id.tv_contentfour)
        TextView tvContentfour;
        @Bind(R.id.ll_four)
        LinearLayout llFour;
        @Override
        public void onInFlate(View v) {
            ButterKnife.bind(this, v);
        }
    }

}