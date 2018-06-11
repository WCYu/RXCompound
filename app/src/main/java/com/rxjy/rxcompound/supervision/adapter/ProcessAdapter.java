package com.rxjy.rxcompound.supervision.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.utils.AutoUtils;
import com.rxjy.rxcompound.supervision.entity.PrepareInfo;

import java.util.List;

/**
 * Created by Administrator on 2017/2/6.
 */
public class ProcessAdapter extends BaseExpandableListAdapter {

    private List<PrepareInfo.PrepareGroup> dataList;
    private Context context;

    public ProcessAdapter(Context context, List<PrepareInfo.PrepareGroup> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @Override
    public int getGroupCount() {
        return dataList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return dataList.get(groupPosition).getList().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return dataList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return dataList.get(groupPosition).getList().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean b, View convertView, ViewGroup viewGroup) {

        PrepareInfo.PrepareGroup info = dataList.get(groupPosition);

        GroupViewHolder holder = null;

        if (convertView == null) {
            convertView = View.inflate(context, R.layout.list_item_process_group, null);
            AutoUtils.auto(convertView);
            holder = new GroupViewHolder();
            holder.tvName = (TextView) convertView.findViewById(R.id.tv_list_item_process_group_name);
            holder.tvStatus = (TextView) convertView.findViewById(R.id.tv_list_item_process_group_state);
            holder.ivArrow = (ImageView) convertView.findViewById(R.id.iv_list_item_process_group_arrow);
            convertView.setTag(holder);
        } else {
            holder = (GroupViewHolder) convertView.getTag();
        }

        if (b){
            holder.ivArrow.setImageResource(R.mipmap.arrow_down_black);
        }else {
            holder.ivArrow.setImageResource(R.mipmap.arrow_up_black);
        }

//        if (info.getNoCount() == 0) {
//            holder.tvCount.setVisibility(View.INVISIBLE);
//        } else {
//            holder.tvCount.setVisibility(View.VISIBLE);
//            holder.tvCount.setText(info.getNoCount() + "");
//            if (b) {
//                holder.tvCount.setVisibility(View.INVISIBLE);
//            } else {
//                holder.tvCount.setVisibility(View.VISIBLE);
//            }
//        }

        if (info.getStatus() == 0) {
            holder.tvStatus.setText("未完成");
            holder.tvStatus.setTextColor(context.getResources().getColor(R.color.colorRedLight));
        } else {
            holder.tvStatus.setText("已完成");
            holder.tvStatus.setTextColor(context.getResources().getColor(R.color.colorGreen));
        }

        holder.tvName.setText(info.getProcess_name());

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean b, View convertView, ViewGroup viewGroup) {

        PrepareInfo.PrepareGroup.PrepareChild info = dataList.get(groupPosition).getList().get(childPosition);

        ChildViewHolder holder = null;

        if (convertView == null) {
            convertView = View.inflate(context, R.layout.list_item_process_child, null);
            AutoUtils.auto(convertView);
            holder = new ChildViewHolder();
            holder.tvName = (TextView) convertView.findViewById(R.id.tv_list_item_process_child_name);
            holder.tvStatus = (TextView) convertView.findViewById(R.id.tv_list_item_process_child_state);
            holder.tvCount = (TextView) convertView.findViewById(R.id.tv_list_item_process_child_count);
            convertView.setTag(holder);
        } else {
            holder = (ChildViewHolder) convertView.getTag();
        }

        if (info.getNoCount() == 0) {
            holder.tvCount.setVisibility(View.INVISIBLE);
        } else {
            holder.tvCount.setVisibility(View.VISIBLE);
            holder.tvCount.setText(info.getNoCount() + "");
        }

        if (info.getStatus() == 0) {
            holder.tvStatus.setText("未完成");
            holder.tvStatus.setTextColor(context.getResources().getColor(R.color.colorRedLight));
        } else {
            holder.tvStatus.setText("已完成");
            holder.tvStatus.setTextColor(context.getResources().getColor(R.color.colorGreen));
        }

        holder.tvName.setText(info.getProcess_name());

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }

    class GroupViewHolder {
        TextView tvName;
        TextView tvStatus;
        ImageView ivArrow;
    }

    class ChildViewHolder {
        TextView tvName;
        TextView tvStatus;
        TextView tvCount;
    }

}
