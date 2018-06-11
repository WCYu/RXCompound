package com.rxjy.rxcompound.des.photo;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.des.entity.MyCamera;

import java.util.List;

/**
 * Created by Administrator on 2017/7/7.
 */
public class MyPagerAdapter extends PagerAdapter {

    private List<MyCamera.Body.CatalogList> dataList;
    private Context context;
    private List<MyCamera.Body.CatalogList> body;
    public MyPagerAdapter(Context context, List<MyCamera.Body.CatalogList> dataList) {
        body=dataList;
        this.context = context;

        this.dataList = dataList;
    }

//    @Override
//    public float getPageWidth(int position) {
//        return (float) 0.33333333;
//    }
//@Override
//public int getItemPosition(Object object) {
//    return POSITION_NONE;
//}



    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.we_item,null);
        TextView tv = (TextView) v.findViewById(R.id.mycamera_tv);


                String name = body.get(position).getCatalogName();
                String count = body.get(position).getImgCount();
                String text = name + "(" + count + ")";



        tv.setText(text);
        container.addView(v);
        return v;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.we_item,null);
        container.removeView(v);
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == object);
    }
}
