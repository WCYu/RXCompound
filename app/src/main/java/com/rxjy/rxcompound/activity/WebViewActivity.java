package com.rxjy.rxcompound.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.api.ApiEngine;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.base.BasePresenter;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WebViewActivity extends BaseActivity {

    @Bind(R.id.new_web)
    WebView newWeb;
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.iv_add)
    ImageView ivAdd;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.rl_tool)
    RelativeLayout rlTool;

    String url=null;
    String name=null;
    private String type;

    @Override
    public int getLayout() {
        return R.layout.activity_web_view;
    }

    @Override
    public void initData() {
        ButterKnife.bind(this);
        url = getIntent().getStringExtra("url");
        name = getIntent().getStringExtra("name");
        type = getIntent().getStringExtra("type");
        tvTitle.setText(name);
        if(name.equals("量房")||name.equals("量房")){
            rlTool.setBackgroundColor(getResources().getColor(R.color.textorange));
        }

        if(!TextUtils.isEmpty(type)){
            if(type.equals("顾问")){
                rlTool.setBackgroundColor(getResources().getColor(R.color.textorange));
            }
        }

        newWeb.loadUrl(url);
        Log.e("webView————————",url);

        WebSettings settings = newWeb.getSettings();
        settings.setJavaScriptEnabled(true);
        //设置自适应屏幕，两者合用
        settings.setUseWideViewPort(true); //将图片调整到适合webview的大小
        settings.setLoadWithOverviewMode(true); // 缩放至屏幕的大小
        settings.setDomStorageEnabled(true);
        newWeb.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return super.shouldOverrideUrlLoading(view, url);
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
