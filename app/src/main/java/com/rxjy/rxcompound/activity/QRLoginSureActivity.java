package com.rxjy.rxcompound.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.mvp.contract.QRLoginSureContract;
import com.rxjy.rxcompound.mvp.presenter.QRLoginSurePresenter;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by hjh on 2017/12/20.
 */
public class QRLoginSureActivity extends BaseActivity<QRLoginSurePresenter> implements QRLoginSureContract.View {

    @Bind(R.id.iv_icon)
    ImageView ivIcon;
    @Bind(R.id.tv_cardnum)
    TextView tvCardnum;

    @Override
    public int getLayout() {
        return R.layout.activity_qrloginsure;
    }

    String cardno, biaoshi;

    @Override
    public void initData() {
        SharedPreferences sp = getSharedPreferences("rxdy_userdatas", Activity.MODE_PRIVATE);
        cardno = sp.getString("rxdy_cardno", null);
        if (cardno != null) {
            tvCardnum.setText("卡号：" + cardno);
        }

        Intent intent = getIntent();
        biaoshi = intent.getStringExtra("sign");

    }

    @Override
    public void responseQRLoginSure() {
        Log.e("扫码登陆成功", "成功");
        showToast("扫码登陆成功！");
        finish();
    }

    @Override
    public void responseQRLoginSureError(String msg) {
        showToast("扫码登陆失败！");
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
    protected QRLoginSurePresenter onCreatePresenter() {
        return new QRLoginSurePresenter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.iv_back, R.id.tv_surelogin})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_surelogin:
                //登录啦
                Log.e("扫码登陆", "开始");
                mPresenter.getQRLoginSure(cardno, biaoshi);
                break;
        }
    }
}
