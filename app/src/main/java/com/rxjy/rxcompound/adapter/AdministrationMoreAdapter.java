package com.rxjy.rxcompound.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.rxjy.rxcompound.R;

import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2018/5/9.
 */

public class AdministrationMoreAdapter extends BaseAdapter {
    private Map<Integer,String> mlst;
    private Context context;

    public AdministrationMoreAdapter(Map<Integer, String> mlst, Context context) {
        this.mlst = mlst;
        this.context = context;
    }

    @Override
    public int getCount() {
        return mlst.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
///R.layout.item_moreitem
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHoider viewHoider;
        if(convertView==null){
            viewHoider=new ViewHoider();
            convertView=  LayoutInflater.from(context).inflate(R.layout.administration_more_item,null);
            viewHoider.imageView= (ImageView) convertView.findViewById(R.id.iv_item);
            viewHoider.mtext= (TextView) convertView.findViewById(R.id.tv_item);
            convertView.setTag(viewHoider);

        }else {
            viewHoider= (ViewHoider) convertView.getTag();
        }
        Set<Integer> integers = mlst.keySet();

        for (Integer key: integers) {
            viewHoider.imageView.setImageResource(key);
            viewHoider.mtext.setText(mlst.get(key));
        }


        return convertView;
    }
    class ViewHoider{
         private TextView mtext;
        private ImageView imageView;

    }
}
