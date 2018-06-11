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
import com.rxjy.rxcompound.des.entity.GetXunjianXQYInfo;
import com.rxjy.rxcompound.des.mvp.contract.XunjianXQYContract;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/6/22.
 */
public class DesAlbumXJAdapter extends BaseAdapter
{

    private XunjianXQYContract.View listener;
    private Context context;
    private List<GetXunjianXQYInfo.BodyBean.ChildListBean> dataList;
    private int picsize=-1;
    private int dborwcbs=-1;
    public DesAlbumXJAdapter(Context context, List<GetXunjianXQYInfo.BodyBean.ChildListBean> dataList, XunjianXQYContract.View listener, int picsize, int dborwcbs)
    {
        this.picsize=picsize;
        this.listener = listener;
        this.context = context;
        this.dataList = dataList;
        this.dborwcbs=dborwcbs;
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

        final GetXunjianXQYInfo.BodyBean.ChildListBean info = dataList.get(position);

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

            if (position == getCount() - 1&&picsize!=1&&dborwcbs==1)
            {
                holder.ivDesAblum.setScaleType(ImageView.ScaleType.CENTER);
                holder.ivDesAblumDelete.setVisibility(View.GONE);
                holder.ivDesAblum.setImageResource(R.mipmap.add);
            } else
            {
                holder.ivDesAblum.setScaleType(ImageView.ScaleType.CENTER_CROP);
                holder.ivDesAblumDelete.setVisibility(View.VISIBLE);
                RequestOptions options=new RequestOptions().centerCrop().placeholder(R.mipmap.ic_carmer);
                Glide.with(context).load(Constants.WenesImgBaseURl + info.getSi_ImageUrl()).apply(options).into(holder.ivDesAblum);
            }

        }

        if (dborwcbs==0){
            holder.ivDesAblumDelete.setVisibility(View.INVISIBLE);
        }

        holder.ivDesAblumDelete.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Log.e("img",info.getSi_Id()+"|"+info.getSi_ImageUrl());
                listener.DeleteKaigongPicInfo(info, position);
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
