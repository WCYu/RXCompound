package com.rxjy.rxcompound.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.App;
import com.rxjy.rxcompound.commons.base.SingleBaseAdapter;
import com.rxjy.rxcompound.commons.base.SingleViewHolder;
import com.rxjy.rxcompound.entity.InfoMessageBodyBean;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by asus on 2018/5/18.
 */

public class NewsRedAdapter extends SingleBaseAdapter<InfoMessageBodyBean, NewsRedAdapter.ViewHolder> {


    public NewsRedAdapter(Context context, List<InfoMessageBodyBean> datas) {
        super(context, datas);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.item_xiaoxi;
    }

    @Override
    public ViewHolder initViewHolder() {
        return new ViewHolder();
    }

    @Override
    public void onBindView(int position, InfoMessageBodyBean data, ViewHolder holder) {
        holder.tvTasktitle.setText(data.getTitle());
        holder.tvTime.setText(data.getCreate_date());
        holder.tvPerson.setText("内容 : "+data.getTxt());
        Log.e("tag",data.getReward_money());


        if(App.regionid.equals("39")){

            String[] split = data.getReward_money().split(" ");
            holder.tvReward.setText(split[0]);
        }else {
            holder.zongliang.setText(data.getTask_num());
            holder.allowance.setText(data.getTask_balance());
            holder.tvReward.setText(data.getReward_money());
        }

    }

    public class ViewHolder implements SingleViewHolder {
        @Bind(R.id.tv_tasktitle)
        TextView tvTasktitle;
        @Bind(R.id.allowance)
        TextView allowance;
        @Bind(R.id.tv_time)
        TextView tvTime;
        @Bind(R.id.tv_person)
        TextView tvPerson;
        @Bind(R.id.tv_reward)
        TextView tvReward;
        @Bind(R.id.tv_content)
        TextView tvContent;
        @Bind(R.id.ll_view)
        LinearLayout llView;
        @Bind(R.id.zongliang)
        TextView zongliang;
        @Override
        public void onInFlate(View v) {
            ButterKnife.bind(this, v);
        }
    }
}
