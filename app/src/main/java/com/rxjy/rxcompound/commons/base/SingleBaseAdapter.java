package com.rxjy.rxcompound.commons.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;


import com.rxjy.rxcompound.commons.utils.AutoUtils;

import java.util.List;

/**
 * Created by Mr雷 on 2016/8/5.
 * 单类型item适配器抽象
 */
public abstract class SingleBaseAdapter<T, V extends SingleViewHolder> extends BaseAdapter
{
    private List<T> datas;
    private LayoutInflater mInflater;
    //    private Context context;
    protected Context context;

    public SingleBaseAdapter(Context context, List<T> datas)
    {
        this.context = context;
        this.datas = datas;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount()
    {
        return datas == null ? 0 : datas.size();
    }

    @Override
    public T getItem(int position)
    {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        V holder = null;
        if (convertView == null)
        {
            convertView = mInflater.inflate(getLayoutRes(), parent, false);
            //业务需求此处需要加入屏幕适配
            AutoUtils.auto(convertView);
            holder = initViewHolder();
            holder.onInFlate(convertView);
            convertView.setTag(holder);
        } else
        {
            holder = (V) convertView.getTag();
        }
        onBindView(position, getItem(position), holder);
        return convertView;
    }

    public abstract int getLayoutRes();

    public abstract V initViewHolder();

    public abstract void onBindView(int position, T data, V holder);
}