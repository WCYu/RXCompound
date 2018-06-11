package com.rxjy.rxcompound.supervision.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.base.SingleBaseAdapter;
import com.rxjy.rxcompound.commons.base.SingleViewHolder;
import com.rxjy.rxcompound.supervision.entity.ProcessDetailInfo;

import java.util.List;

/**
 * Created by Administrator on 2017/2/6.
 */
public class ProcessDetailAdapter extends SingleBaseAdapter<ProcessDetailInfo.ProcessDetail, ProcessDetailAdapter.ViewHolder> {

    public interface OnProcessDetailClickListener {

        void largePhoto(String url);

        void subProcessPhoto(ProcessDetailInfo.ProcessDetail data, int position);

    }

    private OnProcessDetailClickListener mListener;

    public ProcessDetailAdapter(Context context, List<ProcessDetailInfo.ProcessDetail> datas) {
        super(context, datas);
    }

    public void setListener(OnProcessDetailClickListener mListener) {
        this.mListener = mListener;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.list_item_process_detail;
    }

    @Override
    public ViewHolder initViewHolder() {
        return new ViewHolder();
    }

    @Override
    public void onBindView(final int position, final ProcessDetailInfo.ProcessDetail data, ViewHolder holder) {

        holder.tvStep.setText("" + (position + 1));
        holder.tvName.setText(data.getStepName());
        holder.tvDesc.setText(data.getStepDesc());
        RequestOptions options = new RequestOptions();
        options.placeholder(R.mipmap.placeholder_icon);
        options.error(R.mipmap.placeholder_icon);
        RequestOptions optionsUser = new RequestOptions();
        optionsUser.placeholder(R.mipmap.camera_sub_icon);
        optionsUser.error(R.mipmap.camera_sub_icon);
        Glide.with(context).load(data.getStepPhotoUrl()).apply(options).into(holder.ivStandard);

        Glide.with(context).load(data.getPhotoUrl()).apply(optionsUser).into(holder.ivUser);

        //开工准备审核状态  0-待审核   1-合格   2-不合格
        holder.ivDel.setVisibility(View.GONE);
//        if (data.getManager_audit() == 0){
//            holder.ivStatus.setVisibility(View.GONE);
//            holder.rlTip.setVisibility(View.VISIBLE);
//            holder.ivDel.setVisibility(View.GONE);
//        }else if (data.getManager_audit() == 1){
//            holder.ivStatus.setVisibility(View.VISIBLE);
//            holder.rlTip.setVisibility(View.GONE);
//        }else if (data.getManager_audit() == 2){
//            holder.ivStatus.setVisibility(View.GONE);
//            holder.rlTip.setVisibility(View.VISIBLE);
//            holder.ivDel.setVisibility(View.VISIBLE);
//        }else if (data.getPhotoUrl().length() == 0){
//
//        }
//        switch (data.getManager_audit()) {
//            case 0:
//                holder.ivStatus.setVisibility(View.GONE);
//                holder.rlTip.setVisibility(View.VISIBLE);
//                holder.ivDel.setVisibility(View.GONE);
//                break;
//            case 1:
//                holder.ivStatus.setVisibility(View.VISIBLE);
//                holder.rlTip.setVisibility(View.GONE);
//                break;
//            case 2:
//                holder.ivStatus.setVisibility(View.GONE);
//                holder.rlTip.setVisibility(View.VISIBLE);
//                holder.ivDel.setVisibility(View.VISIBLE);
//                break;
//        }

//        if (data.getPhotoUrl().length() == 0) {
//            holder.ivUser.setScaleType(ImageView.ScaleType.CENTER);
//        } else {
//            holder.ivUser.setScaleType(ImageView.ScaleType.CENTER_CROP);
//        }

        holder.ivUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (data.getPhotoUrl().length() == 0) {
                    if (mListener != null)
                        mListener.subProcessPhoto(data, position);
                } else {
                    if (mListener != null)
                        mListener.largePhoto(data.getPhotoUrl());
                }
            }
        });

        holder.ivStandard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (data.getStepPhotoUrl() != null) {
                    if (mListener != null)
                        mListener.largePhoto(data.getStepPhotoUrl());
                }
            }
        });

    }

    class ViewHolder implements SingleViewHolder {

        TextView tvStep;
        TextView tvName;
        TextView tvDesc;
        ImageView ivStandard;
        ImageView ivUser;
        ImageView ivStatus;
        ImageView ivDel;
        RelativeLayout rlTip;

        @Override
        public void onInFlate(View v) {
            tvStep = (TextView) v.findViewById(R.id.tv_list_item_process_detail_step);
            tvName = (TextView) v.findViewById(R.id.tv_list_item_process_detail_step_name);
            tvDesc = (TextView) v.findViewById(R.id.tv_list_item_process_detail_step_desc);
            ivStandard = (ImageView) v.findViewById(R.id.iv_list_item_process_detail_standard_photo);
            ivUser = (ImageView) v.findViewById(R.id.iv_list_item_process_detail_user_photo);
            ivStatus = (ImageView) v.findViewById(R.id.iv_list_item_process_detail_pass);
            ivDel = (ImageView) v.findViewById(R.id.iv_list_item_process_detail_del);
            rlTip = (RelativeLayout) v.findViewById(R.id.rl_list_item_process_detail_tip);
        }
    }
}
