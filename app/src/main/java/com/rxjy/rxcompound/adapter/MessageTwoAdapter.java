package com.rxjy.rxcompound.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.activity.IdentityInfoNewActivity;
import com.rxjy.rxcompound.activity.MessageDetailsActivity;
import com.rxjy.rxcompound.activity.ZThreeActivity;
import com.rxjy.rxcompound.commons.base.SingleBaseAdapter;
import com.rxjy.rxcompound.commons.base.SingleViewHolder;
import com.rxjy.rxcompound.commons.utils.StringUtils;
import com.rxjy.rxcompound.entity.InfoMessageBodyBean;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by hjh on 2018/3/9.
 */

public class MessageTwoAdapter extends SingleBaseAdapter<InfoMessageBodyBean, MessageTwoAdapter.ViewHolder> {


    public MessageTwoAdapter(Context context, List<InfoMessageBodyBean> datas) {
        super(context, datas);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.item_messageer;
    }

    @Override
    public ViewHolder initViewHolder() {
        return new ViewHolder();
    }

    @Override
    public void onBindView(int position, final InfoMessageBodyBean data, ViewHolder holder) {
        String time = data.getCreate_date();
        if (!StringUtils.isEmpty(time) ) {
            holder.lvTime.setText(time);
        }
        holder.tvTitle.setText(data.getTitle());
        holder.tvContent.setText(data.getTxt());
      // holder.lvDate.setText(data.);

//        holder.rlDetails.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //进入详情
//                if (data.getType().equals("1") || data.getType().equals("2")) {
//                    context.startActivity(new Intent(context, IdentityInfoNewActivity.class));
//                } else if (data.getType().equals("3")) {//入职资料
//                    context.startActivity(new Intent(context, ZThreeActivity.class));
//                } else {
//                    context.startActivity(new Intent(context, MessageDetailsActivity.class).putExtra("id", data.getId() + ""));
//                }
//            }
//        });
    }

    class ViewHolder implements SingleViewHolder {

        @Bind(R.id.tv_time)
        TextView tvTime;
        @Bind(R.id.tv_title)
        TextView tvTitle;
        @Bind(R.id.tv_content)
        TextView tvContent;
        @Bind(R.id.rl_details)

        RelativeLayout rlDetails;
        @Bind(R.id.lv_time)
        TextView lvTime;
        @Bind(R.id.lv_Date)
        TextView lvDate;
        @Override
        public void onInFlate(View v) {
            ButterKnife.bind(this, v);
        }
    }
}
