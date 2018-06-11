package com.rxjy.rxcompound.supervision.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.base.SingleBaseAdapter;
import com.rxjy.rxcompound.commons.base.SingleViewHolder;
import com.rxjy.rxcompound.supervision.entity.AuditListInfo;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by AAA on 2017/12/14.
 */

public class AuditAdapter extends SingleBaseAdapter<AuditListInfo.AuditList.AuditInfo, AuditAdapter.ViewHolder> {

    public AuditAdapter(Context context, List<AuditListInfo.AuditList.AuditInfo> datas) {
        super(context, datas);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.list_item_audit;
    }

    @Override
    public ViewHolder initViewHolder() {
        return new ViewHolder();
    }

    @Override
    public void onBindView(int position, AuditListInfo.AuditList.AuditInfo data, ViewHolder holder) {
        holder.tvPosition.setText((position + 1) + "");
        holder.tvName.setText(data.getItem_name());
        holder.tvArea.setText(data.getArea_name());
        holder.tvUnit.setText(data.getUnit());
        holder.tvCount.setText(data.getCost_price_update() + "");
//        1:多项2:漏项3:多量 4:少量5:价高 6:价低
        switch (data.getItem_type()) {
            case 1:
                holder.ivState.setImageResource(R.mipmap.audit_multiterm_icon);
                break;
            case 2:
                holder.ivState.setImageResource(R.mipmap.audit_lack_icon);
                break;
            case 3:
                holder.ivState.setImageResource(R.mipmap.audit_more_icon);
                break;
            case 4:
                holder.ivState.setImageResource(R.mipmap.audit_few_icon);
                break;
            case 5:
                holder.ivState.setImageResource(R.mipmap.audit_more_price_icon);
                break;
            case 6:
                holder.ivState.setImageResource(R.mipmap.audit_few_price_icon);
                break;
        }
    }

    class ViewHolder implements SingleViewHolder {
        @Bind(R.id.tv_list_item_audit_position)
        TextView tvPosition;
        @Bind(R.id.tv_list_item_audit_name)
        TextView tvName;
        @Bind(R.id.tv_list_item_audit_area)
        TextView tvArea;
        @Bind(R.id.iv_list_item_audit_state)
        ImageView ivState;
        @Bind(R.id.tv_list_item_audit_unit)
        TextView tvUnit;
        @Bind(R.id.tv_list_item_audit_unit_count)
        TextView tvCount;

        @Override
        public void onInFlate(View v) {
            ButterKnife.bind(this, v);
        }
    }
}
