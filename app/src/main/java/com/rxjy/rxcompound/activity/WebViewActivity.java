package com.rxjy.rxcompound.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.base.BasePresenter;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WebViewActivity extends BaseActivity {

    @Bind(R.id.web_dianpu)
    WebView webDianpu;
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.iv_add)
    ImageView ivAdd;
    @Bind(R.id.tv_title)
    TextView tvTitle;

    String url=null;
    String name=null;
    @Override
    public int getLayout() {
        return R.layout.activity_web_view;
    }

    @Override
    public void initData() {
        ButterKnife.bind(this);
        url = getIntent().getStringExtra("url");
        name = getIntent().getStringExtra("name");
        tvTitle.setText(name);
        webDianpu.loadUrl(url);
        webDianpu.getSettings().setJavaScriptEnabled(true);
        // 为图片添加放大缩小功能
        webDianpu.getSettings().setUseWideViewPort(true);
        webDianpu.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(url);
                return super.shouldOverrideUrlLoading(view, request);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
//        webDianpu.destroy();
    }

    @Override
    protected BasePresenter onCreatePresenter() {
        return null;
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }

}