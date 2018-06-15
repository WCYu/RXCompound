package com.rxjy.rxcompound.adapter.more;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.entity.more.KeHuInfoBean;

import java.util.ArrayList;

/**
 * Created by 阿禹 on 2018/6/11.
 */

public class KeHuAdapter extends BaseAdapter {

    Context context;
    ArrayList<KeHuInfoBean.BodyBean> arrayList;

    public KeHuAdapter(Context context, ArrayList<KeHuInfoBean.BodyBean> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getItemViewType(int position) {
        // current menu type
        return position;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_list_kehu, null);
            ViewHolder viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }

        if(position<arrayList.size()){
            //        ViewHolder viewHolder = new ViewHolder(convertView);
            ViewHolder viewHolder= (ViewHolder) convertView.getTag();
            viewHolder.tv_biaoqian.setText(arrayList.get(position).getType());

            Object visitContent = arrayList.get(position).getVisitContent();

            if(visitContent == null){
                viewHolder.tv_content.setText("暂无更多内容");
            }else {
                viewHolder.tv_content.setText(visitContent.toString());
            }

            viewHolder.tv_gcname.setText(arrayList.get(position).getXingMing()+"-"+arrayList.get(position).getGongSiMingCheng());
            viewHolder.tv_name.setText(arrayList.get(position).getXinXiYuanXingMing());
            viewHolder.tv_time.setText(arrayList.get(position).getTianJiaShiJian());
            viewHolder.tv_zhuangtai.setText(arrayList.get(position).getStatus());
            Log.e("tag __adapter",position+""+arrayList.get(position).getStatus());
        }
        return convertView;
    }

    public static class ViewHolder {
        public View rootView;
        public TextView tv_biaoqian;
        public TextView tv_gcname;
        public TextView tv_zhuangtai;
        public TextView tv_content;
        public TextView tv_name;
        public TextView tv_time;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.tv_biaoqian = (TextView) rootView.findViewById(R.id.tv_biaoqian);
            this.tv_gcname = (TextView) rootView.findViewById(R.id.tv_gcname);
            this.tv_zhuangtai = (TextView) rootView.findViewById(R.id.tv_zhuangtai);
            this.tv_content = (TextView) rootView.findViewById(R.id.tv_content);
            this.tv_name = (TextView) rootView.findViewById(R.id.tv_name);
            this.tv_time = (TextView) rootView.findViewById(R.id.tv_time);
        }

    }
}
