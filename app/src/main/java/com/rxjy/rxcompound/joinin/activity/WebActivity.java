package com.rxjy.rxcompound.joinin.activity;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.App;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.base.BasePresenter;

/**
 * Created by asus on 2018/5/31.
 */

public class WebActivity extends BaseActivity {
    private WebView wb_rxsongs;
    private TextView tv_title;
    private ImageView iv_back;

    @Override
    public int getLayout() {
        return R.layout.activity_bannersetails;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public void initData() {
        Intent intent=getIntent();
        String url_id=intent.getStringExtra("id");
        iv_back= (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        wb_rxsongs= (WebView) findViewById(R.id.wb_rxsongs);
        wb_rxsongs.getSettings().setJavaScriptEnabled(true);
        wb_rxsongs.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        wb_rxsongs.getSettings().setDomStorageEnabled(true);
        wb_rxsongs.getSettings().setMediaPlaybackRequiresUserGesture(false);
        wb_rxsongs.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String request) {
                return false;
            }
        });
        wb_rxsongs.loadUrl("http://j.rxjy.com/Mobile/News/Index?id="+url_id+"&cardno="+ App.cardNo);
    }

    @Override
    protected BasePresenter onCreatePresenter() {
        return null;
    }
}
