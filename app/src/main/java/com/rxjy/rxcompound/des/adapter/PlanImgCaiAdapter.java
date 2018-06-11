package com.rxjy.rxcompound.des.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.base.SingleBaseAdapter;
import com.rxjy.rxcompound.commons.base.SingleViewHolder;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/4/17.
 */

public class PlanImgCaiAdapter extends SingleBaseAdapter<String, PlanImgCaiAdapter.ViewHolder> {


    public PlanImgCaiAdapter(Context context, List<String> datas) {
        super(context, datas);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.img;
    }

    @Override
    public PlanImgCaiAdapter.ViewHolder initViewHolder() {
        return new PlanImgCaiAdapter.ViewHolder();
    }

    @Override
    public void onBindView(int position, String data, PlanImgCaiAdapter.ViewHolder holder) {
        RequestOptions options = new RequestOptions();
        options.error(R.drawable.ic_imgdefault);
        Glide.with(context).load(data).apply(options).into(holder.ivImg);
    }

    class ViewHolder implements SingleViewHolder {

        @Bind(R.id.iv_img)
        ImageView ivImg;
        @Override
        public void onInFlate(View v) {
            ButterKnife.bind(this, v);
        }
    }

}