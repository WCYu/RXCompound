package com.rxjy.rxcompound.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.utils.AutoUtils;
import com.rxjy.rxcompound.entity.FindDataBean;

import java.util.ArrayList;

import butterknife.Bind;

/**
 * Created by hjh on 2017/11/14.
 */

public class FindListAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<FindDataBean> list;

    public FindListAdapter(Context context, ArrayList<FindDataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        MyHolder myHolder;
        if (view == null) {
            view = View.inflate(context, R.layout.item_finddata, null);
            AutoUtils.auto(view);
            myHolder = new MyHolder();
            myHolder.ll_one = (LinearLayout) view.findViewById(R.id.ll_one);
            myHolder.ll_zero = (LinearLayout) view.findViewById(R.id.ll_zero);
            myHolder.ll_edu = (LinearLayout) view.findViewById(R.id.ll_edu);
            myHolder.iv_img = (ImageView) view.findViewById(R.id.iv_img);
            myHolder.iv_imgone = (ImageView) view.findViewById(R.id.iv_imgone);
            myHolder.iv_imgedu = (ImageView) view.findViewById(R.id.iv_imgedu);
            myHolder.tv_title = (TextView) view.findViewById(R.id.tv_title);
            myHolder.tv_time = (TextView) view.findViewById(R.id.tv_time);
            myHolder.tv_spare = (TextView) view.findViewById(R.id.tv_spare);
            myHolder.tv_like = (TextView) view.findViewById(R.id.tv_like);
            myHolder.tv_views = (TextView) view.findViewById(R.id.tv_views);
            myHolder.tv_titleone = (TextView) view.findViewById(R.id.tv_titleone);
            myHolder.tv_timeone = (TextView) view.findViewById(R.id.tv_timeone);
            myHolder.tv_edutitle = (TextView) view.findViewById(R.id.tv_edutitle);
            myHolder.tv_into = (TextView) view.findViewById(R.id.tv_into);
            myHolder.tvTitle= (TextView) view.findViewById(R.id.tv_title);
            myHolder.tvContect= (TextView) view.findViewById(R.id.tv_contect);
            myHolder.llZero= (LinearLayout) view.findViewById(R.id.ll_zero);
            myHolder.mvImgone=(ImageView) view.findViewById(R.id.mv_imgone);
            myHolder.mvImgtwo=(ImageView) view.findViewById(R.id.mv_imgtwo);
            myHolder.mvImgthere=(ImageView) view.findViewById(R.id.mv_imgthere);
            myHolder.llThere=(LinearLayout) view.findViewById(R.id.ll_there);
            myHolder.tvSpare=(TextView) view.findViewById(R.id.tv_spare);
            myHolder.tvLike=(TextView) view.findViewById(R.id.tv_like);
            myHolder.ivLike=(ImageView) view.findViewById(R.id.iv_like);
            myHolder.tvViews=(TextView) view.findViewById(R.id.tv_views);
            myHolder.ivViewse=(ImageView) view.findViewById(R.id.iv_viewse);
            myHolder.tvTimers=(TextView) view.findViewById(R.id.tv_timers);
            myHolder.lvtitle= (TextView) view.findViewById(R.id.lv_title);
            view.setTag(myHolder);
        } else {
            myHolder = (MyHolder) view.getTag();
        }
        FindDataBean findDataBean = list.get(i);
        myHolder.tvTitle.setText(findDataBean.getName());
        myHolder.tvContect.setText(findDataBean.getContent());

        myHolder.tvSpare.setText(findDataBean.getSpare1());
        myHolder.tvViews.setText(findDataBean.getView()+"");
        myHolder.lvtitle.setText(findDataBean.getName());
        myHolder.tvTimers.setText(findDataBean.getReleaseDate());
        if(findDataBean.getType()==0){
            myHolder.llZero.setVisibility(View.VISIBLE);
            myHolder.llThere.setVisibility(View.GONE);
            Glide.with(context).load(findDataBean.getCover()).into(myHolder.iv_img);
            myHolder.ll_edu.setVisibility(View.GONE);
        }else if(findDataBean.getType()==3){
            myHolder.llZero.setVisibility(View.GONE);
            myHolder.llThere.setVisibility(View.VISIBLE);
            Glide.with(context).load(findDataBean.getContentPic().get(0)).into(myHolder.mvImgone);
            Glide.with(context).load(findDataBean.getContentPic().get(1)).into(myHolder.mvImgtwo);
            Glide.with(context).load(findDataBean.getContentPic().get(2)).into(myHolder.mvImgthere);
            myHolder.ll_edu.setVisibility(View.GONE);

        }
//        if (findDataBean.getType() == 0) {//一般的文本
//            myHolder.ll_zero.setVisibility(View.VISIBLE);
//            myHolder.ll_one.setVisibility(View.GONE);
//            myHolder.ll_edu.setVisibility(View.GONE);
//            myHolder.tv_title.setText(findDataBean.getName());
//            String time = findDataBean.getReleaseDate();
//            String data = time;
//            if (time.length() >= 10) {
//                data = time.substring(0, 10);
//            }
//            myHolder.tv_time.setText(data);
//            myHolder.tv_spare.setText(findDataBean.getSpare1());
//            myHolder.tv_like.setText(findDataBean.getPraise() + "");
//            myHolder.tv_views.setText(findDataBean.getView() + "");
//            Glide.with(context).load(findDataBean.getCover()).into(myHolder.iv_img);
      //  }
        else if (findDataBean.getType() == 1||findDataBean.getType() == 2) {//岗前答题 //日常培训
            myHolder.ll_zero.setVisibility(View.GONE);
            myHolder.ll_one.setVisibility(View.GONE);
            myHolder.llZero.setVisibility(View.VISIBLE);
            myHolder.llThere.setVisibility(View.GONE);
            myHolder.ll_edu.setVisibility(View.VISIBLE);
            myHolder.tv_edutitle.setText(findDataBean.getName());
            switch (findDataBean.getType()){
                case 1:
                    myHolder.iv_imgedu.setImageResource(R.drawable.ic_findgang);
                    myHolder.tv_into.setText("进入岗前");
                    break;
                case 2:
                    myHolder.iv_imgedu.setImageResource(R.mipmap.ic_findpeixun);
                    myHolder.tv_into.setText("进入日常");
                    break;
            }
//            myHolder.tv_into.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                }
//            });
            //视频
//            myHolder.ll_zero.setVisibility(View.GONE);
//            myHolder.ll_one.setVisibility(View.VISIBLE);
//            myHolder.tv_titleone.setText(findDataBean.getName());
//            String time=findDataBean.getReleaseDate();
//            String data=time;
//            if(time.length()>=10){
//                data=time.substring(0,9);
//            }
//            myHolder.tv_timeone.setText(data);
//            Glide.with(context).load(findDataBean.getCover()).into(myHolder.iv_imgone);
        }
        return view;
    }


    public class MyHolder {
        private ImageView iv_img, iv_imgone, iv_imgedu;
        private TextView tv_title, tv_time, tv_spare, tv_like, tv_views, tv_titleone, tv_timeone, tv_edutitle, tv_into;
        private LinearLayout ll_one, ll_zero, ll_edu;

        TextView tvTitle,lvtitle;
        TextView tvContect;
        LinearLayout llZero;
        ImageView mvImgone;
        ImageView mvImgtwo;
        ImageView mvImgthere;
        LinearLayout llThere;
        TextView tvSpare;
        TextView tvLike;
        ImageView ivLike;
        TextView tvViews;
        ImageView ivViewse;
        TextView tvTimers;
    }

}
