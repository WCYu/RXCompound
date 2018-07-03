package com.rxjy.rxcompound.des.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.base.SingleBaseAdapter;
import com.rxjy.rxcompound.commons.base.SingleViewHolder;
import com.rxjy.rxcompound.des.entity.HomeBean;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by asus on 2018/5/25.
 */

public class HomeShejiAdapter extends SingleBaseAdapter<HomeBean.BodyBean.ListBean, HomeShejiAdapter.ViewHoider> {


    public HomeShejiAdapter(Context context, List<HomeBean.BodyBean.ListBean> datas) {
        super(context, datas);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.item_finddata;
    }

    @Override
    public ViewHoider initViewHolder() {
        return new ViewHoider();
    }

    @Override
    public void onBindView(int position, HomeBean.BodyBean.ListBean data, ViewHoider holder) {
        holder.tvTitle.setText(data.getTitle());
        holder.tvContect.setText(data.getSummary());
        holder.tvTimers.setText(data.getCreateTime());
        holder.ivViewse.setVisibility(View.INVISIBLE);
        holder.tvViews.setVisibility(View.INVISIBLE);
        holder.tvSpare.setText("瑞祥联盟");
        String createTime = data.getCreateTime();
        String substring = createTime.substring(5, 10);
        holder.tvTimers.setText(substring);
        if(data.getType()==0){
            holder.llZero.setVisibility(View.VISIBLE);
            holder.llThere.setVisibility(View.GONE);

            if(data.getCover().equals("")){
                Glide.with(context).load(R.mipmap.zanwei).into(holder.ivImg);
            }else {
                Glide.with(context).load(data.getCover()).into(holder.ivImg);
            }
            holder.llEdu.setVisibility(View.GONE);
        }else if(data.getType()==3){
            holder.llZero.setVisibility(View.GONE);
            holder.llThere.setVisibility(View.VISIBLE);
            if(data.getContentPic().size()==3){
                Glide.with(context).load(data.getContentPic().get(0)).into(holder.mvImgone);
                Glide.with(context).load(data.getContentPic().get(1)).into(holder.mvImgtwo);
                Glide.with(context).load(data.getContentPic().get(2)).into(holder.mvImgthere);
            }else if(data.getContentPic().size()==2){
                Glide.with(context).load(data.getContentPic().get(0)).into(holder.mvImgone);
                Glide.with(context).load(data.getContentPic().get(1)).into(holder.mvImgtwo);
            }else {
                Glide.with(context).load(data.getContentPic().get(0)).into(holder.mvImgone);
            }
            holder.llEdu.setVisibility(View.GONE);

        }
    }

    public class ViewHoider implements SingleViewHolder {
        @Bind(R.id.iv_imgone)
        ImageView ivImgone;
        @Bind(R.id.tv_titleone)
        TextView tvTitleone;
        @Bind(R.id.tv_timeone)
        TextView tvTimeone;
        @Bind(R.id.ll_one)
        LinearLayout llOne;
        @Bind(R.id.iv_img)
        ImageView ivImg;
        @Bind(R.id.tv_title)
        TextView tvTitle;
        @Bind(R.id.tv_contect)
        TextView tvContect;
        @Bind(R.id.ll_zero)
        LinearLayout llZero;
        @Bind(R.id.lv_title)
        TextView lvTitle;
        @Bind(R.id.mv_imgone)
        ImageView mvImgone;
        @Bind(R.id.mv_imgtwo)
        ImageView mvImgtwo;
        @Bind(R.id.mv_imgthere)
        ImageView mvImgthere;
        @Bind(R.id.ll_there)
        LinearLayout llThere;
        @Bind(R.id.tv_spare)
        TextView tvSpare;
        @Bind(R.id.tv_like)
        TextView tvLike;
        @Bind(R.id.iv_like)
        ImageView ivLike;
        @Bind(R.id.iv_viewse)
        ImageView ivViewse;
        @Bind(R.id.tv_views)
        TextView tvViews;
        @Bind(R.id.tv_timers)
        TextView tvTimers;
        @Bind(R.id.iv_imgedu)
        ImageView ivImgedu;
        @Bind(R.id.tv_edutitle)
        TextView tvEdutitle;
        @Bind(R.id.tv_into)
        TextView tvInto;
        @Bind(R.id.ll_edu)
        LinearLayout llEdu;
        @Override
        public void onInFlate(View v) {
            ButterKnife.bind(this, v);
        }
    }
}
