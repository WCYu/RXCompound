package com.rxjy.rxcompound.supervision.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.base.SingleBaseAdapter;
import com.rxjy.rxcompound.commons.base.SingleViewHolder;
import com.rxjy.rxcompound.supervision.entity.DatumListInfo;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by AAA on 2017/12/21.
 */

public class PaperAdapter extends SingleBaseAdapter<DatumListInfo.DatumInfo.Datum, PaperAdapter.ViewHolder> {

    public interface OnPaperAdapterClickListener{

        void uploadListener(DatumListInfo.DatumInfo.Datum data);

        void readListener(DatumListInfo.DatumInfo.Datum data);

    }

    private OnPaperAdapterClickListener mListener;

    public PaperAdapter(Context context, List<DatumListInfo.DatumInfo.Datum> datas) {
        super(context, datas);
    }

    public void setOnPaperAdapterClickListener(OnPaperAdapterClickListener mListener){
        this.mListener = mListener;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.list_item_paper;
    }

    @Override
    public ViewHolder initViewHolder() {
        return new ViewHolder();
    }

    @Override
    public void onBindView(int position, final DatumListInfo.DatumInfo.Datum data, ViewHolder holder) {
        if (data.getIsHeader() == 1) {
            holder.linPaper.setVisibility(View.VISIBLE);
            holder.rlPaper.setVisibility(View.GONE);

            holder.tvPaperTitle.setText(data.getHeaderName());
        } else {
            holder.linPaper.setVisibility(View.GONE);
            holder.rlPaper.setVisibility(View.VISIBLE);

            holder.tvPaper.setText(data.getAttr_name());
            if (data.getConfirm_status() == 5){
                holder.ivPaper.setImageResource(R.mipmap.read_btn_icon);
                holder.ivPaper.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (mListener != null)
                            mListener.readListener(data);
                    }
                });
            }else {
                holder.ivPaper.setImageResource(R.mipmap.upload_btn_icon);
                holder.ivPaper.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (mListener != null)
                            mListener.uploadListener(data);
                    }
                });
            }
        }
    }

    class ViewHolder implements SingleViewHolder {
        @Bind(R.id.tv_paper_title)
        TextView tvPaperTitle;
        @Bind(R.id.lin_paper)
        LinearLayout linPaper;
        @Bind(R.id.tv_paper)
        TextView tvPaper;
        @Bind(R.id.iv_paper)
        ImageView ivPaper;
        @Bind(R.id.rl_paper)
        RelativeLayout rlPaper;

        @Override
        public void onInFlate(View v) {
            ButterKnife.bind(this, v);
        }
    }
}
