package com.rxjy.rxcompound.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rxjy.rxcompound.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * Created by asus on 2018/5/14.
 */

public class NattenDanceAdapter extends BaseAdapter {
    List<Map<String, Object>> nattendance_list;
    Context mContext;
    public static final int TYPE_TITLE = 0;
    public static final int TYPE_COMPANY = 1;
    private int num;

    public NattenDanceAdapter(List<Map<String, Object>> nattendance_list, Context mContext, int num) {
        this.nattendance_list = nattendance_list;
        this.mContext = mContext;
        this.num = num;
    }

    @Override
    public int getCount() {
        return nattendance_list.size();
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
        ViewHoider viewHoider = null;
        TwoViewHoider twoViewHoider = null;

        if (position == 0) {
            if (convertView == null) {
                viewHoider = new ViewHoider();
                convertView = LayoutInflater.from(mContext).inflate(R.layout.administration_more_item, null);
                viewHoider.mimage = (ImageView) convertView.findViewById(R.id.iv_item);
                viewHoider.mname = (TextView) convertView.findViewById(R.id.tv_item);
                viewHoider.mhondian = (TextView) convertView.findViewById(R.id.tv_messagenum);
                convertView.setTag(viewHoider);
            } else {
                viewHoider = (ViewHoider) convertView.getTag();
            }
            if (num != 0) {
                viewHoider.mhondian.setVisibility(View.VISIBLE);
                viewHoider.mhondian.setText(num + "");
            }
            Map<String, Object> stringIntegerMap = nattendance_list.get(position);
            Set<String> strings = stringIntegerMap.keySet();
            for (String key:strings) {
                viewHoider.mimage.setImageResource(Integer.parseInt(stringIntegerMap.get(key).toString()));
                viewHoider.mname.setText(key);
            }

        } else {
            if (convertView == null) {
                twoViewHoider = new TwoViewHoider();
                convertView = LayoutInflater.from(mContext).inflate(R.layout.administration_more_item, null);
                twoViewHoider.mimage = (ImageView) convertView.findViewById(R.id.iv_item);
                twoViewHoider.mname = (TextView) convertView.findViewById(R.id.tv_item);
                twoViewHoider.mhondian = (TextView) convertView.findViewById(R.id.tv_messagenum);
                convertView.setTag(twoViewHoider);
            } else {
                twoViewHoider = (TwoViewHoider) convertView.getTag();
            }
            twoViewHoider.mhondian.setVisibility(View.GONE);
            Map<String, Object> stringIntegerMap = nattendance_list.get(position);
            Set<String> strings = stringIntegerMap.keySet();

            for (String key:strings) {
                twoViewHoider.mimage.setImageResource(Integer.parseInt(stringIntegerMap.get(key).toString()));
                twoViewHoider.mname.setText(key);
            }
        }
        return convertView;
    }

    class ViewHoider {
        private ImageView mimage;
        private TextView mname, mhondian;

    }

    class TwoViewHoider {
        private ImageView mimage;
        private TextView mname, mhondian;

    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_TITLE;
        } else {
            return TYPE_COMPANY;
        }
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }
}
