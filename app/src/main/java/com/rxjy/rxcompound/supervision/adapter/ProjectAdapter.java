package com.rxjy.rxcompound.supervision.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.base.SingleBaseAdapter;
import com.rxjy.rxcompound.commons.base.SingleViewHolder;
import com.rxjy.rxcompound.commons.utils.TimeUtil;
import com.rxjy.rxcompound.entity.CustomerBean;
import com.rxjy.rxcompound.supervision.entity.ProjectListInfo;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by hjh on 2018/2/2.
 */

public class ProjectAdapter extends SingleBaseAdapter<ProjectListInfo.Project, ProjectAdapter.ViewHolder> {

    public ProjectAdapter(Context context, List<ProjectListInfo.Project> datas) {
        super(context, datas);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.item_projectlist;
    }

    @Override
    public ViewHolder initViewHolder() {
        return new ViewHolder();
    }

    @Override
    public void onBindView(int position, final ProjectListInfo.Project data, ViewHolder holder) {
        holder.tvName.setText(data.getProName());
        holder.tvAddress.setText(data.getProAddr());
        holder.tvTime.setText((TimeUtil.getNormalTime(data.getBeginTime()) + " - " + (TimeUtil.getNormalTime(data.getEndTime()))));
        switch (data.getProType()) {
            case 1:
                holder.ivMark.setImageResource(R.mipmap.mark_work_icon);
                break;
            case 2:
                holder.ivMark.setImageResource(R.mipmap.mark_repast_icon);
                break;
            case 3:
                holder.ivMark.setImageResource(R.mipmap.mark_business_icon);
                break;
            case 4:
                holder.ivMark.setImageResource(R.mipmap.mark_hotel_icon);
                break;
            case 5:
                holder.ivMark.setImageResource(R.mipmap.mark_other_icon);
                break;
            default:
                holder.ivMark.setImageResource(R.mipmap.mark_other_icon);
                break;
        }
        switch (data.getState()) {
            case 7:
                holder.tvState.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.shape_state_start));
                holder.tvState.setText("施工");
                break;
            case 8:
                holder.tvState.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.shape_state_finish));
                holder.tvState.setText("竣工");
                break;
            case 6:
                holder.tvState.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.shape_state_finish));
                holder.tvState.setText("待工");
                break;
            case 71:
                holder.tvState.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.shape_state_wait));
                holder.tvState.setText("完工");
                break;
        }
//        if (data.getCarmaCount() != 0) {
//            if (data.getCarmaCount() < 10) {
//                holder.tvCameraStateCount.setText(data.getCarmaCount() + "");
//            } else {
//                holder.tvCameraStateCount.setText("9+");
//            }
//            holder.tvCameraStateCount.setVisibility(View.VISIBLE);
//        } else {
//            holder.tvCameraStateCount.setVisibility(View.INVISIBLE);
//        }
    }

    class ViewHolder implements SingleViewHolder {
        @Bind(R.id.iv_list_item_project_mark)
        ImageView ivMark;
        @Bind(R.id.tv_list_item_project_name)
        TextView tvName;
        @Bind(R.id.tv_list_item_project_state)
        TextView tvState;
        @Bind(R.id.tv_list_item_project_address)
        TextView tvAddress;
        @Bind(R.id.tv_list_item_project_time)
        TextView tvTime;

        @Override
        public void onInFlate(View v) {
            ButterKnife.bind(this, v);
        }
    }
}
