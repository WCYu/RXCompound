package com.rxjy.rxcompound.supervision.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.luck.picture.lib.entity.LocalMedia;
import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.utils.AutoUtils;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by AAA on 2017/9/14.
 */

public class AttachmentAdapter extends BaseAdapter {

    private Context context;
    private List<LocalMedia> dataList;

    public AttachmentAdapter(Context context, List<LocalMedia> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LocalMedia info = dataList.get(position);

        ViewHolder holder;

        if (convertView == null) {
            convertView = View.inflate(context, R.layout.list_item_attachment, null);
            AutoUtils.auto(convertView);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        if (getCount() <= 13 ){
            //保证最后一个item为相册入口
            if (parent.getChildCount() == position) {
                if (position == (getCount() - 1)) {
                    holder.ivAttachment.setImageResource(R.mipmap.attachment_bg_icon);
                    holder.ivAttachment.setScaleType(ImageView.ScaleType.CENTER);
                } else {
                    Glide.with(context).load(info.getCompressPath()).into(holder.ivAttachment);
                    holder.ivAttachment.setScaleType(ImageView.ScaleType.CENTER_CROP);
                }
            }
        }else {
            //防止item数据错乱
            if (position == (getCount() - 1)) {
                holder.ivAttachment.setImageResource(R.mipmap.attachment_bg_icon);
                holder.ivAttachment.setScaleType(ImageView.ScaleType.CENTER);
            } else {
                Glide.with(context).load(info.getCompressPath()).into(holder.ivAttachment);
                holder.ivAttachment.setScaleType(ImageView.ScaleType.CENTER_CROP);
            }
        }

        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.iv_list_item_attachment)
        ImageView ivAttachment;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
