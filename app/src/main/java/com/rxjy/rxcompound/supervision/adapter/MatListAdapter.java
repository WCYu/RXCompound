package com.rxjy.rxcompound.supervision.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.base.SingleBaseAdapter;
import com.rxjy.rxcompound.commons.base.SingleViewHolder;
import com.rxjy.rxcompound.supervision.entity.MatListInfo;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by AAA on 2017/12/13.
 */

public class MatListAdapter extends SingleBaseAdapter<MatListInfo.MatInfo, MatListAdapter.ViewHolder> {

    public MatListAdapter(Context context, List<MatListInfo.MatInfo> datas) {
        super(context, datas);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.list_item_mat_list;
    }

    @Override
    public ViewHolder initViewHolder() {
        return new ViewHolder();
    }

    @Override
    public void onBindView(int position, MatListInfo.MatInfo data, ViewHolder holder) {
        holder.tvPosition.setText((position + 1) + "");
        holder.tvMatName.setText(data.getMatName());
        holder.tvBrand.setText(data.getBrandName());
        holder.tvSpec.setText(data.getMatSpec());
        holder.tvUnitCount.setText(data.getTotal() + "");
        if (data != null && data.getUnitName().equals("平方米"))
            holder.tvUnit.setText("㎡");
        else
            holder.tvUnit.setText(data.getUnitName());
    }

    class ViewHolder implements SingleViewHolder {
        @Bind(R.id.tv_list_item_mat_list_position)
        TextView tvPosition;
        @Bind(R.id.tv_list_item_mat_list_mat_name)
        TextView tvMatName;
        @Bind(R.id.tv_list_item_mat_list_brand)
        TextView tvBrand;
        @Bind(R.id.tv_list_item_mat_list_spec)
        TextView tvSpec;
        @Bind(R.id.tv_list_item_mat_list_unit)
        TextView tvUnit;
        @Bind(R.id.tv_list_item_mat_list_unit_count)
        TextView tvUnitCount;

        @Override
        public void onInFlate(View v) {
            ButterKnife.bind(this, v);
        }
    }
}
