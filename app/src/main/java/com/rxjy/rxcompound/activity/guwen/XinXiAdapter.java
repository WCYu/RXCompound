package com.rxjy.rxcompound.activity.guwen;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.rxjy.rxcompound.R;

import java.util.List;

public class XinXiAdapter extends BaseAdapter {
    private List<XinXiYuanInfo.BodyBean> body;
    Context context;

    public XinXiAdapter(List<XinXiYuanInfo.BodyBean> body, Context context) {
        this.body = body;
        this.context = context;
    }

    @Override
    public int getCount() {
        return body.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.xinxiyuan_item_layout, null);
        ViewHolder viewHolder = new ViewHolder(convertView);
        viewHolder.tv_name.setText(body.get(position).getXingMing());
        viewHolder.tv_content.setText(body.get(position).getZuiJinHuiFangNeiRong());
        Log.i("tag", "倒计时时间>>>>>>>>>>" + body.get(position).getVisitHour());
        String visitHour = body.get(position).getVisitHour();
        if (body.get(position).getVisitHour() != null) {
            if (body.get(position).getVisitHour().equals("--")) {
                viewHolder.tv_daojishi.setText(body.get(position).getVisitHour());
            } else {
                String substring = visitHour.substring(0, 1);
//                Integer integer = Integer.valueOf(substring);
                Log.e("数字",substring);
                if (substring.equals("-")) {
                    viewHolder.tv_daojishi.setTextColor(Color.parseColor("#e60012"));
                    viewHolder.tv_daojishi.setText(body.get(position).getVisitHour());
                } else {
                    viewHolder.tv_daojishi.setTextColor(Color.parseColor("#22ad38"));
                    viewHolder.tv_daojishi.setText(body.get(position).getVisitHour());
                }
            }
        } else {
            viewHolder.tv_daojishi.setText(" ");
        }

        viewHolder.tv_jibie.setText(body.get(position).getJiBie());
        viewHolder.tv_type.setText(body.get(position).getWorkType());
        viewHolder.tv_gongsi.setText(body.get(position).getGongSiMingCheng());
        return convertView;
    }


    public static class ViewHolder {
        public View rootView;
        public TextView tv_type;
        public TextView tv_content;
        public TextView tv_name;
        public TextView tv_jibie;
        public TextView tv_daojishi;
        public TextView tv_gongsi;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.tv_type = (TextView) rootView.findViewById(R.id.tv_type);
            this.tv_content = (TextView) rootView.findViewById(R.id.tv_content);
            this.tv_name = (TextView) rootView.findViewById(R.id.tv_name);
            this.tv_jibie = (TextView) rootView.findViewById(R.id.tv_jibie);
            this.tv_daojishi = (TextView) rootView.findViewById(R.id.tv_daojishi);
            this.tv_gongsi = (TextView) rootView.findViewById(R.id.tv_gongsi);
        }

    }
}
