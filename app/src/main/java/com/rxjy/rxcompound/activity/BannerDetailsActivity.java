package com.rxjy.rxcompound.activity;

import android.content.Intent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.base.BasePresenter;

/**
 * Created by hjh on 2017/11/13.
 */

public class BannerDetailsActivity extends BaseActivity{

    private WebView wb_rxsongs;
    private TextView tv_title;
    private ImageView iv_back;

    @Override
    public int getLayout() {
        return R.layout.activity_bannersetails;
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
        Intent intent=getIntent();
        String url=intent.getStringExtra("url");
        iv_back= (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        wb_rxsongs= (WebView) findViewById(R.id.wb_rxsongs);
        tv_title= (TextView) findViewById(R.id.tv_title);
        tv_title.setText("详情");
        wb_rxsongs= (WebView) findViewById(R.id.wb_rxsongs);
        wb_rxsongs.getSettings().setJavaScriptEnabled(true);
        wb_rxsongs.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String request) {
                return false;
            }
        });
        wb_rxsongs.loadUrl(url);
    }

}
