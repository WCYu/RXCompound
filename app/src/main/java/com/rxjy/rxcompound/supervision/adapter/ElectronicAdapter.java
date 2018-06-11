package com.rxjy.rxcompound.supervision.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.base.SingleBaseAdapter;
import com.rxjy.rxcompound.commons.base.SingleViewHolder;
import com.rxjy.rxcompound.supervision.entity.DatumListInfo;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by AAA on 2017/12/21.
 */

public class ElectronicAdapter extends SingleBaseAdapter<DatumListInfo.DatumInfo.Datum, ElectronicAdapter.ViewHolder> {

    public ElectronicAdapter(Context context, List<DatumListInfo.DatumInfo.Datum> datas) {
        super(context, datas);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.list_item_electronic;
    }

    @Override
    public ViewHolder initViewHolder() {
        return new ViewHolder();
    }

    @Override
    public void onBindView(int position, DatumListInfo.DatumInfo.Datum data, ViewHolder holder) {
        holder.tvElectronic.setText(data.getAttr_name());
        if (data.getConfirm_status() == 5) {
            holder.tvElectronicState.setText("已推送");
            holder.tvElectronicState.setTextColor(context.getResources().getColor(R.color.colorGreen));
        } else {
            holder.tvElectronicState.setText("未推送");
            holder.tvElectronicState.setTextColor(context.getResources().getColor(R.color.colorRedLight));
        }
    }

    class ViewHolder implements SingleViewHolder {
        @Bind(R.id.tv_electronic)
        TextView tvElectronic;
        @Bind(R.id.tv_electronic_state)
        TextView tvElectronicState;

        @Override
        public void onInFlate(View v) {
            ButterKnife.bind(this, v);
        }
    }
}
