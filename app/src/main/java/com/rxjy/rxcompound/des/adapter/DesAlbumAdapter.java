package com.rxjy.rxcompound.des.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.Constants;
import com.rxjy.rxcompound.commons.utils.AutoUtils;
import com.rxjy.rxcompound.des.entity.AllImagesInfo;
import com.rxjy.rxcompound.des.mvp.contract.DesAlbumContract;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/6/22.
 */
public class DesAlbumAdapter extends BaseAdapter
{

    private DesAlbumContract.View listener;
    private Context context;
    private List<AllImagesInfo.Album.image> dataList;
    private int picsize=-1;
    public DesAlbumAdapter(Context context, List<AllImagesInfo.Album.image> dataList, DesAlbumContract.View listener, int picsize)
    {
        this.picsize=picsize;
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

        final AllImagesInfo.Album.image info = dataList.get(position);

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

            if (position == getCount() - 1&&picsize!=1)
            {
                holder.ivDesAblum.setScaleType(ImageView.ScaleType.CENTER);
                holder.ivDesAblumDelete.setVisibility(View.GONE);
                holder.ivDesAblum.setImageResource(R.mipmap.add);
            } else
            {
                holder.ivDesAblum.setScaleType(ImageView.ScaleType.CENTER_CROP);
                holder.ivDesAblumDelete.setVisibility(View.VISIBLE);
                RequestOptions options=new RequestOptions().centerCrop().placeholder(R.mipmap.zhanweitu);
                Glide.with(context).load(Constants.WenesImgBaseURl + info.getImageUrl()).apply(options).into(holder.ivDesAblum);
            }

        }

        holder.ivDesAblumDelete.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                listener.deletePhoto(info, position);
            }
        });

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
