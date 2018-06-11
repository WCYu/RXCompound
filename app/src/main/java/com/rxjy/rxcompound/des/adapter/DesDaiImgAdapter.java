package com.rxjy.rxcompound.des.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.Constants;
import com.rxjy.rxcompound.commons.utils.AutoUtils;
import com.rxjy.rxcompound.des.entity.AllImagesInfo;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by qindd on 2017/6/21.
 */
public class DesDaiImgAdapter extends BaseAdapter {

    private Context mContext;
    private List<AllImagesInfo.Album> dataList;

    public DesDaiImgAdapter(Context context, List<AllImagesInfo.Album> dataList) {
        this.mContext = context;
        this.dataList = dataList;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.gridview_item_des_dai, null);
            AutoUtils.auto(convertView);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        AllImagesInfo.Album info = dataList.get(position);
        Log.i("allimagesinfo", info.getCatalogIDName());
        viewHolder.tvCount.setText(info.getCatalogCount() + "");
        viewHolder.tvName.setText(info.getCatalogIDName());
        //viewHolder.tvType.setText(info.getCatalogShowType());
        if (info.getCatalogShowType().equals("横拍")) {
            viewHolder.tvType.setImageResource(R.mipmap.hor_photo);
        } else if (info.getCatalogShowType().equals("竖拍")) {
            viewHolder.tvType.setImageResource(R.mipmap.ver_photo);
        }
        int size = info.getChildList().size();
        if (size != 0) {
            RequestOptions options = new RequestOptions().centerCrop().placeholder(R.mipmap.zhanweitu);
            Glide.with(mContext).load(Constants.WenesImgBaseURl + info.getChildList().get(0).getImageUrl()).apply(options).into(viewHolder.ivMeasure);
            viewHolder.ivMeasure.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else {
            viewHolder.ivMeasure.setImageResource(R.mipmap.photo);
            viewHolder.ivMeasure.setScaleType(ImageView.ScaleType.CENTER);
        }
        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.iv_des_dai)
        ImageView ivMeasure;
        @Bind(R.id.tv_des_dai_name)
        TextView tvName;
        @Bind(R.id.tv_des_dai_count)
        TextView tvCount;
        @Bind(R.id.iv_des_dai_type)
        ImageView tvType;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
