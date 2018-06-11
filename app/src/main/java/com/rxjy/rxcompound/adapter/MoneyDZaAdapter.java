package com.rxjy.rxcompound.adapter;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.base.SingleBaseAdapter;
import com.rxjy.rxcompound.commons.base.SingleViewHolder;
import com.rxjy.rxcompound.commons.utils.StringUtils;
import com.rxjy.rxcompound.entity.MoneyDZaProcessBean;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by hjh on 2018/3/19.
 */

public class MoneyDZaAdapter extends SingleBaseAdapter<MoneyDZaProcessBean.BodyBean, MoneyDZaAdapter.ViewHolder> {



    public MoneyDZaAdapter(Context context, List<MoneyDZaProcessBean.BodyBean> datas) {
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
    public void onBindView(int position, MoneyDZaProcessBean.BodyBean data, ViewHolder holder) {
        holder.llBottom.setVisibility(View.VISIBLE);
        holder.tvStatus.setText(data.getResult());
        holder.tvTitle.setText(data.getClientName());
        holder.tvTitleone.setText("预收");
        holder.tvContentone.setText(StringUtils.getPrettyNumber(data.getOrdersPreCollection() + ""));
        holder.tvTitletwo.setText("已收");
        holder.tvContenttwo.setText(StringUtils.getPrettyNumber(data.getAlreadyPaid() + ""));
        holder.tvTitlethree.setText("本月");
        holder.tvContentthree.setText(StringUtils.getPrettyNumber(data.getShouldPaid() + ""));
        int benyuemoney = data.getShouldPaid().intValue();
        if (benyuemoney >= 0) {
            holder.tvContentthree.setTextColor(context.getResources().getColor(R.color.colorPrimarys));
        } else {
            holder.tvContentthree.setTextColor(context.getResources().getColor(R.color.textred));
        }

        holder.tvContentbone.setText(StringUtils.getPrettyNumber(data.getOrderIncome() + ""));
        holder.tvContentbtwo.setText(StringUtils.getPrettyNumber(data.getProgrammeIncome() + ""));
        holder.tvContentbthree.setText(StringUtils.getPrettyNumber(data.getNegotiateIncome() + ""));
        holder.tvContentbfour.setText(StringUtils.getPrettyNumber(data.getBudgetIncome() + ""));
        holder.tvContentbfive.setText(StringUtils.getPrettyNumber(data.getContractIncome() + ""));
        holder.tvContentbsix.setText(StringUtils.getPrettyNumber(data.getProcessSubsidy() + ""));
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
        @Bind(R.id.ll_bone)
        LinearLayout llBone;
        @Bind(R.id.tv_contentbone)
        TextView tvContentbone;
        @Bind(R.id.tv_contentbtwo)
        TextView tvContentbtwo;
        @Bind(R.id.ll_btwo)
        LinearLayout llBtwo;
        @Bind(R.id.tv_contentbthree)
        TextView tvContentbthree;
        @Bind(R.id.ll_bthree)
        LinearLayout llBthree;
        @Bind(R.id.tv_contentbfour)
        TextView tvContentbfour;
        @Bind(R.id.ll_bfour)
        LinearLayout llBfour;
        @Bind(R.id.tv_contentbfive)
        TextView tvContentbfive;
        @Bind(R.id.ll_bfive)
        LinearLayout llBfive;
        @Bind(R.id.tv_contentbsix)
        TextView tvContentbsix;
        @Bind(R.id.ll_bsix)
        LinearLayout llBsix;
        @Bind(R.id.ll_bottom)
        LinearLayout llBottom;
        @Bind(R.id.tv_status)
        TextView tvStatus;

        @Override
        public void onInFlate(View v) {
            ButterKnife.bind(this, v);
        }
    }
}
