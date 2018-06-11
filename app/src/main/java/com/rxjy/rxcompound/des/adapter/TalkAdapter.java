package com.rxjy.rxcompound.des.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.utils.AutoUtils;
import com.rxjy.rxcompound.des.entity.GetHuiFang;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/8/15.
 */

public class TalkAdapter extends BaseAdapter {
    List<GetHuiFang.Body> datas;
    LayoutInflater inflater;
    public final int SJS = 0;
    public final int ZG = 1;
    public final int ZAJL = 2;
    public final int XZJL = 3;
    Context context;

    public TalkAdapter(Context context, List<GetHuiFang.Body> datas) {
        this.context = context;
        this.datas = datas;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        int type = datas.get(position).getCv_Type();

        if (type == 1) {
            return SJS;
        } else if (type == 2) {
            return ZG;
        } else if (type == 5) {
            return XZJL;
        } else {
            return ZAJL;
        }
    }

    @Override
    public int getViewTypeCount() {
        return 4;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        GetHuiFang.Body body = datas.get(position);
        sjsViewHolder sjsholder = null;
        zgViewHolder zgholder = null;
        zajlViewHolder zajlholder = null;
        xzjlViewHolder xzjlholder = null;

        int type = getItemViewType(position);

        int temp = -1;
        if (convertView != null) {
            if (convertView.getTag() instanceof sjsViewHolder) {
                temp = SJS;
            } else if (convertView.getTag() instanceof zgViewHolder) {
                temp = ZG;
            } else if (convertView.getTag() instanceof zajlViewHolder) {
                temp = ZAJL;
            } else if (convertView.getTag() instanceof xzjlViewHolder) {
                temp = XZJL;
            }
            System.out.println("缓存的类型  " + temp);
            // 3判断缓存的类型是否是当前item要显示的类型？是，可复用；不是，设置convertView为空重新加载。
            if (temp != type) {
                convertView = null;
            }
        }

        // 4 判断convertView是否为空？是，复用；不是，重新加载。
        if (convertView == null) {
            // 5.1根据类型 加载当前item要显示的布局，并让convertView setTag当前布局的holder
            switch (type) {
                case SJS:
                    convertView = inflater.inflate(R.layout.zsxm_sjs_dhk, null);
                    AutoUtils.auto(convertView);
                    sjsholder = new sjsViewHolder(convertView);
                    convertView.setTag(sjsholder);
                    break;
                case ZG:
                    convertView = inflater.inflate(R.layout.zsxm_zg_dhk, null);
                    AutoUtils.auto(convertView);
                    zgholder = new zgViewHolder(convertView);
                    convertView.setTag(zgholder);
                    break;
                case ZAJL:
                    convertView = inflater.inflate(R.layout.zsxm_zajl_dhk, null);
                    AutoUtils.auto(convertView);
                    zajlholder = new zajlViewHolder(convertView);
                    convertView.setTag(zajlholder);
                    break;
                case XZJL:
                    convertView = inflater.inflate(R.layout.xzjl_zajl_dhk, null);
                    AutoUtils.auto(convertView);
                    xzjlholder = new xzjlViewHolder(convertView);
                    convertView.setTag(xzjlholder);
                    break;
            }
        } else {
            // 5.2根据类型 复用convertView getTag获取当前布局的holder
            switch (type) {
                case SJS:
                    sjsholder = (sjsViewHolder) convertView.getTag();
                    break;
                case ZG:
                    zgholder = (zgViewHolder) convertView.getTag();
                    break;
                case ZAJL:
                    zajlholder = (zajlViewHolder) convertView.getTag();
                    break;
                case XZJL:
                    xzjlholder = (xzjlViewHolder) convertView.getTag();
                    break;
            }
        }
        switch (type) {
            case SJS:
                sjsholder.tv_date.setText(body.getCv_AddTime());
                sjsholder.tv_res.setText(body.getCv_TodayProgress());
                sjsholder.tv_type_right.setText(body.getCv_TypeName());
                break;
            case ZG:
                zgholder.tv_date.setText(body.getCv_AddTime());
                zgholder.tv_res.setText(body.getCv_TodayProgress());
                zgholder.tv_type_leftblue.setText(body.getCv_TypeName());
                break;
            case ZAJL:
                zajlholder.tv_date.setText(body.getCv_AddTime());
                zajlholder.tv_res.setText(body.getCv_TodayProgress());
                zajlholder.tv_type_leftgreen.setText(body.getCv_TypeName());
                break;
            case XZJL:
                xzjlholder.tv_date.setText(body.getCv_AddTime());
                xzjlholder.tv_res.setText(body.getCv_TodayProgress());
                xzjlholder.tv_type_yellow.setText(body.getCv_TypeName());
                break;
        }
        return convertView;

    }


    class sjsViewHolder {
        @Bind(R.id.sjs_item_tv_zsxm_date)
        TextView tv_date;
        @Bind(R.id.sjs_item_tv_zsxm_res)
        TextView tv_res;
        @Bind(R.id.tv_type_right)
        TextView tv_type_right;

        public sjsViewHolder(View v) {
            {
                ButterKnife.bind(this, v);
            }

        }

    }

    class zgViewHolder {
        @Bind(R.id.zg_item_tv_zsxm_date)
        TextView tv_date;
        @Bind(R.id.zg_item_tv_zsxm_res)
        TextView tv_res;
        @Bind(R.id.tv_type_leftblue)
        TextView tv_type_leftblue;

        public zgViewHolder(View v) {
            {
                ButterKnife.bind(this, v);
            }

        }

    }

    class zajlViewHolder {
        @Bind(R.id.zajl_item_tv_zsxm_date)
        TextView tv_date;
        @Bind(R.id.zajl_item_tv_zsxm_res)
        TextView tv_res;
        @Bind(R.id.tv_type_leftgreen)
        TextView tv_type_leftgreen;

        public zajlViewHolder(View v) {
            {
                ButterKnife.bind(this, v);
            }

        }

    }

    class xzjlViewHolder {
        @Bind(R.id.zajl_item_tv_zsxm_date)
        TextView tv_date;
        @Bind(R.id.zajl_item_tv_zsxm_res)
        TextView tv_res;
        @Bind(R.id.tv_type_yellow)
        TextView tv_type_yellow;

        public xzjlViewHolder(View v) {
            {
                ButterKnife.bind(this, v);
            }

        }

    }

}
