package com.rxjy.rxcompound.des.activity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.App;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.base.BasePresenter;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by asus on 2018/5/25.
 */

public class WebActivity extends BaseActivity {
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_right)
    TextView tvRight;
    @Bind(R.id.webview)
    WebView webview;

    @Override
    public int getLayout() {
        return R.layout.web_activity;
    }

    @Override
    public void initData() {
        tvTitle.setText("详情");
        //http://j.rxjy.com/Mobile/News/Index?id=1&cardno=01011166
        Intent intent = getIntent();
        int id = intent.getIntExtra("id", 1);
        webview.loadUrl("http://j.rxjy.com/Mobile/News/Index?id="+id+"&cardno="+ App.cardNo);
        WebSettings wSet = webview.getSettings();
        wSet.setJavaScriptEnabled(true);
        wSet.setUseWideViewPort(true);
        wSet.setLoadWithOverviewMode(true);
        webview.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) { //  重写此方法表明点击网页里面的链接还是在当前的webview里跳转，不跳到浏览器那边
                view.loadUrl(url);
                return true;
            }
        });
    }

    @Override
    protected BasePresenter onCreatePresenter() {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }
}
