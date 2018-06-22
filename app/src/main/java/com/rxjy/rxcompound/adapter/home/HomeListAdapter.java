package com.rxjy.rxcompound.adapter.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.rxjy.rxcompound.R;

import java.util.ArrayList;

/**
 * Created by 阿禹 on 2018/6/22.
 */

public class HomeListAdapter extends BaseAdapter {

    Context context;
    ArrayList arrayList;

    public HomeListAdapter(Context context, ArrayList arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
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
        convertView = LayoutInflater.from(context).inflate(R.layout.item_home_header,null);
        return convertView;
    }
}
