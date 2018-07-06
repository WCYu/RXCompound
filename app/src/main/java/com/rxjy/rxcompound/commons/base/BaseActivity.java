package com.rxjy.rxcompound.commons.base;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.entity.LocalMedia;
import com.rxjy.rxcompound.R;
import com.rxjy.rxcompound.activity.WpsImage2Activity;
import com.rxjy.rxcompound.activity.WpsImageActivity;
import com.rxjy.rxcompound.commons.App;
import com.rxjy.rxcompound.commons.Constants;
import com.rxjy.rxcompound.commons.utils.AutoUtils;
import com.rxjy.rxcompound.utils.ToastUtil;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {

    public App application;

    public Handler mHandler;

    public Toast toast;

    protected P mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);//隐藏标题栏
//        //取消标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //取消状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //沉浸式状态栏
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            // 透明状态栏
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//        }

        //初始化布局，并且适配
        View view = View.inflate(this, getLayout(), null);
        AutoUtils.setSize(this, false, 720, 1280);
        AutoUtils.auto(view);
        setContentView(view);
        //禁止横屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //禁止键盘挤压布局
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        //绑定插件
        ButterKnife.bind(this);
        mHandler = new myhandle(this);
        application = App.getApp();
        toast = new Toast(this);
        if (onCreatePresenter() != null) {
            mPresenter = onCreatePresenter();
        }
        App.baseActivity = this;
        App.getApp().addActivity(this);
        initData();
        App.context = this;
    }

    //加载布局
    public abstract int getLayout();

    //加载数据
    public abstract void initData();


    public static class myhandle extends Handler {
        //使用弱引用防止内存泄漏
        WeakReference<BaseActivity> activityWeakReference;

        public myhandle(BaseActivity activityWeakReference) {
            this.activityWeakReference = new WeakReference<BaseActivity>(activityWeakReference);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (activityWeakReference.get() != null) {
                activityWeakReference.get().handlerMeaasg(msg);
            }
        }
    }

    //子类可以同时重写这个方法实现Handler传输
    public void handlerMeaasg(Message msg) {

    }

    // 内存紧张时回收图片资源
    @Override
    public void onLowMemory() {
        super.onLowMemory();
        Glide.get(this).clearMemory();
    }

    // 内存紧张时回收图片资源 API4.0
    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        Glide.get(this).trimMemory(level);
    }

    //Acitiy销毁时反注册插件,并且移除活动
    @Override
    protected void onDestroy() {
        application.removeActivity(this);
        ButterKnife.unbind(this);
        if (mPresenter != null) {
            mPresenter.unSubscribe();
        }
        super.onDestroy();
    }

    public void showToast(String msg) {
        if (toast != null) {
            toast.cancel();
        }
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    private ProgressDialog dialog;

    public void showLoading() {
        if (dialog != null && dialog.isShowing()) return;
        dialog = new ProgressDialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setMessage(getString(R.string.loading));
        dialog.show();
    }

    public void dismissLoading() {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }

    public void setProgressDialog(final long l) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(l);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if(dialog!=null && dialog.isShowing()){
                            dialog.dismiss();
                            ToastUtil.getInstance().toastCentent("当前网络较差",BaseActivity.this);
                        }
                    }
                });
            }
        }).start();
    }

    //输入框下划线效果
    public void lineSelector(EditText[] etArray, final TextView[] tvArray) {
        for (int i = 0; i < etArray.length; i++) {
            final int position = i;
            etArray[i].setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if (hasFocus) {
                        //此处为得到焦点时
                        tvArray[position].setEnabled(true);
                    } else {
                        //此处为失去焦点时
                        tvArray[position].setEnabled(false);
                    }
                }
            });
        }
    }

    //查看大图
    public void watchLargerImage(String baseurl, List<String> imgList, int position) {

        //imgList.clear();
        Intent intent = new Intent(this, WpsImageActivity.class);
        intent.putExtra("BaseUrl",baseurl);
        intent.putStringArrayListExtra(Constants.IMAGE_URL_LIST, (ArrayList<String>) imgList);
        intent.putExtra("camera_position",position);
        startActivity(intent);
    }

    public void watchLargerImage2(String baseurl, List<String> imgList, int position) {

        //imgList.clear();
        Intent intent = new Intent(this, WpsImage2Activity.class);
        intent.putExtra("BaseUrl",baseurl);
        intent.putStringArrayListExtra(Constants.IMAGE_URL_LIST, (ArrayList<String>) imgList);
        intent.putExtra("camera_position",position);
        Log.e("imglist",imgList.size()+"");
        startActivity(intent);
    }

    /**
     * 照片预览
     */
    public void photoPreview(String url) {
        com.luck.picture.lib.entity.LocalMedia localMedia = new com.luck.picture.lib.entity.LocalMedia();
        localMedia.setPath(url);
        List<LocalMedia> list = new ArrayList<>();
        list.add(localMedia);
        PictureSelector.create(this).externalPicturePreview(0, list);
    }

    protected abstract P onCreatePresenter();

}