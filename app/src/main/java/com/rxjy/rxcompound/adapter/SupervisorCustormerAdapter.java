package com.rxjy.rxcompound.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.base.SingleBaseAdapter;
import com.rxjy.rxcompound.commons.base.SingleViewHolder;
import com.rxjy.rxcompound.entity.CustomerBean;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by asus on 2018/4/13.
 */

public class SupervisorCustormerAdapter extends SingleBaseAdapter<CustomerBean.BodyBean, SupervisorCustormerAdapter.ViewHolder> {




    public SupervisorCustormerAdapter(Context context, List<CustomerBean.BodyBean> datas) {
        super(context, datas);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.customer_item;
    }

    @Override
    public ViewHolder initViewHolder() {
        return new ViewHolder();
    }

    @Override
    public void onBindView(int position, CustomerBean.BodyBean data, ViewHolder holder) {
        holder.tvCompany.setText(data.getCi_DecorationAddress());
        holder.tvNumber.setText(data.getCi_SalesmanCard());

        holder.time.setText(data.getCa_MeasureDate().substring(0,10));
    }

    public class ViewHolder implements SingleViewHolder {
        @Bind(R.id.tv_company)
        TextView tvCompany;
        @Bind(R.id.tv_state)
        TextView tvState;
        @Bind(R.id.lv_number)
        TextView lvNumber;
        @Bind(R.id.tv_number)
        TextView tvNumber;
        @Bind(R.id.time)
        TextView time;
        @Override
        public void onInFlate(View v) {
            ButterKnife.bind(this, v);
        }
    }
}
