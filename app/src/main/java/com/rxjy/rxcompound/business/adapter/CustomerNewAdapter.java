package com.rxjy.rxcompound.business.adapter;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.business.activity.CustomerFollowActivity;
import com.rxjy.rxcompound.business.entity.CustomerNewBean;
import com.rxjy.rxcompound.commons.base.SingleBaseAdapter;
import com.rxjy.rxcompound.commons.base.SingleViewHolder;
import com.rxjy.rxcompound.commons.utils.StringUtils;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by hjh on 2018/5/11.
 */

public class CustomerNewAdapter extends SingleBaseAdapter<CustomerNewBean.BodyBean,CustomerNewAdapter.ViewHolder>{



    public CustomerNewAdapter(Context context, List<CustomerNewBean.BodyBean> datas) {
        super(context, datas);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.item_customer;
    }

    @Override
    public ViewHolder initViewHolder() {
        return new ViewHolder();
    }

    @Override
    public void onBindView(int position, final CustomerNewBean.BodyBean data, ViewHolder holder) {
        if (!StringUtils.isEmpty(data.getXingMing()) && !StringUtils.isEmpty(data.getGongSiMingCheng())) {
            holder.tvName.setText(data.getXingMing() + "-" + data.getGongSiMingCheng());
        } else if (!StringUtils.isEmpty(data.getXingMing()) ) {
            holder.tvName.setText(data.getXingMing());
        }else{
            holder.tvName.setText(data.getShouJiHao());
        }

//        if (data.getVisitContent() != null) {
//            holder.tvContent.setText(data.getVisitContent());
//        } else {
//            holder.tvContent.setText("");
//        }

//        holder.tvPerson.setText("信息员  " + data.getXinXiYuanXingMing());
        holder.tvPerson.setText("信息员  暂无" );
        holder.tvTime.setText(data.getTianJiaShiJian());
//        if (!StringUtils.isEmpty(data.getStatus())) {
//            holder.tvStatus.setText(data.getStatus());
//        }
        if (!StringUtils.isEmpty(data.getChannelName())) {
            switch (data.getChannelName()) {
                case "办公":
                    holder.ivType.setImageResource(R.drawable.ic_typeoffice);
                    break;
                case "餐饮":
                    holder.ivType.setImageResource(R.drawable.ic_typefood);
                    break;
                case "互联网":
                    holder.ivType.setImageResource(R.drawable.ic_typenet);
                    break;
                case "酒店":
                    holder.ivType.setImageResource(R.drawable.ic_typehotel);
                    break;
                case "商业":
                    holder.ivType.setImageResource(R.drawable.ic_typebusi);
                    break;
                case "其它":
                    holder.ivType.setImageResource(R.drawable.ic_typeother);
                    break;
                default:
                    holder.ivType.setImageResource(R.drawable.ic_typeother);
                    break;
            }
        } else {
            holder.ivType.setImageResource(R.drawable.ic_typeother);
        }
        holder.ivAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//跟进
                context.startActivity(new Intent(context, CustomerFollowActivity.class)
                        .putExtra("customerid", data.getKeHuBaseID() + "")
//                        .putExtra("saleid", data.getYeWuYuanID() + "")
                );
            }
        });
        holder.ivPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + data.getShouJiHao()));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                try {
                    context.startActivity(intent);
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(context, "请检查您的手机，无法拨打电话！", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    class ViewHolder implements SingleViewHolder {
        @Bind(R.id.iv_type)
        ImageView ivType;
        @Bind(R.id.tv_name)
        TextView tvName;
        @Bind(R.id.iv_go)
        ImageView ivGo;
        @Bind(R.id.tv_status)
        TextView tvStatus;
        @Bind(R.id.tv_content)
        TextView tvContent;
        @Bind(R.id.tv_person)
        TextView tvPerson;
        @Bind(R.id.tv_time)
        TextView tvTime;
        @Bind(R.id.iv_add)
        ImageView ivAdd;
        @Bind(R.id.iv_phone)
        ImageView ivPhone;

        @Override
        public void onInFlate(View v) {
            ButterKnife.bind(this, v);
        }
    }
}
