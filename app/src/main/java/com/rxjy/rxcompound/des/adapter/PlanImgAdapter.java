package com.rxjy.rxcompound.des.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.base.SingleBaseAdapter;
import com.rxjy.rxcompound.commons.base.SingleViewHolder;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by hjh on 2018/4/17.
 */

public class PlanImgAdapter extends SingleBaseAdapter<String, PlanImgAdapter.ViewHolder> {


    public PlanImgAdapter(Context context, List<String> datas) {
        super(context, datas);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.img;
    }

    @Override
    public ViewHolder initViewHolder() {
        return new ViewHolder();
    }

    @Override
    public void onBindView(int position, String data, ViewHolder holder) {
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