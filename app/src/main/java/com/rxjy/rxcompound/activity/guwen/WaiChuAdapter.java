package com.rxjy.rxcompound.activity.guwen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.rxjy.rxcompound.R;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class WaiChuAdapter extends BaseAdapter {
    List<WaiChuInfo.BodyBean> body;
    Context context;

    public WaiChuAdapter(List<WaiChuInfo.BodyBean> body, Context context) {
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
        convertView = LayoutInflater.from(context).inflate(R.layout.waichu_item, null);
        ViewHolder viewHolder = new ViewHolder(convertView);
        viewHolder.dizhi.setText(body.get(position).getMeetingArea() + "");
        if (body.get(position).getLeiXing() == 1) {
            viewHolder.tv_name.setText("信息员 - ");
        } else if (body.get(position).getLeiXing() == 2) {
            viewHolder.tv_name.setText("会员 - ");
        }
        viewHolder.tv_shenfen.setText("" + body.get(position).getXingMing());
        viewHolder.tv_starttime.setText(body.get(position).getWaiChuShiJian());
        viewHolder.tv_endtime.setText(" - " + body.get(position).getGuiLaiShiJian());
        viewHolder.tv_yuanyin.setText(body.get(position).getStatus());
        viewHolder.waichu_yuanyin.setText(body.get(position).getWaiChuYuanYin());
        return convertView;
    }



    class ViewHolder {
        public View rootView;
        public TextView tv_name;
        public TextView tv_shenfen;
        public TextView tv_yuanyin;
        public TextView dizhi;
        public TextView waichu_yuanyin;
        public TextView tv_starttime;
        public TextView tv_endtime;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.tv_name = (TextView) rootView.findViewById(R.id.tv_name);
            this.tv_shenfen = (TextView) rootView.findViewById(R.id.tv_shenfen);
            this.tv_yuanyin = (TextView) rootView.findViewById(R.id.tv_yuanyin);
            this.dizhi = (TextView) rootView.findViewById(R.id.dizhi);
            this.waichu_yuanyin = (TextView) rootView.findViewById(R.id.waichu_yuanyin);
            this.tv_starttime = (TextView) rootView.findViewById(R.id.tv_starttime);
            this.tv_endtime = (TextView) rootView.findViewById(R.id.tv_endtime);
        }

    }
}
