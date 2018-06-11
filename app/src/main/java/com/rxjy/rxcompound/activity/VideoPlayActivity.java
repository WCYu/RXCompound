package com.rxjy.rxcompound.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.utils.StringUtils;

import butterknife.ButterKnife;

/**
 * Created by hjh on 2017/11/16.
 */

public class VideoPlayActivity extends BaseActivity{

    private FrameLayout video_fullView;
    private WebView wb_rxsongs;
    private TextView tv_title;
    private ImageView iv_back;

    private View xCustomView;
    private WebChromeClient.CustomViewCallback xCustomViewCallback;
    private myWebChromeClient xwebchromeclient;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_rxsongs;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public void initData() {
        init();

    }

    String loadurl="";//要加载的url
    String getids;//得到的id
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    private void init(){

        iv_back= (ImageView) findViewById(R.id.iv_back);
        video_fullView= (FrameLayout) findViewById(R.id.video_fullView);
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Intent intent=getIntent();
        getids=intent.getStringExtra("id");

        wb_rxsongs= (WebView) findViewById(R.id.wb_rxsongs);
        tv_title= (TextView) findViewById(R.id.tv_title);
        tv_title.setText("视频");

        int pxWidth = getWindowManager().getDefaultDisplay().getWidth();



//        String videoUrl = "<div id=\"youkuplayer\" style=\"width:" + pxWidth + "px;height:" + pxWidth +
//                "px\"></div><script type=\"text/javascript\" " +
//                "src=\"http://player.youku.com/jsapi\">player " +
//                "= new YKU.Player('youkuplayer',{styleid: '0',client_id: " +
//                "'YOUR YOUKUOPENAPI CLIENT_ID',vid: 'XMTQ3NDg3OTUwMA=='});</script>";




        WebSettings ws = wb_rxsongs.getSettings();
        ws.setJavaScriptEnabled(true);
        ws.setJavaScriptCanOpenWindowsAutomatically(true);
        ws.setDomStorageEnabled(true);
        ws.setMediaPlaybackRequiresUserGesture(false);
        ws.setUseWideViewPort(true);
        ws.setLoadWithOverviewMode(true);
        ws.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);//适应屏幕
        //隐藏缩放按钮
        ws.setBuiltInZoomControls(false);
        //可以任意比例缩放
        ws.setUseWideViewPort(true);
        //setUseWideViewPort方法设置webview推荐使用的窗口。setLoadWithOverviewMode方法是设置webview加载的页面的模式。 
        //设置支持JS
        ws.setJavaScriptEnabled(true);
        ws.setSupportMultipleWindows(true);// 新加  
        ws.setLoadWithOverviewMode(false);//<==== 一定要设置为false，不然有声音没图像
        xwebchromeclient = new myWebChromeClient();
        wb_rxsongs.setHorizontalScrollBarEnabled(false);
        wb_rxsongs.setWebChromeClient(xwebchromeclient);
        wb_rxsongs.setWebViewClient(new myWebViewClient());
        wb_rxsongs.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return (event.getAction() == MotionEvent.ACTION_MOVE);
            }
        });

        if(!StringUtils.isEmpty(getids)){//优酷视频
            loadurl="<div id=\"youkuplayer\" style=\"width:" + 350 + "px;height:" + 350 +
                    "px\"></div> <script type=\"text/javascript\" src=\"http://player.youku.com/jsapi\"> " +
                    "player = new YKU.Player('youkuplayer',{ styleid: '0', client_id: 'b1b8d127374e42ee', vid: '"+getids+"',autoplay: true}); </script>";
            wb_rxsongs.loadData(loadurl,"text/html", "utf-8");
        }else{//爱奇艺视频
            loadurl="<iframe src=\"http://open.iqiyi.com/developer/player_js/coopPlayerIndex.html?vid=225b404782d158d2f44e749bdf77f887&tvId=9734981809&accessToken=2.f22860a2479ad60d8da7697274de9346&appKey=3955c3425820435e86d0f4cdfe56f5e7&appId=1368&height=100%&width=100%\" frameborder=\"0\" allowfullscreen=\"true\" width=\"350px\" height=\"350px\"></iframe>";
            wb_rxsongs.loadData(loadurl,"text/html", "utf-8");
        }

    }

    public class myWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return false;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
        }
    }



    public class myWebChromeClient extends WebChromeClient {
        private View xprogressvideo;

        // 播放网络视频时全屏会被调用的方法  
        @Override
        public void onShowCustomView(View view, CustomViewCallback callback) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            wb_rxsongs.setVisibility(View.INVISIBLE);
            // 如果一个视图已经存在，那么立刻终止并新建一个  
            if (xCustomView != null) {
                callback.onCustomViewHidden();
                return;
            }
            video_fullView.addView(view);
            xCustomView = view;
            xCustomViewCallback = callback;
            video_fullView.setVisibility(View.VISIBLE);
        }

        // 视频播放退出全屏会被调用的  
        @Override
        public void onHideCustomView() {
            if (xCustomView == null)// 不是全屏播放状态  
                return;

            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            xCustomView.setVisibility(View.GONE);
            video_fullView.removeView(xCustomView);
            xCustomView = null;
            video_fullView.setVisibility(View.GONE);
            xCustomViewCallback.onCustomViewHidden();
            wb_rxsongs.setVisibility(View.VISIBLE);
        }

        // 视频加载时进程loading  
        @Override
        public View getVideoLoadingProgressView() {
            if (xprogressvideo == null) {
                LayoutInflater inflater = LayoutInflater
                        .from(VideoPlayActivity.this);
                xprogressvideo = inflater.inflate(
                        R.layout.video_loading_progress, null);
            }
            return xprogressvideo;
        }
    }

    /**
     *  
     * * 判断是否是全屏 
     * *  
     * * @return 
     *      
     */
    public boolean inCustomView() {
        return (xCustomView != null);
    }

    /**
     *  
     * * 全屏时按返加键执行退出全屏方法 
     *      
     */
    public void hideCustomView() {
        xwebchromeclient.onHideCustomView();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    @Override
    protected void onResume() {
        super.onResume();
        wb_rxsongs.onResume();
        wb_rxsongs.resumeTimers();

        /** 
         * 设置为横屏 
         */
        if (getRequestedOrientation() != ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        wb_rxsongs.onPause();
        wb_rxsongs.pauseTimers();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected BasePresenter onCreatePresenter() {
        return null;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (inCustomView()) {
                // webViewDetails.loadUrl("about:blank");  
                hideCustomView();
                return true;
            } else {
                wb_rxsongs.loadUrl("about:blank");
                finish();
            }
        }
        return false;
    }


}
