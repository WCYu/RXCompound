package com.rxjy.rxcompound.supervision.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.base.SingleBaseAdapter;
import com.rxjy.rxcompound.commons.base.SingleViewHolder;
import com.rxjy.rxcompound.supervision.entity.ProListInfo;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by AAA on 2017/12/15.
 */

public class ProListAdapter extends SingleBaseAdapter<ProListInfo.ProList, ProListAdapter.ViewHolder> {

    public ProListAdapter(Context context, List<ProListInfo.ProList> datas) {
        super(context, datas);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.list_item_pro_list;
    }

    @Override
    public ViewHolder initViewHolder() {
        return new ViewHolder();
    }

    @Override
    public void onBindView(int position, ProListInfo.ProList data, ViewHolder holder) {
        holder.tvPosition.setText((position + 1) + "");
        holder.tvName.setText(data.getItem_name());
        holder.tvListUnit.setText(data.getQuantities() + data.getUnit());
    }

    class ViewHolder implements SingleViewHolder {
        @Bind(R.id.tv_list_item_pro_list_position)
        TextView tvPosition;
        @Bind(R.id.tv_list_item_pro_list_name)
        TextView tvName;
        @Bind(R.id.tv_list_item_pro_list_quantities)
        TextView tvQuantities;
        @Bind(R.id.tv_list_item_pro_list_unit)
        TextView tvListUnit;

        @Override
        public void onInFlate(View v) {
            ButterKnife.bind(this, v);
        }
    }
}
