package com.rxjy.rxcompound.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.Constants;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.base.BasePresenter;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by hjh on 2017/11/22.
 */

public class MoreBannerActivity extends BaseActivity {
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.wb_rxsongs)
    WebView wbRxsongs;

    @Override
    public int getLayout() {
        return R.layout.activity_rxsongs;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public void initData() {
        tvTitle.setText("瑞祥装饰");
        wbRxsongs.getSettings().setJavaScriptEnabled(true);
        wbRxsongs.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        wbRxsongs.getSettings().setDomStorageEnabled(true);
        wbRxsongs.getSettings().setMediaPlaybackRequiresUserGesture(false);

        wbRxsongs.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String request) {
                return false;
            }
        });
        wbRxsongs.loadUrl(Constants.WEBURL_MOREBANNER);
    }

    @Override
    protected BasePresenter onCreatePresenter() {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }
}
