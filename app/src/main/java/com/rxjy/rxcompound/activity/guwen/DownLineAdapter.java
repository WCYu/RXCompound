package com.rxjy.rxcompound.activity.guwen;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.utils.AutoUtils;
import com.rxjy.rxcompound.utils.GlideCircleTransform;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/5/30.
 */

public class DownLineAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<DownLineBean> DownLinelist;

    public DownLineAdapter(Context context, ArrayList<DownLineBean> DownLinelist) {
        this.context = context;
        this.DownLinelist = DownLinelist;
    }

    @Override
    public int getCount() {
        return DownLinelist.get(0).getBody().getTable().size();
    }

    @Override
    public Object getItem(int position) {
        return DownLinelist.get(0).getBody().getTable().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        ViewHolder viewHolder;

        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.downline_list_it, parent, false);
            AutoUtils.auto(view);
            viewHolder = new ViewHolder();
            /* 调用View的findViewById()方法分别获得image和name实例 */
            viewHolder.downlineItHead = (ImageView) view.findViewById(R.id.downline_it_Head);
            viewHolder.downlineItPhone = (TextView) view.findViewById(R.id.downline_it_phone);
            viewHolder.downlineItIdentity = (TextView) view.findViewById(R.id.downline_it_identity);
            viewHolder.downlineItActivation = (TextView) view.findViewById(R.id.downline_it_activation);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.downlineItPhone.setText(DownLinelist.get(0).getBody().getTable().get(position).getPhone());
        viewHolder.downlineItIdentity.setText(DownLinelist.get(0).getBody().getTable().get(position).getName());
        if (DownLinelist.get(0).getBody().getTable().get(position).getState().equals("已激活")) {
            viewHolder.downlineItActivation.setTextColor(Color.parseColor("#33FF33"));
            viewHolder.downlineItActivation.setText(DownLinelist.get(0).getBody().getTable().get(position).getState());
        } else {
            viewHolder.downlineItActivation.setTextColor(Color.parseColor("#e60012"));
            viewHolder.downlineItActivation.setText(DownLinelist.get(0).getBody().getTable().get(position).getState());
        }
        String image = DownLinelist.get(0).getBody().getTable().get(position).getImage();
        RequestOptions options = new RequestOptions();
        options.centerCrop().transform(new GlideCircleTransform(context));
        if (!TextUtils.isEmpty(image)) {
            Glide.with(context).load(image).apply(options).into(viewHolder.downlineItHead);
        } else {
            Glide.with(context).load(R.mipmap.xiaxiantoxiang).apply(options).into(viewHolder.downlineItHead);
        }

        return view;
    }


    class ViewHolder {
        TextView downlineItPhone, downlineItActivation, downlineItIdentity;
        ImageView downlineItHead;
    }

}
