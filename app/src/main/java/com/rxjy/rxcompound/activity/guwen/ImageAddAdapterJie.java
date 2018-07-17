package com.rxjy.rxcompound.activity.guwen;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.rxjy.rxcompound.R;

import java.util.List;


public class ImageAddAdapterJie extends BaseAdapter {

    private List<String> lists;
    Context context;

    public ImageAddAdapterJie(List lists, Context context) {
        this.lists = lists;
        this.context = context;
    }

    @Override
    public int getCount() {
        int count = lists == null ? 1 : lists.size() + 1;
        if (count > 20) {
            return lists.size();
        } else {
            return count;
        }
    }

    @Override
    public Object getItem(int position) {
        return lists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.e("集合大小>>>>", lists.size() + "");
        convertView = LayoutInflater.from(context).inflate(R.layout.item_imageadd, null);
        ImageView iv = (ImageView) convertView.findViewById(R.id.iv_imgadd);
        if (position < lists.size()) {
            //代表+号之前的需要正常显示图片
            String picUrl = lists.get(position); //图片路径
            Log.e("集合>>>>", picUrl);
            Glide.with(context).load(picUrl).into(iv);
        } else {
            iv.setImageResource(R.drawable.ic_imgadd);//最后一个显示加号图片
        }
        return convertView;

    }

}
