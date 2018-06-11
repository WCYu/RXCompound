package com.rxjy.rxcompound.supervision.adapter;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import com.luck.picture.lib.entity.LocalMedia;
import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.base.SingleBaseAdapter;
import com.rxjy.rxcompound.commons.base.SingleViewHolder;
import com.rxjy.rxcompound.supervision.entity.RoutingDetailInfo;
import com.rxjy.rxcompound.widget.HorizontalListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by AAA on 2018/1/16.
 */

public class RoutingDetailAdapter extends SingleBaseAdapter<RoutingDetailInfo.RoutingMarkInfo, RoutingDetailAdapter.ViewHolder> {

    public interface OnRoutingDetailClickListener {

        void onRoutingDetailClickListener(int position, RoutingDetailInfo.RoutingMarkInfo data);

    }

    private OnRoutingDetailClickListener listener;

    public RoutingDetailAdapter(Context context, List<RoutingDetailInfo.RoutingMarkInfo> datas) {
        super(context, datas);
    }

    public void setOnRoutingSubClickListener(OnRoutingDetailClickListener listener) {
        this.listener = listener;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.list_item_routing_detail_mark;
    }

    @Override
    public ViewHolder initViewHolder() {
        return new ViewHolder();
    }

    @Override
    public void onBindView(int position, final RoutingDetailInfo.RoutingMarkInfo data, final ViewHolder holder) {
        holder.tvName.setText(data.getXj_TypeName());
        holder.tvRemark.setText(data.getXj_remark().equals("") ? "暂无信息..." : data.getXj_remark());
        if (data.getXj_remark().equals(""))
            holder.tvRemark.setTextColor(context.getResources().getColor(R.color.colorGrayLight));
        else
            holder.tvRemark.setTextColor(context.getResources().getColor(R.color.colorGrayDark));
        List<LocalMedia> photoList = new ArrayList<>();
        photoList.clear();
        for (String url : data.getXj_photoUrl()) {
            LocalMedia localMedia = new LocalMedia();
            localMedia.setPath(url);
            photoList.add(localMedia);
        }
        if (photoList.size() == 0) {
            photoList.add(new LocalMedia());
        }
        ImageAdapter mAdapter = new ImageAdapter(context, photoList);
        mAdapter.setType(2);
        holder.hlv.setAdapter(mAdapter);
        holder.hlv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (listener != null)
                    listener.onRoutingDetailClickListener(position, data);
            }
        });
    }

    class ViewHolder implements SingleViewHolder {
        @Bind(R.id.tv_list_item_routing_detail_mark_name)
        TextView tvName;
        @Bind(R.id.hlv_list_item_routing_detail_mark)
        HorizontalListView hlv;
        @Bind(R.id.tv_list_item_routing_detail_remark)
        TextView tvRemark;

        @Override
        public void onInFlate(View v) {
            ButterKnife.bind(this, v);
        }
    }
}
