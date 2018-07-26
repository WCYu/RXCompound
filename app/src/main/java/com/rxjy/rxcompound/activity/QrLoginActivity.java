package com.rxjy.rxcompound.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.App;
import com.rxjy.rxcompound.commons.Constants;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.entity.CheckInfo;
import com.rxjy.rxcompound.mvp.contract.QrLoginContract;
import com.rxjy.rxcompound.mvp.presenter.QrLoginPresenter;
import com.rxjy.rxcompound.utils.GlideCircleTransform;
import com.rxjy.rxcompound.utils.ToastUtil;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by asus on 2018/5/30.
 */

public class QrLoginActivity extends BaseActivity<QrLoginPresenter> implements QrLoginContract.View {

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.qr_photo)
    ImageView qrPhoto;
    @Bind(R.id.qr_login)
    TextView qrLogin;
    @Bind(R.id.qrRwdid)
    TextView qrRwdid;
    @Bind(R.id.qrRwdid_two)
    TextView qrRwdidTwo;
    @Bind(R.id.cancel_text)
    TextView cancelText;
    private String appid;
    private String cardNo;

    @Override
    public int getLayout() {
        return R.layout.activity_sc_login;
    }

    @Override
    public void initData() {


        qrRwdid.setText(App.name);
        RequestOptions options = new RequestOptions();
        options.centerCrop().transform(new GlideCircleTransform(this));
        options.error(R.mipmap.userimage);
        options.placeholder(R.mipmap.userimage);
        options.centerCrop().transform(new GlideCircleTransform(this));
        Glide.with(this).load(App.icon).apply(options).into(qrPhoto);
        tvTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected QrLoginPresenter onCreatePresenter() {
        return new QrLoginPresenter(this);
    }

    @OnClick({R.id.qr_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.qr_login:
                Log.e("扫码登陆", "开始");
                String appid = getIntent().getStringExtra("appid");
                SharedPreferences msp = getSharedPreferences("rxdy_userdatas", Activity.MODE_PRIVATE);
                String rxdy_pwd = msp.getString("rxdy_pwd", "");
                Log.e("lrj", App.cardNo + "=======" + rxdy_pwd);
                mPresenter.getRrLogin(App.cardNo, rxdy_pwd, appid);
                break;
        }
    }

    @Override
    public void showDialog() {
        showLoading();
    }

    @Override
    public void hideDialog() {
        dismissLoading();
    }

    @Override
    public void showMessage(String message) {
        showToast(message);
    }

    @Override
    public void getRrLoginData(CheckInfo checkInfo) {
        if (checkInfo.getStatusCode() == 0) {
            ToastUtil.getInstance().toastCentent("登陆成功");
            finish();
        } else {
            showToast(checkInfo.getStatusMsg());
        }
    }

    @OnClick(R.id.cancel_text)
    public void onViewClicked() {
        finish();
    }
}
