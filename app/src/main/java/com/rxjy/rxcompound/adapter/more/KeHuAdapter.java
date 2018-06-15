package com.rxjy.rxcompound.adapter.more;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.activity.WebViewActivity;
import com.rxjy.rxcompound.activity.more.KeHuActivity;
import com.rxjy.rxcompound.activity.more.ZaiTanActivity;
import com.rxjy.rxcompound.entity.more.KeHuInfoBean;

import java.util.ArrayList;

/**
 * Created by 阿禹 on 2018/6/11.
 */

public class KeHuAdapter extends BaseAdapter {

    Context context;
    ArrayList<KeHuInfoBean.BodyBean> arrayList;

    public KeHuAdapter(Context context, ArrayList<KeHuInfoBean.BodyBean> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getItemViewType(int position) {
        // current menu type
        return position;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_list_kehu, null);
            ViewHolder viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
//        ViewHolder viewHolder = new ViewHolder(convertView);
        ViewHolder viewHolder = (ViewHolder) convertView.getTag();
        if (position < arrayList.size()) {
            String status = arrayList.get(position).getStatus();
            viewHolder.tv_biaoqian.setText(arrayList.get(position).getType());
            viewHolder.tv_content.setText(arrayList.get(position).getVisitContent());
            viewHolder.tv_gcname.setText(arrayList.get(position).getXingMing() + "-" + arrayList.get(position).getGongSiMingCheng());
            viewHolder.tv_name.setText("信息员 "+arrayList.get(position).getXinXiYuanXingMing());
            viewHolder.tv_time.setText(arrayList.get(position).getZhuAnZhongShenTime());
            viewHolder.tv_zhuangtai.setText(status);
            viewHolder.tv_pic.setText("");
            switch (status) {
                case "在跟踪":
                    viewHolder.tv_zhuangtai.setTextColor(Color.parseColor("#f8701c"));
                    break;
                case "审核":
                    viewHolder.tv_zhuangtai.setTextColor(Color.parseColor("#f8701c"));
                    break;
                case "打回":
                    viewHolder.tv_zhuangtai.setTextColor(Color.parseColor("#e60012"));
                    break;
                case "在谈":
                    viewHolder.tv_name.setText("量房 ");
                    viewHolder.tv_zhuangtai.setTextColor(Color.parseColor("#f8701c"));
                    break;
                case "已签":
                    viewHolder.tv_zhuangtai.setTextColor(Color.parseColor("#33c5a5"));
                    viewHolder.tv_time.setText(arrayList.get(position).getJieGuoTime());
                    viewHolder.tv_name.setText("签单 ");
                    viewHolder.tv_pic.setText(arrayList.get(position).getShiGongHeTongJinE()+" 万");
                    break;
                case "未签":
                    viewHolder.tv_zhuangtai.setTextColor(Color.parseColor("#f8701c"));
                    viewHolder.tv_name.setText("未签 ");
                    viewHolder.tv_time.setText(arrayList.get(position).getJieGuoTime());
                    viewHolder.tv_content.setText(arrayList.get(position).getReason());
                    break;
            }

        }
        return convertView;
    }

    public static class ViewHolder {
        public View rootView;
        public TextView tv_biaoqian;
        public TextView tv_gcname;
        public TextView tv_zhuangtai;
        public TextView tv_content;
        public TextView tv_name;
        public TextView tv_time;
        public TextView tv_pic;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.tv_biaoqian = (TextView) rootView.findViewById(R.id.tv_biaoqian);
            this.tv_gcname = (TextView) rootView.findViewById(R.id.tv_gcname);
            this.tv_zhuangtai = (TextView) rootView.findViewById(R.id.tv_zhuangtai);
            this.tv_content = (TextView) rootView.findViewById(R.id.tv_content);
            this.tv_name = (TextView) rootView.findViewById(R.id.tv_name);
            this.tv_time = (TextView) rootView.findViewById(R.id.tv_time);
            this.tv_pic = (TextView) rootView.findViewById(R.id.tv_pic);
        }

    }
}
