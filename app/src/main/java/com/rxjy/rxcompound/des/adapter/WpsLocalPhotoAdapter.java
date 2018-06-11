package com.rxjy.rxcompound.des.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.Constants;
import com.rxjy.rxcompound.commons.base.SingleBaseAdapter;
import com.rxjy.rxcompound.commons.base.SingleViewHolder;
import com.rxjy.rxcompound.des.mvp.contract.IWpsLocalPhotoContract;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Mr雷 on 2016/12/19.
 */
public class WpsLocalPhotoAdapter extends SingleBaseAdapter<String, WpsLocalPhotoAdapter.ViewHolder>
{
    /**
     * 用户选择的图片，存储为图片的完整路径
     */
    private List<String> mSelectedImage = new ArrayList<>();

    /**
     * LocalPhoto视图的接口
     */
    private IWpsLocalPhotoContract.View selectedListener;
    /**
     * 是否能够选择多张照片
     */
    private int type = 0;

    public WpsLocalPhotoAdapter(Context context, List<String> datas)
    {
        super(context, datas);
    }

    public void setHasSelector(List<String> hasSelector)
    {
        mSelectedImage.addAll(hasSelector);
    }

    @Override
    public int getLayoutRes()
    {
        return R.layout.list_item_wps_local_photo;
    }

    @Override
    public ViewHolder initViewHolder()
    {
        return new ViewHolder();
    }

    @Override
    public void onBindView(final int position, final String data, final ViewHolder holder)
    {

        holder.ivPhotoSelect.setImageResource(R.mipmap.choice_icon);
        /**
         * 已经选择过的图片，显示出选择过的效果
         */
        if (mSelectedImage.contains(data))
        {
            holder.ivPhotoSelect.setImageResource(R.mipmap.choice_icon_pre);
        } else
        {
            holder.ivPhotoSelect.setImageResource(R.mipmap.choice_icon);
        }

//        if (position == 0)
//        {
//            holder.ivPhoto.setImageResource(Integer.parseInt(data));
//            holder.ivPhotoSelect.setVisibility(View.INVISIBLE);
//            holder.ivPhoto.setScaleType(ImageView.ScaleType.CENTER);
//        } else
//        {
            RequestOptions options=new RequestOptions().centerCrop().placeholder(R.mipmap.zhanweitu);
            Glide.with(context).load(data).apply(options).into(holder.ivPhoto);
            holder.ivPhotoSelect.setVisibility(View.VISIBLE);
            holder.ivPhoto.setScaleType(ImageView.ScaleType.CENTER_CROP);
      //  }

        //设置ImageView的点击事件
        holder.ivPhoto.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                /**
                 * 如果position为0则点击照片调用相机
                 */
//                if (position == 0)
//                {
//                    //通过接口回调调用照相机
//                    selectedListener.responseStartCamera();
//                } else
//                {
                    if (type == Constants.UNONLY_ONE_PHOTO)
                    {
                        // 已经选择过该图片
                        if (mSelectedImage.contains(data))
                        {
                            mSelectedImage.remove(data);
                            holder.ivPhotoSelect.setImageResource(R.mipmap.choice_icon);
                            //通过回调将数据传递给Activity
                            selectedListener.responseSelectedPhotoes(data, Constants.IV_REMOVE);
                        } else
                        {    // 未选择该图片
                            mSelectedImage.add(data);
                            holder.ivPhotoSelect.setImageResource(R.mipmap.choice_icon_pre);
                            //通过回调将数据传递给Activity
                            selectedListener.responseSelectedPhotoes(data, Constants.IV_ADD);
                        }
                    } else if (type == Constants.ONLY_ONE_PHOTO)
                    {
                        // 已经选择过该图片
                        if (mSelectedImage.contains(data))
                        {
                            mSelectedImage.remove(data);
                            holder.ivPhotoSelect.setImageResource(R.mipmap.choice_icon);
                            //通过回调将数据传递给Activity
                            selectedListener.responseSelectedPhotoes(data, Constants.IV_REMOVE);
                        } else
                        {    // 未选择该图片
                            if (mSelectedImage.size() >= 1)
                            {
                                selectedListener.responseToast();
                            } else
                            {
                                mSelectedImage.add(data);
                                holder.ivPhotoSelect.setImageResource(R.mipmap.choice_icon_pre);
                                //通过回调将数据传递给Activity
                                selectedListener.responseSelectedPhotoes(data, Constants.IV_ADD);
                            }
                        }
                    }
                }
          //  }
        });

    }

    public void setSelectedListener(IWpsLocalPhotoContract.View selectedListener, int type)
    {
        this.selectedListener = selectedListener;
        this.type = type;
    }

    static class ViewHolder implements SingleViewHolder
    {
        @Bind(R.id.iv_local_photo)
        ImageView ivPhoto;
        @Bind(R.id.iv_local_photo_select)
        ImageButton ivPhotoSelect;

        @Override
        public void onInFlate(View v)
        {
            ButterKnife.bind(this, v);
        }
    }

}
