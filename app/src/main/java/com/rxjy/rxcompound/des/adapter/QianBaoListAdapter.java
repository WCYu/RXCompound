package com.rxjy.rxcompound.des.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.base.SingleBaseAdapter;
import com.rxjy.rxcompound.commons.base.SingleViewHolder;
import com.rxjy.rxcompound.des.entity.QianBaoInfo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/8/25.
 */

public class QianBaoListAdapter extends SingleBaseAdapter<QianBaoInfo.BodyBean.SalaryDetailBean, QianBaoListAdapter.ViewHolder> {


    private String month;
    private int mPosition = 0;
    private Map<Integer, Boolean> map;

    public QianBaoListAdapter(Context context, List<QianBaoInfo.BodyBean.SalaryDetailBean> datas) {
        super(context, datas);
        map = new HashMap<>();
    }

    @Override
    public int getLayoutRes() {
        return R.layout.list_item_qianbao;
    }

    @Override
    public ViewHolder initViewHolder() {
        return new ViewHolder();
    }

    @Override
    public void onBindView(int position, QianBaoInfo.BodyBean.SalaryDetailBean data, ViewHolder holder) {
        holder.tvListItemQianbaoXmdate.setText(data.getCreateTime());
        holder.tvListItemQianbaoXmname.setText(data.getRwdid());
        holder.tvListItemQianbaoXmnamehou.setText(data.getCliType());
        holder.tvListItemQianbaoXmyushoutype2.setText(data.getCliType());
        holder.tvListItemQianbaoXmyushoumoney.setText(data.getIncome() + "");
        holder.tvListItemQianbaoXmjdsrMoney.setText(data.getIncome() + "");
        holder.tvListItemQianbaoXmyushoutype.setText(data.getCliType());
        holder.tvListItemQianbaoXmjdsrFen.setText(data.getPoints() + "");
        holder.tvListItemQianbaoXmjdsrMoney.setText(data.getIncome() + "");
        String time = data.getCreateTime().substring(0, 7).replace("-", "年") + "月";

        // String time=getDateToString(data.getTimeNum());
        holder.tvQianbaoFirstMonth.setText(time);

        if (position >= mPosition) {
            mPosition = position;
            if (position == 0) {
                month = time.substring(time.indexOf("年") + 1, time.indexOf("月"));
                holder.ll_first_time.setVisibility(View.VISIBLE);
                map.put(position, true);
            } else {
                if (time.substring(time.indexOf("年") + 1, time.indexOf("月")).equals(month)) {
                    holder.ll_first_time.setVisibility(View.GONE);
                    map.put(position, false);
                } else {
                    holder.ll_first_time.setVisibility(View.VISIBLE);
                    month = time.substring(time.indexOf("年") + 1, time.indexOf("月"));
                    map.put(position, true);
                }
            }
        } else {
            if (position == 0) {
                mPosition = 0;
            }
            Boolean flag = map.get(position);
            if (flag) {
                holder.ll_first_time.setVisibility(View.VISIBLE);
            } else {
                holder.ll_first_time.setVisibility(View.GONE);
            }
        }


    }


    public String getDateToString(long time) {
        Log.e("time", time + "");
        //1503657014013
        //1503655338
        //1503655338
        Date date = new Date();
        date.setTime(Long.parseLong("1503655338"));

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String str = sdf.format(date);
        return str;
    }

    class ViewHolder implements SingleViewHolder {
        @Bind(R.id.tv_qianbao_first_month)
        TextView tvQianbaoFirstMonth;
        @Bind(R.id.tv_list_item_qianbao_xmdate)
        TextView tvListItemQianbaoXmdate;
        @Bind(R.id.imageView)
        ImageView imageView;
        @Bind(R.id.tv_list_item_qianbao_xmname)
        TextView tvListItemQianbaoXmname;
        @Bind(R.id.tv_list_item_qianbao_xmnamehou)
        TextView tvListItemQianbaoXmnamehou;
        @Bind(R.id.tv_list_item_qianbao_xmyushoutype)
        TextView tvListItemQianbaoXmyushoutype2;
        @Bind(R.id.tv_list_item_qianbao_xmyushoumoney)
        TextView tvListItemQianbaoXmyushoumoney;
        @Bind(R.id.tv_list_item_qianbao_xmjdsr_type)
        TextView tvListItemQianbaoXmyushoutype;
        @Bind(R.id.tv_list_item_qianbao_xmjdsr_fen)
        TextView tvListItemQianbaoXmjdsrFen;
        @Bind(R.id.tv_list_item_qianbao_xmjdsr_money)
        TextView tvListItemQianbaoXmjdsrMoney;
        @Bind(R.id.tv_list_item_qianbao_xmtype)
        TextView tvListItemQianbaoXmtype;
        @Bind(R.id.ll_first_time)
        LinearLayout ll_first_time;

        @Override
        public void onInFlate(View v) {
            ButterKnife.bind(this, v);
        }
    }


}
