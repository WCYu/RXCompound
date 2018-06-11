package com.rxjy.rxcompound.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;


import com.bumptech.glide.Glide;
import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.utils.AutoUtils;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * Created by asus on 2018/5/16.
 */

public class GridViewAddImgesAdpter  extends BaseAdapter {
    private List<Map<String, Object>> datas;
    private Context context;
    private LayoutInflater inflater;
    /**
     * 可以动态设置最多上传几张，之后就不显示+号了，用户也无法上传了
     * 默认9张
     */
    private int maxImages = 30;

    public GridViewAddImgesAdpter(List<Map<String, Object>> datas, Context context) {
        this.datas = datas;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    /**
     * 获取最大上传张数
     *
     * @return
     */
    public int getMaxImages() {
        return maxImages;
    }

    /**
     * 设置最大上传张数
     *
     * @param maxImages
     */
    public void setMaxImages(int maxImages) {
        this.maxImages = maxImages;
    }

    /**
     * 让GridView中的数据数目加1最后一个显示+号
     * 当到达最大张数时不再显示+号
     * @return 返回GridView中的数量
     */
    @Override
    public int getCount() {

            return datas.size();
       // }
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public void notifyDataSetChanged(List<Map<String, Object>> datas) {
        this.datas = datas;
        this.notifyDataSetChanged();

    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {


        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_item_image, parent, false);
            //业务需求此处需要加入屏幕适配
            AutoUtils.autoSize(convertView);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        /**代表+号之前的需要正常显示图片**/
        //if (datas != null && position < datas.size()) {
        if(position==0){
            String path = datas.get(position).get("path").toString();
            int i = Integer.parseInt(path);
            Glide.with(context)
                    .load(i)
                    .into(viewHolder.ivimage);
        }else {
            final File file = new File(datas.get(position).get("path").toString());
            Glide.with(context)
                    .load(file)
                    .into(viewHolder.ivimage);
        }

     //   }
//        else {
//            /**代表+号的需要+号图片显示图片**/
//            Glide.with(context)
//                    .load(R.mipmap.camera_sub_icon)
//                    .into(viewHolder.ivimage);
//            viewHolder.ivimage.setScaleType(ImageView.ScaleType.FIT_XY);
//         //   viewHolder.btdel.setVisibility(View.GONE);
//        }

        return convertView;

    }

    public class ViewHolder {
        public final ImageView ivimage;
        public final View root;

        public ViewHolder(View root) {
            ivimage = (ImageView) root.findViewById(R.id.iv_list_item_image);
           // btdel = (ImageView) root.findViewById(R.id.bt_del);
            this.root = root;
        }
    }
}
