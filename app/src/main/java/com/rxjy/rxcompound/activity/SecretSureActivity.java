package com.rxjy.rxcompound.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.Constants;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.utils.ShowUtils;
import com.rxjy.rxcompound.entity.CheckIsBeingBean;
import com.rxjy.rxcompound.entity.ResultBean;
import com.rxjy.rxcompound.mvp.contract.EntryJobPContract;
import com.rxjy.rxcompound.mvp.presenter.EntryJobPresenter;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/11/17.
 */

public class SecretSureActivity extends BaseActivity<EntryJobPresenter> implements EntryJobPContract.View {


    @Bind(R.id.cb_entrybox)
    CheckBox cb_entrybox;
    @Bind(R.id.wb_entryjobview)
    WebView wb_entryjobview;
    @Bind(R.id.tv_sure)
    TextView tv_sure;
    @Bind(R.id.tv_title)
    TextView tv_title;
    @Bind(R.id.ic_back)
    ImageView ic_back;

    String phonenum,cardno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @Override
    public void responseConsent(CheckIsBeingBean data) {
        startActivity(new Intent(this, ZThreeActivity.class));
        finish();
    }

    @Override
    public void responseConsentError(String msg) {
        ShowUtils.Toastshort(this,msg);

    }

    @Override
    public void responseEntryJob(CheckIsBeingBean data) {
    }

    @Override
    public void responseEntryJobError(String msg) {
        ShowUtils.Toastshort(this,msg);
    }

    @Override
    public void responseIsConsent(ResultBean data) {

    }

    @Override
    public void responseIsConsentError(String msg) {

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
    public int getLayout() {
        return R.layout.activity_entryjobp;
    }

    @Override
    public void initData() {
        tv_title.setText("保密协议");
        tv_sure.setBackgroundColor(getResources().getColor(R.color.textgreytwo));
        tv_sure.setEnabled(false);//设置不可点击
        SharedPreferences sp = getSharedPreferences("rxdy_userdatas", Activity.MODE_PRIVATE);
        phonenum = sp.getString("rxdy_phonenum", null);
        cardno = sp.getString("rxdy_cardno", null);
        ShowWebView();
        cb_entrybox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){//选中
                    tv_sure.setBackgroundColor(getResources().getColor(R.color.colorred));
                    tv_sure.setEnabled(true);//设置可点击
                }else{
                    tv_sure.setBackgroundColor(getResources().getColor(R.color.textgreytwo));
                    tv_sure.setEnabled(false);//设置不可点击
                }
            }
        });
    }

    /**
     * 显示入职需知
     */
    private void ShowWebView() {
        wb_entryjobview.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String request) {
                return false;
            }
        });
        wb_entryjobview.loadUrl(Constants.WEBURL_ENTRYJOB + "CardNo=" + cardno + "&Type=" + "3");
    }

    @OnClick({R.id.tv_sure,R.id.ic_back})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_sure://同意协议
                mPresenter.getConsent(cardno,"3");
                break;
            case R.id.ic_back:
                finish();
                break;
        }
    }


    @Override
    protected EntryJobPresenter onCreatePresenter() {
        return new EntryJobPresenter(this);
    }
}
