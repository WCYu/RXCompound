package com.rxjy.rxcompound.des.adapter;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.base.SingleBaseAdapter;
import com.rxjy.rxcompound.commons.base.SingleViewHolder;
import com.rxjy.rxcompound.entity.XunjianListInfo;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by AAA on 2017/7/26.
 */

public class XunjianAdapter extends SingleBaseAdapter<XunjianListInfo.BodyBean, XunjianAdapter.ViewHolder> {


          String gongsiname;
    public XunjianAdapter(Context context, List<XunjianListInfo.BodyBean> datas, String gongsiname) {
        super(context, datas);
        this.gongsiname=gongsiname;
        Log.e("gongsiname",gongsiname);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.list_item_xunjian;
    }

    @Override
    public ViewHolder initViewHolder() {
        return new ViewHolder();
    }

    @Override
    public void onBindView(int position, final XunjianListInfo.BodyBean data, ViewHolder holder) {
        holder.tvListItemXunjianName.setText(gongsiname);
        if (data.getSc_StateName().equals("待办")) {
            holder.tvListItemXunjianDate.setText("规定"+" : "+data.getSc_CheckTime());
            holder.tvListItemXunjianState.setTextColor(Color.parseColor("#e60012"));
        }else if (data.getSc_StateName().equals("完成")){
            holder.tvListItemXunjianDate.setText("实际"+" : "+data.getSc_ActualCheckTime());
            holder.tvListItemXunjianState.setTextColor(Color.parseColor("#22ac38"));
        }
        holder.tvListItemXunjianState.setText(data.getSc_StateName());

    }

    class ViewHolder implements SingleViewHolder {
        @Bind(R.id.tv_list_item_xunjian_name)
        TextView tvListItemXunjianName;
        @Bind(R.id.tv_list_item_xunjian_state)
        TextView tvListItemXunjianState;
        @Bind(R.id.tv_list_item_xunjian_date)
        TextView tvListItemXunjianDate;

        @Override
        public void onInFlate(View v) {
            ButterKnife.bind(this, v);
        }
    }
}
