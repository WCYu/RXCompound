package com.rxjy.rxcompound.commons.utils;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.support.v4.content.FileProvider;
import android.util.Log;


import com.rxjy.rxcompound.commons.App;
import com.rxjy.rxcompound.entity.VersionInfo;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by AAA on 2017/8/9.
 */

public class DownLoadApk {

    public Context context;

    public DownLoadApk(Context context) {
        this.context = context;
    }

    /*
     * 从服务器中下载APK
	 */
    public void downLoadApk(final VersionInfo.Version versionInfo) {
        Log.e("tag_开始下载", "");
        final ProgressDialog pd;    //进度条对话框
        pd = new ProgressDialog(context);
        pd.setCancelable(false);// 设置点击屏幕Dialog不消失
        pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        pd.setMessage("正在下载更新");
        pd.show();
        new Thread() {
            @Override
            public void run() {
                try {
                    Log.e("tag_开始下载", "正常下载");
                    File file = getFileFromServer(versionInfo.getVersionUrl(), pd);
                    //安装APk
                    installApk(file, context);
                    pd.dismiss(); //结束掉进度条对话框
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.e("tag_开始下载", "下载失败" + e);
                }
            }
        }.start();
        Log.e("tag_开始下载", "下载结束");
    }

    /**
     * 下载方法
     *
     * @param path
     * @param pd
     * @return
     * @throws Exception
     */

    public File getFileFromServer(String path, ProgressDialog pd)
            throws Exception {
        // 如果相等的话表示当前的sdcard挂载在手机上并且是可用的
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            URL url = new URL(path);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            // 获取到文件的大小
            pd.setMax(conn.getContentLength());
            InputStream is = conn.getInputStream();
            File file = new File(Environment.getExternalStorageDirectory(),
                    "gc.apk");
            FileOutputStream fos = new FileOutputStream(file);
            BufferedInputStream bis = new BufferedInputStream(is);
            byte[] buffer = new byte[1024];
            int len;
            int total = 0;
            while ((len = bis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
                total += len;
                // 获取当前下载量
                pd.setProgress(total);
            }
            fos.close();
            bis.close();
            is.close();
            return file;
        } else {
            return null;
        }
    }

    /**
     * 安装Apk
     *
     * @param file
     * @param context
     */
    public void installApk(File file, Context context) {
        //判断是否在Android7.0以上
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        if (Build.VERSION.SDK_INT >= 24) {
            //参数1 上下文, 参数2  和配Provider主机地址置文件中保持一致   参数3  共享的文件
            Uri apkUri = FileProvider.getUriForFile(context, "com.rxjy.rxcompound.provider", file);
            //添加这一句表示对目标应用临时授权该Uri所代表的文件
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            intent.setDataAndType(apkUri, "application/vnd.android.package-archive");
        } else {
            intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
        }
        context.startActivity(intent);
    }

}
