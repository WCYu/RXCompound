package com.rxjy.rxcompound.supervision.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.luck.picture.lib.entity.LocalMedia;
import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.base.SingleBaseAdapter;
import com.rxjy.rxcompound.commons.base.SingleViewHolder;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by AAA on 2017/11/6.
 */

public class ImageAdapter extends SingleBaseAdapter<LocalMedia, ImageAdapter.ViewHolder> {

    private int type = 0;

    public ImageAdapter(Context context, List<LocalMedia> datas) {
        super(context, datas);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.list_item_image;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public ViewHolder initViewHolder() {
        return new ViewHolder();
    }

    @Override
    public void onBindView(int position, LocalMedia data, ViewHolder holder) {
        if(data.getPath()!=null) {

        }
        if (type == 0) {
            if (position == (getCount() - 1)) {
                holder.ivImage.setImageResource(R.mipmap.camera_sub_icon);
            } else {
                RequestOptions options = new RequestOptions();
                options.placeholder(R.mipmap.placeholder_icon);
                options.error(R.mipmap.placeholder_icon);
                Glide.with(context).load(data.getPath()).apply(options).into(holder.ivImage);
            }
        }
        if (type == 1) {
            if (position == 0) {
                holder.ivImage.setImageResource(R.mipmap.camera_sub_icon);
            } else {
                RequestOptions options = new RequestOptions();
                options.placeholder(R.mipmap.placeholder_icon);
                options.error(R.mipmap.placeholder_icon);
                Glide.with(context).load(data.getPath()).apply(options).into(holder.ivImage);
            }
        } else if (type == 2) {
            RequestOptions options = new RequestOptions();
            options.placeholder(R.mipmap.placeholder_icon);
            options.error(R.mipmap.photo_un_upload_icon);
            Glide.with(context).load(data.getPath()).apply(options).into(holder.ivImage);
        } else {
            RequestOptions options = new RequestOptions();
            options.placeholder(R.mipmap.placeholder_icon);
            options.error(R.mipmap.placeholder_icon);
            Glide.with(context).load(data.getPath()).apply(options).into(holder.ivImage);
        }
    }

    class ViewHolder implements SingleViewHolder {
        @Bind(R.id.iv_list_item_image)
        ImageView ivImage;

        @Override
        public void onInFlate(View v) {
            ButterKnife.bind(this, v);
        }
    }
}
