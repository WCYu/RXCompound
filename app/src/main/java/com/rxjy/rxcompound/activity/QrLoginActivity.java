package com.example.asus.customer.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asus.customer.R;
import com.example.asus.customer.commons.App;
import com.example.asus.customer.commons.Constants;
import com.example.asus.customer.commons.base.BaseActivity;
import com.example.asus.customer.commons.utils.PrefUtils;
import com.example.asus.customer.entity.CheckInfo;
import com.example.asus.customer.mvp.contract.QrLoginContract;
import com.example.asus.customer.mvp.presenter.QrLoginPresenter;

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


        if (App.projectName.length() > 6) {
            String substring = App.projectName.substring(0, 6);
            String substring1 = App.projectName.substring(5, substring.length());
            qrRwdid.setText(substring);
            qrRwdidTwo.setText(substring1);
            qrRwdidTwo.setVisibility(View.VISIBLE);
        } else {
            qrRwdid.setText(App.projectName);
            qrRwdidTwo.setVisibility(View.INVISIBLE);
        }
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
            String appid=  getIntent().getStringExtra("appid");
                String pawwword = PrefUtils.getValue(QrLoginActivity.this, Constants.PASSWORD);
                Log.e("lrj",App.tokenInfo.getCardNo()+"======="+pawwword);
                mPresenter.getRrLogin(App.tokenInfo.getCardNo(), pawwword, appid);
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
            App.getApp().finishSingleActivity(NjjActivity.class);
            startActivity(new Intent(QrLoginActivity.this, NjjActivity.class));
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
