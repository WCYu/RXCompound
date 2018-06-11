package com.rxjy.rxcompound.des.adapter;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.base.SingleBaseAdapter;
import com.rxjy.rxcompound.commons.base.SingleViewHolder;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by hjh on 2017/12/8.
 */

public class TextGridviewAdapter extends SingleBaseAdapter<String, TextGridviewAdapter.ViewHolder> {


    int setstyle=-1;

    public int getSetstyle() {
        return setstyle;
    }

    public void setSetstyle(int setstyle) {
        this.setstyle = setstyle;
    }

    public TextGridviewAdapter(Context context, List<String> datas) {
        super(context, datas);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.gv_item_textgv;
    }

    @Override
    public ViewHolder initViewHolder() {
        return new ViewHolder();
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBindView(int position, String data, ViewHolder holder) {
        holder.tvItem.setText(data);
        if(getSetstyle()==position){
            holder.tvItem.setTextColor(context.getResources().getColor(R.color.cor00a0e9));
            holder.tvItem.setBackground(context.getResources().getDrawable(R.drawable.border_blue));
//            holder.tvItem.setBackground(context.getResources().getDrawable(R.drawable.border_blue));
        }else{
            holder.tvItem.setTextColor(context.getResources().getColor(R.color.cor666));
            holder.tvItem.setBackground(context.getResources().getDrawable(R.drawable.border_write));
        }
    }

    class ViewHolder implements SingleViewHolder {

        @Bind(R.id.tv_item)
        TextView tvItem;

        @Override
        public void onInFlate(View v) {
            ButterKnife.bind(this, v);
        }
    }
}
