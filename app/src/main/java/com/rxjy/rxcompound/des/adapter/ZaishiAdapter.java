package com.rxjy.rxcompound.des.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.base.SingleBaseAdapter;
import com.rxjy.rxcompound.commons.base.SingleViewHolder;
import com.rxjy.rxcompound.des.entity.GetZaishiInfo;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by AAA on 2017/7/26.
 */

public class ZaishiAdapter extends SingleBaseAdapter<GetZaishiInfo.BodyBean, ZaishiAdapter.ViewHolder> {

    @Bind(R.id.tv_list_item_home_date)
    TextView tvListItemHomeDate;


    public ZaishiAdapter(Context context, List<GetZaishiInfo.BodyBean> datas) {
        super(context, datas);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.list_item_home;
    }

    @Override
    public ViewHolder initViewHolder() {
        return new ViewHolder();
    }

    @Override
    public void onBindView(int position, final GetZaishiInfo.BodyBean data, ViewHolder holder) {
        holder.tvName.setText(data.getCi_ClientName());
        holder.tvAddress.setText(data.getCi_DecorationAddress());
        holder.tvstate.setText(data.getSg_StateName());
        holder.tvdate.setText(data.getSg_TrueTime());
        holder.ivImg.setVisibility(View.GONE);
//            holder.iv_phone.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent=new Intent("android.intent.action.CALL", Uri.parse("tel:"+data.getShouJiHaoYi()));
//                    context.startActivity(intent);
//                }
//            });

        if (data.getSg_StateName().equals("开工") || data.getSg_StateName().equals("施工")) {
            holder.tvstate.setTextColor(context.getResources().getColor(R.color.core60012));
        } else {
            holder.tvstate.setTextColor(context.getResources().getColor(R.color.colorGreen));
        }

    }


    class ViewHolder implements SingleViewHolder {
        @Bind(R.id.tv_list_item_home_name)
        TextView tvName;
        @Bind(R.id.tv_list_item_home_address)
        TextView tvAddress;
        @Bind(R.id.tv_list_item_home_date)
        TextView tvdate;
        @Bind(R.id.tv_list_item_home_state)
        TextView tvstate;
        @Bind(R.id.iv_img)
        ImageView ivImg;


        @Override
        public void onInFlate(View v) {
            ButterKnife.bind(this, v);
        }
    }
}
