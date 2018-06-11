package com.rxjy.rxcompound.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.utils.StringUtils;
import com.rxjy.rxcompound.entity.FindDataBean;
import com.rxjy.rxcompound.entity.InfoMessageBodyBean;

import java.util.ArrayList;

/**
 * Created by hjh on 2017/11/22.
 */

public class InformMessageAdapter extends BaseAdapter{


    private Context context;
    private ArrayList<InfoMessageBodyBean> list;

    public InformMessageAdapter(Context context, ArrayList<InfoMessageBodyBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyHolder myHolder;
        if(convertView==null){
            convertView=View.inflate(context, R.layout.item_infomessage, null);
            myHolder=new MyHolder();
            myHolder.tv_title= (TextView) convertView.findViewById(R.id.tv_title);
            myHolder.tv_time= (TextView) convertView.findViewById(R.id.tv_time);
            myHolder.tv_content= (TextView) convertView.findViewById(R.id.tv_content);
            myHolder.tv_status= (TextView) convertView.findViewById(R.id.tv_status);
            convertView.setTag(myHolder);
        }else{
            myHolder= (MyHolder) convertView.getTag();
        }
        InfoMessageBodyBean bodyBean=list.get(position);
        myHolder.tv_time.setText(bodyBean.getCreate_date());
        myHolder.tv_title.setText(bodyBean.getTitle());
        myHolder.tv_content.setText(bodyBean.getTxt());
        if(!StringUtils.isEmpty(bodyBean.getState())){
            int status= Integer.parseInt(bodyBean.getState());
            if(status==0){
                myHolder.tv_status.setText("未读");
                myHolder.tv_status.setTextColor(context.getResources().getColor(R.color.textred));
            }else if(status==1){
                myHolder.tv_status.setText("已读");
                myHolder.tv_status.setTextColor(context.getResources().getColor(R.color.textgreen));
            }
        }
        return convertView;
    }


    public class MyHolder{
        private TextView tv_title,tv_content,tv_status,tv_time;
    }

}
