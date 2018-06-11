package com.rxjy.rxcompound.activity;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.commons.base.BaseActivity;
import com.rxjy.rxcompound.commons.base.BasePresenter;

import java.io.File;

/**
 * Created by hjh on 2018/4/8.
 */

public class OfficeWebViewActivity extends BaseActivity {

    private WebView wb_office;
    private TextView tv_title;
    private ImageView iv_back;
    String TAG = "1111";

    @Override
    public int getLayout() {
        return R.layout.activity_officeh5;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public void initData() {
        init();
    }


    @Override
    protected BasePresenter onCreatePresenter() {
        return null;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    private void init() {
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String url = intent.getStringExtra("url");

        iv_back = (ImageView) findViewById(R.id.iv_back);
        wb_office = (WebView) findViewById(R.id.wb_office);
        tv_title = (TextView) findViewById(R.id.tv_title);
//        iv_back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                finish();
//            }
//        });
        tv_title.setText(title);
        wb_office.getSettings().setJavaScriptEnabled(true);
        wb_office.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        wb_office.getSettings().setDomStorageEnabled(true);
        wb_office.getSettings().setMediaPlaybackRequiresUserGesture(false);
        wb_office.getSettings().setAllowFileAccess(true);
        wb_office.getSettings().setSupportZoom(true);
        wb_office.getSettings().setBuiltInZoomControls(true);
        wb_office.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        wb_office.getSettings().setDatabaseEnabled(true);
        wb_office.getSettings().setUseWideViewPort(true);
        wb_office.getSettings().setLoadWithOverviewMode(true);
        wb_office.requestFocus();
        wb_office.setWebViewClient(new WebViewClient());
        wb_office.setWebChromeClient(new ArcWebChromeClient());
        wb_office.loadUrl(url);
    }

    private ValueCallback mUploadMessage;

    public void openFileChooserImpl(ValueCallback uploadMsg) {
        mUploadMessage = uploadMsg;
        Intent i = new Intent(Intent.ACTION_GET_CONTENT);
        i.addCategory(Intent.CATEGORY_OPENABLE);
        i.setType("image/*");
        startActivityForResult(Intent.createChooser(i, "File Chooser"), 0);
    }

    //onActivityResult回调
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0) {
            if (null == mUploadMessage)
                return;
            Uri result = data == null || resultCode != RESULT_OK ? null : data.getData();
            if (mUploadMessage != null) {
                mUploadMessage.onReceiveValue(result);
                mUploadMessage = null;
            }
        }
        if (requestCode == 1) {
            if (mUploadCallbackAboveL == null) {
                return;
            }
            Uri result = (data == null || resultCode != RESULT_OK) ? null : data.getData();
            if (result != null) {
                mUploadCallbackAboveL.onReceiveValue(new Uri[]{result});
            } else {
                mUploadCallbackAboveL.onReceiveValue(new Uri[]{});
            }
            mUploadCallbackAboveL = null;
        }
    }

    private ValueCallback mUploadCallbackAboveL;

    public void setUploadMsg(ValueCallback uploadMsg) {
        mUploadCallbackAboveL = uploadMsg;
    }

    @SuppressLint("NewApi")
    private void onActivityResultAboveL(int requestCode, int resultCode, Intent data) {
        if (requestCode != 0
                || mUploadCallbackAboveL == null) {
            return;
        }
        Uri[] results = null;
        if (resultCode == Activity.RESULT_OK) {
            if (data == null) {
            } else {
                String dataString = data.getDataString();
                ClipData clipData = data.getClipData();
                if (clipData != null) {
                    results = new Uri[clipData.getItemCount()];
                    for (int i = 0; i < clipData.getItemCount(); i++) {
                        ClipData.Item item = clipData.getItemAt(i);
                        results[i] = item.getUri();
                    }
                }
                if (dataString != null)
                    results = new Uri[]{Uri.parse(dataString)};
            }
        }
        mUploadCallbackAboveL.onReceiveValue(results);
        mUploadCallbackAboveL = null;
        return;
    }

    public class ArcWebChromeClient extends WebChromeClient {

        public void openFileChooser(ValueCallback uploadMsg) {
            openFileChooserImpl(uploadMsg);
        }

        public void openFileChooser(ValueCallback uploadMsg, String acceptType) {
            openFileChooserImpl(uploadMsg);
        }

        public void openFileChooser(ValueCallback uploadMsg, String acceptType, String capture) {
            openFileChooserImpl(uploadMsg);
        }

        // For Android 5.0+
        @Override
        public boolean onShowFileChooser(WebView webView, ValueCallback uploadMsg, WebChromeClient.FileChooserParams fileChooserParams) {
//               mUploadCallbackAboveL = uploadMsg;
//               Intent i = newframe Intent(Intent.ACTION_GET_CONTENT);
//               i.addCategory(Intent.CATEGORY_OPENABLE);
//               i.setType("image/*");
//               startActivityForResult(
//                          Intent.createChooser(i, "File Browser"), 0);
//               return true;
//          mUploadCallbackAboveL = uploadMsg;
            setUploadMsg(uploadMsg);
            Intent contentSelectionIntent = new Intent(Intent.ACTION_GET_CONTENT);
            contentSelectionIntent.addCategory(Intent.CATEGORY_OPENABLE);
            contentSelectionIntent.setType("image/*");

            Intent chooserIntent = new Intent(Intent.ACTION_CHOOSER);
            chooserIntent.putExtra(Intent.EXTRA_INTENT, contentSelectionIntent);
            chooserIntent.putExtra(Intent.EXTRA_TITLE, "Image Chooser");

            startActivityForResult(chooserIntent, 1);
            return true;

        }
    }

}
