package com.rxjy.rxcompound.supervision.adapter;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.base.SingleBaseAdapter;
import com.rxjy.rxcompound.commons.base.SingleViewHolder;
import com.rxjy.rxcompound.commons.utils.TimeUtil;
import com.rxjy.rxcompound.supervision.entity.RoutingListInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by AAA on 2017/11/3.
 */

public class RoutingAdapter extends SingleBaseAdapter<RoutingListInfo.RoutingInfo, RoutingAdapter.ViewHolder> {

    public interface OnRoutingAdapterClick {

        void onPushTaskClick(RoutingListInfo.RoutingInfo data);

    }

    private OnRoutingAdapterClick mListener;

    private Map<String, Integer> markMap;

    public RoutingAdapter(Context context, List<RoutingListInfo.RoutingInfo> datas) {
        super(context, datas);
        initMap();
    }

    private void initMap() {
        markMap = new HashMap<>();
        markMap.put("1", R.mipmap.mark_gc_icon);
        markMap.put("2", R.mipmap.mark_jd_icon);
        markMap.put("3", R.mipmap.mark_aq_icon);
        markMap.put("4", R.mipmap.mark_hj_icon);
        markMap.put("5", R.mipmap.mark_cl_icon);
        markMap.put("6", R.mipmap.mark_xm_icon);
        markMap.put("100", R.mipmap.mark_xc_icon);
    }

    public void setOnRoutingAdapterListener(OnRoutingAdapterClick mListener) {
        this.mListener = mListener;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.list_item_routing;
    }

    @Override
    public ViewHolder initViewHolder() {
        return new ViewHolder();
    }

    @Override
    public void onBindView(int position, final RoutingListInfo.RoutingInfo data, ViewHolder holder) {
        holder.tvContent.setText(data.getXj_content());
        holder.tvTime.setText(TimeUtil.getNormalTime(data.getXj_finishtime()));
        showStatusIcon(holder.ivOne, holder.ivTwo, holder.ivThree, data.getXj_tag());
        holder.btnTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null)
                    mListener.onPushTaskClick(data);
            }
        });
    }

    private void showStatusIcon(ImageView ivOne, ImageView ivTwo, ImageView ivThree, List<String> stateList) {
        switch (stateList.size()) {
            case 0:
                ivOne.setVisibility(View.GONE);
                ivTwo.setVisibility(View.GONE);
                ivThree.setVisibility(View.GONE);
                break;
            case 1:
                ivOne.setVisibility(View.VISIBLE);
                ivTwo.setVisibility(View.GONE);
                ivThree.setVisibility(View.GONE);
                ivOne.setImageResource(markMap.get(stateList.get(0)));
                break;
            case 2:
                ivOne.setVisibility(View.VISIBLE);
                ivTwo.setVisibility(View.VISIBLE);
                ivThree.setVisibility(View.GONE);
                ivOne.setImageResource(markMap.get(stateList.get(0)));
                ivTwo.setImageResource(markMap.get(stateList.get(1)));
                break;
            default:
                ivOne.setVisibility(View.VISIBLE);
                ivTwo.setVisibility(View.VISIBLE);
                ivThree.setVisibility(View.VISIBLE);
                ivOne.setImageResource(markMap.get(stateList.get(0)));
                ivTwo.setImageResource(markMap.get(stateList.get(1)));
                ivThree.setImageResource(markMap.get(stateList.get(2)));
                break;
        }
    }

    class ViewHolder implements SingleViewHolder {
        @Bind(R.id.tv_list_item_routing_content)
        TextView tvContent;
        @Bind(R.id.tv_list_item_routing_time)
        TextView tvTime;
        @Bind(R.id.iv_list_item_routing_status_one)
        ImageView ivOne;
        @Bind(R.id.iv_list_item_routing_status_two)
        ImageView ivTwo;
        @Bind(R.id.iv_list_item_routing_status_three)
        ImageView ivThree;
        @Bind(R.id.btn_list_item_routing_push_task)
        Button btnTask;

        @Override
        public void onInFlate(View v) {
            ButterKnife.bind(this, v);
        }
    }
}
