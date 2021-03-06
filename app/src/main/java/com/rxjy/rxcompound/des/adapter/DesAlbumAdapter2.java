package com.rxjy.rxcompound.des.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.Constants;
import com.rxjy.rxcompound.commons.utils.AutoUtils;
import com.rxjy.rxcompound.des.entity.GetYiLiangFangAllInfo;
import com.rxjy.rxcompound.des.mvp.contract.DesAlbumContract;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/6/22.
 */
public class DesAlbumAdapter2 extends BaseAdapter
{

    private DesAlbumContract.View listener;
    private Context context;
    private List<GetYiLiangFangAllInfo.BodyBean.HuanJingZhaoPianBean.image> dataList;

    public DesAlbumAdapter2(Context context, List<GetYiLiangFangAllInfo.BodyBean.HuanJingZhaoPianBean.image> dataList, DesAlbumContract.View listener)
    {
        this.listener = listener;
        this.context = context;
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
    public View getView(final int position, View convertView, ViewGroup viewGroup)
    {

        final GetYiLiangFangAllInfo.BodyBean.HuanJingZhaoPianBean.image info = dataList.get(position);

        ViewHolder holder;

        if (convertView == null)
        {
            convertView = View.inflate(context, R.layout.gv_item_des_ablum, null);
            AutoUtils.auto(convertView);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else
        {
            holder = (ViewHolder) convertView.getTag();
        }

        if (viewGroup.getChildCount() == position)
        {
            Log.e("axiba2",viewGroup.getChildCount()+""+position);
//            if (position == getCount() - 1)
//            {
//                holder.ivDesAblum.setScaleType(ImageView.ScaleType.CENTER);
//                holder.ivDesAblumDelete.setVisibility(View.GONE);
//                holder.ivDesAblum.setImageResource(R.mipmap.add);
//            } else
  //          {
            Log.e("axib2",getCount()+"");
                holder.ivDesAblum.setScaleType(ImageView.ScaleType.CENTER_CROP);
                //holder.ivDesAblumDelete.setVisibility(View.VISIBLE);
                RequestOptions options=new RequestOptions().centerCrop().placeholder(R.mipmap.zhanweitu);
                Glide.with(context).load(Constants.WenesImgBaseURl + info.getImageUrl()).apply(options).into(holder.ivDesAblum);
            Log.e("axib2",Constants.WenesImgBaseURl + info.getImageUrl());
            }

     //   }

//        holder.ivDesAblumDelete.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View view)
//            {
//                listener.deletePhoto(info, position);
//            }
//        });

        return convertView;
    }

    static class ViewHolder
    {
        @Bind(R.id.iv_des_ablum)
        ImageView ivDesAblum;
        @Bind(R.id.iv_des_ablum_delete)
        ImageView ivDesAblumDelete;

        ViewHolder(View view)
        {
            ButterKnife.bind(this, view);
        }
    }
}
