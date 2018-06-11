package com.rxjy.rxcompound.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.rxjy.rxcompound.R;

/**
 * Created by hjh on 2018/3/16.
 */

public class MoneyDZaView extends RelativeLayout {

    private TextView tv_title,tv_titleone,tv_contentone,tv_titletwo,tv_contenttwo,tv_titlethree,tv_contentthree;

    public MoneyDZaView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.widget_zamoney, this, true);
        tv_title= (TextView) findViewById(R.id.tv_title);
        tv_titleone= (TextView) findViewById(R.id.tv_titleone);
        tv_contentone= (TextView) findViewById(R.id.tv_contentone);
        tv_titletwo= (TextView) findViewById(R.id.tv_titletwo);
        tv_contenttwo= (TextView) findViewById(R.id.tv_contenttwo);
        tv_titlethree= (TextView) findViewById(R.id.tv_titlethree);
        tv_contentthree= (TextView) findViewById(R.id.tv_contentthree);
    }


    public void setContent(String title,String t1,String t2,String t3,String c1,String c2,String c3){
        tv_title.setText(title);
        tv_titleone.setText(t1);
        tv_titletwo.setText(t2);
        tv_titlethree.setText(t3);
        tv_contentone.setText(c1);
        tv_contenttwo.setText(c2);
        tv_contentthree.setText(c3);
    }


}