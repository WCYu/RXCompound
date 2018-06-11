package com.rxjy.rxcompound.commons.utils;

import android.webkit.WebChromeClient;

/**
 * Created by hjh on 2018/4/12.
 */

public class ArcWebChromeClient extends WebChromeClient {
//
//    public void openFileChooser(ValueCallback uploadMsg) {
//        ((OfficeWebViewActivity) mContext).openFileChooserImpl(uploadMsg);
//    }
//    public void openFileChooser(ValueCallback uploadMsg, String acceptType ) {
//        ((OfficeWebViewActivity) mContext).openFileChooserImpl(uploadMsg);
//    }
//    public void openFileChooser(ValueCallback uploadMsg, String acceptType, String capture){
//        ((OfficeWebViewActivity) mContext).openFileChooserImpl(uploadMsg);
//    }
//    // For Android 5.0+
//    public boolean onShowFileChooser (WebView webView, ValueCallback uploadMsg, WebChromeClient.FileChooserParams fileChooserParams) {
////               mUploadCallbackAboveL = uploadMsg;
////               Intent i = newframe Intent(Intent.ACTION_GET_CONTENT);
////               i.addCategory(Intent.CATEGORY_OPENABLE);
////               i.setType("image/*");
////               startActivityForResult(
////                          Intent.createChooser(i, "File Browser"), 0);
////               return true;
////          mUploadCallbackAboveL = uploadMsg;
//        ((OfficeWebViewActivity) mContext).setUploadMsg(uploadMsg);
//        Intent contentSelectionIntent = new Intent(Intent.ACTION_GET_CONTENT);
//        contentSelectionIntent.addCategory(Intent.CATEGORY_OPENABLE);
//        contentSelectionIntent.setType("image/*");
//
//        Intent chooserIntent = new Intent(Intent.ACTION_CHOOSER);
//        chooserIntent.putExtra(Intent.EXTRA_INTENT, contentSelectionIntent);
//        chooserIntent.putExtra(Intent.EXTRA_TITLE, "Image Chooser");
//
//        ((OfficeWebViewActivity) mContext).startActivityForResult(chooserIntent, 1);
//        return true;
//    }
}/**-------------------------------处理webview调用本地文件浏览-------------------------------------*/
