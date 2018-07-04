package com.rxjy.rxcompound.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.App;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.base.BasePresenter;

/**
 * Created by hjh on 2017/11/14.
 */

public class FindListActivity extends Activity{

    private WebView wb_rxsongs;
    private TextView tv_title;
    private ImageView iv_back;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bannersetails);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE|WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        init();
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    private void init(){
        Intent intent=getIntent();
        String url_id=intent.getStringExtra("id");
        String title=intent.getStringExtra("title");
        String type=intent.getStringExtra("type");
        String courseId = intent.getStringExtra("courseId");
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
        wb_rxsongs.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        wb_rxsongs.getSettings().setDomStorageEnabled(true);
        wb_rxsongs.getSettings().setMediaPlaybackRequiresUserGesture(false);
        wb_rxsongs.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String request) {
                return false;
            }
        });
        switch (type){
            case "0":
//                wb_rxsongs.loadUrl("http://news.rx/front/app_details.html?id="+url_id+"&cardNo="+ App.cardNo);
                wb_rxsongs.loadUrl("http://wpsnew.rxjy.com//front/app_details.html?id="+url_id+"&cardNo="+ App.cardNo+"&appId="+App.app_id+"&isAndroid=0");
//                Log.e("h5url","http://news.rx/front/app_details.html?id="+url_id+"&cardNo"+App.cardNo);
                break;
            case "1"://岗前答题
                wb_rxsongs.loadUrl("http://edu.rxjy.com/a/rs/curaInfo/"+App.cardNo+"/"+courseId+"/GetTryPostQues");
//                wb_rxsongs.loadUrl("http://news.rx//front/app_video.html");
                break;
            case "2"://日常培训
//                wb_rxsongs.loadUrl("http://news.rx//front/app_video.html");
                wb_rxsongs.loadUrl("http://edu.rxjy.com/a/rs/cour/"+App.cardNo+"/GetTrainCurr");
                break;
            case "3":
                wb_rxsongs.loadUrl("http://wpsnew.rxjy.com//front/app_details.html?id="+url_id+"&cardNo="+ App.cardNo+"&appId="+App.app_id+"&isAndroid=0");
        }
//        wb_rxsongs.loadUrl("http://news.rx/front/app_details.html?id="+url_id+"&cardNo"+ App.cardNo);
//        Log.e("h5url","http://news.rx/front/app_details.html?id="+url_id+"&cardNo"+App.cardNo);
////        wb_rxsongs.loadUrl("http://news.rx/front/app_details.html?id="+url_id);
    }

}