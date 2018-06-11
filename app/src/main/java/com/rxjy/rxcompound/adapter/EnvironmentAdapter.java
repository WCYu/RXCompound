package com.rxjy.rxcompound.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.base.SingleBaseAdapter;
import com.rxjy.rxcompound.commons.base.SingleViewHolder;
import com.rxjy.rxcompound.entity.EnvirBean;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by hjh on 2018/4/25.
 */

public class EnvironmentAdapter extends SingleBaseAdapter<EnvirBean.BodyBean, EnvironmentAdapter.ViewHolder> {

    public EnvironmentAdapter(Context context, List<EnvirBean.BodyBean> datas) {
        super(context, datas);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.item_envir;
    }

    @Override
    public ViewHolder initViewHolder() {
        return new ViewHolder();
    }

    @Override
    public void onBindView(int position, EnvirBean.BodyBean data, ViewHolder holder) {
        holder.tvTitle.setText(data.getAreaName());
    }


//    public EnvironmentAdapter(Context context, List<String> datas) {
//        super(context, datas);
//    }
//
//    @Override
//    public int getLayoutRes() {
//        return R.layout.item_envir;
//    }
//
//    @Override
//    public ViewHolder initViewHolder() {
//        return new ViewHolder();
//    }
//
//    @Override
//    public void onBindView(int position, String data, ViewHolder holder) {
//        holder.tvTitle.setText(data);
//    }data

    class ViewHolder implements SingleViewHolder {
        @Bind(R.id.tv_title)
        TextView tvTitle;

        @Override
        public void onInFlate(View v) {
            ButterKnife.bind(this, v);
        }
    }
}
