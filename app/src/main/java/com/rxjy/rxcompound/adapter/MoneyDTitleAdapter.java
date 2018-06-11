package com.rxjy.rxcompound.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.base.SingleBaseAdapter;
import com.rxjy.rxcompound.commons.base.SingleViewHolder;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by hjh on 2018/3/16.
 */

public class MoneyDTitleAdapter extends SingleBaseAdapter<String, MoneyDTitleAdapter.ViewHolder> {


    public MoneyDTitleAdapter(Context context, List<String> datas) {
        super(context, datas);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.item_txt;
    }

    @Override
    public ViewHolder initViewHolder() {
        return new ViewHolder();
    }

    @Override
    public void onBindView(int position, String data, ViewHolder holder) {
        holder.tvTxt.setText(data);
    }

    class ViewHolder implements SingleViewHolder {

        @Bind(R.id.tv_txt)
        TextView tvTxt;

        @Override
        public void onInFlate(View v) {
            ButterKnife.bind(this, v);
        }
    }

}