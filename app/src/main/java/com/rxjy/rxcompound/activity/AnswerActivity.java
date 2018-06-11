package com.rxjy.rxcompound.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.Constants;

/**
 * Created by hjh on 2017/11/16.
 */
public class AnswerActivity extends Activity{

    private WebView wb_rxsongs;
    private TextView tv_title;
    private ImageView iv_back;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxsongs);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    private void init(){
        Intent intent=getIntent();
        String coursewareInfoId=intent.getStringExtra("coursewareInfoId");
        String dayIndex=intent.getStringExtra("dayIndex");

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
        tv_title.setText("岗前答题");

        wb_rxsongs.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String request) {
                return false;
            }
        });
        wb_rxsongs.loadUrl(Constants.WEBURL_ANSWER + "cardno=" + cardno + "&coursewareInfoId=" + coursewareInfoId+"&dayIndex"+dayIndex);
    }

}
