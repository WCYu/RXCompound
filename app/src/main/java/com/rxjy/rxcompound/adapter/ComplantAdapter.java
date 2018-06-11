package com.rxjy.rxcompound.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.rxjy.rxcompound.R;

import java.util.List;

/**
 * Created by asus on 2018/4/17.
 */

public class ComplantAdapter extends BaseAdapter {
    private Context mContext;
    private List<Integer> mList;
    private LayoutInflater inflater;

    public ComplantAdapter(Context mContext, List<Integer> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @Override
    public int getCount() {
        int count = mList == null ? 1 : mList.size() + 1;
        return count;
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
        convertView = LayoutInflater.from(mContext).inflate(R.layout.complant_grid_item, null);
        ImageView iv = (ImageView) convertView.findViewById(R.id.grid_item);
        if (position < mList.size()) {
            //代表+号之前的需要正常显示图片
               int picUrl  = mList.get(position); //图片路径
            Glide.with(mContext).load(picUrl).into(iv);
        } else {
            iv.setImageResource(R.mipmap.ic_launcher);//最后一个显示加号图片
        }
        return convertView;
    }
}
