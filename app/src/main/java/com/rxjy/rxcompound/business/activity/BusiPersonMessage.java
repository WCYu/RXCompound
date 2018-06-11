package com.rxjy.rxcompound.business.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.utils.StringUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by hjh on 2017/11/24.
 */

public class BusiPersonMessage extends BaseActivity {


    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.iv_icon)
    ImageView ivIcon;
    @Bind(R.id.tv_cardno)
    TextView tvCardno;
    @Bind(R.id.tv_weichat)
    TextView tvWeichat;
    @Bind(R.id.tv_email)
    TextView tvEmail;

    @Override
    public int getLayout() {
        return R.layout.activity_bus_personmsg;
    }

    String cardno,weichat,email,icon;
    @Override
    public void initData() {
        tvTitle.setText("个人信息");
        Intent intent=getIntent();
        cardno=intent.getStringExtra("cardnum");
        weichat=intent.getStringExtra("weichatnum");
        email=intent.getStringExtra("emailnum");
        icon=intent.getStringExtra("icon");
        tvCardno.setText(cardno);
        if(!StringUtils.isEmpty(weichat)){
            tvWeichat.setText(cardno);
        }else{
            tvWeichat.setText("未知");
        }
        if(!StringUtils.isEmpty(email)){
            tvEmail.setText(email);
        }else{
            tvEmail.setText("未知");
        }
        if(!StringUtils.isEmpty(icon)){
            Glide.with(this).load(icon).into(ivIcon);
        }

    }

    @Override
    protected BasePresenter onCreatePresenter() {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }
}
