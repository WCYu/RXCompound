package com.rxjy.rxcompound.activity.guwen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.rxjy.rxcompound.R;

import java.util.List;

/**
 * Created by 解亚鑫 on 2018/6/20.
 */

public class ZhangBenAdapter extends BaseAdapter {
    List<ZhangBenInfo.BodyBean.TableBean> table;
    Context context;

    public ZhangBenAdapter(List<ZhangBenInfo.BodyBean.TableBean> table, Context context) {
        this.table = table;
        this.context = context;
    }

    @Override
    public int getCount() {
        return table.size();
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
        convertView = LayoutInflater.from(context).inflate(R.layout.zhangben_item_layout, null);
        ViewHolder viewHolder = new ViewHolder(convertView);
        switch (table.get(position).getLaiYuan()) {
            case "个人":
                viewHolder.tv_laiyuan.setText(table.get(position).getLaiYuan());
                viewHolder.tv_balance.setText(table.get(position).getSumMoney() + "");
                viewHolder.img_zhangben.setImageResource(R.mipmap.zhuce);
                break;
            case "会员":
                viewHolder.tv_laiyuan.setText(table.get(position).getLaiYuan());
                viewHolder.tv_balance.setText(table.get(position).getSumMoney() + "");
                viewHolder.img_zhangben.setImageResource(R.mipmap.shoudan);
                break;
            case "提现记录":
                viewHolder. tv_laiyuan.setText(table.get(position).getLaiYuan());
                viewHolder.tv_balance.setText(table.get(position).getSumMoney() + "");
                viewHolder.img_zhangben.setImageResource(R.mipmap.tixian);
                break;
            case "预收":
                viewHolder.tv_laiyuan.setText(table.get(position).getLaiYuan());
                viewHolder.tv_balance.setText(table.get(position).getSumMoney() + "");
                viewHolder.img_zhangben.setImageResource(R.mipmap.yushoukuan);
                break;
            default:
        }
        return convertView;
    }

    public static class ViewHolder {
        public View rootView;
        public ImageView img_zhangben;
        public TextView tv_laiyuan;
        public TextView tv_balance;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.img_zhangben = (ImageView) rootView.findViewById(R.id.img_zhangben);
            this.tv_laiyuan = (TextView) rootView.findViewById(R.id.tv_laiyuan);
            this.tv_balance = (TextView) rootView.findViewById(R.id.tv_balance);
        }

    }
}
