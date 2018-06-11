package com.rxjy.rxcompound.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.utils.StringUtils;

/**
 * Created by hjh on 2018/3/27.
 */

public class MoneyTzView extends RelativeLayout {

    ImageView ivShu;
    TextView tvTitle;
    TextView tvTypeone;
    TextView tvTypeonemoney;
    TextView tvTypetwo;
    TextView money;
    TextView tvTypethree;
    TextView tvTypethreemoney;
    TextView tvTypefour;
    TextView tvTypefourmoney;
    LinearLayout llWallet;
//    LinearLayout llFive;
//    View vLine;
//    TextView tvTypefive;
//    TextView tvTypefivemoney;
    TextView tvTypefourmoneytwo;
    TextView tvLineone;
    TextView tvTypeonemoneytwo;
    TextView tvLinetwo;
//    TextView tvTypefivemoneytwo;
    LinearLayout llOne;

    public MoneyTzView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.widget_wallettzitem, this, true);
        tvTypefourmoney = (TextView) findViewById(R.id.tv_typefourmoney);
        tvTypefour = (TextView) findViewById(R.id.tv_typefour);
        tvTypethree = (TextView) findViewById(R.id.tv_typethree);
        money = (TextView) findViewById(R.id.money);
        tvTypetwo = (TextView) findViewById(R.id.tv_typetwo);
        tvTypeonemoney = (TextView) findViewById(R.id.tv_typeonemoney);
        tvTypethreemoney = (TextView) findViewById(R.id.tv_typethreemoney);
        tvTypeone = (TextView) findViewById(R.id.tv_typeone);
        tvTitle = (TextView) findViewById(R.id.tv_title);
//        tvTypefive = (TextView) findViewById(R.id.tv_typefive);
//        tvTypefivemoney = (TextView) findViewById(R.id.tv_typefivemoney);
        tvTypefourmoneytwo = (TextView) findViewById(R.id.tv_typefourmoneytwo);
        tvLineone = (TextView) findViewById(R.id.tv_lineone);
        tvTypeonemoneytwo = (TextView) findViewById(R.id.tv_typeonemoneytwo);
        tvLinetwo = (TextView) findViewById(R.id.tv_linetwo);
//        tvTypefivemoneytwo = (TextView) findViewById(R.id.tv_typefivemoneytwo);
        llWallet = (LinearLayout) findViewById(R.id.ll_wallet);
//        llFive = (LinearLayout) findViewById(R.id.ll_five);
        llOne = (LinearLayout) findViewById(R.id.ll_one);
    }

    public void Show(int isshow) {
        switch (isshow) {
            case 0:
                llWallet.setVisibility(GONE);
                break;
            case 1:
                llWallet.setVisibility(VISIBLE);
                break;
        }
    }

    public void setTitleAndType(String str1, String str2, String str3, String str4, String str5) {
//        vLine.setVisibility(GONE);
//        llFive.setVisibility(GONE);
        tvTitle.setText(str1);
        tvTypeone.setText(str2);
        tvTypetwo.setText(str3);
        tvTypethree.setText(str4);
        tvTypefour.setText(str5);
    }

    public void setTitleAndType(String str1, String str2, String str3, String str4, String str5, String str6) {
//        vLine.setVisibility(VISIBLE);
//        llFive.setVisibility(VISIBLE);
        tvTitle.setText(str1);
        tvTypeone.setText(str2);
        if(StringUtils.isEmpty(str2)){
            llOne.setVisibility(GONE);
        }else{
            llOne.setVisibility(VISIBLE);
        }
        tvTypetwo.setText(str3);
        tvTypethree.setText(str4);
        tvTypefour.setText(str5);
//        tvTypefive.setText(str6);
    }

    public void setContent(String str1, String str2, String str3, String str4) {
        tvTypeonemoney.setText(str1);
        money.setText(str2);
        tvTypethreemoney.setText(str3);
        tvTypefourmoney.setText(str4);
        if(!StringUtils.isEmpty(str4)){
            String isfu=str4.substring(0,1);
            if(isfu.equals("-")){
                tvTypefourmoney.setTextColor(getResources().getColor(R.color.textred));
            }else{
                tvTypefourmoney.setTextColor(getResources().getColor(R.color.colorPrimarys));
            }
//            int money= Integer.parseInt(str4);
//            if(money>=0){
//                tvTypefourmoney.setTextColor(getResources().getColor(R.color.colorPrimarys));
//            }else{
//                tvTypefourmoney.setTextColor(getResources().getColor(R.color.textred));
//            }

        }
    }

    public void setContentFive(String str1, String str1_2, String str2, String str3, String str4, String str5, String str5_2) {
        llOne.setVisibility(GONE);
        tvLineone.setVisibility(VISIBLE);
        tvTypeonemoneytwo.setVisibility(VISIBLE);
//        llFive.setVisibility(VISIBLE);
        tvTypeonemoney.setText(str1);
        tvTypeonemoney.setTextColor(this.getResources().getColor(R.color.colorPrimarys));
        tvTypeonemoneytwo.setText(str1_2);
        money.setText(str2);
        tvTypethreemoney.setText(str3);
        tvTypefourmoney.setText(str4);
//        tvTypefivemoney.setText(str5);
//        tvTypefivemoneytwo.setText(str5_2);
    }

    public void setLasttwoContent(String str1, String str2, String str3, String str4, String str5) {//最后一个有两个值
        tvTypefourmoneytwo.setVisibility(VISIBLE);
        tvLinetwo.setVisibility(VISIBLE);
        tvTypeonemoney.setText(str1);
        money.setText(str2);
        tvTypethreemoney.setText(str3);
        tvTypefourmoney.setText(str4);
        tvTypefourmoneytwo.setText(str5);
    }

    public void setTextColor(int colortype,int textposition){//colortype颜色种类，1：绿色2：红色
        switch (colortype){
            case 1:
                switch (textposition){
                    case 4:
                        tvTypefourmoney.setTextColor(this.getResources().getColor(R.color.colorPrimarys));
                        break;
                    case 5:
                        tvTypefourmoneytwo.setTextColor(this.getResources().getColor(R.color.colorPrimarys));
                        break;
                }
                break;
            case 2:
                switch (textposition){
                    case 4:
                        tvTypefourmoney.setTextColor(this.getResources().getColor(R.color.textred));
                        break;
                    case 5:
                        tvTypefourmoneytwo.setTextColor(this.getResources().getColor(R.color.textred));
                        break;
                }
                break;
        }
    }


}