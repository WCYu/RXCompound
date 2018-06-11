package com.rxjy.rxcompound.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.base.SingleBaseAdapter;
import com.rxjy.rxcompound.commons.base.SingleViewHolder;
import com.rxjy.rxcompound.commons.utils.StringUtils;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by hjh on 2018/4/26.
 */

public class ImageAddAdapter extends SingleBaseAdapter<String, ImageAddAdapter.ViewHolder> {

    private List lists;

    public ImageAddAdapter(Context context, List<String> datas) {
        super(context, datas);
        lists = datas;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.item_imageadd;
    }

    @Override
    public ViewHolder initViewHolder() {
        return new ViewHolder();
    }

    @Override
    public void onBindView(int position, String data, ViewHolder holder) {

        if (lists.size() == 1) {
            holder.ivImgadd.setImageResource(R.drawable.ic_imgadd);
        } else if (lists.size() == 2) {
            Glide.with(context).load(data).into(holder.ivImgadd);
            if (position == getCount() - 1) {
                holder.ivImgadd.setImageResource(R.drawable.ic_imgadd);
            }
        } else {
            if (position == getCount() - 1) {
                holder.ivImgadd.setImageResource(R.drawable.ic_imgadd);
            } else {
                Glide.with(context).load(data).into(holder.ivImgadd);
            }
        }

    }

    class ViewHolder implements SingleViewHolder {
        @Bind(R.id.iv_imgadd)
        ImageView ivImgadd;

        @Override
        public void onInFlate(View v) {
            ButterKnife.bind(this, v);
        }
    }
}