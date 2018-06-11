package com.rxjy.rxcompound.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.activity.AnswerActivity;
import com.rxjy.rxcompound.activity.VideoPlayActivity;
import com.rxjy.rxcompound.commons.utils.StringUtils;
import com.rxjy.rxcompound.entity.AssementCuraBean;

import java.util.ArrayList;

/**
 * Created by hjh on 2017/11/16.
 */

public class JobTryAnAdapter extends BaseAdapter{

    private Context context;
    private ArrayList<AssementCuraBean> list;

    public JobTryAnAdapter(Context context, ArrayList<AssementCuraBean> list) {
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
    public View getView(final int i, View view, ViewGroup viewGroup) {
        MyHolder myHolder;
        if(view==null){
            view=View.inflate(context, R.layout.item_jobtryan, null);
            myHolder=new MyHolder();
            myHolder.iv_play= (ImageView) view.findViewById(R.id.iv_play);
            myHolder.iv_nocir= (ImageView) view.findViewById(R.id.iv_nocir);
            myHolder.tv_index= (TextView) view.findViewById(R.id.tv_index);
            myHolder.tv_title= (TextView) view.findViewById(R.id.tv_title);
            myHolder.tv_iscomplete= (TextView) view.findViewById(R.id.tv_iscomplete);
            myHolder.tv_progress= (TextView) view.findViewById(R.id.tv_progress);
            myHolder.tv_answer= (TextView) view.findViewById(R.id.tv_answer);
            myHolder.v_lineone=view.findViewById(R.id.v_lineone);
            myHolder.v_linetwo=view.findViewById(R.id.v_linetwo);
            myHolder.v_linethree=view.findViewById(R.id.v_linethree);
            myHolder.ll_status= (LinearLayout) view.findViewById(R.id.ll_status);
            myHolder.ll_play= (LinearLayout) view.findViewById(R.id.ll_play);
            myHolder.ll_answer= (LinearLayout) view.findViewById(R.id.ll_answer);
            view.setTag(myHolder);
        }else{
            myHolder= (MyHolder) view.getTag();
        }
        final AssementCuraBean bean=list.get(i);
        myHolder.tv_index.setText(i+1+"");
        myHolder.tv_title.setText(bean.getCourInfo());
        int scores = 0;
        if(!StringUtils.isEmpty(bean.getScore())){
            scores= Integer.parseInt(bean.getScore());
        }
        if(scores>0){
            myHolder.tv_progress.setText(bean.getScore()+"分");
            //设置不可答题、已完成
            myHolder.tv_answer.setBackgroundColor(context.getResources().getColor(R.color.textgreytwo));
            myHolder.ll_answer.setEnabled(false);
            myHolder.tv_iscomplete.setText("已完成");
            myHolder.iv_nocir.setImageResource(R.drawable.ic_yesdot);
            myHolder.ll_status.setBackgroundColor(context.getResources().getColor(R.color.bgtblue));
        }else{
            myHolder.tv_progress.setText("0分");
        }

        myHolder.ll_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getids=bean.getFileUrl();
                Log.e("getids",getids);
                if(!StringUtils.isEmpty(bean.getAppFileUrl())){
                    context.startActivity(new Intent(context,VideoPlayActivity.class).putExtra("id",""));
                }else{
                    if(!StringUtils.isEmpty(getids)){
                        getids=getids.substring(getids.indexOf("sid/")+4,getids.indexOf("/v.swf"));
                    }
                    Log.e("截取后的字符串是：",getids);
                    context.startActivity(new Intent(context,VideoPlayActivity.class).putExtra("id",getids));
                }


            }
        });
        myHolder.ll_answer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context,AnswerActivity.class).putExtra("coursewareInfoId",bean.getCourInfoId()).putExtra("dayIndex",bean.getDayIndex()+""));
            }
        });

        if(i==0){
            myHolder.v_lineone.setVisibility(View.GONE);
        }else{
            myHolder.v_lineone.setVisibility(View.VISIBLE);
        }
        if(i==(list.size()-1)){
            myHolder.v_linetwo.setVisibility(View.GONE);
        }else{
            myHolder.v_linetwo.setVisibility(View.VISIBLE);
        }
        return view;
    }


    public class MyHolder{
        private ImageView iv_play,iv_nocir;
        private TextView tv_index,tv_title,tv_iscomplete,tv_progress,tv_answer;
        private View v_lineone,v_linetwo,v_linethree;
        private LinearLayout ll_status,ll_answer,ll_play;

    }



}
