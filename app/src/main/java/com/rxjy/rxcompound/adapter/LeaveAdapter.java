package com.rxjy.rxcompound.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.base.SingleBaseAdapter;
import com.rxjy.rxcompound.commons.base.SingleViewHolder;
import com.rxjy.rxcompound.entity.LeaveBean;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by asus on 2018/5/17.
 */

public class LeaveAdapter extends SingleBaseAdapter<LeaveBean.BodyBean, LeaveAdapter.ViewHoider> {


    public LeaveAdapter(Context context, List<LeaveBean.BodyBean> datas) {
        super(context, datas);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.item_leave_item;
    }

    @Override
    public ViewHoider initViewHolder() {
        return new ViewHoider();
    }

    @Override
    public void onBindView(int position, LeaveBean.BodyBean data, ViewHoider holder) {
        holder.leaveTitle.setText(data.getTypeName());
        //holder.leaveResults.setText(data.get);
        if(data.getState()==1){
            holder.leaveResults.setText("审核通过");
            holder.leaveResults.setTextColor(context.getResources().getColor(R.color.colorAccents));
        }else {
            holder.leaveResults.setText("待审");
            holder.leaveResults.setTextColor(context.getResources().getColor(R.color.colorred));
        }
        holder.leaveReason.setText("原因: 1"+data.getReason());
        holder.leaveResult.setText(data.getDays()+" 天");
    }

    public class ViewHoider implements SingleViewHolder {
        @Bind(R.id.leave_title)
        TextView leaveTitle;
        @Bind(R.id.leave_results)
        TextView leaveResults;
        @Bind(R.id.leave_Reason)
        TextView leaveReason;
        @Bind(R.id.leave_Result)
        TextView leaveResult;
        @Override
        public void onInFlate(View v) {
            ButterKnife.bind(this, v);
        }
    }
}
