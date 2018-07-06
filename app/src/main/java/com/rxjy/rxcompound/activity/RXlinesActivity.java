package com.rxjy.rxcompound.activity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.Constants;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.base.BasePresenter;

/**
 * Created by hjh on 2017/11/10.
 */

public class RXlinesActivity extends BaseActivity{
    private WebView wb_rxsongs;
    private TextView tv_title;
    private ImageView iv_back;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_rxsongs;
    }

    @Override
    public void initData() {
        init();

    }

    @Override
    protected BasePresenter onCreatePresenter() {
        return null;
    }

    private void init(){
        iv_back= (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        SharedPreferences sp = getSharedPreferences("rxdy_userdatas", Activity.MODE_PRIVATE);
        String phonenum = sp.getString("rxdy_phonenum", null);
        String cardno = sp.getString("rxdy_cardno", null);
        wb_rxsongs= (WebView) findViewById(R.id.wb_rxsongs);
        tv_title= (TextView) findViewById(R.id.tv_title);
        tv_title.setText("瑞祥准则");
        wb_rxsongs.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String request) {
                return false;
            }
        });
        wb_rxsongs.loadUrl(Constants.WEBURL_ENTRYJOB + "CardNo=" + cardno + "&Type=" + "4");

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        wb_rxsongs.resumeTimers();
        wb_rxsongs.destroy();
    }
}
