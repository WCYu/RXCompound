package com.rxjy.rxcompound.widget;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.utils.StringUtils;

import java.math.BigDecimal;

/**
 * Created by hjh on 2018/3/14.
 */

public class MoneyDTzView extends RelativeLayout{

    TextView tv_title,tv_one,tv_two,tv_three,tv_four,tv_five,tv_six,tv_seven,tv_seventop,tv_nine;

    public MoneyDTzView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.widget_tzmoneyone, this, true);
        tv_title= (TextView) findViewById(R.id.tv_title);
        tv_one= (TextView) findViewById(R.id.tv_one);
        tv_two= (TextView) findViewById(R.id.tv_two);
        tv_three= (TextView) findViewById(R.id.tv_three);
        tv_four= (TextView) findViewById(R.id.tv_four);
        tv_five= (TextView) findViewById(R.id.tv_five);
        tv_six= (TextView) findViewById(R.id.tv_six);
        tv_seven= (TextView) findViewById(R.id.tv_seven);
        tv_seventop= (TextView) findViewById(R.id.tv_seventop);
        tv_nine= (TextView) findViewById(R.id.tv_nine);
    }

    public void setContent(String str,String str1,String str2,String str3,String str4,String str5,String str6,String str7){
        tv_title.setText(str);
        if(!StringUtils.isEmpty(str1)){
            tv_one.setText(str1);
            tv_one.setVisibility(VISIBLE);
        }else{
            tv_one.setVisibility(GONE);
        }
        if(!StringUtils.isEmpty(str2)){
            tv_two.setText(str2);
            tv_two.setVisibility(VISIBLE);
        }else{
            tv_two.setVisibility(GONE);
        }
        if(!StringUtils.isEmpty(str3)){
            tv_three.setText(str3);
            tv_three.setVisibility(VISIBLE);
        }else{
            tv_three.setVisibility(GONE);
        }
        if(!StringUtils.isEmpty(str4)){
            tv_four.setText(str4);
            tv_four.setVisibility(VISIBLE);
        }else{
            tv_four.setVisibility(GONE);
        }
        if(!StringUtils.isEmpty(str5)){
            tv_five.setText(str5);
            tv_five.setVisibility(VISIBLE);
        }else{
            tv_five.setVisibility(GONE);
        }
        if(!StringUtils.isEmpty(str6)){
            tv_six.setText(str6);
            tv_six.setVisibility(VISIBLE);
        }else{
            tv_six.setVisibility(GONE);
        }
        if(!StringUtils.isEmpty(str7)){
            tv_seven.setText(str7);
            tv_seven.setVisibility(VISIBLE);
        }else{
            tv_seven.setVisibility(GONE);
        }
    }
    public void setContent(String str,String str1,String str2,String str3,String str4,String str5,String str6,String str7,String str8,String str9){
        tv_title.setText(str);
        if(!StringUtils.isEmpty(str1)){
            tv_one.setText(str1);
            tv_one.setVisibility(VISIBLE);
        }else{
            tv_one.setVisibility(GONE);
        }
        if(!StringUtils.isEmpty(str2)){
            tv_two.setText(str2);
            tv_two.setVisibility(VISIBLE);
        }else{
            tv_two.setVisibility(GONE);
        }
        if(!StringUtils.isEmpty(str3)){
            tv_three.setText(str3);
            tv_three.setVisibility(VISIBLE);
        }else{
            tv_three.setVisibility(GONE);
        }
        if(!StringUtils.isEmpty(str4)){
            tv_four.setText(str4);
            tv_four.setVisibility(VISIBLE);
        }else{
            tv_four.setVisibility(GONE);
        }
        if(!StringUtils.isEmpty(str5)){
            tv_five.setText(str5);
            tv_five.setVisibility(VISIBLE);
        }else{
            tv_five.setVisibility(GONE);
        }
        if(!StringUtils.isEmpty(str6)){
            tv_six.setText(str6);
            tv_six.setVisibility(VISIBLE);
        }else{
            tv_six.setVisibility(GONE);
        }
        if(!StringUtils.isEmpty(str7)){
            tv_seven.setText(str7);
            tv_seven.setVisibility(VISIBLE);
        }else{
            tv_seven.setVisibility(GONE);
        }
        if(!StringUtils.isEmpty(str9)){
            tv_nine.setText(str9);
            tv_nine.setVisibility(VISIBLE);
        }else{
            tv_nine.setVisibility(GONE);
        }
    }

    public void setContent(String str,String str1,String str2,String str3,String str4,String str5,String str6,String str7,String str8){
        tv_title.setText(str);
        if(!StringUtils.isEmpty(str1)){
            tv_one.setText(str1);
            tv_one.setVisibility(VISIBLE);
        }else{
            tv_one.setVisibility(GONE);
        }
        if(!StringUtils.isEmpty(str2)){
            tv_two.setText(str2);
            tv_two.setVisibility(VISIBLE);
        }else{
            tv_two.setVisibility(GONE);
        }
        if(!StringUtils.isEmpty(str3)){
            tv_three.setText(str3);
            tv_three.setVisibility(VISIBLE);
        }else{
            tv_three.setVisibility(GONE);
        }
        if(!StringUtils.isEmpty(str4)){
            tv_four.setText(str4);
            tv_four.setVisibility(VISIBLE);
        }else{
            tv_four.setVisibility(GONE);
        }
        if(!StringUtils.isEmpty(str5)){
            tv_five.setText(str5);
            tv_five.setVisibility(VISIBLE);
        }else{
            tv_five.setVisibility(GONE);
        }
        if(!StringUtils.isEmpty(str6)){
            tv_six.setText(str6);
            tv_six.setVisibility(VISIBLE);
        }else{
            tv_six.setVisibility(GONE);
        }
        if(!StringUtils.isEmpty(str7)){
            tv_seven.setText(str7);
            tv_seven.setVisibility(VISIBLE);
        }else{
            tv_seven.setVisibility(GONE);
        }

        if(!StringUtils.isEmpty(str8)){
            tv_seventop.setText(str8);
            tv_seventop.setVisibility(VISIBLE);
        }else{
            tv_seventop.setVisibility(GONE);
        }
    }

    public void setTvColor(Context context,int position,int start,String str,BigDecimal money){//文字位置、颜色设置的开始位置、文字内容
        switch (position){
            case 7:
                int size=str.length();
                SpannableStringBuilder style=new SpannableStringBuilder(str);
                int moneys=money.intValue();
                if(moneys>=0){
                    style.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.colorPrimarys)), start, size, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                }else{
                    style.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.textred)), start, size, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                }
                tv_seven.setText(style);
                break;
        }
    }
}