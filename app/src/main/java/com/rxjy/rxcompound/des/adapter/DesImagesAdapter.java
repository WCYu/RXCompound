package com.rxjy.rxcompound.des.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.Constants;
import com.rxjy.rxcompound.commons.utils.AutoUtils;
import com.rxjy.rxcompound.des.entity.GetYiLiangFangAllInfo;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by qindd on 2017/6/21.
 */
public class DesImagesAdapter extends BaseAdapter
{

    private Context mContext;
    private List<GetYiLiangFangAllInfo.BodyBean.HuanJingZhaoPianBean> dataList;

    public DesImagesAdapter(Context context, List<GetYiLiangFangAllInfo.BodyBean.HuanJingZhaoPianBean> dataList)
    {
        this.mContext = context;
        this.dataList = dataList;
    }

    @Override
    public int getCount()
    {
        return dataList.size();
    }

    @Override
    public Object getItem(int position)
    {
        return dataList.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        Log.e("axib2",getCount()+"");
        ViewHolder viewHolder;
        if (convertView == null)
        {
            convertView = View.inflate(mContext, R.layout.gridview_item_des_yi, null);
            AutoUtils.auto(convertView);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else
        {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        GetYiLiangFangAllInfo.BodyBean.HuanJingZhaoPianBean album = dataList.get(position);
        viewHolder.tvDesYiCount.setText(album.getCatalogCount() + "");
        viewHolder.tvDesYiName.setText(album.getCatalogIDName());
        int size = album.getChildList().size();
        if (size != 0)
        {
            Log.e("axiba", Constants.WenesImgBaseURl + album.getChildList().get(0).getImageUrl());
            Glide.with(mContext).load(Constants.WenesImgBaseURl + album.getChildList().get(0).getImageUrl()).into(viewHolder.ivDesYi);
            viewHolder.ivDesYi.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else
        {
            viewHolder.ivDesYi.setScaleType(ImageView.ScaleType.CENTER);
        }
        return convertView;
    }

    static class ViewHolder
    {
        @Bind(R.id.iv_des_yi)
        ImageView ivDesYi;
        @Bind(R.id.tv_des_yi_count)
        TextView tvDesYiCount;
        @Bind(R.id.tv_des_yi_name)
        TextView tvDesYiName;

        ViewHolder(View view)
        {
            ButterKnife.bind(this, view);
        }
    }
}
