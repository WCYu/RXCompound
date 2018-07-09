package com.rxjy.rxcompound.activity.guwen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.rxjy.rxcompound.R;

import java.util.List;

/**
 * Created by 解亚鑫 on 2018/6/21.
 */

public class HuiShouAdapter extends BaseAdapter {
    List<HuiShouInfo.BodyBean.TableBean> table;
    Context context;

    public HuiShouAdapter(List<HuiShouInfo.BodyBean.TableBean> table, Context context) {
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
        convertView = LayoutInflater.from(context).inflate(R.layout.huishou_item, null);
        ViewHolder viewHolder = new ViewHolder(convertView);
        viewHolder.tv_ly.setText(table.get(position).getLaiYuan());
        viewHolder.tv_money.setText(table.get(position).getMoney()+"");
        viewHolder.tv_time.setText(table.get(position).getTJShiJian()+"");
        return convertView;
    }

    public static class ViewHolder {
        public View rootView;
        public TextView tv_ly;
        public TextView tv_time;
        public TextView tv_money;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.tv_ly = (TextView) rootView.findViewById(R.id.tv_ly);
            this.tv_time = (TextView) rootView.findViewById(R.id.tv_time);
            this.tv_money = (TextView) rootView.findViewById(R.id.tv_money);
        }

    }
}
