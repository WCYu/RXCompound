package com.rxjy.rxcompound.business.adapter;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.business.entity.CustomerBean;
import com.rxjy.rxcompound.commons.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hjh on 2017/11/24.
 */

public class CustomerAdapter extends BaseAdapter {


    private Context context;
    private List<CustomerBean.BodyBean> list;

    public CustomerAdapter(Context context, List<CustomerBean.BodyBean> list) {
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
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.item_customer, null);
            myHolder = new MyHolder();
            myHolder.tv_name = (TextView) convertView.findViewById(R.id.tv_name);
            myHolder.tv_status = (TextView) convertView.findViewById(R.id.tv_status);
            myHolder.tv_content = (TextView) convertView.findViewById(R.id.tv_content);
            myHolder.tv_person = (TextView) convertView.findViewById(R.id.tv_person);
            myHolder.tv_time = (TextView) convertView.findViewById(R.id.tv_time);
            myHolder.iv_type = (ImageView) convertView.findViewById(R.id.iv_type);
            myHolder.iv_phone = (ImageView) convertView.findViewById(R.id.iv_phone);
            myHolder.iv_add = (ImageView) convertView.findViewById(R.id.iv_add);
            convertView.setTag(myHolder);
        } else {
            myHolder = (MyHolder) convertView.getTag();
        }
        CustomerBean.BodyBean bean = list.get(position);
        myHolder.tv_name.setText(bean.getXingMing() + "-" + bean.getGongSiMingCheng());
        if (bean.getVisitContent() != null) {
            myHolder.tv_content.setText(bean.getVisitContent());
        }
        myHolder.tv_person.setText("信息员  " + bean.getXinXiYuanXingMing());
        myHolder.tv_time.setText(bean.getTianJiaShiJian());
        if(!StringUtils.isEmpty(bean.getStatus())){
            myHolder.tv_status.setText(bean.getStatus());
        }
        if (!StringUtils.isEmpty(bean.getType())) {
            switch (bean.getType()) {
                case "办公":
                    myHolder.iv_type.setImageResource(R.drawable.ic_typeoffice);
                    break;
                case "餐饮":
                    myHolder.iv_type.setImageResource(R.drawable.ic_typefood);
                    break;
                case "互联网":
                    myHolder.iv_type.setImageResource(R.drawable.ic_typenet);
                    break;
                case "酒店":
                    myHolder.iv_type.setImageResource(R.drawable.ic_typehotel);
                    break;
                case "商业":
                    myHolder.iv_type.setImageResource(R.drawable.ic_typebusi);
                    break;
                case "其它":
                    myHolder.iv_type.setImageResource(R.drawable.ic_typeother);
                    break;
            }
        } else {
            myHolder.iv_type.setImageResource(R.drawable.ic_typeother);
        }
        myHolder.iv_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        myHolder.iv_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+"15001075684"));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                try {
                    context.startActivity(intent);
                }catch (ActivityNotFoundException e){
                    Toast.makeText(context,"请检查您的手机，无法拨打电话！",Toast.LENGTH_SHORT).show();
                }
            }
        });
        return convertView;
    }

    public class MyHolder {
        private TextView tv_name, tv_status, tv_content, tv_person, tv_time;
        private ImageView iv_type,iv_phone,iv_add;
    }

    public class ViewHolder {

    }
}
